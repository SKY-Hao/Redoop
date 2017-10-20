<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>客户列表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>客户列表</h4>
        </div>
        <div>
            <div style="text-align: center;color: red;margin-bottom: 10px;">
                ${message}
            </div>
            <div style="margin-top:8px;margin-bottom: 5px;float: right;">
                <form id="form" action="<%=basePath%>/admin/customer/select" method="POST">
                    <span>公司查询:<input type="text" name="username" style="width: 100px;" value="${username}">
                        <button id="sub">查询</button>
                    </span>
                </form>
            </div>
        </div>


        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>公司名称</th>
                    <th>邮箱</th>
                    <th>电话</th>
                    <th>注册时间</th>
                    <th>最后登录时间</th>
                    <th>激活状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="one">
                    <tr>
                        <td>${one.username}</td>
                        <td>${one.password}</td>
                        <td>${one.companyname}</td>
                        <td>${one.email}</td>
                        <td>${one.phonenumber}</td>
                        <td>${one.registerdate}</td>
                        <td>${one.logindate}</td>
                        <c:if test="${one.activatestate==0}">
                            <td>未激活</td>
                        </c:if>
                        <c:if test="${one.activatestate==1}">
                            <td>已激活</td>
                        </c:if>

                        <td>
                            <a href="<%=basePath%>/admin/customer/edit/${one.id}">修改</a>
                            <c:if test="${one.activatestate==0}"><a
                                    href="<%=basePath%>/admin/customer/startActivate/${one.id}"
                                    onclick="return start()">手动激活</a></c:if>
                            <c:if test="${one.activatestate==1}"><a
                                    href="<%=basePath%>/admin/customer/stopActivate/${one.id}" onclick="return stop()">禁止登录</a></c:if>
                            <a href="<%=basePath%>/admin/customer/delete/${one.id}" onclick="return del()">删除</a>
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
