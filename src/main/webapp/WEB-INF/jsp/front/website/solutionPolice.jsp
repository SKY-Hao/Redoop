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

<section class="solutionPolice" style="margin-top: 75px;"></section>
<section class="grey-bg" id="breadMenu">
	<div class="container"><a href="<%=basePath%>/">首页</a> &gt; 解决方案及案例 &gt; 公安大数据解决方案</div>
</section>
<section class="block" id="solution">
	<div class="container clearfix">
		<h2 class="titleLeft">公安大数据解决方案</h2>
		<div class="titleLine"></div>
		<div class="row">
			<div class="fr solutionImg"><img src="<%=basePath%>/front/website/img/solution-policea.jpg" /></div>
			<div class=" solutionTxt">
				<p>随着数据的集中和业务的发展，公安系统多年运行积累下来的警务数据及其相关的社会参照数据，如卡口、视频、犯罪人员、社会比对等数据量正在急速增长，公安行业对数据的管理与应用需求已经超越了传统的历史数据备份的需求。红象云腾作为业界领先的云计算大数据基础平台解决方案供应商，凭借在大数据管理与分析领域的优势资源，打造基于大数据平台的警务云系统解决方案，为公安行业解决了数据量庞大、来源多样、处理复杂的难题。</p>
				<p>红象云腾大数据平台CRH，以Hadoop为核心，融合其他技术平台系统。通过红象云腾数据平台 CRH实现高可用、高性能、高安全的数据存储、数据分析以及大数据应用服务开发等核心技术，构建省公安厅大数据资源库，实现整合交换、数据采集、数据同步、数据集成和大数据资源管理；建立省公安大数据应用服务支撑平台，结合大数据应用服务开发软件，为公安通用基础服务，如智能搜索、一站式服务、机器学习、统计服务、地图服务等提供大数据应用开发的全生命周期管理，同时对上层大数据应用提供数据服务支撑。具体建设方案如下：</p>
				<p>◎ 通过建设大数据中心整合各个来源的业务数据实现数据的集中和交换共享<br />
					◎ 通过建设大数据平台实现公安海量业务数据的深度挖掘分析<br />
					◎ 实现多业务系统的实时打通实现情报的实时分析决策有效促进业务协同<br />
					◎ 基于云平台提供的基础设施帮助应用开发商和基层民警快速构建警务应用<br />
					◎ 面向社会和单位开发信息服务广泛采集社会信息服务于公安业务<br /></p>
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
				<img src="<%=basePath%>/front/website/img/profitPolice1.png" class="center-block" />
				<h3>一键云搜寻踪迹</h3>
				<p>通过数据挖掘等大数据技术，对海量数据对象进行自动分类、整理，对海量数据库中的各种行为特征进行分析，从而发现行为规律、趋势，了解不同行为之间的关联，以及何种状态会诱发何种犯罪行为，进行串并案分析，提供破案线索和情报，预测并预防犯罪。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitPolice2.png" class="center-block" />
				<h3>一键摸排找嫌疑</h3>
				<p>通过组合应用侦查摸排助手、超级档案等子系统，可以分析摸排案件嫌疑人，并通过超级档案应用掌握嫌疑人的全息详细档案。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitPolice3.png" class="center-block" />
				<h3>一键预警控高危</h3>
				<p>运用高危人员分析子系统，实时掌握各类高危人员在我省的的聚集情况，并通过活动频率分析进行预警预防。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitPolice4.png" class="center-block" />
				<h3>一键扩线挖团伙</h3>
				<p>通过组合应用侦查摸排助手、超级档案等子系统，可以分析摸排案件嫌疑人，并通过超级档案应用掌握嫌疑人的全息详细档案。</p>
			</div>
		</div>
	</div>
</section>
<section class="block">
	<div class="container clearfix">
		<h2 class="titleLeft">成功案例</h2>
		<div class="row">
			<div class="col-2 fl">
				<div class="img"><a href="<%=basePath%>/front/casePolice"><img src="<%=basePath%>/front/website/img/case-police1.jpg"/></a></div>
				<div class="txt">
					<h3><a href="<%=basePath%>/front/casePolice">构建极致公安检索系统，维护社会公共秩序。</a></h3>
					<p>公安行业有大量的数据（亲属关系、同户口数据、通话数据、住宿数据）待计算。受限于传统的技术框架，硬件支持等，公安行业数据无法发挥出应有的价值。</p>
				</div>
			</div>
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
