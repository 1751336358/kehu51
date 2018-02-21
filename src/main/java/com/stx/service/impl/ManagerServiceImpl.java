package com.stx.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.stx.dao.ManagerDao;
import com.stx.dao.EmployDao;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;
import com.stx.pojo.Log;
import com.stx.pojo.Menu;
import com.stx.pojo.User;
import com.stx.pojo.Work;
import com.stx.pojo.page.Page;
import com.stx.service.ManagerService;

@Service("managerServices")
public class ManagerServiceImpl implements ManagerService{
	
	
	//根据父菜单id查询子菜单列表
	public List<Menu> getsonmenu(int idIndex){
		return managerDao.getsonmenu(idIndex);
	}
	
	//将添加的员工数据插入数据库
	public HttpServletRequest insertEmploy(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//查询数据库是否有同名employ		
		String username = request.getParameter("username");
		int count = managerDao.getUsername(username);
		
		//查询所有员工,根据当前登录的manager的id
		User u = (User)session.getAttribute("user");
		int userid = u.getId();
		//查dao
		List<Employ> employs = managerDao.getAllEmploy(userid);
		request.setAttribute("employs", employs);
		
		if(count != 0){
			return request;
		}
		String info = request.getParameter("info");
		System.out.println("username:"+username);
		System.out.println("info:"+info);
		//根据经理用户名名查询部门id
		User user = (User)session.getAttribute("user");
		int departmentId = managerDao.getDepartmentIdByUserName(user.getUsername());
		System.out.println("departmentid:"+departmentId);
		Employ employ = new Employ();
		employ.setUsername(username);
		employ.setInfo(info);
		employ.setDepartmentid(departmentId);
		managerDao.insertEmploy(employ);	
		return request;
	}
	
	//查询所有的员工
	public HttpServletRequest getAllEmploy(HttpServletRequest request,HttpServletResponse response){
		int userid = Integer.parseInt(request.getParameter("userid"));
		List<Employ> employs = managerDao.getAllEmploy(userid);
		request.setAttribute("employs",employs);
		return request;
	}
	//修改员工信息
	public  HttpServletRequest updateEmploy(HttpServletRequest request,HttpServletResponse response){
		int userid = Integer.parseInt(request.getParameter("userid"));
		Employ employ = employDao.selEmployById(userid);		
		//根据userid查询员工信息回显
		request.setAttribute("employ",employ);
		return request;
	}
	
	//根据departmentid查询部门信息
	public List<Department> getDepartment(HttpServletRequest request,HttpServletResponse response){
		return managerDao.getDepartment();
	}
	
	//将修改后的员工信息插入数据库
	public HttpServletRequest newEmploy(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String info = request.getParameter("info");
		int departmentid = Integer.parseInt(request.getParameter("departmentid"));
		//封装请求参数，调用dao存入数据库
		Employ employ = new Employ();
		employ.setId(id);
		employ.setUsername(username);
		employ.setInfo(info);
		employ.setDepartmentid(departmentid);
		managerDao.newEmploy(employ);
		//查询所有员工,根据当前登录的manager的id
		User u = (User)session.getAttribute("user");
		int userid = u.getId();
		//查dao
		List<Employ> employs = managerDao.getAllEmploy(userid);
		request.setAttribute("employs", employs);
		return request;
	}
	
	//删除员工，根据userid
	public HttpServletRequest deleteManager(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		int id = Integer.parseInt(request.getParameter("userid"));
		//删除dao
		managerDao.deleteManager(id);
		
		//查询所有员工,根据当前登录的manager的id
		User u = (User)session.getAttribute("user");
		int userid = u.getId();
		//查dao
		List<Employ> employs = managerDao.getAllEmploy(userid);
		request.setAttribute("employs", employs);
		return request;
	}
	//跳转到员工日志列表页面
	public HttpServletRequest getlogs(HttpServletRequest request,HttpServletResponse response){
		//查询出当前经理所有员工的前5条记录
		int userid = Integer.parseInt(request.getParameter("userid"));
		System.out.println("经理id:"+userid);
		int currentPage = 0;
		Page pageLog = new Page();
		pageLog.setManager_id(userid);	//根据经理id查询
		pageLog.setCurrentPage(currentPage);
		List<Log> logs = managerDao.getlogs(pageLog);
		request.setAttribute("logs",logs);
		return request;
	}
	// Ajax控制日志列表翻页
	public List<Log> getLogByPage(HttpServletRequest request,HttpServletResponse response){
		int userid = Integer.parseInt(request.getParameter("userid")); //经理id
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		Page pageLog = new Page();
		pageLog.setManager_id(userid);
		pageLog.setCurrentPage(currentPage*5);//5为页面尺寸
		return managerDao.getlogs(pageLog);
	}
	
	//查询日志详细信息
	public HttpServletRequest getLogDetail(HttpServletRequest request,HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));	//日志id
		System.out.println("日志id:"+id);
		//根据日志id查询发表日志的员工的username
		String username = managerDao.getUserNameByLogId(id);
		System.out.println("发表该日志的用户名是:"+username);
		request.setAttribute("username",username);
		
		//查询日志的详细信息,根据日志id
		Log log = managerDao.getLogById(id);
		request.setAttribute("log", log);
		return request;
	}
	
	//查询出最近5条考勤记录,根据userid(经理的id)查询
	public HttpServletRequest getWorks(HttpServletRequest request,HttpServletResponse response){
		int userid = Integer.parseInt(request.getParameter("userid"));
		Page page = new Page();
		page.setManager_id(userid);	//经理id
		page.setCurrentPage(0*10);	//当前页数
		List<Work> works = managerDao.getWorkByManagerId(page);
		request.setAttribute("works", works);
		return request;
	}
	// Ajax控制考勤列表翻页
	public List<Work> getWorkByPage(HttpServletRequest request,HttpServletResponse response){
		int userid = Integer.parseInt(request.getParameter("userid"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		Page page = new Page();
		page.setManager_id(userid);	//经理id
		page.setCurrentPage(currentPage*10);	//当前页数
		List<Work> works = managerDao.getWorkByManagerId(page);
		return works;
	}
	@Resource(name="managerdao")
	private ManagerDao managerDao;
	@Resource(name="employdao")
	private EmployDao employDao;
}
/*

insert into menu(name,url,authority_id,parent_id) values('签到','workstart',2,4);
insert into menu(name,url,authority_id,parent_id) values('签退','workend',2,4);
insert into menu(name,url,authority_id,parent_id) values('写日志','writelog',2,4);

*/