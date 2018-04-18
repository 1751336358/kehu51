<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/right/right.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/right/right.js"></script>
  </head>
  
  <body>
  <!-- 不能加/，否则是以根路径 -->
  <!--  <img src="kehu51\ccc.jpg" /> -->
  	<div class="cover none"></div>
  	<div class="cbox none">
  		<p class="closeWindow" onclick=closeWindow()><img src="${pageContext.request.contextPath}/images/right/closeWindow.png" /></p>
  		<div class="msgInfo"></div>
  	</div>
   	<div class="box">
   		<div class="new msgBox">
   			<div class="head">
   				最新消息(刷新)
   			</div>
   			<div class="msgBody">
   				<!-- <div class="msg" onclick=openWindow(this)><p class="sname">employ1</p><p class="type">补卡消息1</p><p class="time">2018-02-14 15:30</p><p class="content">一直回车,会将redis启动程序6379.conf复制到/etc/init.d下，命一直回车,会将redis启动程序6379.conf复制到/etc/init.d下，命一直回车,会将redis启动程序6379.conf复制到/etc/init.d下，命</p><div class="other"></div></div>-->
   			</div>
   		</div>
   		<div class="histroy msgBox">
   			<div class="head">
   				历史消息(刷新)				
   			</div>
   			<div class="msgBody">
   				<!-- <div class="msg" onclick=openWindow(this)><p class="sname">employ1</p><p class="type">补卡消息1</p><p class="time">2018-02-14 15:30</p><p class="content">一直回车,会将redis启动程序6379.conf复制到/etc/init.d下，命一直回车,会将redis启动程序6379.conf复制到/etc/init.d下，命一直回车,会将redis启动程序6379.conf复制到/etc/init.d下，命</p><div class="other"></div></div>-->
   			</div>
   		</div>
   		<div class="hasSend msgBox">
   			<div class="head">
   				已发送消息(刷新)
   			</div>
   			<div class="msgBody">
   				<!-- <div class="msg">
   					<p class="sname">manager2</p>
   					<p class="type">补卡消息1</p>
   					<p class="time">2018-02-14 15:30</p>
   					<p class="content">一直回车,会将redis启动程序6379.conf复制到/etc/init.d下，命一直回车,会将redis启动程序6379.conf复制到/etc/init.d下，命一直回车,会将redis启动程序6379.conf复制到/etc/init.d下，命</p>
   					<div class="other"></div>
   				</div> -->
   			</div>
   		</div>
   		<script type="text/javascript">
   		function closeWindow(){
			var cover = $(".cover");
   			var cbox = $(".cbox");
   			cover.removeClass("block");
   			cbox.removeClass("block");
   			cover.addClass("none");
   			cbox.addClass("none"); 			
   		}
	   	//弹出窗口
   		var openWindow = function(This){
   			var msg = $(".box .msgBox .msgBody .msg");   			
			var cover = $(".cover");
			var cbox = $(".cbox");
			cover.addClass("block");
			cbox.addClass("block");
			cover.removeClass("none");			
			cbox.removeClass("none");
			cbox.empty();
			cbox.append("<p class='closeWindow' onclick=closeWindow()><img src='${pageContext.request.contextPath}/images/right/closeWindow.png' /></p>");
			cbox.append("<div class='msgInfo'>");
			var msgInfo = $(".cbox .msgInfo");
			var childNodes = This.childNodes;	//.msg p标签的引用

			for(var i=0;i<childNodes.length-1;i++){
			//	console.log(childNodes[i].innerHTML);	//p标签里的内容 sname type content time
				msgInfo.append("<p>"+childNodes[i].innerHTML+"</p>");
			}
			var mapContent = childNodes[childNodes.length-1].childNodes;	//.other p里的内容
			if(mapContent.length==0){
				console.log("为空");
				return;
			}
			for(var i=0;i<mapContent.length;i++){
				var span = mapContent[i].childNodes;	//.other p span
		/*		console.log(span);
				console.log(span[0].innerHTML);	//key
				console.log(span[1].innerHTML);	//value
		*/
				msgInfo.append("<p>"+span[0].innerHTML+":"+span[1].innerHTML+"</p>");
			}
			cbox.append("</div>");
   	   	}
	   	
   		/**
   		 * 处理消息中的url
   		 */
   		function dealUrl(e){
   			//阻止a标签的默认跳转事件
	   		 if ( e && e.preventDefault ) 
	   	      e.preventDefault(); 
	   	     else 
	   	        window.event.returnValue = false;
   			//事件对象
	   		var event = e || window.event;
   			//事件源对象
   			var eventSrc = event.srcElement ? event.srcElement : event.target;
   			var url = eventSrc.href;
   			//发送ajax请求给不同的controller处理不同的业务，由于页面很少，所以最好不用页面跳转，直接ajax请求处理
   			//数据返回的格式也要一致，是一个String类型，标记消息处理结果
   			$.get(url,function(data){
   				alert(data);
   			});
   		}
   		</script>
   	</div>
  </body>
</html>
