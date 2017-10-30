<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="tools/head.jsp"></jsp:include>

</head>

<body>

<jsp:include page="tools/header.jsp"></jsp:include>

<section class="grey-bg" id="breadMenu" style="margin-top: 75px;">
    <div class="container"><a href="<%=basePath%>/">首页</a> &gt; REDOOP周报</div>
</section>
<section class="block">
    <div class="container clearfix">

        <div style="color: red">
            <table>
                <thead>
                <tr>
                    <th>标题</th>
                    <th>发布者</th>
                    <th>更新简要</th>
                    <th>发布时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${messList}" var="one">
                    <tr>
                        <td>${one.title}</td>
                        <td>${one.author}</td>
                        <td>${one.outline}</td>
                        <td>${one.authortime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</section>
        <!--分页-->
    </div>

</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
