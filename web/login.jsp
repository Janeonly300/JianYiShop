<%--
  Created by IntelliJ IDEA.
  User: 简一
  Date: 2020/11/12
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="loginServlet" method="post"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p style="color: red">${error}</p>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p><input type="text" name="username" value="" placeholder="用户名"></p>
        <p><input type="text" name="pwd" value="" placeholder="密码"></p>
        <p><input type="submit" value="登  录"></p>
        <p class="txt"><a class="" href="reg.html">免费注册</a><a href="forget.html">忘记密码？</a></p></form>
</div>
</body>
</html>
