package com.stx.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stx.pojo.WorkMessage;

public interface MessageService {
	/**
	 * 员工申请补卡
	 * 2018-02-14
	 */
	public boolean appealBuka(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	/**
	 * 最新消息
	 * 2018-02-15
	 */
	public List<WorkMessage> queryNewMessage(HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 查询已发送消息
	 */
	public List<WorkMessage> queryHasSendMsg(HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 日志标记已读  manager-->employ
	 * 2018-02-20
	 */
	public boolean tagHasBeenRead(HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 批量发送消息 manager-->employ
	 * 2018-02-20
	 */
	public boolean batSendMessage(HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * manager处理employ的补卡信息
	 * 同意/不同意补卡签到
	 * 2018-08-21
	 */
	
	public String aggreeLogin(HttpServletRequest request,HttpServletResponse response);
	/**
	 * manager处理employ的补卡信息
	 * 同意/不同意补卡签退
	 * 2018-08-21
	 */
	public String aggreeLogout(HttpServletRequest request,HttpServletResponse response);
}
