<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/dynamic/link/taglib.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:forEach var="v" items="${page.list}">
	   <tr id="${v.id}" align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#F1F8B4';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
			<td><div align="center"><input type="checkbox" value="${v.id}" class="subBox"/></div></td>
			<td><div align="center">${v.username}</div></td>
			<td><div align="center">${v.name}</div></td>
			<td><div align="center">${v.phone}</div></td>
			<td><div align="center">${v.email}</div></td>
			<td><div align="center"><c:if test="${v.status == 1}">正常</c:if></div></td>
			<td><div align="center"><a href="#" onclick="toModify('<%=path %>/server/user!findByIdForAllot.action?user.id=${v.id}',350,550);return false;" style="cursor: pointer;">分组</a>&nbsp;<a href="#" onclick="toModify('<%=path %>/server/user!findById.action?user.id=${v.id}',350,550);return false;" style="cursor: pointer;">修改</a>&nbsp;<a href="#" onclick="removeById('<%=path %>/server/user!removeById.action?user.id=${v.id}',${v.id});return false;" style="cursor: pointer;">删除</a></div></td>
		</tr>
</c:forEach>
