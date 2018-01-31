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
	<link  rel="stylesheet" href="<%=basePath%>/front/website/css/partnerFotter.css" type="text/css">
	<link rel="stylesheet" href="<%=basePath%>/front/website/css/bootstrap-select.css">

</head>


<body>

<jsp:include page="tools/header.jsp"></jsp:include>

<section class="grey-bg" id="breadMenu">
	<div class="container" id="partnerA"><a href="<%=basePath%>/">首页</a> &gt; 合作伙伴</div>
</section>


<section class="block">
	<div class="container clearfix">
		<h2 class="titleLeft">合作伙伴</h2>
		<p style="margin-left:15px; margin-bottom:20px;font-size: 15px;">
			红象云腾与众多的合作伙伴一起互信共赢，共同取得了许多成绩。
			感谢陪伴我们一路走来的合作伙伴，也期待和您的共同合作！
			<span class="sq" data-target="#sqModal"  data-toggle="modal" >
				<a href="#" style="padding:5px 10px;border-radius:3px; background:#cd2017; text-align:center; color:#fff;">
					在线申请加入合作伙伴
				</a>
			</span>
		</p>

		<form action="<%=basePath%>/front/partners/findByPartnertype/" method="GET" style="margin-left: 15px;margin-bottom: 20px;font-size: 15px;">

			<select id="maxOption2" class="selectpicker show-menu-arrow form-control" multiple data-max-options=""  name="partnertype">

				<option name="partnertype" value="0" <c:forEach var="a" items="${partnertypeList}"><c:if test="${a=='0'}">selected</c:if></c:forEach> style="color: #a94442">硬件厂商</option>
				<option name="partnertype" value="1" <c:forEach var="a" items="${partnertypeList}"><c:if test="${a=='1'}">selected</c:if></c:forEach> style="color: #a94442">集成厂商</option>
				<option name="partnertype" value="2" <c:forEach var="a" items="${partnertypeList}"><c:if test="${a=='2'}">selected</c:if></c:forEach> style="color: #a94442">设备厂商</option>
				<option name="partnertype" value="3" <c:forEach var="a" items="${partnertypeList}"><c:if test="${a=='3'}">selected</c:if></c:forEach> style="color: #a94442">软件合作厂商</option>
				<option name="partnertype" value="4" <c:forEach var="a" items="${partnertypeList}"><c:if test="${a=='4'}">selected</c:if></c:forEach> style="color: #a94442">基础软件厂商</option>
				<option name="partnertype" value="5" <c:forEach var="a" items="${partnertypeList}"><c:if test="${a=='5'}">selected</c:if></c:forEach> style="color: #a94442">应用软件厂商</option>

			</select>
			<input type="submit"  value="Search">
		</form>

		<div>
			<span class="certifiedIcon1" style="display: block;">
					<span style="margin-left: 30px;font-size: 15px;">
						此图标为本公司认证标识
					</span>
			</span>
		</div>

		<c:if test="${empty pageList.getContent()}">
			<div style="margin-left: 15px; margin-top: 15px;">
				<h4 style="color: brown"> 抱歉，没有搜索到您想要查询厂商的合作伙伴信息......</h4>
			</div>
		</c:if>
		<c:if test="${not empty pageList.getContent()}">
			<c:forEach items="${pageList.getContent()}" var="one" >
				<div class="col-4" data-target="#myModal"  data-toggle="modal">

					<div  class="partenrOne" >
						<a href="#">
							<span>
								<img src="<%=basePath%>/${one.companypic}" />
							</span>

							<c:if test="${one.authentication==0}">		<!--显示认证图标-->
								<span class="certifiedIcon" style="display: block;"/>
							</c:if>
							<c:if test="${one.authentication==1}">
								<span class="certifiedIcon" style="display: none;"/>
							</c:if>
						</a>

					</div>
					<input type="hidden" value="${one.id}">
					<input type="hidden" value="${one.partnertype}">
				</div>
			</c:forEach>
		</c:if>
	<%--表格--%>
		<div class="modal fade" id="myModal" tabindex="100" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:70%;  margin-top: 15%;" >
				<div class="modal-content">

					<!--模态框头-->
					<div class="modal-header" id="tabletou" style="background-color: #c9302c; border-bottom-color: #c9302c;">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true" >
							&times;
						</button>
						<div class="modal-title" style="color: #f9f9f9">
							<h4 id="a1" style="font-size: 20px;"></h4> <!--公司名称-->
							<p id="a2" style="white-space:normal"></p>   <!--公司简介-->
						</div>
					</div>

					<div id="mo">
						<!--模态框内容-->
						<div class="modal-body" id="sp" style="height: 25%; background-color: #c9302c;color: #f9f9f9; display-model: block" >
							<table class="table table-bordered" id="table1" style="word-break:break-all;word-wrap: break-word;
															background-color: #c9302c; padding: inherit;" >
								<thead>
								<tr style="font-size: 12px;">
									<th>Redoop CRH版本</th>
									<th>合作伙伴产品名称</th>
									<th>合作伙伴产品版本</th>
									<th>测试内容</th>
									<th>测试结果</th>
								</tr>
								</thead>
								<tbody>
								<tr class="partnertd" style="height: 35px;">
									<td id="a3"></td>	<!--测试版本（Redoop CRH版本）-->
									<td id="a4"></td>	<!--合作伙伴产品名称-->
									<td id="a5"></td>	<!--合作伙伴产品版本-->
									<td id="a6"></td>	<!--测试内容-->
									<td id="a7"></td>	<!--测试结果-->
								</tr>
								</tbody>
							</table>
						</div>
					</div>

				</div>
			</div>
		</div><!--模态框end-->

	</div>

</section>

