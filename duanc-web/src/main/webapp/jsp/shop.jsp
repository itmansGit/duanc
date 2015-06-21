<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
<%@include file="/jsp/common/meta.jsp"%>
<title>手掌 | 商城</title>
<%@include file="/jsp/common/css.jsp"%>
</head>
<body>
	<%@include file="/jsp/common/navbar.jsp"%>
	<div class="my-space">
		<div class="am-panel am-panel-default">
			<div class="am-panel-bd">
				<label>当前条件： <span id="c-model" style="margin-right: 50px;"></span>
					<span id="c-price" style="margin-right: 50px;"></span>
					<input type="hidden" id="hidden">
					<button type="button" style="float: right;" class="am-btn am-btn-primary am-round am-btn-xs" id="reset">清除</button>
				</label>
				<hr>
				<label>机 型： <c:forEach items="${models}" var="item">
						<a href="#" class="model" style="margin-right: 20px;"><input type="hidden" value="${item.id }">${item.modelName }</a>
					</c:forEach>
					<button type="button" id="model-more" style="float: right;" class="am-btn am-btn-primary am-round am-btn-xs"
						data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0, width: 400, height: 225}">更多+</button>
				</label>
				<br> 
				<label>价格(￥)： 
					<a href="#" class="price"style="margin-right: 20px;">0~500</a> 
					<a href="#" class="price" style="margin-right: 20px;">500~999</a> 
					<a href="#" class="price" style="margin-right: 20px;">1000~1999</a> 
					<a href="#" class="price" style="margin-right: 20px;">2000~3999</a> 
					<a href="#" class="price" style="margin-right: 20px;">>4000</a>
				</label>
			</div>
		</div>
		
		<div class="am-panel am-panel-default" style="min-height: 400px;">
			<div class="am-panel-bd">
				<table class="am-table am-table-hover" id="table-list">
					<thead>
						<tr>
							<th style="text-align: center">手机详情</th>
							<th style="text-align: center">价格</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.dataList}" var="item">
							<tr onclick="getShow(${item.id})">
								<td width="100">
									<img alt="" src="${picPath }${item.picUrl }" width=100px height=80px style="margin-right: 50px; margin-left: 80px;"> 
									<span style="margin-right: 20px;">${item.brandName } ${item.modelName } ${item.version }</span> 
									<span>${item.os }</span></td>
								<td width="50" style="text-align: center">
									<span>￥${item.price }</span>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="TEXT-ALIGN: center;">
					<c:if test="${fn:length(pagination.dataList) == 10}">
						<button type="button" class="am-btn am-btn-primary am-round am-btn-xs" id="more-btn">更多<p>v</p></button>
					</c:if>
				</div>
			</div>
		</div>
	</div>

	<!-- 模态框 -->
	<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">
				更多机型 <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
			</div>
			<div class="am-modal-bd">
			</div>
		</div>
	</div>
<%@include file="/jsp/common/login.jsp"%>
<%@include file="/jsp/common/footer.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<script type="text/javascript">
$(function() {

	$('form').find('span.am-icon-search').click(function() {
		$('form').find('div').show();
		$(this).hide();
	});

	$('div.am-topbar').find('#login').click(function() {
		$('#doc-modal-2').modal();
	}); 

	$('.price').click(function() {
		$("#c-price").text($(this).text());
		loadPhones();
	});
	$('.model').click(function() {
		$('#hidden').val($(this).find('input[type=hidden]').val());
		$("#c-model").text($(this).text());
		loadPhones();
	});
	$('#reset').click(function() {
		$("#c-price").text('');
		$("#c-model").text('');
		loadPhones();
	});
			
	$('#model-more').click(function() {
		$('#doc-modal-1').find('.am-modal-bd').empty(); 
		$.ajax({
			url:'${ctx}/shop/ajax-more-model',
			type:'post',
			dataType:'json',
			data:null,
			success:function(data){
				$.each(data, function(i, item) {
					console.log(item.modelName + "  " + item.id + " " + i);
					$('#doc-modal-1').find('.am-modal-bd').append('<span><a href="#" class="model"'
							+ 'style="margin-right: 20px;"><input type="hidden" value="' + item.id + '">'+ item.modelName +'</a></span>');
				});
				myListener();
			},
			error:function(){
				alert('系统异常请稍后再试');
			}
		});
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
		
function myListener(){
	$('.model').click(function() {
		$('#hidden').val($(this).find('input[type=hidden]').val());
		$("#c-model").text($(this).text());
	});
}
	
function loadPhones(){
	$('#more-btn').hide();
	var price = $('#c-price').text();
	var modelId = $('#hidden').val();
	console.log(price + '  ' + modelId);
	$('#table-list').find('tbody').empty();
	$.ajax({
		url : '${ctx}/shop/ajax-load-phone',
		type : 'post',
		dataType : 'json',
		data : {price : price, modelId : modelId},
		success : function(data){
			console.log('${fn:length(data)}');
			console.log(data.length);
			if(data.length > 0) {
				$.each(data, function(i, item) {
					console.log(item.price + "  " + item.modelId );
					$('#table-list').find('tbody').append(
							'<tr onclick="getShow('+ item.id +')"><td width="100">' +
							'<img alt="" src="${picPath }' + item.picUrl +'" width=100px height=80px style="margin-right: 50px; margin-left: 80px;">'+
							'<span style="margin-right: 20px;">' + item.brandName + item.modelName + item.version + '</span>' + 
							'<span>'+ item.os + '</span></td>' +
							'<td width="50" style="text-align: center">'+
							'<span>￥' + item.price + '</span></td></tr>');
					});
					/* if(data.length == 10) {
						$('#more-btn').show();
					} */
			} else {
				$('#table-list').find('tbody').append('<span style="text-align: center;color:red;">没有符合条件的商品</span>');
			}
		},
		error : function(){
		}
	});
}
		
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
</script>
</body>
</html>