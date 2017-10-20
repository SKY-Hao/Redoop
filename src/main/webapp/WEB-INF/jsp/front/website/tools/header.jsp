<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>


<div class="qqTips">
    <div class="slide_min"></div>
    <div class="slide_box" style="display:none;">
        <h2><img src="<%=basePath%>/front/website/css/img/slide_box.jpg" /></h2>
        <p><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1169644787&site=qq&menu=yes">
            <img border="0" src="http://wpa.qq.com/pa?p=2:1169644787:51" alt="点击这里给我发消息" title="点击这里给我发消息"/>
        </a>
        </p>
        <p>
            <img src="<%=basePath%>/front/website/css/img/weixin.png" class="weixin" /><br />
            <b>客户服务热线</b><br />
            400-0389-155
        </p>
    </div>
</div>


<div class="requestTips" id="rt1">
    <div class="slide_min" id="sm1"></div>
    <div class="slide_box" id="sb1" style="display:none;">
        <h2><img src="<%=basePath%>/front/website/css/img/sb1.jpg" /></h2>
        <div class="text">
            <h2>欢迎申请试用Redoop CRH产品!</h2>
            <p>请正确填写以下有效信息并提交，我们将提供Redoop CRH的下载地址。 <br />您也可以通过致电400-0389-155直接与我们联系。</p>
        </div>
        <div class="formCon">
            <p>“<span>*</span>”为必填项</p>
            <form id="__vtigerWebForm" name="官方网站需求表单" action="http://vcrm.redoop.com/modules/Webforms/capture.php" method="post" accept-charset="utf-8" enctype="multipart/form-data">
                <input type="hidden" name="__vtrftk" value="sid:847f1f547721e3fc7ab607b1a21e457ba62eb998,1503549807">
                <input type="hidden" name="publicid" value="10f3500db8d1753bdc5577e6d7ba2f47">
                <input type="hidden" name="urlencodeenable" value="1">
                <input type="hidden" name="name" value="官方网站需求表单">
                <table class="formStyle">
                    <tbody>
                    <tr>
                        <td><label><span>*</span> 姓</label></td>
                        <td><input type="text" name="lastname" data-label="" value="" required=""></td>
                    </tr>
                    <tr>
                        <td><label>名字</label></td>
                        <td><input type="text" name="firstname" data-label="" value=""> </td>
                    </tr>
                    <tr>
                        <td><label><span>*</span> 公司</label></td>
                        <td><input type="text" name="company" data-label="" value="" required=""></td>
                    </tr>
                    <tr>
                        <td><label>职务</label></td>
                        <td><input type="text" name="designation" data-label="" value=""></td>
                    </tr>
                    <tr>
                        <td><label><span>*</span> 手机</label></td>
                        <td><input type="text" name="mobile" data-label="" value="" required=""></td>
                    </tr>
                    <tr>
                        <td><label>常用 Email</label></td>
                        <td><input type="email" name="email" data-label="" value=""></td>
                    </tr>
                    <tr>
                        <td><label>行业</label></td>
                        <td><select name="industry" data-label="industry">
                            <option value="">选择值</option>
                            <option value="Apparel">服饰业</option>
                            <option value="Banking">银行业</option>
                            <option value="Biotechnology">生物技术</option>
                            <option value="Chemicals">化工</option>
                            <option value="Communications">交通</option>
                            <option value="Construction">建筑</option>
                            <option value="Consulting">咨询</option>
                            <option value="Education">教育</option>
                            <option value="Electronics">电子</option>
                            <option value="Energy">能源</option>
                            <option value="Engineering">工程</option>
                            <option value="Entertainment">娱乐</option>
                            <option value="Environmental">环保</option>
                            <option value="Finance">金融</option>
                            <option value="Food &amp; Beverage">食品与饮料</option>
                            <option value="Government">政府</option>
                            <option value="Healthcare">保健</option>
                            <option value="Hospitality">酒店</option>
                            <option value="Insurance">保险</option>
                            <option value="Machinery">机械</option>
                            <option value="Manufacturing">制造</option>
                            <option value="Media">媒体</option>
                            <option value="Not For Profit">非盈利机构</option>
                            <option value="Recreation">娱乐</option>
                            <option value="Retail">零售</option>
                            <option value="Shipping">航运</option>
                            <option value="Technology">科技</option>
                            <option value="Telecommunications">电信</option>
                            <option value="Transportation">运输</option>
                            <option value="Utilities">公共事业</option>
                            <option value="公安">公安</option>
                            <option value="Other">其它</option>
                        </select></td>
                    </tr>
                    <input type="hidden" name="leadsource" value="Web Site">

                    </tbody>
                </table>
                <input type="submit" value="提交申请" style="width:100px; height:25px; background:#cd2017; color:#fff;" />
            </form>
        </div>

    </div>
