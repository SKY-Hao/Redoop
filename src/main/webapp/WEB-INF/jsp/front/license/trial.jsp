<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>试用版申请</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>

</head>

<body class="gray-bg">
<script>${message}</script>
    <div style="width:50%; height:auto; margin-left: auto;margin-right: auto;margin-top: 80px;min-width: 900px;" >
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="ibox float-e-margins" >
                    <div class="ibox-title" style="text-align:center; height: 80px;font-size: 24px;line-height: 50px;border-bottom: 1px solid #DEE5E7;" >
                        申请试用许可注册文件
                    </div>
                    <div class="ibox-content" style="width: 80%; margin-left: auto;margin-right: auto; border: none;">
                         <div style="text-align: center;color: red;margin-bottom: 10px;">
                            ${errorMessage}
                        </div>
                        <form action="<%=basePath%>/front/license/register" class="form-horizontal" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="version" value="0">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">公司名称</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="company" value="${form.company}">
                                    <span class="help-block m-b-none">申请试用许可的公司名称&nbsp;&nbsp;<b style="color: red;">*</b></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">项目名称</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control"  name="project" value="${form.project}">
                                    <span class="help-block m-b-none">申请试用许可的项目&nbsp;&nbsp;<b style="color: red;">*</b></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">申请人邮箱</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="email" value="${form.email}">
                                    <span class="help-block m-b-none">申请人联系邮箱&nbsp;&nbsp;<b style="color: red;">*</b></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">试用产品</label>
                                <div class="col-sm-10">
                                    <select class="form-control m-b" name="products">
                                        <option value="CRH4.9" <c:if test="${form.products =='CRH4.9'}">selected</c:if>>CRH4.9</option>
                                        <option value="CRH5.0" <c:if test="${form.products =='CRH5.0'}">selected</c:if>>CRH5.0</option>
                                    </select>
                                    <span class="help-block m-b-none">申请试用产品的版本&nbsp;&nbsp;<b style="color: red;">*</b></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">试用节点</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="node" value="1" id="node">
                                    <span class="help-block m-b-none">申请试用节点数（不能大于10个）</span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">注册文件</label>&nbsp;&nbsp;&nbsp;
                                <div class="logo">上载注册文件
                                    <input type="file" name="file" placeholder="请上传注册文件"/>
                                </div>
                                <div class="logo" style="font-size: 14px; background:none;border:none;color:#406026;">
                                    注册文件为集群管理界面>许可证>导出注册信息.&nbsp;
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">保存内容</button>
                                   <button class="btn btn-primary" type="reset">取消</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
