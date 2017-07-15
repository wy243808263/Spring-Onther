<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/dynamic/link/taglib.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:forEach var="v" items="${page.list}">
	   <tr id="${v.id}" align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#F1F8B4';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
			<td><div align="center"><input type="checkbox" value="${v.id}" class="subBox"/></div></td>
			<td><div align="center">${v.brand.name}</div></td>
			<td><div align="center">${v.items.name}</div></td>
			<td><div align="center">${v.name}</div></td>
			<td><div align="center">${v.amount}</div></td>
			<td title="${v.expound}"><div align="center"><c:if test="${fn:length(v.expound)>12}">${ fn:substring(v.expound ,0,12)}...</c:if><c:if test="${fn:length(v.expound)<=12 }">${v.expound}</c:if></div></td>
			<td><div align="center"><a href="#" onclick="toModify('<%=path %>/server/goods!findById.action?goods.id=${v.id}',350,550);return false;" style="cursor: pointer;">修改</a>&nbsp;<a href="#" onclick="removeById('<%=path %>/server/goods!removeById.action?goods.id=${v.id}',${v.id});return false;" style="cursor: pointer;">删除</a></div></td>
		</tr>
</c:forEach>
