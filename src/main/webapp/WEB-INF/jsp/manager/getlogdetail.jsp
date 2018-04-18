<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>日志详细信息</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/getlogdetail/getlogdetail.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/getlogdetail/getlogdetail.js"></script>
	
  </head>
  
  <body>
  	<div class="box">
  		<div class="title">
  			<p>标题:<span>${log.title}</span></p>
  		</div>
  		<button class="hasRead">标记已读</button>
  		<div class="container">
  			<pre>内容:${log.content}</pre>
  		</div>
  		<div class="footer">
  			<p class="time">发表时间:${log.committime}</p>
    		<p class="username">发表用户:<span>${username}</span></p>
    		<p class="userid" hidden>id:<span>${log.employ_id}</span></p>
  		</div>
  	</div>   
  </body>
</html>
