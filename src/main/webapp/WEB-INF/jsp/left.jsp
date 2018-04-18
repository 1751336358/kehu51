<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/css/left/zzsc.css">
<link rel=stylesheet type=text/css href="${pageContext.request.contextPath}/css/left/left.css">
<script type=text/javascript src="${pageContext.request.contextPath}/js/left/jquery.min.js"></script>
</head>
<body>
<!-- 代码 开始 -->
 <div id="firstpane" class="menu_list" style="margin-left:0px;">
 	<c:forEach items="${sessionScope.menuVOList }" var="menuVO">
 		<p class="menu_head current">${menuVO.fMenu.name }</p>
	    <div style="display:block" class=menu_body >
	    	<c:forEach items="${menuVO.sMenu}" var="menu">
	    		<a href="${pageContext.request.contextPath}/${menu.url}?userid=${sessionScope.user.id}" target="right">${menu.name }</a>
	    	</c:forEach>      
	    </div>
 	</c:forEach>
 	<p class="menu_head current"><a style="text-decoration: underline;" class="message" href="${pageContext.request.contextPath}/right" target="right">消息</a></p>
	<p class="menu_head current"><a style="text-decoration: underline;" class="logout" href="${pageContext.request.contextPath}/logout" target="_blank">退出系统</a></p> 
</div>
<script type=text/javascript>
$(document).ready(function(){
	$("#firstpane .menu_body:eq(0)").show();
	$("#firstpane p.menu_head").click(function(){
		$(this).addClass("current").next("div.menu_body").slideToggle(300).siblings("div.menu_body").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
	$("#secondpane .menu_body:eq(0)").show();
	$("#secondpane p.menu_head").mouseover(function(){
		$(this).addClass("current").next("div.menu_body").slideDown(500).siblings("div.menu_body").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
	
});
</script>

<!-- 代码 结束 -->
</body>
</html>