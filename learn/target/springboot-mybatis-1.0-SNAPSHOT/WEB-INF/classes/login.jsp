<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>C:\Users\admin-01\workspace\learn\src\main\webapp\static\bower_components\jquery\dist\jquery.min.js

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
        alert($("#userName").val());
        alert($("#password").val());
        var newPwd = md5($("#password").val());
        alert(newPwd);

         alert("登录成功");
     });

</script>
</body>
</html>