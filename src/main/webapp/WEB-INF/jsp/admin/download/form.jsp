<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>${form.id==null?"CRH&AI下载添加":"CRH&AI下载修改"}</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>

    <script type="text/javascript" src="<%=basePath%>/backstage/My97DatePicker/WdatePicker.js"></script>
    <link href="<%=basePath%>/backstage/makedown/css/editormd.min.css" rel="stylesheet">
    <script src="<%=basePath%>/backstage/makedown/js/editormd.min.js"></script>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>${form.id==null?"CRH&AI下载添加":"CRH&AI下载修改"}</h5>
            </div>
            <div class="ibox-content">
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${message}
                </div>
                <h4><span style="color: #d43f3a;font-size: 16px;">*</span>为必填项</h4>
                <form action="<%=basePath%>/admin/download/add" class="form-horizontal" method="POST" enctype="multipart/form-data">

                    <c:if test="${form.id != null}">
                        <input type="hidden" name="id" value="${form.id}"/>
                    </c:if>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">产品类型</label>
                        <div class="col-sm-4">
                            <select class="form-control m-b" name="producttype">
                                <option value="0" ${form.producttype=='0'?'selected':''} >CRH</option>
                                <option value="1" ${form.producttype=='1'?'selected':''} >AI</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">平台类型</label>
                        <div class="col-sm-4">
                            <select class="form-control m-b" name="platformtype">
                                <option value="0" ${form.platformtype=='0'?'selected':''} >X64</option>
                                <option value="1" ${form.platformtype=='1'?'selected':''} >OpenPower</option>
                                <option value="2" ${form.platformtype=='2'?'selected':''} >ARM/飞腾</option>
                                <option value="3" ${form.platformtype=='3'?'selected':''} >申威</option>
                                <option value="4" ${form.platformtype=='4'?'selected':''} >龙芯</option>
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-2 control-label">产品发布时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="producttime" value="${form.producttime}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>



                    <div class="form-group">
                        <label class="col-sm-2 control-label">文档名称(操作系统名称)</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="documentname" value="${form.documentname}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-2 control-label">操作系统编号(版本)</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="sysversion" value="${form.sysversion}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">文档(下载)地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="documenturl" value="${form.documenturl}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">支持的系统图片</label>
                        <div class="col-sm-4">
                            <input type="file" class="form-control" style="height: 38px;" name="logo">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">支持的芯片图片</label>
                        <div class="col-sm-4">
                            <input type="file" class="form-control" style="height: 38px;" name="logo">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-2 control-label">下载概要(大概内容:简单,明了)</label>
                        <div class="col-sm-4">
                            <textarea class="form-control" name="outline">${form.outline}</textarea>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                        <span style="color: #d43f3a;font-size: 16px;">和简报更新概要同步</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">详情文档</label>
                        <div class="col-sm-4" id="editormd-content">
                            <textarea class="editormd-markdown-textarea" name="content">${form.content}</textarea>
                            <textarea class="editormd-html-textarea" name="htmlcontent">${form.htmlcontent}</textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button class="btn btn-primary" type="submit">保存内容</button>
                            <a href="<%=basePath%>/admin/download/findAll">
                                <button class="btn btn-white" type="button">取消</button>
                            </a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>

    $(function(){
        editormd({
            id:"editormd-content",
            width:"80%",
            height: 300,
            syncScrolling : "single",
            path: "<%=basePath%>/backstage/makedown/lib/",
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "<%=basePath%>/upload/uploadfile",
            emoji:true,
            previewTheme : "dark",
            saveHTMLToTextarea : true
        });
    });

</script>
</html>