<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
 <!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
	<!-- Custom Theme files -->
	<!-- Custom Theme files -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta name="keywords" content="Shade Flat Contact Form Responsive,Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<!--Google Fonts-->
	<link href="${pageContext.request.contextPath}/css/changeinfo/style.css" rel="stylesheet" type="text/css" media="all"/>
	<link href='${pageContext.request.contextPath}/css/changeinfo/other.css' rel='stylesheet' type='text/css'>
	<!--Google Fonts-->
	<script>var __links = document.querySelectorAll('a');function __linkClick(e) { parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>
	<script src="${pageContext.request.contextPath}/js/changeinfo/jquery.js"></script>
	<script>$(document).ready(function(c) {
		$('.sky-close').on('click', function(c){
			$('.green-button').fadeOut('slow', function(c){
		  		$('.green-button').remove();
			});
		});	  
	});
	</script>
	<script>$(document).ready(function(c) {
		$('.oran-close').on('click', function(c){
			$('.orange-button').fadeOut('slow', function(c){
		  		$('.orange-button').remove();
			});
		});	  
	});
	</script>
	<script type="text/javascript">
		$(function(){
			var url = "${pageContext.request.contextPath}/updateinfo";
			$("#submit").click(function(){
				//获取个表单内容
				var oldpassword = $("#oldpassword").val();
				var newpassword = $("#newpassword").val();
				var info = $("#info").val();
				$.post(url,"oldpassword="+oldpassword+"&newpassword="+newpassword+"&info="+info,function(data){
				//	eval("var message="+data);//修改成功 or 修改失败
					var message = data;
					alert(message);
				})
			});
		})
	</script>
</head>
<body>
<!--coact start here-->
<!-- <h1>Shade Flat Contact Form</h1> -->
<div class="contact">
	<div class="contact-main">
		<h3>Old Password</h3>
		<input id="oldpassword" type="text" name="oldpassword" value="old password" class="hola" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'old password';}"/>
		<h3>New Password</h3>
		<input id="newpassword" type="text" name="newpassword" value="new password" class="hola" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'new password';}"/>
		<h3>My Info</h3>
		<textarea id="info" name="info" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Leave your message here ....';}"/>Leave your message here ....</textarea>
	
	</div>
	<div class="enviar">
		
        <div class="contact-enviar">
		  <input id="submit" type="submit" value="Submit">
		</div>
		<div class="clear"> </div>
</div>
</div>
<!--contact end here-->
</body>
</html>