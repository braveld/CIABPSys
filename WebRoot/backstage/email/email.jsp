<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<h2>发送邮件</h2>
		
		<hr>
    	<form action="${pageContext.request.contextPath}/admin/sendMail.action" method="post" enctype="multipart/form-data">
    	<center>邮 箱:<input name="email" type="text" id="email" class="inputbox" style="width:160px;hight:20px" value="${requestScope.user.email}"><br/>
				主 题:<input name="subject" type="text" id="subject" class="inputbox" style="width:160px;hight:20px" >							
		</center><br/>
											
											
    	<div>
			<textarea name="content" id="content" cols=150 rows=4 style="width: 900px;height: 100px" ></textarea>
		</div>
		
		<br>
		
		
		<input type="submit" value="提交" 
						style="height:28px; width:60px; margin-left:50px;margin-top: 50px;">
    	</form>
    </center>
  </body>
</html>
