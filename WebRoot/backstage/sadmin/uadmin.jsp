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
    
    <title>管理员添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body >
  	<center>
		<h2>添加管理员</h2>
		<hr>
		<form  method="post"  action="${pageContext.request.contextPath}/superadmin/upateAdmin.action?&no=${requestScope.admin.no}" enctype="multipart/form-data">
		密&nbsp;码：<input id="admin.password" name="admin.password" type="text" value="${requestScope.admin.password}">
   			<table background="../images/loginBg.jpg" height="100%" cellSpacing=0 cellPadding=0 width="100">
   				<tr>
   					<td>
   					
   						<center>
   							<input type="submit" value="更新管理员" style="height:45px; width:80px;margin-top:50px;">
   						</center>
   					
   					</td>
   				</tr>
   			</table>
   		</form>
   	</center>
  </body>
</html>
