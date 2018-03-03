package com.stx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stx.pojo.Department;
import com.stx.pojo.Employ;
import com.stx.pojo.Log;
import com.stx.pojo.Menu;
import com.stx.pojo.Work;
import com.stx.service.ManagerService;

/**
 * 
 * @author Administrator
 *	与manager相关的控制器
 */
@RestController("managerController")
public class ManagerController {
	
	
	/**
	 * 根据父菜单id查询子菜单id
	 */
	@RequestMapping("/getsonmenu/{inIndex}")
	public @ResponseBody List<Menu> getsonmenu(@PathVariable("inIndex")int idIndex){
		return managerService.getsonmenu(idIndex);
	}
	
	/**
	 * 跳转到添加员工页面
	 */
	@RequestMapping("/addemploy")
	public void addManager(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/manager/addemploy.jsp").forward(request, response);
		} catch (Exception e) {
		} 
	}
	/**
	 * 将添加的员工数据插入数据库
	 */
	@RequestMapping("/insertemploy")
	public void insertEmploy(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		request = managerService.insertEmploy(request, response,session);
		//后跳转到查询员工类表页
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/manager/getallemploy.jsp").forward(request, response);
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * 删除员工
	 */
	@RequestMapping("/delemploy")
	public @ResponseBody void deleteManager(HttpServletRequest request,HttpServletResponse response,HttpSession session){	
		request = managerService.deleteManager(request, response,session);
		//后跳转到查询员工类表页
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/manager/getallemploy.jsp").forward(request, response);
		} catch (Exception e) {
			
		} 
	}
	
	
	/**
	 * 跳转到修改员工信息页面
	 */
	@RequestMapping("/updateemploy")
	public  void updateEmploy(HttpServletRequest request,HttpServletResponse response){	
		request = managerService.updateEmploy(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/manager/employdetail.jsp").forward(request, response);
		} catch (Exception e) {			
		} 
	}
	/**
	 * 将修改后的员工信息插入数据库
	 */
	@RequestMapping("/newemploy")
	public void newEmploy(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		request = managerService.newEmploy(request, response,session);
		//后跳转到查询员工类表页
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/manager/getallemploy.jsp").forward(request, response);
		} catch (Exception e) {
			
		} 
	}
	
	//根据部门id查询部门信息
	@RequestMapping("/getDepartment")
	public @ResponseBody List<Department> getDepartment(HttpServletRequest request,HttpServletResponse response){
		return managerService.getDepartment(request,response);
	}
	/**
	 * 跳转到员工列表页面
	 */
	@RequestMapping("/getallemploy")
	public void getAllEmploy(HttpServletRequest request,HttpServletResponse response){
		request = managerService.getAllEmploy(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/manager/getallemploy.jsp").forward(request, response);
		} catch (Exception e) {
		} 
	}
	/*
	 * 跳转到员工日志列表页面
	 */
	@RequestMapping("/getlogs")
	public void getlogs(HttpServletRequest request,HttpServletResponse response){
		request = managerService.getlogs(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/manager/getlogs.jsp").forward(request, response);
		} catch (Exception e) {
		} 
	}	
	/**
	 * Ajax控制日志列表翻页
	 */
	@RequestMapping("/getlogbypage")
	public @ResponseBody List<Log> getLogByPage(HttpServletRequest request,HttpServletResponse response){
		return managerService.getLogByPage(request, response);
	}
	
	/**
	 * 跳转到日志详细信息页面
	 */
	@RequestMapping("/getlogdetail")
	public void getLogDetail(HttpServletRequest request,HttpServletResponse response){
		request = managerService.getLogDetail(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/manager/getlogdetail.jsp").forward(request, response);
		} catch (Exception e) {			
		} 
	}
	/**
	 * 跳转到考情管理页面
	 */
	@RequestMapping("/getworks")
	public void getWorks(HttpServletRequest request,HttpServletResponse response){
		request = managerService.getWorks(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/manager/getworks.jsp").forward(request, response);
		} catch (Exception e) {			
		} 
	}
	/**
	 * Ajax查看考勤列表分页
	 */
	@RequestMapping("/getworkbypage")
	public @ResponseBody List<Work> getWorkByPage(HttpServletRequest request,HttpServletResponse response){
		return managerService.getWorkByPage(request, response);
	}
	
	
	@Resource(name="managerServices")
	private ManagerService managerService;
}
