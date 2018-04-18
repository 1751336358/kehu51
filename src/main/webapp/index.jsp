<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>客户无忧</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
		<base href="<%=basePath%>">
        <!-- CSS -->
        <link rel='stylesheet' href='${pageContext.request.contextPath}/css/index/font.css'>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index/supersized.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>Login kehu51</h1>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <input type="text" name="username" class="username" placeholder="Username">
                <input type="password" name="password" class="password" placeholder="Password">
                <button type="submit">Sign me in</button>
                <p id="warning"></p>
                <div class="error" style="width:0px;height:0px;"><span>not null</span></div>
            </form>
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
        </div>
        <div align="center">Collect from <a href="${pageContext.request.contextPath}/gotocustomregisterpage" title="客户注册">客户注册</a></div>

        <!-- Javascript -->
        <script src="${pageContext.request.contextPath}/js/index/jquery-1.8.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/index/supersized.3.2.7.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/index/supersized-init.js"></script>
        <script src="${pageContext.request.contextPath}/js/index/scripts.js"></script>

    </body>

</html>


