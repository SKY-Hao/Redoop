<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>${form.id==null?"服务添加":"服务修改"}</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>${form.id==null?"服务添加":"服务修改"}</h5>
            </div>
            <div class="ibox-content">
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${message}
                </div>
                <form action="<%=basePath%>/admin/component/add" class="form-horizontal" method="POST" enctype="multipart/form-data">
                    <c:if test="${form.id != null}">
                        <input type="hidden" name="id" value="${form.id}"/>
                    </c:if>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">服务软件名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="name" value="${form.name}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">服务软件别名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="alias" value="${form.alias}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">服务软件所属</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="subjection" value="${form.subjection}">
                            <span class="help-block m-b-none">服务软件所属机构或公司&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">是否开源</label>
                        <div class="col-sm-4">
                            <label><input name="open" type="radio" value="1" ${form.open=='1' || form.open==null?'checked':''} />开源</label>
                            <label><input name="open" type="radio" value="0" ${form.open=='0'?'checked':''} />不开源</label>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">遵从协议</label>
                        <div class="col-sm-4">
                            <select class="form-control m-b" name="mpl">
                                <option value="1" ${form.mpl=='1'?'selected':''} >Apache1.0</option>
                                <option value="2" ${form.mpl=='2'?'selected':''} >Apache2.0</option>
                            </select>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">服务软件类型</label>
                        <div class="col-sm-4">
                            <select class="form-control m-b" name="type">
                                <option value="0" ${form.type=='0'?'selected':''} >组件</option>
                                <option value="1" ${form.type=='1'?'selected':''} >案例</option>
                                <option value="2" ${form.type=='2'?'selected':''} >行业版本</option>
                            </select>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">服务软件版本</label>
                        <div class="col-sm-4">
                            <select class="form-control m-b" name="version">
                                <option value="CRH5.0" ${form.version=='CRH5.0'?'selected':''} >CRH5.0</option>
                                <option value="CRH4.9" ${form.version=='CRH4.9'?'selected':''} >CRH4.9</option>
                            </select>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">是否显示</label>
                        <div class="col-sm-4">
                            <label><input name="showstate" type="radio" value="0" ${form.showstate=='0' || form.showstate==null?'checked':''} />不显示</label>
                            <label><input name="showstate" type="radio" value="1" ${form.showstate=='1'?'checked':''} />显示</label>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">服务软件存储大小</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="memorysize" value="${form.memorysize}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">服务软件下载地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="downurl" value="${form.downurl}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">服务软件LOGO</label>
                        <div class="col-sm-4">
                            <input type="file" class="form-control" style="height: 38px;" id="logo" name="logo">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">服务软件描述</label>
                        <div class="col-sm-4">
                            <textarea class="form-control" name="description">${form.description}</textarea>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                        <span style="color: #d43f3a;font-size: 16px;">和简报更新概要同步</span>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button class="btn btn-primary" type="submit">保存内容</button>
                            <button class="btn btn-white" type="submit">取消</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
$(function(){
    //点击文件上传跳转

        $("#logo").click(function () {

        });


})

</script>

</html>