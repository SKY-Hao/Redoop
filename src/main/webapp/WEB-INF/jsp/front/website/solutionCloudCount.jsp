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


<section class="solutionCloud" style="margin-top: 75px;"></section>
<section class="grey-bg" id="breadMenu">
	<div class="container"><a href="<%=basePath%>/">首页</a> &gt; 解决方案及案例 &gt; 云计算大数据解决方案</div>
</section>
<section class="block" id="solution">
	<div class="container clearfix">
		<h2 class="titleLeft">云计算大数据解决方案</h2>
		<div class="titleLine"></div>
		<div class="row">
			<div class="fr solutionImg"><img src="<%=basePath%>/front/website/img/solution-cloudCounta.png" /></div>
			<div class=" solutionTxt">
				<p>大数据分析和处理需要海量的存储资源、和计算资源。云端大数据方案提供了“无限”的存储和计算能力，加之可以快速部署，无疑是一个理想选择。红象云腾提供的RedCloud解决方案，RedCloud为企业级云端大数据提供一套RedCloud+CRH解决方案，保证数据安全。
					RedCloud可以把大数据及分析结果存储在RedCloud Storage(云存储)中。在需要大数据分析时启动Redoop的Hadoop 群集，分析完毕后可以进行可视化展现，对外数据共享。最终结果数据存储在云中，也可以存储到主流的关系型数据库/NOSQL中。
				</p>
				<p>方案架构</p>
				<img src="<%=basePath%>/front/website/img/solution-cloudCount1.gif" />
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
				<img src="<%=basePath%>/front/website/img/profitCloud3.png" class="center-block" />
				<h3>管理可视化</h3>
				<p>可视化集群管理界面，清晰明了，实时监控。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitCloud4.png" class="center-block" />
				<h3>存储多样化</h3>
				<p>弹性存储，支持结构化、半结构化、分结构化多种数据存储</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitCloud1.png" class="center-block" />
				<h3>处理实时化</h3>
				<p>实时流数据处理，30亿数据秒级响应</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitCloud2.png" class="center-block" />
				<h3>分析简单化</h3>
				<p>DataBank拖拽式数据分析，操作更简，性能更优</p>
			</div>
		</div>
	</div>
</section>
<section class="block">
	<div class="container clearfix">
		<h2 class="titleLeft">成功案例</h2>
		<div class="row">
			<div class="col-2 fl">
				<div class="img"><a href="<%=basePath%>/front/caseUnicom"><img src="<%=basePath%>/front/website/img/case-unicom1.jpg" /></a></div>
				<div class="txt">
					<h3><a href="<%=basePath%>/front/caseUnicom">助力联通打造云端大数据平台，实现大数据平台一键上云</a></h3>
					<p>大数据分析和处理需要海量的存储资源和计算资源。联通云大数据平台提供了“无限”的存储和计算能力，可以一键部署。</p>
				</div>
			</div>
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
