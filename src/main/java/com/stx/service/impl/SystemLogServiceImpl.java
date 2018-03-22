package com.stx.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stx.dao.SystemLogDao;
import com.stx.pojo.SystemLog;
import com.stx.pojo.SystemLogVO;
import com.stx.service.SystemLogService;

/**
 * 记录系统日志
 * @author LL
 *	2018-03-22
 */
@Service("systemLogServices")
public class SystemLogServiceImpl implements SystemLogService{
	/**
	 * 统一处理日志的方法
	 * @param systemLog
	 * @return
	 */
	@Override
	public void dealWithSystemLog(SystemLog systemLog) throws Exception{
		//今天的表名systemlog_yyyyMMdd
		String tableName = this.getTableName();
		//	1、判断表名知否存在
		String exisTable = systemLogDao.existTable(tableName);
		//	表不存在，新建表
		if(exisTable == null){
			try{
				systemLogDao.createNewTable(tableName);
			}catch(Exception e){
				throw new Exception("create table "+tableName+" is failed");
			}
		}
		// 2、写入日志，用SystemLogVO包装SystemLog
		SystemLogVO systemLogVO = new SystemLogVO(systemLog,tableName);
		try{
			systemLogDao.insertSystemLog(systemLogVO);
		}catch(Exception e){
			throw new Exception("insert systemLog is failed: "+systemLogVO);
		}
	}
	
	/**
	 * 得到今天的表名 systemlog_yyyyMMdd
	 * @return
	 */
	private String getTableName(){
		StringBuffer tableName = new StringBuffer("systemlog_");
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		tableName = tableName.append(date);
		return tableName.toString();
	}
	@Resource(name="systemlogdao")
	private SystemLogDao systemLogDao;
	
}
