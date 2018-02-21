package com.stx.pojo;

import java.util.Date;

/**
 * 
 * @author Administrator
 * 客户表
 */
public class Custom extends User{
	
	public Custom() {
		
	}
	public Custom(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	/*	private int id;				//主键id	
	private String username;	//用户名
	private String password;	//密码*/
	private String phoneNumber;	//手机号
	private String email;		//邮箱
	private String birthday;		//生日
	private String registerTime;	//注册时间
	private String queueName;	//消息队列名称
	private Employ employ;		//所属的客户
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public String getQueueName() {
		return queueName;
	}
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	public Employ getEmploy() {
		return employ;
	}
	public void setEmploy(Employ employ) {
		this.employ = employ;
	}
}