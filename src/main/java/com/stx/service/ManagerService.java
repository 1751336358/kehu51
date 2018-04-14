package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ResponseBody;

import com.stx.pojo.Custom;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;
import com.stx.pojo.Log;
import com.stx.pojo.Menu;
import com.stx.pojo.Work;

public interface ManagerService {
	//根据父菜单id查询子菜单列表
		public List<Menu> getsonmenu(int idIndex);
		
		//将添加的员工数据插入数据库
		public HttpServletRequest insertEmploy(HttpServletRequest request,HttpServletResponse response,HttpSession session);
		
		//查询所有的员工
		public HttpServletRequest getAllEmploy(HttpServletRequest request,HttpServletResponse response);
		
		//修改员工信息
		public  HttpServletRequest updateEmploy(HttpServletRequest request,HttpServletResponse response);
		
		
		//根据departmentid查询部门信息
		public List<Department> getDepartment(HttpServletRequest request,HttpServletResponse response);
		
		//将修改后的员工信息插入数据库
		public HttpServletRequest newEmploy(HttpServletRequest request,HttpServletResponse response,HttpSession session);
		
		//删除员工，根据userid
		public HttpServletRequest deleteManager(HttpServletRequest request,HttpServletResponse response,HttpSession session);
		
		//跳转到员工日志列表页面
		public HttpServletRequest getlogs(HttpServletRequest request,HttpServletResponse response);
		
		// Ajax控制日志列表翻页
		public List<Log> getLogByPage(HttpServletRequest request,HttpServletResponse response);
		
		//查询日志详细信息
		public HttpServletRequest getLogDetail(HttpServletRequest request,HttpServletResponse response);
		
		//查询出最近5条考勤记录
		public HttpServletRequest getWorks(HttpServletRequest request,HttpServletResponse response);
		// Ajax控制考勤列表翻页
		public List<Work> getWorkByPage(HttpServletRequest request,HttpServletResponse response);
		
		//通过员工id查看所有客户详情
		public List<Custom> queryCustomDetailByEmployId(HttpServletRequest request,HttpServletResponse response);
	}
