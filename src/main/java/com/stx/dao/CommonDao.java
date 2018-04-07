package com.stx.dao;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.stx.pojo.Authority;
import com.stx.pojo.Menu;
import com.stx.pojo.User;

public interface CommonDao {
	//跳转首页，查询出所有权限
	public List<Authority> getAllAuthority();
	
	//登录检查employ和 manager用户名和密码是否正确
	public  int checkInputEmploy(User u);
	//登录检查custom用户名和密码是否正确
	public  int checkInputCustom(User u);
	
	//根据username查询authorityid,manager or employ
	public int getAuthorityId4Employ(String username);
	
	//根据username查authorityId，custom
	public int getAuthorityId4Custom(String username);
		
	//登录
	public void login(HttpServletRequest request,HttpServletResponse response);
	
	//登录时检查企业内的人username和password
	public User checkEmploy(User user);
	
	//登录时检查客户的username和password
	public User checkCustom(User user);
	
	//根据authorityid查询权限，并关联查询出菜单列表
	public Authority getAuthority(int authorityId);	
	
	//根据authorityid查询父菜单
	public List<Menu> getFMenuByAuthorityId(int authority_id);
	
	//根据menuId查询子Menu
	public List<Menu> getSonMenuByFatherId(int menuId);	
}
