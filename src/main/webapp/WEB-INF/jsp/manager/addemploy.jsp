<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<title></title>
	<!-- Custom Theme files -->
	
	<!-- Custom Theme files -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="${pageContext.request.contextPath }/css/addemploy/style.css" rel="stylesheet" type="text/css" media="all"/>
	<!--Google Fonts-->
	<link href='${pageContext.request.contextPath }/css/addemploy/other.css' rel='stylesheet' type='text/css'>
	<!--Google Fonts-->
</head>
<body>
<!--contact page start here-->
<h1>添加新员工</h1>
<div class="contact">
	<!-- <h2>Get In Touch With Us</h2> -->
	<p>默认密码为用户名，记得提醒您的员工及时更换用户名哦！</p>
	<form action="${pageContext.request.contextPath}/insertemploy" method="post">
		<h3>Employ Name</h3>
		<input type="text" name="username" class="user active" value="example : John Doe" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'example : John Doe';}">
		
		<h3>Employ Message</h3>
		<textarea class="i" name="info" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'example : I’d like to say “good job!”';}">example : I’d like to say “good job!”</textarea>
		<input type="submit" value="Submit Your message" />
	</form>
</div>

<!--contact page end here-->	
</body>
</html>
