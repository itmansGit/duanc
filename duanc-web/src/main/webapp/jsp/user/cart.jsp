<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
<%@include file="/jsp/common/meta.jsp"%>
<title>手掌 | 购物车</title>
<%@include file="/jsp/common/css.jsp"%>
<style type="text/css">
</style>
</head>
<body>
	<%@include file="/jsp/common/navbar.jsp"%>
	<div class="my-space" >
		<div class="am-panel am-panel-default" style="min-height: 520px;">
			<div class="am-panel-bd">
				<div class="am-g">
					<div class="am-u-sm-10" style="margin-left:60px;">
						<h1><i class="am-icon-cart-plus"></i> 购物车</h1>
					</div>
				</div>
				<hr>
				<div class="am-g" style="min-height: 320px;">
					<div class="am-u-sm-10">
						 <table style="margin-left:60px;width: 1200px;">
						 	<tbody>
						 		<c:if test="${cartList == null || fn:length(cartList) == 0}">
						 			<label style="color:red; margin-left:60px;">购物车空空的！赶紧去选几件商品吧！</label>
						 		</c:if>
						 		<c:forEach var="item" items="${cartList}">
						 			<tr style="border: 1px solid #ECE2E2;padding: 10px;height: 110px;">
						 				<td width=60>
						 					<label class="am-checkbox" style="margin-left:40px;">
     	 										<input type="checkbox" value="${item.id }" data-am-ucheck>
    										</label>
    									</td>
						 				<td width=180><img alt="" src="${picPath }${item.picUrl }" 
						 					width=120px height=100px style="margin-right: 50px; margin-left: 80px;"></td>
						 				<td width=520>${item.brandName } ${item.modelName } ${item.version }&nbsp;${item.os }</td>
						 				<td width=180> ￥${item.price }</td>
						 				<td width=180 style="margin-left:40px;"><button type="button" class="am-btn am-btn-warning" onclick="removeFromCart(${item.id })">删 除</button></td>
						 			</tr>
						 		</c:forEach>
						 	</tbody>
						 </table>
					</div>
				</div>
				<br>
				<div class="am-g">
					<div class="am-u-sm-10" style="background-color: #DBE1D2;margin-left:78px;width: 1200px;height: 55px;padding-top: 5px;">
						<button type="button" class="am-btn am-btn-secondary" onclick="chooseAll();">全 选</button>
						<button type="button" class="am-btn am-btn-secondary" onclick="chooseNull();">全不选</button>
						<button type="button" class="am-btn am-btn-danger" onclick="reomve();">删 除</button>
						<button type="button" class="am-btn am-btn-primary" style="float:right;" onclick="buy();">购 买</button>
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

var chooseAll = function() {
	 var options = $('table').find('input[type=checkbox]');
	 $.each(options,function(i,item){
		 item.checked=true;
	 });
}
var chooseNull = function() {
	 var options = $('table').find('input[type=checkbox]');
	 $.each(options,function(i,item){
		 item.checked=false;
	 });
}

var removeFromCart = function(phoneId) {
	$.ajax({
		url : '${ctx}/cart/ajax-removeFromCart',
		type : 'post',
		dataType : 'json',
		data : {phoneId : phoneId},
		success : function(data){
			console.log(data);
			if(data == true) {
				location.reload(false); 
			} else{
				alert('系统异常请稍后再试');
			}
		},
		error : function(){
			alert('系统异常请稍后再试');
		}
	});
}

var reomve = function() {
	var options = $('table').find('input[type=checkbox]');
	var arr = [];  
	 $.each(options,function(i,item){
		 if(item.checked == true) {
			 arr[arr.length] = $(item).val();
		 }
	 });
	 console.log(arr);
	 $.ajax({
			url : '${ctx}/cart/ajax-removeListFromCart',
			type : 'post',
			dataType : 'json',
			data : {"arr":arr},
			success : function(data){
				console.log(data);
				if(data == true) {
					location.reload(false); 
				} else{
					alert('请求异常请稍后再试');
				}
			},
			error : function(){
				alert('系统异常请稍后再试');
			}
		});
}

var buy = function() {
	if('${cartList}' == '' || '${fn:length(cartList)}' == 0) {
		console.log('${cartList}');
		alert('购物车空空如也！不知道您要买什么！');
		return ;
	}
	if('${current_user}'  == '') {
		console.log('${current_user}');
		alert('请先登录');
		return ;
	}
	/* var options = $('table').find('input[type=checkbox]');
	var arr = [];  
	 $.each(options,function(i,item){
		 if(item.checked == true) {
			 arr[arr.length] = $(item).val();
		 }
	 });
	 console.log(arr);
	 $.ajax({
			url : '${ctx}/cart/ajax-removeListFromCart',
			type : 'post',
			dataType : 'json',
			data : {"arr":arr},
			success : function(data){
				console.log(data);
				if(data == true) {
					location.reload(false); 
				} else{
					alert('请求异常请稍后再试');
				}
			},
			error : function(){
				alert('系统异常请稍后再试');
			}
		}); */
}
</script>
</body>
</html>