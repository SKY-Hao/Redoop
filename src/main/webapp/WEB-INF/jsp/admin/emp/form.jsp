<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>${form.id==null?"添加":"修改"}</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>${form.id==null?"添加":"修改"}</h5>
            </div>
            <div class="ibox-content">
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${message}
                </div>
                <form action="<%=basePath%>/admin/mess/save" id="itemAddForm" class="form-horizontal" method="post" enctype="multipart/form-data">
                    <c:if test="${form.id != null}">
                        <input type="hidden" name="id" value="${form.id}"/>
                    </c:if>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户姓名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="name" value="${form.name}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户年龄</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="age" value="${form.age}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">所在部门</label>
                        <div class="col-sm-4">
                            <select name="dept.id">
                                <option value="">请选择部门</option>
                                <c:forEach items="${list }" var="d">
                                    <option value="${d.id }">${d.name}</option>
                                </c:forEach>
                            </select>
                        </div>
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



</html>