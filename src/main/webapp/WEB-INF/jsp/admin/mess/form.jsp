<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>${form.id==null?"简报更新添加":"简报更新修改"}</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
    <link href="<%=basePath%>/backstage/kindeditor/themes/default/default.css">

    <%--<script src="<%=basePath%>/backstage/editor/jquery.js"></script>
    <script src="<%=basePath%>/backstage/editor/kindeditor.js"></script>

    <script type="text/javascript">
        KE.show({
            id: 'content7',
            cssPath: '../index.css'
        });
    </script>--%>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>${form.id==null?"简报更新添加":"简报更新修改"}</h5>
            </div>
            <div class="ibox-content">
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${message}
                </div>
                <form action="<%=basePath%>/admin/mess/save" id="itemAddForm" class="form-horizontal" method="post" enctype="multipart/form-data">
                    <c:if test="${form.id != null}">
                        <input type="hidden" name="id" value="${form.id}"/>
                    </c:if>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">简报类目</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="tablename" value="${form.tablename}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">简报标题</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="title" value="${form.title}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">更新概要</label>
                        <div class="col-sm-4">
                            <textarea class="form-control" name="outline">${form.outline}</textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">简报更新内容</label>
                        <div class="col-sm-4">
                    <textarea id="editor_id" name="content" class="picFileUpload" style="width:800px;height:350px;visibility:hidden;">
                            ${form.content}
                    </textarea>
                        </div>
                    </div>




                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button class="btn btn-primary" type="submit">保存内容</button>
                            <button class="btn btn-white" type="submit">取消</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

<script src="<%=basePath%>/backstage/js/common.js"></script>
<script charset="utf-8" src="<%=basePath%>/backstage/kindeditor/kindeditor-all-min.js"></script>
<script charset="utf-8" src="<%=basePath%>/backstage/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="<%=basePath%>/backstage/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" charset="UTF-8">

    var itemAddEditor ;
    $(function(){
        itemAddEditor = REDOOP.createEditor("#itemAddForm [name=content]");
    });

</script>


</html>