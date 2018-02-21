package com.stx.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stx.pojo.WorkMessage;
import com.stx.service.MessageService;



@RestController
public class MessageController {

	/**
	 * 员工申请补卡
	 */
	@RequestMapping("/appealBuka")
	public @ResponseBody boolean appealBuka(HttpServletRequest request,HttpServletResponse response){
		boolean isOk = false;
		try {
			isOk = messageService.appealBuka(request, response);
		} catch (Exception e) {
			
		}
		return isOk;
	}
	
	/**
	 * 最新消息
	 */
	@RequestMapping("/queryNewMessage")
	public @ResponseBody List<WorkMessage> queryNewMessage(HttpServletRequest request,HttpServletResponse response){
		List<WorkMessage> listMessage = messageService.queryNewMessage(request, response);
		return listMessage;
	}
	
	/**
	 * 查询已发消息
	 */
	@RequestMapping("/queryHasSendMsg")
	public List<WorkMessage> queryHasSendMsg(HttpServletRequest request,HttpServletResponse response){
		return messageService.queryHasSendMsg(request, response);
	}
	
	/**
	 * 日志标记已读  manager-->employ
	 * 2018-02-20
	 */
	@RequestMapping("/tagHasBeenRead")
	public String tagHasBeenRead(HttpServletRequest request,HttpServletResponse response){
		boolean b = messageService.tagHasBeenRead(request, response);
		String message = "";
		if(b){
			message = "已标记，消息发送成功";
		}else{
			message = "系统出错，日志标记失败，消息未发送成功";
		}
		return message;
	}
	
	/**
	 * 批量发送消息 manager-->employ
	 * 2018-02-20
	 */
	@RequestMapping("/batSendMessage")
	public String batSendMessage(HttpServletRequest request,HttpServletResponse response){
		boolean b = messageService.batSendMessage(request, response);
		String message = "";
		if(b){
			message = "消息发送成功";
		}else{
			message = "由于系统原因消息发送失败";
		}
		return message;
	}
	
	/**
	 * manager处理employ的补卡信息
	 * 同意/不同意补卡签到
	 * 2018-08-21
	 */
	@RequestMapping("/aggreeLogin")
	public void aggreeLogin(HttpServletRequest request,HttpServletResponse response){
		messageService.aggreeLogin(request, response);
	}
	/**
	 * manager处理employ的补卡信息
	 * 同意/不同意补卡签退
	 * 2018-08-21
	 */
	@RequestMapping("/aggreeLogout")
	public void aggreeLogout(HttpServletRequest request,HttpServletResponse response){
		messageService.aggreeLogout(request, response);
	}
	
	@Resource(name="messageServices")
	private MessageService messageService;
}
