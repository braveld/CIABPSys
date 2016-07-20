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
    
    <title>questionaire/showAllQ.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function prom(qno) {  
	        var name = prompt("请输入您要修改的名字"); //将输入的内容赋给变量 name ，  
	        //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值  
	        if (name)//如果返回的有内容  
	        {  
	            location.href="/CIABPSys/user/updateQno.action?name="+name+"&openno="+qno;  
	        }  
    	}  
	</script>
  </head>
  
  <body>
    <center>
		<h2>全部问卷</h2>

		<hr>
		<form method="post" action="${pageContext.request.contextPath}/superadmin/gqresultfile.action">
		<input type="submit" value="问卷上传"  
						style="height:20px; width:100px;margin-top: 20px"></form>
		<form method="post" action="${pageContext.request.contextPath}/superadmin/forbidall.action"><input type="submit" value="全不启用" 
						style="height:20px; width:100px;margin-top: 20px"></form>
		<table border="1" width="900" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<tr height="40" align="center">
				<th width="100" style="color:#1F85B6">问卷编号</th>
				<th width="400" style="color:#1F85B6">问卷名称</th>
				<th width="200" style="color:#1F85B6">生成日期</th>
				<th width="100" style="color:#1F85B6">状态</th>
				<th width="100" style="color:#1F85B6">是否启用</th>
			</tr>
			<c:forEach items="${ sessionScope.detaillist }" var="questionaire">
				<tr align="center">
					<td>${questionaire.no }</td>
					<td><c:choose>
						<c:when test='${questionaire.isqiyong == "未启用"}'><a href="${pageContext.request.contextPath}/user/showByNo.action?no=${questionaire.no }">${questionaire.name }</a></c:when>
						<c:when test='${questionaire.isqiyong == "启用"}'>${questionaire.name }</c:when>
					</c:choose>
					<input type="button" value="改名"  onclick="prom('${questionaire.no }');return false; ">
					</td>
					<td>${questionaire.date }</td>
					<td>${questionaire.isopen }</td>
					 <td><form method="post" action="${pageContext.request.contextPath}/user/qiyong.action?openno=${questionaire.no }"><input type="submit" value="启用" 
						style="height:20px; width:60px;margin-top: 20px"></form> </td>
				</tr>
				
				
			</c:forEach>
			
		</table>
		
	</center>
  </body>
</html>
