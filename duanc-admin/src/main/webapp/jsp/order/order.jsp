<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <%@include file="/jsp/common/meta.jsp" %>
  <title>手掌-订单管理</title>
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
						<li class="active">手机管理</li>
					</ul><!-- .breadcrumb -->						
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<form:form action="${ctx }/authc/order-page?menuId=${menuId }&subMenuId=${subMenuId }" method="post" commandName="orderQO" id="query-form">
								<label>订单号：<form:input path="orderId"/></label>
								<label style="margin-left:50px;">用户名：<form:input path="username"/></label>
								<br>
								<label style="margin-top:10px;">品牌&型号：
								<form:select path="brandId" cssClass="input-medium" style="width: 180px;height: 40px;">
									<form:option value="" label="请选择"/>
									<form:options items="${brands }"/>
								</form:select>
								<form:select path="modelId" cssClass="input-medium" style="width: 180px;height: 40px;">
									<form:option value="" label="请选择"/>
									<c:if test="${orderQO.brandId != null}">
										<spring:eval expression="@brandAndModelService.getModelMapByBrand('${orderQO.brandId }')" var="models"/>
										<form:options items="${models }"/>
									</c:if>
								</form:select>
								</label>
								<label style="margin-top:10px;margin-left:50px;">订单状态：
									<form:select path="status" cssClass="input-medium" style="width: 180px;height: 40px;">
										<form:option value="" label="请选择"/>
										<form:options items="${status }"/>
									</form:select>
								</label>
								<br>
								<button id="query-btn" type="submit" class="btn btn-sm btn-primary"><i class="icon-search"></i> 查询</button>
							</form:form>
							
							<div class="table-responsive" style="margin-top:15px;">
								<div class="table-header">
									订单列表
								</div>
								<table id="sample-table-2" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>序号</th>
											<th>订单号</th>
											<th>用户</th>
											<th>商品信息</th>
											<th>收货地址</th>
											<th>数量</th>
											<th>价格</th>
											<th>状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pagination.dataList}" var="item" varStatus="status" begin="0" end="${fn:length(pagination.dataList)}">
											<tr>
												<td>${status.index + 1}</td>
												<td>${item.baseOrder.orderId}</td>
												<td>${item.baseUser.username }</td>
												<td>
													<img alt="" src="${picPath }${item.basePhone.picUrl }" 
						 								width=80px height=60px style="margin-right: 50px; margin-left: 80px;">
													${item.brandName } ${item.modelName } ${item.basePhone.version }
												</td>
												<td>${item.baseUserAddress.province }&nbsp;${item.baseUserAddress.city }&nbsp;${item.baseUserAddress.district }&nbsp;${item.baseUserAddress.detail }</td>
												<td>${item.baseOrderDetail.number}</td>
												<td>${item.baseOrderDetail.price}</td>
												<td>${item.status }</td>
												<td>
											<c:choose>
											<c:when test="${item.baseOrder.status == 1}">
												<button type="button" class="btn btn-primary" onclick="updataStatus(${item.baseOrder.orderId},2);">发货</button>
											</c:when>
											<c:when test="${item.baseOrder.status == 6}">
												<button type="button" class="btn btn-danger" onclick="updataStatus(${item.baseOrder.orderId},7);">通过审核</button>
											</c:when>
											<c:when test="${item.baseOrder.status == 7}">
												<button type="button" class="btn btn-danger" onclick="updataStatus(${item.baseOrder.orderId},8);">确认退货</button>
											</c:when>
											<c:otherwise>
											
											</c:otherwise>
											</c:choose>
										</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							
							<div class="clearfix form-actions" style="margin-top: 15px;">
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
 
var updataStatus = function(orderId,status){
	$.ajax({
		url : '${ctx}/authc/ajax-updata-status',
		type : 'post',
		dataType : 'json',
		data : {orderId : orderId, status : status},
		success : function(data){
			if(data.success){
				alert("操作成功！");
			} else{
				alert("操作失败！请稍后重试！");
			}
			location.reload(false); 	
		},
		error : function(){
			alert('系统异常请稍后再试');
		}
	});
}

$(function(){
	kkpager.generPageHtml({
		pno : '${pagination.current}',
		total : '${pagination.count}',
		totalRecords : '${pagination.total}',
		isShowPageSize : true,
		hrefFormer : '${ctx}/authc/phone-mng',
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
	
});
</script>
</body>
</html>