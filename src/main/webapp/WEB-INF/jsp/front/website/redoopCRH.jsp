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
    <link href="<%=basePath%>/front/website/css/CRHFotter.css" type="text/css" rel="stylesheet" />
    <link href="<%=basePath%>/front/website/css/crh.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=basePath%>/front/website/css/productinformation.css" type="text/css" media="screen" />

    <script type="text/javascript" src="<%=basePath%>/front/website/js/jquery.validate.js"></script>

</head>

<body>

<jsp:include page="tools/productHeader.jsp"></jsp:include>

<div class="crhheader">
    <div class="headerBg">
        <div class="container">

            <h2><img src="<%=basePath%>/front/website/css/img/crhImages/txt.png" /></h2>
            <p>CRH大数据平台支持5颗芯片，主流的硬件和操作系统。致力于成为世界最顶级的大数据供应商，OpenPower平台是唯一指定的大数据软件供应商，支持主流的X86平台，在国产化趋势下，研发支持了飞腾，龙芯，申威等国产芯片。源代码完全自主可控的大数据平台。支持国产主流的服务器操作系统，红旗，银河麒麟，中标麒麟等操作系统。所以红象云腾有大量来自全国的硬件、操作系
                统、大数据应用软件合作伙伴。</p>
        </div>
    </div>
</div>

<!--平台类型-->
<div class="verNav">
    <div class="container">
        <a href="<%=basePath%>/front/redoopCRH?platformtype=0"  <c:if test="${platformtype==0}"> class="on"</c:if>>X64</a>
        <a href="<%=basePath%>/front/redoopCRH?platformtype=1"  <c:if test="${platformtype==1}"> class="on"</c:if>>OpenPower</a>
        <a href="<%=basePath%>/front/redoopCRH?platformtype=2"  <c:if test="${platformtype==2}"> class="on"</c:if>>ARM/飞腾</a>
        <a href="<%=basePath%>/front/redoopCRH?platformtype=3"  <c:if test="${platformtype==3}"> class="on"</c:if>>申威</a>
        <a href="<%=basePath%>/front/redoopCRH?platformtype=4"  <c:if test="${platformtype==4}"> class="on"</c:if>>龙芯</a>
    </div>
</div>

<section class="block">
    <div class="container clearfix" style="padding-bottom: 30px;width: 976px;">
        <!--平台类型-->
        <h2 class="downloadH2" style="margin:auto;">
            Redoop CRH for
            <c:if test="${platformtype==0}">X64</c:if>
            <c:if test="${platformtype==1}">OpenPower</c:if>
            <c:if test="${platformtype==2}">ARM/飞腾</c:if>
            <c:if test="${platformtype==3}">申威</c:if>
            <c:if test="${platformtype==4}">龙芯</c:if>
        </h2>

        <c:if test="${empty list}">
            <div style="margin-left: 15px; margin-top: 15px;">
                <h3 style="color: brown;"> 版本更新中...</h3>
                <h3 style="color: brown;"> 请您耐心等待发布，谢谢...</h3>
            </div>
        </c:if>
        <c:if test="${not empty list}">
            <c:forEach  items="${list}" var="one">
            <ul class="downList-crh" style="margin-top: 20px;">
              <%-- <span>${one.id}</span>--%>
               <li>

                    <button  class="aBtn fr" style="font-size: 14px;padding: 5px 5px;color: #fff;background: #2f3437;
                                        border-radius: 5px;width: 89px;height: 30px;line-height: 20px;" disabled="disabled"><!--下载地址-->
                        下载
                    </button>
                    <%--  <c:if test="${one.documenturl == ''}">
                           <button  class="aBtn fr" style="font-size: 14px;padding: 5px 5px;color: #fff;background: #2f3437;
                                        border-radius: 5px;width: 89px;height: 30px;line-height: 20px;" disabled="disabled"><!--下载地址-->
                               下载
                           </button>
                       </c:if>
                       <c:if test="${one.documenturl != ''}">
                           <button value="${one.documenturl}" class="aBtn fr" name="documenturl" id="${one.id}"
                            style="font-size: 14px;padding: 5px 5px;
                                    color: #fff;background: #33a0ff;
                                    border-radius: 5px;width: 89px;height: 30px;
                                    line-height: 20px;" target="_blank"><!--下载地址-->
                                 下载
                             </button>
                       </c:if>--%>



                    <%--之前注释--%>
                 <%--  <button value="${one.see}" class="aBtn fr" name="see" id="${one.id}"
                           style=" display:inline-block; float:right; font-size:14px; padding:5px 5px;color:#fff; background:#33a0ff; border-radius:5px; font-family:'微软雅黑';width:60px; line-height:20px;"><!--下载地址-->
                       查看
                   </button>--%>


                   <span class="img">
                        <img src="<%=basePath%>/${one.systempic}" />
                    </span>
                    <span style="width:87px;">Redoop CRH</span>
                    <span class="img">${one.sysversion}</span>
                    <span>${one.documentname}</span>
                    <span class="img">
                        <img src="<%=basePath%>/${one.chippic}" />
                    </span>
                    <%--<span class="downLink">
                        <a href="${one.documenturl}" id="${one.id}">${one.documenturl}</a>
                    </span>--%>
                    <span class="downNum">点击次数：${one.docudowncount}</span>
                    <span class="downNum1">${one.producttime}更新</span>
                </li>
            </ul>
           </c:forEach>
        </c:if>

    </div>
</section>



<div class="mod-dialog-bg"></div>
<div class="wrap">
    <h4>申请下载文档<a href="#" class="closeX">X</a></h4>
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



<jsp:include page="tools/footer.jsp"></jsp:include>
</body>
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
                    "<%=basePath%>/front/redoopCRH/saveCustomer",
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
<script type="text/javascript">
    $(function () {
        $("[name='documenturl']").click(function () {
            var id = $(this).attr("id");
            var url=$(this).val();
            $.post(
                "<%=basePath%>/front/redoopCRH/addDocumenCount/" + id,
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

</html>
