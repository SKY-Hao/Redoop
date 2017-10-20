<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/5
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <meta charset="utf-8">
    <title>激活反馈</title>
</head>

<body style="background-color: #F0F3F4;">
<div style="margin-top: 100px;text-align: center;">
    ${msg}<br>
    页面在跳转中请稍后...
</div>
<script>
    function jumpurl() {
        location = 'http://www.redoop.com';
    }
    setTimeout('jumpurl()', 5000);
</script>

</body>

</html>

