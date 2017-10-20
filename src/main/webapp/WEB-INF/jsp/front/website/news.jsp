<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="tools/head.jsp"></jsp:include>

</head>

<body>

<jsp:include page="tools/header.jsp"></jsp:include>

<section class="grey-bg" id="breadMenu" style="margin-top: 75px;">
	<div class="container"><a href="<%=basePath%>/">首页</a> &gt; 新闻</div>
</section>
<section class="block">
	<div class="container clearfix">

		<c:forEach items="${newList}" var="onenew">
			<div class="newsCon clearfix">

				<div class="grid_1 alpha"><!--日期-->
					<div class="date">
						<span> ${onenew.month}. </span>
						<span>${onenew.day}&nbsp;</span>
						<span class="year">${onenew.year}</span>
					</div>
				</div>

				<div class="cont span_2_of_single">
					<h4 class="blog_title">
						<a href="<%=basePath%>/front/onenew/${onenew.id}"><!--标题-->
								${onenew.title}
						</a>
					</h4>
					<a href="<%=basePath%>/front/onenew/${onenew.id}"><!--图片-->
						<img class="m_img" width="780" height="250"  src="<%=basePath%>/${onenew.picPath}" alt=""/>
					</a>
					<p class="m_para" style="width: 780px;"><!--内容-->
						&nbsp;&nbsp;&nbsp;&nbsp;${onenew.content}[...]
					</p>
					<br/>
					<a href="<%=basePath%>/front/onenew/${onenew.id}" class="arrowBtn"><!--更多-->
						More
					</a>
				</div><br/><br/>

			</div>
		</c:forEach>
		<%--<jsp:include page="../../tools/page/admin_page.jsp"></jsp:include>--%>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
