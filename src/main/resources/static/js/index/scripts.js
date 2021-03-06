
jQuery(document).ready(function() {
	var inputOk = false;
	//检查输入用户名和密码是否正确
	$('.page-container form .password').blur(function(){
		
		var username = $('.page-container form .username').val();
		var password = $('.page-container form .password').val();
		$.post('/kehu51/checkInput','username='+username+"&password="+password,function(data){
			if(data==1){	//可正常登陆
				$("#warning").html("");
				inputOk = true;
			}else if(data == 0){	//用户名密码输入错误
				inputOk = false;
				//dom操作显示错误信息
				$("#warning").html("");
				$('.page-container form .error span').html('input error');
				$('.page-container form .error').fadeIn('fast', function(){});
			}else if(data == -1){	//员工被禁用
				inputOk = false;
				$("#warning").html("该用户名已被禁用");
			}
		});
	});
    $('.page-container form').submit(function(e){
    //	alert(inputOk);
    	//如果输入的用户名或密码错误，阻止提交
    	if(inputOk == false){
    		//阻止提交按钮的的默认跳转行为，改为ajax发送请求
    		if ( e && e.preventDefault ) 
    	  	      e.preventDefault(); 
    	  	 else 
    	  	      window.event.returnValue = false;
    		return;
    	} 		
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        if(username == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function(){
            	$('.page-container form .error span').html('not null');
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if(password == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function(){
            	$('.page-container form .error span').html('not null');
                $(this).parent().find('.password').focus();
            });
            return false;
        }
        //登录表单提交地址
        var url = $(this).attr('action');	//	/kehu51/loginIn
        $.post(url,"username="+username+"&password="+password,function(data){
        	//跳转
        });
    });

    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});
