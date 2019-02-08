<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div>

    <c:if test="${not empty code}">
        <c:if test="${code eq 7000}">
            <h2>操作成功</h2>
        </c:if>
        <c:if test="${code ne 7000}">
            <h2>操作失败</h2>
            ${msg}
        </c:if>
    </c:if>

    <c:if test="${empty code and empty msg }">
        <h2>转账</h2>
        <form action="/account/transfer" method="post">
            转入账号: <input type="text" name="cardNo"><br>
            转入金额: <input type="text" name="transactionAmount"><br>
            <input type="submit" value="转账">
        </form>
    </c:if>

</div>
