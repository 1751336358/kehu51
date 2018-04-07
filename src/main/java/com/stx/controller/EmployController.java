package com.stx.controller;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.stx.pojo.User;
import com.stx.service.EmployService;
/**
 * 
 * @author Administrator
 *	与employ相关的控制器
 */
@RestController("employController")
public class EmployController {
	
	/**
	 * 跳转到员工签到/签退页面
	 */
	@RequestMapping("/workstartend")
	public void workStartEnd(HttpServletRequest request,HttpServletResponse response){
		request = employService.selNearWork(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/employ/workstartend.jsp").forward(request, response);
		} catch (Exception e) {
		} 
	}
	/**
	 * 签到
	 */
	@RequestMapping("/workstart")
	public @ResponseBody String workStart(HttpServletRequest request,HttpServletResponse response){
		String message;
		boolean b = employService.workStart(request, response);
		if(b){
			message = "签到成功";
		}else{
			message = "对不起,不能重复签到";
		}
		return message;
	}
	
	/**
	 * 签退
	 */
	@RequestMapping("/workend")
	public @ResponseBody String wordEnd(HttpServletRequest request,HttpServletResponse response){
		String message;
		boolean b = employService.workEnd(request, response);
		if(b){
			message = "签退成功";
		}else{
			message = "对不起,不能重复签退";
		}
		return message;
	}
	
	/**
	 * 补卡
	 * 2018-02-14
	 * @input radio "1"/"2"
	 * 			bukaTime
	 * @method post
	 */
	@RequestMapping("/hasDaka")
	public @ResponseBody boolean buka(HttpServletRequest request,HttpServletResponse response){
		boolean status = employService.buka(request, response);
		
		return status;
	}
	/**
	 * 跳转到写日志页面
	 */
	@RequestMapping("/writelog")
	public void writeLog(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/employ/writelog.jsp").forward(request, response);
		} catch (Exception e) {
		}
	}
	/**
	 * 将日志添加到数据库
	 */
	@RequestMapping("/addlog")
	public @ResponseBody Integer addLog(HttpServletRequest request,HttpServletResponse response){
		Integer ret = 0;
		try{
			ret = employService.addLog(request, response);
		}catch(Exception e){
			System.out.println("日志发送失败");
			return 0;
		}
		return ret;
	}

	@RequestMapping("/logsuccess")
	public void logSuccess(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/employ/logsuccess.jsp").forward(request, response);
		} catch (Exception e) {
		}
	}
	/**
	 * 跳转到修改个人信息页面
	 */
	@RequestMapping("/changeinfo")
	public void changeInfo(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/employ/changeinfo.jsp").forward(request, response);
		} catch (Exception e) {
		}
	}
	/**
	 * 将修改后的数据更新到数据库
	 */
	@RequestMapping("/updateinfo")
	public @ResponseBody String updateInfo(HttpServletRequest request,HttpServletResponse response){
		String message = employService.updateInfo(request, response);
		return message;
	}
	/**
	 * 查看所有用户
	 */
	@RequestMapping("/getallcustom")
	public void getAllCustom(HttpServletRequest request,HttpServletResponse response){
		request = employService.getAllCustom(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/employ/getallcustom.jsp").forward(request, response);
		} catch (Exception e) {
		}
	}
	
	/**
	 * 评论我的
	 */
	@RequestMapping("/mycomment")
	public void myComment(HttpServletRequest request,HttpServletResponse response){
		request = employService.myComment(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/employ/mycomment.jsp").forward(request, response);
		} catch (Exception e) {
		}
	}
	
	@Resource(name="employServices")
	private EmployService employService;
}
