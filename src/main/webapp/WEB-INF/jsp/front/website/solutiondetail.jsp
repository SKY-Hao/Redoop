<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!doctype html>
<html>
<head>
    <jsp:include page="tools/head.jsp"></jsp:include>
</head>


<body>

<jsp:include page="tools/header.jsp"></jsp:include>

<section class="grey-bg" id="breadMenu" style="margin-top: 75px;">
    <div class="container"><a href="<%=basePath%>/">首页</a> &gt; 行业版本及案例详情</div>
</section>
<section class="block" id="newsPage">
    <div class="container clearfix">
        <h2 class="titleLeft">${solutiondetail.title}</h2>
        <div class="headSource">
            <span class="author">作者：${solutiondetail.author}</span>
            <span class="source">时间：${solutiondetail.authortime}更新</span>
        </div>
        <div class="newsInfo"><!--内容-->
            ${solutiondetail.content}
        </div>
    </div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
