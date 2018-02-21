<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工写日志</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/writelog.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
  <div id="box">
  	<form action="${pageContext.request.contextPath}/addlog" method="post">
    	<input value="${sessionScope.user.id}" hidden name="employ_id"/><br/><br/>
    	<input id="title" type="text" name="title"/ required="required" placeholder="日志标题"><br/><br/>
    	<textarea id="content" name="content" required="required" placeholder="日志内容"></textarea><br/><br/>
    	<input id="submit" type="submit" value="提交" />
    </form>
  </div>
  </body>
</html>
