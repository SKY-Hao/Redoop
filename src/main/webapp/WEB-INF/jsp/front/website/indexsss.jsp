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

<div class="banner2"  style="margin-top: 74px;">
	<ul></ul>
	<ol></ol>
	<i class="left"></i><i class="right"></i>
</div>
<section id="news">
	<div class="container">
		<%--<a href="http://www.redoop.com/front/news" class="fr moreLink">更多</a>--%>
		<a href="<%=basePath%>/front/week" class="fr moreLink">红象云腾周报</a>
		<i></i>
		<p>
			<c:forEach items="${briefingList}" var="briefing">
				<a href="<%=basePath%>/front/week"  target="_blank">红象云腾与新云东方技术交流会圆满结束</a>
			</c:forEach>
			<%--<a href="http://www.redoop.com/front/onenew/30"  target="_blank">红象云腾与新云东方技术交流会圆满结束</a>
			<a href="http://www.redoop.com/front/onenew/29" target="_blank">《中国经济导报》专访红象云腾童小军先生</a>--%>

		</p>
	</div>
</section>
<section class="block" id="function">
	<div class="container clearfix">
		<h2 class="title">产品功能</h2>
		<div class="clearfix">
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/function_storage.png" class="center-block" />
				<h3>分布式存储</h3>
				<p>化整为零,分块存储。支持结构化和非结构化数据存储,管理PB规模数据。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/function_count.png" class="center-block" />
				<h3>分布式计算</h3>
				<p>移动计算,分块处理。支持批处理模型,流计算模型,处理TB规模数据。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/function_database.png" class="center-block" />
				<h3>分布式数据库</h3>
				<p>单表支持千亿行,支持标准SQL,支持高速查询。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/function_datadig.png" class="center-block" />
				<h3>分布式数据挖掘</h3>
				<p>并行数据挖掘算法,支持R数据挖掘,支持深度学习。</p>
			</div>
		</div>
	</div>
