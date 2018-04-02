package com.stx.pojo;

import java.io.Serializable;

/**
 * 员工请假表
 * @author LL
 *
 */
public class EmployLeave implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;	//主键id
	private String startTime;	//请假开始时间  yyyy-MM-dd
	private String endTime;		//请假结束时间	yyyy-MM-dd
	private Integer employId;	//员工id
	private String employName;	//员工name
	private String commitTime;	//请假消息产生时间	yyyy-MM-dd hh:mm:ss
	private String dealTime;	//请假消息被处理时间	yyyy-MM-dd hh:mm:ss
	private boolean status;		//是否同意请假,true/false
	private String leaveReason;	//请假理由
	private String unapproved;	//未批准理由
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getEmployId() {
		return employId;
	}
	public void setEmployId(Integer employId) {
		this.employId = employId;
	}
	public String getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(String commitTime) {
		this.commitTime = commitTime;
	}
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getEmployName() {
		return employName;
	}
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getUnapproved() {
		return unapproved;
	}
	public void setUnapproved(String unapproved) {
		this.unapproved = unapproved;
	}
}
/*
  CREATE TABLE `employ_leave` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `start_time` char(20) DEFAULT NULL COMMENT '请假开始时间  yyyy-MM-dd',
  `end_time` char(20) DEFAULT NULL COMMENT '请假结束时间 yyyy_MM-dd',
  `employ_id` int(11) DEFAULT NULL COMMENT '请假员工的id',
  `commit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '请假消息产生时间',
  `deal_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '请假消息被处理时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '是否同意请假 true/false',
  `employ_name` varchar(30) DEFAULT NULL COMMENT '员工名',
  `leave_reason` varchar(2048) DEFAULT '' COMMENT '请假理由',
  `unapproved` varchar(2048) DEFAULT '' COMMENT '未批准理由',
  PRIMARY KEY (`id`),
  KEY `employ_id` (`employ_id`),
  CONSTRAINT `employ_leave_ibfk_1` FOREIGN KEY (`employ_id`) REFERENCES `employ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk COMMENT='员工请假表'
 */
