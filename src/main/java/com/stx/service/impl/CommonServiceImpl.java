package com.stx.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.stx.dao.CommonDao;
import com.stx.pojo.Authority;
import com.stx.pojo.Custom;
import com.stx.pojo.User;
import com.stx.service.CommonService;

@Service("commonServices")
public class CommonServiceImpl implements CommonService{
	
	
	//跳转首页，查询出所有权限
	@Override
	public HttpServletRequest getAllAuthority(HttpServletRequest request,HttpServletResponse response) {
		List<Authority> authorityList =  commonDao.getAllAuthority();
		request.setAttribute("authorityList", authorityList);
		return request;
	}
	
	//登录
	@Override
	public boolean login(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		int authorityid = Integer.parseInt(request.getParameter("authorityid"));	//登陆的权限值：1客户，2员工，3经理
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//先检查username和password
		User user = new User(username,password);
		//根据authorityid查询不同的角色所对应的菜单列表
		Authority authority = commonDao.getAuthority(authorityid);
		System.out.println(authority.getId());
		System.out.println(authority.getName());
		System.out.println(authority.getMenus().size());
		session.setAttribute("authority", authority);
		user.setAuthority(authority);
		//再检查权限，注意：要将查询出来的菜单存入session里
		if(authorityid == 1){
			user = commonDao.checkCustom(user);
			System.out.println("客户");
			if(user != null){
				System.out.println("客户输入的用户名密码正确");
				session.setAttribute("user", user);
				return true;
			}else {
				System.out.println("客户输入错误");
				session.removeAttribute("user");
				return false;
			}
		}else if(authorityid == 2){
			user = commonDao.checkEmploy(user);
			System.out.println("员工");
			if(user != null){
				System.out.println("员工输入的用户名密码正确");
				session.setAttribute("user", user);
				return true;
			}else{
				System.out.println("员工输入错误");
				session.removeAttribute("user");
				return false;
			}
		}else if(authorityid == 3){
			user = commonDao.checkEmploy(user);
			System.out.println("经理");
			if(user != null){
				System.out.println("经理输入的用户名密码正确");
				session.setAttribute("user", user);				
				return true;
			}else{
				System.out.println("经理输入错误");
				session.removeAttribute("user");
				return false;
			}
		}
		return false;
	}
	
	//注销
	public void logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session.removeAttribute("user");
		
		User u = (User)session.getAttribute("user");
		if(u == null){
			System.out.println("成功退出");
		}
		session.invalidate();
	}
	@Resource(name="commondao")
	private CommonDao commonDao;

	/*
	insert into menu(name,url,authority_id) values('员工管理','employmanage',3);
	insert into menu(name,url,authority_id) values('日志管理','logmanage',3);
	insert into menu(name,url,authority_id) values('考情管理','workmanage',3);
	
	insert into menu(name,url,authority_id) values('工作日志','worklogmanage',2);
	insert into menu(name,url,authority_id) values('客户管理','custommanage',2);
	
	insert into menu(name,url,authority_id) values('修改个人信息','updateinfo',1);
	insert into menu(name,url,authority_id) values('查看员工信息','getemploy',1);
	insert into menu(name,url,authority_id) values('选择新员工','changenewemploy',1);
	*/
}