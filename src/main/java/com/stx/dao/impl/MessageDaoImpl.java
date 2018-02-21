package com.stx.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.stx.dao.MessageDao;
import com.stx.pojo.WorkMessage;
import com.stx.utils.MessageSend;
import com.stx.utils.MessageSerializable;

import redis.clients.jedis.Jedis;
/**
 * 将消息存入redis的工具类
 * @author LL
 *	2018-02-16
 */
@Repository("messagedao")
public class MessageDaoImpl implements MessageDao {
	
	/**
	 * 将新发送的消息保存为已发消息,存入redis[2]中
	 */
	public void newMsg2HasSendMsg(Jedis jedis,int id,String username,WorkMessage workMessage){
		System.out.println("源id:"+workMessage.getSource_id());
		System.out.println("源queue:"+workMessage.getSource_queue());
		System.out.println("目标id:"+workMessage.getDistince_id());
		System.out.println("目标queue:"+workMessage.getDistince_queue());
		String key = id + "_" + username;
		System.out.println("key:"+key);
		jedis.select(2);
		jedis.lpush(key.getBytes(), MessageSerializable.serializable(workMessage));
	}
	
	/**
	 * 查询已发送消息
	 */
	public List<WorkMessage> queryHasSendMsg(Jedis jedis,int id,String username){
		jedis.select(2);
		String key = id+"_"+username;
		List<byte[]> msgByte = jedis.lrange(key.getBytes(),0, 100);
		if(msgByte==null || msgByte.size()==0){
			return null;
		}
		List<WorkMessage> listMessage = new ArrayList<WorkMessage>(0);
		for(byte []b:msgByte){
			WorkMessage workMessage = MessageSerializable.unSerializable(b);
			listMessage.add(workMessage);
		}
		return listMessage;
	}
	
	/**
	 * 日志标记已读  manager-->employ
	 * 2018-02-20
	 */
	public void tagHasBeenRead(WorkMessage workMessage){
		int id = workMessage.getDistince_id();
		String queueName = workMessage.getDistince_queue();
		MessageSend.sendMessage(workMessage, id, queueName);
	}
}
