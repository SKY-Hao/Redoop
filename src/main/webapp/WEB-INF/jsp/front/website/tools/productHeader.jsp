<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>



<%--
<script type="text/javascript" src="<%=basePath%>/front/website/js/jquery-1.11.3.min.js"></script>
--%>

<header class="header" style="height: 75px;position: fixed;top: 0px;width: 100%;z-index:1;">
    <div class="container clearfix" style="height:auto;">
        <div class="header-r fr">
           <%-- <p><a href="<%=basePath%>/customer/register" target="_blank">注册</a> | <a href="<%=basePath%>/customer/login" target="_blank">登录</a></p>--%>
               <p style="color:#dc0005; font-weight:bold;font-family:tahoma arial;font-size:14px">TEL：400-0389-155</p>
            <ul>
<!--                <li><a href="<%=basePath%>/front/products" class="${product}">产品</a></li>
                <li><a href="<%=basePath%>/front/solution" class="${solution}">行业版本及案例</a></li>
-->
                <li><a href="<%=basePath%>/front/news" class="${news}">新闻</a></li>
                <li><a href="<%=basePath%>/front/productinformation" class="${productinformation}">产品资料</a></li>
                <li><a href="<%=basePath%>/front/partners" class="${partners}">合作伙伴</a></li>
                <%--<li><a href="<%=basePath%>/front/appstore" class="${appstore}">应用组件</a></li>--%>
                <li>
                        <div id="down">
                            <a style="text-decoration: none;">下载</a>
                            <%--<div id="aa" class="nav-nav" style="display: none;">
                                <a class="CRH" href="http://archive.redoop.com" style="border-bottom:1px dashed #4D4D4D" target="_blank">Redoop CRH</a>
                                <a class="AI"  href="http://archive.redoop.com/redoopAI" style="border-bottom:0px dashed #4D4D4D" target="_blank">Redoop AI</a>
                            </div>--%>
                            <div id="aa" class="nav-nav" style="display: none;">
                                <a class="CRH" href="<%=basePath%>/front/redoopCRH" style="border-bottom:1px dashed #4D4D4D">Redoop CRH</a>
                                <%--<a class="AI"  href="<%=basePath%>/front/redoopAI" style="border-bottom:0px dashed #4D4D4D">Redoop AI</a>--%>
                            </div>
                        </div>
                </li>
                <li class="last"><a href="http://www.redoop.net/"  target="_blank">技术社区</a></li>

                <li class="last"><a href="<%=basePath%>/front/aboutus" class="${aboutus}" style="text-decoration: none;">关于我们</a></li>

            </ul>
        </div>
        <div class="header-l fl clearfix">
            <a href="http://www.redoop.com" class="logo fl" title="红象云腾"></a>
         <!--   <i title="大数据基础软件旗舰厂商"></i>-->
        </div>
    </div>
    <script type="text/javascript">
        $('#down').mouseover(function(){
            $('#aa').show();
        }).mouseout(function(){
            $('#aa').hide();
        });
        $(function () {
            $(document).ready(function(){
                $(".CRH").mouseover(function(){
                    $(".CRH").css("color","red");
                });
                $(".CRH").mouseout(function(){
                    $(".CRH").css("color","#E9E9E4");
                });
            });
        })

    </script>
</header>

