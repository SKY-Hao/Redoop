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

<div class="bannerCon">
    <div class="container">
        <div class="bannerImg"></div>
        <p> 红象云腾是航天大数据基础软件提供商,已经服务十颗卫星。</p>
    </div>
</div>


<section id="news">
    <div class="container">
        <a href="<%=basePath%>/front/weekly" id="twoWeekA" target="_blank">
            红象周报→
        </a>
        <i></i>
        <p>
            <c:forEach items="${briefingList}" var="briefing">


                <%--<a href="<%=basePath%>/front/weekly"  target="_blank">${briefing.tabletitle}</a>--%>
                <a href="${briefing.jumpurl}"  target="_blank">${briefing.tabletitle} </a>

            </c:forEach>
        </p>

    </div>
</section>



<section class="block" id="function">
    <div class="container clearfix">

        <div class="productCon">
            <img src="<%=basePath%>/front/website/css/img/product-2.jpg" />
            <h2> 物联网大数据接入平台</h2>
            <p>红象云腾面向物联网推出，企业级流式数据处理平台，提供一整套可视化的数据接入方案。让数据在流动中被处理和消费，更快，更准确;超低的门槛让提供灵活的数据探索，产生商业价值。</p>
            <%--<a href="http://www.redoop.net/group/detail/5" class="btn"  target="_blank">阅读更多主题</a>--%>
        </div>
        <div class="productCon">
            <img src="<%=basePath%>/front/website/css/img/product-1.jpg" />
            <h2>大数据存储和计算平台</h2>
            <p>
                红象大数据发行版CRH为企业大数据实施提供一套完整的一站式大数据解决方案，产品覆盖了企业数据仓库、
                商业智能、机器学习、数据可视化等领域，助力企业在DT时代更敏捷、更智能、更具洞察力。
            </p>
            <%--<a href="http://www.redoop.net/group/detail/2" class="btn"  target="_blank">阅读更多主题</a>--%>
        </div>
        <div class="productCon">
            <img src="<%=basePath%>/front/website/css/img/product-3.jpg" />
            <h2>数据挖掘和AI智能分析平台</h2>
            <p>CRS支持NVIDIA，基于Hadoop Yarn完成了对TensorFlow、Caffe等常用框架的集成，同时具备良好的扩展性和兼容性，并能提供数据可视化，数据挖掘工具。</p>
            <%--<a href="http://www.redoop.net/group/detail/4" class="btn"  target="_blank">阅读更多主题</a>--%>
        </div>
    </div>
</section>







<section class="block grey-bg" id="function">
    <div class="container clearfix">
        <h2 class="title">企业历程</h2>
        <div class="clearfix "  style="text-align:center;" align="middle">
            <embed src="https://imgcache.qq.com/tencentvideo_v1/playerv3/TPout.swf?max_age=86400&v=20161117&vid=t0610cphkcp&auto=0" allowFullScreen="true" quality="high" width="480" height="400" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed>
        </div>
    </div>
</section>

<section class="block" id="function" style="margin-top: 20px;">
    <div class="container clearfix">
        <h2 class="title">成功案例</h2>
        <div class="clearfix ">
            <div class="caseIMG"><img src="<%=basePath%>/front/website/css/img/case-1.jpg" /></div>
            <div class="caseTXT">
                <h2>全球承接卫星数量最多的集群</h2>
                <p>支持国家级关键项目、存储量PB级别大数据平台稳定高效运行</p>
                <p>处理高分、高景、资源、张衡等遥感星座“十颗星”,未来60颗陆地观测卫星</p>
                <p>在全球范围内航天领域大数据底层技术行业第一</p>
                <h2 style="margin-top:20px;">全球容量最大的卫星遥感集群</h2>
                <p>日新增数据大于1TB ,满足：接入、存储、处理、归档 等 </p>
                <p>产品生产集群系统需达到几千核心计算能力，上百PB的存储容量 </p>
                <p>平台具有高性能、高扩展性、高I/O读写、高性价比的特点 </p>
                <!-- <a href="#" class="btn"  target="_blank">阅读详情</a> -->
            </div>
        </div>

    </div>
</section>


<section class="block appraise">
    <div class="container clearfix">
        <div class="a" style="display:block;">
            <div class="clientLogo"><img src="<%=basePath%>/front/website/css/img/ht-Logo.png" width="383" height="60"></div>
            <h4>“红象云腾为航天大数据保驾护航”</h4>
        </div>

    </div>
</section>










<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
