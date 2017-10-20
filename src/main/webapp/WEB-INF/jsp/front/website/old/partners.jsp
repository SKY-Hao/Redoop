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

</head>


<body>

<jsp:include page="tools/header.jsp"></jsp:include>

<section class="grey-bg" id="breadMenu" style="margin-top: 75px;">
	<div class="container"><a href="<%=basePath%>/">首页</a> &gt; 合作伙伴</div>
</section>
<section class="block">
	<div class="container clearfix">
		<h2 class="titleLeft">合作伙伴</h2>
		<ul class="partnersList">
			<li><a><img src="<%=basePath%>/front/website/img/partnerIBM.jpg" /></a></li>
			<li><a><img src="<%=basePath%>/front/website/img/partnerMicrosoft.jpg" /></a></li>
			<li><a><img src="<%=basePath%>/front/website/img/partnerKYLIN.jpg" /></a></li>
			<li><a><img src="<%=basePath%>/front/website/img/partnerRedFlag.jpg" /></a></li>
			<li><a><img src="<%=basePath%>/front/website/img/partnerZB.jpg" /></a></li>
			<li><a><img src="<%=basePath%>/front/website/img/partnerZHONGTAI.jpg" /></a></li>
			<li><a><img src="<%=basePath%>/front/website/img/partnerODPI.jpg" /></a></li>
			<li><a><img src="<%=basePath%>/front/website/img/partnerOpenPower.jpg" /></a></li>
			<li><a><img src="<%=basePath%>/front/website/img/partnerZKDJ.jpg" /></a></li>
			<li><a><img src="<%=basePath%>/front/website/img/partnerXYDF.jpg" /></a></li>
			<li><a><img src="<%=basePath%>/front/website/img/partnerSJJ.jpg" /></a></li>
		</ul>
	</div>
</section>
<section class="block grey-bg">
	<div class="container clearfix">
		<h2 class="titleLeft">产品认证</h2>
		<div class="clearfix">
			<table  border="0" cellspacing="0" cellpadding="0" class="table1">
				<tr>
					<th>公司名称</th>
					<th>认证产品</th>
					<th>认证编号</th>
				</tr>
				<tr>
					<td>山东英特力数据技术有限公司</td>
					<td>CRH 4.9 ppc64le</td>
					<td>RH16122001</td>

				</tr>
				<tr>
					<td>中标软件有限公司</td>
					<td>CRH 4.9 ppc64le</td>
					<td>CRH17030601</td>

				</tr>
			</table>
		</div>
	</div>
</section>
<section class="block" style="display: none;">
	<div class="container clearfix">
		<h2 class="titleLeft">申请成为我们的合作伙伴</h2>
		<div class="clearfix row">
			<div class="col-2 fl">
				<input type="text" class="inputIn" placeholder=" * 您的名称" />
				<input type="text" class="inputIn" placeholder=" * 您的电话" />
				<input type="text" class="inputIn" placeholder=" 您的邮箱" />
				<input type="text" class="inputIn" placeholder=" * 您公司的名称" />
			</div>
			<div class="col-2 fl">
				<textarea class="textareaIn" ></textarea>
			</div>
		</div>
		<div class="clearfix" style="margin-left:15px; margin-right:15px;">
			<button class="aBtn fr" value="提交" >提交</button>
			* 为必填项
		</div>
	</div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
