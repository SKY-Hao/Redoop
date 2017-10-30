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
</div>
<!--平台类型-->
<div class="verNav">
    <div class="container">

        <a href="<%=basePath%>/front/redoopAI?platformtype=0"  <c:if test="${platformtype==0}"> class="on"</c:if>>X64</a>
        <a href="<%=basePath%>/front/redoopAI?platformtype=1"  <c:if test="${platformtype==1}"> class="on"</c:if>>OpenPower</a>

    </div>
</div>

<section class="block">
    <div class="container clearfix" style="padding-bottom: 30px;width: 976px;">
        <!--平台类型-->
        <h2 class="downloadH2" style="margin:auto;">
            Redoop AI for
            <c:if test="${platformtype==0}">X64</c:if>
            <c:if test="${platformtype==1}">OpenPower</c:if>
        </h2>
        <a id="x64" name="x64"></a>
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
                        <a href="${one.documenturl}">${one.documenturl}</a>
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
