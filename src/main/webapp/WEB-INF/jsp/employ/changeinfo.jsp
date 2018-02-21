<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
  
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/changeinfo.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var url = "${pageContext.request.contextPath}/updateinfo";
			$("#submit").click(function(){
				//获取个表单内容
				var uid = $("#uid").val();
				var oldpassword = $("#oldpassword").val();
				var newpassword = $("#newpassword").val();
				var info = $("#info").val();
				$.post(url,"id="+uid+"&oldpassword="+oldpassword+"&newpassword="+newpassword+"&info="+info,function(data){
				//	eval("var message="+data);//修改成功 or 修改失败
					var message = data;
					alert(message);
				})
			});
		})
	</script>
  </head>
  
  <body>
  	<div id="box">
  	
  	
  	<!-- 修改password或 info-->
    	<input id="uid" hidden value="${sessionScope.user.id}" name="id"/>
    	<input id="oldpassword" type="text" name="oldpassword" required="required" placeholder="输入旧密码"/><br/><br/>
    	<input id="newpassword" type="text" name="newpassword" required="required" placeholder="输入新密码"/><br/><br/>
    	<textarea id="info" rows="" cols="" name="info" required="required" placeholder="一句话描述自己"></textarea>
    	<button id="submit">修改</button>
    </div>
  </body>
</html>
