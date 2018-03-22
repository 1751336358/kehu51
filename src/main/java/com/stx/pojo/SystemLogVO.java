package com.stx.pojo;

import java.io.Serializable;

/**
 * 包装SystemLog
 * 2018-03-22
 * @author LL
 *
 */
public class SystemLogVO implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 构造方法
	 */
	public SystemLogVO() {
		super();
	}
	public SystemLogVO(SystemLog systemLog, String tableName) {
		super();
		this.systemLog = systemLog;
		this.tableName = tableName;
	}
	private SystemLog systemLog;
	/**
	 * 表名
	 */
	private String tableName;
	public SystemLog getSystemLog() {
		return systemLog;
	}
	public void setSystemLog(SystemLog systemLog) {
		this.systemLog = systemLog;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	@Override
	public String toString() {
		return "SystemLogVO [systemLog=" + systemLog + ", tableName=" + tableName + "]";
	}
	
}
