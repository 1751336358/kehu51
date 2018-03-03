<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>欢迎注册</title>
	<!-- for-mobile-apps -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Easy Sign Up Form Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
			function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //for-mobile-apps -->
	<!-- js -->
	<script src="${pageContext.request.contextPath}/js/register/jquery-1.11.1.min.js"></script>
	<!-- //js -->
	<link href="${pageContext.request.contextPath}/css/register/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='${pageContext.request.contextPath}/css/register/font.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="main">
		<h1>Welcome to kehu51</h1>
		<div class="agileinfo_main">
			<h3>Sign Up</h3>
			<h2>Join with us</h2>
			<form action="${pageContext.request.contextPath}/register" method="post">
				<div class="agileinfo_main_grid1 agileinfo_main_grid">
					<input type="text" name="username" placeholder="Your Name" required=""> 
				</div> 
				<div class="agileinfo_main_grid agileinfo_main_grid_left">
					<select id="country" name="department_id" onchange="change_country(this.value)" class="frm-field required department">
						<c:forEach items="${departments}" var="department">
		    				<option value="${department.id}">${department.name}</option>
		    		</c:forEach> 
					</select>
				</div>
				<div class="agileinfo_main_grid agileinfo_main_grid_left">
					<select id="country" name="employ_id" onchange="change_country(this.value)" class="frm-field required employ">
						<c:forEach items="${employs}" var="employ">
			    			<option value="${employ.id}">${employ.username}</option>
			    		</c:forEach>
					</select>
				</div>
				<div class="agileinfo_main_grid_data agileinfo_main_grid_left1">
					<input class="date" id="datepicker" name="birthday" type="text" value="Date of birth" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '19/10/2015';}" required="">
				</div>
				<div class="clear"> </div>
				<!---strat-date-piker---->
					<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register/jquery-ui.css" />
					<script src="${pageContext.request.contextPath}/js/register/jquery-ui.js"></script>
					  <script>
							  $(function() {
								$( "#datepicker,#datepicker1" ).datepicker();
							  });
					  </script>
				<!---/End-date-piker---->
				<div class="agileinfo_main_grid2 agileinfo_main_grid">
					<input type="email" name="email" placeholder="Your Email" required=""> 
				</div> 
				<div class="agileinfo_main_grid agileinfo_main_grid_left">
					<input type="password" name="password" placeholder="Password" required=""> 
				</div>
				<div class="agileinfo_main_grid agileinfo_main_grid_left1">
					<input type="text" name="phonenumber" placeholder="Your Phone Number" required=""> 
				</div>
				<div class="clear"> </div>
				<input type="submit" value="Sign Up">
			</form>
		</div>
	<script type="text/javascript">
	//select标签联动
    	var department = $(".department");
    	var employ = $(".employ");
    	department.change(function(){
    		var department_id = department.val();	//部门id
    		//根据department_id查询该部门下的员工
    		var url = "${pageContext.request.contextPath}/getemploybydepartmentid?department_id="+department_id;
    		$.get(url,true,function(data){
    			var a = data;
    			employ.empty();	//清空原有的标签
    			for(var i = 0;i<a.length;i++){
    				var node = "<option value="+a[i].id+">"+a[i].username+"</option>";
    				employ.append(node);
    			}
    		})
    	});
    </script>
		<div class="wthree_footer_copy">
			<p>© 2018 山西农业大学信息学院 | Powered by <a href="http://localhost:8081/kehu51/">客户无忧</a></p>
		</div>
	</div>
</body>
</html>
