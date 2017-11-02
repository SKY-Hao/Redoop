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
	<link rel="stylesheet" href="<%=basePath%>/front/website/css/week.css" type="text/css"/>

</head>

<body>

<header class="header">
	<div class="container clearfix">
		<div class="mzjy">截止日期:</div>
		<div class="header-l fl clearfix">
			<a href="http://www.redoop.com" class="logo fl" title="红象云腾"></a>
			<i title="企业大数据旗舰厂商"></i>
		</div>
	</div>
</header>
<div class="wrap">
	<div class="content1">
		<c:if test="${empty list}">
			<h3>抱歉,本周还有没更新最新业务,</h3>
			<h3>请您耐心等待......</h3>
		</c:if>
		<c:if test="${not empty list}">
			<c:forEach items="${list}" var="list">
				<dl>
					<dt>
						<span>${list.date}</span>
						<a href="${list.jumpurl}">${list.tabletitle}</a>
					</dt>
					<dd>
						${list.outline}...
					</dd>
				</dl>
			</c:forEach>
		</c:if>

	</div>
</div>


<jsp:include page="tools/footer.jsp"></jsp:include>
</body>
<script>
    $(function(){
        var mydate = new Date();
        var t=mydate.toLocaleDateString();
		var s="截止日期:"
        $(".mzjy").text(s+t);

    });
</script>
</html>
