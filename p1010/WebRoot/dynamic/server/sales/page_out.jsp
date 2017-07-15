<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<jsp:include page="/dynamic/link/page.jsp"></jsp:include>

<script>
	$(function(){ // 初始化分页参数
		pageMain();
		loadBrand();
		brandEvent();
		itemsEvent();
	});
	function pageMain(){
		initPage('<%=path %>/server/sales!pageTotal.action', '<%=path %>/server/sales!page.action', $('#offset').val(), $('#limit').val(), $('#searchForm').serialize());
	}
	function f5(){
		location.href = "<%=path %>/dynamic/server/sales/page.jsp";
	}

	function loadBrand(){
		$.post('<%=path %>/server/brand!show.action','',function(data){
			var json = eval('('+data+')');
			$.each(json.value, function(i, v){
				$('#brand').append('<option value="'+v.id+'">'+v.name+'</option>');
			});
		});
	}
	function brandEvent(){
		$('#brand').change(function(){
			if($(this).val() == ''){
				$('#items').html('<option value="">分类...</option>');
				$('#goods').html('<option value="">商品...</option>');
			}else{
				$.post('<%=path %>/server/items!show.action','brandid='+$(this).val(),function(data){
					var json = eval('('+data+')');
					$('#items').html('<option value="">分类...</option>');
					$('#goods').html('<option value="">商品...</option>');
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
				$('#goods').html('<option value="">商品...</option>');
			}else{
				$.post('<%=path %>/server/goods!show.action','itemsid='+$(this).val(),function(data){
					var json = eval('('+data+')');
					$('#goods').html('<option value="">商品...</option>');
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

<jsp:include page="/dynamic/link/params.jsp"></jsp:include>

<!--  搜索表单  -->
<form id="searchForm" action="" method="post">
<input type="hidden" value="2" name="mold" />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='/static/skin/server/images/wbg.gif' align='center' bgcolor='#E7E7E7'>
      <table border='0' cellpadding='0' bgcolor='#E7E7E7' cellspacing='0'>
       <tr>
	   <td rowspan="2">搜索条件：<td>
		 <td>
			<table border='0' cellpadding='0' bgcolor='#E7E7E7' cellspacing='0'>
				<tr>
					<td>
					  <select id="brand" name="brand" class="{required:true}">
						<option value="">品牌...</option>
					</select>
					  &nbsp;
					 </td>
					 <td>
					  <select id="items" name="items" class="{required:true}">
						<option value="">分类...</option>
					</select>
					  &nbsp;
					 </td>
					 <td>
					  <select id="goods" name="goods" class="{required:true}">
							<option value="">商品...</option>
						</select>
					  &nbsp;
					 </td>
					<td>
						月份：<input type='text' name='start'' style='width:120px' onclick="WdatePicker({dateFmt:'yyyy-MM-dd 00:00:00'});" />&nbsp;至&nbsp;<input type='text' name='ends'' style='width:120px'  onclick="WdatePicker({dateFmt:'yyyy-MM-dd 00:00:00'});" />&nbsp;
					</td>
				</tr>
			</table>
		 </td>
		 <td>&nbsp;<input type="image" alt="搜索" onclick="pageMain();return false;" title="search" src="/static/skin/server/images/frame/search.gif" width="45" height="20" border="0" style="margin-top:5px;" class="np" /></td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
  
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#EEF4EA">
	<td height="24" colspan="9" background="/static/skin/server/images/tbg.gif" >&nbsp;<label>出货记录列表</label>&nbsp;<div style="float:right;margin-right:20px;">每页&nbsp;<select id="totalWav" onchange="changeTotalWav('#totalWav');"><option value="10">10</option><option value="5">5</option><option value="15">15</option><option value="20">20</option><option value="30">30</option><option value="50">50</option><option value="100">100</option></select>&nbsp;条,共计&nbsp;<label id="total">0</label>&nbsp;条记录</div></td>
</tr>

<tr align="right" bgcolor="#FAFAF1">
<td height="28" colspan="9">
	&nbsp;
	<a href="#" onclick="toAdd('<%=path %>/dynamic/server/sales/add.jsp','380','550');return false;" class="coolbg">&nbsp;新增记录&nbsp;</a>
	<a href="#" onclick="removeForAll('<%=path %>/server/sales!removeForAll.action');return false;" class="coolbg">&nbsp;删除选中&nbsp;</a>
	<a href="#" onclick="f5();" class="coolbg">&nbsp;刷新列表&nbsp;</a>
</td>
</tr>
<!-- 列表头部 -->
<tr align="center" bgcolor="#FAFAF1">
	<td class="theader" width="5%"><input type="checkbox" id="allBox" class="checkbox" /></td>
	<td class="theader" width="10%">类型</td>
	<td class="theader" width="10%">用户</td>
	<td class="theader" width="10%">商品</td>
	<td class="theader" width="10%">数量</td>
	<td class="theader" width="10%">单价</td>
	<td class="theader" width="10%">时间</td>
	<td class="theader" width="20%">备注</td>
	<td class="theader" width="10%">操作</td>
</tr>
<!-- 列表内容 -->
<tbody id="substance">
</tbody>
<tr align="right" bgcolor="#FFFFFF">
	<td height="36" colspan="9" align="right">
		<!--翻页代码 -->
		<div id="pagination" class="pagination"></div>
	</td>
</tr>
</table>
</body>
</html>