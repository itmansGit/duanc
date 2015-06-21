<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
<%@include file="/jsp/common/meta.jsp"%>
<title>手掌 | 支付</title>
<%@include file="/jsp/common/css.jsp"%>
<style type="text/css">
</style>
</head>
<body>
	<%@include file="/jsp/common/navbar.jsp"%>
	<div class="my-space">
		<div class="am-panel am-panel-default" style="min-height: 540px;">
			<div class="am-panel-bd">
				<div class="am-g">
					<div class="am-u-sm-10" style="margin-left:240px;">
						<label>订单号：${orderId }</label>
					</div>
				</div>
				<hr>
				<div class="am-g" style="margin-top:60px;">
					<div class="am-u-sm-10" style="margin-left:160px;border: 1px solid #ECE2E2;padding: 10px;">
						<div onclick="getShow(${phone.id})">
							<img alt="" src="${picPath }${phone.picUrl }" width=100px height=80px style="margin-right: 50px; margin-left: 80px;"> 
							<span style="margin-right: 20px;">${phone.brandName } ${phone.modelName } ${phone.version }</span> 
							<span>${phone.os }</span>
							<span> ￥${phone.price }</span>
						</div>
					</div>
				</div>
				<div class="am-g" style="margin-top:60px;">
					<div class="am-u-sm-10" style="margin-left:240px;">
						<div>
							收件地址：<label>${userAddress.province }${userAddress.city }${userAddress.district }${userAddress.detail }</label>
							<button type="button" class="am-btn am-btn-success" style="float: right;" onclick="changeAddr()">修改地址</button>
						</div>
						<div>
							价格：<label style="color: red;">￥${phone.price }</label>
						</div>
					</div>
				</div>
				<hr>
				<div class="am-g" style="margin-top:60px;">
					<div class="am-u-sm-10" style="margin-left:240px;">
						<div>
							<button type="button" class="am-btn am-btn-success" onclick="bookIngSubmit()">确认</button>
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

var bookIngSubmit = function(){
	location.href = "${ctx}/booking/submit";
}

var changeAddr = function(){
	location.href = "${ctx}/user-center/addr";
}
</script>
</body>
</html>