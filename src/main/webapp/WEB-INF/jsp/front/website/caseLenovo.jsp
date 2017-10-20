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
		<h2 class="titleLeft">联想电商大数据平台</h2>
		<div class="headSource">
			<span class="date-published">2017/2/17 0:00:00</span>
			<span class="author">作者：admin</span>
			<span class="source">来源： <a>admin </a></span>
		</div>
		<div class="newsInfo">
			<h2>一、客户简介</h2>
			<p>联想是目前世界上最大的PC电脑生产商，成立于1984年，总部位于中国北京和美国罗利。联想为个人和商用客户提供优质产品和专业服务，集团拥有近2万名员工，业务遍布世界主要国家。</p>
			<p>联想官方网上商城是联想集团设立的官方网上购物商城，提供电子商品的展示、热卖产品、产品报价、产品促销等信息。联想商城有大量的用户及数据，如何从这些数据中挖掘到适合于业务需求的数据，是一个巨大的挑战，是否可以通过用户画像分析数据可以帮助决策者在正确的时间正确的地点对正确的人做正确的营销活动。</p>
			<h2>二、项目挑战</h2>
			<p><strong>1、社区、商城海量数据难以存储，数据中什么情况都可能存在。</strong>如果说有10条数据，那么大不了每条去逐一检查，人为处理，如果有上百条数据，也可以考虑，如果数据上到千万级别，甚至过亿，那不是手工能解决的了，必须通过工具或者程序进行处理，尤其海量的数据中，什么情况都可能存在，例如，数据中某处格式出了问题，尤其在程序处理时，前面还能正常处理，突到了某个地方问题出现了，程序终止了。并且以前数据都是采用集中式存储，如何将这些集中式存储的数据迁移到大数据平台并且不能影响线上业务。</p>
			<p><strong>（2）历史数据不完整。</strong>由于之前的数据存储采用的是传统的集中式关系型数据库进行的存储，对历史数据中的结构化数据都能够比较好的保存下来，而对于非结构化和半结构化数据，由于没有很好的存储策略，加之数据存储资源的有限，导致很多历史数据的丢失。</p>
			<p><strong>（3）软硬件要求高，系统资源占用率高。</strong>对海量的数据进行处理，除了好的方法，最重要的就是合理使用工具，合理分配系统资源。一般情况，如果处理的数据过TB级，小型机是要考虑的，普通的机子如果有好的方法可以考虑，不过也必须加大CPU和内存，就象面对着千军万马，光有勇气没有一兵一卒是很难取胜的。</p>
			<h2>三、解决方案</h2>
			<p class="imgTxtUp">总体方案:</p>
			<img src="<%=basePath%>/front/website/img/case-lenovo1.gif" />
			<p>1）分布式大数据存储方案。</p>
			<p class="imgTxtUp">分布式系统</p>
			<img src="<%=basePath%>/front/website/img/case-lenovo2.gif" />
			<p>2）数据多备份存储保证数据完整性。</p>
			<p class="imgTxtUp">多份备份</p>
			<img src="<%=basePath%>/front/website/img/case-lenovo3.gif" />
			<p>3）大数据集群并行计算设计，提升集群计算性能。</p>
			<img src="<%=basePath%>/front/website/img/case-lenovo4.gif" />
			<p>大数据分析和处理需要海量的存储资源和计算资源。XX云大数据平台提供了“无限”的存储和计算能力，并且可以一键部署。红象云腾提供的XX云大数据平台可以把大数据及分析结果存储在XX云中（云存储）。在需要大数据分析的时启动Redoop的CRH集群，分析完毕后可以可视化对外数据共享，数据存储在云中，也可以存储到主流的关系型数据库/NOSQL中。</p>
			<h2>四、分钟级实时统计</h2>
			<img src="<%=basePath%>/front/website/img/case-lenovo5.gif" />
			<h2>五、客户收益</h2>
			<p> <strong>1、用户精准营销推送。</strong>针对联想电商平台进行用户画像，用户流量分析等，对用户最终消费行为分析，最终达到用户精准营销的推送。</p>
			<p><strong>2. 大数据云架构平台构建。</strong>整个项目的架构基于大数据云架构设计，能够支持动态扩容，数据容错等功能。为以后的数据存储和分析提供了基础平台。</p>
			<p><strong>3.帮助管理层决策。</strong>通过对电商平台用户的行为画像分析，能够精准实时分析用户的购买行为，帮助管理层决策营销方案。</p>
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
