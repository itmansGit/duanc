<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
<%@include file="/jsp/common/meta.jsp"%>
<title>手掌 | 修改密码</title>
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
				<div class="am-g">
					<div class="am-u-sm-10" style="margin-left:78px;padding-top: 15px;padding-bottom: 15px;border: 1px solid #ECE2E2;width: 1200px;">
						<form  id ="form" action="${ctx }/user-center/pwd/change" style="margin-left: 400px;" method="post" enctype="multipart/form-data">
							<table>
								<tr>
									<td style="padding: 10px;"><input style="display: none" type="text" name="id" value=""></td>
								</tr>
								<tr>
									<td style="padding: 10px;">旧密码：</td>
									<td style="padding: 10px;"><input type="password" name="oldPwd" value=""></td>
								</tr>
								<tr>
									<td style="padding: 10px;">新密码：</td>
									<td style="padding: 10px;"><input type="password" name="newPwd" value=""></td>
									<td style="padding: 10px;"><span style="color:red;" id="newPwd-error"></span></td>
								</tr>
								<tr>
									<td style="padding: 10px;">确认新密码：</td>
									<td style="padding: 10px;"><input type="password" id="rNewPwd" value=""></td>
									<td style="padding: 10px;"><span style="color:red;" id="rNewPwd-error"></span></td>
								</tr>
								<tr>
									<td><button type="button" id="submit-btn" class="am-btn am-btn-primary">保  存</button></td>
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
window.onload = function() {
	if("${pwd_massage}"!= null &&  "${pwd_massage}"!= ""){
		alert("${pwd_massage}");
	}
}
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
function checkPwd(str){
	var re=/^(\w){6,20}$/; 
    if(re.test(str)){
		return true;
	}else{
		return false;
	}       
}
$(function(){
	$('input[name=newPwd]').change(function(){
		$('#newPwd-error').text(null);
		var password= $(this).val();
		if(checkPwd(password) == false) {
			$('#newPwd-error').text('请输入正确格式的密码');
			return ;
		} 
	});
	
	$('#rNewPwd').change(function(){
		$('#rNewPwd-error').text(null);
		var password= $('input[name=newPwd]').val();
		if(password != $(this).val()) {
			$('#rNewPwd-error').text('密码前后不一致');
			return ;
		} 
	});
	
	$('#submit-btn').click(function(){
		if($('#newPwd-error').text() != ''|| $('#rNewPwd-error').text() != '') {
			alert('请根据提示修改正确');
			return;
		} else if($('input[name=oldPwd]').val() == '' && $('input[name=newPwd]').val() == '' && $('#rNewPwd').val() ==''){
			alert('您还有没填的呢');
			return;
		}
		$('#form').submit();
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
</script>
</body>
</html>