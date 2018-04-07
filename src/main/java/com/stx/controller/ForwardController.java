package com.stx.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Administrator
 *	负责转发的控制器
 */
@RestController("forwardController")
public class ForwardController {
	
	//转发到left.jsp
	@RequestMapping("/left")
	public void left(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/left.jsp").forward(request, response);
		} catch (Exception e) {	
		} 
	}
	//转发到top.jsp
	@RequestMapping("/top")
	public void top(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/top.jsp").forward(request, response);
		} catch (Exception e) {	
		}
	}
	//转发到right.jsp,也是消息页面
	@RequestMapping("/right")
	public void right(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/right.jsp").forward(request, response);
		} catch (Exception e) {	
		}
	}
}
