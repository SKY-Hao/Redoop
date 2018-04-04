﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!doctype html>
<html>
<head>
	<jsp:include page="tools/head.jsp"></jsp:include>

	<link rel="stylesheet" href="<%=basePath%>/front/website/css/test01.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="<%=basePath%>/front/website/css/test02.css" type="text/css" media="screen" />

	<script type="text/javascript" src="<%=basePath%>/front/website/js/down_png.js"></script>
	<script type="text/javascript" src="<%=basePath%>/front/website/js/up_png.js"></script>



</head>
<body>

<jsp:include page="tools/header.jsp"></jsp:include>

<div class="bannerCon">
	<div class="container">
		<div class="bannerImg"></div>
		<p> 全球感知 精准服务</p>
	</div>
</div>


<section id="news">
	<div class="container">
		<a href="<%=basePath%>/front/weekly" id="twoWeekA" target="_blank">
			红象周报→
		</a>
		<i></i>
		<p>
			<c:forEach items="${briefingList}" var="briefing">
				<a href="<%=basePath%>/front/weekly"  target="_blank">${briefing.tabletitle}</a>
			</c:forEach>
		</p>
	</div>
</section>



<section class="block" id="function">
	<div class="container clearfix">

		<div class="productCon">
			<img src="<%=basePath%>/front/website/css/img/product-2.jpg" />
			<h2> 物联网大数据接入平台</h2>
			<p>红象云腾面向物联网推出，企业级流式数据处理平台，提供一整套可视化的数据接入方案。让数据在流动中被处理和消费，更快，更准确;超低的门槛让提供灵活的数据探索，产生商业价值。</p>
			<a href="http://www.redoop.net/group/detail/5" class="btn"  target="_blank">阅读更多主题</a>
		</div>
		<div class="productCon">
			<img src="<%=basePath%>/front/website/css/img/product-1.jpg" />
			<h2>大数据存储和计算平台</h2>
			<p>
				红象大数据发行版CRH为企业大数据实施提供一套完整的一站式大数据解决方案，产品覆盖了企业数据仓库、
				商业智能、机器学习、数据可视化等领域，助力企业在DT时代更敏捷、更智能、更具洞察力。
			</p>
			<a href="http://www.redoop.net/group/detail/2" class="btn"  target="_blank">阅读更多主题</a>
		</div>
		<div class="productCon">
			<img src="<%=basePath%>/front/website/css/img/product-3.jpg" />
			<h2>数据挖掘和AI智能分析平台</h2>
			<p>CRS支持NVIDIA，基于Hadoop Yarn完成了对TensorFlow、Caffe等常用框架的集成，同时具备良好的扩展性和兼容性，并能提供数据可视化，数据挖掘工具。</p>
			<a href="http://www.redoop.net/group/detail/4" class="btn"  target="_blank">阅读更多主题</a>
		</div>
	</div>
</section>



<section class="block grey-bg" id="function">
	<div class="container clearfix">
		<h2 class="title">成功案例</h2>
		<div class="clearfix ">
			<div class="caseIMG"><img src="<%=basePath%>/front/website/css/img/case-1.jpg" /></div>
			<div class="caseTXT">
				<h2><a href="http://www.redoop.net/group/detail/7"  target="_blank">红象数据高铁助力航天大数据</a></h2>
				<p>卫星在发射、运行过程中会产生大量的数据，如何有效存储数据以及快速计算分析这些数据，实时检测卫星状况是中国航天集团亟需解决的问题。</p>
				<a href="http://www.redoop.net/group/detail/7" class="btn"  target="_blank">阅读详情</a>
			</div>
		</div>
	</div>
</section>


<section class="block appraise">
	<div class="container clearfix">
		<div class="a" style="display:block;">
			<div class="clientLogo"><img src="<%=basePath%>/front/website/css/img/ht-Logo.png" width="383" height="60"></div>
			<h4>“红象云腾为航天大数据保驾护航”</h4>
		</div>

	</div>
</section>










<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
