package com.stx.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface EmployService {
	//跳转到员工签到页面，还要查询出该员工最近的签到记录
		public HttpServletRequest selNearWork(HttpServletRequest request,HttpServletResponse response);
		
		//签到
		public boolean workStart(HttpServletRequest request,HttpServletResponse response);
			
		//签退
		public boolean workEnd(HttpServletRequest request,HttpServletResponse response);
		
		//将日志添加到数据库
		public Integer addLog(HttpServletRequest request,HttpServletResponse response) throws Exception;
		
		//补卡
		public boolean buka(HttpServletRequest request,HttpServletResponse response);
		
		//将修改后的数据更新到数据库 
		public String updateInfo(HttpServletRequest request,HttpServletResponse response);
		
		//查询所有用户
		public HttpServletRequest getAllCustom(HttpServletRequest request,HttpServletResponse response);
		
		//评论我的
		public HttpServletRequest myComment(HttpServletRequest request,HttpServletResponse response);
		
	}
