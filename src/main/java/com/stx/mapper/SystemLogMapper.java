package com.stx.mapper;

import com.stx.pojo.SystemLogVO;

/**
 * 2018-03-22
 * @author LL
 *
 */
public interface SystemLogMapper {
	/**
	 * 查看表是否存在
	 * @param tableName
	 * @return
	 */
	public String existTable(String tableName);
	
	/**
	 * 删除一张日志表
	 * @param tableName
	 * @return
	 */
	public Integer dropTable(String tableName);
	
	/**
	 *  创建一张新的系统日志表
	 * @param tableName
	 * @return
	 */
	public Integer createNewTable(String tableName);
	
	/**
	 * 写日志
	 * @param systemLogVO
	 * @return
	 */
	public Integer insertSystemLog(SystemLogVO systemLogVO);
}
