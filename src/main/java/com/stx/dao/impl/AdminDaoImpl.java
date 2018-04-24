package com.stx.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.AdminDao;
import com.stx.mapper.AdminMapper;
import com.stx.pojo.Custom;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;

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
	 * 修改部门名时判断部门名是否存在
	 */
	@Override
	public Integer updateDepartmentExist(Department department){
		return this.getSqlSession().getMapper(AdminMapper.class).updateDepartmentExist(department);
	}
	/**
	 * 修改部门
	 */
	@Override
	public Integer changeDepartmentInfo(Department department){
		return this.getSqlSession().getMapper(AdminMapper.class).changeDepartmentInfo(department);
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
	
	/**
	 * 修改employ状态
	 * @param request
	 * @param response
	 */
	public Integer open(Employ employ){
		return this.getSqlSession().getMapper(AdminMapper.class).open(employ);
	}
	
	/**
	 * 修改custom状态
	 * @param request
	 * @param response
	 */
	public Integer openCustom(Custom custom){
		return this.getSqlSession().getMapper(AdminMapper.class).openCustom(custom);
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}	
}
