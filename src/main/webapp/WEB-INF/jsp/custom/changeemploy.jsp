<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>My JSP 'changemyinfo.jsp' starting page</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/changeemploy.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
  <h1>更换员工</h1>
   	<%-- <div class="box">
   		<div class="level1">
   			<ul>
   			<c:forEach items="${departments}" var="department">
   				<li>
   					<input type="radio" name="department_id" value="${department.id}" /><span>${department.name}</span>
   				</li>
   			</c:forEach>
   			</ul>  			
   		</div>
   		<div class="level2">
   		
   		</div>
   	</div> --%>
    <!-- 客户更换员工 -->
   <%--  <form action="${pageContext.request.contextPath}/updateemployid" method="post">
    	<select name="department_id" id="department">
    		<c:forEach items="${departments}" var="department">
    			<option value="${department.id}">${department.name}</option>
    		</c:forEach>   		
    	</select>
    	<select name="employ_id" id="employ">
    		<c:forEach items="${employs}" var="employ">
    		<option value="${employ.id}">${employ.username}</option>
    		</c:forEach>
    	</select>
    	<input type="submit" value="确认更换员工" />
    </form> --%>
	
    <script type="text/javascript">
    	var department = $("#department");
    	var employ = $("#employ");
    	department.change(function(){
    		var department_id = department.val();	//部门id
    		//根据department_id查询该部门下的员工
    		var url = "${pageContext.request.contextPath}/getemploybydepartmentid?department_id="+department_id;
    		$.get(url,true,function(data){
    			var a=data;
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
