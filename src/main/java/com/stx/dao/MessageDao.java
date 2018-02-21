package com.stx.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.pojo.WorkMessage;

import redis.clients.jedis.Jedis;
/**
 * 
 * @author LL
 *	操作redis中的消息
 *	2018-02-17
 */
public interface MessageDao {
	
	/**
	 * 将新发送的消息保存为已发消息,存入redis[2]中
	 */
	public void newMsg2HasSendMsg(Jedis jedis,int id,String username,WorkMessage workMessage);
	
	/**
	 * 查询已发送消息
	 */
	public List<WorkMessage> queryHasSendMsg(Jedis jedis,int id,String username);
	
	/**
	 * 日志标记已读  manager-->employ
	 * 2018-02-20
	 */
	public void tagHasBeenRead(WorkMessage workMessage);
	
}