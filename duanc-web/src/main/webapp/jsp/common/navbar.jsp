<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="am-topbar am-topbar-inverse">
  <h1 class="am-topbar-brand" style="margin-left: 25px;">
    <a href="#">Palm <i class="am-icon-tablet"></i> 手掌</a>
  </h1>

  <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav" style="margin-left: 55px;">
    	<c:choose>
			<c:when test="${navbar == 0 }">
				<li class="am-active"><a href="${ctx }/index/index">首页</a></li>
      			<li><a href="${ctx }/shop/page">商城</a></li>
			</c:when>
			<c:when test="${navbar == 1 }">
				<li><a href="${ctx }/index/index">首页</a></li>
      			<li class="am-active"><a href="${ctx }/shop/page">商城</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${ctx }/index/index">首页</a></li>
      			<li><a href="${ctx }/shop/page">商城</a></li>
			</c:otherwise>
		</c:choose>
    </ul>

    <form class="am-topbar-form am-topbar-left am-form-inline" role="search">
		<div class="am-form-group am-form-icon" style="display:none;">
			<i class="am-icon-search" onclick="alert('search start ...')"></i>
			<input type="text" class="am-form-field" placeholder="搜索">
		</div>
		<span class="am-icon-search"></span>    
    </form>
	
    <div class="am-topbar-right" id="login-div">
    	<c:choose>
			<c:when test="${current_user != null }">
				<div class="am-dropdown" data-am-dropdown="{boundary: '.am-topbar'}">
        			<button class="am-btn am-btn-primary am-topbar-btn am-btn-sm am-dropdown-toggle" data-am-dropdown-toggle>${current_user.username }<span class="am-icon-caret-down"></span></button>
        			<ul class="am-dropdown-content">
          			<li><a href="${ctx }/user-center/index">个人中心</a></li>
          			<li><a href="${ctx }/cart">购物车</a></li>
          			<li><a id="logout">退出</a></li>
        			</ul>
      			</div>
			</c:when>
			<c:otherwise>
				<button class="am-btn am-btn-primary am-topbar-btn am-btn-sm" id="login">登录</button>
      			<div class="am-dropdown" data-am-dropdown="{boundary: '.am-topbar'}">
        		<button class="am-btn am-btn-primary am-topbar-btn am-btn-sm am-dropdown-toggle" data-am-dropdown-toggle>其他 <span class="am-icon-caret-down"></span></button>
        		<ul class="am-dropdown-content">
          			<li><a href="${ctx }/regist-page">注册</a></li>
          			<li><a href="${ctx }/cart">购物车</a></li>
        		</ul>
      			</div>
			</c:otherwise>
		</c:choose>
    </div>
  </div>
</div>