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
    
    <title>My JSP 'showPass.jsp' starting page</title>
    
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
		<h2>预约管理</h2>

		<hr>
		
		<table border="1" width="900" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<tr height="40" align="center">
				<th width="100" style="color:#1F85B6">会员编号</th>
				<th width="100" style="color:#1F85B6">会员姓名</th>
				<th width="400" style="color:#1F85B6">地址</th>
				<th width="200" style="color:#1F85B6">身份证</th>
				<th width="150" style="color:#1F85B6">联系方式</th>
				<th width="100" style="color:#1F85B6">状态</th>
				<th width="100" style="color:#1F85B6">操作</th>
				<th width="100" style="color:#1F85B6">上传</th>
			</tr>
			<c:forEach items="${ sessionScope.rlist }" var="reserve">
				<tr align="center">
					<td>${reserve.no }</td>
					<td>${reserve.name }</a></td>
					<td>${reserve.address }</td>
					<td>${reserve.idno }</td>
					<td>${reserve.phone }</td>
					<td>${reserve.status }</td>
					<td><form method="post" action="${pageContext.request.contextPath}/user/updateS.action?status=${reserve.status }&no=${reserve.no }"><input type="submit" value="操作" 
						style="height:20px; width:60px; margin-top: 15px"></form> </td>
					<td><c:choose><c:when test='${reserve.status != "检测完成"}'>
							 不可上传
						</c:when>
						<c:when test="${empty reserve.result}"><form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/admin/uploadresult.action?no=${reserve.no }"><input type="file" value="上传临床检测单" name="checkreult" id="checkreult"><input type="submit" value="上传" 
						style="height:20px; width:60px;"></form></c:when>
						<c:otherwise>已上传</c:otherwise></c:choose>
					</td>
				</tr>
				
				
			</c:forEach>
			
		</table>
		
	</center>
  </body>
</html>
