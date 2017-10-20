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
		<h2 class="titleLeft">助力辽宁智慧交通，构建高效智能城市</h2>
		<div class="headSource">
			<span class="date-published">2017/2/17 0:00:00</span>
			<span class="author">作者：admin</span>
			<span class="source">来源： <a>admin </a></span>
		</div>
		<div class="newsInfo">
			<h2>一、项目背景</h2>
			<p>随着经济的发展和城市化进程的推进，城市的人口迅猛增长，但是城市的建设并不能满足人口的增长，表现最明显的就是城市交通问题。交通是经济发展的命脉，因此，智能交通如何缓解道路压力、降低事故率、提升公共交通服务和节能减碳等问题被提上日程。</p>
			<p>随着政府各个部门 业务的不断增长，各种有价值的数据，没有得到很好的整合、分析与挖掘，没有发挥它应有的价值；传统的数据存储方法已经无法完全存储这么大的需要保存的有价值的历史数据，导致很多有价值的数据无法分析。随着互联网大数据的快速发展，智慧交通的概念逐渐出现在人们的生活。智慧城市是运用大数据技术，通过整合各系统数据以科学的分析手法，推进智慧交通的发展，使得交通更加智能化，做到对交通状况的快速响应与准确预测。而随着智能交通产业的发展以及交通流量的日益增长，如何能全面、准确、及时地监控和分析卡口道路交通状况，缓解交通压力，降低事故率以及快速分析卡口车辆通过信息采集和打击犯罪，是当前交通厅系统急于解决的问题。</p>
			<h2>二、项目挑战</h2>
			<p><strong>1、历史数据迁移，保证数据安全和完整性。</strong>对包括省厅、运输管理局、港航管理局、高速公路管理局、高建局等在内的下属的23个子系统的历史数据的迁移，如何在不影响现有业务的基础上把数据从传统的B/S架构系统迁移到基于虚拟化构建的云计算数据中心。同时要保证数据的安全性和完整性。</p>
			<p><strong>2、快速精准定位敏感区。</strong>GPS模块中，对车辆敏感区判定如何确定敏感区的范围，用什么算法能够比较精确的确定敏感区范围。</p>
			<p><strong>3、精准判断连续驾驶。</strong>GPS模块中，对车辆连续驾驶的判定中，人脸识别采用什么算法，如何提高人脸识别的精准度，采用什么技术快速分析判定疲劳驾驶并警告驾驶员。</p>
			<p><strong>4、精准检索轨迹相似。</strong>GPS模块中，车辆轨迹相似度判断中，用什么算法和模型训练能满足实际车辆轨迹在时间和空间上的相似性，如何保证数据分析计算在性能上可以满足前台业务的检索。</p>
			<h2>三、解决方案</h2>
			<p class="imgTxtUp">针对本项目的需求分析，红象云腾定制化的项目系统结构图如下：</p>
			<img src="<%=basePath%>/front/website/img/case-traffic1.gif" />
			<p class="imgTxtUp">项目的总体架构图如下：</p>
			<img src="<%=basePath%>/front/website/img/case-traffic2.gif" />
			<p class="imgTxt">智慧交通大数据平台架构图</p>
			<p>借鉴互联网架构，引入流式处理和离线分析开源框架，基于x86平台构建分布式计算与存储平台，在保障系统可靠性（High-Availability）和可水平扩展(Scale-Out)基础上，同时大幅降低系统总拥有成本（TCO）。</p>
			<h2>四、客户收益</h2>
			<p> 1、对23个子系统的数据迁移，迁移到大数据平台上，以便后期能够更好地统计分析使用。</p>
			<p>2、GPS模块中，放弃现在大多数分析中采用的圆形算法，采用多边形算法，能够更加精确地找出敏感区的范围。效果图如下：</p>
			<img src="<%=basePath%>/front/website/img/case-traffic3.gif" />
			<p>3、GPS模块中，能够实时检测车辆速度，最终在大屏展示，对超速车辆会标红显示，效果如下：</p>
			<img src="<%=basePath%>/front/website/img/case-traffic4.gif" />
			<p>4、GPS模块中，采用人脸识别和大数据相关技术，对同一驾驶员连续驾驶时长进行检测，对于疲劳驾驶的车辆也会标红显示，如下：</p>
			<img src="<%=basePath%>/front/website/img/case-traffic5.gif" />
			<p>5、 GPS模块中，支持手动在页面画行车轨迹，后台就会通过我们构建的数学模型和算法进行快速分析计算，最终把轨迹相似的车牌和相似程度显示在大屏，如下：</p>
			<img src="<%=basePath%>/front/website/img/case-traffic6.gif" />
			<img src="<%=basePath%>/front/website/img/case-traffic7.gif" />
			<p>6、桥梁检测中，通过Hive和Spark对桥梁的数据进行离线和在线的分析，对不同传感器数据做归一处理后，运用一些相关性算法和聚类算法，获取桥梁一些因素的相关关系和聚类情况，最终检测桥梁的健康状况，如下：</p>
			<img src="<%=basePath%>/front/website/img/case-traffic8.gif" />
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
