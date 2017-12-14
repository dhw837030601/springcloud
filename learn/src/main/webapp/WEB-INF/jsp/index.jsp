<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>

</head>
<body>
    <div class="container">
        <table class="table">
            <caption>${sysUser}</caption>
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>User Name</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>aehyok</td>
                    <td>leo</td>
                    <td>@aehyok</td>
                </tr>
                <tr>
                    <td>lynn</td>
                    <td>thl</td>
                    <td>@lynn</td>
                </tr>
                <#list productList as p>
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.pic}</td>
                </tr>
                   </#list>
                
            </tbody>
        </table>
    </div>
<script src="static/bower_components/jquery/dist/jquery.min.js"></script>
<script src="static/bower_components/js-md5/jquery.md5.js"></script>
<script src="static/bower_components/js-md5/jquery.md5.js"></script>
<script src="static/bower_components/bootstrap-sass/assets/javascripts/bootstrap.min.js"></script>
<link rel="stylesheet" href="static/css/bootstrap.min.css"></link>

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