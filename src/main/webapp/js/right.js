$(function(){
	//已发消息
	var queryHasSendMsg = function(){
		var hasSendMsg = "http://localhost:8081/kehu51/queryHasSendMsg";
	  	$.post(hasSendMsg,null,function(data){
	  		var messageList = data;
	  		var msgBody = $(".box .hasSend .msgBody");
	  		if(messageList == null){
	  			console.log("已发送消息==null");
	  			return;
	  		}else if(messageList.length == 0){
	  			console.log("已发送消息长度==0");
	  			return;
	  		}
	  		msgBody.empty();
	  		for(var i = 0;i<messageList.length;i++){
	  			var msg = messageList[i];
	  			var map = messageList[i].contentMap;
	  			console.log(map);
	  			var node = "<div class='msg' onclick=openWindow(this)><p class='sname'>目标:"+msg.distince_queue+"</p><p class='type'>"+msg.type+"</p><p class='time'>"+msg.time+"</p><p class='content'>"+msg.content+"</p>"
	  			var other = "<div class='other' hidden>";
	  			if(map != null){
	  				for(var key in map){
	 	  		  console.log("新消息属性：" + key + ",新消息值：" + map[key]);
	 	  		  var value = map[key];
	 	  		  other += "<p><span class='s1'>"+key+"</span><span class='s2'>"+value+"</span></p>"
	 	  		}
	  				other += "</div>";
	  			}else{
	  				console.log("map==null");
	  			}  		  
	  			msgBody.append(node+other);
	  		}
	  	});
	}
		
	//新消息
	var queryNewMsg = function(){
		var hasSendMsg = "http://localhost:8081/kehu51/queryNewMessage";
	  	$.post(hasSendMsg,null,function(data){
	  		var messageList = data;
	  		var msgBody = $(".box .new .msgBody");
	  		if(messageList == null){
	  			console.log("新消息==null");
	  			return;
	  		}else if(messageList.length == 0){
	  			console.log("新消息长度==0");
	  			return;
	  		}
	  		msgBody.empty();
	  		for(var i = 0;i<messageList.length;i++){
	  			var msg = messageList[i];
	  			var map = messageList[i].contentMap;
	  			console.log(map);
	  			var node = "<div class='msg' onclick=openWindow(this)><p class='sname'>来源:"+msg.source_queue+"</p><p class='type'>"+msg.type+"</p><p class='time'>"+msg.time+"</p><p class='content'>"+msg.content+"</p>"
	  			var other = "<div class='other' hidden>";
	  			if(map != null){
	  				for(var key in map){
	 	  		  console.log("新消息属性：" + key + ",新消息值：" + map[key]);
	 	  		  var value = map[key];
	 	  		  other += "<p><span class='s1'>"+key+"</span><span class='s2'>"+value+"</span></p>"
	 	  		}
	  				other += "</div>";
	  			}else{
	  				console.log("map==null");
	  			}  		  
	  			msgBody.append(node+other);
	  		}
	  	});
	}
	
	//刷新已发送消息
	queryHasSendMsg();
	$(".box .hasSend .head").click(function(){
		queryHasSendMsg();
	});
	//刷新新消息
	queryNewMsg();
	$(".box .new .head").click(function(){
		queryNewMsg();
	});
	
	//关闭弹框
	function closeWindow(){
		var cover = $(".cover");
		var cbox = $(".cbox");
		cover.removeClass("block");
		cbox.removeClass("block");
		cover.addClass("none");
		cbox.addClass("none");
	}
	
	
})