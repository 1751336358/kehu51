package com.stx.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.AdminDao;
import com.stx.dao.CommonDao;
import com.stx.mapper.AdminMapper;
import com.stx.mapper.CommonMapper;
import com.stx.pojo.Authority;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;
import com.stx.pojo.Menu;
import com.stx.pojo.User;

@Repository("admindao")
public class AdminDaoImpl extends SqlSessionDaoSupport implements AdminDao{
	/**
	 * 判断部门名是否存在
	 * @param department
	 * @return
	 */
	public Integer departNameExist(Department department){
		return this.getSqlSession().getMapper(AdminMapper.class).departNameExist(department);
	}
	/**
	 * 添加部门
	 * @param department
	 * @return
	 */
	@Override
	public Integer addDepartment(Department department){
		return this.getSqlSession().getMapper(AdminMapper.class).addDepartment(department);
	}
	
	/**
	 * 查询所有部门
	 */
	@Override
	public List<Department> queryDepartment(){
		return this.getSqlSession().getMapper(AdminMapper.class).queryDepartment();
	}
	
	/**
	 * 删除部门
	 */
	@Override
	public Integer delDepartmentById(Integer id){
		return this.getSqlSession().getMapper(AdminMapper.class).delDepartmentById(id);
	}
	
	/**
	 * 查询部门员工
	 */
	public List<Employ> queryEmployByDepartmentId(Integer departmentId){
		return this.getSqlSession().getMapper(AdminMapper.class).queryEmployByDepartmentId(departmentId);
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}	
}
