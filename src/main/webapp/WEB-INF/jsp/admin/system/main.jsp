<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <!-- 图标库地址 icon: http://holdirbootstrap.de/komponenten/ -->
    <title>Main</title>
    <meta charset="utf-8">
    <link href="<%=basePath%>backstage/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>backstage/css/styles.css" rel="stylesheet">
    <script src="<%=basePath%>backstage/js/jquery-1.11.1.min.js"></script>
    <script src="<%=basePath%>backstage/js/bootstrap.min.js"></script>

</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
<!--导航-->
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span>Redoop-</span>管理系统</a>
            <ul class="user-menu">
                <li class="dropdown pull-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                            class="glyphicon glyphicon-user"></span> Admin <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-cog"></span> 设置</a></li>
                        <li><a href="<%=basePath%>admin/logout"><span class="glyphicon glyphicon-log-out"></span> 注销</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div><!-- /.container-fluid -->
</nav>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <ul class="nav menu">
        <li class="active"><a href="<%=basePath%>admin/new/findAll" target="main"><span
                class="glyphicon glyphicon-dashboard"></span>Dashboard</a></li>



        <!--网站管理模块-->
        <li class="parent">
            <a href="#sub-item-1" data-toggle="collapse">
                <span class="glyphicon glyphicon-globe"></span>网站管理
            </a>
            <ul class="children collapse" id="sub-item-1">
                <!--新闻管理-->
                <li class="parent">
                    <a href="#sub-item-2" data-toggle="collapse">
                        <span class="glyphicon glyphicon-book"></span>新闻模块
                    </a>
                    <ul class="children collapse" id="sub-item-2">
                        <li class="item">
                            <a href="<%=basePath%>admin/new/findAll" target="main">
                                <span class="glyphicon glyphicon-list-alt"></span>新闻列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>admin/new/form/null" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>新闻添加
                            </a>
                        </li>
                    </ul>
                </li>
                <!--方案管理-->
                <li class="parent">
                    <a href="#sub-item-3" data-toggle="collapse">
                        <span class="glyphicon glyphicon-folder-close"></span>行业版本及案例
                    </a>
                    <ul class="children collapse" id="sub-item-3">
                        <li class="item">
                            <a href="<%=basePath%>admin/solution/findAll" target="main">
                                <span class="glyphicon glyphicon-calendar"></span>行业版本|案例列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>admin/solution/form/null" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>行业版本|案例添加
                            </a>
                        </li>
                    </ul>
                </li>
                <!--案例管理-->
                <%--<li class="parent">
                    <a href="#sub-item-4" data-toggle="collapse">
                        <span class="glyphicon glyphicon-briefcase"></span>案例模块
                    </a>
                    <ul class="children collapse" id="sub-item-4">
                        <li class="item">
                            <a href="<%=basePath%>admin/system/case/list" target="main">
                                <span class="glyphicon glyphicon-align-center"></span>案例列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>admin/system/case/form/null" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>案例添加
                            </a>
                        </li>
                    </ul>
                </li>
