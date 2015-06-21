<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <%@include file="/jsp/common/meta.jsp" %>
  <title>库存管理-手机入库</title>
  <%@include file="/jsp/common/css.jsp" %>
</head>
<body class="skin-3">
	<%@include file="/jsp/common/top.jsp" %>
	<div class="main-container" id="main-container">			
		<div class="main-container-inner">	
			<!-- 菜单开始 -->
			<%@include file="/jsp/common/sidebar.jsp" %>
			<!-- 菜单结束 -->							
			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">						
					<ul class="breadcrumb">
						<li>
							<i class="icon-home home-icon"></i>
							<a href="#">Home</a>
						</li>
						<li>
							<a href="#">库存管理</a>
						</li>
						<li class="active">手机入库</li>
					</ul><!-- .breadcrumb -->						
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="col-sm-offset-1 col-sm-10">
								<div class="space"></div>
								<form:form class="form-horizontal" method="post" action="${ctx }/authc/store-in?menuId=${menuId }&subMenuId=${subMenuId }" 
										id="submit-form" commandName="storageDTO">
									<div class="tabbable">
										<div class="tab-content profile-edit-tab-content">
											<div id="edit-basic" class="tab-pane in active">
												<h4 class="header blue bolder smaller">General</h4>
												<div class="row">
													<div class="col-xs-12 col-sm-12">
														<div class="form-group">
															<label class="col-sm-4 control-label no-padding-right">*品牌</label>
															<div class="col-sm-6">
																<form:select path="phone.brandId" id="brandId" class="input-large">
																	<form:option value="">请选择</form:option>
																	<form:options items="${brands }"/>
																</form:select>
															</div>
														</div>
														<div class="space-4"></div>
														<div class="form-group">
															<label class="col-sm-4 control-label no-padding-right">*机型</label>
															<div class="col-sm-6">
																<form:select path="phone.modelId" id="modelId" cssClass="input-large">
																	<form:option value="" label="请选择"/>
																	<c:if test="${storageDTO.phone.brandId != null}">
																		<spring:eval expression="@brandAndModelService.getModelMapByBrand('${storageDTO.phone.brandId }')" var="models"/>
																		<form:options items="${models }"/>
																	</c:if>
																</form:select>
															</div>
														</div>
														<div class="space-4"></div>
														<div class="form-group">
															<label class="col-sm-4 control-label no-padding-right">*版本</label>
															<div class="col-sm-6">
																<form:select path="phoneId" cssClass="input-large">
																	<form:option value="" label="请选择"/>
																	<c:if test="${storageDTO.phone.modelId != null}">
																		<spring:eval expression="@phoneService.getPhonesMap('${storageDTO.phone.modelId }')" var="phones"/>
																		<form:options items="${phones }"/>
																	</c:if>
																</form:select>
															</div>
														</div>
														<div class="space-4"></div>
														<div class="form-group">
															<label class="col-sm-4 control-label no-padding-right">*数量</label>
															<div class="col-sm-6">
																<form:input path="count" class="input-large" placeholder="200"/>
															</div>
														</div>
														<div class="space-4"></div>
														<div class="form-group">
															<label class="col-sm-4 control-label no-padding-right">*价格</label>
															<div class="col-sm-6">
																<div class="input-medium">
																	<div class="input-group">
																		<form:input path="price" placeholder="2000.00"/>
																		<span class="input-group-addon">￥</span>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="button" id="save-btn">
												<i class="icon-ok bigger-110"></i>
												Save
											</button>
												&nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="icon-undo bigger-110"></i>
												Reset
											</button>
										</div>
									</div>
								</form:form>
							</div><!-- /span -->
							<!-- PAGE CONTENT ENDS -->
						</div><!-- /.col -->
					</div><!-- /.row -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->
		</div>	
		
		<%@include file="/jsp/common/toggle.jsp" %>
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
<%@include file="/jsp/common/js.jsp" %>
<!-- page specific plugin scripts start -->
<script src="${staticUrl}/resources/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${staticUrl}/resources/assets/js/fuelux/fuelux.spinner.min.js"></script>
<script src="${staticUrl}/resources/assets/js/jquery.maskedinput.min.js"></script>
<!-- page specific plugin scripts end -->
<script type="text/javascript">
window.onload = function(){
	if(null != '${OptionResult.message}' && '' != '${OptionResult.message}') {
		alert('${OptionResult.message}');
	}
	if(null != '${phoneDTO.picUrl}' && '' != '${phoneDTO.picUrl}') {
		$('#img').attr('src','${picPath }${phoneDTO.picUrl }');
	}
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
	$('#save-btn').click(function(){
		$('#submit-form').submit();
	});
	
	
	
	$('#edit-basic')
	.find('button[type=reset]').on(ace.click_event, function(){
		$('#user-profile-3 input[type=file]').ace_file_input('reset_input');
	})
	.end().find('.date-picker').datepicker().next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
	
	$('#brandId').change(function(){
		var brandId =  $(this).val();
		console.log('brandId:' + brandId);
		$('#modelId').empty();
		$('#modelId').append('<option value="">请选择</option>');
		if("" == brandId) {
			return;
		}
		$.ajax({
			url : '${ctx }/authc/ajax-init-model',
			type : 'post',
			dataType : 'json',
			data : {brandId : brandId},
			success : function(data) {
				console.log(data);
				$.each(data, function(i, item) {
					$('#modelId').append('<option value="' + item.modelId + '">' + item.modelName +'</option>');
				});
			},
			error : function() {
			}
		});
	});
	
	$('#modelId').change(function(){
		var modelId =  $(this).val();
		console.log('modelId:' + modelId);
		$('#phoneId').empty();
		$('#phoneId').append('<option value="">请选择</option>');
		if("" == modelId) {
			return;
		}
		$.ajax({
			url : '${ctx }/authc/ajax-init-phone',
			type : 'post',
			dataType : 'json',
			data : {modelId : modelId},
			success : function(data) {
				console.log(data);
				$.each(data, function(i, item) {
					$('#phoneId').append('<option value="' + item.phoneId + '">' + item.phoneName +'</option>');
				});
			},
			error : function() {
			}
		});
	});
	
	$('#img').click(function(){
		$('#file').click();
	});
	
});
</script>
</body>
</html>