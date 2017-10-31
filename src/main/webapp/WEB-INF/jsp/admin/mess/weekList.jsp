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
        <%--<form method="post" action="" id="f1">--%>
            <div>
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${message}
                </div>
                <div style="float: right">
                    <input type="button" class="btn btn-info" value="生成简报">
                </div>
            </div>
            <div class="ibox-content">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>
                            <input type="checkbox" id="qx">全选/反选
                        </th>
                        <th>类目</th>
                        <th>标题</th>
                        <th>更新概要</th>
                        <th>发布者</th>
                        <th>更新时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="mess">
                            <tr>
                                <td>
                                    <input type="checkbox" value="${mess.id}" name="ids" class="ck">
                                </td>
                                <td style="display: none;">${mess.id}</td>
                                <td>${mess.tablename}</td>
                                <td>${mess.title}</td>
                                <td>${mess.outline}</td>
                                <td>${mess.author}</td>
                                <td>${mess.authortime}</td>
                                <td>
                                   <%-- <a href="<%=basePath%>/front/onenew/${mess.id}" target="_blank" class="tablelink">预览</a>--%>
                                   <%-- <a href="<%=basePath%>/admin/mess/form/${mess.id}" class="tablelink">修改</a>--%>
                                     <%--<c:if test="${mess.state eq 1}"><a href="<%=basePath%>/admin/mess/cancelRelease/${mess.id}" class="tablelink">取消发布</a></c:if>
                                    <c:if test="${mess.state eq 0}"><a href="<%=basePath%>/admin/mess/release/${mess.id}" class="tablelink">发布</a></c:if>--%>
                                    <a href="<%=basePath%>/admin/mess/delete/${mess.id}" class="tablelink" onclick="return del()">删除</a>
                                    <a href="<%=basePath%>/admin/messBriefing/lastAdd/${mess.id}" class="tablelink">生成简报</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
       <%-- </form>--%>
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
                    ids[i].checked=true ;
                }
            }
        });
        
       /* $("#f1").click(function () {
            $.post(
                "<%=basePath%>/admin/mess/lastAdd",
                $("#f1").serialize(),
                function (obj) {
                    alert(obj);
                    if(obj){
                        location.reload();
                    }else {
                        alert("生成失败");
                    }
                }
            );
        })*/

    })
</script>
</html>
