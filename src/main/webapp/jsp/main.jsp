<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!Doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        .left{
            float: left;
        }
        .clearfix::after{
            content: ',';
            height: 0;
            display: block;
            visibility: hidden;
            clear: both;
        }
    </style>
</head>
<body>

<div id="main">
    ${account.cardNo}
    <a href="/account/logout">退出登录</a>
</div>


<div class="clearfix">
    <div class="left">
        <div><a href="/account/balance/${account.cardNo}">查询余额</a></div>
        <div><a href="/account/transferTo">转账</a></div>
        <div><a href="/transactionrecord/record">查询交易记录</a></div>
        <div><a href="">修改密码</a></div>
    </div>
    <div class="left">
        <c:if test="${page eq 'balance'}">
            <%--引入balance页面--%>
            <jsp:include page="main/balance.jsp"/>
        </c:if>
        <c:if test="${page eq 'transferTo'}">
            <%--引入transferTo页面--%>
            <jsp:include page="main/transferTo.jsp"/>
        </c:if>
        <c:if test="${page eq 'records'}">
            <%--引入transferTo页面--%>
            <jsp:include page="main/records.jsp"/>
        </c:if>
    </div>
</div>

</body>
</html>


