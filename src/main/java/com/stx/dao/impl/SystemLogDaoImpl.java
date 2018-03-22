package com.stx.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.stx.dao.SystemLogDao;
import com.stx.mapper.SystemLogMapper;
import com.stx.pojo.SystemLogVO;

@Repository("systemlogdao")
public class SystemLogDaoImpl extends SqlSessionDaoSupport implements SystemLogDao{
	/**
	 * 查看表是否存在
	 * @param tableName
	 * @return
	 */
	@Override
	public String existTable(String tableName){
		return this.getSqlSession().getMapper(SystemLogMapper.class).existTable(tableName);
	}
	
	/**
	 * 删除一张日志表
	 * @param tableName
	 * @return
	 */
	@Override
	public Integer dropTable(String tableName){
		return this.getSqlSession().getMapper(SystemLogMapper.class).dropTable(tableName);
	}
	
	/**
	 *  创建一张新的系统日志表
	 * @param tableName
	 * @return
	 */
	@Override
	public Integer createNewTable(String tableName){
		return this.getSqlSession().getMapper(SystemLogMapper.class).createNewTable(tableName);
	}
	
	/**
	 * 写日志
	 * @param systemLogVO
	 * @return
	 */
	@Override
	public Integer insertSystemLog(SystemLogVO systemLogVO){
		return this.getSqlSession().getMapper(SystemLogMapper.class).insertSystemLog(systemLogVO);
	}
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
