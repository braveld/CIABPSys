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
    
    <title>问卷须知</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
    	<center>
		<h2>问卷须知</h2>

		<hr>
		<table border="1" width="550" cellpadding="0" cellspacing="0" background=../images/menu_bg.jpg>
		
			<tr>
				<th>问卷须知</th>
				<td align="left"><font style="font-family:宋体;font-size:80%;line-height:150%"><br/>
					<ul>
						<li>本系统旨在推动国内白塞病的相关基础研究，为病人早期诊断，早期治疗提<br/>供贡献。本知情同意书提供给您一些信息以帮助您决定是否参加此项临床研<br/>究，请您仔细阅读。</li>
						<li>我们致力于从事公益性、非盈利性社会工作，致力于为白塞病群体开展关怀<br/>和救助服务，我们希望更多的患者能得到最新科研数据，更了解自己的病情<br/>，并获取更多的帮助。本研究参加者为完全自愿参加的法定成年患者，且需<br/>经由权威临床三级医院确诊，提供血清样本，出具相关诊断和各项基本临床<br/>信息。此部分血清抽血和运输费用由本实验室提供。</li>
						<li>本研究将为参加者义务提供免费咨询，同时提供各种最新同步发表于国际学<br/>术期刊的指标检测数据，根据您的病理特征共同分析研讨该分子的临床价值<br/>与意义，是否与发病、疾病进程、受累器官组织、可能的疾病未来走向与趋<br/>势等。</li>
						<li>请认真填写您的个人信息和临床信息，正确的临床信息将会为未来的疾病研<br/>究及对您的帮助提供便携。</li>
					</ul>
					　　</font></td>
			
			</tr>
			
			
				
		</table>
		
			<form method="post" action="${pageContext.request.contextPath}/user/usershowByNo.action">
			<input type="submit" value="开始填写" 
			style="height:28px; width:120px; margin-top:50px;"></form>
	</center>
</html>
