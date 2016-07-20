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
    
    <title>笔记</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" src="js/jquery-1.11.1.js"></script>
	<style type="text/css">
body{
	margin:0;
	padding:40px;
	background:#fff;
	font:80% Arial, Helvetica, sans-serif;
	color:#555;
	line-height:180%;
}
img{border:none;}
ul,li{
	margin:0;
	padding:0;
}
li{
	list-style:none;
	float:left;
	display:inline;
	margin-right:10px;
	border:1px solid #AAAAAA;
}

/* tooltip */
#tooltip{
	position:absolute;
	border:1px solid #ccc;
	background:#333;
	padding:2px;
	display:none;
	color:#fff;
}
</style>
<script type="text/javascript">
//<![CDATA[
$(function(){
	var x = 10;
	var y = 20;
	$("a.tooltip").mouseover(function(e){
		this.myTitle = this.title;
		this.title = "";	
		var imgTitle = this.myTitle? "<br/>" + this.myTitle : "";
		var tooltip = "<div id='tooltip'><img src='"+ this.href +"' alt='产品预览图'/>"+imgTitle+"<\/div>"; //创建 div 元素
		$("body").append(tooltip);	//把它追加到文档中						 
		$("#tooltip")
			.css({
				"top": (e.pageY+y) + "px",
				"left":  (e.pageX+x)  + "px"
			}).show("fast");	  //设置x坐标和y坐标，并且显示
    }).mouseout(function(){
		this.title = this.myTitle;	
		$("#tooltip").remove();	 //移除 
    }).mousemove(function(e){
		$("#tooltip")
			.css({
				"top": (e.pageY+y) + "px",
				"left":  (e.pageX+x)  + "px"
			});
	});
})
//]]>
</script>
  </head>
  <body>
    <center>
		<h2>笔记</h2>

		<hr>
		
		<table border="1" width="900" cellpadding="0" cellspacing="0" bordercolor="#1F85B6" align="center">
			
			
			<tr height="30">
				<th width="200" style="color:#1F85B6">日期</th>
				<th width="400" style="color:#1F85B6">笔记</th>
				<th width="400" style="color:#1F85B6">操作</th>
			</tr >
			<c:forEach items="${ requestScope.notelist }" var="note">
				<tr height="30">
					<td align="center">${note.date }</td>
					<td align="left"><form><textarea  type="text" class="inputbox" style="width:700px;hight:60px;border: 1px">${note.content }</textarea><br>
					<table>
					<c:forEach items="${note.noteImages }" var="noteImage">
						<c:choose>
							<c:when test='${noteImage.type == "png" or noteImage.type == "jpg" or noteImage.type == "jpeg" or noteImage.type == "gif"}'>
								<th><a href="${pageContext.request.contextPath}/uploadimages/${noteImage.userno}/${noteImage.filename}" class="tooltip" title="img"><img height="50" width="50" src="${pageContext.request.contextPath}/uploadimages/${noteImage.userno}/${noteImage.filename}" alt="img" /></a>&nbsp;</th>
							</c:when>
							<c:otherwise>
								<th><a href="${pageContext.request.contextPath}/user/downloadN.action?no=${noteImage.userno}&fileName=${noteImage.filename}">${noteImage.url}</a>&nbsp;</th>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
					</table></form></td>
					<td>
						<center><a href="${pageContext.request.contextPath}/user/deleteN.action?id=${note.id}">删除</a></center>
					</td>
				</tr>			
				
			</c:forEach>
			
		</table>
	</center>
  
  </body>
</html>
