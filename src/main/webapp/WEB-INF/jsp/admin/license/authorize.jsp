<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

<head>
    <title>授权信息修改</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>正式版授权</h5>
            </div>
            <div class="ibox-content">
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${errorMessage}
                </div>
                <form action="<%=basePath%>/admin/license/authorize" class="form-horizontal" method="POST">
                    <input type="hidden" name="id" value="${form.id}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-10"><span style="color: red;">授权完成则不能修改，请确认信息无误！需要修改则返回修改</span></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">申请授权公司</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="company" value="${form.company}" disabled/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">申请授权项目</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="project" value="${form.project}" disabled/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">申请授权邮箱</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="email" value="${form.email}" disabled/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">申请授权产品</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="products" value="${form.products}" disabled/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">申请授权时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="products" value="${form.createDate}" disabled/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">已经试用次数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="products" value="${form.trials}" disabled/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">申请授权节点</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="node" value="${form.node}" disabled>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">是否允许替换Logo</label>
                        <div class="col-sm-10">
                            &nbsp;<input type="radio" name="allowPic" value="1" checked/>是
                            &nbsp;&nbsp;<input type="radio" name="allowPic" value="0" />否
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">授权有效期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="vaildDays" value="<c:if test='${form.vaildDays !=0}'>${form.vaildDays}</c:if>" placeholder="授权有效期为天数,为大于0的数字,默认为30">
                        </div>
                    </div>

                    <%--<div class="form-group">
                        <label class="col-sm-2 control-label">授权组件</label>
                        <div class="col-sm-10">
                            <c:forEach items="${list}" var="name">
                                &nbsp;&nbsp;<input type="checkbox" name="services" value="${form.services}">${name}
                            </c:forEach>

                        </div>
                    </div>--%>


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