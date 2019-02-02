<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div align="center">
    <form action="/news/getCategory/name">
        <span>名称</span>
        <input type="text" name="name" value="${name}">
        <input type="submit" value="查询">
    </form>

</div>

<table align="center" border="1" cellspacing="0">
    <thead>
    <tr>
        <th colspan="9">
            <h2>表单</h2>
        </th>
    </tr>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>时间</th>
        <th>编辑</th>
        <th>删除</th>
        <th>属性</th>
        <th>评论</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td colspan="9">
            <c:if test="${deletesuc eq true}">
                删除成功,请返回
            </c:if>
            <c:if test="${deletesuc eq false}">
                删除失败,请返回
            </c:if>
        </td>
    </tr>
    <c:forEach items="${cs}" var="obj">
        <tr>
            <td>${obj.id}</td>
            <td>${obj.name}</td>
            <%--添加fmt标签,实现不同显示的时间--%>
            <td><fmt:formatDate value="${obj.createDate}" pattern="yyyy-mm-dd HH:MM:ss"/></td>
            <td><a href="/news/editCategory?id=${obj.id}">编辑</a></td>
            <td><a href="/news/deleteCategory?id=${obj.id}">删除</a></td>
            <%--rest风格--%>
            <td><a href="/propety/listProperty?id=${obj.id}">属性</a></td>
            <td>
                <%--rest风格 , 评论模块 ,里面查询  ,根据newid查询--%>
                <a href="/comments/query/newid/${obj.id}">查看评论</a>
                <a href="/comments/addTo/${obj.id}">评论</a>
                <a href="/news/deleteComments/${obj.id}">删除评论</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div align="center">
    <h1>${warn}</h1>
</div>

<div align="center" style="text-align:center;margin-top:40px">
    <form method="post" action="/news/addCategory">
        分类名称: <input name="name" value="" type="text">
        <br/>
        <input type="submit" value="添加分类">
    </form>
</div>

</body>
</html>
