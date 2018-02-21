package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stx.pojo.Authority;

public interface CommonService {
	//跳转首页，查询出所有权限
		public HttpServletRequest getAllAuthority(HttpServletRequest request,HttpServletResponse response);
		
		//登录
		public boolean login(HttpServletRequest request,HttpServletResponse response,HttpSession session);
		
		//注销
		public void logout(HttpServletRequest request,HttpServletResponse response,HttpSession session);
	}
