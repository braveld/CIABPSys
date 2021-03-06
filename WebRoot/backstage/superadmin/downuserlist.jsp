<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'downuserlist.jsp' starting page</title>
    
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
		<h2>会员列表</h2>

		<hr>
		
		<table border="1" width="900" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<thead>
			<tr height="40" align="center">
				<th width="100" style="color:#1F85B6">编号</th>
				<th width="400" style="color:#1F85B6">用户名</th>
				<th width="100" style="color:#1F85B6">真实姓名</th>
				<th width="100" style="color:#1F85B6">状态</th>
				<th width="100" style="color:#1F85B6">查看/修改</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ requestScope.upageVO.list }" var="user">
				<tr align="center" height="40">
					<td>${user.no }</td>
					<td>${user.nick }</td>
					<td>${user.name }</td>
					<td>${user.qstatus}</td>
					<td>
					<c:choose>
						<c:when test="${ user.qstatus=='已填'}"><form method="post" action="${pageContext.request.contextPath}/admin/showUQ.action?qno=${ requestScope.qno }&no=${user.no 

}"><input type="submit" value="查看" style="margin-top: 20"></form></c:when>
						<c:otherwise>
							<form method="post" action="${pageContext.request.contextPath}/admin/luruabc.action?qno=${ requestScope.qno }&no=${user.no}&page=${ requestScope.page }"><input type="submit" value="录入" style="margin-top: 20"></form>
						</c:otherwise>
					</c:choose> 
					</td>
				</tr>				
			</c:forEach>
			<tbody>
			<tfoot>
			<tr>
				<td colspan="6" align="right">当前是第${requestScope.upageVO.page }页
				|共${ requestScope.upageVO.pageCount}页|
					<c:choose>
						<c:when test="${ requestScope.upageVO.page le 1 }">上一页</c:when>
						<c:otherwise>
							<a
								href="${pageContext.request.contextPath }/admin/${requestScope.actionName }.action?page=${ requestScope.upageVO.page - 1 }">上一页</a>
						</c:otherwise>
					</c:choose> 
					|
					<c:forEach begin="1" end="${ requestScope.upageVO.pageCount}" var="countindex">
						&nbsp;<a href="${pageContext.request.contextPath }/admin/${requestScope.actionName }.action?page=${ countindex }">${ countindex }</a>
					</c:forEach>
					&nbsp;|
					<c:choose>
						<c:when test="${ requestScope.upageVO.page ge requestScope.upageVO.pageCount }">下一页</c:when>
						<c:otherwise>
						<a
								href="${pageContext.request.contextPath }/admin/${requestScope.actionName }.action?page=${ requestScope.upageVO.page +1 }">下一页</a>
						</c:otherwise>
					</c:choose>
					</td>
			</tr>
		</tfoot>
		</table>
		
	</center>
  </body>
</html>
