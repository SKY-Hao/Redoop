<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!doctype html>
<html>
<head>
    <jsp:include page="crhHeade.jsp"></jsp:include>

    <script src="<%=basePath%>/backstage/makedown/js/bootstrap.min.js"></script>
    <link href="<%=basePath%>/backstage/makedown/css/bootstrap.min.css" rel="stylesheet">.

</head>

<body>
<jsp:include page="tools/header.jsp"></jsp:include>


<section class="grey-bg" id="breadMenu" >
    <div class="container"><a href="<%=basePath%>/">首页</a> &gt; Redoop CRH</div>
</section>
<section class="block" id="newsPage">
    <div class="container clearfix">
        <div class="newsInfo" id="htmlcontent"><!--内容-->
            ${markDown.htmlcontent}
        </div>
    </div>
</section>

<jsp:include page="tools/footer.jsp"></jsp:include>

</body>
</html>
