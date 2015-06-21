<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
<%@include file="/jsp/common/meta.jsp"%>
<title>手掌 | 商品展示</title>
<%@include file="/jsp/common/css.jsp"%>
<style type="text/css">
	.comm-font{
		color:#1794B6;
	}
</style>
</head>
<body>
	<%@include file="/jsp/common/navbar.jsp"%>
	<div class="my-space">
		<div class="am-panel am-panel-default">
			<div class="am-panel-bd">
				<div class="am-g">
					<div class="am-u-sm-6 am-u-md-4 am-u-lg-5" style="margin-left:180px;margin-top:20px;">
						<img alt="" src="${picPath }${showPhone.picUrl }" width="360px" height="360px;">
					</div>
  					<div class="am-u-sm-6 am-u-md-8 am-u-lg-4 am-u-end" style="margin-top:20px;">
  						<span> <h1>${showPhone.brandName } ${showPhone.modelName } ${showPhone.version }</h1> </span>
  						<span> <h2 style="color:red;">￥${showPhone.price }</h2> </span>
  						<button type="button" class="am-btn am-btn-success" onclick="pay(${showPhone.id })">立即购买</button>
  						<button type="button" class="am-btn am-btn-warning" onclick="addToCart(${showPhone.id})">加入购物车</button>
  					</div>
				</div>
				<hr>
				<div class="am-g" style="margin-top:60px;">
					<div class="am-u-sm-10" style="margin-left:240px;">
						<div class="am-u-sm-5">
							<label>品牌：<span class="comm-font">${showPhone.brandName } </span></label>
						</div>
						<div class="am-u-sm-5 am-u-end">
							<label>机型：<span class="comm-font">${showPhone.modelName }</span></label>
						</div>
					</div>
					<div class="am-u-sm-10" style="margin-left:240px;">
						<div class="am-u-sm-5">
							<label>版本：<span class="comm-font">${showPhone.version }</span></label>
						</div>
						<div class="am-u-sm-5 am-u-end">
							<label>价格：<span class=" comm-font">￥${showPhone.price }</span></label>
						</div>
					</div>
					<div class="am-u-sm-10" style="margin-left:240px;">
						<div class="am-u-sm-5">
							<label>cpu型号：<span class=" comm-font">${showPhone.cpu }</span></label>
						</div>
						<div class="am-u-sm-5 am-u-end">
							<label>cpu核心数：<span class=" comm-font">${showPhone.cpuCores }</span></label>
						</div>
					</div>
					<div class="am-u-sm-10" style="margin-left:240px;">
						<div class="am-u-sm-5">
							<label>cpu频率：<span class=" comm-font">${showPhone.cpuhz }GHz</span></label>
						</div>
						<div class="am-u-sm-5 am-u-end">
							<label>上市日期：<span class=" comm-font"><fmt:formatDate value="${showPhone.listingDate }" pattern="yyyy-MM-dd"/></span></label>
						</div>
					</div>
					<div class="am-u-sm-10" style="margin-left:240px;">
						<div class="am-u-sm-5">
							<label>主屏尺寸：<span class=" comm-font">${showPhone.screensize }寸</span></label>
						</div>
						<div class="am-u-sm-5 am-u-end">
							<label>网络类型：<span class=" comm-font">${showPhone.netType }</span></label>
						</div>
					</div>
					<div class="am-u-sm-10" style="margin-left:240px;">
						<div class="am-u-sm-5">
							<label>RAM：<span class=" comm-font">${showPhone.ram }</span></label>
						</div>
						<div class="am-u-sm-5 am-u-end">
							<label>ROM：<span class=" comm-font">${showPhone.rom }</span></label>
						</div>
					</div>
					<div class="am-u-sm-10 am-u-end" style="margin-left:240px;">
						<div class="am-u-sm-5">
							<label>操作系统：<span class=" comm-font">${showPhone.os }</span></label>
						</div>
						<div class="am-u-sm-5 am-u-end">
							<label>电池容量：<span class=" comm-font">${showPhone.battery }mAh</span></label>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@include file="/jsp/common/login.jsp"%>
<%@include file="/jsp/common/footer.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<script type="text/javascript">
/* window.onload = function(){
	alert('${showPhone}');
	if('${showPhone}' == null && '${showPhone}' == ''){
		alert('null');
		location.href = "${ctx}/index/index";
	}
} */
$(function(){
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
				alert('系统异常请稍后再试');
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
			alert('系统异常请稍后再试');
		}
	});
}

var pay = function(phoneId){
	location.href = "${ctx}/booking?phoneId=" + phoneId;
}

var addToCart = function(phoneId){
	$.ajax({
		url : '${ctx}/cart/ajax-addToCart',
		type : 'post',
		dataType : 'json',
		data : {phoneId : phoneId},
		success : function(data){
			console.log(data);
			if(data == true) {
				alert('成功添加到购物车'); 
			} else{
				alert('添加失败');
			}
		},
		error : function(){
			alert('系统异常请稍后再试');
		}
	});
}
</script>
</body>
</html>