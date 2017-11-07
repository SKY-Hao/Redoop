<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>列表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
    <script type="text/javascript" src="<%=basePath%>/backstage/My97DatePicker/WdatePicker.js"></script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>列表表</h4>
        </div>
        <div>
            <div style="text-align: center;color: red;margin-bottom: 10px;">
                ${message}
            </div>
        </div>

            <div class="ibox-content">
                <table class="table table-bordered table-striped" style="table-layout: fixed;">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>部门</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pageList}" var="mess">
                            <tr>
                                <td>${mess.id}</td>
                                <td>${mess.name}</td>
                                <td>${mess.sex}</td>
                                <td>${mess.dept}</td>
                                <td>
                                   <%-- <a href="<%=basePath%>/front/onenew/${mess.id}" target="_blank" class="tablelink">预览</a>--%>
                                   <%-- <a href="<%=basePath%>/admin/mess/form/${mess.id}" class="tablelink">修改</a>--%>
                                     <%--<c:if test="${mess.state eq 1}"><a href="<%=basePath%>/admin/mess/cancelRelease/${mess.id}" class="tablelink">取消发布</a></c:if>
                                    <c:if test="${mess.state eq 0}"><a href="<%=basePath%>/admin/mess/release/${mess.id}" class="tablelink">发布</a></c:if>--%>
                                    <a href="<%=basePath%>/admin/mess/delete/${mess.id}" class="tablelink" onclick="return del()">删除</a>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>


 </div>
</div>

</body>

</html>
