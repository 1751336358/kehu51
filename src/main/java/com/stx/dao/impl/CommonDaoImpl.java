package com.stx.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.CommonDao;
import com.stx.mapper.CommonMapper;
import com.stx.pojo.Authority;
import com.stx.pojo.User;

@Repository("commondao")
public class CommonDaoImpl extends SqlSessionDaoSupport implements CommonDao{
	//跳转首页，查询出所有权限
	@Override
	public List<Authority> getAllAuthority() {
		return this.getSqlSession().getMapper(CommonMapper.class).getAllAuthority();
	}
	
	//登录
	@Override
	public void login(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	//检查username和password
	public User checkEmploy(User user){
		return this.getSqlSession().getMapper(CommonMapper.class).checkEmploy(user);

	}
	//登录时检查客户的username和password
	public User checkCustom(User user){
		return this.getSqlSession().getMapper(CommonMapper.class).checkCustom(user);
	}
	
	//根据authorityid查询权限，并关联查询出菜单列表
	public Authority getAuthority(int authorityId){
		return this.getSqlSession().getMapper(CommonMapper.class).getAuthority(authorityId);
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	
}
