package com.stx.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	 * 登录检查输入的用户名和密码是否正确
	 */
	@RequestMapping("/checkInput")
	public @ResponseBody  boolean checkInput(HttpServletRequest request,HttpServletResponse response){
		return commonService.checkInput(request, response);
	}
	/**
	 * 登录控制器
	 */
	@RequestMapping("/login")
	public  void login(HttpServletRequest request,HttpServletResponse response){
		//不用判断，点击登录按钮时已经做了输入检查，能走到这一步说明username和password是对的
		commonService.loginIn(request, response);	
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/frame.jsp").forward(request, response);
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
	
	/**
	 * 跳转到上传头像页面
	 */
	/*@RequestMapping("/gotoUploadHeadImg")
	public void gotoUploadHeadImg(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/uploadhead.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	/**
	 * 上传头像
	 */
	/*
	@RequestMapping("/uploadHeadImg")
	public void uploadHeadImg(HttpServletRequest request,HttpServletResponse response){
		this.commonService.uploadHeadImg(request, response);
	}
	*/
	@Resource(name="commonServices")
	private CommonService commonService;
}
