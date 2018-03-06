<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/addemploy.css">
  </head>
  
  <body>
    <!-- ${sessionScope.user.id } 根据useid确定查询出客户被那个经理添加到哪个部门-->
    <div id="box">
		<form action="${pageContext.request.contextPath}/insertemploy" method="post">
			<input id="username" type="text" name="username" required="required" placeholder="员工名"/><br/><br/>
			<textarea id="info" rows="" cols="" name="info" required="required" placeholder="一句话描述员工"></textarea>
			<input id="submit" type="submit" value="添加"/>
		</form>
	</div>
	
  </body>
</html> --%>
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
