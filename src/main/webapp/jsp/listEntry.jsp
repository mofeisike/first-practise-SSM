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
        <th colspan="2">
            <h2>产品页面</h2>
            <button><a  href="/news/listCategory">首页</a></button>
            <form action="/entry/querytEnrty/categoryid" method="post">
                <select name="id">
                    <option value="0">全部</option>
                    <c:forEach items="${cs}" var="c">
                        <option value="${c.id}" <c:if test="${categoryid eq c.id}">selected</c:if>>${c.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="查询">
            </form>
        </th>
    </tr>
    <tr>
        <th>ID</th>
        <th>产品</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${es}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
        </tr>
    </c:forEach>
    <c:if test="${empty es}">
        <tr>
            <td colspan="2">${em}</td>
        </tr>
    </c:if>
    </tbody>
</table>


</body>
</html>
