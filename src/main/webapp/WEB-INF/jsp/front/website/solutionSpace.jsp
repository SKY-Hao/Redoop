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


<section class="solutionVideo" style="margin-top: 75px;"></section>
<section class="grey-bg" id="breadMenu">
	<div class="container"><a href="<%=basePath%>/">首页</a> &gt; 解决方案及案例 &gt; 航天大数据解决方案</div>
</section>
<section class="block" id="solution">
	<div class="container clearfix">
		<h2 class="titleLeft"><span class="container">航天大数据解决方案</span></h2>
		<div class="titleLine"></div>
		<div class="row">
			<div class="fr solutionImg"><img src="<%=basePath%>/front/website/img/solution-videoa.jpg" /></div>
			<div class=" solutionTxt">
				<p>通过近年来国家持续投入，航天人的不断努力，中国航天事业取得了长足进步。而在新的时代，航天也面临着一些新的转变，首先是由科研向应用转变，其次，由单产向批量转变。这些转变意味着航天任务将附加更多的职能，产品研制的压力持续增加，如何通过信息科技手段来解决这些问题，也成为航天界迫切需要解决的课题。而如何管好、利用好航天器的工程数据，则是这些问题中的重中之重。北京红象云腾科技公司依托多年的航天行业经验，自主研发了航天大数据平台CRH系列产品，并成功地应用于航天领域，为中国航天事业的高速发展提供助力。</p>
				<p>针对航天领域数据量大、数据增长快等特点，我们采用分布式架构对数据进行存储和计算。分布式架构是一种应对海量数据处理场景而产生的全新的技术架构，分布式架构在进行海量数据处理时，将巨大的数据处理任务分解成许多小任务，交由多台设备共同完成，极大地提高了海量数据处理的效率。</p>

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
				<img src="<%=basePath%>/front/website/img/profitVideo2.png" class="center-block" />
				<h3>高性能</h3>
				<p>一个巨大的数据处理任务将被分成许多小的任务，交由多台设备来协同完成，极大地提高了数据处理的能力，满足了大数据时代对海量数据处理的需求。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitVideo1.png" class="center-block" />
				<h3>高扩展性</h3>
				<p>将数据处理的任务分给多台设备来并行完成，设备的数量与数据处理的能力呈一个线性增长的关系，可以弥补传统集中式架构在扩展能力上的不足。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitBridge4.png" class="center-block" />
				<h3>高稳定性</h3>
				<p>提供数据的冗余机制，某一节点硬盘损坏或这个节点整体的损坏不会影响数据的安全性，具有极高的稳定性。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitPolice1.png" class="center-block" />
				<h3>高性价比</h3>
				<p>硬件平台的选择上一般采用高性价比的X86服务器集群，相比于传统的集中式架构中昂贵的高性能服务器和高端存储，具有较高的性价比。</p>
			</div>
		</div>
	</div>
</section>
<section class="block" id="newsPage">
	<div class="container clearfix">
		<h3 class="titleLeft">解决方案</h3>
		<div class="newsInfo">
			<h2>针对航天领域，我们采用了分布式存储和分布式计算的方式，具体详情如下。</h2>
			<p>1、分布式文件存储</p>
			<p>分布式文件存储以HDFS为核心，上图中DN为DataNode，NN为NameNode这两个都是HDFS的组件，NN为管理节点，DN为存储节点。管理节点负责管理元数据信息（数据大小，存储位置等信息），存储节点负责数据的存储，并会定时向管理节点通信报告自己的生存状况，两者协同工作保证存储数据的完整性和高效性。</p>
			<p>下图是分布式数据存储架构如下：</p>
			<img src="<%=basePath%>/front/website/img/solution-space2.jpg" />
			<p class="imgTxt">在计算前海量数据被分布存储在多个节点上。应用程序编写好后会被复制成多份分配到多个服务器上同时并行计算，每个计算程序使计算原始数据的一部分，从而提高了计算效率。此过程中并非像传统的处理模式一样将数据移动到程序端造成大量的网络使用，而是移动程序到数据端。</p>
			<p>下图为分布式计算架构：</p>

			<img src="<%=basePath%>/front/website/img/solution-space3.jpg" />

		</div>
	</div>
</section>
<section class="block grey-bg">
	<div class="container clearfix">
		<h2 class="titleLeft">成功案例</h2>
		<div class="col-2 fl">
			<div class="img"><a href="<%=basePath%>caseSpace"><img src="<%=basePath%>/front/website/img/case-space.jpg" /></a></div>
			<div class="txt">
				<h3><a href="<%=basePath%>caseSpace">红象数据高铁为中国航天事业保驾护航</a></h3>
				<p>卫星在发射、运行过程中会产生大量的数据，如何有效存储数据以及快速计算分析这些数据，实时检测卫星状况是XX航天集团亟需解决的问题。</p>
			</div>
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
