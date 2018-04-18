<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="${pageContext.request.contextPath}/css/registerFail/pintuer.css" rel="stylesheet"/>
</head>

<body>
<div class="container" style=" margin-top:8%;"> 
   <div class="panel margin-big-top">
      <div class="text-center">
         <br>
         <h2 class="padding-top"> <stong>抱歉，该用户名已被注册！</stong> </h2>
         <div class=""> 
            <div class="float-left">
                <img src="${pageContext.request.contextPath}/images/registerFail/ds-1.gif">
                <div class="alert"> 卧槽！被注册了 </div>
            </div>
            <div class="float-right">
               <img src="${pageContext.request.contextPath}/images/registerFail/ds-2.png" width="260"> 
            </div>
          </div>
          <div class="padding-big">
               <a href="${pageContext.request.contextPath}" class="button bg-yellow">返回首页</a>
              <!--  <a href="" class="button">保证不打死管理员</a> -->
          </div> 
      </div> 
   </div> 
</div>
</body>
</html>
