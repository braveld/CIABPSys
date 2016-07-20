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
    
    <title>superadmin/questionlist.jsp</title>
    
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
				<th width="100" style="color:#1F85B6">编号</th>
				<th width="400" style="color:#1F85B6">题目</th>
				<th width="100" style="color:#1F85B6">日期</th>
				<th width="100" style="color:#1F85B6">题型</th>
				<th width="100" style="color:#1F85B6">状态</th>
				<th width="100" style="color:#1F85B6">显示</th>
				<th width="100" style="color:#1F85B6">删除</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ requestScope.questionlist }" var="question">
				<tr align="center" height="40">
					<td>${question.no }</td>
					<td>${question.question }</td>
					<td>${question.date }</td>
					<td><c:choose>
						<c:when test="${ question.type == '0' }">单选</c:when>
						<c:when test="${ question.type == '1' }">多选</c:when>
						<c:otherwise>
							填空
						</c:otherwise>
					</c:choose></td>
					<td>${question.isshow }</td>
					<td><form method="post" action="${pageContext.request.contextPath}/superadmin/updateshow.action?no=${question.no}&isshow=${question.isshow }"><input type="submit" value="更改" style="margin-top: 20"></form></td>
					<td><form method="post" action="${pageContext.request.contextPath}/superadmin/deletequestion.action?no=${question.no}"><input type="submit" value="删除" style="margin-top: 20"></form></td>
				</tr>				
			</c:forEach>
			<tbody>
			
		</table>
		
	</center>
  </body>
</html>
