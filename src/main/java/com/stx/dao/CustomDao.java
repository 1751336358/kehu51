package com.stx.dao;

import java.util.List;

import com.stx.pojo.Comment;
import com.stx.pojo.Custom;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;

public interface CustomDao {
	//查询部门信息
		public List<Department> getDepartment();
		
		//跳转到客户注册页面，查询员工信息 
		public List<Employ> showIndexEmploy();
		
		//根据部门id查询该部门的所有员工
		public List<Employ> getEmployByDepartmentId(int department_id);
		
		//根据username查询该用户是否注册
		public int isRegister(String username);
		
		//将注册的客户信息插入数据库
		public void register(Custom custom);
		
		//根据username查询custom信息
		public Custom getCustomByUserName(String username);
		
		//查看个人信息
		public Custom selCustomById(int id);
		
		//将用户修改的个人信息插入数据库
		public void updateCustom(Custom custom);
		
		//查看员工信息
		public Employ selEmployByCustomEmployId(int id);
		
		//根据员工id查询出员工所在的部门信息
		public Department getDepartmentByEmployId(int id);
		
		//将客户更改员工的信息更新到数据库
		public void updateEmployId(Custom custom);
		
		//将客户评论插入到数据库
		public void addComment(Comment comment);
		
		//查看该员工最近20条评论
		public List<Comment> getCommentByEmployId(int employ_id);
		
		//根据客户id查询员工信息
		public Employ getEmployByCustomId(int id);
}
