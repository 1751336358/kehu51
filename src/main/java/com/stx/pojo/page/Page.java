package com.stx.pojo.page;
/**
 * 
 * @author Administrator
 *	封装分页
 */
public class Page {
	private int employ_id;	//员工id
	private int manager_id;		//经理id
	private int currentPage;	//当前页数
	
	
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int managerId) {
		manager_id = managerId;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getEmploy_id() {
		return employ_id;
	}
	public void setEmploy_id(int employId) {
		employ_id = employId;
	}
	
}
