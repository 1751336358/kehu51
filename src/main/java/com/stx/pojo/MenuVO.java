package com.stx.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 为了适应树形目录模板，这里包装一下com.stx.pojo.Menu
 * @author LL
 *
 */
public class MenuVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 父目录
	 */
	private Menu fMenu;
	/**
	 * 子目录
	 */
	private List<Menu> sMenu;
	public Menu getfMenu() {
		return fMenu;
	}
	public void setfMenu(Menu fMenu) {
		this.fMenu = fMenu;
	}
	public List<Menu> getsMenu() {
		return sMenu;
	}
	public void setsMenu(List<Menu> sMenu) {
		this.sMenu = sMenu;
	}
	
}