</section>
<section class="block grey-bg" id="character" style="margin: auto;">
	<div class="container clearfix">
		<h2 class="title">产品特性</h2>
		<div class="clearfix">
			<div class="row">
				<div class="col-2 fl">
					<div class="img"><a><img src="<%=basePath%>/front/website/img/texing1.png" /></a></div>
					<div class="txt">
						<h3>平台开放性</h3>
						<ul>
							<li>红象云腾(REDOOP)致力于采用完全开放的软件开发方式，集成组件和应用E-AppStore，从而保证了平台开放性和创新性。</li>
							<li>CRH使企业在处理和存储海量的结构化、非结构化数据时无需像以前一样花费大量高额的成本。</li>
							<li>CRH提供企业级Hadoop发行版，100%开源，促进了平台创新还可以防止供应商的技术垄断。</li>
							<li>CRH跨平台，支持五大主流硬件X86，Power，ARM，MIPS，Alpha架构。CRH支持FPGA/GPU硬件加速，提升Hadoop整体性能。</li>
						</ul>
					</div>
				</div>
				<div class="col-2 fl">
					<div class="img"><a><img src="<%=basePath%>/front/website/img/texing3.png" /></a></div>
					<div class="txt">
						<h3>一体化</h3>
						<ul>
							<li>CRH基于YARN实现一体化的架构、统一资源管理。这种架构使得各种应用程序间可灵活的动态分配资源。</li>
							<li>YARN使企业可以灵活的支撑不同的数据应用，从而最大限度的使用资源快速提取数据。</li>
							<li>YARN为数据治理提供安全的集群服务、保障集群的稳定性。</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-2 fl">
					<div class="img"><a><img src="<%=basePath%>/front/website/img/texing2.png" /></a></div>
					<div class="txt">
						<h3>互操作</h3>
						<ul>
							<li>CRH与广泛的数据中心和云供应商可以互操作。</li>
							<li>CRH数据的处理能力帮助企业最大程度降低成本、节省时间并且最大化的利用企业现有IT基础设施。</li>
							<li>借助CRH，客户在采用Hadoop后仍然可以保全现有IT架构的投资。</li>
						</ul>
					</div>
				</div>
				<div class="col-2 fl">
					<div class="img"><a><img src="<%=basePath%>/front/website/img/texing4.png" /></a></div>
					<div class="txt">
						<h3>企业级安全</h3>
						<ul>
							<li>CRH提供了对集群的一体化管理、监控和审计。</li>
							<li>使用CRH，企业大数据平台内置数据安全、数据治理能力。</li>
							<li>CRH可以确保数据访问时的可靠性、并提供安全管控的能力。</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<section class="block" id="case">
	<div class="container clearfix">
		<h2 class="title">成功案例</h2>
		<div class="row">
			<div class="col-2 fl">
				<div class="img">
					<!-- <a href="<%=basePath%>/front/caseSpace">-->
					<a>
						<img src="<%=basePath%>/front/website/img/case-space.jpg" />
					</a>
				</div>
				<div class="txt">
					<h3>
						<!--<a href="<%=basePath%>/front/caseSpace">红象数据高铁为中国航天事业保驾护航</a></h3>-->
						红象数据高铁为中国航天事业保驾护航</h3>
					<p>卫星在发射、运行过程中会产生大量的数据，如何有效存储数据以及快速计算分析这些数据，实时检测卫星状况是XX航天集团亟需解决的问题。</p>
				</div>
			</div>
			<div class="col-2 fl">
				<div class="img">
					<!--<a href="<%=basePath%>/front/caseLenovo">-->
					<a>
						<img src="<%=basePath%>/front/website/img/case-lenovo.jpg" />
					</a>
				</div>
				<div class="txt">
					<h3>
						<!--<a href="<%=basePath%>/front/caseLenovo">构建联想电商大数据平台</a>-->
						构建联想电商大数据平台
					</h3>
					<p>针对联想电商平台进行用户画像，用户流量分析等，对用户最终消费行为分析，实现用户精准营销的推送。</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-2 fl">
				<!--<div class="img"><a href="<%=basePath%>/front/caseTraffic"><img src="<%=basePath%>/front/website/img/case-traffic.jpg" /></a></div>-->
				<div class="img"><a><img src="<%=basePath%>/front/website/img/case-traffic.jpg" /></a></div>
				<div class="txt">
					<!--<h3><a href="<%=basePath%>/front/caseTraffic">交通智能化！助力辽宁智慧交通，构建高效智能城市</a></h3>-->
					<h3>交通智能化！助力辽宁智慧交通，构建高效智能城市</h3>
					<p>如何能全面、准确、及时地监控和分析卡口道路交通状况，缓解交通压力，降低事故率以及快速分析卡口车辆通过信息采集和打击犯罪，是当前交通厅系统急于解决的问题。</p>
				</div>
			</div>
			<div class="col-2 fl">
				<!--<div class="img"><a href="<%=basePath%>/front/caseUnicom"><img src="<%=basePath%>/front/website/img/case-unicom.jpg" /></a></div>-->
				<div class="img"><a><img src="<%=basePath%>/front/website/img/case-unicom.jpg" /></a></div>
				<div class="txt">
					<!--<h3><a href="<%=basePath%>/front/caseUnicom">助力联通打造云端大数据平台，实现大数据平台一键上云</a></h3>-->
					<h3>助力联通打造云端大数据平台，实现大数据平台一键上云</h3>
					<p>大数据分析和处理需要海量的存储资源和计算资源。联通云大数据平台提供了“无限”的存储和计算能力，可以一键部署。</p>
				</div>
			</div>
		</div>
		<a href="<%=basePath%>/front/solution" class="moreLink fr">更多&gt;</a>
	</div>
