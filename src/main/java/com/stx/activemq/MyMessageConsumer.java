package com.stx.activemq;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.stx.pojo.WorkMessage;
import com.stx.utils.IpService;

/**
 * 消息消费者
 */
public class MyMessageConsumer {
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
		//Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);	//开启事物
		//5.创建一个目标
		Destination destination = session.createQueue("manager2");
		//6.创建一个消费者
		MessageConsumer messageConsumer = session.createConsumer(destination);
		List<WorkMessage> messageList = new ArrayList<WorkMessage>(0);
		ObjectMessage objMsg;
		//循环获取消息
		while(true){
			System.out.println("消息循环中");			
			try {
				/**
				 * 获取消息，如果没有消息，receive()会阻塞，receiveNoWait()不会阻塞
				 */
				objMsg = (ObjectMessage)messageConsumer.receiveNoWait();
				if(objMsg == null){
					System.out.println("消息获取完成");
					break;
				}else{
					System.out.println("消息不为空,继续获取消息");
				}
				WorkMessage workMessage = (WorkMessage)objMsg.getObject();
				messageList.add(workMessage);
			} catch (JMSException e) {
				throw new RuntimeException("消息获取失败");
			}
			
		}

		
		//8.关闭连接,设置监听器后就不要将连接关掉，因为要时刻监听生产者
		session.close();
		connection.close();
	}
}