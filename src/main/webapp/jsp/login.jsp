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
    <script src="/plugins/layui/layui.js"></script>
    <script src="/plugins/JQuery.js"></script>
    <style>
        #main{
            width: 60%;
            margin: auto;
            padding: 10%;
            /*background-color: #00acc1;*/
        }
        form{
            width: 30%;
            margin: auto;
            /*background-color: #00FF00;*/
        }
    </style>
</head>
<body>

<div id="main">
    <form action="/account/login" method="post" onsubmit="return cheack()">
        <h1>网上银行</h1>
        卡号: <input type="text" name="cardNo"><br>
        密码: <input type="password" name="password"><br>
        <input type="submit" value="登录">
        <a href="/news/listCategory">layui</a>
    </form>
</div>


<script>
    $(function () {
        var errorMsg = '${errorMsg}';
        if(errorMsg != null && errorMsg != undefined && errorMsg != ""){
            alert(errorMsg);
        }
    })
    function cheack() {
        var cardNo = $('input[name=cardNo]').val();
        if (cardNo.length != 16) {
            alert("卡号长度必须为16位")
            return false;
        }
        var pwd = $('input[name=password]').val();

        if(pwd.length != 6){
            alert("密码长度必须为6位");
            return false;
        }
        return true;
    }
</script>

</body>
</html>