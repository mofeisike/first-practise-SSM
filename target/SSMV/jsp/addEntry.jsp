<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div style="width:500px;margin:0px auto;text-align:center">

    <div class="panel-heading">添加产品</div>
    <div class="panel-body">

        <form method="post" id="editForm" action="/entry/add">

            <table class="editTable" border="1px">
                <tr>
                    <td>名称</td>
                    <td>
                        <input id="name" name="name" value="" type="text">
                    </td>
                </tr>
                <tr>
                    <td>简介</td>
                    <td>
                        <input id="introduce" name="introduce" value="" type="text">
                    </td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <input type="text" name="cid" value="${categoryId}">
                        <button type="submit" >提 交</button>
                        <button><a href="javascript:history.go(-1);" >返回</a></button>
                    </td>
                </tr>
            </table>
        </form>

    </div>

</div>

