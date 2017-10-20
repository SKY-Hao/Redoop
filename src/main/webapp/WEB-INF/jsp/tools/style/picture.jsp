<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<link href="<%=basePath%>/backstage/picture/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>/backstage/picture/font-awesome.min.css" rel="stylesheet">
<link href="<%=basePath%>/backstage/picture/picture.css" rel="stylesheet">

