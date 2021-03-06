package com.stx.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stx.dao.EmployDao;
import com.stx.mapper.EmployMapper;
import com.stx.pojo.Comment;
import com.stx.pojo.Custom;
import com.stx.pojo.Employ;
import com.stx.pojo.Log;
import com.stx.pojo.User;
import com.stx.pojo.Work;

@Repository("employdao")
public class EmployDaoImpl extends SqlSessionDaoSupport implements EmployDao{
	//根据userid查询employ信息
		@Override
		public Employ selEmployById(int userid) {
			return this.getSqlSession().getMapper(EmployMapper.class).selEmployById(userid);
		}
		
		//根据userid查询该用户最近的签到状况
		@Override
		public List<Work> selNearWork(int userid){
			return this.getSqlSession().getMapper(EmployMapper.class).selNearWork(userid);
		}
		
		//签到
		@Override
		public void workStart(Work work){
			this.getSqlSession().getMapper(EmployMapper.class).workStart(work);
		}
		
		//是否签到
		@Override
		public int isWorkStart(Work work){
			return this.getSqlSession().getMapper(EmployMapper.class).isWorkStart(work);
		}
		//签退
		@Override
		public void workEnd(Work work){
			this.getSqlSession().getMapper(EmployMapper.class).workEnd(work);
		}
		
		//是否签退
		@Override
		public int isWorkEnd(Work work){
			return this.getSqlSession().getMapper(EmployMapper.class).isWorkEnd(work);
		}
		
		//将日志添加到数据库
		@Override
		public Integer addLog(Log log){
			return this.getSqlSession().getMapper(EmployMapper.class).addLog(log);
		}
		
		//根据当前的员工的id查询出该员工所在的部门的经理的id
		@Override
		public int selManagerId(int employ_id){
			return this.getSqlSession().getMapper(EmployMapper.class).selManagerId(employ_id);
		}
		
		//根据当前员工的id查询出该员工所在部门经理的信息
		@Override
		public Employ getManagerInfoByEmployId(int employ_id){
			return this.getSqlSession().getMapper(EmployMapper.class).getManagerInfoByEmployId(employ_id);
		}
		
		//根据当前员工id查询密码，用于修改个人信息比对
		@Override
		public String getPasswordById(int id){
			return this.getSqlSession().getMapper(EmployMapper.class).getPasswordById(id);
		}
		//将员工修改的个人信息更新到数据库
		@Override
		public void updateInfo(Employ employ){
			this.getSqlSession().getMapper(EmployMapper.class).updateInfo(employ);
		}
		//查询所有用户
		@Override
		public List<Custom> getAllCustom(int userid){
			return this.getSqlSession().getMapper(EmployMapper.class).getAllCustom(userid);
		}
		
		//评论我的
		@Override
		public List<Comment> myComment(int userid){
			return this.getSqlSession().getMapper(EmployMapper.class).myComment(userid);
		}
		
		//判断经理名是否存在
		@Override
		public Integer managerExist(String username){
			return this.getSqlSession().getMapper(EmployMapper.class).managerExist(username);
		}
		
		//添加经理
		@Override
		public Integer addManager(Employ employ){
			return this.getSqlSession().getMapper(EmployMapper.class).addManager(employ);
		}
		
		//删除经理delManagerByDepartmentId
		@Override
		public Integer delManagerByDepartmentId(Integer id){
			return this.getSqlSession().getMapper(EmployMapper.class).delManagerByDepartmentId(id);
		}
		
		//断该部门下是否有非经理的其他员工，如果有则不能删除该部门
		@Override
		public Integer hasOtherEmploy(Integer id){
			return this.getSqlSession().getMapper(EmployMapper.class).hasOtherEmploy(id);
		}
		//查询该部门下的所有成员(包括员工和经理)的id、username,发消息用
		@Override
		public List<User> queryEmployByDepartmentId(Integer departmentId){
			return this.getSqlSession().getMapper(EmployMapper.class).queryEmployByDepartmentId(departmentId);
		}
		@Autowired
		@Override
		public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
			// TODO Auto-generated method stub
			super.setSqlSessionFactory(sqlSessionFactory);
		}		
}
