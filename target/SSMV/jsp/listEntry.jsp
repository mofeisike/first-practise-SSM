<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/plugins/layui/css/layui.css">
    <script src="/plugins/layui/layui.js"></script>
    <script src="/plugins/JQuery.js"></script>
</head>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>

<table align="center" border="1" cellspacing="0">
    <thead>
    <tr>
        <th colspan="5">
            <h2>产品页面</h2>
            <button><a  href="/news/listCategory">首页</a></button>
            <form action="/entry/querytEnrty/categoryid" method="post">
                <select name="id">
                    <option value="0">全部</option>
                    <c:forEach items="${cs}" var="c">
                        <option value="${c.id}" <c:if test="${categoryid eq c.id}">selected</c:if>>${c.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" id="find" value="查询" toggle="0">
                <input type="button"  id="addbtn" value="新增电子文档">
                <button id="btn">test</button>
            </form>
        </th>
    </tr>
    <tr>
        <th>ID</th>
        <th>产品</th>
        <th>简介</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${es}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.introduce}</td>
            <td><a>修改</a></td>
            <td><a>删除</a></td>
        </tr>
    </c:forEach>
    <c:if test="${empty es}">
        <tr>
            <td colspan="5"><span id="em">${em}</span></td>
        </tr>
    </c:if>
    </tbody>
</table>

<script>
    $(function () {
        $('#addbtn').click(function () {
            //获取当前分类id
            var id = $('form select').val();
            if (id == 0) {
                alert("请先选择分类信息")
                return false;
            }
            window.location = "/entry/addTo/"+id;
        })


        //检查查询是否被点击
        // $('#addbtn').click(function () {
        //     $('#find').attr("toggle","1");
        // })


    })


</script>

</body>
</html>
