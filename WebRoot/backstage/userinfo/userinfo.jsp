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
    
    <title>userinfo/userinfo.jsp</title>
    
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
	<form  method="post" name="loginForm" >  
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td height="100%" align="center" bgcolor="#e3efff">
					<table width="762" height="435" border="0" cellpadding="0"
						cellspacing="0" background="../images/loginBg.png">
						<tr>
							<td><table border="1" align="center" cellpadding="0"
									cellspacing="7">
									<tr align="center">
										<td><span style="font-size:12px;">昵称：</span></td>
										<td>${sessionScope.userinfo.nick}</td>
									</tr>									
									<tr align="center">
										<td><span style="font-size:12px;">姓名：</span></td>
										<td>${sessionScope.userinfo.name}</td>
									</tr>
									<tr align="center">
										<td><span style="font-size:12px;">性别：</span></td>
										<td>${sessionScope.userinfo.sex}</td>
									</tr>
									<tr align="center">
										<td><span style="font-size:12px;">民族：</span></td>
										<td>${sessionScope.userinfo.type}</td>
									</tr>
									<tr align="center">
										<td><span style="font-size:12px;">出生日期：</span></td>
										<td>${sessionScope.userinfo.birthday}</td>
									</tr>
									<tr align="center">
										<td><span style="font-size:12px;">教育程度：</span></td>
										<td><select id="user.education" name="user.education" style="width:160px;hight:20px">
										<c:if test="${sessionScope.userinfo.education eq 0}">
												<option value ="0">小学</option>  
  												<option value ="1">初中</option>  
  												<option value="2">高中</option>
  												<option value="3">大学及以上学历</option>
  												<option value="4">其他</option>
										</c:if>
                  						<c:if test="${sessionScope.userinfo.education eq 1}">
												<option value ="1" selected="selected">初中</option> 
												<option value ="0">小学</option>  
  												 
  												<option value="2">高中</option>
  												<option value="3">大学及以上学历</option>
  												<option value="4">其他</option>
										</c:if>
										<c:if test="${sessionScope.userinfo.education eq 2}">
												<option value="2" selected="selected">高中</option>
												<option value ="0">小学</option>  
  												<option value ="1">初中</option>  
  												
  												<option value="3">大学及以上学历</option>
  												<option value="4">其他</option>
										</c:if>
										<c:if test="${sessionScope.userinfo.education eq 3}">
												<option value="3" selected="selected">大学及以上学历</option>
												<option value ="0">小学</option>  
  												<option value ="1">初中</option>  
  												<option value="2">高中</option>
  												
  												<option value="4">其他</option>
										</c:if>
										<c:if test="${sessionScope.userinfo.education eq 4}">
												<option value="4" selected="selected">其他</option>
												<option value ="0">小学</option>  
  												<option value ="1">初中</option>  
  												<option value="2">高中</option>
  												<option value="3">大学及以上学历</option>
  												
										</c:if>
                  							</select></td>
									</tr>
									<tr align="center">
										<td><span style="font-size:12px;">职业：</span></td>
										<td>${sessionScope.userinfo.work}</td>
									</tr>
									<tr align="center">
										<td><span style="font-size:12px;">电子邮件：</span></td>
										<td>${sessionScope.userinfo.email}</td>
									</tr>
									<tr align="center">
										<td><span style="font-size:12px;">qq：</span></td>
										<td>${sessionScope.userinfo.qq}</td>
									</tr>
									<tr align="center">
										<td><span style="font-size:12px;">微信号：</span></td>
										<td>${sessionScope.userinfo.weixin}</td>
									</tr>
									<tr align="center">
										<td><span style="font-size:12px;">手机（登录用户名）：</span></td>
										<td>${sessionScope.userinfo.mphone}</td>
									</tr>
									<tr align="center">
										<td><span style="font-size:12px;">家庭联系电话：</span></td>
										<td>${sessionScope.userinfo.phone}</td>
									</tr>
									<tr align="center">
										<td><span style="font-size:12px;">家庭住址：</span></td>
										<td>${sessionScope.userinfo.address}</td>
									</tr>
									
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
		
	</form>  
  </body>
</html>
