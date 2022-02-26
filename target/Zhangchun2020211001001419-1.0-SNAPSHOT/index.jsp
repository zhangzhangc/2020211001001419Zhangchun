<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="main.css">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>

<body>
<div id="container-login">
    <div id="title">
        <i class="material-icons lock">登录界面</i>
    </div>

    <form>
        <div class="input">
            <div class="input-addon">
                <i class="material-icons">账号</i>
            </div>
            <input id="username" placeholder="请输入账号" type="text" required class="validate" autocomplete="off">
        </div>

        <div class="clearfix"></div>

        <div class="input">
            <div class="input-addon">
                <i class="material-icons">密码</i>
            </div>
            <input id="password" placeholder="密码" type="password" required class="validate" autocomplete="off">
        </div>

        <div class="remember-me">
            <input type="checkbox">
            <span style="color: #DDD">记住我</span>
        </div>

        <input type="submit" value="登录" />
    </form>

    <div class="forgot-password">
        <a href="#">忘记密码？</a>
    </div>


    <div class="register">
        还没有账户？
        <a href="#"><button id="register-link">在这里注册</button></a>
    </div>
</div>
</body>

</html>