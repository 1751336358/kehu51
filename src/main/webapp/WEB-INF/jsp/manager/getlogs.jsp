<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>日志查看</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/getlogs/getlogs.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/comment/tablemodel.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
	 <div id="box">
	    <table class="table">
	    	<tr id="title">
	    		<td>标题</td>
	    		<td>员工id</td>
	    		<td>员工</td>
	    		<td>时间</td>
	    	</tr>
	    	<c:forEach items="${logs}" var="log">
	    	<tr class="logdetail info">
	    		<td><a href="${pageContext.request.contextPath}/getlogdetail?id=${log.id}">${log.title }</a></td>
				<td>${log.employ_id }</td>
				<td>${log.username}</td>
				<td>${log.committime }</td>
	    	</tr>
	    	</c:forEach>
	    </table>
	    <button id="nextPage">下一页</button><button id="prePage">上一页</button>
    </div>
	<script type="text/javascript">
		$(function(){
			var currentPage = 0;	//当前页数
			var table = $("table");
			
			 $("#prePage").click(function(){
				var url = "${pageContext.request.contextPath}/getlogbypage?userid=${sessionScope.user.id}&currentPage="+currentPage;
				if(currentPage >= 0){
					currentPage--;		
					$.get(url,true,function(data){
						//	box.html("");	//清空原有的内容
						//	eval("var a="+data);
							var a = data;
							$(".logdetail").remove();
							for(var i = 0;i<a.length;i++){
								var node = "<tr class='logdetail info'><td><a href='${pageContext.request.contextPath}/getlogdetail?id="+a[i].id+"'>"+a[i].title+"</a></td><td>"+a[i].employ_id+"</td><td>"+a[i].username+"</td><td>"+a[i].committime+"</td></tr>";
								$(".table").append(node);
							}					
					});
				}
			});
			$("#nextPage").click(function(){
				currentPage++;
				var url = "${pageContext.request.contextPath}/getlogbypage?userid=${sessionScope.user.id}&currentPage="+currentPage;			
				$.get(url,true,function(data){
					//	box.html("");	//清空原有的内容
					//	eval("var a="+data);
						var a = data;
						$(".logdetail").remove();
						for(var i = 0;i<a.length;i++){
							var node = "<tr class='logdetail info'><td><a href='${pageContext.request.contextPath}/getlogdetail?id="+a[i].id+"'>"+a[i].title+"</a></td><td>"+a[i].employ_id+"</td><td>"+a[i].username+"</td><td>"+a[i].committime+"</td></tr>";
							$(".table").append(node);
						}					
				});
			});
		})
	</script>
  </body>
</html>
