<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<link rel="stylesheet" href="/static/skin/server/css/base.css" type="text/css" />
<link rel="stylesheet" href="/static/skin/server/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="/static/skin/server/js/menu.js"></script>
<base target="main" />
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
      <!-- Item 1 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items1_1")'><b>基本管理</b></dt>
        <dd style='display:block' class='sitem' id='items1_1'>
          <ul class='sitemu'>
           <li>
              <div class='items'>
                <div class='fllct'><a href='<%=path %>/dynamic/server/sales/page_in.jsp' target='main'>进货信息</a></div>
                <div class='flrct'> <a href='<%=path %>/dynamic/server/sales/page_in.jsp' target='main'><img src='/static/skin/server/images/frame/menuarrow.gif' alt='进货信息' title='进货信息'/></a> </div>
              </div>
            </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='<%=path %>/dynamic/server/sales/page_out.jsp' target='main'>出货信息</a></div>
                <div class='flrct'> <a href='<%=path %>/dynamic/server/sales/page_out.jsp' target='main'><img src='/static/skin/server/images/frame/menuarrow.gif' alt='出货信息' title='出货信息'/></a> </div>
              </div>
            </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='<%=path %>/dynamic/server/brand/page.jsp' target='main'>品牌信息</a></div>
                <div class='flrct'> <a href='<%=path %>/dynamic/server/brand/page.jsp' target='main'><img src='/static/skin/server/images/frame/menuarrow.gif' alt='品牌信息' title='品牌信息'/></a> </div>
              </div>
            </li>
             <li>
              <div class='items'>
                <div class='fllct'><a href='<%=path %>/dynamic/server/items/page.jsp' target='main'>分类信息</a></div>
                <div class='flrct'> <a href='<%=path %>/dynamic/server/items/page.jsp' target='main'><img src='/static/skin/server/images/frame/menuarrow.gif' alt='分类信息' title='分类信息'/></a> </div>
              </div>
            </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='<%=path %>/dynamic/server/goods/page.jsp' target='main'>商品信息</a></div>
                <div class='flrct'> <a href='<%=path %>/dynamic/server/goods/page.jsp' target='main'><img src='/static/skin/server/images/frame/menuarrow.gif' alt='商品信息' title='商品信息'/></a> </div>
              </div>
            </li>
          </ul>
        </dd>
      </dl>
      <!-- Item 1 End -->
      <!-- Item 2 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>角色权限</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
           <li>
              <div class='items'>
                <div class='fllct'><a href='<%=path %>/dynamic/server/res/page.jsp' target='main'>资源管理</a></div>
                <div class='flrct'> <a href='<%=path %>/dynamic/server/res/page.jsp' target='main'><img src='/static/skin/server/images/frame/menuarrow.gif' alt='资源管理' title='资源管理'/></a> </div>
              </div>
            </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='<%=path %>/dynamic/server/role/page.jsp' target='main'>角色管理</a></div>
                <div class='flrct'> <a href='<%=path %>/dynamic/server/role/page.jsp' target='main'><img src='/static/skin/server/images/frame/menuarrow.gif' alt='角色管理' title='角色管理'/></a> </div>
              </div>
            </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='<%=path %>/dynamic/server/group/page.jsp' target='main'>分组管理</a></div>
                <div class='flrct'> <a href='<%=path %>/dynamic/server/group/page.jsp' target='main'><img src='/static/skin/server/images/frame/menuarrow.gif' alt='分组管理' title='分组管理'/></a> </div>
              </div>
            </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='<%=path %>/dynamic/server/user/page.jsp' target='main'>用户管理</a></div>
                <div class='flrct'> <a href='<%=path %>/dynamic/server/user/page.jsp' target='main'><img src='/static/skin/server/images/frame/menuarrow.gif' alt='用户管理' title='用户管理'/></a> </div>
              </div>
            </li>
          </ul>
        </dd>
      </dl>
      <!-- Item 2 End -->
	  </td>
  </tr>
</table>
</body>
</html>