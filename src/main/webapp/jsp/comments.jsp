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
            <h2>评论列表</h2>
            <button><a  href="/">首页</a></button>
        </th>
    </tr>
    <tr>
        <th>ID</th>
        <th>评论</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${comments}" var="co">
        <tr>
            <td>${co.id}</td>
            <td>${co.comments}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
