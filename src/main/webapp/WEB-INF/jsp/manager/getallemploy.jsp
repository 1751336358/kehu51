<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/getallemploy/getallemploy.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/getallemploy/getallemploy.js"></script>
  </head>
  
  <body>
  	<div id="box">
  		<table>
	  		<tr id="title">
	  			<td></td>
	  			<!-- <td>id</td> -->
	  			<td>用户名</td>
	  			<td>信息</td>
	  			<!-- <td>department_id</td> -->
	  			<!-- <td>queuename</td> -->
	  			<td>操作</td>
	  		</tr>
	  		<c:forEach items="${employs}" var="employ">
	  		<tr class="info">
	  			<td><input type="checkbox" name="id" value="${employ.id}_${employ.username}"/></td>
	  			<%-- <td>${employ.id }</td> --%>
	  			<td>${employ.username}</td>
	  			<td>${employ.info }</td>
	  			<%-- <td>${employ.departmentid}</td> --%>
	  			<%-- <td>${employ.queuename }</td> --%>
	  			<td><a href="${pageContext.request.contextPath}/updateemploy?userid=${employ.id}">编辑</a>&nbsp<a href="${pageContext.request.contextPath}/delemploy?userid=${employ.id}">删除</a>&nbsp&nbsp<span value="${employ.id}" class="customDetail">详情</span></td>
	  		</tr>
	  		</c:forEach>
	  	</table>
	  	<!-- 显示客户信息的div -->
	  	<div class="showDetailBox">
	  		<!--js dom操作 -->
	  		<c:forEach items="${requestScope.firstCustom}" var="custom" varStatus="status">
	  		<div>
	  			<div class="index">第${status.index+1}位</div>
	  			<p>名字：${custom.username}</p>
	  			<p>手机号：${custom.phoneNumber}</p>
	  			<p>邮箱：${custom.email}</p>
	  			<p>生日：${custom.birthday}</p>
	  			<p>注册时间:${custom.registerTime}</p>
	  		</div>
	  		</c:forEach>
	  	</div>
  	</div>
  	<div class="footer">
  		<textarea></textarea>
  		<button>批量发消息</button>
  	</div>
  	
  </body>
</html>
