<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>${form.id==null?"图片添加":"图片修改"}</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>${form.id==null?"图片添加":"图片修改"}</h5>
            </div>
            <div class="ibox-content">
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${message}
                </div>
                <form action="<%=basePath%>/admin/system/picture/save" class="form-horizontal" method="POST" enctype="multipart/form-data">
                    <c:if test="${form.id != null}">
                        <input type="hidden" name="id" value="${form.id}"/>
                    </c:if>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="name" value="${form.name}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">类型</label>
                        <div class="col-sm-4">
                            <select class="form-control m-b" name="type">
                                <c:forEach items="${tags}" var="tag">
                                    <option value="${tag.label}">${tag.label}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="description" value="${form.description}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">图片</label>
                        <div class="col-sm-4">
                            <input type="file" class="form-control" style="height: 38px;" name="logo">
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