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
    
    <title>预约须知</title>
    
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
		<h2>预约状态</h2>

		<hr>
		<table border="1" width="700" cellpadding="0" cellspacing="0" background="../images/menu_bg.jpg">
		
			<tr>
				<th>预约状态</th>
				<td align="left"><font style="font-family:宋体;font-size:80%;line-height:150%">${sessionScope.userinfo.name}：<br/>
					您好！你的血清检测申请已经通过，<br/>请将你的血清样本邮寄到以下地址：北京市海淀区学院路30号理化楼 112实验室 <br/>   邮编：100083   电话：15652932274
					
					</font></td>
			
			</tr>
			
				
		</table>
			
	</center>
  </body>
</html>
