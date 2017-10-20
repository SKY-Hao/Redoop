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
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=cyQX6YgIG78BSDRPQifnCM9WVrc8hVG3"></script>

</head>


<body>

<jsp:include page="tools/header.jsp"></jsp:include>

<section class="solutionAboutUS"  style="margin-top: 74px;"></section>
<section class="grey-bg" id="breadMenu" style="margin-top: auto;">
	<div class="container"><a href="<%=basePath%>">首页</a> &gt; 关于我们</div>
</section>
<section class="block" id="solution">
	<div class="container clearfix">
		<h2 class="titleLeft">关于我们</h2>
		<div class="titleLine"></div>
		<div class="row">
			<div class="fr solutionImg"><img src="<%=basePath%>/front/website/img/aboutUS.jpg" /></div>
			<div class=" solutionTxt">
				<p style="text-indent:2em;">红象云腾是中国大数据基础软件厂商，为企业和政府提供基于Apache Hadoop生态架构的分布式存储和分布式计算的私有云解决方案，创建伊始，红象云腾就致力于以Apache Hadoop架构在中国的普及和推广工作，专注于打造中国自主可控的大数据基础存储和处理软件平台，红象云腾已经和国内和国际多家芯片，操作系统，服务器厂商建立广泛的合作关系，让Apache Hadoop生态软件可以顺利运行在国产IT生态平台之上，支持国家国产安全可控，军民融合，天基丝路等战略。</p>
                <p style="text-indent:2em;">通过不断努力，红象云腾核心产品 “Redoop Enterprise ”平台从2013年发布的1.0已经迭代到5.0版本，成为国内唯一支持五种芯片架构的大数据平台，并在平台性能和稳定性提供完整解决方案。</p>
                <p style="text-indent:2em;">红象云腾以专注产品,全面合作为宗旨，为客户提供“安全稳定，坚若磐石”的企业大数据平台。</p>
                <p style="text-indent:2em;">2014年红象云腾完成极客帮基金领投的第一轮投资，2015年在航天行业完成大规模集群部署，2016年开始全面支持国产芯片和操作系统，并发布支持国内第一款OpenPower版本Hadoop发行版，2017年发布支持飞腾芯片的银河麒麟超算的的大数据平台，从2015-2016年开始，红象云腾的销售业绩完成五倍的增长，并入驻中关村软件园。</p>
                <p style="text-indent:2em;">在市场方面红象云腾产品已经部署到从石油、铁路、航天、桥梁、交通、公安、电信，制造等国家基础设施关键行业，并和中国人民解放军国防科技大学，中国人民解放军国防大学等国防院校以及太原中北大学，洛阳理工大学等地方院校建立产品和技术合作。</p>
                <p style="text-indent:2em;">红象云腾的管理团队来自国内知名互联网和IT公司，是中国Apache Hadoop技术社区的早期创建者，推广者和爱好者，秉承从“开源中来，到开源中去”的思想，积极参与国际技术社区的建设。红象云腾已经加入OpenPower、Linux Foundation ODPI 国际组织，为中国大数据参与国际开源软件贡献力量，并加入中国全球卫星应用联盟和遥感应用协会，为中国航天事业贡献力量。</p>

			</div>
			<div style="text-align:center;"><img src="<%=basePath%>/front/website/img/aboutIdea.jpg" style="margin-left:auto; margin-right:auto;" /></div>
		</div>
	</div>
</section>
<section class="block  grey-bg" id="honour" style="margin-top: auto;">
	<div class="container clearfix">
		<h2 class="titleLeft">公司荣誉</h2>
		<div class="clearfix">
			<div class="row">
				<div class="col-4">
					<img src="<%=basePath%>/front/website/img/honour1.jpg" class="center-block" />
					<p>大数据产业峰会颁发的创新企业证书</p>
				</div>
				<div class="col-4">
					<img src="<%=basePath%>/front/website/img/honour2.jpg" class="center-block" />
					<p>大数据商业模式赛中荣获优秀项目奖</p>
				</div>
				<div class="col-4">
					<img src="<%=basePath%>/front/website/img/honour3.jpg" class="center-block" />
					<p>公司领导荣获特邀专家称号</p>
				</div>
				<div class="col-4">
					<img src="<%=basePath%>/front/website/img/honour4.jpg" class="center-block" />
					<p>中关村高新技术企业</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<img src="<%=basePath%>/front/website/img/honour5.jpg" class="center-block" />
					<p>北京市高新技术企业</p>
				</div>
				<div class="col-4">
					<img src="<%=basePath%>/front/website/img/honour6.jpg" class="center-block" />
					<p>北京市新技术新产品证书</p>
				</div>
				<div class="col-4">
					<img src="<%=basePath%>/front/website/img/honour7.jpg" class="center-block" />
					<p>2016基础软件厂商贡献奖</p>
				</div>
			</div>
		</div>
	</div>
</section>
<section class="block">
	<div class="container clearfix">
		<h2 class="titleLeft"><a id="contact"></a>联系我们</h2>
		<div class="fl addImg" id="map"></div>
		<div class="addTxt fl"><p>Tel: 15811320188 / 400-0389-155 / 010-56730960<br />
			Email：bd@redoop.com<br />
			北京海淀区中关村软件园二期互联网创新中心506</p></div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

<script>
	var map = new BMap.Map("map");
	var point = new BMap.Point(116.2868310000, 40.0542860000);
	map.centerAndZoom(point, 18);
	map.enableScrollWheelZoom(); 					// 开启鼠标滚轮缩放
	map.enableKeyboard(); 							// 开启键盘控制
	map.enableContinuousZoom(); 					// 开启连续缩放效果
	map.enableInertialDragging(); 					// 开启惯性拖拽效果
	map.addControl(new BMap.NavigationControl()); 	//添加标准地图控件(左上角的放大缩小左右拖拽控件)
	map.addControl(new BMap.ScaleControl()); 		//添加比例尺控件(左下角显示的比例尺控件)
	map.addControl(new BMap.OverviewMapControl()); // 缩略图控件
	var marker = new BMap.Marker(point);// 创建标注
	map.addOverlay(marker);
</script>
</body>
</html>
