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
    
    <title>问卷生成</title>
    
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
		<form method="post" action="${pageContext.request.contextPath}/user/showQuestion.action">
		<table border="1" width="1000" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<tr height="40">
				<th width="200" style="color:#1F85B6">问卷编号：${sessionScope.questionaireNo}</th>
				<th width="300" style="color:#1F85B6">问卷名称：<input name="qname" type="text" class="inputbox" id="qname"
											style="width:500px;hight:20px"></th>
				<th width="100" style="color:#1F85B6"><input type="submit" value="生成" 
															style="height:28px; width:60px; "></th>
			</tr>
			
		</table>
		</form>
	</center>
  </body>
</html>
