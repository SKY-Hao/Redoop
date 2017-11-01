<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>简报7天表</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
    <script type="text/javascript" src="<%=basePath%>/backstage/My97DatePicker/WdatePicker.js"></script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>简报7天表</h4>
        </div>
        <form method="post" action="<%=basePath%>/admin/messBriefing/lastAdd">
            <div>
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${message}
                </div>
                <div style="float: right">
                    <input type="submit" id="but"class="btn btn-info" value="生成简报">
                </div>
            </div>
            <div class="ibox-content">
                <table class="table table-bordered table-striped" >
                    <thead>
                    <tr>
                        <th>
                            <input type="checkbox" id="qx">全选/反选
                        </th>

                        <th>tableID</th>
                        <th>类目</th>
                        <th>标题</th>
                        <th>更新概要</th>
                        <th>发布者</th>
                        <th>更新时间</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="mess">
                            <tr>
                                <td>
                                    <input type="checkbox" value="${mess.id}" name="ids">
                                </td>
                                <td>${mess.tableid}</td>
                                <td>${mess.tablename}</td>
                                <td>${mess.title}</td>
                                <td>${mess.outline}</td>
                                <td>${mess.author}</td>
                                <td>${mess.authortime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
 </div>
</div>

</body>
<script type="text/javascript">
    $(function () {
        //全选反选
        $("#qx").click(function () {
            var ids = document.getElementsByName("ids");
            for(var i=0;i<ids.length;i++){
                if(ids[i].checked) {
                    ids[i].checked = false;
                }
                else{
                    ids[i].checked=true;
                }
            }
        });
    })
</script>
</html>
