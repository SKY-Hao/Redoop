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

<section class="grey-bg" id="breadMenu" style="margin-top: 75px;">
	<div class="container"><a href="<%=basePath%>">首页</a> &gt; 成功案例</div>
</section>
<section class="block" id="newsPage">
	<div class="container clearfix">
		<h2 class="titleLeft">中国航天案例</h2>
		<div class="headSource">
			<span class="date-published">2017/2/17 0:00:00</span>
			<span class="author">作者：admin</span>
			<span class="source">来源： <a>admin </a></span>
		</div>
		<div class="newsInfo">
			<h2>一、客户简介</h2>
			<p>XXX公司是国家授权投资的机构，由中央直接管理的国有特大型高科技企业。XXX公司承担着我国全部的运载火箭、应用卫星、载人飞船、空间站、深空探测飞行器等宇航产品及全部战略导弹和部分战术导弹等武器系统的研制、生产和发射试验任务，是我国影像信息记录产业中规模最大、技术最强的产品提供商。作为我国航天科技工业的主导力量，集团公司是国家首批创新型企业，创造了以载人航天和月球探测两大里程碑为标志的一系列辉煌成就，在推进国防现代化建设和国民经济发展中作出了重要贡献。</p>
			<p>“XX专项行动”是XXX公司的一个非常庞大的遥感技术项目，包含至少7颗卫星和其他观测平台。这些卫星在发射、运行过程中会产生大量的数据，如何存储数据以及快速计算分析这些数据实时检测卫星状况是XXX集团亟需解决的问题。</p>
			<h2>二、项目挑战</h2>
			<p><strong>（1）数据增量大：</strong>卫星专项行动（民用部分）地面系统第一批研制项目数据处理系统需要三套存储系统，分别是数据处理分系统中的录入数据存储系统、产品生产数据存储系统和分发服务分统中的用户服务存储系统。三套系统总容量需要达到500TB，数据日增量大于1	TB。</p>
			<p><strong>（2）网络性能太弱：</strong>为了满足卫星专项行动卫星数据快速录入及后续的快速处理与生产，整套存储及计算网络需要达到高带宽要求，而普通的千兆网络无法满足需求，故整套存储网络及计算网络都需采用万兆或更高带宽交换网络，保证整体系统。</p>
			<p><strong>（3）集群计算性能要求高：</strong>在第二批研制项目数据处理系统中尤其是在数据处理分系统中，为达到数据的并行处理，计算集群系统是必不可少的。产品生产集群系统需要达到1700核心计算能力。</p>
			<p><strong>（4）满足不同功能需求：</strong>业务管理、资源管理、流程管理、作业调度、计划编排、软件测试与验证、仿真模拟与故障分析、数据处理、数据库服务、存储管理、数据迁移、数据归档、试验测试、系统仿真、快视与录入监控、生产监控、集群管理、数据归档等需求。</p>
			<h2>三、解决方案</h2>
			<p>集群节点：104个节点<br />
				数据量：5PB级数据量<br />
				数据增量：1T/天<br />
				使用产品：CRH3.0<br />

			</p>
			<p class="imgTxtUp">下图为该项目架构图：</p>
			<img src="<%=basePath%>/front/website/img/case-space1.gif" />
			<p>（1）平台利用多台FTP server多个FUSE，可有效提高传输速率，且平台的后期扩展性高。</p>
			<p>（2）采用分布式存储，其特性为：</p>
			<p>	高吞吐量访问<br />CRH的HDFS通过分布式计算的算法，将数据访问均摊到服务器阵列中的每个服务器的多个数据拷贝上，单个硬盘或服务器的吞吐量限制都可以数倍甚至数百倍的突破，提供了极高的数据吞吐量。
			</p>
			<p>	无缝容量扩充<br />CRH的HDFS可以做到在不停止服务的情况下实时地加入新的服务器作为分布式文件系统的容量升级，不需要人工干预文件的重分布。 </p>
			<p>	高度容错<br />CRH的HDFS文件系统假设系统故障（服务器、网络、存储故障等）是常态，而不是异常。</p>
			<p>	NameNode HA<br />CRH的对HDFS组件的元数据服务器进行了高可用的设计，两个元数服务节点，当主节点失效后，由从节点接替工作，保证集群可以正常使用。</p>
			<p>（3）CRH的的分布式计算框架MapReduce设计特性：</p>
			<p>	复杂的数据<br />CRH的MapReduce可以存放和分析各种原始数据格式。</p>
			<p>	超大规模数据<br />CRH的MapReduce创新构架使用低成本的常规服务器储存和处理海量数据。 </p>
			<p>	新的分析手段<br />我们的CRH采用新架构能支持Spark、Storm等处理方式，能方便高效地处理和分析海量数据。</p>
			<h2>四、客户收益</h2>
			<p><strong>1.高性能：</strong>分布式架构在进行数据处理时，一个巨大的数据处理任务将被分成许多小的任务，交由多台设备来协同完成，极大地提高了数据处理的能力，满足了大数据时代对海量数据处理的需求。</p>
			<p><strong>2.高扩展性：</strong>采用分布式架构，随着业务的扩展，当数据的存储与计算能力不足时，只需在集群中添加节点，就可以实现性能的线性提升，可以弥补传统集中式架构在扩展能力上的不足。</p>
			<p><strong>3.高I/O读写：</strong>完全满足高I/O读写的要求，实现业务平滑迁移到大数据架构中</p>
			<p><strong>4.高性价比：</strong>分布式架构在硬件平台的选择上一般采用高性价比的X86服务器集群，相比于传统的集中式架构中昂贵的高性能服务器和高端存储，具有较高的性价比。极大的帮助客户节约了成本。</p>
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
