<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
 <!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
	<link href='${pageContext.request.contextPath}/css/leave4employ.css' rel='stylesheet' type='text/css'>
	<link href='${pageContext.request.contextPath}/css/tablemodel.css' rel='stylesheet' type='text/css'>
	<script src="${pageContext.request.contextPath}/js/changeinfo/jquery.js"></script>
	
	
	
</head>
<body>
	<form action="${pageContext.request.contextPath}/insertLeave" method="post">
		开始时间:<input type="date" name="startTime"><br/><br>
		结束时间:<input type="date" name="endTime"><br/><br>
		请假理由:<input type="text" name="leaveReason"><br/><br>
		<input type="submit" value="确定请假" />
	</form>
	<div id="box">
		<table>
			<tr id="title">
				<td>员工</td>
				<td>开始时间</td>
				<td>结束时间</td>
				<td>状态</td>
				<td>请假理由</td>
			</tr>
			<tr class="info"></tr>
		</table>	
	</div>
</body>
</html>