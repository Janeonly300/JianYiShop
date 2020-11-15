<%--
  Created by IntelliJ IDEA.
  User: 简一
  Date: 2020/11/14
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    function x() {
        $.get('loginOut', null, function (data) {
            if (data == 'true') {
                window.location = '/JianYiShop/login.jsp'
            }
        });
    }
</script>
<div class="zuo fl">
    <h3><a href="#"><img src="img/tx.png"/></a>
        <p class="clearfix"><span class="fl">[${user.userName}]</span><a class="fr" href="javaScript:x()">[退出登录]</a></p></h3>
    <div><h4>我的交易</h4>
        <ul>
            <li><a href="cart.jsp">我的购物车</a></li>
            <li><a href="myorderq.jsp">我的订单</a></li>
            <li><a href="myprod.jsp">评价晒单</a></li>
        </ul>
        <h4>个人中心</h4>
        <ul>
            <li class="on"><a href="mygxin.jsp">我的中心</a></li>
            <li><a href="address.jsp">地址管理</a></li>
        </ul>
        <h4>账户管理</h4>
        <ul>
            <li><a href="mygrxx.jsp">个人信息</a></li>
            <li><a href="remima.jsp">修改密码</a></li>
        </ul>
    </div>
</div>