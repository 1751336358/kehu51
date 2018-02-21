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
    
   
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycomment.css">
	

  </head>
  
  <body>
   <div id="box">
   		<table>
   			<tr id="title">
   				<td>评论者</td>
   				<td>评论内容</td>
   				<td>评论时间</td>
   			</tr>
   			<c:forEach items = "${comments}" var="comment">
   			<tr class="info">
   				<td>${comment. username}</td>
   				<td>${comment.content}</td>
   				<td>${comment.commenttime}</td>
   			</tr>
   			</c:forEach>
   		</table>
   </div>
   
  </body>
</html>
