<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<link href="<%=basePath%>/backstage/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="<%=basePath%>/backstage/css/license.css?v=4.1.0" rel="stylesheet">

<link href="<%=basePath%>/backstage/css/page.css" rel="stylesheet">