<div class="modal fade" id="sqModal" tabindex="100" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width:35%;margin-top: 25%;">

		<div class="sqfrom">
			<span type="button" style="color: #f7f7f8;margin-right: 1px;" class="close" data-dismiss="modal" aria-hidden="true" >
				&times;
		   	</span>
			<h2 style=" height:80px; line-height:80px; text-align:center; font-size:25px; background:#252527; font-weight:normal; color:#fff; margin-top: 0;">申请为合作伙伴</h2>

			<form action="" id="f1" class="form-horizontal" method="post" enctype="multipart/form-data"  style="color: black;">
				<div class="form-group">
					<label class="col-sm-4 control-label">公司名称</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="companyname">
					</div>
					<span style="color: #d43f3a;font-size: 16px;">*</span>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">公司类型</label>
					<div class="col-sm-6">
						<select class="form-control m-b" name="companytype">
							<option value="0" >互联网</option>
							<option value="1" >企业应用</option>
						</select>
					</div>
					<span style="color: #d43f3a;font-size: 16px;">*</span>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">联系人名字</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="contactsname">
					</div>
					<span style="color: #d43f3a;font-size: 16px;">*</span>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label">联系人电话</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="contactstel">
					</div>
					<span style="color: #d43f3a;font-size: 16px;">*</span>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label">联系人邮箱</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="contactsemail">
					</div>
					<span style="color: #d43f3a;font-size: 16px;">*</span>
				</div>

				<div class="form-group" style="display: none">
					<label class="col-sm-2 control-label">合作伙伴类型</label>
					<div class="col-sm-4">
						<select class="form-control m-b" name="partnertype">
							<option value="6" ${form.partnertype=='6'?'selected':''} ></option>
							<option value="0" ${form.partnertype=='0'?'selected':''} >硬件厂商</option>
							<option value="1" ${form.partnertype=='1'?'selected':''} >集成厂商</option>
							<option value="2" ${form.partnertype=='2'?'selected':''} >设备厂商</option>
							<option value="3" ${form.partnertype=='3'?'selected':''} >软件合作厂商</option>
							<option value="4" ${form.partnertype=='4'?'selected':''} >基础软件厂商</option>
							<option value="5" ${form.partnertype=='5'?'selected':''} >应用软件厂商</option>
						</select>
					</div>
				</div>
				<div class="form-group" style="display:none;">
					<label class="col-sm-4 control-label">合作伙伴意向</label>
					<div class="col-sm-6">
						<label><input name="intention" type="radio" value="0" />展示</label>
						<label><input name="intention" type="radio" value="1" checked/>不展示</label>
					</div>
					<span style="color: #d43f3a;font-size: 16px;">*</span>
				</div>
				<div class="form-group" style="display: none">
					<label class="col-sm-2 control-label">审核结果</label>
					<div class="col-sm-4">
						<label><input name="auditoresult" type="radio" value="0" />审核</label>
						<label><input name="auditoresult" type="radio" value="1" checked/>未审核</label>
					</div>
				</div>
				<div class="form-group" style="display: none">
					<label class="col-sm-2 control-label">测试结果</label>
					<div class="col-sm-4">
						<label><input name="testresult" type="radio" value="0" />通过</label>
						<label><input name="testresult" type="radio" value="1" checked/>未通过</label>
					</div>
				</div>
				<div class="form-group" style="display: none">
					<label class="col-sm-2 control-label">认证结果</label>
					<div class="col-sm-4">
						<label><input name="authentication" type="radio" value="0" />认证</label>
						<label><input name="authentication" type="radio" value="1" checked/>未认证</label>
					</div>
				</div>

				<button type="button" id="ljsq" class="btn btn-danger" style="margin-left:12%; width: 350px;">立即申请</button>
			</form>

		</div>
	</div>
</div>


<div style="margin-right: auto;
    margin-left: auto;
    margin-bottom: 30px;
    max-width: 1200px;
    min-width: 1200px;margin-top: -50px">
	<jsp:include page="../../tools/page/admin_page.jsp"></jsp:include>
</div>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>

<link  rel="stylesheet" href="<%=basePath%>/front/website/css/bootstrap.min.css?v=3.3.6">
<script type="text/javascript" src="<%=basePath%>/front/website/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/front/website/js/bootstrap-select.js"></script>

<script type="text/javascript">

    $("#ljsq").click(function () {
        $.post(
            "<%=basePath%>/front/partners/addPartner",
            $("#f1").serialize(),
            function (obj) {
                if(obj){
                    alert("申请成功,请您耐心等待公司审核后给您联系...");
                    $("#sqModal").modal('hide');
                }else {
                    alert("对不起,您的信息填写不完善,请重新输入...");
                }
            },
            "json"
        )
    });

    $(".sq").click(function () {
        $(".sqfrom").show();
    });

    $(".partenrOne").click(function () {
        var id=$(this).next().val();
        $.get(
            "<%=basePath%>/front/partners/findByPicId?id=" + id,
            "",
            function (obj) {
                if(obj.authentication==0){

					$("#myModal").modal('show');
					$("#table1").show();
                    $("#mo").show();

                }else {

					$(".modal-body").modal('hide');
					$("#table1").hide();
					$("#mo").hide();
                }
                if(obj){
                    $("#a1").html(obj.companyname);
                    $("#a2").html(obj.companyprofile);
                    $("#a3").html(obj.testversion);
                    $("#a4").html(obj.partnerproduct);
                    $("#a5").html(obj.partnerversion);
                    $("#a6").html(obj.testcontent);
                    $("#a7").html(obj.testresult==0?'通过':"未通过");
                }else {
                    alert("错误");
                }
            },
            "json"
        )
    });

</script>

</html>
