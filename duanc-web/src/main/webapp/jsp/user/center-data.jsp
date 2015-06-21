<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
<%@include file="/jsp/common/meta.jsp"%>
<title>手掌 | 个人资料</title>
<%@include file="/jsp/common/css.jsp"%>
<style type="text/css">
</style>
</head>
<body>
	<%@include file="/jsp/common/navbar.jsp"%>
	<div class="my-space" >
		<div class="am-panel am-panel-default" style="min-height: 530px;">
			<div class="am-panel-bd">
				<div class="am-g">
					<div class="am-u-sm-10">
						<h1><img alt="" src="${picPath }${current_user.headUrl }" width=100px height=80px style="margin-right: 50px; margin-left: 80px;"> <i class="am-icon-user"></i> ${current_user.username }</h1>
					</div>
				</div>
				<br>
				<div class="am-g">
					<div class="am-u-sm-10" style="background-color: #DBE1D2;margin-left:78px;width: 1200px;height: 55px;padding-top: 5px;">
						<button type="button" class="am-btn am-btn-secondary" onclick="userData();">个人资料</button>
						<button type="button" class="am-btn am-btn-secondary" onclick="userAddr();">收货地址</button>
						<button type="button" class="am-btn am-btn-secondary" onclick="userOrder();">订单管理</button>
						<button type="button" class="am-btn am-btn-danger" style="float:right;" onclick="userPwd();">修改密码</button>
					</div>
				</div>
				<br>
				<div class="am-g">
					<div class="am-u-sm-10" style="margin-left:78px;padding-top: 15px;padding-bottom: 15px;border: 1px solid #ECE2E2;width: 1200px;">
						<form  id ="form" action="${ctx }/user-center/data/change" style="margin-left: 280px;" method="post" enctype="multipart/form-data">
							<table>
								<tr>
									<td>
										<input type="file" id="file" name="file" style="display:none" onchange="preImg(this.id,'img');"/>
										<img alt="" src="${picPath }${current_user.headUrl }" width="180" height="180" id="img">
									</td>
									<td style="padding-left: 140px;">
										<label>姓名：<input type="text" name="nickname" value="${current_user.nickname }" placeholder="${current_user.nickname }"></label>
										<br><br>
										<label>年龄：<input type="text" name="age" value="${current_user.age }" placeholder="${current_user.age }"></label>
										<br><br>
										<label>性别：
											<c:choose>
												<c:when test="${current_user.sex ==0 }">
												<label class="am-radio-inline">
      												<input type="radio" name="sex" value="1" data-am-ucheck>男
    											</label>
    											<label class="am-radio-inline">
      												<input type="radio" name="sex" value="0" data-am-ucheck checked>女
   	 											</label>
												</c:when>
												<c:otherwise>
												<label class="am-radio-inline">
      												<input type="radio" name="sex" value="1" data-am-ucheck checked>男
    											</label>
    											<label class="am-radio-inline">
      												<input type="radio" name="sex" value="0" data-am-ucheck>女
   	 											</label>
												</c:otherwise>
											</c:choose>
   	 									</label>
   	 									<br><br>
									</td>
								</tr>
								<tr>
									<td><button type="submit" id="submit" class="am-btn am-btn-primary">保  存</button></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@include file="/jsp/common/footer.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<script type="text/javascript">
var userData = function() {
	location.href = "${ctx}/user-center/data";
}
var userAddr = function() {
	location.href = "${ctx}/user-center/addr";
}
var userPwd = function() {
	location.href = "${ctx}/user-center/pwd";
}
var userOrder = function() {
	location.href = "${ctx}/user-center/order";
}

function getFileUrl(sourceId) { 
	var url; 
	if (navigator.userAgent.indexOf("MSIE")>=1) { // IE 
	url = document.getElementById(sourceId).value; 
	} else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox 
	url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
	} else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome 
	url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
	} 
	return url; 
} 

function preImg(sourceId, targetId, preId) { 
	var url = getFileUrl(sourceId); 
	var imgPre = document.getElementById(targetId); 
	var pre = document.getElementById(preId); 
	imgPre.src = url;
	console.log(url);
} 

$(function(){
	$('#img').click(function(){
		$('input[name=file]').click();
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
	
	/*$('#submit').click(function(){
		 var b = false;
		if(('input[type=file]').val() != null || ('input[type=file]').val() !='' ){
			b = true;
		}
		if(('input[type=nickname]').val() != null || ('input[type=nickname]').val() !='' ){
			b = true;
		}
		if(('input[type=age]').val() != null || ('input[type=age]').val() !='' ){
			b = true;
		}
		if(b){
			alert("大瞎！您");
			return;
		} 
		$('#form').submit();
	});*/
});
</script>
</body>
</html>