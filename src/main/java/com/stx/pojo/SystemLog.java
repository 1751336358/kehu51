package com.stx.pojo;

import java.io.Serializable;

/**
 * 记录系统日志
 * 2018-03-22
 * @author LL
 *
 */
public class SystemLog implements Serializable{
	/**
	 * 构造函数
	 * @param methodName
	 * @param className
	 * @param operTime
	 */
	public SystemLog() {
		super();
	}
	public SystemLog(String methodName, String className, String operTime) {
		super();
		this.methodName = methodName;
		this.className = className;
		this.operTime = operTime;
	}
	
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 调用的方法
	 */
	private String methodName;
	/**
	 * 调用的类 全限定名
	 */
	private String className;
	/**
	 * 操作时间
	 */
	private String operTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getOperTime() {
		return operTime;
	}
	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}
	@Override
	public String toString() {
		return "SystemLog [methodName=" + methodName + ", className=" + className + ", operTime=" + operTime + "]";
	}
	
	
}
