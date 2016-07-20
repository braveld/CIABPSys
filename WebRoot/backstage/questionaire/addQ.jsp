<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addQ.jsp' starting page</title>
    
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
		<h2>问卷生成</h2>

		<hr>
		<%String no = (String)session.getAttribute("questionaireNo");
		String name = (String)session.getAttribute("qname"); %>
		<%
			request.setCharacterEncoding("utf-8");
		%>
		<table border="1" width="1200" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<tr height="40">
				<th width="200" style="color:#1F85B6">问卷编号：<%=no %></th>
				<th width="200" style="color:#1F85B6">问卷名称：${sessionScope.qname}</th>
				<th width="200" style="color:#1F85B6"><a href="${pageContext.request.contextPath}/user/addQD.action?no=${sessionScope.questionaireNo}&name=<%=name %>">完成</a></th>
				<th width="200" style="color:#1F85B6"><a>取消</a></th>
			</tr>
			<tr height="40">
				<td width="200" style="color:#1F85B6">题目编号</th>
				<td width="200" style="color:#1F85B6">题目</th>
				<td width="200" style="color:#1F85B6">类型</th>
				<td width="200" style="color:#1F85B6"></th>
			</tr>
			<c:forEach items="${ sessionScope.questionlist }" var="question">
				<tr>
					<td>${question.no }</td>
					<td>${question.question }</td>
					<td>${question.type }</td>
					<td> <a href="${pageContext.request.contextPath}/user/addQ.action?questionaire.qno=${question.no }&questionaire.no=${sessionScope.questionaireNo}">添加</a></td>
					
				</tr>
			</c:forEach>
			
			
		</table>
		
	</center>
  </body>
</html>
