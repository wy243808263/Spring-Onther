<%@ page language="java" pageEncoding="UTF-8"%>
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
			if($('#oldu').val() != $('#newu').val()){
				if($('#password').val() == ''){
					alert('账号名已经改变,为保证安全请输入密码!');
					return false;
				}
			}
			// 按钮灰化
			disabledBtn();
			// 表单提交
			$.post("<%=path %>/server/own!edit.action", $(form).serialize(), function(data){
				if(data == "success"){
					$("#password").val("");
					$("#confirm_password").val("");
					var f = confirm("提交成功,重新登录可获取最新信息!是否需要注销?");
					if(!f){
						undisabledBtn();
						return false;
					}
					top.location.href = "<%=path %>/logout.sec";
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
<input type="hidden" name="user.id" value="${user.id}" />
<input type="hidden" id="oldu" value="${user.username}" />
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="/static/skin/server/images/tbg.gif">修改个人资料</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">账号:</td>
	<td width="85%"><input type="text" style="width:150px;" id="newu" name="user.username"  value="${user.username}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">姓名:</td>
	<td width="85%"><input type="text" style="width:150px;" name="user.name" value="${user.name}" class="{required:true,rangelength:[1,13]}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td>新密码:</td>
	<td><input type="password" id="password" name="user.password" maxlength="13" style="width:150px;" class="{rangelength:[6,13]}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td>确认密码:</td>
	<td><input type="password" id="confirm_password" maxlength="13" style="width:150px;" class="{equalTo:'#password',rangelength:[6,13]}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">电话:</td>
	<td width="85%"><input type="text" name="user.phone" value="${user.phone}" style="width:150px;" class="{required:true,minlength:11,maxlength:11,phone:true}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">邮箱:</td>
	<td width="85%"><input type="text" name="user.email" value="${user.email}" style="width:150px;" class="{required:true,rangelength:[0,100],email:true}" />&nbsp;<label class="lb_rq">*</label></td>
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