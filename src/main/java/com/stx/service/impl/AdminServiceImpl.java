package com.stx.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stx.dao.AdminDao;
import com.stx.dao.EmployDao;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;
import com.stx.pojo.User;
import com.stx.service.AdminService;

@Service("adminServices")
public class AdminServiceImpl implements AdminService{
	
	
	/**
	 * 添加部门和经理
	 * @param request
	 */
	@Override
	@Transactional
	public Integer addDepartmentAndManager(HttpServletRequest request){
		String departmentName = request.getParameter("departmentName");	//部门名称
		String departmentInfo = request.getParameter("departmentInfo");	//部门描述
		String username = request.getParameter("username");
		String managerInfo = request.getParameter("managerInfo");
		//封装部门信息
		Department department = new Department();
		department.setName(departmentName);
		department.setInfo(departmentInfo);
		//先判断部门名是否存在
		int count = adminDao.departNameExist(department);
		if(count != 0){	//部门名已存在
			return -1;
		}
		//封装经理信息
		Employ manager = new Employ();
		manager.setUsername(username);
		manager.setInfo(managerInfo);
		//判断经理名是否存在
		count = employDao.managerExist(username);
		if(count != 0){
			return -2;
		}
		/**
		 * -1：部门名已存在
		 * -2：经理名已存在
		 * 1：添加成功
		 * 0：添加失败
		 */
		
		//添加部门,在这里使用事物，防止脏数据
		adminDao.addDepartment(department);
		manager.setDepartmentid(department.getId());
		//添加经理
		employDao.addManager(manager);
		return 1;
	}
	
	/**
	 * 查询所有部门
	 */
	public List<Department> queryDepartment(){
		return adminDao.queryDepartment();
	}
	
	/**
	 * 删除部门
	 * 业务逻辑
	 * 	1）首先该部门下的员工必须被经理全部移到其他部门
	 * 	2）管理员才可以删除部门和部门经理
	 */
	@Override
	@Transactional
	public Integer delDepartmentById(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		//验证是否是管理员权限
		if(u == null || (!"admin".equals(u.getUsername()) && !"admin".equals(u.getPassword()))){
			return 0;
		}
		Integer id = Integer.parseInt(request.getParameter("id"));	//departmentId
		//再判断该部门下是否有非经理的其他员工，如果有则不能删除该部门
		Integer employCount = employDao.hasOtherEmploy(id);
		if(employCount > 0){
			return 0;
		}
		//先删除这个部门的经理
		employDao.delManagerByDepartmentId(id);
		//再删除部门
		adminDao.delDepartmentById(id);
		return 1;
	}
	
	/**
	 * 查询部门员工信息
	 */
	public List<Department> queryDepartmentAndEmploy(){
		//查询部门信息
		List<Department> departments = adminDao.queryDepartment();
		
		for(Department department:departments){
			//循环查询员工信息
			Integer departmentId = department.getId();
			List<Employ> employs = adminDao.queryEmployByDepartmentId(departmentId);
			department.setEmploys(employs);
		}
		return departments;
	}
	@Resource(name="admindao")
	private AdminDao adminDao;
	@Resource(name="employdao")
	private EmployDao employDao;
}