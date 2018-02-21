<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
</html>
