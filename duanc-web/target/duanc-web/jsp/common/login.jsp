<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!-- 模态框 -->
	<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-2">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">
				<span>Palm <i class="am-icon-tablet"></i> 手掌</span><a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
			</div>
			<br>
			<div class="am-modal-bd">
				<div class="am-g">
					<div class="am-u-lg-11" style="margin-left:20px;">
						<div class="am-input-group">
  							<span class="am-input-group-label"><i class="am-icon-user am-icon-fw"></i></span>
  							<input type="text" id="username" class="am-form-field" placeholder="Username">
						</div>
						<br>
						<div class="am-input-group">
  							<span class="am-input-group-label"><i class="am-icon-lock am-icon-fw"></i></span>
 	 						<input type="password" id="password" class="am-form-field" placeholder="Password">
						</div>
						<br>
						
  						<button type="button" class="am-btn am-btn-primary am-btn-block" id="login-btn" onclick="login(this);">登录</button>
  						<button type="button" class="am-btn am-btn-default am-btn-block" id="lost-pwd">忘记密码</button>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
