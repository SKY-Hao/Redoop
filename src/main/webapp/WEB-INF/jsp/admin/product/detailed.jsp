<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>产品资料列表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>产品资料列表</h4>
        </div>

        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>

                    <tr>
                        <th>文档类型</th>
                        <th>
                            <c:if test="${form.producttype==0}">
                                产品文档
                            </c:if>
                            <c:if test="${form.producttype==1}">
                                产品技术文档
                            </c:if>
                            <c:if test="${form.producttype==2}">
                                测试报告
                            </c:if>
                        </th>
                    </tr>
                    <tr>
                        <th>文档名称</th>
                        <th>
                            ${form.productname}
                        </th>
                    </tr>

                    <tr class="warning">
                        <th>产品发布时间</th>
                        <th>${form.producttime}</th>
                    </tr>

                    <tr class="warning">
                        <th>文档发布状态</th>
                        <th>
                            <c:if test="${form.protype==0}">
                                已发布(显示)
                            </c:if>
                            <c:if test="${form.protype==1}">
                                已取消发布(不显示)
                            </c:if>
                        </th>
                    </tr>

                    <tr>
                        <th>文档下载次数</th>
                        <th>${form.productcount}</th>
                    </tr>

                    <tr>
                        <th>文档发布人</th>
                        <th> ${form.productauthor}</th>
                    </tr>

                    <tr class="warning">
                        <th>文档(下载)地址</th>
                        <th style="word-break:break-all;">
                            <a href="#">
                                ${form.producturl}
                            </a>
                        </th>
                    </tr>
                    <tr>
                        <th>htmlContent</th>
                        <th> ${form.htmlContent}</th>
                    </tr>

                </thead>
            </table>
            <a href="<%=basePath%>/admin/product/findAll">
                <button class="btn btn-danger" type="button">返回</button>
            </a>
        </div>
    </div>

</div>

</body>