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
	});
	function pageMain(){
		initPage('<%=path %>/server/role!pageTotal.action', '<%=path %>/server/role!page.action', $('#offset').val(), $('#limit').val(), $('#searchForm').serialize());
	}
	function f5(){
		location.href = "<%=path %>/dynamic/server/role/page.jsp";
	}
</script>
</head>
<body leftmargin="8" topmargin="8" background='/static/skin/server/images/allbg.gif'>

<!-- head -->
<div id="head"></div>

<jsp:include page="/dynamic/link/params.jsp"></jsp:include>

<!--  搜索表单  -->
<form id="searchForm" method="post">
</form>
  
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#EEF4EA">
	<td height="24" colspan="4" background="/static/skin/server/images/tbg.gif" >&nbsp;<label>角色列表</label>&nbsp;<div style="float:right;margin-right:20px;">每页&nbsp;<select id="totalWav" onchange="changeTotalWav('#totalWav');"><option value="10">10</option><option value="5">5</option><option value="15">15</option><option value="20">20</option><option value="30">30</option><option value="50">50</option><option value="100">100</option></select>&nbsp;条,共计&nbsp;<label id="total">0</label>&nbsp;条记录</div></td>
</tr>

<tr align="right" bgcolor="#FAFAF1">
<td height="28" colspan="4">
	&nbsp;
	<a href="#" onclick="toAdd('<%=path %>/dynamic/server/role/add.jsp','350','550');return false;" class="coolbg">&nbsp;新增角色&nbsp;</a>
	<a href="#" onclick="removeForAll('<%=path %>/server/role!removeForAll.action');return false;" class="coolbg">&nbsp;删除选中&nbsp;</a>
	<a href="#" onclick="f5();" class="coolbg">&nbsp;刷新列表&nbsp;</a>
</td>
</tr>
<!-- 列表头部 -->
<tr align="center" bgcolor="#FAFAF1">
	<td class="theader" width="5%"><input type="checkbox" id="allBox" class="checkbox" /></td>
	<td class="theader" width="20%">名称</td>
	<td class="theader" width="20%">描述</td>
	<td class="theader" width="10%">操作</td>
</tr>
<!-- 列表内容 -->
<tbody id="substance">
</tbody>
<tr align="right" bgcolor="#FFFFFF">
	<td height="36" colspan="4" align="right">
		<!--翻页代码 -->
		<div id="pagination" class="pagination"></div>
	</td>
</tr>
</table>
</body>
</html>