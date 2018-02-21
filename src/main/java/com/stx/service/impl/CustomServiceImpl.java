package com.stx.service.impl;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.stx.dao.CommonDao;
import com.stx.dao.CustomDao;
import com.stx.dao.EmployDao;
import com.stx.dao.ManagerDao;
import com.stx.pojo.Authority;
import com.stx.pojo.Comment;
import com.stx.pojo.Custom;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;
import com.stx.service.CustomService;

@Service("customServices")
public class CustomServiceImpl implements CustomService{
	
	//跳转到custom注册页面
	public HttpServletRequest gotoCustomRegisterPage(HttpServletRequest request,HttpServletResponse response){
		//查询部门信息
		List<Department> departments = customDao.getDepartment();
		request.setAttribute("departments", departments);
		//查询员工信息
		List<Employ> employs = customDao.showIndexEmploy();
		request.setAttribute("employs", employs);
		return request;
	}
	
	//注册
	public boolean  register(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String username = request.getParameter("username");
		int count = customDao.isRegister(username);
		if(count != 0){	//该用户已经被注册
			System.out.println("该用户已经注册");
			return true;
		}
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		int employ_id = Integer.parseInt(request.getParameter("employ_id"));
		String registerTime = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分").format(new Date());		//注册时间
		//封装
		Custom user = new Custom();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		user.setBirthday(birthday);
		user.setRegisterTime(registerTime);
		user.setQueueName(username);
		Employ employ = employDao.selEmployById(employ_id);
		user.setEmploy(employ);
		customDao.register(user);	//将注册的客户信息插入数据库
		System.out.println("注册成功");
		//查询菜单列表,存入session
		Authority authority = commonDao.getAuthority(1);	//客户的权限
		System.out.println(authority.getId());
		System.out.println(authority.getName());
		System.out.println(authority.getMenus().size());
		session.setAttribute("authority", authority);
		user.setAuthority(authority);
		user.setId(customDao.getCustomByUserName(username).getId());	//主键没有回显，查询出主键
		//将登录信息存入session
		session.setAttribute("user",user);
		return false;
	}
	
	//根据部门id查询该部门的所有员工
	public List<Employ> getEmployByDepartmentId(HttpServletRequest request,HttpServletResponse response){
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		return customDao.getEmployByDepartmentId(department_id);
	}
	
	//查看个人信息
	public HttpServletRequest selCustomById(HttpServletRequest request,HttpServletResponse response){
		int userid = Integer.parseInt(request.getParameter("userid"));
		Custom custom = customDao.selCustomById(userid);
		request.setAttribute("custom", custom);
		return request;
	}
	
	//将用户修改的个人信息插入数据库
	public void updateCustom(HttpServletRequest request,HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));		
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		Custom custom = new Custom();
		custom.setId(id);
		custom.setPassword(password);
		custom.setPhoneNumber(phoneNumber);
		custom.setEmail(email);
		customDao.updateCustom(custom);
	}
	
	//查看员工信息
	public HttpServletRequest selEmployByCustomEmployId(HttpServletRequest request,HttpServletResponse response){
		int userid = Integer.parseInt(request.getParameter("userid"));
		Employ employ = customDao.selEmployByCustomEmployId(userid);
		//根据employ_id查询出该员工属于哪个部门
		int id = employ.getId();
		Department department = customDao.getDepartmentByEmployId(id);
		request.setAttribute("employ", employ);
		request.setAttribute("department", department);
		//要查出这个员工的评论
		List<Comment> comments = customDao.getCommentByEmployId(id);
		request.setAttribute("comments", comments);
		return request;
	}
	
	//跳转到更换员工页面
	public HttpServletRequest changeEmploy(HttpServletRequest request,HttpServletResponse response){
		//查询部门信息
		List<Department> departments = managerDao.getDepartment();
		request.setAttribute("departments", departments);
		return request;
	}
	
	//将客户更改员工的信息更新到数据库
	public void updateEmployId(HttpServletRequest request,HttpServletResponse response){
		int custom_id = Integer.parseInt(request.getParameter("custom_id"));
		int employ_id = Integer.parseInt(request.getParameter("employ_id"));
		Custom custom = new Custom();
		custom.setId(custom_id);
		Employ employ = new Employ();
		employ.setId(employ_id);
		custom.setEmploy(employ);
		customDao.updateEmployId(custom);	//更换员工
	}
	
	//将客户评论信息插入数据库
	public boolean addcomment(HttpServletRequest request,HttpServletResponse response){
		String content = request.getParameter("content");
		System.out.println(content);
		/*try {
			content = new String(content.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
		}*/
		System.out.println(content);
		String username = request.getParameter("username");
		int employ_id = Integer.parseInt(request.getParameter("employ_id"));
		int custom_id = Integer.parseInt(request.getParameter("custom_id"));
		//构造评论时间
		String commenttime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setUsername(username);
		comment.setCustom_id(custom_id);
		comment.setEmploy_id(employ_id);
		comment.setCommenttime(commenttime);
		try{
			customDao.addComment(comment);
		}catch(Exception e){
			return false;	//评论失败
		}	
		return true;
	}
	
	
	@Resource(name="customdao")
	private CustomDao customDao;
	@Resource(name="employdao")
	private EmployDao employDao;
	@Resource(name="commondao")
	private CommonDao commonDao;
	@Resource(name="managerdao")
	private ManagerDao managerDao;
	
}
