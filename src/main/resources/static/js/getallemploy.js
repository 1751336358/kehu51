/*
2018-02-20
*/
$(function(){
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
		$.post(batSendMessage,"selected="+selected+"&massageContent="+messageContent,function(message){
			alert(message);	//弹出消息发送状态
		});
	});
})