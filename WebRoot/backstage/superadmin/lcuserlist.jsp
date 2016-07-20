<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>lcuserlist.jsp</title>
    
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
		<h2>会员列表</h2>

		<hr>
		<form method="post" action="${pageContext.request.contextPath}/superadmin/searchlcbyuser.action">
		<select id="xuan" name="xuan">
            <option value ="用户名" selected = "selected">用户名</option>  
  			<option value ="真实姓名">真实姓名</option>  
  			<option value="手机号">手机号</option>
  			<option value="QQ号">QQ号</option>
         </select>
         <input name="xuanxiang" type="text" id="xuanxiang" class="inputbox" style="width:160px;hight:20px">
		<input type="submit" value="搜索" style="height:28px; width:60px; margin-left:50px;">
		</form>
		<table border="1" width="900" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<thead>
			<tr height="40" align="center">
				<th width="100" style="color:#1F85B6">编号</th>
				<th width="200" style="color:#1F85B6">用户名</th>
				<th width="200" style="color:#1F85B6">真实姓名</th>
				<th width="200" style="color:#1F85B6">手机号</th>
				<th width="200" style="color:#1F85B6">QQ号</th>
				<th width="100" style="color:#1F85B6">临床信息</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ requestScope.upageVO.list }" var="user">
				<tr align="center" height="40">
					<td>${user.no }</td>
					<td>${user.nick }</td>
					<td>${user.name }</td>
					<td>${user.mphone }</td>
					<td>${user.qq }</td>
					<td><form method="post" action="${pageContext.request.contextPath}/superadmin/showlcByNo.action?&no=${user.no}"><input type="submit" value="临床信息" style="margin-top: 20"></form>
					</td>
				</tr>				
			</c:forEach>
			<tbody>
			<tfoot>
			<tr>
				<td colspan="6" align="right"><form action="${pageContext.request.contextPath }/superadmin/${requestScope.actionName }.action" method="post">当前是第${requestScope.upageVO.page }页
				|共${ requestScope.upageVO.pageCount}页|
					<c:choose>
						<c:when test="${ requestScope.upageVO.page le 1 }">上一页</c:when>
						<c:otherwise>
							<a
								href="${pageContext.request.contextPath }/superadmin/${requestScope.actionName }.action?page=${ requestScope.upageVO.page - 1 }">上一页</a>
						</c:otherwise>
					</c:choose> 
					|跳转到<input name="page" id="page" type="text" style="width:30px;"><input type="submit" value="跳转" style="width:50px;">&nbsp;|
					<c:choose>
						<c:when test="${ requestScope.upageVO.page ge requestScope.upageVO.pageCount }">下一页</c:when>
						<c:otherwise>
						<a href="${pageContext.request.contextPath }/superadmin/${requestScope.actionName }.action?page=${ requestScope.upageVO.page +1 }">下一页</a>
						</c:otherwise>
					</c:choose>
					</form></td>
			</tr>
		</tfoot>
		</table>
		
	</center>
  </body>
</html>
