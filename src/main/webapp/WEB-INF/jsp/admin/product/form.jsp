<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>${form.id==null?"产品资料添加":"产品资料下载修改"}</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
    <script type="text/javascript" src="<%=basePath%>/backstage/My97DatePicker/WdatePicker.js"></script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>${form.id==null?"产品资料下载添加":"产品资料下载修改"}</h5>
            </div>
            <div class="ibox-content">
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${message}
                </div>
                <h4><span style="color: #d43f3a;font-size: 16px;">*</span>为必填项</h4>
                <form action="<%=basePath%>/admin/product/add" class="form-horizontal" method="POST" enctype="multipart/form-data">
                    <c:if test="${form.id != null}">
                        <input type="hidden" name="id" value="${form.id}"/>
                    </c:if>

                     <div class="form-group">
                          <label class="col-sm-2 control-label">文档类型</label>
                          <div class="col-sm-4">
                              <select class="form-control m-b" name="producttype">
                                  <option value="0" ${form.producttype=='0'?'selected':''} >产品文档</option>
                                  <option value="1" ${form.producttype=='1'?'selected':''} >产品技术文档</option>
                                  <option value="2" ${form.producttype=='2'?'selected':''} >测试报告</option>
                              </select>
                          </div>
                      </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">文档名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="productname" value="${form.productname}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">文档(下载)地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="producturl" value="${form.producturl}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>



                    <div class="form-group">
                        <label class="col-sm-2 control-label">文档发布时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="producttime" value="${form.producttime}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">文档概要</label>
                        <div class="col-sm-4">
                            <textarea type="text" class="form-control" name="outline">${form.outline}</textarea>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                        <span style="color: #d43f3a;font-size: 16px;">和简报更新概要同步</span>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button class="btn btn-primary" type="submit">保存内容</button>
                            <a href="<%=basePath%>/admin/product/findAll">
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

</html>