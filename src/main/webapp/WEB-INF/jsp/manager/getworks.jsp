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
    
    <title>考勤管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/comment/tablemodel.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/getworks/getworks.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
    <div id="box">
	    <table class="table">
	    	<tr id="title">
	    		<td>id</td>
	    		<td>员工名</td>
	    		<td>employ_id</td>
	    		<td>日期</td>
	    		<td>是否签到</td>
	    		<td>签到时间</td>
	    		<td>是否签退</td>
	    		<td>签退时间</td>
	    	</tr>
	    	<c:forEach items="${works}" var="work">
	    	<tr class="workdetail info">
	    		<td>${work.id}</td>
	    		<td>${work.username }</td>
	    		<td>${work.employ_id}</td>
	    		<td>${work.day}</td>
	    		<td>${work.workstart}</td>
	    		<td>${work.workstart_time}</td>
	    		<td>${work.workend}</td>
	    		<td>${work.workend_time}</td>
	    	</tr>
	    	</c:forEach>
	    </table>
	    <button id="nextPage">下一页</button><button id="prePage">上一页</button>
    </div>
    
    
    <script type="text/javascript">
		$(function(){
			var currentPage = 0;
			$("#prePage").click(function(){
				var url = "${pageContext.request.contextPath}/getworkbypage?userid=${sessionScope.user.id}&currentPage="+currentPage;
				if(currentPage >= 0){
					currentPage--;		
					$.get(url,true,function(data){
				//		box.html("");	//清空原有的内容
					//	eval("var a="+data);
						var a = data;
						$(".workdetail").remove();
						for(var i=0;i<a.length;i++){
							var node = "<tr class='workdetail info'><td>"+a[i].id+"</td><td>"+a[i].username+"</td><td>"+a[i].employ_id+"</td><td>"+a[i].day+"</td><td>"+a[i].workstart+"</td><td>"+a[i].workstart_time+"</td><td>"+a[i].workend+"</td><td>"+a[i].workend_time+"</td></tr>";
							$(".table").append(node);
						}					
					})
				}				
			});
			$("#nextPage").click(function(){
				currentPage++;
				var url = "${pageContext.request.contextPath}/getworkbypage?userid=${sessionScope.user.id}&currentPage="+currentPage;			
				$.get(url,true,function(data){
				//	box.html("");	//清空原有的内容
				//	eval("var a="+data);
					var a = data;
					$(".workdetail").remove();
					for(var i = 0;i<a.length;i++){
						var node = "<tr class='workdetail info'><td>"+a[i].id+"</td><td>"+a[i].username+"</td><td>"+a[i].employ_id+"</td><td>"+a[i].day+"</td><td>"+a[i].workstart+"</td><td>"+a[i].workstart_time+"</td><td>"+a[i].workend+"</td><td>"+a[i].workend_time+"</td></tr>";
						$(".table").append(node);
					}					
				});					
			});
		});
	</script>
  </body>
</html>
