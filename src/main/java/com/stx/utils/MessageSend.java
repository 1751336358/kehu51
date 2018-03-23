package com.stx.utils;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.stx.pojo.WorkMessage;

/**
 * 消息生产者
 * 2018-02-14
 */
public class MessageSend {
	
	//目标队列名字id_queueName
	public static  void sendMessage(WorkMessage workMessage,int id,String queueName) throws RuntimeException{
		
		ActiveMQConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session activeSession = null;
		Destination destination = null;
		MessageProducer messageProducer = null;
		ObjectMessage obgMsg = null;
		//1.创建ConnectionFactory工厂
		connectionFactory= new ActiveMQConnectionFactory(IpService.ACTIVE_MQ_IP);
		connectionFactory.setTrustAllPackages(true);//可以序列化对象
		try {
			//2.创建连接
			connection = connectionFactory.createConnection();			
			//3.启动连接
			connection.start();			
		} catch (JMSException e) {
			System.out.println("activemq连接创建失败");
			throw new RuntimeException("activemq连接创建失败");
		}
		
		try {
			//4.创建会话:参数1:是否使用事物，参数2:应答模式，自动应答
			activeSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//5.创建一个目标
			destination = activeSession.createQueue(id+"_"+queueName);
			//6.创建一个生产者
			messageProducer = activeSession.createProducer(destination);
		} catch (JMSException e) {
			System.out.println("session、distination、messageProducer创建失败");
			throw new RuntimeException("session、distination、messageProducer创建失败");
		}				
		try {
			//7.创建消息
			obgMsg = activeSession.createObjectMessage(workMessage);
			//8.发送消息，这里改为后台线程发送
			
			messageProducer.send(obgMsg);
		} catch (JMSException e) {
			throw new RuntimeException("消息发送失败");
		}				
		try {
			//9.关闭连接,此链接信息可以在activemq的web管理界面看到
			activeSession.close();
			connection.close();			
		} catch (JMSException e) {
			System.out.println("activemq连接释放失败");
			throw new RuntimeException("activemq连接释放失败");
		}
	}
}