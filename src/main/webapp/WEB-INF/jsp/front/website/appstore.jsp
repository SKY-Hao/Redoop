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
    <link href="<%=basePath%>/front/website/css/appstore.css" type="text/css" rel="stylesheet" />
</head>
<body>
<jsp:include page="tools/header.jsp"></jsp:include>
<div class="e-appstoreBannner"></div>


<div class="modal fade" id="myTips" tabindex="100"  role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
    <div class="modal-dialog" style="width:70%;  margin-top: 23%;" >
            <!--服务详细信息-->
            <div class="tips" style="display: none;" id="tips">

                <span type="button" style="color: black;margin-right: 1px;" class="close" data-dismiss="modal" aria-hidden="true" >
                        &times;
                </span>
                <div class="partImg">
                    <img id="picurl" src="<%=basePath%>/${compontent.picurl}"/>
                </div>
                <div class="partTxt">
                    <h3 id="name">${compontent.name}</h3>
                    <p id="description">${compontent.description}</p>
                </div>
                <div style="clear:both;"></div>
                <div class="step">
                    <h4>安装步骤</h4>
                    <ul id="downurl">
                        <li><a href="${compontent.downurl}">${compontent.downurl}</a></li>
                    </ul>
                </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="100"  role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:70%;  margin-top: 23%;" >
            <!--登录-->
            <div class="login"  style="${login}; background-color: #dfdfdf;">
                   <span type="button" style="color: #f7f7f8;margin-right: 1px;" class="close" data-dismiss="modal" aria-hidden="true" >
                    &times;
                   </span>
                <h2>登录</h2>
                <div class="formCon">
                    <span id="loginerror" style="color: #d43f3a" ></span>
                    <span>${erro}</span>
                    <input type="text" class="input loginTxt" placeholder="邮箱名" name="email" id="loginemail"/>
                    <input type="password" class="input loginTxt" placeholder="密码" name="password" id="loginpass"/>
                    <%--<p class="forgetTxt" disabled="disabled"><a href="#">忘记密码</a></p>--%>
                    <p class="forgetTxt" disabled="disabled">忘记密码</p>
                    <button class="formBtn loginBtn" id="dengLu">登录</button>

                    <div class="col-8" data-target="#regModal"  data-toggle="modal">
                        <a href="#" class="redLink" data-dismiss="modal" aria-hidden="true">
                            新用户注册
                        </a>
                    </div>

                </div>
            </div>

    </div>
</div>

<div class="modal fade" id="regModal" tabindex="-1"  role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:70%;  margin-top: 23%;" >
        <!--注册-->
        <div class="registe" id="reg" style="display:none;z-index: 1; background-color: #dfdfdf; position: fixed;">
             <span type="button" style="color: #f7f7f8;margin-right: 1px;" class="close" data-dismiss="modal" aria-hidden="true" >
                    &times;
             </span>
            <h2>注册帐号</h2>
            <div class="formCon" style="margin-top: 15px">
                   <form action=""  id="addRegiste">
                       <input type="text" class="input registeTxt"  placeholder="请输入:2~8个汉字/4~16个字符(用户名)" id="txtInput" name="username"/>
                       <input type="text" class="input registeTxt" placeholder="请输入:正确的手机号码(11位)" name="phonenumber"/>
                       <input type="text" class="input registeTxt" placeholder="请输入:正确的邮箱格式" name="email"/>
                       <input type="text" class="input registeTxt" placeholder="请输入:公司名称" name="companyname"/>
                       <input type="password" class="input registeTxt" placeholder="请输入:6-20位密码" id="password" name="password"/>
                       <input type="password" class="input registeTxt" placeholder="确认密码:两次密码必须要一致" name="repassword"/>
                       <button class="formBtn registeBtn" id="registe" type="button">注册</button>
                       <p class="forgetTxt" style="color: #d43f3a; height: 50px; margin-top: 10px ">已有帐号，去
                           <a href="#" class="QDL">登录</a>
                       </p>
                   </form>
            </div>
        </div>
    </div>
</div>

<!--组件 案例 行业版本-->
<div class="e-appstoreNav">
    <div class="container">

        <div class="searchCon">
            <form action="<%=basePath%>/front/appstore/select/"  method="get">
                <input type="text" class="inputApp" name="name" value="${name}"/>
                <button class="searchBtn" type="submit">搜索</button>
            </form>
        </div>
        <a href="<%=basePath%>/front/appstore?type=0" <c:if test="${type==0}"> class="on"</c:if>>组件</a>
        <%--<a href="<%=basePath%>/front/appstore?type=1" <c:if test="${type==1}"> class="on"</c:if>>案例</a>
        <a href="<%=basePath%>/front/appstore?type=2" <c:if test="${type==2}"> class="on"</c:if>>行业版本</a>--%>
        <a class="a" style="font-size: 1px;">案例(敬请期待)</a>
        <a class="a" style="font-size: 1px;">行业版本(敬请期待)</a>

    </div>
