package com.stx.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stx.pojo.Department;
import com.stx.service.AdminService;
import com.stx.service.EmployService;

@RestController("adminController")
public class AdminController {
	
	/**
	 * 跳转到添加部门页面
	 */
	@RequestMapping("/gotoAddDepartment")
	public void gotoAddDepartment(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/admin/adddepartment.jsp").forward(request, response);
		} catch (Exception e) {
		} 
	}
	
	/**
	 * 添加部门和经理
	 */
	@RequestMapping("/addDepartmentAndManager")
	public @ResponseBody Integer addDepartmentAndManager(HttpServletRequest request){
		Integer ret = 0;
		try {
			ret = adminService.addDepartmentAndManager(request);
		} catch (Exception e) {
			return 0;
		}
		/**
		 * -1：部门名已存在
		 * -2：经理名已存在
		 * 1：添加成功
		 * 0：添加失败
		 */
		return ret;
	}
	
	/**
	 * 跳转到部门管理页面
	 */
	@RequestMapping("/departmentlist")
	public void departmentList(HttpServletRequest request,HttpServletResponse response){
		try {
			List<Department> departments = adminService.queryDepartment();
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/departmentlist.jsp").forward(request, response);
		} catch (Exception e) {
		}
	}
	
	/**
	 * 删除部门
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delDepartmentById")
	public void delDepartmentById(HttpServletRequest request,HttpServletResponse response){
		adminService.delDepartmentById(request, response);
		List<Department> departments = adminService.queryDepartment();
		request.setAttribute("departments", departments);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/admin/departmentlist.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	/**
	 * 跳转到员工列表页面
	 */
	@RequestMapping("/gotoEmployList")
	public void gotoEmployList(HttpServletRequest request,HttpServletResponse response){
		//查询部门员工信息
		List<Department> departments = adminService.queryDepartmentAndEmploy();
		try {
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/employList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 修改employ状态：open=1:启用  open=-1:禁用
	 * @param request
	 * @param response
	 */
	@RequestMapping("/open")
	public @ResponseBody  Integer open(HttpServletRequest request,HttpServletResponse response){
		Integer ret = adminService.open(request, response);
		return ret;
	}
	
	/**
	 * 修改custom状态：open=1:启用  open=-1:禁用
	 * @param request
	 * @param response
	 */
	@RequestMapping("/openCustom")
	public @ResponseBody  Integer openCustom(HttpServletRequest request,HttpServletResponse response){
		Integer ret = adminService.openCustom(request, response);
		return ret;
	}
	/**
	 * 通过employid查询客户列表
	 */
	@RequestMapping("/queryCustom")
	public void queryCustom(HttpServletRequest request,HttpServletResponse response){
		request = employService.getAllCustom(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/admin/queryCustom.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	@Resource(name="adminServices")
	private AdminService adminService;
	@Resource(name="employServices")
	private EmployService employService;
}
