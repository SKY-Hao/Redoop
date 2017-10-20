<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pages">
    <span class="disBlock">共${pageList.totalElements}条（${pageList.size}条/页）  |   第${pageList.number + 1}/${pageList.totalPages}页</span>&nbsp;&nbsp;&nbsp;&nbsp;
    <span>

        <span><a href="<%=basePath%>/${url}" class="page go" style="text-decoration: none;">首页</a></span>

        <c:if test="${pageList.number >0}">
            <span><a href="<%=basePath%>/${url}page=${pageList.number-1}" class="page go" style="text-decoration: none;">上一页</a></span>
        </c:if>

        <c:choose>
            <c:when test="${pageList.totalPages<=12}">
                <c:set var="begin" value="0"/>
                <c:set var="end" value="${pageList.totalPages == 0 ? 0: pageList.totalPages-1}"/>
            </c:when>
            <c:otherwise>
                <c:set var="begin" value="${pageList.number-6}"/>
                <c:set var="end" value="${pageList.number + 5}"/>


                <c:if test="${begin < 1}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="12"/>
                </c:if>
                <c:if test="${end > pageList.totalPages}">
                    <c:set var="begin" value="${pageList.totalPages-11}"/>
                    <c:set var="end" value="${pageList.totalPages}"/>
                </c:if>


            </c:otherwise>
        </c:choose>

        <c:forEach var="i" begin="${begin}" end="${end}">
            <c:choose>
                <c:when test="${i eq pageList.number}">
                    <span><a class="on" style="text-decoration: none;">${i+1}</a></span>
                </c:when>
                <c:otherwise>
                    <span><a href="<%=basePath%>/${url}page=${i}" class="page" style="text-decoration: none;" >${i+1}</a></span>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${pageList.number < pageList.totalPages -1}">
            <span><a href="<%=basePath%>/${url}page=${pageList.number+1}" class="page go"style="text-decoration: none;" >下一页</a></span>
        </c:if>

        <span><a href="<%=basePath%>/${url}page=${pageList.totalPages-1}" class="page go"style="text-decoration: none;" >尾页</a></span>


    </span>
    <%--<span class="disBlock">转到第</span>
    <span class="pageInput">
		<input type="text" value="" id="inputpagepageDiv">
    </span>
    <span class="disBlock">页</span>
    <a class="go page" href="javascript:void(0)" onclick="#">确定</a>--%>
</div>