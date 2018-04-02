package com.stx.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.EmployLeaveDao;
import com.stx.mapper.EmployLeaveMapper;
import com.stx.pojo.EmployLeave;

@Repository("employleavedao")
public class EmployLeaveDaoImpl extends SqlSessionDaoSupport implements EmployLeaveDao{
	/**
	 * insert 请假记录
	 */
	@Override
	public Integer insertLeave(EmployLeave employLeave) {
		Integer ret = 0;
		ret = this.getSqlSession().getMapper(EmployLeaveMapper.class).insert(employLeave);
		return ret;
	}	
		
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}	
}
