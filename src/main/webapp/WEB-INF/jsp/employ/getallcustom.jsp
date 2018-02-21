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
    
    <title>My JSP 'getallcustom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/getallcustom.css">
	

  </head>
  
  <body>
    <div id="box">
    <table>
    	<tr id="title">
    		<td>id</td>
    		<td>用户名</td>
    		<td>手机号</td>
    		<td>邮箱</td>
    		<td>生日</td>
    		<td>注册时间</td>
    	</tr>
    	<c:forEach items="${customs}" var="custom">
    	<tr class="info">
    		<td>${custom.id }</td>
    		<td>${custom.username }</td>
    		<td>${custom. phoneNumber}</td>
    		<td>${custom.email }</td>
    		<td>${custom.birthday }</td>
    		<td>${custom.registerTime }</td>
    	</tr>
    	</c:forEach>
    </table>
    </div>
  </body>
</html>
