package com.stx.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.ManagerDao;
import com.stx.mapper.ManagerMapper;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;
import com.stx.pojo.Log;
import com.stx.pojo.Menu;
import com.stx.pojo.Work;
import com.stx.pojo.page.Page;

@Repository("managerdao")
public class ManagerDaoImpl extends SqlSessionDaoSupport implements ManagerDao{
	
	@Override
	//根据父菜单id查询子菜单列表
	public List<Menu> getsonmenu(int idIndex){
		return this.getSqlSession().getMapper(ManagerMapper.class).getsonmenu(idIndex);
	}
	
	//将添加的员工数据插入数据库
	public void insertEmploy(Employ employ){
		this.getSqlSession().getMapper(ManagerMapper.class).insertEmploy(employ);
	}
	
	//根据username查询department_id
	public int getDepartmentIdByUserName(String username){
		return this.getSqlSession().getMapper(ManagerMapper.class).getDepartmentIdByUserName(username);
	}
	
	//查询是否有相同的username
	public int getUsername(String username){
		return this.getSqlSession().getMapper(ManagerMapper.class).getUsername(username);
	}
	
	//根据经理的userid查询该部门下的所有员工
	public List<Employ> getAllEmploy(int userid){
		return this.getSqlSession().getMapper(ManagerMapper.class).getAllEmploy(userid);
	}
	
	//根据departmentid查询部门信息
	public List<Department> getDepartment(){
		return this.getSqlSession().getMapper(ManagerMapper.class).getDepartment();
	}
	
	//将新修改的员工信息存如数据库
	public void newEmploy(Employ employ){
		this.getSqlSession().getMapper(ManagerMapper.class).newEmploy(employ);
	}
	
	//删除员工
	public void deleteManager(int userId){
		this.getSqlSession().getMapper(ManagerMapper.class).deleteManager(userId);
	}
	
	//跳转到员工日志列表页面,查询出钱前5条日志
	public List<Log> getlogs(Page pageLog){
		return this.getSqlSession().getMapper(ManagerMapper.class).getlogs(pageLog);
	}
	
	//根据日志id查询出发表日志的员工的username
	public String getUserNameByLogId(int id){
		return this.getSqlSession().getMapper(ManagerMapper.class).getUserNameByLogId(id);
	}
	
	//根据日志id查询日志详细信息
	public Log getLogById(int id){
		return this.getSqlSession().getMapper(ManagerMapper.class).getLogById(id);
	}
	
	//经理查询考勤状况,parameterType:经理id ,按id降序
	public List<Work> getWorkByManagerId(Page page){
		return this.getSqlSession().getMapper(ManagerMapper.class).getWorkByManagerId(page);
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}		
}
