<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
<%@include file="/jsp/common/meta.jsp"%>
<title>手掌 | 注册</title>
<%@include file="/jsp/common/css.jsp"%>
</head>
<body>
	<%@include file="/jsp/common/navbar.jsp"%>
	<div class="my-space">
		<div class="am-panel am-panel-default">
			<div class="am-panel-bd">
				<form id="regist-form" class="am-form am-form-horizontal" action="${ctx }/regist" method="post">
					<div class="am-form-group" >
    					<label for="doc-ipt-3" class="am-u-sm-2 am-form-label" style="text-align: center;margin-left: 530px;">
    						<h1>Palm <i class="am-icon-tablet"></i> 手掌</h1>用户注册
    					</label>
 					</div>
 					<br>
  					<div class="am-form-group">
    					<label for="doc-ipt-3" class="am-u-sm-2 am-form-label">用户名</label>
    					<div class="am-u-sm-8 am-u-end">
      						<input type="text" name="username" class="am-form-field" placeholder="规则：字母、数字、下划线组成，字母开头，4-16位。">
    					</div>
    					<span id="username-error" style="color:red;"></span>
 					 </div>
  					<div class="am-form-group">
    					<label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">密码</label>
    					<div class="am-u-sm-8 am-u-end">
      						<input type="password" name="password" class="am-form-field" placeholder="只能输入6-20个字母、数字、下划线 ">
    					</div>
    					<span id="password-error" style="color:red;"></span>
  					</div>
					<div class="am-form-group">
    					<label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">确认密码</label>
    					<div class="am-u-sm-8 am-u-end">
      						<input type="password" id="rpwd" class="am-form-field" placeholder="再次输入密码">
    					</div>
    					<span id="pwd-error" style="color:red;"></span>
  					</div>
  					<div class="am-form-group">
    					<label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">邮箱</label>
    					<div class="am-u-sm-8 am-u-end">
      						<input type="text" name="email" class="am-form-field" placeholder="输入你的联系邮箱">
    					</div>
    					<span id="email-error" style="color:red;"></span>
  					</div>
  					<div class="am-form-group">
    					<label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">手机号码</label>
    					<div class="am-u-sm-8 am-u-end">
      						<input type="text" name="phoneNo" class="am-form-field" placeholder="输入你的手机号码">
    					</div>
    					<span id="phoneNo-error" style="color:red;"></span>
  					</div>
  					<div class="am-form-group">
    					<div class="am-u-sm-10 am-u-sm-offset-2">
      						<button type="button" id="submit-btn" class="am-btn am-btn-default">提交注册</button>
    					</div>
  					</div>
				</form>
			</div>
		</div>
	</div>
<%@include file="/jsp/common/footer.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<script type="text/javascript">
$(function(){
	$('#login-div').hide();
	
	$('input[name=username]').change(function(){
		$('#username-error').text(null);
		var username= $('input[name=username]').val();
		if(checkUser(username) == false) {
			$('#username-error').text('请输入正确格式的用户名');
			return;
		}
		$.ajax({
			url : '${ctx}/checkUser',
			type : 'post',
			dataType : 'json',
			data : {username:username},
			success : function(data){
				if(data == false) {
					$('#username-error').text('用户名已存在');
					return;
				}
			},
			error : function(){
				$('#username-error').text('系统繁忙请稍后再试');
			}
		});
	});
	
	$('input[name=email]').change(function(){
		$('#email-error').text(null);
		var email= $(this).val();
		if(checkEmail(email) == false) {
			$('#email-error').text('请输入正确格式的邮箱');
			return;
		}
		$.ajax({
			url : '${ctx}/checkUser',
			type : 'post',
			dataType : 'json',
			data : {email:email},
			success : function(data){
				if(data == false) {
					$('#email-error').text('邮箱已存在');
					return;
				}
			},
			error : function(){
				$('#email-error').text('系统繁忙请稍后再试');
			}
		});
	});
	$('input[name=phoneNo]').change(function(){
		$('#phoneNo-error').text(null);
		var phoneNo= $(this).val();
		if(checkMobile(phoneNo) == false) {
			$('#phoneNo-error').text('请输入正确的手机号码');
			return ;
		} 
		$.ajax({
			url : '${ctx}/checkUser',
			type : 'post',
			dataType : 'json',
			data : {phoneNo:phoneNo},
			success : function(data){
				if(data == false) {
					$('#phoneNo-error').text('手机号码已存在');
					return;
				}
			},
			error : function(){
				$('#phoneNo-error').text('系统繁忙请稍后再试');
			}
		});
	});
	
	$('input[name=password]').change(function(){
		$('#password-error').text(null);
		var password= $(this).val();
		if(checkPwd(password) == false) {
			$('#password-error').text('请输入正确格式的密码');
			return ;
		} 
	});
	
	$('#rpwd').change(function(){
		$('#pwd-error').text(null);
		var password= $('input[name=password]').val();
		if(password != $(this).val()) {
			$('#pwd-error').text('密码前后不一致');
			return ;
		} 
	});
	
	$('#submit-btn').click(function(){
		if($('#phoneNo-error').text() != '' && $('#email-error').text() != '' && $('#username-error').text() != ''
				&& $('#password-error').text() != '' && $('#pwd-error').text() != '') {
			alert('请根据提示修改正确');
			return;
		} else if($('input[name=username]').val() == '' && $('input[name=password]').val() == '' && $('input[name=email]').val() == ''
			&& $('input[name=phoneNo]').val() == '' && $('#rpwd').val() ==''){
			alert('您还有没填的呢');
			return;
		}
		$('#regist-form').submit();
	});
});

function checkMobile(str) {
   var re = /^1\d{10}$/;
   if (re.test(str)) {
       return true;
   } else {
       return false;
   }
}

function checkEmail(str){
   var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
   if(re.test(str)){
       return true;
   }else{
       return false;
   }
}

function checkUser(str){
   var re = /^[a-zA-z]\w{3,15}$/;
   if(re.test(str)){
       return true;
   }else{
       return false;
   }       
}

function checkPwd(str){
	var re=/^(\w){6,20}$/; 
    if(re.test(str)){
		return true;
	}else{
		return false;
	}       
}
</script>
</body>
</html>