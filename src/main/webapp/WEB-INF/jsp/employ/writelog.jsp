<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<link href="${pageContext.request.contextPath}/css/writelog/style.css" rel="stylesheet" type="text/css" media="all"/>
	<!--web-fonts-->
	<link href='${pageContext.request.contextPath}/css/writelog/other.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<!---header--->
	<div class="header">
		<h1>留言</h1>
	</div>
		
	<div class="main">
		<div class="main-section">
			<div class="login-form">
				<form action="${pageContext.request.contextPath}/addlog" method="post">
					<ul>
						 <li class="text-info">标题</li>
						 <li><input name="title" type="text" placeholder="" required></li>
						 <div class="clear"></div>
					 </ul>					
					 <ul>
						<li class="text-info">内容</li>
						<li><textarea name="content"></textarea></li>
						<div class="clear"></div>
					</ul>
					<input type="submit" value="Send Message">
				</form>
			</div>
		</div>
	</div>
</body>
</html>