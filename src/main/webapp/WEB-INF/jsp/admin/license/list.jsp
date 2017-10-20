<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>

<head>
    <title>授权信息列表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>License列表</h4>
        </div>
        <div>
            <div style="float: left;margin-top:8px;margin-bottom: 5px;">
                <span style="margin: 5px 10px;">授权记录共有: &nbsp;<b style="color: red;">${licenseNumber}</b>&nbsp;条</span>
            </div>

            <div style="margin-top:8px;margin-bottom: 5px;float: right;">
                <form id="form" action="<%=basePath%>/admin/license/select" method="POST">
                    <span>公司查询:<input type="text" name="companyName" style="width: 100px;" value="${companyName}">
                        <button id="sub">查询</button>
                    </span>
                </form>
            </div>
        </div>


        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>公司</th>
                    <th>项目</th>
                    <th>邮箱</th>
                    <th>所属产品</th>
                    <th>节点数</th>
                    <th>申请时间</th>
                    <th>授权码</th>
                    <th>版式</th>
                    <th>试用次数</th>
                    <th>状态</th>
                    <th>替换图片</th>
                    <th>到期时间</th>
                    <th>有效天数</th>
                    <th>更新时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="license">
                    <tr>
                        <td>${license.id}</td>
                        <td>${license.company}</td>
                        <td>${license.project}</td>
                        <td>${license.email}</td>
                        <td>${license.products}</td>
                        <td>${license.node}</td>
                        <td>${license.createDate}</td>
                        <td ><span class="biglong">${license.code}</span></td>
                        <c:if test="${license.version==0}"><td>试用版</td></c:if>
                        <c:if test="${license.version==1}"><td>正式版</td></c:if>
                        <td>${license.trials}</td>

                        <c:if test="${license.status==0}"><td>试用版已授权</td></c:if>
                        <c:if test="${license.status==1}"><td>正式版未授权</td></c:if>
                        <c:if test="${license.status==2}"><td>正式版已授权</td></c:if>

                        <c:if test="${license.allowPic==0}"><td>否</td></c:if>
                        <c:if test="${license.allowPic==1}"><td>是</td></c:if>

                        <td>${license.vaild}</td>
                        <td>${license.vaildDays}天</td>
                        <td>${license.updateDate}</td>

                        <td>
                            <a href="<%=basePath%>/admin/license/edit/${license.id}">修改</a>
                            <c:if test="${license.status==1}"><a href="<%=basePath%>/admin/license/authorizePage/${license.id}">正式版授权</a></c:if>
                            <c:if test="${license.status==2}"><a href="<%=basePath%>/admin/license/export/${license.id}">导出</a></c:if>
                            <a href="<%=basePath%>/admin/license/delete/${license.id}" onclick="return del()">删除</a>
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
