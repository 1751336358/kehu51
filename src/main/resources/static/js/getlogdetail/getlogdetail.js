/*
2018-02-20
*/
$(function(){
	var btn = $(".box .hasRead");
	//点击标记已读发消息
	btn.click(function(){
		var title = $(".box .title p span").html();
		var username = $(".box .footer .username span").html();
		var userid = $(".box .footer .userid span").html();
		var url = "http://localhost:8081/kehu51/tagHasBeenRead";
		$.post(url,"title="+title+"&username="+username+"&userid="+userid,function(data){
			alert(data);
		});
	});
})