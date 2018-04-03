package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ResponseBody;

import com.stx.pojo.Authority;

public interface CommonService {
		//跳转首页，查询出所有权限
		public HttpServletRequest getAllAuthority(HttpServletRequest request,HttpServletResponse response);
		
		//登录检查用户名和密码是否正确		
		public   boolean checkInput(HttpServletRequest request,HttpServletResponse response);
		//登录
		public boolean login(HttpServletRequest request,HttpServletResponse response);
		//登录，新接口
		public void loginIn(HttpServletRequest request,HttpServletResponse response);
		//注销
		public void logout(HttpServletRequest request,HttpServletResponse response,HttpSession session);
	}
