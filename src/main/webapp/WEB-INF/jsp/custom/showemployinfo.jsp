<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changemyinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/showemployinfo.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
  	<div id="box">
    	<table>
    		<tr id="title">
    			<td>用户名</td>
    			<td>用户信息</td>
    			<td>部门</td>
    			<td>部门信息</td>
    		</tr>
    		<tr class="info">
    			<td>${employ.username }</td>
    			<td>${employ.info }</td>
    			<td>${department.name }</td>
    			<td>${department.info }</td>
    		</tr>
    	</table>
    	<br/>
    	<textarea id="content" name="content"></textarea><br/>
    	<button id="submit">评论</button><br/><br/><br/>
    	<p id="text01">最近20条评论</p>
    	<table>
    		<tr id="title">
    			<td>用户</td>
    			<td>内容</td>
    			<td>发表时间</td>
    		</tr>
    		<c:forEach items="${comments}" var="comment">
    		<tr class="info">
    			<td>${comment.username}</td>
    			<td>${comment.content}</td>
    			<td>${comment.commenttime}</td>
    		</tr>
    		</c:forEach>
    	</table>
    	
  	</div>
    	
    	
    	<script type="text/javascript">
    		$("#content").focus(function(){
    			$("#content").css({"width":"100%","height":"100px"});
    		});
    		$("#content").blur(function(){
    			$("#content").css({"width":"30%","height":"40px"});
    		});
    		$("#submit").click(function(){
    			var content = $("#content").val();	//评论内容
    			/* var username = "${sessionScope.user.username}";	//客户用户名
    			var employ_id = "${employ.id }";	//员工id
    			var custom_id = "${sessionScope.user.id}";	//客户id */
    			if(content==''){
    				alert("内容不能为空");
    				return;
    			}
    			var url = "${pageContext.request.contextPath}/addcomment?content="+content;
    			$.get(url,true,function(data){
    			//	eval("var message="+data);
    				var message = data;
    				$("#content").val("");	//清空评论框
    				alert(message);
    			});
    		});
    	</script>
    	
    	
  </body>
</html>
