package com.stx.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *	权限表
 */
public class Authority {
	private int id;		//主键id
	private String name;//权限名
	private List<Menu>  menus = new ArrayList<Menu>();	//菜单
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}	
}
