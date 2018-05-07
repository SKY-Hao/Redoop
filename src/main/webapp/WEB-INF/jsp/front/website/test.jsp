<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <%--<title>${form.id==null?"CRH&AI下载添加":"CRH&AI下载修改"}</title>
    <jsp:include page="../../tools/style/common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/toastr.jsp"></jsp:include>
--%>
    <%-- <script type="text/javascript" src="<%=basePath%>/backstage/My97DatePicker/WdatePicker.js"></script>
     <link href="<%=basePath%>/backstage/makedown/css/editormd.min.css" rel="stylesheet">
     <script src="<%=basePath%>/backstage/makedown/js/editormd.min.js"></script>--%>

   <%-- <link href="https://pandao.github.io/dist/css/planeui.min.css"  type="text/css" rel="stylesheet">
    <link href="https://pandao.github.io/editor.md/css/editormd.min.css" type="text/css"  rel="stylesheet">
    <link href="https://pandao.github.io/editor.md/css/index.css" type="text/css"  rel="stylesheet">
    <link href="https://pandao.github.io/editor.md/lib/codemirror/codemirror.min.css" type="text/css"  rel="stylesheet">
--%>

   <%-- <script src="https://pandao.github.io/editor.md/examples/js/jquery.min.js"></script>
    <script src="https://pandao.github.io/editor.md/editormd.min.js"></script>
    <script src="https://pandao.github.io/editor.md/js/index.js"></script>
--%>

        <link href="<%=basePath%>/backstage/makedown/css/editormd.min.css"  type="text/css"  rel="stylesheet">

        <%--<link href="<%=basePath%>/backstage/makedown/lib/codemirror/codemirror.min.css" type="text/css"  rel="stylesheet">
    <link href="<%=basePath%>/backstage/makedown/lib/codemirror/addon/dialog/dialog.css" type="text/css"  rel="stylesheet">
    <link href="<%=basePath%>/backstage/makedown/lib/codemirror/addon/search/matchesonscrollbar.css" type="text/css"  rel="stylesheet">
    <link href="<%=basePath%>/backstage/makedown/lib/codemirror/addon/fold/foldgutter.css"  type="text/css"  rel="stylesheet">
--%>
        <script type="text/javascript" src="<%=basePath%>/front/website/js/jquery-1.8.2.min.js"></script>

        <%--<script type="text/javascript" src="<%=basePath%>/backstage/makedown/js/jquery-3.2.1.min.js"></script>--%>

        <script type="text/javascript" src="<%=basePath%>/backstage/makedown/js/editormd.min.js"></script>

    <%--<script type="text/javascript" src="<%=basePath%>/backstage/makedown/lib/codemirror/modes.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/backstage/makedown/lib/codemirror/addons.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/backstage/makedown/lib/marked.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/backstage/makedown/lib/prettify.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/backstage/makedown/lib/raphael.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/backstage/makedown/lib/underscore.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/backstage/makedown/lib/flowchart.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/backstage/makedown/lib/jquery.flowchart.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/backstage/makedown/lib/flowchart.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.3.0/katex.min.js"></script>
--%>

   <%--<script src="https://pandao.github.io/editor.md/lib/codemirror/modes.min.js"></script>
    <script src="https://pandao.github.io/editor.md/lib/codemirror/addons.min.js"></script>
    <script src="https://pandao.github.io/editor.md/lib/marked.min.js"></script>
    <script src="https://pandao.github.io/editor.md/lib/prettify.min.js"></script>
    <script src="https://pandao.github.io/editor.md/lib/raphael.min.js"></script>
    <script src="https://pandao.github.io/editor.md/lib/underscore.min.js"></script>
    <script src="https://pandao.github.io/editor.md/lib/flowchart.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/backstage/makedown/lib/jquery.flowchart.min.js"></script>
    <script src="https://pandao.github.io/editor.md/lib/jquery.flowchart.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.3.0/katex.min.js"></script>--%>
</head>
<body>
    ${markDown.htmlcontent}
</body>
</html>
<script type="text/javascript">
        $(function() {
            editormd("editormd-content", {
                width   : "90%",
                height  : 640,
                syncScrolling : "single",
                //你的lib目录的路径，我这边用JSP做测试的
                path    : "<%=request.getContextPath()%>/backstage/makedown/lib/",
                //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
                saveHTMLToTextarea : false
            });
        });
</script>

