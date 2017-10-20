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

<div class="eventBg"  style="margin-top: 75px;">
    <div class="eventTxt"><img src="<%=basePath%>/front/website/img/eventTxt.png" /></div>
    <p>红象云腾2017产品发布暨合作伙伴大会&nbsp;&nbsp;&nbsp;&nbsp;敬请期待</p>
</div>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
