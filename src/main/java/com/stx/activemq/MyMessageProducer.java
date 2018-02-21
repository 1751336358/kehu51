package com.stx.activemq;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.stx.utils.IpService;

/**
 * 消息生产者
 */
public class MyMessageProducer {
	//队列名字
	public static final String queueName = "queue-test1";
	public static void main(String[] args) throws Exception {
		//1.创建ConnectionFactory工厂
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(IpService.ACTIVE_MQ_IP);
		connectionFactory.setTrustAllPackages(true);//可以序列化对象
		//2.创建连接
		Connection connection = connectionFactory.createConnection();
		//3.启动连接
		connection.start();
		//4.创建会话:参数1:是否使用事物，参数2:应答模式，自动应答
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5.创建一个目标
		Destination destination = session.createQueue(queueName);
		//6.创建一个生产者
		MessageProducer messageProducer = session.createProducer(destination);
		for(int i = 0;i<50;i++){
			//7.创建消息
			TextMessage textMessage = session.createTextMessage("sssssss"+i);
			//8.发送消息
			messageProducer.send(textMessage);
		}
		//9.关闭连接,此链接信息可以在activemq的web管理界面看到
		session.close();
		connection.close();
	}
}