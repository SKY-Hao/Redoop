﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!doctype html>
<html>
<head>
    <title>红象云腾-云销售</title>
    <link rel="stylesheet" href="<%=basePath%>/front/website/css/sales.css" type="text/css" media="screen" />
</head>

<body>
<div class="container">
    <h1 class="saleTxt"></h1>
    <div class="downArea">
        <div class="anzhuo">安卓版<br />
            <a href="<%=basePath%>/front/website/css/img/salesImage/CloudSales.apk" class="downBtn">立即下载</a>
        </div>
        <div class="weixin">
            微信小程序<br />
            <img  src="<%=basePath%>/front/website/css/img/salesImage/weixinxiaochengxu.png" style="margin-top: 5px;" />
        </div>
        <div style="clear: both"></div>
    </div>
    <div class="logoYun"></div>
    <div class="shadow"></div>
</div>
</body>
</html>
