<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!doctype html>
<html>
<head>

    <jsp:include page="tools/productHead.jsp"></jsp:include>
    <script type="text/javascript" src="<%=basePath%>/front/website/js/jquery.validate.js"></script>
    <link rel="stylesheet" href="<%=basePath%>/front/website/css/productinformation.css" type="text/css" media="screen" />

    <script type="text/javascript">
        $(function () {
            $("[name='producturl']").click(function () {
                var id = $(this).attr("id");
                var url=$(this).val();
                $.post(
                    "<%=basePath%>/front/productinformation/addProductCount/" + id,
                    "",
                    function (obj) {

                        if(obj==0){
                            $(".mod-dialog-bg").show();
                            $(".wrap").show();
                            $("#f1").show();

                        }else if (obj==1) {

                            location.href=url;

                        }else if(obj==2){

                            alert("下载失败");

                        }
                    },
                    "json"
                )
            });
            /* $(".a").click(function () {
             $("[name='documenturl']").click();
             })*/
        });
    </script>
    <%--validate验证--%>
    <script type="text/javascript">
        $(function(){

            //自定义验证手机号
            jQuery.validator.addMethod("isMobile", function(value, element) {
                var length = value.length;
                var mobile = /^1[3456789]\d{9}$/;/*/^1(3|4|5|7|8)\d{9}$/*/
                return this.optional(element) || (length == 11 && mobile.test(value));
            }, "请正确填写您的手机号码");
            //控件validate
            $("#f1").validate({
                rules:{
                    companyname:{
                        required:true,
                        rangelength:[2,10]
                    },
                    username:{
                        required:true,
                        rangelength:[2,8]
                    },
                    phonenumber:{
                        required:true,
                        rangelength:[11,11],
                        digits:true,
                        number:true,
                        isMobile : true
                    },
                    email:{
                        required: true,
                        email:true
                    }
                },
                messages:{
                    companyname:{
                        required:"请输入公司名称",
                        rangelength:"公司名称长度不正确"
                    },
                    username:{
                        required:"请输入您的名字",
                        rangelength:"长度为2-10位"
                    },
                    phonenumber:{
                        required:"请输入手机号",
                        rangelength:"手机号为11位",
                        digits:"必须是数字"    ,
                        number:"请输入有效数字",
                        isMobile: "手机号格式错误"
                    },
                    email:{
                        required:"请输入邮箱",
                        email:"请输入正确格式的电子邮件"
                    }
                },
                submitHandler:function(){
                    $.post(
                        "<%=basePath%>/front/productinformation/saveCustomer",
                        $("#f1").serialize(),
                        function(obj){
                            if (obj){
                                alert("提交成功,请下载您所需的文件");
                                $(".mod-dialog-bg").hide();
                                $(".wrap").hide();
                                $("#f1").hide();
                            }
                        }
                    );
                }
            });
            $(".closeX").click(function () {
                $(".mod-dialog-bg").hide();
                $(".wrap").hide();
                $("#f1").hide();
            });
            $(".mod-dialog-bg").click(function () {
                $(".mod-dialog-bg").hide();
                $(".wrap").hide();
                $("#f1").hide();
            });
        });
    </script>

</head>

<body>
<jsp:include page="tools/productHeader.jsp"></jsp:include>

<section class="grey-bg" id="breadMenu">
    <div class="container" id="partnerA"><a href="<%=basePath%>/">首页</a> &gt; 产品资料</div>
</section>
<!--文档类型-->
<div class="verNav" style="height: 64px;border-bottom: 1px solid #999;margin-top: 0px;">
    <div class="container">
        <a href="<%=basePath%>/front/productinformation?producttype=1"  <c:if test="${producttype==1}"> class="on"</c:if>>产品技术文档</a>
        <a href="<%=basePath%>/front/productinformation?producttype=0"  <c:if test="${producttype==0}"> class="on"</c:if>>产品文档</a>
        <a href="<%=basePath%>/front/productinformation?producttype=2"  <c:if test="${producttype==2}"> class="on"</c:if>>测试报告</a>
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
                            <%--<span id="xiazai">
                                <a href="${one.producturl}" class="aBtn fr" name="producturl"style="margin-top: 10px;line-height: 40px;">下载</a>
                            </span>--%>
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
    </div>

</section>

<div class="mod-dialog-bg"></div>
<div class="wrap" style="">
    <h4>申请下载<a href="#" class="closeX">X</a></h4>
    <div class="con">
        <form action="" id="f1" class="form-horizontal" method="post" enctype="multipart/form-data"  style="display: none; ">

            <div class="clearfix">
                <label>姓名</label><input type="text" class="text" name="username"/>
                <label style="display: inline-block;width: 70px;text-align: right;height: inherit;padding-right: 10px;"></label>
            </div>
            <div class="clearfix">
                <label>手机号码</label><input type="text" class="text" name="phonenumber"/>
                <label style="display: inline-block;width: 70px;text-align: right;height: inherit;padding-right: 10px;"></label>
            </div>
            <div class="clearfix">
                <label>电子邮箱</label><input type="text" class="text"  name="email"/>
                <label style="display: inline-block;width: 70px;text-align: right;height: inherit;padding-right: 10px;"></label>
            </div>
            <div class="clearfix">
                <label>公司名称</label><input type="text" class="text" name="companyname"/>
                <label style="display: inline-block;width: 70px;text-align: right;height: inherit;padding-right: 10px;"></label>
            </div>
            <div class="clearfix">
                <input type="submit" value="提交信息" class="btn" />
            </div>
        </form>
    </div>
</div>

<div style="margin-right: auto;margin-left: auto;margin-bottom: 30px;max-width: 1200px;min-width: 1200px;margin-top: -50px">
    <jsp:include page="../../tools/page/admin_page.jsp"></jsp:include>
</div>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>



</html>
