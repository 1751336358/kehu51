<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Client Signup Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/css/adddepartment/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<!-- main -->
	<div class="main main-agileits">
		<h1>Adding Department And Manager</h1>
		<div class="main-agilerow"> 
			<div class="signup-wthreetop">
				<h2>Welcome to Registration</h2>
				<p>Lorem ipsum dolor sit amet </p>
			</div>	
			<div class="contact-wthree">
				
				<h3>Adding Department :</h3>
				<div class="form-w3step1">
					<input id="departmentName" type="text" name="departmentName" placeholder="Department Name" required=""> 
					<input id="departmentInfo" type="text" class="email agileits-btm" name="departmentInfo" placeholder="Department Info" required=""> 
				</div> 
				
				<h3>Adding Manager :</h3>
				<div class="form-w3step1 w3ls-formrow">
					<input id="username" type="text" name="username" placeholder="Manager UserName" required="">
					<input id="managerInfo" type="text" class="agileits-btm" name="managerInfo" placeholder="Manager Info" required="">
				</div>
				<input id="submit" type="submit" value="SUBMIT">
			
			 	<script type="text/javascript">
					$("#submit").click(function(){
						var departmentName = $("#departmentName").val();
						var departmentInfo = $("#departmentInfo").val();
						var username = $("#username").val();
						var managerInfo = $("#managerInfo").val();
						if(name=='' || departmentInfo=='' || username=='' || managerInfo==''){
							alert("请将字段填写完整");
							return;
						}else{
							var url = "${pageContext.request.contextPath}/addDepartmentAndManager";
							$.post(url,"departmentName="+departmentName+"&departmentInfo="+departmentInfo+"&username="+username+"&managerInfo="+managerInfo,function(data){
								if(data == 1){
									$("#departmentName").val("");
									$("#departmentInfo").val("");
									$("#username").val("");
									$("#managerInfo").val("");
									alert("添加成功");
								}else if(data == 0){
									alert("系统异常，添加失败");
								}else if(data == -1){
									alert("该部门已经存在，添加失败");
								}else if(data == -2){
									alert("该经理已经存在，添加失败");
								}
							});
						}
					})
				</script>
			</div>  
		</div>	
	</div>	
</body>
</html>