function showEmployInfo(id){
	//根据用户id查用户信息
	$.post("/kehu51/updateemployid","employ_id="+id,function(data){
		if(data == true){
			alert("更换员工成功!!!");
			return;
		}
		alert("更换员工失败!!!");
	});
}