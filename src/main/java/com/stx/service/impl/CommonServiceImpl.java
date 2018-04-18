package com.stx.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stx.dao.CommonDao;
import com.stx.pojo.Authority;
import com.stx.pojo.Menu;
import com.stx.pojo.MenuVO;
import com.stx.pojo.User;
import com.stx.service.CommonService;

@Service("commonServices")
public class CommonServiceImpl implements CommonService{
	private static Logger logger =  LoggerFactory.getLogger(CommonServiceImpl.class);
	
	//跳转首页，查询出所有权限
	@Override
	public HttpServletRequest getAllAuthority(HttpServletRequest request,HttpServletResponse response) {
		List<Authority> authorityList =  commonDao.getAllAuthority();
		request.setAttribute("authorityList", authorityList);
		return request;
	}
	//登录检查用户名和密码是否正确
	@Override
	public  Integer checkInput(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if("admin".equals(username) && "admin".equals(password)){	//如果是管理员登录
			session.setAttribute("loginRole", "admin");
			return 1;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		int employCount = commonDao.checkInputEmploy(user);
		int customCount = commonDao.checkInputCustom(user);
		if(employCount == 0 && customCount == 0){
			return 0;
		}else if(employCount == 1){	//说明是employ或manager正在登录
			//判断employ是否被禁用
			Integer isOpen = commonDao.isOpen(user);
			if(isOpen == -1){
				return -1;
			}
			session.setAttribute("loginRole", "employ");
		}else if(customCount == 1){	//说明是custom正在登录
			//判断custom是否被禁用
			Integer isOpen4Custom = commonDao.isOpen4Custom(user);
			if(isOpen4Custom == -1){
				return -1;
			}
			session.setAttribute("loginRole", "custom");
		}
		return 1;	//正常登陆
	}
	//登录，旧接口，暂时废弃
	@Override
	public boolean login(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		int authorityid = Integer.parseInt(request.getParameter("authorityid"));	//登陆的权限值：1客户，2员工，3经理
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//先检查username和password
		User user = new User(username,password);
		//根据authorityid查询不同的角色所对应的菜单列表
		Authority authority = commonDao.getAuthority(authorityid);
		
		session.setAttribute("authority", authority);
		user.setAuthority(authority);
		//再检查权限，注意：要将查询出来的菜单存入session里
		if(authorityid == 1){
			user = commonDao.checkCustom(user);	//username,password,id
			if(user != null){
				session.setAttribute("user", user);
				return true;
			}else {
				session.removeAttribute("user");
				return false;
			}
		}else if(authorityid == 2){
			user = commonDao.checkEmploy(user);
			if(user != null){
				session.setAttribute("user", user);
				return true;
			}else{
				session.removeAttribute("user");
				return false;
			}
		}else if(authorityid == 3){
			user = commonDao.checkEmploy(user);
			if(user != null){
				session.setAttribute("user", user);				
				return true;
			}else{
				session.removeAttribute("user");
				return false;
			}
		}
		return false;
	}
	/**
	 * 登录，新接口
	 * 2018-03-03
	 */
	@Override
	public void loginIn(HttpServletRequest request,HttpServletResponse response){
		//登录按钮可以点击说明username和password是没有问题的
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = new User(username, password);
		//根据username和password查询authority_id
		String loginRole = (String)session.getAttribute("loginRole");
		int authorityId = 0;
		if("employ".equals(loginRole)){	//employ或manager正在登录,查employ表
			authorityId = commonDao.getAuthorityId4Employ(username);
		}else if("custom".equals(loginRole)){	//custom正在登录，查custom表
			authorityId = commonDao.getAuthorityId4Custom(username);
		}else if("admin".equals(loginRole)){	//管理员登录
			authorityId = 4;
		}
		//权限和一级菜单
		Authority authority = commonDao.getAuthority(authorityId);
		session.setAttribute("authority", authority);
		u.setAuthority(authority);
		//为了适应树形目录模板，把查询目录的操作做调整，根据authorityId把所有目录都查出来
		List<MenuVO> menuVOList = queryMenuByAuthorityId(authorityId);
		session.setAttribute("menuVOList", menuVOList);
		//再检查权限，注意：要将查询出来的菜单存入session里
		if(authorityId == 1){
			u = commonDao.checkCustom(u);	//username,password,id
			if(u != null){
				session.setAttribute("user", u);
				return;
			}else {
				session.removeAttribute("user");
				return;
			}
		}else if(authorityId == 2){
			u = commonDao.checkEmploy(u);
			if(u != null){
				session.setAttribute("user", u);
				return;
			}else{
				session.removeAttribute("user");
				return;
			}
		}else if(authorityId == 3){
			u = commonDao.checkEmploy(u);
			if(u != null){
				session.setAttribute("user", u);				
				return;
			}else{
				session.removeAttribute("user");
				return;
			}
		}else if(authorityId == 4){	//管理员登录
			u.setId(0);
			u.setUsername("admin");
			u.setPassword("admin");
			session.setAttribute("user", u);
			return;
		}
	}
	/**
	 * 根据authorityId查父目录和子目录
	 */
	private List<MenuVO> queryMenuByAuthorityId(int authorityId){
		List<MenuVO> menuVOList = new ArrayList<MenuVO>();
		//查询父菜单
		List<Menu> menuList = commonDao.getFMenuByAuthorityId(authorityId);
		for(Menu menu:menuList){
			MenuVO menuVO = new MenuVO();
			menuVO.setfMenu(menu);
			//循环查询子菜单
			int menuId = menu.getId();
			List<Menu> sonMenuList = commonDao.getSonMenuByFatherId(menuId);
			menuVO.setsMenu(sonMenuList);
			menuVOList.add(menuVO);
		}
		return menuVOList;
	}
	//注销
	public void logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session.removeAttribute("user");
		
		User u = (User)session.getAttribute("user");
		if(u == null){
			System.out.println("成功退出");
		}
		session.invalidate();
	}
	
	
	
	
	@Resource(name="commondao")
	private CommonDao commonDao;

	/*
	insert into menu(name,url,authority_id) values('员工管理','employmanage',3);
	insert into menu(name,url,authority_id) values('日志管理','logmanage',3);
	insert into menu(name,url,authority_id) values('考情管理','workmanage',3);
	
	insert into menu(name,url,authority_id) values('工作日志','worklogmanage',2);
	insert into menu(name,url,authority_id) values('客户管理','custommanage',2);
	
	insert into menu(name,url,authority_id) values('修改个人信息','updateinfo',1);
	insert into menu(name,url,authority_id) values('查看员工信息','getemploy',1);
	insert into menu(name,url,authority_id) values('选择新员工','changenewemploy',1);
	*/
}