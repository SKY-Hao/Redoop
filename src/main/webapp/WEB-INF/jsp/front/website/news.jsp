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

		<c:forEach items="${pageList.getContent()}" var="one">

			<div class="newsCon clearfix" >

					<div class="grid_1 alpha"><!--日期-->
						<div class="date" style="width: 120px;margin-left: 60px;">
							<div class="date">${one.date}</div>
						</div>
					</div>


				<div class="cont span_2_of_single">
					<h4 class="blog_title">
						<a href="<%=basePath%>/front/onenew/${one.id}" style="margin-left: 95px;"><!--标题-->
								${one.title}
						</a>
					</h4>
					<a href="<%=basePath%>/front/onenew/${one.id}" style="margin-left: 95px;"><!--图片-->
						<img class="m_img" width="780" height="250"  src="<%=basePath%>/${one.picpath}" alt=""/>
					</a>
					<p class="m_para" style="width: 780px; margin-left: 95px;"><!--内容-->
						&nbsp;&nbsp;&nbsp;&nbsp;${one.content}[...]
					</p>
					<br/>
					<a href="<%=basePath%>/front/onenew/${one.id}" class="arrowBtn"style="margin-left: 95px;"><!--更多-->
						More
					</a>

				</div>
			</div>
		</c:forEach>
		<div class="cont span_2_of_single" style="margin-top: -50px;" >
			<jsp:include page="../../tools/page/admin_page.jsp"></jsp:include>
		</div>
	</div>

</section>




<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
