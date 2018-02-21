<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户无忧</title>	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
  	<div id="box">
  		<div id="logo"><img src="${pageContext.request.contextPath}/images/logo.jpg"/></div>
  		<p id="text01">Sign in to kehu51</p>
  		<div id="operator">
  			 <form action="${pageContext.request.contextPath}/<%=response.encodeUrl("login")%>" method="post">
  			 	<p id="text02">username</p>
		    	<input id="username" type="text" name="username"/><br/>
		    	<p id="text03">password</p>
		    	<input id="password" type="text" name="password"/><br/>
		    	<select name="authorityid">
		    		<c:forEach items="${requestScope.authorityList}" var="authority">
		    			<option value="${authority.id}">${authority.name}</option>
		    		</c:forEach>
		    	</select>   	
		    	<input id="submit" type="submit"  value="登录"/>
		    </form>
  		</div>
  	</div>
    <div id="buttom">
    	<span>注册新客户</span><a href="${pageContext.request.contextPath}/gotocustomregisterpage">客户注册</a>
    </div>
   
    
  </body>
</html>
