package com.stx.pojo;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Administrator
 *	部门表
 */
public class Department {
	private int id;			//主键id
	private String name;	//部门名
	private String info;	//部门描述
	private List<Employ> employs = new ArrayList<Employ>();	//员工集合
	
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public List<Employ> getEmploys() {
		return employs;
	}
	public void setEmploys(List<Employ> employs) {
		this.employs = employs;
	}
	
	
}
