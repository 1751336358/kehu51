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
	  			queryHistroyMessage();
	  			return;
	  		}else if(messageList.length == 0){
	  			console.log("新消息长度==0");
	  			queryHistroyMessage();
	  			return;
	  		}
	  		msgBody.empty();
	  		for(var i = 0;i<messageList.length;i++){
	  			var msg = messageList[i];
	  			var map = messageList[i].contentMap;
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
	  		//查询历史消息
	  		queryHistroyMessage();
	  	});
	}
	var queryHistroyMessage = function(){
		var histroyMsg = "http://localhost:8081/kehu51/queryHistroyMessage";
	  	$.post(histroyMsg,null,function(data){
	  		var messageList = data;
	  		var msgBody = $(".box .histroy .msgBody");
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
	//刷新历史消息
	$(".box .histroy .head").click(function(){
		queryHistroyMessage();
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