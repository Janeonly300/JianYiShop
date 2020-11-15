<%--
  Created by IntelliJ IDEA.
  User: 简一
  Date: 2020/11/10
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/canlendar.js" type="text/javascript"></script>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/function.js"></script>
    <style>
        .reg p .error{
            display: inline-block;
            line-height: 1px;
            border: 1px solid #ff855a;
            background-color: #ffe8e0;
            color: red;
            padding: 25px;
            margin-left: 20px;
        }
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="registerServlet" method="post" onsubmit="return checkedFromAll(this)"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <h1 style="padding: 0px;margin: 0px;font-size: 30px;text-align: center;background-color: #3344AA;color: #fff">用户注册</h1>
        <p><input type="text" onfocus="onfocusItem(this)" onblur="onblurItem(this)" name="userName" placeholder="请输入用户名"><span></span></p>
        <p><input type="text" onfocus="onfocusItem(this)" onblur="onblurItem(this)" name="name" value="" placeholder="请输入真实姓名"><span ></span></p>
        <p><input type="text" id="pwd" onfocus="onfocusItem(this)" onblur="onblurItem(this)" name="pwd" value="" placeholder="请输入密码"><span ></span></p>
        <p><input type="text"  onfocus="onfocusItem(this)" onblur="onblurItem(this)" name="rePwd" value="" placeholder="请再次输入密码"><span ></span></p>
        <p><input width="15px" onfocus="onfocusItem(this)" onblur="onblurItem(this)" type="radio" name="sex" checked value="t">男 <input width="15px"  type="radio" name="sex" value="f">女</p>
        <p><input type="date" name="birth" value="" placeholder="请输入您的生日"></p>
        <p><input type="email"  name="email" value="" placeholder="请输入邮箱"><span></span ></p>
        <p><input type="text"  onfocus="onfocusItem(this)" onblur="onblurItem(this)" name="phone" value="" placeholder="请输入您的电话"><span ></span></p>
        <p><input type="text" onfocus="onfocusItem(this)" onblur="onblurItem(this)" name="address" value="" placeholder="请输入您的地址"><span ></span></p>
        <p class="text"><input onfocus="onfocusItem(this)" onblur="onblurItem(this)" class="code" type="text" name="code" value="" placeholder="验证码"><span></span>
            <img onclick="javaScript:setImage(this)"
                src="/JianYiShop/checkCode"/></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>