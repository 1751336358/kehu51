package com.stx.pojo;
/**
 * 
 * @author Administrator
 *	评论表
 */
public class Comment {
	private int id;
	private String username;	//客户用户名
	private String content;		//评论内容
	private int employ_id;		//员工id
	private int custom_id;		//客户id
	private String commenttime;	//评论时间
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getEmploy_id() {
		return employ_id;
	}
	public void setEmploy_id(int employId) {
		employ_id = employId;
	}
	public int getCustom_id() {
		return custom_id;
	}
	public void setCustom_id(int customId) {
		custom_id = customId;
	}
	public String getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}
	
}
