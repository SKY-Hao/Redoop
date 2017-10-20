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

<section class="grey-bg" id="breadMenu"  style="margin-top: 75px;">
	<div class="container"><a href="<%=basePath%>">首页</a> &gt; 成功案例</div>
</section>
<section class="block" id="newsPage">
	<div class="container clearfix">
		<h2 class="titleLeft">构建极致公安检索系统，维护社会公共秩序</h2>
		<div class="headSource">
			<span class="date-published">2017/2/17 0:00:00</span>
			<span class="author">作者：admin</span>
			<span class="source">来源： <a>admin </a></span>
		</div>
		<div class="newsInfo">
			<h2>一、项目背景</h2>
			<p>随着大数据技术的不断完善，大数据在全球各个领域都已经被认可，并给予很高的评价。国内企业与行业同样纷纷拥抱大数据，主要以通信行业（移动
				、联通、电信）、金融行业、互联网电商等为领军行业。其中公安行业对大数据同样有着迫切的需求。
			</p>
			<p>公安行业有大量的数据（亲属关系、同户口数据、通话数据、住宿数据）待计算。受限于传统的技术框架，硬件支持等，公安行业数据无法发挥出应有的价值。导致工作效率较低，严重的导致部分功能（车辆同行、酒店同行同住等）难以实现。</p>
			<h2>二、项目需求</h2>
			<p><strong>（1）容量需求：</strong>该项目第一个需求便是数据存储需求，客户拥有大量的酒店入住数据需要做长期存储，其中包含日期、姓名、性别、年龄等。数据量高达几千亿条数据。</p>
			<p><strong>（2）性能需求：</strong>对于给定的需求，业务查询性能需要在海量数据的背景下秒级（三秒）返回。数据计算性能需要分钟级返回（最新一天数据）。</p>
			<p><strong>（3）计算需求：</strong>计算需求主要以酒店同住计算、酒店同行计算等。</p>
			<p><strong>（4）功能需求：</strong>基于酒店住宿信息的同行、同住分析。</p>
			<h2>三、项目架构</h2>
			<p class="imgTxtUp">该项目的总的架构支持为下图Redoop的数据银行+数据高铁的核心架构，项目流程图如下：</p>
			<img src="<%=basePath%>/front/website/img/case-police.jpg" />
			<p>项目中数据收集系统收集数据存储到数据库中。大数据平台数据同步组件将数据同步至大数据平台。此架构HDFS作为海量数据的存储系统，MapReduce、Spark作为计算系统。</p>
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>