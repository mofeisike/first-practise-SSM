<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table align="center" border="1" cellspacing="0">
    <thead>
    <tr>
        <th colspan="4">
            <h2>属性</h2>
            <button><a  href="/news/listCategory">首页</a></button>
        </th>
    </tr>
    <tr>
        <th>ID</th>
        <th>属性管理</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ps}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td><a href="/propety/editProperty?id=${p.id}">编辑</a></td>
            <td><a href="/propety/deleteProperty?id=${p.id}" deleteLink="true">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<div align="center">
    <form method="post" action="/propety/addProperty">
        <table >
            <tr>
                <td>属性名称</td>
                <td><input id="name" name="name" type="text"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="text" name="cid" value="${cc.id}">
                    <button type="submit">提交</button>
                </td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>
