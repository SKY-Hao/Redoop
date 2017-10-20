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


<section class="solutionGene" style="margin-top: 75px;"></section>
<section class="grey-bg" id="breadMenu">
	<div class="container"><a href="<%=basePath%>/">首页</a> &gt; 解决方案及案例 &gt; 基因大数据解决方案</div>
</section>
<section class="block" id="solution">
	<div class="container clearfix">
		<h2 class="titleLeft">基因大数据解决方案</h2>
		<div class="titleLine"></div>
		<div class="row">
			<div class="fr solutionImg"><img src="<%=basePath%>/front/website/img/solution-genea.jpg" /></div>
			<div class=" solutionTxt">
				<p>随着社会经济、科技的高速发展以及人民生活水平的不断提高，
					生物医学大数据将逐步从"概念"走向"价值",引发医疗健康行业的巨大变革,最终生物医学大数据将被上升到国家战略层面,成为影响国计民生的重要战略性产业近几年,大数据技术得到了飞速发展,它的触角不断地延伸,如今已经延伸到了生物医疗领域。在美国,政府已开始利用大数据来预防流感蔓延。新一代的高通量测序技术让以往无比昂贵的基因测序不再遥不可及,催生了整个行业数据的爆发式增长。目前美国拥有2000多家从事人类基因序列分析的公司,预测未来将会有更多企业涉足这一领域。这也意味着,由大数据主导的个性化医疗时代即将来临。然而，传统的 IT 架构的由于性能和横向扩展能力有限，已不能适应快速发展的基因测序的需求，业界迫切需要一套新的 IT 系统解决方案来实现海量基因数据的存储和分析。
				</p>
				<p>基于上述需求，红象云腾企业级大数据平台CRH4.9提供基于HDFS的分布式的基因存储仓库，负责存储基因原始数据和各类基因分析软件的中间数据和结果数据；平台同时提供大数据分析计算系统、数据权限管理系统以及前端的可视化展现系统。</p>

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
				<img src="<%=basePath%>/front/website/img/profitGene1.png" class="center-block" />
				<h3>高度集成的大数据平台</h3>
				<p>包括基因大数据存储、计算以及可视化展现</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitGene4.png" class="center-block" />
				<h3>高度可扩展的存储</h3>
				<p>历史案例中存储最大数据量4PB+，集群节点100+</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitGene2.png" class="center-block" />
				<h3>快速检索服务</h3>
				<p>平台整合多种分析工具和算法，能够实现千亿级数据秒级响应，实现快速查询基因库服务。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitGene3.png" class="center-block" />
				<h3>完善的服务体系</h3>
				<p>20+以上的技术团队支持，降低系统后期维护成本。</p>
			</div>
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
