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
	submitForm('<%=path %>/server/role!add.action', '#submitForm');
});

</script>
</head>
<body leftmargin="8" topmargin="8" background='/static/skin/server/images/allbg.gif'>

<!-- head -->
<div id="head"></div>

<!-- 数据提交表单   -->
<form id="submitForm" method="post">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="/static/skin/server/images/tbg.gif">新增角色</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">名称:</td>
	<td width="85%"><input type="text" name="role.name" style="width:150px;" class="{required:true,rangelength:[1,20]}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">描述:</td>
	<td width="85%"><input type="text" name="role.expound" style="width:150px;" class="{required:true,rangelength:[1,255]}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td colspan="2" align="left">
		<div style="margin-left:150px;">
			<button type="submit" id="submitBtn" class="coolbg np">提交</button>&nbsp;<button id="roleetBtn" type="roleet" class="coolbg np">重置</button>
		</div>
	</td>
</tr>
</table>
</form>
</body>
</html>