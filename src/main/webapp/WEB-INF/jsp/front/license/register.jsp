<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>许可证申请</title>

    <link rel="stylesheet" href="<%=basePath%>/front/license/css/style.css" type="text/css" media="screen" />

</head>

<body>
<div class="container">
    <h3>申请最新版 Redoop 数据存储平台Licence，<br />
        拥有最安全稳定的数据体验</h3>
    <a href="<%=basePath%>/front/license/trial">试用版申请</a><a href="<%=basePath%>/front/license/formal" class="green">正式版申请</a>
</div>
</body>
</html>
