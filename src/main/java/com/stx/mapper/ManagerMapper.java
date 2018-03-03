package com.stx.mapper;

import java.util.List;

import com.stx.pojo.Department;
import com.stx.pojo.Employ;
import com.stx.pojo.Log;
import com.stx.pojo.Menu;
import com.stx.pojo.Work;
import com.stx.pojo.page.Page;




public interface ManagerMapper {
	//根据父菜单id查询子菜单列表
		public List<Menu> getsonmenu(int idIndex);
		
		//将添加的员工数据插入数据库
		public void insertEmploy(Employ employ);
		
		//根据username查询department_id
		public int getDepartmentIdByUserName(String username);
		
		//查询是否有相同的username
		public int getUsername(String username);
		
		//根据经理的userid查询该部门下的所有员工
		public List<Employ> getAllEmploy(int userid);
		
		//查询部门信息关联查询所有员工信息
		public List<Department> getDepartment();
		
		//根据deartmentid查询部门下的所有员工信息,不包括经理
		public List<Employ>queryEmployByDepartmentIdIngoreManager(int departmentId);
		
		//将新修改的员工信息存如数据库
		public void newEmploy(Employ employ);
		
		//删除员工
		public void deleteManager(int userId);
		
		//查询出前5条记录
		public List<Log> getlogs(Page pageLog);
		
		//根据日志id查询出发表日志的员工的username
		public String getUserNameByLogId(int id);
		
		//根据日志id查询日志详细信息
		public Log getLogById(int id);
		
		//经理查询考勤状况,parameterType:经理id ,按id降序
		public List<Work> getWorkByManagerId(Page page);
}
