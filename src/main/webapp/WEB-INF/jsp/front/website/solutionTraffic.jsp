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


<section class="solutionTraffic" style="margin-top: 75px;"></section>
<section class="grey-bg" id="breadMenu">
	<div class="container"><a href="<%=basePath%>/">首页</a> &gt; 解决方案及案例 &gt; 交通大数据解决方案</div>
</section>
<section class="block" id="solution">
	<div class="container clearfix">
		<h2 class="titleLeft">交通大数据解决方案</h2>
		<div class="titleLine"></div>
		<div class="row">
			<div class="fr solutionImg"><img src="<%=basePath%>/front/website/img/solution-traffica.jpg" /></div>
			<div class=" solutionTxt">
				<p>随着经济的发展和城市化进程的推进，城市的人口迅猛增长，但是城市的建设并不能满足人口的增长，表现最明显的就是城市交通问题。就一个中等城市而言，交通车辆总数至少在百万级别，实时并发量巨大，要面临对海量非结构化大数据的组织与分析，对数据处理的时效性和效率提出了极大的挑战。因此，智能交通如何缓解道路压力、降低事故率、提升公共交通服务和节能减碳等问题被提上日程。
				</p>
				<p>针对交通行业的具体特点，红象云腾推出智慧交通解决方案。</p>
				<p>◎ 存储层基于红象云腾企业级发行版的分布式文件系统RedoopStor以及分布式实时数据库Hbase技术实现。存储层可同时支持结构化、半结构化、非结构化三种数据结构。同时可以支持对象存储。</p>
				<p>◎ 应用层基于红象云腾企业级发行版流处理Storm技术和离线分析Hive技术以及实时处理Spark技术，用来对存储的海量数据进行数据分析、数据挖掘。同时支持交通数据离线、近线和在线等全场景的数据分析。</p>
				<p>◎ 数据库层移入Hbase技术实现跨域的数据共享，并且上层进行优化对外提供标准的SQL接口，方便用户交互查询。</p>
				<p>◎ 红象云腾平台整合R语言进行数据挖掘和机器学习，扩展性和易用性更强，降低了开发的复杂的数据挖掘逻辑的工作量。</p>

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
				<img src="<%=basePath%>/front/website/img/profitTraffic4.png" class="center-block" />
				<p>为出行者提供实时准确的交通出行信息服务，帮助出行者根据交通状况选择更合适的出行路线及换乘方式，减少因拥堵造成的时间成本浪费。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitTraffic2.png" class="center-block" />
				<p>违法车辆追踪效率提升，通过海量数据实时分析处理功能将违法车辆数据定位时间由小时级减为分钟级甚至秒级。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitTraffic3.png" class="center-block" />
				<p>降低交通事故率，通过人脸识别技术和实时监控连续驾驶时长分析，判断车主行车状态，进行疲劳驾驶预警，降低交通事故率。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitTraffic1.png" class="center-block" />
				<p>道路拥堵率下降，通过路况监控设备收集路况信息并实时处理，能够精确绘制道路拥堵线圈，提供交管部门快速处理突发事故，并提供给大众平台供驾驶员参考从而疏导车流</p>
			</div>
		</div>
	</div>
</section>
<section class="block">
	<div class="container clearfix">
		<h2 class="titleLeft">成功案例</h2>
		<div class="col-2 fl">
			<div class="img"><a href="<%=basePath%>/front/caseTraffic"><img src="<%=basePath%>/front/website/img/case-traffic.jpg" /></a></div>
			<div class="txt">
				<h3><a href="<%=basePath%>/front/caseTraffic">交通智能化！助力辽宁智慧交通，构建高效智能城市</a></h3>
				<p>如何能全面、准确、及时地监控和分析卡口道路交通状况，缓解交通压力，降低事故率以及快速分析卡口车辆通过信息采集和打击犯罪，是当前交通厅系统急于解决的问题。</p>
			</div>
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
