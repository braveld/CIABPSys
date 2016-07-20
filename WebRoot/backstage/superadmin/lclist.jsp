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
    
    <title>My JSP 'lclist.jsp' starting page</title>
    
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
   <h2>临床列表</h2>

		<hr>
		
		<table border="1" width="900" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<thead>
			<tr height="40" align="center">
				<th width="100" style="color:#1F85B6">就诊日期</th>
				<th width="200" style="color:#1F85B6">就诊医院</th>
				<th width="100" style="color:#1F85B6">就诊医生</th>
				<th width="100" style="color:#1F85B6">临床化验单</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ requestScope.upageVO.list }" var="linchuang">
				<tr align="center" height="40">
					<td>${linchuang.date }</td>
					<td>${linchuang.hospital }</td>
					<td>${linchuang.doctor }</td>
					<td>
						<c:choose>
							<c:when test='${linchuang.type == "png" or linchuang.type == "jpg" or linchuang.type == "jpeg" or linchuang.type == "gif"}'>
								<a href="${pageContext.request.contextPath}/lcimages/${linchuang.userno}/${linchuang.filename}" class="tooltip" title="img"><img height="50" width="50" src="${pageContext.request.contextPath}/lcimages/${linchuang.userno}/${linchuang.filename}" alt="img" /></a>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/user/downloadL.action?no=${linchuang.userno}&fileName=${linchuang.filename}">${linchuang.imageurl }</a>
							</c:otherwise>
						</c:choose>
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
							<a href="${pageContext.request.contextPath }/superadmin/${requestScope.actionName }.action?page=${ requestScope.upageVO.page - 1 }">上一页</a>
						</c:otherwise>
					</c:choose> 
					|跳转到<input name="page" id="page" type="text" style="width:30px;"><input type="submit" value="跳转" style="width:50px;">&nbsp;|
					<c:choose>
						<c:when test="${ requestScope.upageVO.page ge requestScope.upageVO.pageCount }">下一页</c:when>
						<c:otherwise>
						<a
								href="${pageContext.request.contextPath }/superadmin/${requestScope.actionName }.action?page=${ requestScope.upageVO.page +1 }">下一页</a>
						</c:otherwise>
					</c:choose>
					</form></td>
			</tr>
		</tfoot>
		</table>
		<span><input type="submit" value="返回" onclick="javascript:history.go(-1)"
															style="height:28px; width:60px; margin-top:50px;"></span>
	</center>
  </body>
</html>
