<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改密码</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	scroll="no">
	<form action="../changepwdServlet" method="post" name="changepwdForm">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td height="100%" align="center" bgcolor="#e3efff">
					<table width="762" height="435" border="0" cellpadding="0"
						cellspacing="0" background="../images/changepwd.jpg">
						<tr>
							<td><table border="0" align="center" cellpadding="0"
									cellspacing="7">
									<tr>
										<td><span style="font-size:12px;">新密码：</span>
										</td>
										<td><input name="newpwd" type="password" class="inputbox"
											style="width:160px;hight:20px">
										</td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">请确认：</span>
										</td>
										<td><input name="renewpwd" type="password"
											class="inputbox" style="width:160px;hight:20px">
										</td>
									</tr>
									<tr>
										<td height="100" colspan="2" valign="top"><table
												border="0" align="center" cellpadding="0" cellspacing="5">
												<tr>
													<td><input type="submit" value="修改"
														style="height:28px; width:60px; margin-left:50px;">
													</td>
													<td><input type="reset" value="重置"
														style="height:28px; width:60px;"></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
