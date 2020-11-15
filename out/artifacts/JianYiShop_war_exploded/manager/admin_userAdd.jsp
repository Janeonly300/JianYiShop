<%--
  Created by IntelliJ IDEA.
  User: 简一
  Date: 2020/11/8
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="admin_meun.jsp"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/JianYiShop/manager/douserservelt">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/JianYiShop/manager/admin_douseradd" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>用户名：</th>
                            <td>
                                <input class="common-text required" id="title" name="userName" size="50" value="" type="text">
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>姓名：</th>
                            <td><input class="common-text" name="name" size="50" type="text"></td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>登陆密码：</th>
                            <td><input class="common-text" name="password" size="50" type="text"></td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>确认密码：</th>
                            <td><input class="common-text" name="rePassword" size="50"  type="text"></td>
                        </tr>

                        <tr>
                            <th>性别：</th>
                            <td>
                                <input class="common-text" name="sex" size="50"  value="t" checked type="radio">男
                                <input class="common-text" name="sex" size="50"  value="f" type="radio">女</td>
                        </tr>

                        <tr>
                            <th>出生日期：</th>
                            <td><input class="common-text" name="birth" size="50"  type="text"></td>
                        </tr>

                        <tr>
                            <th>电子邮箱：</th>
                            <td><input class="common-text" name="email" size="50"  type="email"></td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>手机号码：</th>
                            <td><input class="common-text" name="phone" size="50"  type="text"></td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>送货地址：</th>
                            <td><input class="common-text" name="address" size="50"  type="text"></td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>