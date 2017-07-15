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
	$("#submitForm").validate({
		submitHandler:function(form){
			// 按钮灰化
			disabledBtn();
			$.post('<%=path %>/server/res!checkIsExist.action','res.id='+$('#id').val()+'&res.uri='+$('#uri').val()+'&array=edit',function(data){
				data = toJSON(data);
				if(!data.success){
					alert(data.message);
					undisabledBtn();
					return false;
				}else{
					// 表单提交
					$.ajax({
					   type: "post",
					   url: "<%=path %>/server/res!edit.action",
					   data: $("#submitForm").serialize(),
					   success: function(data){
						   data = toJSON(data);
						   if(data.success){
								var f = confirm(data.message);
								if(f){
									var p = window.dialogArguments;
									if(p != null)
									  p.pageMain();
									else
									  window.opener.pageMain();
								}
								window.close();
							}
					   },
					   error: function(){
						   alert("提交失败,请尝试重新提交!");
						   undisabledBtn();
						   return false;
					   }
					}); 
				}
			});
			return false;
		}
	});
});
</script>
</head>
<body leftmargin="8" topmargin="8" background='/static/skin/server/images/allbg.gif'>

<!-- head -->
<div id="head"></div>

<!-- 数据提交表单   -->
<form id="submitForm" method="post">
<input type="hidden" id="id" name="res.id" value="${res.id}" />
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="/static/skin/server/images/tbg.gif">修改资源</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">类型:</td>
	<td width="85%">
	<select name="res.mold" class="{required:true}">
		<option value="${res.mold}"><c:if test="${res.mold == 1}">访问路径</c:if><c:if test="${res.mold == 2}">元素编号</c:if></option>
		<option value="1">访问路径</option>
		<option value="2 ">元素编号</option>
	</select>&nbsp;<label class="lb_rq">*</label>
	</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">名称:</td>
	<td width="85%"><input type="text" name="res.expound" value="${res.expound}" style="width:150px;" class="{required:true,rangelength:[1,20]}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">路径:</td>
	<td width="85%"><input type="text" name="res.uri" id="uri" value="${res.uri}" style="width:150px;" class="{required:true,rangelength:[1,255]}" />&nbsp;<label class="lb_rq">*</label></td>
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