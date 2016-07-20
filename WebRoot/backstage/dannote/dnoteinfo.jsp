<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统消息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" src="js/jquery-1.11.1.js"></script>

  </head>
  
  <body>
    <center>
		<h2>推荐信息</h2>

		<hr>
    	<form>
    	<center>主 题:<input name="dnote.title"  id="dnote.title" style="width:160px;hight:20px" value="${requestScope.dnote.title}" readonly="readonly"></center>
    	<div>
			<textarea name="dnote.content" id="dnote.content" cols=150 rows=4 style="width: 900px;height: 100px" readonly="readonly">${requestScope.dnote.content}</textarea>
			
		</div>
		
		<br>		
    	</form>
    </center>
  </body>
</html>
