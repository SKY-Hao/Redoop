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

<section class="bannerProduct"  style="margin-top: 74px;">
	<div class=" container clearfix">
		<h2>红象大数据发行版</h2>
		<p>红象大数据发行版CRH为企业大数据实施提供一套完整的一站式大数据解决方案，<br />产品覆盖了企业数据仓库、商业智能、机器学习、数据可视化等领域，<br />助力企业在DT时代更敏捷、更智能、更具洞察力</p>
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
<section class="block" id="function">
	<div class="container clearfix">
		<h2 class="title">产品架构</h2>
		<div class="clearfix" style="text-align:center">
			<img src="<%=basePath%>/front/website/img/jiagou.png" />
			<p style="text-align:left; width:904px; margin:10px auto;">核心产品在原有的(RedStream、RedDW、RedDB、RedSearch、RedML)基础上，新增分布式深度学习平台RedDL、可视化数据科学工作台Data Science Workbench、合作伙伴生态软件E-AppStore平台和社区高度协作，提供稳定可靠的接口来无缝融合更多大数据生态的软件产品，使得CRH成为一个多功能的数据分析平台，更多的第三方合作伙伴软件将出现在E-AppStore中，让CRH可以在更多的数据分析场景帮助客户解决问题。此外，升级后的CRH许可证中心，可以帮助合作伙伴更加灵活的控制集群。</p>
		</div>
	</div>
</section>
<section class="block  grey-bg" style="display:none;">
	<div class="container clearfix">
		<h2 class="title">组成部分</h2>
		<div class="clearfix">
			<div class="part clearfix">
				<img src="<%=basePath%>/front/website/img/part1.png" />
				<div class="partTxt fl">
					<h3>数据库</h3>
					<p>CRH-DB是红象云腾自主研发的基于实时的分布式数据库，可以实现千亿数据秒级响应。</p>
					<ul>
						<li>支持对象存储：以对象存储为主，容量可轻松扩展到PB，查询速度更快</li>
						<li>性能更优：支持多种工作负载的高性能</li>
						<li>高可靠性：设计保护单点故障的容错功能，数据存储可靠性更强</li>
					</ul>
				</div>
			</div>
			<div class="part clearfix">
				<img src="<%=basePath%>/front/website/img/part2.png" />
				<div class="partTxt fl">
					<h3>分布式搜索引擎</h3>
					<p>CRH-SE基于ElasticSearch的搜索服务组件，能够达到实时搜索，具有稳定、可靠、快速的特点</p>
					<ul>
						<li>更加丰富的功能：丰富的查询语法，丰富的功能模块，有数据分析和可视化展现模块</li>
						<li>更加轻量级：配置简单轻量，一款更加轻量级“NOSQL数据库”</li>
						<li>更快的响应速度：查询速度更快，用户体验更佳。百万条数据秒级响应。</li>
					</ul>
				</div>
			</div>
			<div class="part clearfix">
				<img src="<%=basePath%>/front/website/img/part3.png" />
				<div class="partTxt fl">
					<h3>时间序列数据库</h3>
					<p>CRH-TSDB它基于HBase存储数据，充分发挥了HBase的分布式列存储特性，支持数百万每秒的读写。</p>
					<ul>
						<li>更节省存储空间：可动态增加的列式存储，节省存储空间</li>
						<li>更强的查询能力：融合key/value存储模式带来实时查询的能力，以及通过MapReduce进行离线处理或者批处理的能力</li>
						<li>低延迟性：准实时近线数据处理，时效性更高</li>
					</ul>
				</div>
			</div>
			<div class="part clearfix">
				<img src="<%=basePath%>/front/website/img/part4.png" />
				<div class="partTxt fl">
					<h3>准实时流处理组件</h3>
					<p>CRH-CEP基于Storm和SparkStreaming的准实时流处理组件，具有低延迟、可扩展和高容错的诸多优点</p>
					<ul>
						<li>更好的水平扩展性：支持水平扩展，具有高容错性，数据处理可靠性好</li>
						<li>更快的计算速度：全内存计算，分布式实时计算，速度更快，性能更优</li>
						<li>更多的应用场景：适用实时分析、在线机器学习、持续计算、分布式RPC、ETL，等等多种场景</li>
					</ul>
				</div>
			</div>
			<div class="part clearfix">
				<img src="<%=basePath%>/front/website/img/part5.png" />
				<div class="partTxt fl">
					<h3>数据仓库组件</h3>
					<p>CRH-DW基于Apache Hive+Apache Hadoop的数据仓库，突破传统数据仓库数据量过大导致的数据提取缓慢的问题，存储数据量无上限要求</p>
					<ul>
						<li>更好的扩展性：基于HDFS存储，扩展性更强，动态无限扩容</li>
						<li>更强的容错性：多副本机制，具有更强的自动容错性</li>
						<li>更丰富的查询方式：它提供了丰富的SQL查询方式来分析存储在HDFS中的数据，用户可以很方便地利用SQL 语言查询、汇总、分析数据</li>
					</ul>
				</div>
			</div>
			<div class="part clearfix">
				<img src="<%=basePath%>/front/website/img/part6.png" />
				<div class="partTxt fl">
					<h3>数据挖掘组件</h3>
					<p>CRH -DM基于机器学习和统计学，提供R语言、Mahout数据挖掘</p>
					<ul>
						<li>更好的易用性：底层基于R语言，易用性强</li>
						<li>更多的分析模型：包含工业、金融、交通等多个行业的模型</li>
						<li>更强的挖掘能力：并行化计算，集成多种机器学习算法</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</section>

