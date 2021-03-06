package com.stx.dao;

import java.util.List;

import com.stx.pojo.Custom;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;

public interface AdminDao {
	/**
	 * 判断部门名是否存在
	 * @param department
	 * @return
	 */
	public Integer departNameExist(Department department);
	/**
	 * 添加部门
	 * @param department
	 * @return
	 */
	public Integer addDepartment(Department department);
	/**
	 * 修改部门名时判断部门名是否存在
	 */
	public Integer updateDepartmentExist(Department department);
	/**
	 * 修改部门
	 */
	public Integer changeDepartmentInfo(Department department);
	/**
	 * 查询所有部门
	 */
	public List<Department> queryDepartment();
	
	/**
	 * 删除部门
	 */
	public Integer delDepartmentById(Integer id);
	
	/**
	 * 查询部门员工
	 */
	public List<Employ> queryEmployByDepartmentId(Integer departmentId);
	
	/**
	 * 修改employ状态
	 * @param request
	 * @param response
	 */
	public Integer open(Employ employ);
	
	/**
	 * 修改custom状态
	 * @param request
	 * @param response
	 */
	public Integer openCustom(Custom custom);
	
}
