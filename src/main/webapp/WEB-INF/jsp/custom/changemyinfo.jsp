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
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/changemyinfo.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
    <div class="box">
    	<div class="title">修改个人信息</div>
    	<table>
    		<tr>
    			<td class="left">id:&nbsp&nbsp&nbsp</td>
    			<td class="right"><input id="id" type="text" name="id" value="${requestScope.custom.id}" readonly=true/></td>
    		</tr>
    		<tr>
    			<td class="left">用户名:&nbsp&nbsp&nbsp</td>
    			<td class="right"><input id="username" type="text" name="username" value="${requestScope.custom.username}" readonly=true/></td>
    		</tr>
    		<tr>
    			<td class="left">密码:&nbsp&nbsp&nbsp</td>
    			<td class="right"><input id="password" type="text" name="password" value="${requestScope.custom.password }"></td>
    		</tr>
    		<tr>
    			<td class="left">手机号:&nbsp&nbsp&nbsp</td>
    			<td class="right"><input id="phonenumber" type="text" name="phonenumber" value="${requestScope.custom.phoneNumber}"></td>
    		</tr>
    		<tr>
    			<td class="left">邮箱:&nbsp&nbsp&nbsp</td>
    			<td class="right"><input id="email" type="email" name="email" value="${requestScope.custom.email }"></td>
    		</tr>
    		<tr>
    			<td colspan="2"><button id="submit">确认修改</button></td>
    		</tr>
    	</table>
    	
    </div>
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
