package com.stx.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import com.stx.dao.EmployDao;
import com.stx.pojo.Comment;
import com.stx.pojo.Custom;
import com.stx.pojo.Employ;
import com.stx.pojo.Log;
import com.stx.pojo.User;
import com.stx.pojo.Work;
import com.stx.pojo.WorkMessage;
import com.stx.service.EmployService;
import com.stx.utils.MessageSend;

@Service("employServices")
public class EmployServiceImpl implements EmployService{
	
	/**
	 * 跳转到员工签到页面，还要查询出该员工最近的签到记录
	 */
	public HttpServletRequest selNearWork(HttpServletRequest request,HttpServletResponse response){
		//当前登录的客户id
		int userid = Integer.parseInt(request.getParameter("userid"));
		System.out.println("当前登录的员工id是:"+userid);
		//根据userid查询该员工最近的签到记录
		List<Work> works = employDao.selNearWork(userid);
		request.setAttribute("works", works);
		return request;
	}
	
	/**
	 * 签到
	 */
	public boolean workStart(HttpServletRequest request,HttpServletResponse response){
		Work work = new Work();		//封装
		int userid = Integer.parseInt(request.getParameter("userid"));	//签到者userid
		String day = new SimpleDateFormat("yyyy-MM-dd").format(new Date());	//签到日期
		boolean workstart = true;	//是否签到
		String workstart_time = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分").format(new Date());	//签到具体时间
		work.setDay(day);
		work.setEmploy_id(userid);
		work.setWorkstart(workstart);
		work.setWorkstart_time(workstart_time);
		
		int count = employDao.isWorkStart(work);
		if(count != 0){	//如果已经签到
			System.out.println("work is not null");
			return false;
		}
		System.out.println("work is null");
		//调用dao将签到信息插入数据库
		employDao.workStart(work);
		return true;
	}
	
	/**
	 * 签退
	 */
	public boolean workEnd(HttpServletRequest request,HttpServletResponse response){
		Work work = new Work();		//封装
		int userid = Integer.parseInt(request.getParameter("userid"));	//签退者userid
		String day = new SimpleDateFormat("yyyy-MM-dd").format(new Date());	//签退日期
		boolean workend = true;	//是否签退
		String workend_time = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分").format(new Date());	//签退具体时间
		work.setDay(day);
		work.setEmploy_id(userid);
		work.setWorkend(workend);
		work.setWorkend_time(workend_time);
		
		//查询是否签到,如果已经签到,返回false;
		int isWorkEnd = employDao.isWorkEnd(work);
		if(isWorkEnd != 0){	//如果已经签退
			return false;
		}
		//调用dao将签到信息插入数据库
		employDao.workEnd(work);
		return true;
	}
	/**
	 * 补卡，判断今日是否签到或签退
	 * 2018-02-14
	 */
	public boolean buka(HttpServletRequest request,HttpServletResponse response){
		String radio = request.getParameter("radio");//	1:签到 2:签退
		Work work = new Work();
		HttpSession session = request.getSession(true);
		User u = (User)session.getAttribute("user");
		int userId = u.getId();
		String bukaTime = request.getParameter("bukaTime"); // "yyyy-MM-dd"
		boolean workstart = true;	//是否签到
		boolean workend = true;	//是否签退
		work.setDay(bukaTime);
		work.setEmploy_id(userId);
		work.setWorkstart(workstart);
		work.setWorkend(workend);
		int count = 0;
		//签到
		if("1".equals(radio)){
			count = employDao.isWorkStart(work);
			if(count == 0){
				return true;	//没签到
			}else{
				return false;	//已签到
			}
			
		}
		//签退
		count = employDao.isWorkEnd(work);
		if(count == 0){
			return true; //没有签退
		}else {
			return false;	//已签退
		}
	}
	
	/**
	 * 将日志添加到数据库
	 */
	public void addLog(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession(true);
		User u = (User)session.getAttribute("user");
		int employ_id = u.getId();
		String employ_name = u.getUsername();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String committime = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分").format(new Date());
		//根据当前员工的id查询该员工所在部门的部门经理id
		Employ manager = employDao.getManagerInfoByEmployId(employ_id);
		int manager_id=manager.getId();
		String manager_name = manager.getUsername();
		//封装
		Log log = new Log();
		log.setEmploy_id(employ_id);
		log.setTitle(title);
		log.setContent(content);
		log.setCommittime(committime);
		log.setManager_id(manager_id);
		employDao.addLog(log);
		System.out.println("主键回显的日志id是："+log.getId());
		//发送消息给manager
		WorkMessage workMessage = new WorkMessage();
		workMessage.setType("日志消息");
		workMessage.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
		workMessage.setContent("您的员工"+employ_name+"发表了《"+title+"》日志,<a href='"+request.getContextPath()+"/getlogdetail?id="+log.getId()+"'>点击查看</a>");
		workMessage.setSource_id(employ_id);
		workMessage.setSource_queue(employ_name);
		workMessage.setDistince_id(manager_id);
		workMessage.setDistince_queue(manager_name);
		MessageSend.sendMessage(workMessage, manager_id, manager_name);
	}
	
	/**
	 * 将修改后的数据更新到数据库
	 */
	public String updateInfo(HttpServletRequest request,HttpServletResponse response){
		String message;
		int id = Integer.parseInt(request.getParameter("id"));
		String oldPassword = request.getParameter("oldpassword");
		String newPassword = request.getParameter("newpassword");
		String info = request.getParameter("info");
		/*System.out.println("id:"+id);
		System.out.println("oldpassword:"+oldPassword);
		System.out.println("newpassword:"+newPassword);
		System.out.println("info:"+info);*/
		//根据id查询密码，如果秘密正确，则确认修改
		String oldpass = employDao.getPasswordById(id);
		if(!oldPassword.equals(oldpass)){
			System.out.println("旧密码输入错误");
			message = "旧密码输入错误";
			return message;
		}
		Employ employ = new Employ();	//封装
		employ.setId(id);
		employ.setPassword(newPassword);
		employ.setInfo(info);
		employDao.updateInfo(employ);
		message = "修改成功";
		return message;
	}
	
	/**
	 *	查询所有用户 
	 */
	public HttpServletRequest getAllCustom(HttpServletRequest request,HttpServletResponse response){
		int userid = Integer.parseInt(request.getParameter("userid"));
		List<Custom> customs = employDao.getAllCustom(userid);
		request.setAttribute("customs", customs);
		return request;
	}
	
	/**
	 * 评论我的
	 */
	public HttpServletRequest myComment(HttpServletRequest request,HttpServletResponse response){
		int userid = Integer.parseInt(request.getParameter("userid"));
		List<Comment> comments = employDao.myComment(userid);
		request.setAttribute("comments", comments);
		return request;
	}
	
	
	@Resource(name="employdao")
	private EmployDao employDao;
}
