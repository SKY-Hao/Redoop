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

<!--平台类型-->
<div class="verNav">
    <div class="container">
        <a href="<%=basePath%>/front/redoopCRH?platformtype=0"  <c:if test="${platformtype==0}"> class="on"</c:if>>X64</a>
        <a href="<%=basePath%>/front/redoopCRH?platformtype=1"  <c:if test="${platformtype==1}"> class="on"</c:if>>OpenPower</a>
        <a href="<%=basePath%>/front/redoopCRH?platformtype=2"  <c:if test="${platformtype==2}"> class="on"</c:if>>ARM/飞腾</a>
        <a href="<%=basePath%>/front/redoopCRH?platformtype=3"  <c:if test="${platformtype==3}"> class="on"</c:if>>申威</a>
        <a href="<%=basePath%>/front/redoopCRH?platformtype=4"  <c:if test="${platformtype==4}"> class="on"</c:if>>龙芯</a>
    </div>
</div>

<section class="block">
    <div class="container clearfix" style="padding-bottom: 30px;width: 976px;">
        <!--平台类型-->
        <h2 class="downloadH2" style="margin:auto;">
            Redoop CRH for
            <c:if test="${platformtype==0}">X64</c:if>
            <c:if test="${platformtype==1}">OpenPower</c:if>
            <c:if test="${platformtype==2}">ARM/飞腾</c:if>
            <c:if test="${platformtype==3}">申威</c:if>
            <c:if test="${platformtype==4}">龙芯</c:if>
        </h2>
        <c:if test="${empty list}">
            <div style="margin-left: 15px; margin-top: 15px;">
                <h3 style="color: brown;"> 版本更新中...</h3>
                <h3 style="color: brown;"> 请您耐心等待发布，谢谢...</h3>
            </div>
        </c:if>
        <c:if test="${not empty list}">
            <c:forEach  items="${list}" var="one">
            <ul class="downList-crh" style="margin-top: 20px;">
               <li>
                    <span class="fr">
                        <a href="${one.see}" class="checkBtn" name="see" id="${one.id}">查看</a>
                    </span>

                    <span class="img">
                        <img src="<%=basePath%>/${one.systempic}" />
                    </span>
                    <span style="width:87px;">Redoop CRH</span>
                    <span class="img">${one.sysversion}</span>
                    <span>${one.documentname}</span>
                    <span class="img">
                        <img src="<%=basePath%>/${one.chippic}" />
                    </span>
                    <span class="downLink">
                        <a href="${one.documenturl}" name="see" id="${one.id}">${one.documenturl}</a>
                    </span>
                    <span class="downNum">点击次数：${one.docudowncount}</span>
                    <span class="downNum1">${one.producttime}更新</span>
                </li>
            </ul>
           </c:forEach>
        </c:if>

    </div>
</section>
<jsp:include page="tools/footer.jsp"></jsp:include>
</body>
<script>
    $(function () {
        $("[name='see']").click(function () {
            var id = $(this).attr("id");
            var url=$(this).val();
            $.post(
                "<%=basePath%>/front/redoopCRH/addDocumenCount/" + id,
                "",
                function (obj) {
                    if (obj) {
                        location.href=url;
                    } else {
                        alert("查看失败");
                    }
                },
                "json"
            )
        });

    })
</script>
</html>
