<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <%@include file="/jsp/common/meta.jsp" %>
  <title>手掌 | 首页</title>
  <%@include file="/jsp/common/css.jsp" %>
  <style>
  </style>
</head>
<body>
<%@include file="/jsp/common/navbar.jsp" %>
<div data-am-widget="slider" id="img-div" class="am-slider am-slider-c1" data-am-slider='{&quot;directionNav&quot;:false}' style="margin-top: -20px;">
  <ul class="am-slides">
  <c:forEach items="${phones}" var="item">
  	<li>
      <img src="${picPath }${item.picUrl }" style="min-height:400px;max-height:500px;">
      <div class="am-slider-desc">
      	<h4>${item.version }</h4>  
		<p>
			￥${item.price }  ${item.cpu }  ${item.cpuCores }  ${item.cpuHz }GHz 
	  		<button class="am-btn am-btn-primary" style="float:right;" onclick="getShow(${item.id})">立即购买</button>
	  	</p>
	  </div>
    </li>
  </c:forEach>
  </ul>
</div>

<hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
<center><h1>其他热卖</h1></center>
<div>
<ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-3 am-avg-lg-4 am-gallery-default" data-am-gallery="{ pureview: true }">
<c:forEach items="${phones}" var="item">
<li>
    <div class="am-gallery-item" onclick="getShow(${item.id})">
      <a href="http://s.cn.bing.net/az/hprichbg/rb/TheLuxorHotel_ZH-CN12121725266_1920x1080.jpg" class="">
        <img src="${picPath }${item.picUrl }" alt="${item.version }" style="width:340px;height:200px;"/>
        <h3 class="am-gallery-title">${item.version } ￥${item.price }  ${item.cpu }  ${item.cpuCores }  ${item.cpuHz }GHz </h3>
        <div class="am-gallery-desc"><fmt:formatDate value="${item.listingDate }" pattern="yyyy-MM-dd"/>上市</div>
      </a>
    </div>
  </li>
</c:forEach>
</ul>
<button style="float:right;" class="am-btn am-btn-primary" onclick="getShop();">更多>>></button>
</div>

<hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>

  <div class="am-g am-container">
    <div class="am-u-lg-12 center">
      <center><h1>One Web 、Any Device，期待和你一起去实现!</h1></center>

      <div class="am-g">
        <div class="am-u-lg-3 am-u-md-6 am-u-sm-12 detail-mb">

          <h3 class="detail-h3">
            <i class="am-icon-mobile am-icon-sm"></i>
            为移动而生
          </h3>

          <p class="detail-p">
            Amaze UI 采用业内先进的 mobile first 理念，从小屏逐步扩展到大屏，最终实现所有屏幕适配，适应移动互联潮流。
          </p>
        </div>
        <div class="am-u-lg-3 am-u-md-6 am-u-sm-12 detail-mb">
          <h3 class="detail-h3">
            <i class="am-icon-cogs am-icon-sm"></i>
            组件丰富，模块化
          </h3>

          <p class="detail-p">
            Amaze UI 含近 20 个 CSS 组件、10 个 JS 组件，更有 17 款包含近 60 个主题的 Widgets，可快速构建界面出色、体验优秀的跨屏页面，大幅度提升你的开发效率。
          </p>
        </div>
        <div class="am-u-lg-3 am-u-md-6 am-u-sm-12 detail-mb">
          <h3 class="detail-h3">
            <i class="am-icon-check-square-o am-icon-sm"></i>
            本地化支持
          </h3>

          <p class="detail-p">
            相比国外的前端框架，Amaze UI 专注解决中文排版优化问题，根据操作系统调整字体，实现最佳中文排版效果；针对国内主流浏览器及 App 内置浏览器提供更好的兼容性支持，为你节省大量兼容性调试时间。
          </p>
        </div>
        <div class="am-u-lg-3 am-u-md-6 am-u-sm-12 detail-mb">
          <h3 class="detail-h3">
            <i class="am-icon-send-o am-icon-sm"></i>
            轻量级，高性能
          </h3>

          <p class="detail-p">
            Amaze UI 非常注重性能，基于轻量的 Zepto.js 开发，并使用 CSS3 来做动画交互，平滑、高效，更适合移动设备，让你的 Web 应用可以高速载入。
          </p>
        </div>
      </div>
    </div>
  </div>
  <%@include file="/jsp/common/login.jsp"%>
  <%@include file="/jsp/common/footer.jsp" %>
  <%@include file="/jsp/common/js.jsp" %>
<script type="text/javascript">
$(function(){
	$('form').find('span.am-icon-search').click(function(){
		$('form').find('div').show();
		$(this).hide();
	});
	
	$('div.am-topbar').find('#login').click(function() {
		$('#doc-modal-2').modal();
	});
	 
	$('#logout').click(function(){
		$.ajax({
			url : '${ctx}/logout',
			type : 'post',
			dataType : 'json',
			data : null,
			success : function(data){
				location.reload(false); 	
			},
			error : function(){
			}
		});
	});
});

function login(obj){
	console.log("login:  " + $('#username').val() + "  " + $('#password').val());
	$.ajax({
		url : '${ctx}/login',
		type : 'post',
		dataType : 'json',
		data : {username : $('#username').val(), password : $('#password').val()},
		success : function(data){
			console.log(data);
			if(data == true) {
				$('#doc-modal-2').modal('close');
				location.reload(false); 
			} else{
				alert('用户名或密码错误');
			}
		},
		error : function(){
		}
	});
}

var getShow = function(phoneId){
	location.href = "${ctx}/show/getPage?phoneId=" + phoneId;
}

var getShop = function(phoneId){
	location.href = "${ctx}/shop/page";
}
</script>
</body>
</html>