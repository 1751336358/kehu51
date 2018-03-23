package com.stx.thread;

import com.stx.pojo.SystemLog;
import com.stx.service.SystemLogService;
/**
 * 插入日志的线程
 * @author LL
 *	2018-03-23
 */
public class SystemLogThread implements Runnable{
	private SystemLogService systemLogService;
	private SystemLog systemLog;
	public SystemLogThread(SystemLogService systemLogService,SystemLog systemLog){
		this.systemLogService = systemLogService;
		this.systemLog = systemLog;
	}
	@Override
	public void run() {
		try {
			this.systemLogService.dealWithSystemLog(systemLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
