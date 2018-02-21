package com.stx.pojo;
/**
 * 
 * @author Administrator
 *	员工
 */
public class Employ extends User{
	
	public Employ() {
		super();
	}
	public Employ(String username, String password) {
		super(username, password);
	}
	/*	private int id;				//主键id
	private String username;	//用户名
	private String password;	//密码*/
	private String info;		//信息
	private String queuename;	//消息队列名字
	private int departmentid;	//部门id
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getQueuename() {
		return queuename;
	}
	public void setQueuename(String queuename) {
		this.queuename = queuename;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
}
