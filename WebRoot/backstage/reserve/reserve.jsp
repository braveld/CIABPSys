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
    
    <title>预约</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	scroll="no">
	<form  method="post" name="reserveForm" action="${pageContext.request.contextPath}/user/ureserve.action">  
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="0" >
			<tr>
				<td height="100%" align="center" bgcolor="#e3efff">
					<table width="762" height="435" border="0" cellpadding="0"
						cellspacing="0" background="../images/menu_bg.jpg">
						<tr>
							<td><table border="0" align="center" cellpadding="0"
									cellspacing="7">
									<tr>
										<td><span style="font-size:12px;">姓名*：</span></td>
										<td><input name="reserve.name" type="text" id="reserve.name"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>									
									<tr>
										<td><span style="font-size:12px;">联系电话*：</span></td>
										<td><input name="reserve.phone" type="text" id="reserve.phone"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">家庭住址：</span></td>
										<td><input name="reserve.address" type="text" id="reserve.address"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">身份证号：</span></td>
										<td><input name="reserve.idno" type="text" id="reserve.idno"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td height="100" colspan="2" valign="top"><table
												border="0" align="center" cellpadding="0" cellspacing="5">
												<tr>
													<td><input type="submit" value="预约" 
															style="height:28px; width:60px; margin-left:50px;">
													</td>
												</tr>
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
		
	</form>  
  </body>
</html>
