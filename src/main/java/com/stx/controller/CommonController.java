package com.stx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stx.service.CommonService;

/**
 * 
 * @author Administrator
 *	公共控制器
 */
@RestController("commonController")
public class CommonController {
	
	/**
	 * 跳转到登录页面，系统首页
	 */
	@RequestMapping("/")
	public void gotoIndex(HttpServletRequest request,HttpServletResponse response){
		request = commonService.getAllAuthority(request, response);
		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
		} 
	}
	
	/**
	 * 登录控制器
	 */
	@RequestMapping("/login")
	public  void login(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		boolean b  = commonService.login(request, response,session);
		try {
			if(b){
				request.getRequestDispatcher("/WEB-INF/jsp/frame.jsp").forward(request, response);
				
			}else{
				String message = "对不起,用户名或密码输入错误,登录失败";
			
				request.setAttribute("message", message);
				request.getRequestDispatcher("/WEB-INF/jsp/loginfail.jsp").forward(request, response);
			}
		} catch (Exception e) {
		}
	
	}
	
	/**
	 * 注销
	 */
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		commonService.logout(request, response, session);
		try {
		//	request.getRequestDispatcher("/index.jsp").forward(request, response);
			response.sendRedirect("/kehu51");
		} catch (Exception e) {
		} 
	}
	@Resource(name="commonServices")
	private CommonService commonService;
}
