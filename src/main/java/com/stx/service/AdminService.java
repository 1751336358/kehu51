package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
