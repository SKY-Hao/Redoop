<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>${form.id==null?"合作伙伴添加":"合作伙伴修改"}</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
    <script type="text/javascript" src="<%=basePath%>/backstage/My97DatePicker/WdatePicker.js"></script>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>${form.id==null?"合作伙伴添加":"合作伙伴修改"}</h5>
            </div>
            <div class="ibox-content">
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${message}
                </div>
                <h4><span style="color: #d43f3a;font-size: 16px;">*</span>为必填项</h4>
                <form action="<%=basePath%>/admin/partner/add" class="form-horizontal" method="POST" enctype="multipart/form-data">
                    <c:if test="${form.id != null}">
                        <input type="hidden" name="id" value="${form.id}"/>
                    </c:if>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="companyname" value="${form.companyname}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                        <span style="color: #d43f3a;font-size: 16px;">(官网公司名称)</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司LOGO</label>
                        <div class="col-sm-4">
                            <input type="file" class="form-control" style="height: 38px;" id="logo" name="logo">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                        <span style="color: #d43f3a;font-size: 16px;">(官网公司logo)</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司电话</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="companytel" value="${form.companytel}">
                        </div>
                        <%--<span style="color: #d43f3a;font-size: 16px;">*</span>--%>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司简介</label>
                        <div class="col-sm-4">
                            <textarea class="form-control" name="companyprofile">${form.companyprofile}</textarea>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                        <span style="color: #d43f3a;font-size: 16px;">(官网公司简介)</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="address" value="${form.address}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司类型</label>
                        <div class="col-sm-4">
                            <select class="form-control m-b" name="companytype">
                                <option value="0" ${form.companytype=='0'?'selected':''} >互联网</option>
                                <option value="1" ${form.companytype=='1'?'selected':''} >企业应用</option>
                            </select>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司涉足行业</label>
                        <div class="col-sm-4">
                            <select class="form-control m-b" name="industry">
                                <option value="6" ${form.industry=='6'?'selected':''} ></option>
                                <option value="0" ${form.industry=='0'?'selected':''} >政府/金融</option>
                                <option value="1" ${form.industry=='1'?'selected':''} >媒体/酒店</option>
                                <option value="2" ${form.industry=='2'?'selected':''} >生物技术/化工</option>
                                <option value="3" ${form.industry=='3'?'selected':''} >交通/建筑/工程</option>
                                <option value="4" ${form.industry=='4'?'selected':''} >IT/科技/公共事业</option>
                                <option value="5" ${form.industry=='5'?'selected':''} >其他</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">合作伙伴类型</label>
                        <div class="col-sm-4">
                            <select class="form-control m-b" name="partnertype">
                                <option value="6" ${form.partnertype=='6'?'selected':''} ></option>
                                <option value="0" ${form.partnertype=='0'?'selected':''} >硬件厂商</option>
                                <option value="1" ${form.partnertype=='1'?'selected':''} >集成厂商</option>
                                <option value="2" ${form.partnertype=='2'?'selected':''} >设备厂商</option>
                                <option value="3" ${form.partnertype=='3'?'selected':''} >软件合作厂商</option>
                                <option value="4" ${form.partnertype=='4'?'selected':''} >基础软件厂商</option>
                                <option value="5" ${form.partnertype=='5'?'selected':''} >应用软件厂商</option>
                            </select>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                        <span style="color: #d43f3a;font-size: 16px;">(官网搜索的厂商)</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">测试版本(CRH测试版本)</label>
                        <div class="col-sm-4">
                            <select class="form-control m-b" name="testversion">
                                <option value="CRH5.0" ${form.testversion=='CRH5.0'?'selected':''} >CRH5.0</option>
                                <option value="CRH4.9" ${form.testversion=='CRH4.9'?'selected':''} >CRH4.9</option>
                                <option value="暂无" ${form.testversion=='暂无'?'selected':''} >暂无</option>
                            </select>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">(官网Redoop测试版本)</span>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-2 control-label">联系人名字</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="contactsname" value="${form.contactsname}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">联系人电话</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="contactstel" value="${form.contactstel}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">联系人邮箱</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="contactsemail" value="${form.contactsemail}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">审核结果</label>
                        <div class="col-sm-4">
                            <label><input name="auditoresult" type="radio" value="0" ${form.auditoresult=='0'?'checked':''} />审核</label>
                            <label><input name="auditoresult" type="radio" value="1" ${form.auditoresult=='1' || form.auditoresult==null?'checked':''} />未审核</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">认证结果</label>
                        <div class="col-sm-4">
                            <label><input name="authentication" type="radio" value="0" ${form.authentication=='0'?'checked':''} />认证</label>
                            <label><input name="authentication" type="radio" value="1" ${form.authentication=='1' || form.authentication==null?'checked':''} />未认证</label>
                        </div>
                    </div>


                <!--多个-->
                    <div class="form-group">
                        <label class="col-sm-2 control-label">合作伙伴产品名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="partnerproduct" value="${form.partnerproduct}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                        <span style="color: #d43f3a;font-size: 16px;">(官网合作伙伴产品名)</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">合作伙伴产品版本</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="partnerversion" value="${form.partnerversion}">
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                        <span style="color: #d43f3a;font-size: 16px;">(官网合作伙伴产品版本)</span>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-2 control-label">测试内容</label>
                        <div class="col-sm-4">
                            <textarea class="form-control" name="testcontent">${form.testcontent}</textarea>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                        <span style="color: #d43f3a;font-size: 16px;">(官网测试内容)</span>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">测试时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="testtime" value="${form.testtime}" onclick="WdatePicker()">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="margin-top: 5px;">测试结果</label>
                        <div class="col-sm-4" >
                            <label ><input name="testresult" type="radio" value="0" ${form.testresult=='0'?'checked':''} />通过</label>
                            <label ><input name="testresult" type="radio" value="1" ${form.testresult=='1' || form.testresult==null?'checked':''} />未通过</label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-2 control-label">合作伙伴概要(大概内容:简单,明了)</label>
                        <div class="col-sm-4">
                            <textarea class="form-control" name="outline">${form.outline}</textarea>
                        </div>
                        <span style="color: #d43f3a;font-size: 16px;">*</span>
                        <span style="color: #d43f3a;font-size: 16px;">和简报更新概要同步</span>
                    </div>



                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button class="btn btn-primary" type="submit">保存内容</button>
                            <a href="<%=basePath%>/admin/partner/list">
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