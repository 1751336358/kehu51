package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stx.pojo.Comment;
import com.stx.pojo.Custom;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;
import com.stx.pojo.Log;
import com.stx.pojo.Menu;
import com.stx.pojo.Work;

public interface CustomService {
	//跳转到custom注册页面
		public HttpServletRequest gotoCustomRegisterPage(HttpServletRequest request,HttpServletResponse response);
		
		//注册
		public boolean register(HttpServletRequest request,HttpServletResponse response,HttpSession session);
		
		//根据部门id查询该部门的所有员工
		public List<Employ> getEmployByDepartmentId(HttpServletRequest request,HttpServletResponse response);
		
		//查看个人信息
		public HttpServletRequest selCustomById(HttpServletRequest request,HttpServletResponse response);
		
		//将用户修改的个人信息插入数据库
		public void updateCustom(HttpServletRequest request,HttpServletResponse response);
		
		//查看员工信息
		public HttpServletRequest selEmployByCustomEmployId(HttpServletRequest request,HttpServletResponse response);
		
		//跳转到更换员工页面
		public HttpServletRequest changeEmploy(HttpServletRequest request,HttpServletResponse response);
		
		//将客户更改员工的信息更新到数据库
		public boolean updateEmployId(HttpServletRequest request,HttpServletResponse response);
		
		//将客户评论信息插入数据库
		public boolean addcomment(HttpServletRequest request,HttpServletResponse response);
		
		//根据employid查employ信息		 
		public Employ getEmployById(HttpServletRequest request,HttpServletResponse response);
	}
