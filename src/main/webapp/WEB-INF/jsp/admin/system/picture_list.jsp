<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>图片列表</title>
    <jsp:include page="../../tools/style/picture.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
    <jsp:include page="../../tools/style/modal.jsp"></jsp:include>

</head>

<body>
<!--main begin-->
<div class="main">

    <ul class="body_ul">
        <div style="text-align: center;color: red;margin-bottom: 10px;">
            ${message}
        </div>
        <c:forEach items="${list}" var="one">

        <li class="body_li">
            <div class="body_box">
                <div class="box_top">
                    <img src="<%=basePath%>/${one.url}" height="100%" width="100%"/>
                </div>
                <div class="box_down">
                    <div class="box_name">
                        <span><b style="float: left"><label>&nbsp;</label>名称: ${one.name}</b> <b style="float: right">类型: ${one.type}<label>&nbsp;</label></b></span>
                    </div>
                    <div class="box_tools">
                        <ul class="box_ul">
                            <a href="<%=basePath%>/admin/system/picture/form/${one.id}">
                                <li class="glyphicon glyphicon-edit"></li>
                            </a>
                            <a href="<%=basePath%>/admin/system/picture/delete/${one.id}" onclick="return del()">
                                <li class="glyphicon glyphicon-trash"></li>
                            </a>
                            <a data-toggle="modal" data-id="${one.id}" data-target="#exampleModal" data-whatever="${one.id}">
                                <li class="glyphicon glyphicon-random"></li>
                            </a>
                        </ul>
                    </div>
                </div>
            </div>
        </li>

        </c:forEach>

    </ul>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <form action="<%=basePath%>/admin/system/picture/move" method="post">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel">移动分组</h4>
                </div>

                <div class="modal-body">
                    <div class="form-group">
                        <input type="hidden" name="id" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <select class="form-control m-b" name="type" id="message-text">
                            <c:forEach items="${types}" var="type">
                                <option value="${type}">${type}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>

            </form>
        </div>
    </div>
</div>

<script>
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        modal.find('.modal-title').text('移动分组')
        modal.find('.modal-body input').val(recipient)
    })
</script>

</body>

</html>
