package com.stx.dao;

import java.util.List;

import com.stx.pojo.Comment;
import com.stx.pojo.Custom;
import com.stx.pojo.Employ;
import com.stx.pojo.EmployLeave;
import com.stx.pojo.Log;
import com.stx.pojo.Work;
/**
 * 处理员工请假的dao
 * @author LL
 *	2018-04-02
 */
public interface EmployLeaveDao {
		
	/**
	 * insert 请假记录
	 * @param employLeave
	 * @return
	 */
	public Integer insertLeave(EmployLeave employLeave);
}
