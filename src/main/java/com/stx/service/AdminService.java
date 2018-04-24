package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stx.pojo.Department;

public interface AdminService {
	/**
	 * 添加部门和经理
	 * @param request
	 * @throws Exception 
	 */
	public Integer addDepartmentAndManager(HttpServletRequest request);
	
	/**
	 * 查询所有部门
	 */
	public List<Department> queryDepartment();
	
	/**
	 * 删除部门
	 * @param request
	 * @param response
	 */
	public Integer delDepartmentById(HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 查询部门员工信息
	 */
	public List<Department> queryDepartmentAndEmploy();
	
	/**
	 * 修改employ状态
	 * @param request
	 * @param response
	 */
	public Integer open(HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 修改客户状态
	 */
	public Integer openCustom(HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 修改部门信息
	 */
	public Integer changeDepartmentInfo(HttpServletRequest request,HttpServletResponse response);
	/**
	 * 修改部门信息
	 */
	public Integer delUser(HttpServletRequest request,HttpServletResponse response);
}
