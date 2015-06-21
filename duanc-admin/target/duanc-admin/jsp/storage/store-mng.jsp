<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <%@include file="/jsp/common/meta.jsp" %>
  <title>手掌-库存管理</title>
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
							<i class="icon-home home-icon"></i><a href="#">Home</a>
						</li>
						<li>
							<a href="#">手机中心</a>
						</li>
						<li class="active">库存管理</li>
					</ul><!-- .breadcrumb -->						
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<form:form action="${ctx }/authc/get-stores?menuId=${menuId }&subMenuId=${subMenuId }" method="post" 
									commandName="storageDTO" id="query-form">
								<form:select path="phone.brandId" id="brandId" cssClass="input-medium">
									<form:option value="" label="请选择"/>
									<form:options items="${brands }"/>
								</form:select>
								<form:select path="phone.modelId" id="modelId" cssClass="input-medium">
									<form:option value="" label="请选择"/>
									<c:if test="${storageDTO.phone.brandId != null}">
										<spring:eval expression="@brandAndModelService.getModelMapByBrand('${storageDTO.phone.brandId }')" var="models"/>
										<form:options items="${models }"/>
									</c:if>
								</form:select>
								<form:select path="phoneId" cssClass="input-medium">
									<form:option value="" label="请选择"/>
									<c:if test="${storageDTO.phone.modelId != null}">
										<spring:eval expression="@phoneService.getPhonesMap('${storageDTO.phone.modelId }')" var="phones"/>
										<form:options items="${phones }"/>
									</c:if>
								</form:select>
								<br><br>
								<form:select path="status" cssClass="input-medium">
									<form:option value="" label="请选择"/>
									<form:options items="${status }"/>
								</form:select>
								<br><br>
								<button id="query-btn" type="submit" class="btn btn-sm btn-primary"><i class="icon-search"></i> 查询</button>
							</form:form>
							<br>
							
							<div class="table-responsive">
								<div class="table-header">
									手机列表
									<a href="${ctx }/authc/store-in?menuId=8&subMenuId=9" class="btn btn-sm btn-inverse" style="float:right;height:38px;"><i class="icon-plus"></i> 添加入库</a>
								</div>
								<table id="sample-table-2" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th width="30">#</th>
											<th width="180">流水号</th>
											<th width="260">手机名称</th>
											<th width="100"></th>
											<th width="60">数量</th>
											<th width="100">入库价格</th>
											<th width="60">类型</th>
											<th width="100">操作</th>
										</tr>
									</thead>
									<tbody>
									    <c:if test="${fn:length(pagination.dataList) == 0}">
									    	<tr height=30px>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
									    </c:if>
										<c:forEach items="${pagination.dataList}" var="item" varStatus="status" begin="0" end="${fn:length(pagination.dataList)}">
											<tr>
												<td>${status.index + 1}</td>
												<td>${item.storageId }</td>
												<td>${item.phone.brandName } ${item.phone.modelName } ${item.phone.version }</td>
												<td>
													<img alt="" src="${picPath }${item.phone.picUrl }" width=50px height=40px>
												</td>
												<td>${item.count }</td>
												<td>${item.price }</td>
												<td>${item.statusName }</td>
												<td></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="clearfix form-actions" style="margin-top: -15px;">
							<div class="table-pagination" id="kkpager" style="float:right;margin-right:10px; margin-top: 5px;"></div>
							</div>
							<!-- PAGE CONTENT ENDS -->
						</div><!-- /.col -->
					</div><!-- /.row -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->
		</div>	
		
		<!-- Modal -->
		<div class="modal fade" id="check-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  			<div class="modal-dialog">
    			<div class="modal-content" style="margin-top:25%;margin-left:10%;width:400px;">
      				<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        				<h4 class="modal-title">是否确认删除？</h4>
        				<input type="hidden" id="check-data-hidden">
      				</div>
      				<div class="modal-footer">
        				<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    					<button type="button" class="btn btn-primary" id="verify-btn" style="float:left;">确认</button>
      				</div>
    			</div>
  			</div>
		</div>
		
		<%@include file="/jsp/common/toggle.jsp" %>
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
<%@include file="/jsp/common/js.jsp" %>
<!-- page specific plugin scripts start -->
<!-- page specific plugin scripts end -->
<script type="text/javascript">
 /**删除phone*/
var delPhone = function(obj) {
	$('#check-data-hidden').val(obj);
	$('#check-modal').modal();
} 

$(function(){
	kkpager.generPageHtml({
		pno : '${pagination.current}',
		total : '${pagination.count}',
		totalRecords : '${pagination.total}',
		isShowPageSize : true,
		hrefFormer : '${ctx}/authc/get-stores',
		getLink : function(n) {
			var queryString = $('#query-form').serialize();
			return this.hrefFormer + '?menuId=${menuId }&subMenuId=${subMenuId }&current=' + n + '&' + queryString;
		}
	});
	
	$('#verify-btn').click(function(){
		var obj = $('#check-data-hidden').val();
		$.ajax({
			url : '${ctx }/authc/ajax-del-phone',
			type : 'post',
			dataType : 'json',
			data : {id : obj},
			success : function(data) {
				console.log(data);
				if(data != null && data.success == true){
					alert(data.massage);
					window.location.href = window.location.href;
				} else {
					alert('操作失败');
				}
			},
			error : function() {
				alert('操作失败');
				$('#check-modal').modal('hide');
			}
		});
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
	
});
</script>
</body>
</html>