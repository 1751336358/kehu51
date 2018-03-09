<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
  	<form action="${pageContext.request.contextPath}/newemploy" method="post">
  		id:<input type="text" value="${employ.id}"  name="id"/>
  		username:<input type="text" value="${employ.username }"  name="username"/>
  		info:<textarea rows="" cols="" name="info">${employ.info }</textarea>
  		<select id="select" name="departmentid">
    	</select>
    	<input type="submit" value="提交" />
  	</form>
    <!-- ajax查询部门信息 -->
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
