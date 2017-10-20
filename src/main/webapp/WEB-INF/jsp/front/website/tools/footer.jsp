<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>


<section class="support">
    <div class="container clearfix" id="fotterUpdate">
        <div class="hour fr">7×24小时售后支持</div>
        <p class="fl" id="fotterP">红象Redoop 使大数据操作更加简单、高效、可靠。</p>
    </div>
</section>

<footer class="footer">
    <div class="container clearfix" id="fotterUpdateWX">
        <div class="code fr">
            <div class="fr">
                <h3 id="fotterH3">关注微信账号</h3>
                <img src="<%=basePath%>/front/website/css/img/code.jpg" />
            </div>
            <div class="fl" style="padding-top:50px;">
                立即关注微信账号redoop。<br />
                免费获取<br />
                红象云腾大数据建设成功案例和方案。
            </div>
        </div>
        <div class="contact fl">
            <h3 id="fotterH31">联系我们</h3>
            <p>Tel: 400-0389-155 <br />
                Email: bd@redoop.com<br />
                北京海淀区中关村软件园二期互联网创新中心506
<br />
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1260549954'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/z_stat.php%3Fid%3D1260549954%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script></p>
        </div>
    </div>
   <div class="container" id="fotterUpdateP">
        	<p id="fotterP2">京ICP备17046370号</p>
    </div>
</footer>
