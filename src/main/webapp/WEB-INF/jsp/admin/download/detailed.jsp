<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>CRH&&AI下载列表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>CRH&&AI下载列表</h4>
        </div>

        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>

                <tr>
                    <th>产品类型</th>
                    <th>
                        <c:if test="${form.producttype==0}">
                            CRH
                        </c:if>
                        <c:if test="${form.producttype==1}">
                            AI
                        </c:if>
                    </th>
                </tr>

                <tr class="warning">
                    <th>平台类型</th>
                    <th>
                        <c:if test="${form.platformtype=='0'}">
                            X64
                        </c:if>
                        <c:if test="${form.platformtype=='1'}">
                            OpenPower
                        </c:if>
                        <c:if test="${form.platformtype=='2'}">
                            ARM/飞腾
                        </c:if>
                        <c:if test="${form.platformtype=='3'}">
                            申威
                        </c:if>
                        <c:if test="${form.platformtype=='4'}">
                            龙芯
                        </c:if>
                    </th>
                </tr>


                <tr class="warning">
                    <th>产品发布时间</th>
                    <th>${form.producttime}</th>
                </tr>

                <tr>
                    <th>文档名称</th>
                    <th>
                        ${form.documentname}
                    </th>
                </tr>

                <tr class="warning">
                    <th>文档(下载)地址</th>
                    <th style="word-break:break-all;">
                        <a href="#">
                            ${form.documenturl}
                        </a>
                    </th>
                </tr>

                <tr>
                    <th>文档发布人</th>
                    <th> ${form.documentauthor}</th>
                </tr>

                <tr class="warning">
                    <th>文档发布状态</th>
                    <th>
                        <c:if test="${form.documenttype==0}">
                            已发布
                        </c:if>
                        <c:if test="${form.documenttype==1}">
                            已取消发布
                        </c:if>
                    </th>
                </tr>

                <tr>
                    <th>文档下载次数</th>
                    <th>${form.docudowncount}</th>
                </tr>

                <tr>
                    <th>查看地址</th>
                    <th>${form.see}</th>
                </tr>

                <tr class="warning">
                    <th>支持的图片</th>
                    <th><img src="<%=basePath%>/${form.systempic}" width="80" height="50"></th>
                </tr>

                <tr class="warning">
                    <th>芯片支持的图片</th>
                    <th><img src="<%=basePath%>/${form.chippic}" width="80" height="50"></th>
                </tr>

                </thead>



            </table>
            <a href="<%=basePath%>/admin/download/findAll">
                <button class="btn btn-danger" type="button">返回</button>
            </a>
        </div>
    </div>

</div>

</body>