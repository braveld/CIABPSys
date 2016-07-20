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
    
    <title>问卷展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.11.1.js"> </script> 
	<SCRIPT type=text/javascript>

	function gettihao(){
		var tihaos = "";
		var noss = "";
		<% 
		String[] nos = (String[])request.getAttribute("nos");
		request.setAttribute("nos", nos);
		String[] tihaos = new String[nos.length];
		for(int i = 0;i < nos.length;i++){%>
			tihaos = tihaos+ "/" + $("#<%=nos[i]%>").val();
			noss = noss + "/" + "<%=nos[i]%>";
		<%}
		%>		
		 if(confirm("是否确认修改？")){
			location.href="/CIABPSys/superadmin/updatetihao.action?noss="+noss+"&tihaos="+tihaos+"&no=${requestScope.qno}";
		 }	
	}
</SCRIPT>
  </head>
  
  <body>
    <center>
		<h2>问卷展示</h2>

		<hr>
		
		<table border="1" width="1000" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<tr height="40" align="center">
				<th width="100" style="color:#1F85B6">问卷编号：${requestScope.qno}</th>
				<th width="300" style="color:#1F85B6">问卷名称：${sessionScope.qname}</th>
				<th width="100" style="color:#1F85B6"></th>
				
			</tr>
			<tr height="40" align="center">
				<th width="200" style="color:#1F85B6">题号</th>
				<th width="200" style="color:#1F85B6">题目编号</th>
				<th width="200" style="color:#1F85B6">题目</th>
				<th width="50" style="color:#1F85B6">类型</th>
				<th width="50" style="color:#1F85B6">删除</th>
			</tr>
			<c:forEach items="${ requestScope.Qqlist }" var="question">
				<tr height="40" align="center">
					<td><input name="${question.no }" type="text" id="${question.no }"
											class="inputbox" style="width:160px;hight:20px" value="${question.tihao }"></td>
					<td>${question.no }</td>
					<td>${question.question }</td>
					<td><c:choose>
						<c:when test="${ question.type == '0' }">单选</c:when>
						<c:when test="${ question.type == '1' }">多选</c:when>
						<c:otherwise>
							填空
						</c:otherwise>
					</c:choose> </td>
					<td><form method="post" action="${pageContext.request.contextPath}/superadmin/deleteQu.action?qno=${ requestScope.qno }&quno=${question.no }"><input type="submit" value="删除" style="margin-top: 20"></form></td>
				</tr>
			</c:forEach>
							
		</table>
		<hr>
		<table border="1" width="1000" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<tr height="40" align="center">
				<th width="100" style="color:#1F85B6">题目编号</th>
				<th width="300" style="color:#1F85B6">题目</th>
				<th width="50" style="color:#1F85B6">类型</th>
				<th width="50" style="color:#1F85B6">添加</th>
			</tr>
			<c:forEach items="${ requestScope.nQqlist }" var="nquestion">
				<tr height="40" align="center">
					<td>${nquestion.no }</td>
					<td>${nquestion.question }</td>
					<td><c:choose>
						<c:when test="${ nquestion.type == '0' }">单选</c:when>
						<c:when test="${ nquestion.type == '1' }">多选</c:when>
						<c:otherwise>
							填空
						</c:otherwise>
					</c:choose> </td>
					<td><form method="post" action="${pageContext.request.contextPath}/superadmin/addNQ.action?no=${ requestScope.qno }&qno=${nquestion.no }"><input type="submit" value="添加" style="margin-top: 20"></form></td>
				</tr>
			</c:forEach>
							
		</table>
		<span><input type="submit" value="返回" onclick="javascript:history.go(-1)"
															style="height:28px; width:60px; margin-left:50px;"></span>
		<span><input type="submit" value="调整顺序" onclick="gettihao();return false;"
															style="height:28px; width:80px; margin-left:50px;"></span>	
		<span><form method="post" action="${pageContext.request.contextPath}/superadmin/downQ.action?no=${ requestScope.qno }"><input type="submit" value="下载问卷" style="height:28px; width:80px; margin-left:50px;"></form></span>												
	</center>
  </body>
</html>
