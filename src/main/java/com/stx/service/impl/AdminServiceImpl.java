package com.stx.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stx.dao.AdminDao;
import com.stx.dao.EmployDao;
import com.stx.pojo.Custom;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;
import com.stx.pojo.User;
import com.stx.pojo.WorkMessage;
import com.stx.service.AdminService;
import com.stx.utils.MessageSend;

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
	
	/**
	 * 修改employ状态
	 * @param request
	 * @param response
	 */
	@Override
	public Integer open(HttpServletRequest request,HttpServletResponse response){
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer open = Integer.valueOf(request.getParameter("open"));
		Employ employ = new Employ();
		employ.setId(id);
		employ.setOpen(open);
		Integer ret = adminDao.open(employ);
		return ret;
	}
	
	/**
	 * 修改custom状态
	 * @param request
	 * @param response
	 */
	@Override
	public Integer openCustom(HttpServletRequest request,HttpServletResponse response){
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer open = Integer.valueOf(request.getParameter("open"));
		Custom custom = new Custom();
		custom.setId(id);
		custom.setOpen(open);
		Integer ret = adminDao.openCustom(custom);
		return ret;
	}
	
	/**
	 * 修改部门信息
	 */
	@RequestMapping("/changeDepartmentInfo")
	public Integer changeDepartmentInfo(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		if(!"admin".equals(u.getUsername()) && !"admin".equals(u.getPassword()))
			return 403;	
		Integer did = Integer.parseInt(request.getParameter("did"));
		String name = request.getParameter("name");
		String info = request.getParameter("info");
		Department department = new Department();
		department.setId(did);
		department.setName(name);
		department.setInfo(info);
		//判断部门是否存在
		Integer count = adminDao.updateDepartmentExist(department);
		if(count > 0){
			return 0;
		}
		//更新
		Integer ret = adminDao.changeDepartmentInfo(department);
		//给该部门所有员工和经理发消息
		if(ret == 1){
			//查询该部门下的所有员工
			WorkMessage workMessage = new WorkMessage();
			workMessage.setSource_id(0);
			workMessage.setSource_queue("admin");
			workMessage.setType("系统消息");
			String time = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
			workMessage.setTime(time);
			workMessage.setContent("您好，您所在的部门在"+time+"被admin修改为'"+name+"',详情被修改为'"+info+"'。");
			List<User> userList = employDao.queryEmployByDepartmentId(did);
			if(userList != null && userList.size() > 0){
				for(User user:userList){
					workMessage.setDistince_id(user.getId());
					workMessage.setDistince_queue(user.getUsername());
					//发消息
					MessageSend.sendMessage(workMessage, user.getId(), user.getUsername());
				}
			}
		}
		return ret;
	}
	
	public Integer delUser(HttpServletRequest request,HttpServletResponse response){
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer ret = employDao.delManagerByDepartmentId(id);
		return ret;
		
	}
	@Resource(name="admindao")
	private AdminDao adminDao;
	@Resource(name="employdao")
	private EmployDao employDao;
}