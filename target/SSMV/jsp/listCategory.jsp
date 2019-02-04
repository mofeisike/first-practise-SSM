<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="/css/listCategory.css">
    <script src="/plugins/layui/layui.js"></script>
    <script src="/plugins/JQuery.js"></script>
</head>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="javascript:;">列表三</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body layui-anim layui-anim-upbit">

        <div class="layui-container">
            <div class="layui-row">
                <div class="layui-col-md9" >
                    <h2>表单</h2>
                    <button type="button"><a href="/entry/listEntry">产品页面</a></button>
                </div >
                <div class="layui-col-md3" >
                    <form action="/news/getCategory/name" class="body-head-form">
                        <i class="layui-icon layui-icon-search"></i>
                        <input type="text" class="layui-input" placeholder="请输入名称" name="name" value="${name}">
                        <input type="submit" class="layui-btn layui-btn-radius" value="查询">
                    </form>
                </div>
            </div>
        </div>

        <div classs="body-head">

            <div>

            </div>
        </div>

        <div class="body-table">
            <table class="layui-table">
                <thead>
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
                            <button class="layui-btn layui-btn-warm"><a href="/comments/query/newid/${obj.id}">查看评论</a></button>
                            <button class="layui-btn layui-btn-normal"><a href="/comments/addTo/${obj.id}">评论</a></button>
                            <button class="layui-btn layui-btn-danger"><a href="/news/deleteComments/${obj.id}">删除评论</a></button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>


        <div class="bady-add">
            <div align="center" style="text-align:center;margin-top:40px">
                <form method="post" action="/news/addCategory">
                    分类名称: <input name="name" value="" type="text">
                    <br/>
                    <input type="submit" value="添加分类">
                </form>
            </div>
        </div>

        <div>
            <div align="center">
                <h1>${warn}</h1>
            </div>

            <button type="button"><a href="/entry/listEntry">产品页面</a></button>

            <div>
                <c:if test="${deletesuc eq true}">
                    删除成功,请返回
                </c:if>
                <c:if test="${deletesuc eq false}">
                    删除失败,请返回
                </c:if>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });



</script>
</body>
</html>
