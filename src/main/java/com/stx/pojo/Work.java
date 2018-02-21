package com.stx.pojo;

import java.util.Date;

public class Work {
	private long id;				//主键
	private int employ_id;			//外键,签到人的id
	private String username;		//签到人名字
	private String day;				//签到日期 yyyy-MM-dd
	private boolean  workstart;		//是否签到	默认false
	private String workstart_time;	//签到具体时间
	private boolean workend;			//是否签退	默认false
	private String workend_time;		//签退具体时间
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getEmploy_id() {
		return employ_id;
	}
	public void setEmploy_id(int employId) {
		employ_id = employId;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public boolean isWorkstart() {
		return workstart;
	}
	public void setWorkstart(boolean workstart) {
		this.workstart = workstart;
	}
	
	public boolean isWorkend() {
		return workend;
	}
	public void setWorkend(boolean workend) {
		this.workend = workend;
	}
	public String getWorkend_time() {
		return workend_time;
	}
	public void setWorkend_time(String workendTime) {
		workend_time = workendTime;
	}
	public String getWorkstart_time() {
		return workstart_time;
	}
	public void setWorkstart_time(String workstartTime) {
		workstart_time = workstartTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
