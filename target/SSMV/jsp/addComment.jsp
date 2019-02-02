<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div style="width:500px;margin:0px auto;text-align:center">

    <div class="panel-heading">编辑评论</div>
    <div class="panel-body">

        <form method="post" id="editForm" action="/comments/add">

            <table class="editTable" border="1px">
                <tr class="editTable">
                    <td>评论</td>
                    <td>
                        <input id="name" name="comments" value="" type="text" class="form-control">
                    </td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <input type="hidden" name="newid" value="${newsId}">
                        <button type="submit" >提 交</button>

                        <button><a href="javascript:history.go(-1);" >返回</a></button>
                    </td>
                </tr>
            </table>

        </form>

    </div>

</div>

