<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/static/skin/server/css/base.css" rel="stylesheet" type="text/css" />
<script src="/static/skin/server/js/common.js" type="text/javascript"></script>

<style>
body { padding:0px; margin:0px; }
#tpa {
	color: #009933;
	margin:0px;
	padding:0px;
	float:right;
	padding-right:10px;
}

#tpa dd {
	margin:0px;
	padding:0px;
	float:left;
	margin-right:2px;
}

#tpa dd.ditem {
	margin-right:8px;
}

#tpa dd.img {
  padding-top:6px;
}

div.item
{
  text-align:center;
	background:url(/static/skin/server/images/frame/topitembg.gif) 0px 3px no-repeat;
	width:82px;
	height:26px;
	line-height:28px;
}

.itemsel {
  width:80px;
  text-align:center;
  background:#226411;
	border-left:1px solid #c5f097;
	border-right:1px solid #c5f097;
	border-top:1px solid #c5f097;
	height:26px;
	line-height:28px;
}

*html .itemsel {
	height:26px;
	line-height:26px;
}

a:link,a:visited {
 text-decoration: underline;
}

.item a:link, .item a:visited {
	font-size: 12px;
	color: #ffffff;
	text-decoration: none;
	font-weight: bold;
}

.itemsel a:hover {
	color: #ffffff;
	font-weight: bold;
	border-bottom:2px solid #E9FC65;
}

.itemsel a:link, .itemsel a:visited {
	font-size: 12px;
	color: #ffffff;
	text-decoration: none;
	font-weight: bold;
}

.itemsel a:hover {
	color: #ffffff;
	border-bottom:2px solid #E9FC65;
}

.rmain {
  padding-left:10px;
  /* background:url(skin/images/frame/toprightbg.gif) no-repeat; */
}
</style>
<script>
	function logout(){
		var f = confirm('确定要注销登录?');
		if(!f)
			return false;
		top.location.href = '<%=path %>/logout.sec';
	}
</script>
</head>
<body bgColor='#ffffff'>
<table width="100%" border="0" cellpadding="0" cellspacing="0" background="/static/skin/server/images/frame/topbg.gif">
  <tr>
    <td width='30%' height="60">
    <!--
    <img src="/static/skin/server/images/frame/logo3-2.gif" />
    -->
   <h1 style="font-weight:bold; font-style:italic; font-size:195%; color:black;">商品存销管理系统</h1>
    </td> 
    <td width='80%' align="right" valign="bottom">
    	<table width="750" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	      <td align="right" height="26" style="padding-right:10px;line-height:26px;">
	        	尊敬的&nbsp;<a href="#"><sec:authentication property="name" /></a>&nbsp;您好，欢迎使用商品存销管理系统！
	        	[<a href="#">网站主页</a>]
	        	<sec:authorize ifAnyGranted="ROOT,ADMIN,EMPLOYEE,CUSTOMER">[<a href="<%=path %>/server/own!info_own.action" target="main">修改资料</a>]</sec:authorize>
	        	[<a href="#" onclick="logout();return false;">安全退出</a>]&nbsp;
	      </td>
	      </tr>
	      <tr>
	        <td align="right" height="34" class="rmain">
			<dl id="tpa">
			<dd class='img'><a href="javascript:ChangeMenu(-1);"><img vspace="5" src="/static/skin/server/images/frame/arrl.gif" border="0" width="5" height="8" alt="缩小左框架"  title="缩小左框架" /></a></dd>
			<dd class='img'><a href="javascript:ChangeMenu(0);"><img vspace="3" src="/static/skin/server/images/frame/arrfc.gif" border="0" width="12" height="12" alt="显示/隐藏左框架" title="显示/隐藏左框架" /></a></dd>
			<dd class='img' style="margin-right:10px;"><a href="javascript:ChangeMenu(1);"><img vspace="5" src="/static/skin/server/images/frame/arrr.gif" border="0" width="5" height="8" alt="增大左框架" title="增大左框架" /></a></dd>
			<dd><div class='itemsel' id='item1' onMouseMove="mv(this,'m',1);" onMouseOut="mv(this,'o',1);"><a href="<%=path %>/dynamic/server/view/menu.jsp" onclick="changeSel(1)" target="menu">主菜单</a></div></dd>
			</dl>
			</td>
	      </tr>
	    </table>
    </td>
  </tr>
</table>
</body>
</html>