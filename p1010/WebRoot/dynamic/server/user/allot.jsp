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
var pending = false;
function allot(group, user){
	if(pending){
		alert("正在处理中...");
		return false;
	}
	pending = true;
	var current = jQuery("#checkbox" + group);
	var sel = current.attr("checked");
	var url = "";
	if(sel == undefined){
		url = "<%=path %>/server/group!removeRelate.action";
	}else if(sel == "checked"){
		url = "<%=path %>/server/group!addRelate.action";
	}
	jQuery.post(url, "ver="+new Date().getTime()+"&group.id="+group+"&user.id="+user, function(data){
		data = toJSON(data);
		if(data.success){
			alert(data.message);
		}else{
			alert(data.message);
		}
		pending = false;
	});
}
</script>
</head>
<body leftmargin="8" topmargin="8" background='/static/skin/server/images/allbg.gif'>

<!-- head -->
<div id="head"></div>

<!-- 数据提交表单   -->
<form id="submitForm" method="post">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="/static/skin/server/images/tbg.gif">设置用户分组</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">用户名称:</td>
	<td width="85%">${user.name}&nbsp;(登录名:${user.username})<input type="hidden" value="${user.id}" id="role"/>&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">设置分组:</td>
	<td width="85%" id="allot">
	<c:forEach var="v" items="${allotGroup}" varStatus="st"><c:if test="${st.count%5==0}"><br /></c:if><label id="label${v.id}"><input type="checkbox" class="checkbox" checked="checked" id="checkbox${v.id}" onclick="allot(${v.id},${user.id});" value="${v.id}" />${v.expound}&nbsp;</label></c:forEach>
	<c:forEach var="v" items="${notAllotGroup}" varStatus="st"><c:if test="${st.count%5==0}"><br /></c:if><label id="label${v.id}"><input type="checkbox" class="checkbox" id="checkbox${v.id}" onclick="allot(${v.id},${user.id});" value="${v.id}" value="${v.id}" />${v.expound}&nbsp;</label></c:forEach>
	</td>
</tr>
</table>
</form>
</body>
</html>