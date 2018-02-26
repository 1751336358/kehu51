/*
2018-02-20
*/
$(function(){
	var btn = $(".footer button");
	btn.click(function(){
		var massageContent = $(".footer textarea").val();
		//:check被选择的input标签
		var checkbox = $("#box table .info td input:checked");
		var selected = "";
		checkbox.each(function(){
			selected += $(this).val();
			selected += ":";
		});
		var batSendMessage = "http://localhost:8081/kehu51/batSendMessage";
		$.post(batSendMessage,"selected="+selected+"&massageContent="+massageContent,function(message){
			alert(message);	//弹出消息发送状态
		});
	});
})