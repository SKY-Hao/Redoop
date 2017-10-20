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
    <link href="<%=basePath%>/front/website/css/ai.css" type="text/css" rel="stylesheet" />

</head>

<body>

<jsp:include page="tools/header.jsp"></jsp:include>

<div class="aiHeader">
    <div class="headerBg">
        <div class="container">

            <h2><img src="<%=basePath%>/front/website/css/img/aiImages/txt.png" /></h2>
            <p>Redoop AI 深度学习平台支持TensorFlow、Caffe、Chainer等目前流行的深度学习框架及主流的硬件和操作系统。能嵌入到 Redoop CRH大数据平台，实现自动化安装部署。目前已支持主流的x86平台，国产的红旗服务器操作系统带GPU的OpenPower平台。
            </p>
        </div>
    </div>
</div><a id="x64" name="x64"></a>
<div class="verNav">
    <div class="container">
        <a href="#x64" class="on">X64</a>
        <a href="#OpenPower">OpenPower</a>
    </div>
</div>
<div class="section clearfix">
    <h2>Redoop AI for X64</h2>
    <p>2017 年 08 月 16 日最新发布</p>
    <dl>
        <dt>TensorFlow</dt>
        <dd>centos7/redhat7<span>V1.1.0</span></dd>
        <dd>
            下载目录：
            <a href="http://archive.redoop.com/redoopAI/readme/tensorflow_1.1.0_x86_64_centos7.html" class="checkBtn" target="_blank" >
                安装简介
            </a>
            <a href="http://archive.redoop.com/redoopAI/rpm/tensorflow/1.1.0/x86_64/centos7/">
                http://archive.redoop.com/redoopAI/rpm/tensorflow/1.1.0/x86_64/centos7/
            </a>
        </dd>
    </dl>
    <!--<dl>
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
            <img src="<%=basePath%>/front/website/css/img/aiImages/redhat.png" >
            <!--<img src="images/redflag.png" />-->
        </span>
    </div>
    <div class="zhichi">
    	<span>此版本支持的芯片 :
            <img src="<%=basePath%>/front/website/css/img/aiImages/intel.png" />
            <!--<img src="images/zhaoxin.png" />-->
        </span>
    </div>
</div>
<div class="section clearfix"><a id="OpenPower" name="OpenPower"></a>
    <h2>Redoop AI for OpenPower</h2>
    <p>2017 年 08 月 16 日最新发布</p>
    <dl>
        <dt>TensorFlow</dt>
        <dd>axs7<span>V1.1.0</span></dd>
        <dd>
            下载目录：
            <a href="http://archive.redoop.com/redoopAI/readme/tensorflow_1.1.0_ppc64le_axs7.html" class="checkBtn" target="_blank" >
                安装简介
            </a>
            <a href="http://archive.redoop.com/redoopAI/rpm/tensorflow/1.1.0/ppc64le/axs7/">
                http://archive.redoop.com/redoopAI/rpm/tensorflow/1.1.0/ppc64le/axs7/
            </a>
        </dd>
    </dl>
    <!-- <dl>
         <dt>CRH5.0</dt>
         <dd>centos6/redhat6<span>V4.92</span></dd>
         <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
         <dd class="other">centos6/redhat6<span>V4.92</span></dd>
         <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
         <dd class="other">centos6/redhat6<span>V4.92</span></dd>
         <dd><a href="#" class="checkBtn">查看</a><a href="#">http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/</a>    </dd>
     </dl>
     -->
    <div class="zhichi">
        <span>此版本支持的系统 :
            <img src="<%=basePath%>/front/website/css/img/aiImages/redflag.png" />
        </span>
    </div>
    <div class="zhichi">
        <span>此版本支持的芯片 :
            <img src="<%=basePath%>/front/website/css/img/aiImages/ibm.png" />
        </span>
    </div>
</div>








<jsp:include page="tools/footer.jsp"></jsp:include>



</body>
</html>

