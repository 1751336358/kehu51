<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/employdetail/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath}/css/employdetail/other.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--web-fonts-->
</head>
<body>
			<div class="main">
				<div class="login">
					<div class="login-top">
						<img src="${pageContext.request.contextPath}/images/employdetail/p.png">
					</div>
					<h1>Change Employ Info</h1>
					<div class="login-bottom">
					<form action="${pageContext.request.contextPath}/newemploy" method="post">
						<input type="text" value="${employ.id}"  name="id" hidden/>
						<input type="text" value="${employ.username }"  name="username">					
						<input type="text" class="password" name="info" value="${employ.info }">
						<select id="select" name="departmentid">				
						</select>						
						<input type="submit" value="ok">
					</form>
					<a href="#"><p></p></a>
					</div>
				</div>
			</div>
			<script type="text/javascript">
		    	var url = "${pageContext.request.contextPath}/getDepartment";
		    	$.get(url,true,function(data){
		    	//	eval("var a="+data);
		    		var a = data;
		    		for(var i=0;i<a.length;i++){
		    			if(a[i].id==${employ.departmentid }){
		    				$("#select").append("<option value="+a[i].id+" selected=true>"+a[i].name+"</option>");
		    				continue;
		    			}
		    			$("#select").append("<option value="+a[i].id+">"+a[i].name+"</option>");
		    		}    		
		    	})
    </script>

</body>
</html>

