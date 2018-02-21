package com.stx.utils;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.stx.pojo.WorkMessage;

/**
 * 消息消费者
 * @author LL
 *	2018-02-14
 */
public class MessageReceive {
	public static List<WorkMessage> recieve(int id,String queueName) {
		
		ActiveMQConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session activeSession = null;
		Destination destination = null;
		MessageConsumer messageConsumer = null;
		List<WorkMessage> messageList = null;//存放消息的容器
		
		try {
			//1.创建ConnectionFactory工厂
			connectionFactory = new ActiveMQConnectionFactory(IpService.ACTIVE_MQ_IP);
			connectionFactory.setTrustAllPackages(true);//可以序列化对象
			//2.创建连接
			connection = connectionFactory.createConnection();
			//3.启动连接
			connection.start();
		} catch (JMSException e) {
			throw new RuntimeException("activemq创建连接失败");
		}
		
		try {
			//4.创建会话:参数1:是否使用事物，参数2:应答模式，自动应答
			activeSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);	//开启事物
			//5.创建一个目标
			destination = activeSession.createQueue(id+"_"+queueName);
			//6.创建一个消费者
			messageConsumer = activeSession.createConsumer(destination);
		} catch (JMSException e) {
			throw new RuntimeException("session、destination、messageConsumer创建失败");
		}
			
		messageList = new ArrayList<WorkMessage>(0);
		ObjectMessage objMsg;
		//循环获取消息
		while(true){		
			try {
				objMsg = (ObjectMessage)messageConsumer.receiveNoWait();
				if(objMsg == null){
					System.out.println("消息获取完成");
					break;
				}else{
					System.out.println("消息不为空,继续获取消息");
					WorkMessage workMessage = (WorkMessage)objMsg.getObject();
					messageList.add(workMessage);
				}				
			} catch (JMSException e) {
				throw new RuntimeException("消息获取失败");
			}
			
		}

		try {
			//8.关闭连接,设置监听器后就不要将连接关掉，因为要时刻监听生产者
			activeSession.close();
			connection.close();
		} catch (JMSException e) {
			throw new RuntimeException("activemq关闭连接失败");
		}
		//历史消息入库
		
		return messageList;
	}
}