</section>
<section class="block grey-bg" style="margin: auto;">
	<div class="container clearfix" id="solution">
		<h2 class="title">解决方案</h2>
		<div class="clearfix">
			<!--<div class="col-4">
				<a href="<%=basePath%>solutionPolice"><img src="<%=basePath%>/front/website/img/solution-police.jpg" alt="" class="center-block" /></a>
				<h4><a href="<%=basePath%>solutionPolice">公安大数据解决方案</a></h4>
			</div>
			<div class="col-4">
				<a href="<%=basePath%>solutionGene"><img src="<%=basePath%>/front/website/img/solution-gene.jpg" class="center-block" /></a>
				<h4><a href="<%=basePath%>solutionGene">基因大数据解决方案</a></h4>
			</div>
			<div class="col-4">
				<a href="<%=basePath%>solutionTraffic"><img src="<%=basePath%>/front/website/img/solution-traffic.jpg" class="center-block" /></a>
				<h4><a href="<%=basePath%>solutionTraffic">交通大数据解决方案</a></h4>
			</div>
			<div class="col-4">
				<a href="<%=basePath%>solutionBridge"><img src="<%=basePath%>/front/website/img/solution-bridge.jpg" class="center-block" /></a>
				<h4><a href="<%=basePath%>solutionBridge">桥梁大数据解决方案</a></h4>
			</div>-->
			<div class="col-4">
				<a><img src="<%=basePath%>/front/website/img/solution-police.jpg" alt="" class="center-block" /></a>
				<h4>公安大数据解决方案</h4>
			</div>
			<div class="col-4">
				<a><img src="<%=basePath%>/front/website/img/solution-gene.jpg" class="center-block" /></a>
				<h4>基因大数据解决方案</h4>
			</div>
			<div class="col-4">
				<a><img src="<%=basePath%>/front/website/img/solution-traffic.jpg" class="center-block" /></a>
				<h4>交通大数据解决方案</h4>
			</div>
			<div class="col-4">
				<a><img src="<%=basePath%>/front/website/img/solution-bridge.jpg" class="center-block" /></a>
				<h4>桥梁大数据解决方案</h4>
			</div>
		</div>
		<a href="<%=basePath%>/front/solution" class="moreLink fr">更多&gt;</a>
	</div>
</section>
<section class="block">
	<div class="container clearfix">
		<h2 class="title">我们的合作伙伴</h2>
		<h3 class="title">携手世界顶级厂商及社区联盟共同开发</h3>
		<div class="clearfix">
			<div class="companyPraise fr">
				<p>Redoop works closely with Microsoft team, they highly acknowledge the values Azure and Azure Marketplace can bring to help customers quickly and easily deploy Hadoop cluster and large-scale nodes by just a few clicks. </p>
				<em>Nevin Dong&nbsp;&nbsp;&nbsp;Principle Technical Evangelist (TE), Microsoft</em>
			</div>
			<div class="companyTxt fl">
				<strong>致力国产，放眼世界</strong><br />
				携手世界顶级IT公司，打造国产高性能大数据平台。
			</div>
		</div>
		<dl class="logoListDL clearfix">
			<dt>厂商合作伙伴</dt>
			<dd><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/union_ibm.jpg" /></a></dd>
			<dd><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/union_microsoft.jpg" /></a></dd>
			<dd><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/union_kylin.jpg" /></a></dd>
			<dd><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/union_redflag.jpg" /></a></dd>
			<dd><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/union_sc.jpg" /></a></dd>
			<dd><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/union_zhongtai.jpg" /></a></dd>
			<dd><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/union_xydf.jpg" /></a></dd>
			<dd><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/union_zkdj.jpg" /></a></dd>
			<dd><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/union_sjj.jpg" /></a></dd>
		</dl>
		<dl class="logoListDL clearfix">
			<dt>社区联盟合作伙伴</dt>
			<dd><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/union_odpi.jpg" /></a></dd>
			<dd><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/union_openpower.jpg" /></a></dd>
		</dl>
	</div>
</section>
<section class="block grey-bg" style="margin: auto;">
	<div class="container clearfix">
		<h2 class="title">我们的客户</h2>
		<ul class="logoList">
			<li><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/clientLenovo.jpg" /></a></li>
			<li><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/clientGF.jpg" /></a></li>
			<li><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/clientHSBC.jpg" /></a></li>
			<li><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/clientSGHT.jpg" /></a></li>
			<li><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/clientZBDX.jpg" /></a></li>
			<li><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/clientLNJT.jpg" /></a></li>
			<li><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/clientHK.jpg" /></a></li>
			<li><a href="javascript:void()"><img src="<%=basePath%>/front/website/img/clientUnicom.jpg" /></a></li>
		</ul>
	</div>
</section>

<section class="block appraise">
	<div class="container clearfix">
		<div class="a" style="display:block;">
			<div class="clientLogo"><img src="<%=basePath%>/front/website/img/openpower.png"></div>
			<h4>“红象云腾为OpenPower生态提供Hadoop动力。”</h4>
		</div>

	</div>
</section>


<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
