package com.stx.pojo;
/**
 * 
 * @author Administrator
 *	菜单表
 */
public class Menu {
	private int id;			//主键id
	private String name;	//菜单名
	private String url;		//链接
	private int authority_id;	//权限id
	private int parent_id;		//父菜单id
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(int authorityId) {
		authority_id = authorityId;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parentId) {
		parent_id = parentId;
	}	
	
}
