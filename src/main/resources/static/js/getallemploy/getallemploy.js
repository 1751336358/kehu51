/*
2018-02-20
*/
$(function(){
	//发送消息
	var btn = $(".footer button");
	btn.click(function(){
		var messageContent = $(".footer textarea").val();
		if(messageContent==''){
			alert("请输入发送的内容");
			return;
		}
		//:check被选择的input标签
		var checkbox = $("#box table .info td input:checked");
		var selected = "";
		checkbox.each(function(){
			selected += $(this).val();
			selected += ":";
		});
		if(selected==""){
			alert("请勾选员工");
			return;
		}
		var batSendMessage = "http://localhost:8081/kehu51/batSendMessage";
		$.post(batSendMessage,"selected="+selected+"&messageContent="+messageContent,function(message){
			alert(message);	//弹出消息发送状态
		});
	});
	//根据employId查custom信息
	$("#box table .info .customDetail").click(function(){
		var userid = $(this).attr('value');
		var url = "http://localhost:8081/kehu51/queryCustomDetailByEmployId";
		$.post(url,"userid="+userid,function(data){
			//显示员工信息详情框
			$("#box div").remove("#box .showDetailBox");
			$("#box").append("<div class='showDetailBox'></div>");
			var len = data.length;
			for(var i = 0;i<len;i++){
				var username = data[i].username;
				var birthday = data[i].birthday;
				var email = data[i].email;
				var phoneNumber = data[i].phoneNumber;
				var registerTime = data[i].registerTime;
				var node = "<div>" +
							"<div class='index'>第"+(i+1)+"位</div>"+
							"<p>名字："+username+"</p>"+
							"<p>手机号："+phoneNumber+"</p>"+
							"<p>邮箱："+email+"</p>"+
							"<p>生日："+birthday+"</p>"+
							"<p>注册时间:"+registerTime+"</p>"
						"</div>";
				$("#box .showDetailBox").append(node);
			}
		});
		
	});
})