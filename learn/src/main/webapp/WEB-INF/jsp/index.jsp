<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>

</head>
<body>
    <div>
        欢迎springboot 平台
    </div>
<script src="static/bower_components/jquery/dist/jquery.min.js"></script>
<script src="static/bower_components/js-md5/jquery.md5.js"></script>
<script>
     /* $("#loginBtn").click(function(){
        var userName = $("#userName").val();
        var saltstr="HXWcjvQWVG1wI4FQBLZpQ3pWj48AV63d";
		var password=$.md5($.md5($("#password").val().trim())+saltstr);
        $.ajax({
        	 type:'POST',
             url:'/login',
             data:{'userName':userName,'password':password},
             dataType:'json',
             success:function (data){
                 if(data.ecode!="1"){
                     alert("用户名或密码错误");
                     window.location.reload();
                 }else{
                     alert("登录成功");
                     window.location.href="";
                 }
             }
        });
     }); */

</script>
</body>
</html>