<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>系统标签列表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>系统标签列表</h4>
        </div>
        <div>
            <div style="text-align: center;color: red;margin-bottom: 10px;">
                ${message}
            </div>
            <div style="margin-top:8px;margin-bottom: 5px;float: right;">
                <form id="form" action="<%=basePath%>/admin/system/tag/select" method="POST">
                    <span>名称查询:<input type="text" name="name" style="width: 100px;" value="${name}">
                        <button id="sub">查询</button>
                    </span>
                </form>
            </div>
        </div>


        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>键值</th>
                    <th>名称</th>
                    <th>类型</th>
                    <th>创建时间</th>
                    <th>创建者</th>
                    <th>描述</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="one">
                    <tr>
                        <td>${one.value}</td>
                        <td>${one.label}</td>
                        <td>${one.type}</td>
                        <td>${one.createDate}</td>
                        <td>${one.createBy}</td>
                        <td ><span class="biglong">${one.description}</span></td>

                        <td>
                            <a href="<%=basePath%>/admin/system/tag/form/${one.id}">修改</a>
                            <a href="<%=basePath%>/admin/system/tag/addKey/${one.type}">添加键值</a>
                            <a href="<%=basePath%>/admin/system/tag/delete/${one.id}" onclick="return del()">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>

</html>
