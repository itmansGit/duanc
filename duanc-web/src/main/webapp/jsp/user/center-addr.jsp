<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
<%@include file="/jsp/common/meta.jsp"%>
<title>手掌 | 收货地址</title>
<%@include file="/jsp/common/css.jsp"%>
<style type="text/css">
</style>
</head>
<body>
	<%@include file="/jsp/common/navbar.jsp"%>
	<div class="my-space" >
		<div class="am-panel am-panel-default" style="min-height: 535px;">
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
						<form  id ="form" action="${ctx }/user-center/addr/change" style="margin-left: 400px;" method="post" enctype="multipart/form-data">
							<table>
								<tr>
									<td style="padding: 10px;"><input style="display: none" type="text" name="id" value="${addr.id }"></td>
								</tr>
								<tr>
									<td style="padding: 10px;">省：</td>
									<td style="padding: 10px;"><input type="text" name="province" value="${addr.province }"></td>
								</tr>
								<tr>
									<td style="padding: 10px;">市：</td>
									<td style="padding: 10px;"><input type="text" name="city" value="${addr.city }"></td>
								</tr>
								<tr>
									<td style="padding: 10px;">区/县：</td>
									<td style="padding: 10px;"><input type="text" name="district" value="${addr.district }"></td>
								</tr>
								<tr>
									<td style="padding: 10px;">详细地址：</td>
									<td style="padding: 10px;"><input type="text" name="detail" value="${addr.detail }" style="padding-right: 120px;"></td>
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
$(function(){
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
</script>
</body>
</html>