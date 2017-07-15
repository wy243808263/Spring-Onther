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
var check = false;
$(function(){
	$("#submitForm").validate({
		submitHandler:function(form){
			// 按钮灰化
			disabledBtn();
			$.post('<%=path %>/server/user!checkUser.action?ver='+new Date(),'user.username='+$("#username").val(),function(data){
				data = toJSON(data);
				if(!data.success){
					alert(data.message);
					undisabledBtn();
					return false;
				}else{
					// 表单提交
					$.ajax({
					   type: "post",
					   url: "<%=path %>/server/user!add.action",
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
							}else{
								alert(data.message);
								return false;
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
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="/static/skin/server/images/tbg.gif">新增用户账号</td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">账号:</td>
	<td width="85%"><input type="text" id="username" name="user.username" style="width:150px;" class="{required:true,rangelength:[2,13]}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td width="15%">姓名:</td>
	<td width="85%"><input type="text" name="user.name" style="width:150px;" class="{required:true,rangelength:[1,13]}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td>新密码:</td>
	<td><input type="password" id="password" name="user.password" maxlength="13" style="width:150px;" class="{required:true,rangelength:[6,13]}" />&nbsp;<label class="lb_rq">*</label></td>
</tr>
<tr align="left" bgcolor="#FAFAF1">
	<td>确认密码:</td>
	<td><input type="password" id="confirm_password" maxlength="13" style="width:150px;" class="{required:true,equalTo:'#password',rangelength:[6,13]}" />&nbsp;<label class="lb_rq">*</label></td>
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
			<button type="submit" id="submitBtn" class="coolbg np">提交</button>&nbsp;<button id="resetBtn" type="reset" class="coolbg np" OnClick="checkLevel();">重置</button>
		</div>
	</td>
</tr>
</table>
</form>
</body>
</html>