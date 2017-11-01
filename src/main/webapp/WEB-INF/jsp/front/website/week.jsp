<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!doctype html>
<html>
<head>

	<link rel="stylesheet" href="<%=basePath%>/front/website/css/style.css" type="text/css" media="screen" />

	<script type="text/javascript" src="<%=basePath%>/front/website/js/jquery-1.11.3.min.js"></script>
</head>
<body>

			<table>
				<c:forEach items="${list}" var="mess">
						<tr>
							<td>ID:</td>
							<td>${mess.tableid}</td>
						</tr>
						<tr>
							<td>类目：</td>
							<td>${mess.tablename}</td>

						</tr>
						<tr>
							<td>标题：</td>
							<td>
								<a href="${mess.jumpurl}">
										${mess.tabletitle}
								</a>
							</td>
						</tr>
						<tr>
							<td>概要：</td>
							<td>${mess.outline}</td>
						</tr>
						<tr>
							<td>发布者：</td>
							<td>${mess.author}</td>
						</tr>
						<tr>
							<td>时间:</td>
							<td>${mess.date}</td>
						</tr>
						<tr>
							<td>路径:</td>
							<td>${mess.jumpurl}</td>
						</tr>
				</c:forEach>
			</table>


</body>
</html>
