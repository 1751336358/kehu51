package com.stx.pojo;

import java.sql.Clob;

public class Log {
	private long id;			//主键id
	private String title;		//日志标题
	private String content;		//日志内容
	private String committime;	//提交时间
	private int employ_id;		//发送者id,外键
	private String username;	//发送者名字
	private int manager_id;		//经理id
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommittime() {
		return committime;
	}
	public void setCommittime(String committime) {
		this.committime = committime;
	}
	public int getEmploy_id() {
		return employ_id;
	}
	public void setEmploy_id(int employId) {
		employ_id = employId;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int managerId) {
		manager_id = managerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}