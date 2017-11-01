<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>最终简报表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
    <script type="text/javascript" src="<%=basePath%>/backstage/My97DatePicker/WdatePicker.js"></script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>最终简报表</h4>
        </div>
        <div class="ibox-content">
           <%-- <table class="table table-bordered table-striped" style="table-layout: fixed;">--%>
               <table class="table table-bordered table-striped" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>类目</th>
                        <th>标题</th>
                        <th>更新概要</th>
                        <th>发布者</th>
                        <th>更新时间</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="mess">
                        <tr>
                            <td>${mess.tableid}</td>
                            <td>${mess.tablename}</td>
                            <td>${mess.tabletitle}</td>
                            <%--<td style="white-space:nowrap;overflow: hidden;text-overflow:ellipsis">${mess.outline}</td>--%>
                            <td>${mess.outline}</td>
                            <td>${mess.author}</td>
                            <td>${mess.date}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
