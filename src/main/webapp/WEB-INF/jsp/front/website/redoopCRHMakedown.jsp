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

<%--<section class="block">--%>
    <div class="container clearfix" style="padding-bottom: 30px;width: 976px;">

            <c:forEach  items="${downloadMarkList}" var="one">
            <ul class="downList-crh" style="margin-top: 20px;">

               <li>
                    <span class="fr">
                        <a href="<%=basePath%>/front/byCRH1/${one.id}" class="checkBtn" id="${one.id}" >ChangeLog</a>
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
                        <a href="${one.documenturl}" id="${one.id}">${one.documenturl}</a>
                    </span>
                    <span class="downNum">点击次数：${one.docudowncount}</span>
                    <span class="downNum1">${one.producttime}更新</span>
                </li>
            </ul>
           </c:forEach>

    </div>

</body>
<script>
   $(function () {
        $(".fr").click(function () {
            var id = $(this).children().attr("id");
            $.post(
                "<%=basePath%>/front/redoopCRH/addMakeDown/" + id,
                "",
                function (obj) {
                    if (obj){return false;}else {}
                },
                "json"
            )
        });
   })

</script>
</html>
