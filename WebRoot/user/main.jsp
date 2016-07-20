<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	SimpleDateFormat formattor = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	Date currentTime = new Date();
	String date = formattor.format(currentTime);

	String userName = null;
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="../css/admin.css" type="text/css" rel="stylesheet">
</HEAD>
<BODY>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
		<TR height=28>
			<TD background=../images/title_bg1.jpg>当前位置:</TD>
		</TR>
		<TR>
			<TD bgColor=#b1ceef height=1></TD>
		</TR>
		<TR height=20>
			<TD background=../images/shadow_bg.jpg></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
		<TR height=100>
			<TD align=middle width=100><IMG height=100
				src="../images/admin_p.gif" width=90>
			</TD>
			<TD width=60>&nbsp;</TD>
			<TD>
				<TABLE height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>

					<TR>
						<TD>当前时间：<%=date%></TD>
					</TR>
					<TR>
						<TD style="FONT-WEIGHT: bold; FONT-SIZE: 16px">${sessionScope.userinfo.name}</TD>
					</TR>
					<TR>
						<TD>欢迎进入罕见免疫系统疾病临床信息档案馆！</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR>
			<TD colSpan=3 height=10></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
		<TR height=20>
			<TD></TD>
		</TR>
		<TR height=22>
			<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
				align=middle background=../images/title_bg2.jpg>您的相关信息</TD>
		</TR>
		<TR bgColor=#ecf4fc height=12>
			<TD></TD>
		</TR>
		<TR height=20>
			<TD></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0>
		<TR>
			<TD align=right width=100>登陆帐号：</TD>
			<TD style="COLOR: #880000">${sessionScope.userinfo.mphone}</TD>
		</TR>
		<TR>
			<TD align=right>用户名：</TD>
			<TD style="COLOR: #880000">${sessionScope.userinfo.nick}</TD>
		</TR>
		<TR>
			<TD align=right>真实姓名：</TD>
			<TD style="COLOR: #880000">${sessionScope.userinfo.name}</TD>
		</TR>
		<TR>
			<TD align=right>联系电话：</TD>
			<TD style="COLOR: #880000">${sessionScope.userinfo.mphone}</TD>
		</TR>
		<TR>
			<TD align=right>电子邮箱：</TD>
			<TD style="COLOR: #880000">${sessionScope.userinfo.email}</TD>
		</TR>
		<TR>
			<TD align=right>联系地址：</TD>
			<TD style="COLOR: #880000">${sessionScope.userinfo.address}</TD>
		</TR>
		
	</TABLE>
</BODY>
</HTML>
