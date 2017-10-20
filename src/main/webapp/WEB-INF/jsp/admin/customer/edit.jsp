<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>客户信息修改</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>客户信息修改</h5>
            </div>
            <div class="ibox-content">
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${message}
                </div>
                <form action="<%=basePath%>/admin/customer/edit" class="form-horizontal" method="POST">
                    <input type="hidden" name="id" value="${form.id}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="username" value="${form.username}">
                            <span class="help-block m-b-none">用户名不能为空&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="phonenumber" value="${form.phonenumber}">
                            <span class="help-block m-b-none">联系电话&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="email" value="${form.email}">
                            <span class="help-block m-b-none">激活账号邮箱&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="companyname" value="${form.companyname}">
                            <span class="help-block m-b-none">用户所在公司&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="password" value="${form.password}">
                            <span class="help-block m-b-none">密码不能为空&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码确认</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="repassword" value="${form.password}">
                            <span class="help-block m-b-none">密码确认不能为空&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>
<%--
                    <div class="form-group">
                        <label class="col-sm-2 control-label">登录状态(0:正常     1:禁止登录)</label>
                        <div class="col-sm-4">
                            <input type="text" disabled class="form-control" name="activatestate" value="${form.activatestate==0?'正常':'禁止登录'}">
                        </div>
                    </div>--%>

                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button class="btn btn-primary" type="submit">保存内容</button>
                            <a href="<%=basePath%>/admin/customer/list">
                                <button class="btn btn-white" type="button">取消</button>
                            </a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>