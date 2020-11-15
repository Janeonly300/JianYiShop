<%--
  Created by IntelliJ IDEA.
  User: 简一
  Date: 2020/11/8
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="admin_meun.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script>
        function del(id,name){
            var falg = confirm("确定要删除"+name+"嘛?");
            if(falg){
                //如果确定
                window.location= "/JianYiShop/manager/douserDel?id="+id+"";
            }else{
                alert("别tm乱点")
            }
        }

        function submitT(){
            if(confirm("您确定要删除这些用户吗？")){
                var from = document.getElementById("myform");
                from.submit();
            }

        }
        function selectAll(o){
            var a = document.getElementsByName("id[]");
            for (var i =0;i<a.length;i++){
                a[i].checked = o.checked;
            }
        }
    </script>
</head>
<body>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="get">
                    <table class="search-tab">
                        <form action="/JianYiShop/manager/douserservelt" method="get"></form>
                        <tr>
<%--                            <th width="120">选择分类:</th>--%>
<%--                            <td>--%>
<%--                                <select name="search-sort" id="">--%>
<%--                                    <option value="">全部</option>--%>
<%--                                    <option value="19">精品界面</option><option value="20">推荐界面</option>--%>
<%--                                </select>--%>
<%--                            </td>--%>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="用户名称" name="keywords" value="${serach}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <c:if test="${success}">
            <script>
                alert("修改成功")
            </script>
        </c:if>
        <div class="result-wrap">
            <form action="/JianYiShop/manager/douserDel" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_userAdd.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:submitT()"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" onclick="selectAll(this)" name="" type="checkbox"></th>
                            <th>ID</th>
                            <th>REALNAAME</th>
                            <th>USERNAME</th>
                            <th>SEX</th>
                            <th>BIRTH</th>
                            <th>EMAIL</th>
                            <th>PHONE</th>
                            <th>ADDRESS</th>
                            <th>ROOT</th>
                            <th>ACTION</th>
                        </tr>
                        <c:forEach var="user" items="${pageBean.mList}">
                            <tr>
                                <td class="tc"><input name="id[]" value="${user.id}" type="checkbox"></td>
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>${user.userName}</td>
                                <td>${user.userSex == 't'?'男':'女'}</td>
                                <td>${user.userBirth}</td>
                                <td>${user.userPone}</td>
                                <td>${user.userEmail}</td>
                                <td>${user.userAddress}</td>
                                <td>${user.userStatus == '1'?"普通":"管理"}</td>
                                <td>
                                    <a class="link-update" href="/JianYiShop/doUserReturn?id=${user.id}">修改</a>
                                    <c:if test="${user.userStatus == 1}">
                                        <a class="link-del" href="javascript:del('${user.id}', '${user.name}')">删除</a>
                                    </c:if>

                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="list-page">
                        共 ${pageBean.totalCount} 条记录 当前页面为${pageBean.curPage}/${pageBean.totalPage}页
                        <a href="/JianYiShop/manager/douserservelt?curPage=1">首页</a>
                        <a href="/JianYiShop/manager/douserservelt?curPage=${pageBean.curPage =pageBean.curPage-1}&keywords=${serach}">上一页</a>
                        <a href="/JianYiShop/manager/douserservelt?curPage=${(pageBean.curPage <= pageBean.totalPage?(pageBean.curPage=pageBean.curPage+2):(pageBean.curPage=pageBean.totalPage))}&keywords=${serach}">下一页</a>
                        <a href="/JianYiShop/manager/douserservelt?curPage=${pageBean.totalPage}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>