</div>

<!--搜索-->
<div class="block" style="margin-top:-35px;" id="eAppStore">
    <div class="container clearfix" style="margin-top: 10px;">
        <div class="userInfo">欢迎您:
            <span id="okname">  ${customer.email}</span>
        </div>
        <div class="searchResult" style="display:none;">共搜索以下到<span>10</span>条组件</div>
    </div>

    <div class="container">
        <div class="clearfix">
            <c:if test="${empty pageList.getContent()}">
                <h3> 抱歉，没有搜索到您想要的服务...</h3>
                <h3>我们会不断更新服务，谢谢...</h3>
            </c:if>
            <c:if test="${not empty pageList.getContent()}">
                <c:forEach items="${pageList.getContent()}" var="one">
                    <span style="display: none">${one.id}</span>
                    <div class="col-4">
                        <div class="appImg">
                            <a>
                                <img src="<%=basePath%>/${one.picurl}" alt="${one.name}"/>
                            </a>
                            <p>${one.subjection}</p>
                        </div>
                        <div class="appTxt">
                            <h2>${one.name}</h2>
                            <p>${one.description}</p>

                        <div class="col-4" data-target="#myModal"  data-toggle="modal">
                            <div class="status">
                                <span class="SQ">
                                    <button type="button" class="btn btn-danger">查看</button>
                                </span>
                                <input type="hidden" value="${one.id}">
                                <span class="loadNum">${one.downloads}</span>
                                <span class="size">${one.memorysize}</span>
                            </div>
                        </div>

                        </div>
                    </div>
                </c:forEach>
            </c:if>

        </div>
        <jsp:include page="../../tools/page/admin_page.jsp"></jsp:include>
    </div>
</div>


<jsp:include page="tools/footer.jsp"></jsp:include>
</body>
<link  rel="stylesheet" href="<%=basePath%>/front/website/css/bootstrap.min.css?v=3.3.6">
<script type="text/javascript" src="<%=basePath%>/front/website/js/bootstrap.min.js"></script>

<script type="text/javascript">
   $(".redLink").click(function(){
        $(".login").hide();
        $("#reg").show();
    });
    $(".QDL").click(function () {
        $("#regModal").modal('hide');
        $("#myModal").modal('show');
        $(".login").show();
    });
    $("#ARegsite").click(function () {
        $(".registe").hide();
        $(".login").show();
    });

    $("#registe").click(function () {
        $.post(
            "<%=basePath%>/front/addRegiste",
            $("#addRegiste").serialize(),
            function (obj) {
                if(obj){
                    alert("注册成功!请去邮箱激活!");
                    $("#regModal").modal('hide');
                    $("#myModal").modal('show');
                    $(".login").show();
                }else{
                    alert("注册失败!（信息输入有误，请按提示输入正确信息）请重新注册");
                }
            },
            "json"
        );
    });

    $(".SQ").click(function () {
        var id = $(this).next().val();
        $.get(
            "<%=basePath%>/front/appstore/apply?id=" + id,
            "",
            function (obj) {
                if (obj == 6) {
                    $(".login").show();
                } else
                if(obj == 5){
                    $("#regModal").modal('hide');
                    $("#myModal").modal('hide');
                    $.get(
                        "<%=basePath%>/front/appstore/applyById?id=" + id,
                        "",
                        function (obj) {
                            if(obj){
                                $("#picurl").attr('src',"<%=basePath%>/"+obj.picurl);
                                $("#name").html(obj.name);
                                $("#description").html(obj.description);
                                $("#downurl").html(obj.downurl);
                            }else{
                                $(".login").show();
                            }
                        },
                        "json"
                    );
                    $("#myTips").modal('show');
                    $(".tips").show();
                }
            },
            "json"
        );
    });

    $("#dengLu").click(function () {
        var loginemail = $('#loginemail').val();
        $.get(
            "<%=basePath%>/front/customerLogin/",
            {'email':loginemail,'password':$('#loginpass').val()},
            function (obj) {
                if (obj==3){//登录成功
                    $(".login").hide();
                    $("#regModal").modal('hide');
                    $("#myModal").modal('hide');
                    $('#okname').html(loginemail);
                }else if(obj==2) {
                    $('#loginerror').html('登录失败:密码错误');
                }else if(obj==1){
                    $('#loginerror').html('登录失败:邮箱名称不正确(此邮箱没有注册，请注册)');
                }else if (obj==4){
                    $('#loginerror').html('登录失败:此邮箱还没有激活');
                }else {
                    $('#loginerror').html('登录失败:邮箱格式错误');
                }
            },
            "json"
        );
    });

   $(function(){
       $('.a').removeAttr('href');//去掉a标签中的href属性
       $('.a').removeAttr('onclick');//去掉a标签中的onclick事件
   });
</script>
</html>