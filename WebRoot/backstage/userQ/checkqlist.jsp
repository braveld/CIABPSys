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
    
    <title>userQ/checkqlist.jsp</title>
    
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
		<h2>已填写问卷</h2>

		<hr>
		
		<table border="1" width="900" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<tr height="40" align="center">
				<th width="100" style="color:#1F85B6">问卷编号</th>
				<th width="400" style="color:#1F85B6">问卷名称</th>
				<th width="100" style="color:#1F85B6">查看</th>
				<th width="100" style="color:#1F85B6">问卷结果</th>
				
			</tr>
			<c:forEach items="${ requestScope.UQList }" var="qDetail">
				<tr align="center" height="40">
					<td>${qDetail.no }</td>
					<td>${qDetail.name }</a></td>
					<td><form method="post" action="${pageContext.request.contextPath}/user/checkQ.action?qno=${qDetail.no }"><input type="submit" value="查看" style="margin-top: 20"></form></td>
					 <td><form action="${pageContext.request.contextPath}/user/resultshow.action?no=${qDetail.no }" method="post"><input type="submit" value="问卷结果" style="margin-top: 20"></form>
						 </td>
				</tr>
				
				
			</c:forEach>
			
		</table>
		
	</center>
  </body>
</html>
