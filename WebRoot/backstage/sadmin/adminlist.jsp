<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息管理</title>
    
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
		<h2>信息管理</h2>

		<hr>
		
		<table border="1" width="1100" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<tr height="40" align="center">
				<th width="100" style="color:#1F85B6">编号</th>
				<th width="100" style="color:#1F85B6">密码</th>
				<th width="100" style="color:#1F85B6">修改</th>
				<th width="100" style="color:#1F85B6">删除</th>
				
			</tr>
			<c:forEach items="${ requestScope.upageVO.list }" var="admin">
				<tr align="center">
					<td>${admin.no}</td>
					<td>${admin.password}</td>
					<td><form method="post"  action="${pageContext.request.contextPath}/superadmin/showaByNo.action?&no=${admin.no}"><input type="submit" value="修改" 
						style="height:23px; width:60px; margin-top: 15px"></form> </td>
					<td><form method="post"  action="${pageContext.request.contextPath}/superadmin/deleteAdmin.action?&no=${admin.no}"><input type="submit" value="删除" 
						style="height:23px; width:60px; margin-top: 15px"></form> </td>
				</tr>
				
				
			</c:forEach>
			<tfoot>
			<tr>
				<td colspan="6" align="right">当前是第${requestScope.upageVO.page }页
				|共${ requestScope.upageVO.pageCount}页|
					<c:choose>
						<c:when test="${ requestScope.upageVO.page le 1 }">上一页</c:when>
						<c:otherwise>
							<a
								href="${pageContext.request.contextPath }/superadmin/${requestScope.actionName }.action?page=${ requestScope.upageVO.page - 1 }">上一页</a>
						</c:otherwise>
					</c:choose> 
					|
					<c:forEach begin="1" end="${ requestScope.upageVO.pageCount}" var="countindex">
						&nbsp;<a href="${pageContext.request.contextPath }/superadmin/${requestScope.actionName }.action?page=${ countindex }">${ countindex }</a>
					</c:forEach>
					&nbsp;|
					<c:choose>
						<c:when test="${ requestScope.upageVO.page ge requestScope.upageVO.pageCount }">下一页</c:when>
						<c:otherwise>
						<a
								href="${pageContext.request.contextPath }/superadmin/${requestScope.actionName }.action?page=${ requestScope.upageVO.page +1 }">下一页</a>
						</c:otherwise>
					</c:choose>
					</td>
			</tr>
		</tfoot>
			
		</table>
		
	</center>
  </body>
</html>
