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

</head>

<body>

<jsp:include page="tools/header.jsp"></jsp:include>

<section class="grey-bg" id="breadMenu" style="margin-top: 75px;">
	<div class="container"><a href="<%=basePath%>/">首页</a> &gt; 行业版本与案例</div>
</section>
<section class="block">
	<div class="container clearfix">
		<h2 class="titleLeft">行业版本</h2>
		<div class="clearfix">
			<c:if test="${empty solutionList}">
				<div style="margin-left: 15px; margin-top: 15px;">
					<h3 style="color: brown"> 行业版本更新中,请您耐心等待新版本发布......</h3>
				</div>
			</c:if>
			<c:if test="${not empty solutionList}">
				<c:forEach items="${solutionList}" var="one">
					<div class="col-4" style="margin-left: 30px;">
						<a href="<%=basePath%>/front/solutiondetail/${one.id}">
							<span id="solutionImg">
								<img src="<%=basePath%>/${one.solutionpic}" alt="" class="center-block" />
							</span>
						</a>
						<h4><a href="<%=basePath%>/front/solutiondetail/${one.id}">${one.title}</a></h4>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>
</section>
<section class="block grey-bg"  id="solutionSection">
	<div class="container clearfix">
		<h2 class="titleLeft">产品案例</h2>
		<div class="row" style="margin-top: auto;">
			<c:if test="${empty solutionList2}">
				<div style="margin-left: 15px; margin-top: 15px;">
					<h3 style="color: brown"> 产品案例更新中,请您耐心等待新版本发布......</h3>
				</div>
			</c:if>
			<c:if test="${not empty solutionList2}">
				<c:forEach items="${solutionList2}" var="one2">
					<div class="col-2 fl" id="solutionCol-2">
						<div class="img">
							<a href="<%=basePath%>/front/solutiondetail/${one2.id}" id="solutionImg2">
								<img src="<%=basePath%>/${one2.solutionpic}"/>
							</a>
						</div>
						<div class="txt">
							<h3 style="margin: auto">
								<a href="<%=basePath%>/front/solutiondetail/${one2.id}">
									${one2.title}
								</a>
							</h3>
							<p>${one2.intro}</p>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>

	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>

</html>