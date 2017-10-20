<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>下载列表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>CRH&&AI下载列表</h4>
        </div>
        <div>
            <div style="text-align: center;color: red;margin-bottom: 10px;">
                ${message}
            </div>
            <div style="margin-top:8px;margin-bottom: 5px;float: right;">
                <form id="form" action="<%=basePath%>/admin/download/select" method="get">
                    <span style="margin-right: 30px">
                        <em>0:CRH</em>
                        <em>1:AI</em>
                    </span>
                    <span>产品类型查询:<input type="text" name="producttype" style="width: 100px;" value="${producttype}">
                        <button id="sub">查询</button>
                    </span>

                </form>
            </div>
        </div>

        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>产品类型</th>
                    <th>平台类型</th>
                    <th>产品版本</th>
                    <th>产品发布时间</th>
                    <th>文档名称(操作系统名称)</th>
                    <th>操作系统编号</th>
                    <th>文档发布状态</th>
                    <th>文档下载次数</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageList.getContent()}" var="one">
                    <tr>
                        <td>
                            <a href="<%=basePath%>/admin/download/detailed/${one.id}">
                                    <c:if test="${one.producttype==0}">
                                        CRH
                                    </c:if>
                                    <c:if test="${one.producttype==1}">
                                        AI
                                    </c:if>
                            </a>
                        </td>

                        <td>
                            <c:if test="${one.platformtype==0}">
                                X86
                            </c:if>
                            <c:if test="${one.platformtype==1}">
                                OpenPower
                            </c:if>
                            <c:if test="${one.platformtype==2}">
                                ARM/飞腾
                            </c:if>
                            <c:if test="${one.platformtype==3}">
                                申威
                            </c:if>
                            <c:if test="${one.platformtype==4}">
                                龙芯<em>(敬请期待)</em>
                            </c:if>
                            <c:if test="${one.platformtype==5}">
                                X64
                            </c:if>
                        </td>

                        <td>
                            <c:if test="${one.productversion==0}">
                                CRH5.0
                            </c:if>
                            <c:if test="${one.productversion==1}">
                                CRH4.9
                            </c:if>
                            <c:if test="${one.productversion==2}">
                                TensorFlow
                            </c:if>
                        </td>

                        <td>${one.producttime}</td>

                        <td>${one.documentname}</td>

                        <td>${one.sysversion}</td>

                        <td>
                            <c:if test="${one.documenttype==0}">
                                发布(显示)
                            </c:if>

                            <c:if test="${one.documenttype==1}">
                                不发布(不显示)
                            </c:if>
                        </td>
                        <td>${one.docudowncount}</td>

                        <td>
                            <a href="<%=basePath%>/admin/download/form/${one.id}">修改/</a>
                            <a href="<%=basePath%>/admin/download/delete/${one.id}" onclick="return del()">删除/</a>
                            <a href="<%=basePath%>/admin/download/detailed/${one.id}">查看详细信息</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <jsp:include page="../../tools/page/admin_page.jsp"></jsp:include>
        </div>
    </div>

</div>

</body>