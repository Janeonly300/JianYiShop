<%--
  Created by IntelliJ IDEA.
  User: 简一
  Date: 2020/11/15
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>『简一商城』后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
</head>
<body>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <span>${error}</span>
            <form action="/JianYiShop/manager/adminLogin" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="userName" value="" id="user" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="pwd" value="" id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="code">验证码:</label>
                        <input type="text" name="code" id="code" size="40" class="admin_input_style">
                        <img src="/JianYiShop/checkCode" onclick="cheanager(this)">
                        <script>
                            function cheanager(img) {
                                img.src = '/JianYiShop/checkCode?only='+new Date().getMilliseconds();
                            }
                        </script>
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="#" target="_blank">返回首页</a> &copy; 2014 Powered by 更多模板：<a href="http://www.lmonkey.com/" target="_blank">学习猿地</a></p>
</div>
</body>
</html>
