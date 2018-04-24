package com.stx.mapper;

import java.util.List;

import com.stx.pojo.Comment;
import com.stx.pojo.Custom;
import com.stx.pojo.Employ;
import com.stx.pojo.Log;
import com.stx.pojo.User;
import com.stx.pojo.Work;




public interface EmployMapper {
	//根据userid查询employ
		public Employ selEmployById(int userid);
		
		//根据userid查询出该用户最近的签到状况 
		public List<Work> selNearWork(int userid);
		
		//签到
		public void workStart(Work work);
		
		//是否签到
		public int isWorkStart(Work work);
		
		//签退
		public void workEnd(Work work);
		
		//是否签退
		public int isWorkEnd(Work work);
		
		//将日志添加到数据库
		public Integer addLog(Log log);
		
		//根据当前的员工的id查询出该员工所在的部门的经理的id
		public int selManagerId(int employ_id);
		
		//根据当前员工的id查询出该员工所在部门经理的信息
		public Employ getManagerInfoByEmployId(int employ_id);
		
		//根据当前员工id查询密码，用于修改个人信息比对
		public String getPasswordById(int id);

		//将员工修改的个人信息更新到数据库
		public void updateInfo(Employ employ);
		
		//根据当前的员工id查看该员工下的所有客户
		public List<Custom> getAllCustom(int id);
		
		//评论我的
		public List<Comment> myComment(int userid);
		
		//判断经理名是否存在
		public Integer managerExist(String username);
		 
		//添加经理
		public Integer addManager(Employ employ);
		
		//删除经理delManagerByDepartmentId
		public Integer delManagerByDepartmentId(Integer id);
		
		//断该部门下是否有非经理的其他员工，如果有则不能删除该部门
		public Integer hasOtherEmploy(Integer id);
		
		//查询该部门下的所有成员(包括员工和经理)的id、username,发消息用
		public List<User> queryEmployByDepartmentId(Integer departmentId);
}
