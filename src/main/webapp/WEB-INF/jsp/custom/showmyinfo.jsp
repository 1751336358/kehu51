<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changemyinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>查看个人信息</h1>
    id:${requestScope.custom.id}<br/><br/>
    username:${requestScope.custom.username}<br/><br/>
    phonenumber:${requestScope.custom.phoneNumber}<br/><br/>
    email:${requestScope.custom.email}<br/><br/>
    birthday:${requestScope.custom.birthday }<br/><br/>
    registertime:${requestScope.custom.registerTime}<br/><br/>
    queuename:${requestScope.custom.queueName }<br/><br/>
  </body>
</html>
