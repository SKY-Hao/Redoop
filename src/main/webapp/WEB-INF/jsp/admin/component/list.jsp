<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>服务软件列表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>服务软件列表</h4>
        </div>
        <div>
            <div style="text-align: center;color: red;margin-bottom: 10px;">
                ${message}
            </div>
            <div style="margin-top:8px;margin-bottom: 5px;float: right;">
                <form id="form" action="<%=basePath%>/admin/component/select" method="get">
                    <span>名称查询:<input type="text" name="name" style="width: 100px;" value="${name}">
                        <button id="sub">查询</button>
                    </span>
                </form>
            </div>
        </div>


        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>软件名称</th>
                    <th>缩略图</th>
                    <th>软件别名</th>
                    <th>服务软件类型</th>
                    <th>服务软件所属</th>
                    <th>是否开源</th>
                    <th>所属产品</th>
                    <th>下载量</th>
                    <th>存储大小</th>
                    <th>添加时间</th>
                    <th>添加者</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageList.getContent()}" var="one">
                    <tr>
                        <td><a href="">${one.name}</a></td>
                        <td><img src="<%=basePath%>/${one.picurl}" width="80" height="50"></td>
                        <td>${one.alias}</td>
                        <c:if test="${one.type==0}">
                            <td>组件</td>
                        </c:if>
                        <c:if test="${one.type==1}">
                            <td>案例</td>
                        </c:if>
                        <c:if test="${one.type==2}">
                            <td>行业版本</td>
                        </c:if>
                        <td>${one.subjection}</td>
                       <c:if test="${one.open=='0'}">
                            <td>不开源</td>
                       </c:if>
                        <c:if test="${one.open=='1'}">
                            <td>开源</td>
                        </c:if>
                        <td>${one.version}</td>
                        <td>${one.downloads}</td>
                        <td>${one.memorysize}</td>
                        <td>${one.editdate}</td>
                        <td>${one.additive}</td>

                        <td>
                            <a href="<%=basePath%>/admin/component/form/${one.id}">修改/</a>
                            <a href="<%=basePath%>/admin/component/delete/${one.id}" onclick="return del()">删除/</a>
                            <c:if test="${one.showstate eq 1}"><a href="<%=basePath%>/admin/component/cancelRelease/${one.id}" class="tablelink">取消发布</a></c:if>
                            <c:if test="${one.showstate eq 0}"><a href="<%=basePath%>/admin/component/release/${one.id}" class="tablelink">确认发布</a></c:if>
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

</html>
