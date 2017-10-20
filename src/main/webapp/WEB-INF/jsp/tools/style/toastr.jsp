<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<script src="<%=basePath%>/backstage/toastr/jquery.min.js"></script>
<script src="<%=basePath%>/backstage/toastr/toastr.min.js"></script>

<link href="<%=basePath%>/backstage/toastr/toastr.min.css" rel="stylesheet">


<script type="text/javascript">
    function del() {
        var msg = "您真的确定要删除吗？\n\n请确认！";
        if (confirm(msg) == true) {
            return true;
        } else {
            return false;
        }
    }

    function start() {
        var msg = "您真的确定要激活吗？\n\n请确认！";
        if (confirm(msg) == true) {
            return true;
        } else {
            return false;
        }
    }
    function stop() {
        var msg = "您真的确定要禁止吗？\n\n请确认！";
        if (confirm(msg) == true) {
            return true;
        } else {
            return false;
        }
    }
    function startWRZ() {
        var msg = "您真的确定要认证通过吗？\n\n请确认！";
        if (confirm(msg) == true) {
            return true;
        } else {
            return false;
        }
    }
    function startYRZ() {
        var msg = "您真的确定要取消本公司认证结果吗？\n\n请确认！";
        if (confirm(msg) == true) {
            return true;
        } else {
            return false;
        }
    }
</script>