--%>
                <!--合作伙伴管理-->
                <li class="parent">
                    <a href="#sub-item-5" data-toggle="collapse">
                        <span class="glyphicon glyphicon-user"></span>合作伙伴
                    </a>
                    <ul class="children collapse" id="sub-item-5">
                        <li class="item">
                            <a href="<%=basePath%>admin/partner/findAll" target="main">
                                <span class="glyphicon glyphicon-th-list"></span>伙伴列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>admin/partner/form/null" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>伙伴添加
                            </a>
                        </li>
                        <li class="item" style="display: none;">
                           <%-- <a href="<%=basePath%>admin/partner/detailed" target="main">
                                <span class="glyphicon glyphicon-send"></span>伙伴详情
                            </a>--%>
                            <a href="javascript:void(0)" id="ts" target="main">
                                <span class="glyphicon glyphicon-send"></span>伙伴详情
                            </a>
                        </li>
                    </ul>
                </li>

                <!--下载管理-->
                <li class="parent">
                    <a href="#sub-item-6" data-toggle="collapse">
                        <span class="glyphicon glyphicon-download-alt"></span>下&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;载
                    </a>
                    <ul class="children collapse" id="sub-item-6">
                        <li class="item">
                            <a href="<%=basePath%>admin/download/findAll" target="main">
                                <span class="glyphicon glyphicon-th-list"></span>下载列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>admin/download/form/null" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>下载添加
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="parent">
                    <a href="#sub-item-7" data-toggle="collapse">
                        <span class="glyphicon glyphicon-list-alt"></span>产品资料
                    </a>
                    <ul class="children collapse" id="sub-item-7">
                        <li class="item">
                            <a href="<%=basePath%>admin/product/findAll" target="main">
                                <span class="glyphicon glyphicon-th-list"></span>资料列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>admin/product/form/null" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>资料添加
                            </a>
                        </li>
                    </ul>
                </li>
                <!--简报-->
                <li class="parent">
                    <a href="#sub-item-8" data-toggle="collapse">
                        <span class="glyphicon glyphicon-list-alt"></span>简报更新
                    </a>
                    <ul class="children collapse" id="sub-item-8">
                        <li class="item">
                            <a href="<%=basePath%>admin/mess/findAll" target="main">
                                <span class="glyphicon glyphicon-th-list"></span>简报列表
                            </a>
                        </li>
                        <%--<li class="item">
                            <a href="<%=basePath%>admin/mess/form/null" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>简报添加
                            </a>
                        </li>--%>
                    </ul>
                </li>
            </ul>
        </li>


        <!--应用商店管理模块-->
        <li class="parent ">
            <a href="#sub-item-11" data-toggle="collapse">
                <span class="glyphicon glyphicon-tint"></span>APP管理
            </a>
            <ul class="children collapse" id="sub-item-11">
                <!--服务管理-->
                <li class="parent">
                    <a href="#sub-item-12" data-toggle="collapse">
                        <span class="glyphicon glyphicon-bookmark"></span>服务模块
                    </a>
                    <ul class="children collapse" id="sub-item-12">
                        <li class="item">
                            <a href="<%=basePath%>admin/component/findAll" target="main">
                                <span class="glyphicon glyphicon-list"></span>服务列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>admin/component/form/null" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>服务添加
                            </a>
                        </li>
                    </ul>
                </li>
                <!--客户管理-->
                <li class="parent">
                    <a href="#sub-item-13" data-toggle="collapse">
                        <span class="glyphicon glyphicon-user"></span>客户模块
                    </a>
                    <ul class="children collapse" id="sub-item-13">
                        <li class="item">
                            <a href="<%=basePath%>admin/customer/list" target="main">
                                <span class="glyphicon glyphicon-tasks"></span>客户列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>admin/customer/add" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>客户添加
                            </a>
                        </li>
                    </ul>
                </li>

            </ul>
        </li>


        <!--License授权管理模块-->
        <li class="parent">
            <a href="#sub-item-21" data-toggle="collapse">
                <span class="glyphicon glyphicon-lock"></span>授权管理
            </a>
            <ul class="children collapse" id="sub-item-21">
                <!--授权管理-->
                <li class="parent">
                    <a href="#sub-item-22" data-toggle="collapse">
                        <span class="glyphicon glyphicon-th"></span>授权模块
                    </a>
                    <ul class="children collapse" id="sub-item-22">
                        <li class="item">
                            <a href="<%=basePath%>admin/license/list" target="main">
                                <span class="glyphicon glyphicon-list-alt"></span>授权列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>front/license" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>授权添加
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>


        <!--系统管理模块-->
        <li class="parent">
            <a href="#sub-item-31" data-toggle="collapse">
                <span class="glyphicon glyphicon-cog"></span>系统管理
            </a>
            <ul class="children collapse" id="sub-item-31">
                <!--服务管理-->
                <li class="parent">
                    <a href="#sub-item-32" data-toggle="collapse">
                        <span class="glyphicon glyphicon-tag"></span>标签模块
                    </a>
                    <ul class="children collapse" id="sub-item-32">
                        <li class="item">
                            <a href="<%=basePath%>admin/system/tag/list" target="main">
                                <span class="glyphicon glyphicon-tasks"></span>标签列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>admin/system/tag/form/null" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>标签添加
                            </a>
                        </li>
                    </ul>
                </li>
                <!--客户管理-->
                <li class="parent">
                    <a href="#sub-item-33" data-toggle="collapse">
                        <span class="glyphicon glyphicon-picture"></span>图片模块
                    </a>
                    <ul class="children collapse" id="sub-item-33">
                        <li class="item">
                            <a href="<%=basePath%>admin/system/picture/list" target="main">
                                <span class="glyphicon glyphicon-list"></span>图片列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>admin/system/picture/form/null" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>图片添加
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="parent">
                    <a href="#sub-item-34" data-toggle="collapse">
                        <span class="glyphicon glyphicon-user"></span>用户模块
                    </a>
                    <ul class="children collapse" id="sub-item-34">
                        <li class="item">
                            <a href="<%=basePath%>admin/system/user/list" target="main">
                                <span class="glyphicon glyphicon-list"></span>用户列表
                            </a>
                        </li>
                        <li class="item">
                            <a href="<%=basePath%>admin/system/user/add" target="main">
                                <span class="glyphicon glyphicon-plus-sign"></span>用户添加
                            </a>
                        </li>
                    </ul>
                </li>

            </ul>
        </li>

    </ul>
</div><!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">

    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
        </ol>
    </div>

    <iframe src="<%=basePath%>admin/new/findAll" name="main" frameborder="0" scrolling="auto" style="width: 100%;height: 700px;"></iframe>
</div>
</body>
<script>
    $("#ts").click(function () {
        alert("抱歉,伙伴信息不能查看")
    })
</script>
</html>