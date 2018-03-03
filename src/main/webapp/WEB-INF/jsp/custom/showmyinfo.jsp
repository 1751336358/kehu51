<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changemyinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/showmyinfo.css">
	

  </head>
  
  <body>
  	<div class="box">
  		<div class="title">个人信息</div>
  		<table>
  			<tr>
  				<td class="left">id:&nbsp&nbsp&nbsp&nbsp</td>
  				<td class="right"><input type="text" value="${requestScope.custom.id}" readonly=true /></td>
  			</tr>
  			<tr>
  				<td class="left">用户名:&nbsp&nbsp&nbsp&nbsp</td>
  				<td class="right"><input type="text" value="${requestScope.custom.username}" readonly=true /></td>
  			</tr>
  			<tr>
  				<td class="left">手机号:&nbsp&nbsp&nbsp&nbsp</td>
  				<td class="right"><input type="text" value="${requestScope.custom.phoneNumber}" readonly=true /></td>
  			</tr>
  			<tr>
  				<td class="left">邮箱:&nbsp&nbsp&nbsp&nbsp</td>
  				<td class="right"><input type="text" value="${requestScope.custom.email}" readonly=true /></td>
  			</tr>
  			<tr>
  				<td class="left">生日:&nbsp&nbsp&nbsp&nbsp</td>
  				<td class="right"><input type="text" value="${requestScope.custom.birthday}" readonly=true /></td>
  			</tr>
  			<tr>
  				<td class="left">注册时间:&nbsp&nbsp&nbsp&nbsp</td>
  				<td class="right"><input type="text" value="${requestScope.custom.registerTime}" readonly=true /></td>
  			</tr>
  		</table>
  	</div>
   <%--  id:${requestScope.custom.id}<br/><br/>
    username:${requestScope.custom.username}<br/><br/>
    phonenumber:${requestScope.custom.phoneNumber}<br/><br/>
    email:${requestScope.custom.email}<br/><br/>
    birthday:${requestScope.custom.birthday }<br/><br/>
    registertime:${requestScope.custom.registerTime}<br/><br/>
    queuename:${requestScope.custom.queueName }<br/><br/> --%>
  </body>
</html>
