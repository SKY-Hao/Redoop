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


<section class="solutionBridge" style="margin-top: 75px;"></section>
<section class="grey-bg" id="breadMenu">
	<div class="container"><a href="<%=basePath%>/">首页</a> &gt; 解决方案及案例 &gt; 桥梁大数据解决方案</div>
</section>
<section class="block" id="solution">
	<div class="container clearfix">
		<h2 class="titleLeft">桥梁大数据解决方案</h2>
		<div class="titleLine"></div>
		<div class="row">
			<div class="fr solutionImg"><img src="<%=basePath%>/front/website/img/solutionBridge.jpg" /></div>
			<div class=" solutionTxt">
				<p>近些年来，随着经济和交通的飞速发展，由于地理条件的制约等因素，大跨度桥梁已成为桥梁工程的发展趋势。如何对桥梁健康检测也成了困扰多年的难题。</p>
				<p>针对桥梁健康监测获取海量数据却无法实时精确地监测评估桥梁结构状态的困难性,红象云腾提出了基于大数据理论的桥梁健康监测方案。事实表明,基于Hadoop平台的并行计算和上层的聚类、相关性等分析以及可视化分析能够很好的检测桥梁的健康状况。</p>
				<a href="<%=basePath%>/front/aboutus" class="aBtn">咨询详情</a>
			</div>
		</div>
	</div>
</section>
<section class="block grey-bg" id="value">
	<div class="container clearfix">
		<h2 class="titleLeft">客户收益</h2>
		<div class="clearfix">
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitBridge2.png" class="center-block" />
				<h3>安全</h3>
				<p>HDFS数据存储的安全可靠性</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitBridge1.png" class="center-block" />
				<h3>快速</h3>
				<p>Spark实时并行分析、检测桥梁健康度</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitBridge4.png" class="center-block" />
				<h3>精准</h3>
				<p>数据建模，精准呈现分析结果</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitBridge3.png" class="center-block" />
				<h3>简单</h3>
				<p>操作简单，可视化展现清晰明了</p>
			</div>
		</div>
	</div>
</section>
<section class="block" id="newsPage">
	<div class="container clearfix">
		<h3 class="titleLeft">解决方案</h3>
		<div class="newsInfo">
			<img src="<%=basePath%>/front/website/img/solution-bridge1.gif" />
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
