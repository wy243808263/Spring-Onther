<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/dynamic/link/taglib.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- JavaScript Skin -->
<jsp:include page="/dynamic/link/crud.jsp"></jsp:include>

<script type="text/javascript">
$(function(){
	loadBrand();
	brandEvent();
	itemsEvent();
	submitForm('<%=path %>/server/sales!add.action', '#submitForm');
});

function loadBrand(){
	$.post('<%=path %>/server/brand!show.action','',function(data){
		var json = toJSON(data);
		$.each(json.value, function(i, v){
			$('#brand').append('<option value="'+v.id+'">'+v.name+'</option>');
		});
	});
}
function brandEvent(){
	$('#brand').change(function(){
		if($(this).val() == ''){
			$('#items').html('<option value="">选择...</option>');
			$('#goods').html('<option value="">选择...</option>');
		}else{
			$.post('<%=path %>/server/items!show.action','brandid='+$(this).val(),function(data){
				var json = toJSON(data);
				$('#items').html('<option value="">选择...</option>');
				$('#goods').html('<option value="">选择...</option>');
				$.each(json.value, function(i, v){
					$('#items').append('<option value="'+v.id+'">'+v.name+'</option>');
				});
			});
		}
	});
}
function itemsEvent(){
	$('#items').change(function(){
		if($(this).val() == ''){
			$('#goods').html('<option value="">选择...</option>');
		}else{
			$.post('<%=path %>/server/goods!show.action','itemsid='+$(this).val(),function(data){
				var json = toJSON(data);
				$('#goods').html('<option value="">选择...</option>');
				$.each(json.value, function(i, v){
					$('#goods').append('<option value="'+v.id+'">'+v.name+'</option>');
				});
			});
		}
	});
}
</script>
</head>
<body leftmargin="8" topmargin="8" background='/static/skin/server/images/allbg.gif'>
<script type="text/javascript" src="/static/plugin/My97DatePicker/WdatePicker.js"></script> 
<!-- head -->
<div id="head"></div>

<!-- 数据提交表单   -->
<form id="submitForm" method="post">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="/static/skin/server/images/tbg.gif">新增存销记录</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">类型:</td>
	<td width="85%">
	<select name="sales.mold" class="{required:true}">
		<option value="">选择...</option>
		<option value="1">进货</option>
		<option value="2">出货</option>
	</select>&nbsp;<label class="lb_rq">*</label>
	</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">品牌:</td>
	<td width="85%">
	<select id="brand" name="a" class="{required:true}">
		<option value="">选择...</option>
	</select>&nbsp;<label class="lb_rq">*</label>
	</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">分类:</td>
	<td width="85%">
	<select id="items" name="b" class="{required:true}">
		<option value="">选择...</option>
	</select>&nbsp;<label class="lb_rq">*</label>
	</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">商品:</td>
	<td width="85%">
	<select id="goods" name="sales.goods.id" class="{required:true}">
		<option value="">选择...</option>
	</select>&nbsp;<label class="lb_rq">*</label>
	</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">数量:</td>
	<td width="85%"><input type="text" name="sales.amount" style="width:150px;" class="{required:true,range:[1,999]}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">单价:</td>
	<td width="85%"><input type="text" name="sales.price" style="width:150px;" class="{required:true}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">时间:</td>
	<td width="85%"><input type="text" name="sales.establish" style="width:150px;" class="{required:true} Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">备注信息:</td>
	<td width="85%">
	<textarea rows="5" cols="50" name="sales.expound" class="{rangelength:[0,200]}"></textarea>
	</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td colspan="2" align="left">
		<div style="margin-left:150px;">
			<button type="submit" id="submitBtn" class="coolbg np">提交</button>&nbsp;<button id="resetBtn" type="reset" class="coolbg np">重置</button>
		</div>
	</td>
</tr>
</table>
</form>
</body>
</html>