package com.stx.pojo;

public class User{
	private int id;				//主键id	
	private String username;	//用户名
	private String password;	//密码
	private String path;		//用户头像所在路径
	private Authority authority;	//权限属性
	
	public User() {
		super();
		
	}

	public User(String username, String password) {
		super();
	
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
