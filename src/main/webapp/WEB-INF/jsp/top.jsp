<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/top/top.css">
  </head>
  
  <body>
  	<div id="box">
  		<img src="${pageContext.request.contextPath}/images/top/top.png"/>
  		<p id="text01">真正的实惠</p>
  		<p id="text02">小团队也用得起CRM</p>
  		<div id="show">
  			<p id="text03">随时随地办公</p>
  			<p id="text04">咨询电话:152-3548-4814</p>
  		</div>
  	</div>
   	
  </body>
</html>
