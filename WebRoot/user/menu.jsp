<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="../css/admin.css" type="text/css" rel="stylesheet">
<SCRIPT language=javascript>
	function expand(el) {
		childObj = document.getElementById("child" + el);

		if (childObj.style.display == 'none') {
			childObj.style.display = 'block';
		} else {
			childObj.style.display = 'none';
		}
		return;
	}
</SCRIPT>
<title>白塞病人信息收集系统</title>
</HEAD>
<body>
<%String role = (String)session.getAttribute("role"); %>
	<%if(role.equals("1")){%>
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170
		background=../images/menu_bg.jpg border=0>
		<TR>
			<TD vAlign=top align=middle>
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
					<TR>
						<TD height=10></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style=" padding-left:30px;" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(1) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">信息管理</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="../backstage/adregister.jsp"
							target=main>会员录入</A>
						</TD>
					</TR>
		
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/admin/lcshowuser.action"
							target=main>临床录入</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/admin/qalllist.action"
							target=main>问卷管理</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/admin/adshowusers.action"
							target=main>信息管理</A></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(2) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">日常管理</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/admin/showau3.action"
							target=main>发送邮件</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="../backstage/admin/snote.jsp"
							target=main>系统消息</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/admin/showslist.action"
							target=main>系统消息管理</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/admin/showau2.action"
							target=main>单独通知</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/admin/showdanlist.action"
							target=main>单独通知管理</A></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(3) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">预约管理</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/showRByS.action?status=审核中"
							target=main>预约审核</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/showRByS.action?status=通过"
							target=main>未发送血清</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/showRByS.action?status=收到血清"
							target=main>待检测</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/showRByS.action?status=检测完成"
							target=main>完成检测</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
				
			</TD>
		</TR>
	</TABLE>
	<% }else if(role.equals("0")){%>
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170
		background=../images/menu_bg.jpg border=0>
		<TR>
			<TD vAlign=top align=middle>
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
					<TR>
						<TD height=10></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style=" padding-left:30px;" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(1) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">个人信息</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/adshowsnote.action"
							target=main>系统消息</A>
						</TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/adshowdnote.action"
							target=main>个人消息</A>
						</TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="../backstage/userinfo/userinfo.jsp"
							target=main>基本信息</A>
						</TD>
					</TR>
		
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="../backstage/userinfo/certificate.jsp"
							target=main>荣誉证书</A></TD>
					</TR>
				
							
				</TABLE>
				
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(2) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">问卷填写</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/enterQ.action"
							target=main>填写问卷</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/checkQlist.action"
							target=main>问卷管理</A></TD>
					</TR>
				</TABLE>
			
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(3) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">症状管理</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="../backstage/note/writenote.jsp"
							target=main>记录笔记</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/showNote.action"
							target=main>查看笔记</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/showlinchuang.action"
							target=main>临床诊断</A></TD>
					</TR>
									
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style=" padding-left:30px;" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(4) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">预约管理</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child4 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/enterR.action"
							target=main>预约申请</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/showRStatus.action"
							target=main>预约状态</A></TD>
					</TR>
				
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style=" padding-left:30px;" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(5) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">系统推荐</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child5 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/adshowtnote.action"
							target=main>系统推荐</A></TD>
					</TR>
				
				</TABLE>
			</TD>
		</TR>
	</TABLE>
	<% }else{%>
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170
		background=../images/menu_bg.jpg border=0>
		<TR>
			<TD vAlign=top align=middle>
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
					<TR>
						<TD height=10></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style=" padding-left:30px;" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(1) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">权限管理</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="../backstage/sadmin/aadmin.jsp"
							target=main>创建账号</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><img height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/superadmin/showadmin.action"
							target=main>账号管理</A>
						</TD>
					</TR>				
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(2) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">信息管理</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/superadmin/showau.action"
							target=main>患者信息</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/superadmin/showlcu.action"
							target=main>临床结果</A></TD>
					</TR>

				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(3) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">问卷管理</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="../backstage/questionaire/addQuestion.jsp"
							target=main>题目入库</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/superadmin/questionlist.action"
							target=main>题库管理</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/createQ.action"
							target=main>问卷生成</A></TD>
					</TR>
					
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/user/showQ.action"
							target=main>问卷管理</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/superadmin/sqalllist.action"
							target=main>问卷结果</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px" background=../images/menu_bt.jpg><A
							class=menuParent onclick=expand(4) href="javascript:void(0);"><span
								style="color:#fff; font-weight:bold;">推荐管理</span> </A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child4 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/superadmin/showau1.action"
							target=main>推荐消息</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="../images/menu_icon.gif" width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/superadmin/showat.action"
							target=main>推荐管理</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
	<%} %>
	
</body>
</HTML>

