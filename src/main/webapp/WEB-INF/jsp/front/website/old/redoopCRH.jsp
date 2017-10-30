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
    <link href="<%=basePath%>/front/website/css/crh.css" type="text/css" rel="stylesheet" />

</head>

<body>

<jsp:include page="tools/header.jsp"></jsp:include>


<div class="crhheader">
    <div class="headerBg">
        <div class="container">

            <h2><img src="<%=basePath%>/front/website/css/img/crhImages/txt.png" /></h2>
            <p>CRH大数据平台支持5颗芯片，主流的硬件和操作系统。致力于成为世界最顶级的大数据供应商，OpenPower平台是唯一指定的大数据软件供应商，支持主流的X86平台，在国产化趋势下，研发支持了飞腾，龙芯，申威等国产芯片。源代码完全自主可控的大数据平台。支持国产主流的服务器操作系统，红旗，银河麒麟，中标麒麟等操作系统。所以红象云腾有大量来自全国的硬件、操作系
                统、大数据应用软件合作伙伴。</p>
        </div>
    </div>
</div>
<div class="verNav">
    <div class="container">
        <a href="#x64" class="on">X64</a>
        <a href="#OpenPower">OpenPower</a>
        <a href="#arm">ARM/飞腾</a>
        <span>申威<em>(敬请期待)</em></span>
        <span>龙芯<em>(敬请期待)</em></span>
    </div>
</div>
<div class="section clearfix">
    <h2>Redoop CRH for X64</h2><a id="x64" name="x64"></a>
    <p>2017 年 06 月 30 日最新发布</p>
    <dl>
        <dt>CRH5.0</dt>
        <dd>centos6/redhat6<span>V5.0</span></dd>
        <dd><a target="_blank" href="http://archive.redoop.com/crh/doc/rpm_5.0_x86_64_centos6.html" class="checkBtn">安装简介</a><a href="http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/">下载目录:http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
        <dd class="other">centos7/redhat7<span>V5.0</span></dd>
        <dd><a target="_blank" href="http://archive.redoop.com/crh/doc/rpm_5.0_x86_64_centos7.html" class="checkBtn">安装简介</a><a href="http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos7/">下载目录:http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos7/</a>    </dd>
        <!--      <dd class="other">centos6/redhat6<span>V4.92</span></dd>
              <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd> -->
    </dl>

    <dl>
        <dt>CRH4.9</dt>
        <dd>centos6/redhat6<span>V4.9</span></dd>
        <dd><a target="_blank"  href="http://archive.redoop.com/crh/doc/rpm_4.9_x86_64_redhat6.html" class="checkBtn">安装简介</a><a href="http://archive.redoop.com/crh/rpm/4.9.2.3/CRH/x86_64/redhat6">下载目录:http://archive.redoop.com/crh/rpm/4.9.2.3/CRH/x86_64/redhat6</a>    </dd>
    </dl>

    <div class="zhichi">
        <span>此版本支持的系统 :
            <img src="<%=basePath%>/front/website/css/img/crhImages/redhat.png" />
            <img src="<%=basePath%>/front/website/css/img/crhImages/redflag.png" />
        </span>
    </div>
    <div class="zhichi">
        <span>此版本支持的芯片 :
            <img src="<%=basePath%>/front/website/css/img/crhImages/intel.png" />
            <img src="<%=basePath%>/front/website/css/img/crhImages/zhaoxin.png" />
        </span>
    </div>
</div>
<div class="section clearfix"><a id="OpenPower" name="OpenPower"></a>
    <h2>Redoop CRH for OpenPower</h2>
    <p>2016 年 04 月 27 日最新发布</p>
    <dl>
        <dt>CRH4.9</dt>
        <dd>axs7<span>V4.9</span></dd>
        <dd><a target="_blank" href="http://archive.redoop.com/crh/doc/rpm_4.9_ppc64le_axas7.html" class="checkBtn">安装简介</a><a href="http://archive.redoop.com/crh/rpm/4.9.2.3/CRH/ppc64le/axs7/">下载目录:http://archive.redoop.com/crh/rpm/4.9.2.3/CRH/ppc64le/axs7/</a>    </dd>
    </dl>
    <!-- <dl>
         <dt>CRH5.0</dt>
         <dd>centos6/redhat6<span>V4.92</span></dd>
         <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
         <dd class="other">centos6/redhat6<span>V4.92</span></dd>
         <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
         <dd class="other">centos6/redhat6<span>V4.92</span></dd>
         <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
     </dl>-->
    <div class="zhichi">
        <span>此版本支持的系统 :
            <img src="<%=basePath%>/front/website/css/img/crhImages/redflag.png" />
        </span>
    </div>

    <div class="zhichi">
        <span>此版本支持的芯片 :
            <img src="<%=basePath%>/front/website/css/img/crhImages/ibm.png" />
        </span>
    </div>
