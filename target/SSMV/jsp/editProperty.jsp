<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div style="width:500px;margin:0px auto;text-align:center">
    <div class="panel-heading">编辑属性</div>
    <div class="panel-body">
        <form method="post" id="editForm" action="/propety/updateProperty">
            <table class="editTable" border="1px">
                <tr class="editTable">
                    <td>属性名称</td>
                    <td>
                        <input id="name" name="name" value="${p.name}" type="text" class="form-control">
                    </td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <input type="text" name="id" value="${p.id}">
                        <input type="text" name="cid" value="${p.category.id}">
                        <%--
                        因为修改的时候必须提供id呀，不然怎么知道修改哪一条数据呢。 隐藏的原因是id不需要暴露给用户看见，
                        所以隐藏掉了。cid也是需要传递不过，否则cid信息在修改的时候就丢失了呢
                        --%>
                        <button type="submit" class="btn btn-success">提 交</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