<%--<section class="block  grey-bg" id="case" style="margin: auto;">
	<div class="container clearfix">
		<h2 class="title">成功案例</h2>
		<c:if test="${empty solutionList2}">
			<div style="margin-left: 15px; margin-top: 15px;">
				<h3 style="color: brown"> 产品案例更新中,请您耐心等待新版本发布......</h3>
			</div>
		</c:if>
		<c:if test="${not empty solutionList2}">
			<c:forEach items="${solutionList2}" var="one2">
				<div class="col-2 fl" id="solutionCol-2">
					<div class="img">
						<a href="<%=basePath%>/front/solutiondetail/${one2.id}">
							<img src="<%=basePath%>/${one2.solutionpic}" style="max-width: 220px; max-height: 165px;"/>
						</a>
					</div>
					<div class="txt">
						<h3>
							<a href="<%=basePath%>/front/solutiondetail/${one2.id}">
									${one2.title}
							</a>
						</h3>
						<p>${one2.intro}</p>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>

</section>--%>

<section class="block grey-bg"  id="solutionSection">
	<div class="container clearfix">
		<h2 class="title">产品案例</h2>
		<div class="row" style="margin-top: auto;">
			<c:if test="${empty solutionList2}">
				<div style="margin-left: 15px; margin-top: 15px;">
					<h3 style="color: brown"> 产品案例更新中,请您耐心等待新版本发布......</h3>
				</div>
			</c:if>
			<c:if test="${not empty solutionList2}">
				<c:forEach items="${solutionList2}" var="one2">
					<div class="col-2 fl" id="solutionCol-2">
						<div class="img">
							<a href="<%=basePath%>/front/solutiondetail/${one2.id}" id="solutionImg2">
								<img src="<%=basePath%>/${one2.solutionpic}"/>
							</a>
						</div>
						<div class="txt">
							<h3 style="margin: auto">
								<a href="<%=basePath%>/front/solutiondetail/${one2.id}">
										${one2.title}
								</a>
							</h3>
							<p>${one2.intro}</p>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>

	</div>
</section>

<div style="margin-right: auto;margin-left: auto;margin-bottom: 30px;max-width: 1200px;min-width: 1200px;margin-top: -50px">
	<a href="<%=basePath%>/front/solution" class="moreLink fr">更多&gt;</a>
</div>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
