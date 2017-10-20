<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>新闻列表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>新闻列表</h4>
        </div>
        <div>
            <div style="text-align: center;color: red;margin-bottom: 10px;">
                ${message}
            </div>
            <div style="margin-top:8px;margin-bottom: 5px;float: right;">
                <form id="form" action="<%=basePath%>/admin/new/select" method="GET">
                    <span>新闻标题查询:<input type="text" name="title" style="width: 100px;" value="${title}">
                        <button id="sub">查询</button>
                    </span>
                </form>
            </div>
        </div>

        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <%--<th>编号</th>--%>
                    <th>缩略图</th>
                    <th>标题</th>
                    <th>发布者</th>
                    <th>发布时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageList.getContent()}" var="news">
                    <tr>
                        <%--<td>${news.id}</td>--%>
                        <td><img src="<%=basePath%>/${news.picpath}" width="130" height="50"></td>
                        <td>${news.title}</td>
                        <td>${news.publisher}</td>
                        <td>${news.date}</td>
                        <td>
                            <a href="<%=basePath%>/front/onenew/${news.id}" target="_blank" class="tablelink">预览</a>
                            <a href="<%=basePath%>/admin/new/form/${news.id}" class="tablelink">修改</a>
                            <c:if test="${news.state eq 1}"><a href="<%=basePath%>/admin/new/cancelRelease/${news.id}" class="tablelink">取消发布</a></c:if>
                            <c:if test="${news.state eq 0}"><a href="<%=basePath%>/admin/new/release/${news.id}" class="tablelink">发布</a></c:if>
                            <a href="<%=basePath%>/admin/new/delete/${news.id}" class="tablelink" onclick="return del()">删除</a>
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

</html>
