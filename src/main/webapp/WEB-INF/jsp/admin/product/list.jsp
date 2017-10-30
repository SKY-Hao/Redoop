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
        <div>
            <div style="text-align: center;color: red;margin-bottom: 10px;">
                ${message}
            </div>
            <div style="margin-top:8px;margin-bottom: 5px;float: right;">
                <form id="form" action="<%=basePath%>/admin/product/select" method="get">
                    <span style="margin-right: 30px">
                        <em>0:产品文档</em>
                        <em>1:产品技术文档</em>
                        <em>2:测试报告</em>
                    </span>
                    <span>文档类型查询:<input type="text" name="producttype" style="width: 100px;" value="${producttype}">
                        <button id="sub">查询</button>
                    </span>

                </form>
            </div>
        </div>

        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>文档类型</th>
                    <th>文档名称</th>
                    <th>文档发布时间</th>
                    <th>文档下载次数</th>
                    <th>文档发布状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageList.getContent()}" var="one">
                    <tr>
                        <td>
                            <a href="<%=basePath%>/admin/product/detailed/${one.id}">
                                    <c:if test="${one.producttype==0}">
                                        产品文档
                                    </c:if>
                                    <c:if test="${one.producttype==1}">
                                        产品技术文档
                                    </c:if>
                                    <c:if test="${one.producttype==2}">
                                        测试报告
                                    </c:if>
                            </a>
                        </td>

                        <td>${one.productname}</td>
                        <td>${one.producttime}</td>

                        <td>${one.productcount}</td>
                        <td>
                            <c:if test="${one.protype=='0'}">
                                已发布(显示)
                            </c:if>
                            <c:if test="${one.protype=='1'}">
                                已取消发布(不显示)
                            </c:if>
                        </td>

                        <td>
                            <a href="<%=basePath%>/admin/product/form/${one.id}">修改/</a>
                            <a href="<%=basePath%>/admin/product/delete/${one.id}" onclick="return del()">删除/</a>
                            <a href="<%=basePath%>/admin/product/detailed/${one.id}">查看详细信息/</a>
                            <c:if test="${one.protype eq '0'}"><a href="<%=basePath%>/admin/product/release/${one.id}" class="tablelink">取消发布</a></c:if>
                            <c:if test="${one.protype eq '1'}"><a href="<%=basePath%>/admin/product/cancelRelease/${one.id}" class="tablelink">确认发布</a></c:if>
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