</div>


<script type="text/javascript" src="<%=basePath%>/front/website/js/jquery-1.11.3.min.js"></script>
<script>
    $(function(){
        var thisBox = $('.qqTips');
        var defaultTop = thisBox.offset().top;
        var slide_min = $('.qqTips .slide_min');
        var slide_box = $('.qqTips .slide_box');
        var closed = $('.qqTips .slide_box h2 img');

        var sm1 = $('#rt1 #sm1');
        var sb1 = $('#rt1 #sb1');

        slide_min.on('click',function(){$(this).hide();sb1.hide();sm1.show();	slide_box.show();});
        closed.on('click',function(){slide_box.hide().hide();slide_min.show();});
        // 页面滚动的同时，悬浮框也跟着滚动
        $(window).on('scroll',function(){scro();});
        $(window).onload = scro();
        function scro(){
            var offsetTop = defaultTop + $(window).scrollTop()+'px';
            thisBox.animate({top:offsetTop},
                {	duration: 600,	//滑动速度
                    queue: false    //此动画将不进入动画队列
                });
        }
    });

    $(function(){
        var box1 = $('#rt1');
        var top1 = box1.offset().top;
        var sm1 = $('#rt1 #sm1');
        var sb1 = $('#rt1 #sb1');

        var slide_min = $('.qqTips .slide_min');
        var slide_box = $('.qqTips .slide_box');

        var closed = $('#rt1 #sb1 h2 img');
        sm1.on('click',function(){$(this).hide();slide_box.hide();slide_min.show();sb1.show();});
        closed.on('click',function(){sb1.hide().hide();sm1.show();});
        // 页面滚动的同时，悬浮框也跟着滚动
        $(window).on('scroll',function(){scro();});
        $(window).onload = scro();
        function scro(){
            var offsetTop = top1 + $(window).scrollTop()+'px';
            box1.animate({top:offsetTop},
                {	duration: 600,	//滑动速度
                    queue: false    //此动画将不进入动画队列
                });
        }
    });
</script>

<header class="header" style="position: fixed;top: 0px;width: 100%;z-index:1;">
    <div class="container clearfix" style="height:auto;">
        <div class="header-r fr">
           <%-- <p><a href="<%=basePath%>/customer/register" target="_blank">注册</a> | <a href="<%=basePath%>/customer/login" target="_blank">登录</a></p>--%>
               <p style="color:#dc0005; font-weight:bold;font-family:tahoma arial;font-size:14px">TEL：400-0389-155</p>
            <ul>
                <li><a href="<%=basePath%>/front/product" class="${product}">产品</a></li>
                <li><a href="<%=basePath%>/front/solution" class="${solution}">行业版本及案例</a></li>
                <li><a href="<%=basePath%>/front/news" class="${news}">新闻</a></li>
                <li><a href="<%=basePath%>/front/download" class="${download}">产品资料</a></li>
                <li><a href="<%=basePath%>/front/partners" class="${partners}">合作伙伴</a></li>
                <li><a href="<%=basePath%>/front/appstore" class="${appstore}">应用商城</a></li>
                <li>
                        <div id="down">
                            <a style="text-decoration: none;">下载</a>
                            <div id="aa" class="nav-nav" style="display: none;">
                                <a class="CRH" href="http://archive.redoop.com" style="border-bottom:1px dashed #4D4D4D" target="_blank">Redoop CRH</a>
                                <a class="AI"  href="http://archive.redoop.com/redoopAI" style="border-bottom:0px dashed #4D4D4D" target="_blank">Redoop AI</a>
                            </div>
                            <%--<div id="aa" class="nav-nav" style="display: none;">
                                <a class="CRH" href="<%=basePath%>/front/redoopCRH" style="border-bottom:1px dashed #4D4D4D">Redoop CRH</a>
                                <a class="AI"  href="<%=basePath%>/front/redoopAI" style="border-bottom:0px dashed #4D4D4D">Redoop AI</a>
                            </div>--%>
                        </div>
                </li>

                <li class="last"><a href="<%=basePath%>/front/aboutus" class="${aboutus}" style="text-decoration: none;">关于我们</a></li>
            </ul>
        </div>
        <div class="header-l fl clearfix">
            <a href="http://www.redoop.com" class="logo fl" title="红象云腾"></a>
            <i title="大数据基础软件旗舰厂商"></i>
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
                $(".AI").mouseover(function(){
                    $(".AI").css("color","red");
                });
                $(".AI").mouseout(function(){
                    $(".AI").css("color","#E9E9E4");
                });
            });
        })

    </script>
</header>

