<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page contentType="image/gif"%> --%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>

</head>
<body>
    <div>
        <form>
            <table>
                <tr>
                    <td>用户名:<input type="text" name="userName" id="userName" value=""/></td>
                </tr>
                <tr>
                    <td>密码:<input type="password" name="password" id="password" value=""/></td>
                </tr>
                <tr>
                    <td>
                    	验证码:<input type="text" name="verifiCode" id="verifiCode" value=""/>
                    	<img id="imageCode" src="" class="imageCode srInput srInput-code changeImageCode">
                    	<span id="changeImageCode">换一张</span>
                    </td>
                </tr>
                <!-- <div class="row">
                    <div class="col-xs-5 name" >图片验证码：</div>
                    <div class="col-xs-7 val">
                        <input type="text" value="" name="userImageCode" class="srInput" id="userImageCode">
                        <img id="imageCode" src="" class="imageCode srInput srInput-code changeImageCode" value="短信获取">
                        <span id="changeImageCode">换一张</span>
                    </div>
                </div> -->
                <tr>
                    <td><input type="button" id="registerBtn" value="注册"/></td>
                </tr>

            </table>
        </form>
    </div>
<script src="static/bower_components/jquery/dist/jquery.min.js"></script>
<script src="static/bower_components/js-md5/jquery.md5.js"></script>
<script>
	var flag = false;
	$(function(){
		
        var _this = this;
        showCode();
        $("#vrifiCode").blur(function(){
        	var code = $("#vrifiCode").val();
        	$.ajax({
           	 	type:'POST',
                url:'/verifiTheCode',
                data:{'code':code},
                dataType:'json',
                success:function (data){
               	 data = eval('('+data+')')
               	 alert(data);
                    if(data!="1"){
                        alert("验证码错误");
                    }else{
                        flag = true;
                    }
                }
           });
        });
        $("#changeImageCode").click(function () {
         	showCode();
        });
	});
	
	function showCode() {
        var $imageCode = $('.imageCode'),
            random = Math.random(),
            url = '/getImgCode';
        $imageCode.attr('src', url);
    }

     $("#registerBtn").click(function(){
    	 if(flag){
	   		var userName = $("#userName").val();
	        var pwd = $("#password").val();
	        var code = $("#verifiCode").val();
	        var saltstr="HXWcjvQWVG1wI4FQBLZpQ3pWj48AV63d";
			var password=$.md5($.md5(pwd.trim())+saltstr);
			alert(code);
	        $.ajax({
	        	 type:'POST',
	             url:'/register',
	             data:{'userName':userName,'password':password,'code':code},
	             dataType:'json',
	             success:function (data){
	            	 data = eval('('+data+')')
	                 if(data!="1"){
	                     alert("注册失败");
	                     window.location.reload();
	                 }else{
	                     alert("注册成功");
	                     window.location.href="/index";
	                 }
	             }
	        });
    	 }else{
    	 	alert("验证码错误");
    	 }
     });
</script>
</body>
</html>