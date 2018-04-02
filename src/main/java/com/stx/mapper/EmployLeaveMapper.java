package com.stx.mapper;

import java.util.List;

import com.stx.pojo.EmployLeave;
/**
 *  处理员工请假
 * @author LL
 *	2018-04-02
 */
public interface EmployLeaveMapper {
	/**
	 * 插入一条请假记录
	 * 插入一个数据持久化对象(插入字段为传入PO实体的非空属性)
	 */
	public Integer insert(EmployLeave employLeave);
	/**
	 * 查询请假记录——通用
	 */
	public List<EmployLeave> list(EmployLeave employLeave);
	
	/**
	 * 根据主键修改数据持久化对
	 */
	public Integer updateByKey(EmployLeave employLeave);
}
