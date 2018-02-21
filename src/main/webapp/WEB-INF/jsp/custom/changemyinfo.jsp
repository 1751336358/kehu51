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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
    	<h1>修改个人信息</h1>
    	id:<input id="id" type="text" name="id" value="${requestScope.custom.id}" hidden/>
    	用户名:<input id="username" type="text" name="username" value="${requestScope.custom.username}"><br/><br/>
    	密	码：<input id="password" type="text" name="password" value="${requestScope.custom.password }"><br/><br/>
    	手机号：<input id="phonenumber" type="text" name="phonenumber" value="${requestScope.custom.phoneNumber}"><br/><br/>
    	邮	箱：<input id="email" type="email" name="email" value="${requestScope.custom.email }"><br/><br/>
    	<button id="submit">确认修改</button>
    	<script type="text/javascript">
    		$("#submit").click(function(){
    			var id = $("#id").val();
    			var username = $("#username").val();
    			var password = $("#password").val();
    			var phonenumber = $("#phonenumber").val();
    			var email = $("#email").val();
    			
    			var url = "${pageContext.request.contextPath}/updatecustom?id="+id+"&password="+password+"&phonenumber="+phonenumber+"&email="+email;
    			$.get(url,true,function(data){
    			//	eval("var message="+data);
    				var message = data;
    				alert(message);
    			})
    		})
    	</script>
  </body>
</html>
