<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>

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
                    <td><input type="button" id="loginBtn" value="登录"/></td>
                </tr>

            </table>
        </form>
    </div>
<script src="static/bower_components/jquery/dist/jquery.min.js"></script>
<script src="static/bower_components/js-md5/build/md5.min.js"></script>
<script>
     $("#loginBtn").click(function(){
        var userName = $("#userName").val();
        var salt = "HXWcjvQWVG1wI4FQBLZpQ3pWj48AV63d";
        var newPwd = md5($("#password").val()+salt);
        //alert(newPwd);
        $.ajax({
        	 type:'POST',
             url:'/login',
             data:{'userName':userName,'password':newPwd},
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

         alert("登录成功");
     });

</script>
</body>
</html>