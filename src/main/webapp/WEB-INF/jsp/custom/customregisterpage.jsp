<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>custom注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customregisterpage.css">
  </head>
  
  <body>
  	<img src="${pageContext.request.contextPath}/images/customregisterpage.jpg"/>
  	<div id="box">
  		<div id="show">
  			<form action="${pageContext.request.contextPath}/register" method="post">
		    	<input id="username" name="username" type="text" required="required" placeholder="用户名"/>
		    	<input id="password" name="password" type="text" required="required" placeholder="密码"/>
		    	<input id="phone" name="phonenumber" type="text" required="required" placeholder="手机号码"/>
		    	<input id="email" name="email" type="email" required="required" placeholder="电子邮箱"/>
		    	<input id="bir" name="birthday" type="date" required="required" placeholder="生日"/>
		    	<select id="department" name="department_id">
		    		<c:forEach items="${departments}" var="department">
		    			<option value="${department.id}">${department.name}</option>
		    		</c:forEach>   		
		    	</select>
		    	<select id="employ" name="employ_id">
		    		<c:forEach items="${employs}" var="employ">
		    		<option value="${employ.id}">${employ.username}</option>
		    		</c:forEach>
		    	</select>
		    	<input id="submit" type="submit" value="立即注册" />
    		</form>
  		</div> 		
  	</div>
    
    <script type="text/javascript">
    	var department = $("#department");
    	var employ = $("#employ");
    	department.change(function(){
    		var department_id = department.val();	//部门id
    		//根据department_id查询该部门下的员工
    		var url = "${pageContext.request.contextPath}/getemploybydepartmentid?department_id="+department_id;
    		$.get(url,true,function(data){
    		//	eval("var a="+data);
    			var a = data;
    			employ.empty();	//清空原有的标签
    			for(var i = 0;i<a.length;i++){
    				var node = "<option value="+a[i].id+">"+a[i].username+"</option>";
    				employ.append(node);
    			}
    		})
    	});
    </script>
  </body>
</html>
