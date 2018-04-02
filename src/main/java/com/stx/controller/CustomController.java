package com.stx.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stx.pojo.Employ;
import com.stx.service.CustomService;

/**
 * 
 * @author Administrator
 *	与custom相关的控制器
 */
@RestController("customController")
public class CustomController {
	/**
	 * 跳转到custom注册页面
	 */
	@RequestMapping("/gotocustomregisterpage")
	public void gotoCustomRegisterPage(HttpServletRequest request,HttpServletResponse response){
		
		request = customService.gotoCustomRegisterPage(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/custom/customregisterpage.jsp").forward(request, response);
		} catch (Exception e) {
		} 
	}
	
	/**
	 *	注册
	 */
	@RequestMapping("/register")
	public void register(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		boolean isRegister = customService.register(request, response, session);
		try{
			if(isRegister){
				String message = "对不起，该用户名已经注册，注册失败";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/WEB-INF/jsp/loginfail.jsp").forward(request, response);
			}else{
				//如果注册成功直接跳转到frame.jsp
				request.getRequestDispatcher("/WEB-INF/jsp/frame.jsp").forward(request, response);	//跳转到系统主页
			}
		}catch(Exception e){
			
		}		
	}
	/**
	 * 根据部门id查询该部门的所有员工
	 */
	@RequestMapping("/getemploybydepartmentid")
	public @ResponseBody List<Employ> getEmployByDepartmentId(HttpServletRequest request,HttpServletResponse response){
		return customService.getEmployByDepartmentId(request, response);
	}
	
	/*==========================各种跳转=============================*/
	/**
	 * 跳转到更换员工页面
	 */
	@RequestMapping("/changeemploy")
	public void changeEmploy(HttpServletRequest request,HttpServletResponse response){
		request = customService.changeEmploy(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/custom/changeemploy.jsp").forward(request, response);
		} catch (Exception e) {			
		} 
	}
	/**
	 * 跳转到修改个人信息页面
	 */
	@RequestMapping("/changemyinfo")
	public void changeMyInfo(HttpServletRequest request,HttpServletResponse response){
		request = customService.selCustomById(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/custom/changemyinfo.jsp").forward(request, response);
		} catch (Exception e) {			
		} 
	}
	/**
	 *跳转到查看员工信息页面
	 */
	@RequestMapping("/showemployinfo")
	public void showemployinfo(HttpServletRequest request,HttpServletResponse response){
		request = customService.selEmployByCustomEmployId(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/custom/showemployinfo.jsp").forward(request, response);
		} catch (Exception e) {			
		} 
	}
	/**
	 * 跳转到查看个人信息页面
	 */
	@RequestMapping("/showmyinfo")
	public void showMyInfo(HttpServletRequest request,HttpServletResponse response){
		request = customService.selCustomById(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/custom/showmyinfo.jsp").forward(request, response);
		} catch (Exception e) {			
		} 
	}	
	/**
	 * 将用户修改的信息插入数据库
	 */
	@RequestMapping("/updatecustom")
	public @ResponseBody String updateCustom(HttpServletRequest request,HttpServletResponse response){
		String message = "修改成功";
		customService.updateCustom(request, response);	
		return message;
	}
	/**
	 * 将客户更改员工的信息更新到数据库
	 */
	@RequestMapping("/updateemployid")
	public @ResponseBody boolean updateEmployId(HttpServletRequest request,HttpServletResponse response){
		boolean b = customService.updateEmployId(request, response);
		return b;
	}
	
	/**
	 * 将客户评论信息插入数据库
	 */
	@RequestMapping("/addcomment")
	public @ResponseBody String addComment(HttpServletRequest request,HttpServletResponse response){
		String message;
		boolean b = customService.addcomment(request, response);
		if(b){
			message = "评论成功";
		}else{
			message = "对不起，评论失败";
		}
		return message;
	}
	
	/**
	 * 根据employid查employ信息
	 */
	@RequestMapping("/getEmployById")
	public @ResponseBody Employ getEmployById(HttpServletRequest request,HttpServletResponse response){
		Employ employ = customService.getEmployById(request, response);
		return employ;
	}
	@Resource(name="customServices")
	private CustomService customService;
}
