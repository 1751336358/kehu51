package com.stx.thread;

import com.stx.pojo.WorkMessage;
import com.stx.utils.MessageSend;

public class MessageSendThread implements Runnable{
	private WorkMessage workMessage;
	private int id;
	private String username;
	public MessageSendThread(WorkMessage workMessage,int id,String username){
		this.workMessage = workMessage;
		this.id = id;
		this.username = username;
	}
	
	@Override
	public void run() {
		try{
			MessageSend.sendMessage(workMessage, id, username);
		}catch(Exception e){
			System.out.println("多线程中消息发送失败");
			return;
		}
	}

}
