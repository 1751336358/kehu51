<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tablemodel.css">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/workstartend.css">	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#workstart").click(function(){
				var url = "${pageContext.request.contextPath}/workstart?userid=${sessionScope.user.id}";	//附带请求参数
				$.get(url,true,function(data){
				//	eval("var a="+data);
					var a = data;
					console.log(a);
					alert(a);	//弹出回馈信息
				})
			})
			$("#workend").click(function(){
				var url = "${pageContext.request.contextPath}/workend?userid=${sessionScope.user.id}";	//附带请求参数				
				$.get(url,true,function(data){
				//	eval("var a="+data);
					var a = data;
					alert(a);	//弹出回馈信息
				})
			})
			//申请补卡
			$("#appeal").click(function(){
				$("#cover").css("display","block");
				$("#msg_box").css("display","block");
			});
			//关闭窗口
			$("#msg_box #closeWindow").click(function(){
				$("#cover").css("display","none");
				$("#msg_box").css("display","none");
			});
			//签到/签退焦点事件
			var radio = 1;
			$("#msg_box #form #select input").focus(function(){
			//	console.log($(this).val());
				radio = $(this).val();
			});
			//申请按钮提交
			$("#msg_box #form #appeal_btn button").click(function(){
				//首先查询该日期是否已经签到或签退
				var bukaTime = $(".bukaTime").val();
				var content = $(".content").val();
				var hasDaka = false;
				var hasDakaUrl = "${pageContext.request.contextPath}/hasDaka"
				$.post(hasDakaUrl,"radio="+radio+"&bukaTime="+bukaTime,function(data){
					hasDaka = data;
					if(hasDaka === true){	//如果已经打卡
						//dom操作
					//	alert("补卡成功");
					}else{
						alert("已经打卡了，补卡失败");
						return;
					}
					//申请打卡
					var url = "${pageContext.request.contextPath}/appealBuka";
					 $.post(url,"bukaTime="+bukaTime+"&content="+content+"&radio="+radio,function(data){
						if(data === true){
							alert("申请补卡成功");
						}else{
							alert("系统错误，消息未能发送成功");
						}
					}); 
				});
				
				
			});		
		})
	</script>
  </head>
  
  <body>
  	<div id="cover"></div>
  	<div id="msg_box">
  		<div id="closeWindow">X</div>
  		<div id="form">
  			<div id="time">
  				<lable>补卡时间:</lable><input class="bukaTime" name="bukaTime" type="date" />
  			</div>
  			<div id="reason">
  				<lable>申请理由:</lable><textarea class="content" name="content"></textarea>
  			</div>
  			<div id="select">
  				<input id="input1" type="radio" name="radio" checked="checked" value="1" /><label id="lable1">签到</label><input id="input2" type="radio" name="radio" value="2" /><label id="lable2">签退</label>
  			</div>
  			<div id="appeal_btn">
  				<button>申请</button>
  			</div>
  			
  			
  		</div>
  	</div>
    <div id="box">
	    <button id="workstart">点击签到</button>
	    <button id="workend">点击签退</button>
	    <button id="appeal">申请补卡</button> 
	    <table>
	    	<tr id="title">
	    		<td>签到id</td>
	    		<td>签到日期</td>
	    		<td>我的id</td>
	    		<td>是否签到</td>
	    		<td>签到时间</td>
	    		<td>是否签退</td>
	    		<td>签退时间</td>
	    	</tr>
	    	<c:forEach items="${works}" var="work">
	    		<tr class="info">   			
	    			<td>${work.id}</td>
	    			<td>${work.day }</td>
	    			<td>${work.employ_id}</td>
	    			<td>${work.workstart}</td>
	    			<td>${work.workstart_time}</td>
	    			<td>${work.workend}</td>
	    			<td>${work.workend_time}</td>
	    		</tr>
	    	</c:forEach>
	    </table>
    </div>
  </body>
</html>
