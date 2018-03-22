package com.stx.service;

import com.stx.pojo.SystemLog;
import com.stx.pojo.SystemLogVO;

/**
 * 记录系统日志
 * @author LL
 *	2018-03-22
 */
public interface SystemLogService {
	/**
	 * 同意处理日志的方法
	 * @param systemLog
	 * @return
	 */
	public void dealWithSystemLog(SystemLog systemLog) throws Exception;
	
}
