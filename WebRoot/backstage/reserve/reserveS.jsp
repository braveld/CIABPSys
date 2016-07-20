<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>reserve/reserveS.jsp</title>
    
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
      <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	scroll="no">
	<form  method="post" name="reserveForm" >  
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td height="100%" align="center" bgcolor="#e3efff">
					<table width="762" height="435" border="0" cellpadding="0"
						cellspacing="0" background="../images/menu_bg.jpg">
						<tr>
							<td><table border="0" align="center" cellpadding="0"
									cellspacing="7">
									<tr>
										<td><span style="font-size:20px;">姓名*：</span></td>
										<td><span style="font-size:20px;">${sessionScope.reserve.name}</span></td>
									</tr>									
									<tr>
										<td><span style="font-size:20px;">联系电话*：</span></td>
										<td><span style="font-size:20px;">${sessionScope.reserve.phone}</span></td>
									</tr>
									<tr>
										<td><span style="font-size:20px;">家庭住址：</span></td>
										<td><span style="font-size:20px;">${sessionScope.reserve.address}</span></td>
									</tr>
									<tr>
										<td><span style="font-size:20px;">预约状态：</span></td>
										<td><span style="font-size:20px;">${sessionScope.reserve.status}</span></td>
									</tr>
									<%String status = (String)session.getAttribute("status");
										%>
									
									<c:choose>
										<c:when test="${empty sessionScope.reserve.result}">
											<tr>
												<td><span style="font-size:20px;"><%=status %>：</span></td>
												<td>未上传检测结果</td>
											</tr>
										</c:when>
										<c:otherwise >
											<tr>
												<td><span style="font-size:20px;"><%=status %>：</span></td>
												<td><a href="${pageContext.request.contextPath}/user/download.action?no=${sessionScope.reserve.no}&fileName=${sessionScope.reserve.filename}">下载检测结果</a></td>
											</tr>
										</c:otherwise>
									</c:choose>
						
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
		
	</form>  
  </body>
</html>
