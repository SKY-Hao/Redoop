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

<section class="grey-bg" id="breadMenu"  style="margin-top: 75px;">
	<div class="container"><a href="<%=basePath%>/">首页</a> &gt; 产品资料</div>
</section>
<!--文档类型-->
<div class="verNav" style="height: 64px;border-bottom: 1px solid #999;margin-top: 0px;">
	<div class="container">
		<a href="<%=basePath%>/front/download?producttype=0"  <c:if test="${producttype==0}"> class="on"</c:if>>产品文档</a>
        <a href="<%=basePath%>/front/download?producttype=1"  <c:if test="${producttype==1}"> class="on"</c:if>>产品技术文档</a>
        <a href="<%=basePath%>/front/download?producttype=2"  <c:if test="${producttype==2}"> class="on"</c:if>>测试报告</a>
	</div>
</div>

<section class="block">
	<div class="container clearfix">
		<!--文档类型-->
		<h2 class="downloadH2" style="margin-top:0;">
			Redoop-
			<c:if test="${producttype==0}">产品文档</c:if>
			<c:if test="${producttype==1}">产品技术文档</c:if>
			<c:if test="${producttype==2}">测试报告</c:if>

		</h2>

		<c:if test="${empty pageList.getContent()}">
			<div style="margin-left: 15px; margin-top: 15px;">
				<h3 style="color: brown;"> 文档编译中...</h3>
				<h3 style="color: brown;"> 请您耐心等待发布，谢谢...</h3>
			</div>
		</c:if>
		<c:if test="${not empty pageList.getContent()}">
			<c:forEach items="${pageList.getContent()}" var="one">
				<ul class="downList">
					<li>
						<button value="${one.producturl}" class="aBtn fr" name="producturl" id="${one.id}"
								style="margin-top: 10px;line-height: 40px;"><!--下载地址-->
							下载
						</button>
						<div>
                            <span style="text-decoration: none;">
                                <a href="${one.producturl}">
										${one.productname}
								</a>
                            </span>
							<span style="font-size: 8px; margin-left: 30px;color: #999;">
                                    ${one.producttime}更新发布
                            </span>
						</div>
						<span style="display:none;" name="docudowncount">${one.productcount}</span>
					</li>
				</ul>
			</c:forEach>
		</c:if>


		<!--分页-->
		<jsp:include page="../../tools/page/admin_page.jsp"></jsp:include>

	</div>
</section>


<jsp:include page="tools/footer.jsp"></jsp:include>



</body>
<script>
    $(function () {
        $("[name='producturl']").click(function () {
            var id = $(this).attr("id");
            var url=$(this).val();
            $.post(
                "<%=basePath%>/front/download/addProductCount/" + id,
                "",
                function (obj) {
                    if (obj) {
                        location.href=url;
                    } else {
                        alert("下载失败");
                    }
                },
                "json"
            )
        });

		/* $(".a").click(function () {

		 $("[name='documenturl']").click();
		 })*/
    })
</script>
</html>
