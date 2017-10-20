<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<meta charset="utf-8">
<title>红象云腾</title>

<meta name="keywords" content="Hadoop，redoop，HDFS，MapReduce，HBase，Hive，Zookeeper，Pig，Ambari，Sqoop">
<meta name="description" content="红象云腾redoop是一家专注于企业级大数据解决方案服务商，产品有红象CRH系列产品、数据工厂、页游数据工厂等，让企业上线PB级大数据平台更为敏捷和快速。" />



<link rel="stylesheet" href="<%=basePath%>/front/website/css/style.css" type="text/css" media="screen" />

<link rel="shortcut icon" href="<%=basePath%>/front/website/img/logo.ico">

<script type="text/javascript" src="<%=basePath%>/front/website/js/jquery-1.11.3.min.js"></script>
