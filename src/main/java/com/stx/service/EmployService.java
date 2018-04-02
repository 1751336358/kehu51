package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stx.pojo.Authority;
import com.stx.pojo.Department;
import com.stx.pojo.Log;
import com.stx.pojo.Menu;

public interface EmployService {
	//跳转到员工签到页面，还要查询出该员工最近的签到记录
		public HttpServletRequest selNearWork(HttpServletRequest request,HttpServletResponse response);
		
		//签到
		public boolean workStart(HttpServletRequest request,HttpServletResponse response);
			
		//签退
		public boolean workEnd(HttpServletRequest request,HttpServletResponse response);
		
		//将日志添加到数据库
		public void addLog(HttpServletRequest request,HttpServletResponse response);
		
		//补卡
		public boolean buka(HttpServletRequest request,HttpServletResponse response);
		
		//将修改后的数据更新到数据库 
		public String updateInfo(HttpServletRequest request,HttpServletResponse response);
		
		//查询所有用户
		public HttpServletRequest getAllCustom(HttpServletRequest request,HttpServletResponse response);
		
		//评论我的
		public HttpServletRequest myComment(HttpServletRequest request,HttpServletResponse response);
		
		/**
		 *insert 请假记录
		 */
		public Integer insertLeave(HttpServletRequest request,HttpServletResponse response);
	}
