<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>合作伙伴详细信息</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>伙伴详细信息</h4>
        </div>

        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th >公司名称</th>
                        <th>${form.companyname}</th>
                    </tr>
                    <tr class="warning">
                        <th>公司logo</th>
                        <th><img src="<%=basePath%>/${form.companypic}" width="80" height="50"></th>
                    </tr>
                    <tr>
                        <th>公司类型</th>
                        <th>
                            <c:if test="${form.companytype==0}">
                                互联网
                            </c:if>
                            <c:if test="${form.companytype==1}">
                                企业应用
                            </c:if>
                        </th>
                    </tr>
                    <tr class="warning">
                        <th>公司电话</th>
                        <th>${form.companytel}</th>
                    </tr>
                    <tr>
                        <th>公司简介</th>
                        <th>
                            <textarea class="form-control" name="testcontent">${form.companyprofile}</textarea>
                        </th>
                    </tr>
                    <tr class="warning">
                        <th>公司地址</th>
                        <th>${form.address}</th>
                    </tr>
                    <tr>
                        <th>公司涉足行业</th>
                        <th>
                            <c:if test="${form.industry==0}">
                                政府/金融
                            </c:if>
                            <c:if test="${form.industry==1}">
                                媒体/酒店
                            </c:if>
                            <c:if test="${form.industry==2}">
                                生物技术/化工
                            </c:if>
                            <c:if test="${form.industry==3}">
                               交通/建筑/工程
                            </c:if>
                            <c:if test="${form.industry==4}">
                                IT/科技/公共事业
                            </c:if>
                            <c:if test="${form.industry==5}">
                               其他
                            </c:if>
                            <c:if test="${form.industry==6}"></c:if>
                        </th>
                    </tr>
                    <tr class="warning">
                        <th>合作伙伴产品名称</th>
                        <th>${form.partnerproduct}</th>
                    </tr>
                    <tr>
                        <th>合作伙伴类型</th>
                        <th>
                            <c:if test="${form.partnertype==0}">
                                硬件厂商
                            </c:if>
                            <c:if test="${form.partnertype==1}">
                                集成厂商
                            </c:if>
                            <c:if test="${form.partnertype==2}">
                                设备厂商
                            </c:if>
                            <c:if test="${form.partnertype==3}">
                                软件合作厂商
                            </c:if>
                            <c:if test="${form.partnertype==4}">
                                基础软件厂商
                            </c:if>
                            <c:if test="${form.partnertype==5}">
                                应用软件厂商
                            </c:if>
                            <c:if test="${form.partnertype==6}"></c:if>
                        </th>
                    </tr>
                    <tr class="warning">
                        <th>合作伙伴产品版本</th>
                        <th>${form.partnerversion}</th>
                    </tr>
                    <tr>
                        <th>合作伙伴意向</th>
                        <th>
                            <c:if test="${form.intention==0}">
                                展示
                            </c:if>
                            <c:if test="${form.intention==1}">
                                不展示
                            </c:if>
                        </th>
                    </tr>
                    <tr>
                        <th>申请时间</th>
                        <th>${form.applicationtime}</th>
                    </tr>
                    <tr class="warning">
                        <th>联系人名字</th>
                        <th>${form.contactsname}</th>
                    </tr>
                    <tr>
                        <th>联系电话</th>
                        <th>${form.contactstel}</th>
                    </tr>
                    <tr class="warning">
                        <th>联系邮箱</th>
                        <th>${form.contactsemail}</th>
                    </tr>
                    <tr>
                        <th>审核人</th>
                        <th>${form.auditor}</th>
                    </tr>
                    <tr class="warning">
                        <th>审核时间</th>
                        <th>${form.auditortime}</th>
                    </tr>
                    <tr>
                        <th>审核结果</th>
                        <th>
                            <c:if test="${form.auditoresult==0}">
                                审核
                            </c:if>
                            <c:if test="${form.auditoresult==1}">
                                未审核
                            </c:if>
                        </th>
                    </tr>
                    <tr class="warning">
                        <th>测试版本(CRH测试版本</th>
                        <th>
                            <c:if test="${form.testversion=='CRH5.0'}">
                                CRH5.0
                            </c:if>
                            <c:if test="${form.testversion=='CRH4.9'}">
                                CRH4.9
                            </c:if>
                            <c:if test="${form.testversion=='暂无'}">
                                暂无
                            </c:if>
                        </th>
                    </tr>
                    <tr>
                        <th>测试内容</th>
                        <th>
                            <textarea class="form-control" name="testcontent">${form.testcontent}</textarea>
                        </th>
                    </tr>
                    <tr class="warning">
                        <th>测试结果</th>
                        <th>
                            <c:if test="${form.testresult==0}">
                                通过
                            </c:if>
                            <c:if test="${form.testresult==1}">
                               未通过
                            </c:if>
                        </th>
                    </tr>
                    <tr>
                        <th>测试时间</th>
                        <th>${form.testtime}</th>
                    </tr>
                    <tr class="warning">
                        <th>认证结果</th>
                        <th>
                            <c:if test="${form.authentication==0}">
                                已认证
                            </c:if>
                            <c:if test="${form.authentication==1}">
                                未认证
                            </c:if>
                        </th>
                    </tr>
                </thead>
            </table>
            <a href="<%=basePath%>/admin/partner/findAll">
                <button class="btn btn-danger" type="button">返回</button>
            </a>
        </div>
    </div>

</div>

</body>