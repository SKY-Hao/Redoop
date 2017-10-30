<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>行业版本&案例列表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>行业版本&案例列表</h4>
        </div>
        <div>
            <div style="text-align: center;color: red;margin-bottom: 10px;">
                ${message}
            </div>
            <div style="margin-top:8px;margin-bottom: 5px;float: right;">

                <form id="form" action="<%=basePath%>/admin/solution/select" method="GET">
                    <span style="margin-right: 10px;">
                        <em>(0:行业版本  1:成功案例)</em>
                    </span>
                    <span>行业版本及案例名称查询:<input type="text" name="name" style="width: 100px;" value="${name}">
                        <button id="sub">查询</button>
                    </span>
                </form>
            </div>
        </div>

        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>方案及案例名称</th>
                    <th>方案及案例图片</th>
                    <th>标题</th>
                    <th>发布者</th>
                    <th>发布时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageList.getContent()}" var="solution">
                    <tr>
                        <c:if test="${solution.name==0}">
                            <td>行业版本</td>
                        </c:if>
                        <c:if test="${solution.name==1}">
                            <td>成功案例</td>
                        </c:if>
                        <td><img src="<%=basePath%>/${solution.solutionpic}" width="130" height="50"></td>
                        <td>${solution.title}</td>
                        <td>${solution.author}</td>
                        <td>${solution.authortime}</td>
                        <td>
                            <a href="<%=basePath%>/front/solutiondetail/${solution.id}" target="_blank" class="tablelink">预览</a>
                            <a href="<%=basePath%>/admin/solution/form/${solution.id}" class="tablelink">修改</a>
                            <c:if test="${solution.state eq 0}"><a href="<%=basePath%>/admin/solution/abolish/${solution.id}" class="tablelink">取消发布</a></c:if>
                            <c:if test="${solution.state eq 1}"><a href="<%=basePath%>/admin/solution/affirm/${solution.id}" class="tablelink">确认发布</a></c:if>
                            <a href="<%=basePath%>/admin/solution/delete/${solution.id}" class="tablelink" onclick="return del()">删除</a>
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
