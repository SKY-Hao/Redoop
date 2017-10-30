<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>合作伙伴列表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>合作伙伴列表</h4>
        </div>
        <div>
            <div style="text-align: center;color: red;margin-bottom: 10px;">
                ${message}
            </div>
            <div style="margin-top:8px;margin-bottom: 5px;float: right;">
                <form id="form" action="<%=basePath%>/admin/partner/select" method="GET">
                    <span>公司名称查询:<input type="text" name="companyname" style="width: 100px;" value="${companyname}">
                        <button id="sub">查询</button>
                    </span>
                </form>
            </div>
        </div>


        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>公司名称</th>
                        <th>公司logo</th>
                        <th>公司类型</th>
                       <%-- <th>合作伙伴产品名称</th>
                        <th>合作伙伴产品类型</th>--%>
                        <th>联系名字</th>
                        <th>联系电话</th>
                        <th>联系邮箱</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageList.getContent()}" var="one">
                        <td><a href="<%=basePath%>/admin/partner/detailed/${one.id}">${one.companyname} </a></td>
                        <td><img src="<%=basePath%>/${one.companypic}" width="80" height="50"></td>
                        <c:if test="${one.companytype==0}">
                            <td>互联网</td>
                        </c:if>
                        <c:if test="${one.companytype==1}">
                            <td>企业应用</td>
                        </c:if>
                        <%--<td>${one.partnerproduct}</td>
                        <c:if test="${one.partnertype==0}">
                            <td>硬件厂商</td>
                        </c:if>
                        <c:if test="${one.partnertype==1}">
                            <td>集成厂商</td>
                        </c:if>
                        <c:if test="${one.partnertype==2}">
                            <td>设备厂商</td>
                        </c:if>
                        <c:if test="${one.partnertype==3}">
                            <td>软件合作厂商</td>
                        </c:if>
                        <c:if test="${one.partnertype==4}">
                            <td>基础软件厂商</td>
                        </c:if>
                        <c:if test="${one.partnertype==5}">
                            <td>应用软件厂商</td>
                        </c:if>
                        <c:if test="${one.partnertype==6}">
                            <td></td>
                        </c:if>--%>
                        <td>${one.contactsname}</td>
                        <td>${one.contactstel}</td>
                        <td>${one.contactsemail}</td>
                        <td>${one.applicationtime}</td>

                    <td>
                            <a href="<%=basePath%>/admin/partner/form/${one.id}">修改/</a>
                            <a href="<%=basePath%>/admin/partner/delete/${one.id}" onclick="return del()">删除/</a>
                            <a href="<%=basePath%>/admin/partner/detailed/${one.id}">查看/</a>
                            <c:if test="${one.authentication==0}"><a
                                    href="<%=basePath%>/admin/partner/authenticationYRZ/${one.id}"
                                    onclick="return startYRZ()">已认证/</a>
                            </c:if>
                            <c:if test="${one.authentication==1}"><a
                                    href="<%=basePath%>/admin/partner/authenticationWRZ/${one.id}"
                                    onclick="return startWRZ()">未认证/</a>
                            </c:if>
                        <c:if test="${one.intention eq 0}"><a href="<%=basePath%>/admin/partner/release/${one.id}" class="tablelink">取消发布</a></c:if>
                        <c:if test="${one.intention eq 1}"><a href="<%=basePath%>/admin/partner/cancelRelease/${one.id}" class="tablelink">确认发布</a></c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <jsp:include page="../../tools/page/admin_page.jsp"></jsp:include>
        </div>
    </div>

</div>

</body>