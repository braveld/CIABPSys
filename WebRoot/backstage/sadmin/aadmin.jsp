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
		
		
   		<table background="../images/loginBg.jpg" height="20%" cellSpacing=0 cellPadding=0 width="500" align="center" valign="middle" style="height:250px;margin-top:250px;" bgcolor="#e3efff">
   			<tr align="center">
   				<td>
   					用户名：<input type="text" value="${requestScope.no}">
   				</td>
   			</tr>
   			<tr align="center">
   				<td>
   					密&nbsp;码：<input type="text" value="${requestScope.password}">
   				</td>
   			</tr>
   			<tr align="center">
   				<td>
   					<form  method="post" name="register" action="${pageContext.request.contextPath}/superadmin/register.action">
   						<center>
   							<input type="submit" value="注册管理员" style="height:35px; width:80px;margin-top:10px;">
   						</center>
   					</form>
   				</td>
   			</tr>
   		</table>
   	</center>
  </body>
</html>
