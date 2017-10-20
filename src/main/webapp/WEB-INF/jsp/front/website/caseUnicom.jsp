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
		<h2 class="titleLeft">打造云端大数据平台，实现大数据平台一键上云</h2>
		<div class="headSource">
			<span class="date-published">2017/2/17 0:00:00</span>
			<span class="author">作者：admin</span>
			<span class="source">来源： <a>admin </a></span>
		</div>
		<div class="newsInfo">
			<h2>一、客户简介</h2>
			<p>中国联通集团有限公司在国内31个省（自治区、直辖市）和境外多个国家和地区设有分支机构，是中国唯一一家在纽约、香港、上海三地同时上市的电信运营企业，连续多年入选“世界500强企业”。中国联通主要经营移动网络业务，固定通信业务，国内、国际通信设施服务业务，卫星国际专线业务、数据通信业务、网络接入业务和各类电信增值业务，与通信信息业务相关的系统集成业务等。</p>
			<p>随着互联网大数据时代的到来，面临数据量的激增而资源的有限的困境，更多的企业把视线投向了云计算。在这种背景下，中国联通集团也把目光投向了云计算，研发基于云计算的公有云平台。</p>
			<h2>二、项目挑战</h2>
			<p><strong>（1）实现一键创建集群：</strong>为了使复杂的集群搭建的操作变得简单易操作，使大数据变得更加平民化，企业能够把更多的资源投入到业务相关的开发上，XX云提出了一键部署集群的方案。</p>
			<p><strong>（2）实现集群资源的动态调整：</strong>由于各个企业或个人的数据量不可能是一成不变的，对于增量的数据，集群仍能够通过动态调整资源满足不同存储需求，并且不影响线上业务。</p>
			<p><strong>（3）实现集群的资源监控：</strong>能够及时监控集群硬件故障，并报警提示，保障系统的正常运行；能够对集群关键资源（CPU、内存等）使用情况进行监测，及时发现性能瓶颈，并进行智能性能调控，保证集群在高性能下持续运转。</p>
			<h2>三、解决方案</h2>
			<img src="<%=basePath%>/front/website/img/case-unicom.gif" /><p class="imgTxt">该项目架构图</p>
			<p>大数据分析和处理需要海量的存储资源和计算资源。XX云大数据平台提供了“无限”的存储和计算能力，并且可以一键部署。红象云腾提供的XX云大数据平台可以把大数据及分析结果存储在XX云中（云存储）。在需要大数据分析的时启动Redoop的CRH集群，分析完毕后可以可视化对外数据共享，数据存储在云中，也可以存储到主流的关系型数据库/NOSQL中。</p>
			<h2>四、客户收益</h2>
			<p> <strong>1.	强大的智能分析：</strong>云端创建集群基于Redoop的CRH，上层集成多种可视化智能分析组件，包括Zeppelin/Apache Kylin/Powe BI等多种商业智能分析工具，提供360度客户视图。</p>
			<p><strong>2. 一键式部署安装集群：</strong>在没有平台、没有数据、没有代码、没有场景的环境下，用户可以一键部署大数据平台 ，让每个用户拥有属于自己的大数据生产环境。</p>
			<p><strong>3.	集群资源动态调整：</strong>集群支持弹性扩展，无限扩容，计算能力无限扩展，扩展成本低，时效高。</p>
			<p><strong>4.	低成本：</strong>基于完全开放的X86硬件服务器，基于完全开源技术的操作系统和虚拟化技术。将成本降到最低，性能提升极致。</p>
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