</div>
<div class="section clearfix"><a id="arm" name="arm"></a>
    <h2>Redoop CRH for ARM/飞腾</h2>
    <p>2017 年 06 月 30 日最新发布</p>
    <!-- <dl>
         <dt>CRH4.9</dt>
         <dd>centos6/redhat6<span>V4.92</span></dd>
         <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
     </dl>-->
    <dl>
        <dt>CRH5.0</dt>
        <dd>kylin4<span>V5.0</span></dd>
        <dd><a target="_blank" href="http://archive.redoop.com/crh/doc/deb_5.0_aarch64_kylin4.html" class="checkBtn">安装简介</a><a href="http://archive.redoop.com/crh/deb/5.0.2.4/CRH/aarch64/kylin4/">下载目录:http://archive.redoop.com/crh/deb/5.0.2.4/CRH/aarch64/kylin4/</a>    </dd>
        <!--  <dd class="other">centos6/redhat6<span>V4.92</span></dd>
          <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
          <dd class="other">centos6/redhat6<span>V4.92</span></dd>
          <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd> -->
    </dl>
    <div class="zhichi">
        <span>此版本支持的系统 :
            <img src="<%=basePath%>/front/website/css/img/crhImages/kylin.png" />
        </span>
    </div>
    <div class="zhichi">
        <span>此版本支持的芯片 :
            <img src="<%=basePath%>/front/website/css/img/crhImages/arm.png" />
            <img src="<%=basePath%>/front/website/css/img/crhImages/feiteng.png" />
        </span>
    </div>

</div>

<!--- 神威 start-->

<div class="section clearfix">
    <h2>Redoop CRH for SW/申威</h2>
    <p>2017 年 06 月 30 日最新发布</p>
    <!-- <dl>
         <dt>CRH4.9</dt>
         <dd>centos6/redhat6<span>V4.92</span></dd>
         <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
     </dl>-->
    <dl>
        <dt>CRH5.0</dt>
        <dd>Rasie2<span>V5.0</span></dd>
        <dd><a target="_blank" href="#" class="checkBtn">安装简介</a><a href="http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/sw_64/Raise2/">下载目录:http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/sw_64/Raise2/</a>    </dd>
        <!--  <dd class="other">centos6/redhat6<span>V4.92</span></dd>
          <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
          <dd class="other">centos6/redhat6<span>V4.92</span></dd>
          <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd> -->
    </dl>
    <div class="zhichi">
        <span>此版本支持的系统 :<img src="<%=basePath%>/front/website/css/img/crhImages/raise.png" /></span>
    </div>

    <a id="longxin" name="longxin"></a>
    <div class="zhichi">
        <span>此版本支持的芯片 :<img src="<%=basePath%>/front/website/css/img/crhImages/shenwei.png" /></span>
    </div>

</div>

<!-- 神威 end -->


<!--- 龙芯 start-->

<div class="section clearfix">
    <h2>Redoop CRH for Mips64/龙芯</h2>
    <p>2017 年 06 月 30 日最新发布</p>
    <!-- <dl>
         <dt>CRH4.9</dt>
         <dd>centos6/redhat6<span>V4.92</span></dd>
         <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
     </dl>-->
    <dl>
        <dt>CRH5.0</dt>
        <dd>neokylin5<span>V5.0</span></dd>
        <dd><a target="_blank" href="#" class="checkBtn">安装简介</a><a href="http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/mips64el/neokylin5/">下载目录:http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/mips64el/neokylin5/</a>    </dd>
        <!--  <dd class="other">centos6/redhat6<span>V4.92</span></dd>
          <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
          <dd class="other">centos6/redhat6<span>V4.92</span></dd>
          <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd> -->
    </dl>
    <div class="zhichi">
        <span>此版本支持的系统 :<img src="<%=basePath%>/front/website/css/img/crhImages/zb.png" /></span>
    </div>
    <div class="zhichi">
        <span>此版本支持的芯片 :<img src="<%=basePath%>/front/website/css/img/crhImages/lx.png" /></span>
    </div>

</div>


<!-- 龙芯 end -->








<jsp:include page="tools/footer.jsp"></jsp:include>



</body>
</html>
