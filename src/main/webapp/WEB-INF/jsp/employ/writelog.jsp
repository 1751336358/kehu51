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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		/*
			return true：表单正常提交
			return false：阻止表单提交
		*/
		function submitLog(){
			var title = $("#title").val();
			var content = $("#content").val();
			if(title==''){
				$("#title").focus();
				return false;
			}
			if(content == ''){
				$("#content").focus();
				return false;
			}
			return true;
		}
	</script>
	<!---header--->
	<div class="header">
		<h1>留言</h1>
	</div>
		
	<div class="main">
		<div class="main-section">
			<div class="login-form">
				<!-- onSubmit方法可以阻止表单提交事件 -->
				<form action="${pageContext.request.contextPath}/addlog" method="post" onSubmit="return submitLog();">
					<ul>
						 <li class="text-info">标题</li>
						 <li><input id="title" name="title" type="text" placeholder="" required></li>
						 <div class="clear"></div>
					 </ul>					
					 <ul>
						<li class="text-info">内容</li>
						<li><textarea id="content" name="content"></textarea></li>
						<div class="clear"></div>
					</ul>
					<input id="submit" type="submit" value="Send Message">
				</form>
			</div>
		</div>
	</div>
</body>
</html>