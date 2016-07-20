<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN">
<html>
<head>
<title>白塞病人信息收集系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<SCRIPT type=text/javascript>

	function tiaozhuan(){
		window.location="/CIABPSys/backstage/register/registernotice.jsp";
	}
</SCRIPT>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	scroll="no">
	<form  method="post" name="loginForm" action="${pageContext.request.contextPath}/user/userlogin.action" background="../images/loginBg.jpg"> 
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td height="100%" align="center" bgcolor="#e3efff">
					<table width="762" height="435" border="0" cellpadding="0"
						cellspacing="0" background="../images/loginBg.jpg">
						<tr>
							<td><table border="0" align="center" cellpadding="0"
									cellspacing="7">
									<tr>
										<td><span style="font-size:12px;">用户名：</span></td>
										<td><input name="role.no" type="text" class="inputbox" id="role.no"
											style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">密 码：</span></td>
										<td><input name="role.password" type="password" id="role.password"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">角色：</span></td>
										<td><select id="role.role" name="role.role">
                  								<option value ="0">会员</option>  
  												<option value ="1">管理员</option>  
  												<option value="2">超级管理员</option> 
                  							</select></td>
									</tr>
									<tr>
										<td height="100" colspan="2" valign="top"><table
												border="0" align="center" cellpadding="0" cellspacing="5">
												<tr>
													<td><input type="submit" value="登录" 
															style="height:28px; width:60px; margin-left:50px;">
													</td>
													<td><input type="button" value="注册" style="height:28px; width:60px;" onclick="tiaozhuan();return false; ">
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
