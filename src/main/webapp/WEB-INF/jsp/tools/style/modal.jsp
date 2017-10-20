<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<link href="<%=basePath%>/backstage/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=basePath%>/backstage/js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>/backstage/js/bootstrap.min.js"></script>
