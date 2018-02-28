<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>left</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/left.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".menu").click(function(){
				var id = $(this).attr("id");	//menu_1,menu_2,menu_3
				var idIndex = id.split("_")[1];
		//		var idIndex = id.substring(5,6);//1,2,3
		//		alert(idIndex);
				//Ajax发送查询子菜单
				var url = "${pageContext.request.contextPath}"+"/getsonmenu/"+idIndex;
				$.get(url,true,function(data){
					var a = data;
					for(var i=0;i<a.length;i++){
						var sonClassName = ".sonmenu"+a[i].id;	//子菜单的id(sql)
						var parentClassname = ".sonmenu_"+a[i].parent_id;//子菜单div的class
						console.log("i="+i);
						if(i == 0){
							$(parentClassname).empty();
						}
						//拼接一个a标签,userid是当前登录用户的id号
						var node = "<a href=${pageContext.request.contextPath}/"+a[i].url+"?userid=${sessionScope.user.id} target=right>"+a[i].name+"</a><br/>";
						$(parentClassname).append(node);
					}				
				})
			});
			
		})
		
	</script>
  </head>
  
  <body>
   	 <%-- <h1>left.jsp</h1>
	   用户名:${sessionScope.user.username}<br/>
	   用户id:${sessionScope.user.id}<br/>
	   权限id:${authority.id }<br/>
	   权限名:${authority.name }<br/> --%>
	  <div class="box">
		  <c:forEach items="${authority.menus}" var="menu">
		   		<!--<a href="${pageContext.request.contextPath}/${menu.url}" target="right">${menu.name}</a><br/><br/>  -->
		   		<p id="menu_${menu.id}" class="menu">${menu.name}</p><!-- 父菜单 -->
		   		<div class="sonmenu_${menu.id} sonmenu">
		   			
		   		</div>
		   </c:forEach>
		   <a class="message" href="${pageContext.request.contextPath}/right" target="right">消息</a>
		   <a class="logout" href="${pageContext.request.contextPath}/logout" target="_blank">退出系统</a>   
	  </div>
	   
	   
  </body>
</html>
<!-- 
insert into menu(name,url,authority_id,parent_id) values('添加员工','addmanager',3,1);
insert into menu(name,url,authority_id,parent_id) values('删除员工','deletemanager',3,1);
insert into menu(name,url,authority_id,parent_id) values('修改员工信息','updatemanager',3,1);
 -->