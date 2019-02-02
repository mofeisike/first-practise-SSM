<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width:500px;margin:0px auto;text-align:center">
    <form method="post" action="/news/updateCategory">
        分页名称:<input name="name" value="${cc.name}" type="text">
        <input type="hidden" value="${cc.id}" name="id">
        <input type="submit" value="更新">
    </form>
</div>

</body>
</html>
