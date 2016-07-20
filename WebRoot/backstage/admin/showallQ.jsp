<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>admin/showallQ.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>
		<h2>问卷列表</h2>

		<hr>
		
		<table border="1" width="900" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<thead>
			<tr height="40" align="center">
				<th width="100" style="color:#1F85B6">问卷编号</th>
				<th width="400" style="color:#1F85B6">问卷名称</th>
				<th width="100" style="color:#1F85B6">发布日期</th>
				<th width="100" style="color:#1F85B6">启用状态</th>
				<th width="100" style="color:#1F85B6">查看</th>
			</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${ requestScope.pageVO.list }" var="qDetail">
				<tr align="center" height="40">
					<td>${qDetail.no }</td>
					<td>${qDetail.name }</td>
					<td>${qDetail.date }</td>
					<td>${qDetail.isopen }</td>
					<td><form method="post" action="${pageContext.request.contextPath}/admin/showUlist.action?qno=${qDetail.no }"><input type="submit" value="查看" style="margin-top: 20"></form></td>
				</tr>
				
				
			</c:forEach>
			
			
			<tbody>
			<tfoot>
			<tr>
				<td colspan="6" align="right"><form action="${pageContext.request.contextPath }/admin/${requestScope.actionName }.action" method="post">当前是第${requestScope.pageVO.page }页
				|共${ requestScope.pageVO.pageCount}页|
					<c:choose>
						<c:when test="${ requestScope.pageVO.page le 1 }">上一页</c:when>
						<c:otherwise>
							<a
								href="${pageContext.request.contextPath }/admin/${requestScope.actionName }.action?page=${ requestScope.pageVO.page - 1 }">上一页</a>
						</c:otherwise>
					</c:choose> 
					|跳转到<input name="page" id="page" type="text" style="width:30px;"><input type="submit" value="跳转" style="width:50px;">&nbsp;|
					<c:choose>
						<c:when test="${ requestScope.pageVO.page ge requestScope.pageVO.pageCount }">下一页</c:when>
						<c:otherwise>
						<a
								href="${pageContext.request.contextPath }/admin/${requestScope.actionName }.action?page=${ requestScope.pageVO.page +1 }">下一页</a>
						</c:otherwise>
					</c:choose>
					</form></td>
			</tr>
		</tfoot>
		</table>
		
	</center>
  </body>
</html>
