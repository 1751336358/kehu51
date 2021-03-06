package com.stx.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stx.dao.EmployDao;
import com.stx.dao.MessageDao;
import com.stx.pojo.Employ;
import com.stx.pojo.User;
import com.stx.pojo.Work;
import com.stx.pojo.WorkMessage;
import com.stx.service.MessageService;
import com.stx.thread.MessageSendThread;
import com.stx.utils.MessageReceive;
import com.stx.utils.MessageSerializable;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service("messageServices")
public class MassageServiceImpl implements MessageService{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 员工申请补卡
	 * 2018-02-14
	 * @throws Exception 
	 */
	@Override
	public boolean appealBuka(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		String bukaTime = request.getParameter("bukaTime");
		String content = request.getParameter("content");
		String radio = request.getParameter("radio");
		
		WorkMessage workMessage = new WorkMessage();
		workMessage.setContent(content);	//消息内容
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String date = simpleDateFormat.format(new Date());	//消息产生的时间
		workMessage.setTime(date);
		User u = (User)session.getAttribute("user");
		workMessage.setType("补卡消息");
		workMessage.setSource_id(u.getId());
		workMessage.setSource_queue(u.getUsername());
		Employ employ = employDao.getManagerInfoByEmployId(u.getId());
		workMessage.setDistince_id(employ.getId());
		workMessage.setDistince_queue(employ.getUsername());
		//以下 的是消息的附加属性
		Map<String,String> map = workMessage.getContentMap();
		if("1".equals(radio)){
			map.put("补卡签到", bukaTime);
			//拼接一个url，用于经理处理不卡签到消息，为了通用，格式要严格要求这样写以保持一致
			map.put("同意补卡签到","<a href='"+request.getContextPath()+"/aggreeLogin?aggreeLogin=1&employ_id="+u.getId()+"&employ_name="+u.getUsername()+"&manager_id="+employ.getId()+"&manager_name="+employ.getUsername()+"&bukaTime="+bukaTime+"' onclick=dealUrl()>同意补卡签到</a>");
			map.put("不同意补卡签到", "<a href='"+request.getContextPath()+"/aggreeLogin?aggreeLogin=0&employ_id="+u.getId()+"&employ_name="+u.getUsername()+"&manager_id="+employ.getId()+"&manager_name="+employ.getUsername()+"&bukaTime="+bukaTime+"' onclick=dealUrl()>不同意补卡签到</a>");
		}else if("2".equals(radio)){
			map.put("补卡签退", bukaTime);
			map.put("同意补卡签退", "<a href='"+request.getContextPath()+"/aggreeLogout?aggreeLogout=1&employ_id="+u.getId()+"&employ_name="+u.getUsername()+"&manager_id="+employ.getId()+"&manager_name="+employ.getUsername()+"&bukaTime="+bukaTime+"' onclick=dealUrl()>同意补卡签退</a>");
			map.put("不同意补卡签到退", "<a href='"+request.getContextPath()+"/aggreeLogout?aggreeLogout=0&employ_id="+u.getId()+"&employ_name="+u.getUsername()+"&manager_id="+employ.getId()+"&manager_name="+employ.getUsername()+"&bukaTime="+bukaTime+"' onclick=dealUrl()>不同意补卡签退</a>");
		}
		workMessage.setContentMap(map);
		
		//发送消息
		Jedis jedis = null;
		try{
		//	MessageSend.sendMessage(workMessage, employ.getId(),employ.getUsername());
			executorService.execute(new MessageSendThread(workMessage, employ.getId(), employ.getUsername()));
			//将消息保存为已发消息存入redis[2]
		//	Jedis jedis = (Jedis)request.getServletContext().getAttribute("jedis");
			JedisPool pool = (JedisPool)request.getServletContext().getAttribute("jedisPool");
			jedis = pool.getResource();
			messageDao.newMsg2HasSendMsg(jedis, u.getId(), u.getUsername(), workMessage);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
		System.out.println("消息发送成功");		
		return true;
	}
	
	/**
	 * 最新消息
	 * 2018-02-15
	 */
	public List<WorkMessage> queryNewMessage(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		int id = u.getId();
		String username = u.getUsername();
		List<WorkMessage> messageList = null;
		try{
			messageList = MessageReceive.recieve(id,username);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		if(messageList == null){
			System.out.println("消息为空");
		}else if(messageList.size() == 0){
			System.out.println("消息长度为_0");
		}else{
			System.out.println("获得了"+messageList.size()+"条消息");
		}
		//将最新消息存入redis[1]成为历史消息
		Jedis jedis = null;
	//	Jedis jedis = (Jedis)request.getServletContext().getAttribute("jedis");
		JedisPool pool = (JedisPool)request.getServletContext().getAttribute("jedisPool");
		jedis = pool.getResource();
		if(jedis == null){
			this.logger.debug("debug|(Jedis)request.getServletContext().getAttribute('jedis') is null", jedis);
			return messageList;
		}
		jedis.select(1);
		String key = id+"_"+username;
		if(messageList!=null && messageList.size()>0){
			for(WorkMessage workMessage:messageList){
				jedis.lpush(key.getBytes(),MessageSerializable.serializable(workMessage));
			}
		}
		jedis.close();
		return messageList;
	}
	
	/**
	 * 查询已发送消息
	 */
	public List<WorkMessage> queryHasSendMsg(HttpServletRequest request,HttpServletResponse response){
	//	Jedis jedis = (Jedis)request.getServletContext().getAttribute("jedis");
		JedisPool pool = (JedisPool)request.getServletContext().getAttribute("jedisPool");
		Jedis jedis = pool.getResource();
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		int id = u.getId();
		String username = u.getUsername();
		List<WorkMessage> listMessage = messageDao.queryHasSendMsg(jedis, id, username);
		if(listMessage == null || listMessage.size() == 0){
			return null;
		}
		return listMessage;
	}
	/**
	 * 历史消息
	 * 2018-02-26
	 */
	public List<WorkMessage> queryHistroyMessage(HttpServletRequest request,HttpServletResponse response){
	//	Jedis jedis = (Jedis)request.getServletContext().getAttribute("jedis");
		JedisPool pool = (JedisPool)request.getServletContext().getAttribute("jedisPool");
		Jedis jedis = pool.getResource();
		HttpSession session = request.getSession(false);
		if(session != null){
			User u = (User)session.getAttribute("user");
			int id = u.getId();
			String username = u.getUsername();
			List<WorkMessage> messageList = messageDao.queryHistroyMessage(jedis, id, username);
			return messageList;
		}else{
			this.logger.debug("debug|session is null,relogin will be better", session);
			return null;
		}
	}
	/**
	 * 日志标记已读  manager-->employ
	 * 2018-02-20
	 */
	public boolean tagHasBeenRead(HttpServletRequest request,HttpServletResponse response){
		String title = request.getParameter("title");
		String distince_queue = request.getParameter("username");
		int distince_id = Integer.parseInt(request.getParameter("userid"));
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		String source_queue = u.getUsername();
		int source_id = u.getId();
		String data = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
		WorkMessage workMessage = new WorkMessage();
		workMessage.setContent("您所发送的日志《"+title+"》在"+data+"被经理阅读。");
		workMessage.setSource_id(source_id);
		workMessage.setSource_queue(source_queue);
		workMessage.setDistince_id(distince_id);
		workMessage.setDistince_queue(distince_queue);
		workMessage.setTime(data);
		workMessage.setType("日志消息");
		
		//	messageDao.tagHasBeenRead(workMessage);
		int id = workMessage.getDistince_id();
		String queueName = workMessage.getDistince_queue();
		try{
			this.executorService.execute(new MessageSendThread(workMessage, id, queueName));
		}catch(RejectedExecutionException e){
			System.out.println("线程异常");
			return false;
		}
		
		return true;	//消息发送成功
	}
	
	/**
	 * 批量发送消息 manager-->employ
	 * 2018-02-20
	 */
	@RequestMapping("/batSendMessage")
	public boolean batSendMessage(HttpServletRequest request,HttpServletResponse response){
		String selected = request.getParameter("selected");		//7_xxx:11_employrr:
		String messageContent = request.getParameter("messageContent");
		System.out.println("批量发送消息的内容是："+messageContent);
		HttpSession session = request.getSession(true);
		User u = (User)session.getAttribute("user");
		int source_id = u.getId();
		String source_queue = u.getUsername();
		WorkMessage workMessage = new WorkMessage();
		workMessage.setSource_id(source_id);
		workMessage.setSource_queue(source_queue);
		workMessage.setContent(messageContent);
		workMessage.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
		workMessage.setType("经理消息");
		//解析选择的员工的id和username
		String [] userInfo = selected.split(":");	//id_username
		if(userInfo!=null && userInfo.length>0){
			for(String id_username:userInfo){
				String [] id_uname = id_username.split("_");
				if(id_uname.length == 2){
					int distince_id = Integer.parseInt(id_uname[0]); 
					String distince_queue = id_uname[1];
					workMessage.setDistince_id(distince_id);
					workMessage.setDistince_queue(distince_queue);
					
					//发消息,这里应该最好设置为多线程
					Jedis jedis = null;
					try{
					//	MessageSend.sendMessage(workMessage, distince_id, distince_queue);
						this.executorService.execute(new MessageSendThread(workMessage, distince_id, distince_queue));
						//在这里应该把批量发送的消息存入redis[2]成为已发消息
					//	Jedis jedis = (Jedis)request.getServletContext().getAttribute("jedis");
						JedisPool pool = (JedisPool)request.getServletContext().getAttribute("jedisPool");
						jedis = pool.getResource();
						if(jedis != null){
							messageDao.newMsg2HasSendMsg(jedis, source_id, source_queue, workMessage);
						}
					}catch(RuntimeException e){
						return false;
					}finally{
						if(jedis != null){
							jedis.close();
						}
					}
					
				}else{
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * manager处理employ的补卡信息
	 * 同意/不同意补卡签到
	 * 2018-08-21
	 */
	public String aggreeLogin(HttpServletRequest request,HttpServletResponse response){
		String aggreeLogin = request.getParameter("aggreeLogin");
		String employ_id = request.getParameter("employ_id");	//补卡员工的id
		String employ_name = request.getParameter("employ_name");	//补卡员工的name
		String manager_id = request.getParameter("manager_id");		//处理补卡消息的经理id
		String manager_name = request.getParameter("manager_name");	//处理补卡消息经理的name
		String bukaTime = request.getParameter("bukaTime");
		//权限校验，检查是否是该员工的经理给该员工处理的补卡消息
		HttpSession session = request.getSession(true);
		User u = (User)session.getAttribute("user");
		String id = u.getId()+"";			//当前登录用户的id
		String username = u.getUsername();	//当前登录员工的username
		if(!id.equals(manager_id) && !username.equals(manager_name)){
			return "当前权限错误，无法处理这条补卡签到消息";
		}
		if("1".equals(aggreeLogin)){	//同意补卡签到
			//签到记录入库
			Work work = new Work();
			work.setDay(bukaTime);
			work.setWorkstart(true);
			work.setEmploy_id(Integer.parseInt(employ_id));
			//拼接签到时间
			System.out.println("补卡时间:"+bukaTime);
			String workStartTime[] = bukaTime.split("-");
			String year = workStartTime[0]+"年";
			String month = workStartTime[1]+"月";
			String day = workStartTime[2]+"日 ";
			String h = "09点";
			String min = "00分";
			String workstartTime = year+month+day+h+min;	//签到具体时间;
			work.setWorkstart_time(workstartTime);
			System.out.println("签到集体时间格式:"+workstartTime);
			employDao.workStart(work);
			System.out.println("签到消息入库成功");
			//发消息通知employ
			WorkMessage workMessage = new WorkMessage();
			workMessage.setContent("经理已经通过了您"+bukaTime+"的补卡签到申请");
			workMessage.setDistince_id(Integer.parseInt(employ_id));
			workMessage.setDistince_queue(employ_name);
			workMessage.setSource_id(u.getId());
			workMessage.setSource_queue(u.getUsername());
			workMessage.setType("补卡签到消息");
			workMessage.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
		//	MessageSend.sendMessage(workMessage, Integer.parseInt(employ_id), employ_name);
			this.executorService.execute(new MessageSendThread(workMessage, Integer.parseInt(employ_id), employ_name));
			System.out.println("申请补卡消息发送完成");
			return "您已同意"+employ_name+"的申请签到消息";
		}else if("0".equals(aggreeLogin)){	//不同意补卡签到
			System.out.println("不同意补卡签到");
			//发消息通知employ
			WorkMessage workMessage = new WorkMessage();
			workMessage.setContent("对不起，您的补卡签到申请未通过批准");
			workMessage.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
			workMessage.setType("补卡签到消息");
			workMessage.setDistince_id(Integer.parseInt(employ_id));
			workMessage.setDistince_queue(employ_name);
			workMessage.setSource_id(u.getId());
			workMessage.setSource_queue(u.getUsername());
		//	MessageSend.sendMessage(workMessage, Integer.parseInt(employ_id), employ_name);
			this.executorService.execute(new MessageSendThread(workMessage, Integer.parseInt(employ_id), employ_name));
			System.out.println("不同意补卡消息发送成功");
			return "您未同意"+employ_name+"的申请签到消息";
		}
		return "";
	}
	/**
	 * manager处理employ的补卡信息
	 * 同意/不同意补卡签退
	 * 2018-08-21
	 */
	public String aggreeLogout(HttpServletRequest request,HttpServletResponse response){
		String aggreeLogout = request.getParameter("aggreeLogout");
		String employ_id = request.getParameter("employ_id");
		String employ_name = request.getParameter("employ_name");
		String manager_id = request.getParameter("manager_id");
		String manager_name = request.getParameter("manager_name");
		String bukaTime = request.getParameter("bukaTime");
		//权限校验，检查是否是该员工的经理给该员工处理的补卡消息
		HttpSession session = request.getSession(true);
		User u = (User)session.getAttribute("user");
		String id = u.getId()+"";			//当前登录用户的id
		String username = u.getUsername();	//当前登录员工的username
		if(!id.equals(manager_id) && !username.equals(manager_name)){
			return "当前权限错误，无法处理这条补卡签退消息";
		}
		if("1".equals(aggreeLogout)){	//同意补卡签退
			//签退记录入库
			Work work = new Work();
			work.setDay(bukaTime);
			work.setWorkend(true);
			work.setEmploy_id(Integer.parseInt(employ_id));
			//拼接签退时间
			System.out.println("补卡时间:"+bukaTime);
			String workEndTime[] = bukaTime.split("-");
			String year = workEndTime[0]+"年";
			String month = workEndTime[1]+"月";
			String day = workEndTime[2]+"日 ";
			String h = "18点";
			String min = "30分";
			String workendTime = year+month+day+h+min;	//签退具体时间;
			work.setWorkend_time(workendTime);
			System.out.println("签退具体时间格式:"+workendTime);
			employDao.workEnd(work);
			System.out.println("签退消息入库成功");
			//发消息通知employ
			WorkMessage workMessage = new WorkMessage();
			workMessage.setContent("经理已经通过了您"+bukaTime+"的补卡签退申请");
			workMessage.setDistince_id(Integer.parseInt(employ_id));
			workMessage.setDistince_queue(employ_name);
			workMessage.setSource_id(u.getId());
			workMessage.setSource_queue(u.getUsername());
			workMessage.setType("补卡签退消息");
			workMessage.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
		//	MessageSend.sendMessage(workMessage, Integer.parseInt(employ_id), employ_name);
			this.executorService.execute(new MessageSendThread(workMessage, Integer.parseInt(employ_id), employ_name));
			System.out.println("申请补卡消息发送完成");
			return "您已同意"+employ_name+"的申请签退消息";
		}else if("0".equals(aggreeLogout)){	//不同意不卡签退
			System.out.println("不同意补卡签退");
			//发消息通知employ
			WorkMessage workMessage = new WorkMessage();
			workMessage.setContent("对不起，您的补卡签退申请未通过批准");
			workMessage.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
			workMessage.setType("补卡签退消息");
			workMessage.setDistince_id(Integer.parseInt(employ_id));
			workMessage.setDistince_queue(employ_name);
			workMessage.setSource_id(u.getId());
			workMessage.setSource_queue(u.getUsername());
		//	MessageSend.sendMessage(workMessage, Integer.parseInt(employ_id), employ_name);
			this.executorService.execute(new MessageSendThread(workMessage, Integer.parseInt(employ_id), employ_name));
			System.out.println("不同意补卡消息发送成功");
			return "您未同意"+employ_name+"的申请签退消息";
		}
		return "";
	}
	
	@Resource(name="employdao")
	private EmployDao employDao;
	@Resource(name="messagedao")
	private MessageDao messageDao;
	@Autowired
	private ExecutorService executorService;
}