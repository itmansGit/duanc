<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <%@include file="/jsp/common/meta.jsp" %>
  <title>手掌-机型管理</title>
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
							<a href="#">手机中心</a>
						</li>
						<li class="active">机型管理</li>
					</ul><!-- .breadcrumb -->						
				</div>
				
				
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<form:form action="${ctx }/authc/model-mng?menuId=${menuId }&subMenuId=${subMenuId }" method="post" commandName="brandDTO" id="query-form">
								<form:select path="id" cssClass="input-medium">
									<form:option value="" label="请选择"/>
									<form:options items="${brands }"/>
								</form:select>
								<button id="query-btn" type="submit" class="btn btn-sm btn-primary"><i class="icon-search"></i> 查询</button>
							</form:form>
							<br>
																											
							<div class="table-responsive">
								<button id="add-btn" class="btn btn-inverse" style="float:right;"><i class="icon-plus"></i> 添加</button>
								<table id="sample-table-2" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>#</th>
											<th>ID</th>
											<th>机型名称</th>
											<th class='hidden-350'>品牌名称</th>
											<th class='hidden-480'>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pagination.dataList}" var="item" varStatus="status" begin="0" end="${fn:length(pagination.dataList)}">
											<tr>
												<td width="100">${status.index + 1}</td>
												<td width="100">${item.id }</td>
												<td width="100">${item.modelName }</td>
												<td width="100">${item.brandName }</td>
												<td width="100">
													<button class="btn btn-xs btn-primary" onclick="updateModel(${item.id });"><i class="icon-pencil"></i> 修改</button>
													<button class="btn btn-xs btn-warning" onclick="delModel(${item.id });"><i class="icon-trash"></i> 删除</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="table-pagination" id="kkpager" style="float:right;margin-right:10px;"></div>
							<!-- PAGE CONTENT ENDS -->
						</div><!-- /.col -->
					</div><!-- /.row -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->
		</div>	
		
		<!-- Modal -->
		<div class="modal fade" id="input-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  			<div class="modal-dialog">
    			<div class="modal-content" style="margin-top:25%;margin-left:10%;width:400px;">
      				<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        				<h4 class="modal-title" id="modal-title"></h4>
      				</div>
     	 			<div class="modal-body">
        				<input type="hidden" id="url-hidden">
  						<input type="hidden" id="data-hidden">
    					<label>机型名称:<input id="model-name" type="text" class="input-large" placeholder="请输入机型名称"></label>
      				</div>
      				<div class="modal-footer">
        				<button type="button" class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
    					<button type="button" class="btn btn-primary" id="save-btn">保存</button>
      				</div>
    			</div>
  			</div>
		</div>
		
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
/**删除model*/
var delModel = function(obj) {
	$('#check-data-hidden').val(obj);
	$('#check-modal').modal();
}

/**修改model*/
var updateModel = function(obj) {
	$('#modal-title').text('修改机型');
	$('#data-hidden').val(obj);
	$('#url-hidden').val('${ctx }/authc/ajax-update-model');
	$('#input-modal').modal();
}

$(function(){
	
	kkpager.generPageHtml({
		pno : '${pagination.current}',
		total : '${pagination.count}',
		totalRecords : '${pagination.total}',
		isShowPageSize : true,
		hrefFormer : '${ctx}/authc/model-mng',
		getLink : function(n) {
			var queryString = $('#query-form').serialize();
			return this.hrefFormer + '?menuId=${menuId }&subMenuId=${subMenuId }&current=' + n + '&' + queryString;
		}
	});
	
	$('#add-btn').click(function(){
		$('#modal-title').text('添加机型');
		$('#url-hidden').val('${ctx }/authc/ajax-add-model');
		$('#input-modal').modal();
	});
	
	$('#save-btn').click(function(){
		var modelName = $('#model-name').val();
		var brandId = $('#id').val();
		var id = $('#data-hidden').val();
		var url = $('#url-hidden').val();
		console.log(id);
		console.log("modelName : " + modelName + "  brandId : " + brandId);
		
		$.ajax({
			url : url,
			type : 'post',
			dataType : 'json',
			data : {modelName : modelName, brandId : brandId, id : id},
			success : function(data) {
				console.log(data);
				if(data != null && data.success == true){
					alert(data.massage);
					window.location.href = window.location.href;
				} else {
					alert('添加失败');
				}
			},
			error : function() {
				alert('添加失败');
				$('#input-modal').modal('hide');
			}
		});
	});
	
	$('#verify-btn').click(function(){
		var obj = $('#check-data-hidden').val();
		$.ajax({
			url : '${ctx }/authc/ajax-del-model',
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
});
</script>
</body>
</html>