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
	<div class="container"><a href="<%=basePath%>/">首页</a> &gt; 解决方案及案例 &gt; 视频大数据解决方案</div>
</section>
<section class="block" id="solution">
	<div class="container clearfix">
		<h2 class="titleLeft">视频大数据解决方案</h2>
		<div class="titleLine"></div>
		<div class="row">
			<div class="fr solutionImg"><img src="<%=basePath%>/front/website/img/solution-videoa.jpg" /></div>
			<div class=" solutionTxt">
				<p>在视频监控方面，大数据时代正在悄悄来临。在交通管理、城市安全中都有大量的视频监控设备，这些设备将产生大量的视频及其相关的数据，如交通卡口数据达到十亿条甚至更大级别，公安系统人脸库数量达到千万条甚至更大级别。针对如此大级别的数据量，如何能够合理的存储并且能够快速的检索分析，解决这些问题都需要一个成熟稳定的平台。</p>
				<p>视频大数据一直是红象云腾的重要战略方向，红象视频大数据平台XXX提供从视频采集、视频数据存储到视频数据分析的一站式平台。平台底层视频存储基于开源的HDFS和CEPH。上层的数据分析基于Spark和机器学习等。能够轻松应对大量视频的检索、分析问题。</p>

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
				<h3>端到端的完美结合</h3>
				<p>从视频采集到分析的一站式解决方案</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitVideo1.png" class="center-block" />
				<h3>高性能的视频存储设计</h3>
				<p>高性能、高容错、无限扩容确保视频存储的安全可靠。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitBridge4.png" class="center-block" />
				<h3>精准高效的数据分析设计</h3>
				<p>高度集成人脸识别算法，高度整合批处理、流处理、内存计多种技术，确保数据分析的准确时效性。</p>
			</div>
			<div class="col-4">
				<img src="<%=basePath%>/front/website/img/profitPolice1.png" class="center-block" />
				<h3>海量视频快速检索</h3>
				<p>通过对移动目标的实时检测、识别、分类以及多目标跟踪等实现海量视频快速及检索。</p>
			</div>
		</div>
	</div>
</section>
<section class="block" id="newsPage">
	<div class="container clearfix">
		<h3 class="titleLeft">解决方案</h3>
		<div class="newsInfo">
			<h2>解决方案</h2>
			<p>1、高清视频采集方案</p>
			<p>视频监控采集系统主要实现对本路段下所辖的高清摄像机、硬盘录像机、网络存储设备和IPSAN的集中管理。本方案应统一采用数字化视频监控模式，不仅能够满足对高清摄像机视频数字化监管的需要，还可以兼容硬盘录像机、IPSAN等网络存储设备，并进行视频数字化联网实现高速干线、大桥、服务区、收费站等实时视频调阅、录像存储及下载等功能。</p>
			<p>硬件系统主要包括各种服务器、网络设备、存储设备、摄像机等，软件平台主要包括监控中心、监控分中心、收费站的视频监控系统。本系统采用分布式体系结构，系统的物理结构如下图所示：</p>
			<img src="<%=basePath%>/front/website/img/solution-video1.gif" />
			<p class="imgTxt">视频监控系统物理结构图</p>
			<p>2、高效视频存储方案</p>
			<p>Redoop的视频平台框架OpenVMC集成Hadoop技术，运用其强大的分布式文件存储系统HDFS存储大量的视频文件，Hadoop的分布式文件系统(HDFS)被设计成适合运行在通用硬件(commodity hardware)上的分布式文件系统。系统参照关系数据库的核心外部排序和检索机制，采用专用的内嵌数据格式，特别适合对录像资料进行检索，具备高并发事务处理能力、系统崩溃时自动恢复、数据复制等高级特性。它和现有的分布式文件系统有很多共同点。但同时，它和其他的分布式文件系统的区别也是很明显的。HDFS是一个高度容错性的系统，适合部署在廉价的机器上。HDFS能提供高吞吐量的数据访问，非常适合大规模数据集上的应用。HDFS放宽了一部分POSIX约束，来实现流式读取文件系统数据的目的。</p>
			<img src="<%=basePath%>/front/website/img/solution-video2.gif" />
			<p class="imgTxt">OpenVMC-Hadoop分布式存储</p>
			<p>核心思想：<br />1）化整为零,分片存储;<br />2）移动计算,分片处理;<br />3）本地化计算,并行IO;</p>
			<p>优势：<br />1）计算能力和机器数量成正比<br />2）IO能力和机器数量成正比<br />3）成本低廉，为计算提供动力</p>
			<p>下图为OpenVMC 分布式存储和传统视频集中式存储相比的优势：</p>
			<p>3、精准视频分析方案</p>
			<p>核心技术<br />1.海量视频接入 OpenNVR<br />
				2.视频离线分析 SeasBase<br />
				3.视频实时分析 SeasCam<br />
				4.视频数据分析 SeasETL<br />
				5.分析图表展现 RedBI<br />
			</p><p>NVR作为数据源和视频汇集工具提供视频流到三个部分,保存本地存储,接入到HDFS,数据流到队列,SeasBase应用深度学习的技术，集成多种视频识别算法,通过使用定时器触发MapReduce分布式创建视频索引,SeasCam实时视频分析框架，从队列中读取海量视频数据并分布式分析,最通过ETL分析并通过图表展现报警。</p>
			<p>下图为OpenVMC 视频大数据解决方案，具备批量、实时双重能力： </p>
			<img src="<%=basePath%>/front/website/img/solution-video3.gif" />
			<p class="imgTxt">OpenVMC 视频大数据解决方案</p>
			<p> 对于视频数据从离线和实时两个方向进行分析，SeasBase、SeasCam。</p>
			<p>所以OpenVMC中视频大数据分析最核心的技术，基于人脸识别技术Tensorflow图像分析技术，显著的提升了机器视觉识别的准确性，并使其接近人类的视觉识别水平。</p>
		</div>
	</div>
</section>
<section class="block grey-bg">
	<div class="container clearfix">
		<h2 class="titleLeft">成功案例</h2>
		<div class="col-2 fl">
			<div class="img"><img src="<%=basePath%>/front/website/img/case-haikou.jpg" /></div>
			<div class="txt">
				<h3>巧用TensorFlow，实现海量视频快速精准分析。</h3>
				<p>传统的安防设备由于架构的局限，已经不能够满足当今互联网化的需求，需要采用先进的互联网技术进行深度视频分析。</p>
			</div>
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
