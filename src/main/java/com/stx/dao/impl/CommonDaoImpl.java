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
import com.stx.pojo.Menu;
import com.stx.pojo.User;

@Repository("commondao")
public class CommonDaoImpl extends SqlSessionDaoSupport implements CommonDao{
	//跳转首页，查询出所有权限
	@Override
	public List<Authority> getAllAuthority() {
		return this.getSqlSession().getMapper(CommonMapper.class).getAllAuthority();
	}
	//登录检查employ或manager用户名和密码是否正确
	public  int checkInputEmploy(User u){
		return this.getSqlSession().getMapper(CommonMapper.class).checkInputEmploy(u);
	}
	
	//登录检查employ或manager用户名和密码是否正确
	public  int checkInputCustom(User u){
		return this.getSqlSession().getMapper(CommonMapper.class).checkInputCustom(u);
	}
	
	//根据username查询authorityid,manager or employ
	public int getAuthorityId4Employ(String username){
		return this.getSqlSession().getMapper(CommonMapper.class).getAuthorityId4Employ(username);
	}
	
	//根据username查authorityId，custom
	public int getAuthorityId4Custom(String username){
		return this.getSqlSession().getMapper(CommonMapper.class).getAuthorityId4Custom(username);
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
	
	//根据authorityid查询父菜单
	public List<Menu> getFMenuByAuthorityId(int authority_id){
		return this.getSqlSession().getMapper(CommonMapper.class).getFMenuByAuthorityId(authority_id);
	}
	
	//根据menuId查询子Menu
	public List<Menu> getSonMenuByFatherId(int menuId){
		return this.getSqlSession().getMapper(CommonMapper.class).getSonMenuByFatherId(menuId);
	}
	
	/**
	 * 判断employ是否被禁用
	 * @param u
	 * @return
	 */
	public Integer isOpen(User u){
		return this.getSqlSession().getMapper(CommonMapper.class).isOpen(u);
	}
	
	/**
	 * 判断employ是否被禁用
	 * @param u
	 * @return
	 */
	public Integer isOpen4Custom(User u){
		return this.getSqlSession().getMapper(CommonMapper.class).isOpen4Custom(u);
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	
}
