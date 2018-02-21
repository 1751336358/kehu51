package com.stx.mapper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.pojo.Authority;
import com.stx.pojo.User;
public interface CommonMapper {
	//跳转首页，查询出所有权限
	public List<Authority> getAllAuthority();
	
	//登录时检查员工内部人员的username和password
	public User checkEmploy(User user);
	
	//登录时检查客户的username和password
	public User checkCustom(User user);
	
	//根据authorityid查询权限，并关联查询出菜单列表
	public Authority getAuthority(int authorityId);
}
