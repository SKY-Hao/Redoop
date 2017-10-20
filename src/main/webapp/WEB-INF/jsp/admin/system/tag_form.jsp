<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>${form.id==null?"标签添加":"标签修改"}</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>${form.id==null?"标签添加":"标签修改"}</h5>
            </div>
            <div class="ibox-content">
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${message}
                </div>
                <form action="<%=basePath%>/admin/system/tag/save" class="form-horizontal" method="POST">
                    <c:if test="${form.id != null}">
                        <input type="hidden" name="id" value="${form.id}"/>
                    </c:if>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">键值</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="value" value="${form.value}">
                            <span class="help-block m-b-none">键值不能为空&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">标签</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="label" value="${form.label}">
                            <span class="help-block m-b-none">标签不能为空&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">类型</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="type" value="${form.type}">
                            <span class="help-block m-b-none">类型不能为空&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-4">
                            <textarea name="description" class="col-sm-4">${form.description}</textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button class="btn btn-primary" type="submit">保存内容</button>
                            <button class="btn btn-white" onclick="javascript: history.back()">返回</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>