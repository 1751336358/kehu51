package com.stx.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.CustomDao;
import com.stx.mapper.CustomMapper;
import com.stx.pojo.Comment;
import com.stx.pojo.Custom;
import com.stx.pojo.Department;
import com.stx.pojo.Employ;

@Repository("customdao")
public class CustomDaoImpl extends SqlSessionDaoSupport implements CustomDao{
	
	//查询部门信息
	public List<Department> getDepartment(){
		return this.getSqlSession().getMapper(CustomMapper.class).getDepartment();
	}
	
	//跳转到客户注册页面，查询员工信息 
	public List<Employ> showIndexEmploy(){
		return this.getSqlSession().getMapper(CustomMapper.class).showIndexEmploy();
	}
	
	//根据部门id查询该部门的所有员工
	public List<Employ> getEmployByDepartmentId(int department_id){
		return this.getSqlSession().getMapper(CustomMapper.class).getEmployByDepartmentId(department_id);
	}
	
	//根据username查询该用户是否注册
	public int isRegister(String username){
		return this.getSqlSession().getMapper(CustomMapper.class).isRegister(username);
	}
	
	//将注册的客户信息插入数据库
	public void register(Custom custom){
		this.getSqlSession().getMapper(CustomMapper.class).register(custom);
	}
	
	//根据username查询custom信息
	public Custom getCustomByUserName(String username){
		return this.getSqlSession().getMapper(CustomMapper.class).getCustomByUserName(username);
	}
	
	//查看个人信息
	public Custom selCustomById(int id){
		return this.getSqlSession().getMapper(CustomMapper.class).selCustomById(id);
	}
	//将用户修改的个人信息插入数据库
	public void updateCustom(Custom custom){
		this.getSqlSession().getMapper(CustomMapper.class).updateCustom(custom);
	}
	
	//查看员工信息
	public Employ selEmployByCustomEmployId(int id){
		return this.getSqlSession().getMapper(CustomMapper.class).selEmployByCustomEmployId(id);
	}
	
	//根据员工id查询出员工所在的部门信息
	public Department getDepartmentByEmployId(int id){
		return this.getSqlSession().getMapper(CustomMapper.class).getDepartmentByEmployId(id);
	}
	
	//将客户更改员工的信息更新到数据库
	public void updateEmployId(Custom custom){
		this.getSqlSession().getMapper(CustomMapper.class).updateEmployId(custom);
	}
	
	//将客户评论插入到数据库
	public void addComment(Comment comment){
		this.getSqlSession().getMapper(CustomMapper.class).addComment(comment);
	}
	
	//查看该员工最近20条评论
	public List<Comment> getCommentByEmployId(int employ_id){
		return this.getSqlSession().getMapper(CustomMapper.class).getCommentByEmployId(employ_id);
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}		
}
