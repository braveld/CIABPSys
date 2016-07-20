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
    
    <title>记录笔记</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
		var TfileUploadNum = 1;//图片记录数
		var Tnum=1; //ajax上传图片时索引
		function TAddFileUpload(){
			if(TfileUploadNum < 5){
				var idnum = TfileUploadNum+1;
				var str="<tr><td>图片"+idnum+":</td>";
				str += "<td><input name='noteimage' id='noteimage' type='file' value='上传'/><span></span></td></tr>";			
				$("#imgTable").append(str);
				TfileUploadNum += 1; 
			}else{
				alert("最多一条笔记只能上传一条记录");
			}
			
		}
	</script>
  </head>
  
  <body>
    <center>
		<h2>记笔记</h2>

		<hr>
    	<form action="${pageContext.request.contextPath}/user/addNote.action" method="post" enctype="multipart/form-data">
    	<div>
			<textarea name="note.content" cols=150 rows=4 style="width: 900px;height: 100px"></textarea>
		</div>
		
		<br>
		<table id="imgTable" name="imgTable">
		<tr>
            <td>图片1:</td>
            <td><input type="file" value="上传" name="noteimage" id="noteimage"><span></span></td>
		</tr>
		</table>
		<br />
		<input type="button" value="继续上传" onclick="TAddFileUpload();" style="height:28px; width:80px; margin-left:50px;margin-top: 50px;"/>
		<input type="submit" value="保存" 
						style="height:28px; width:60px; margin-left:50px;margin-top: 50px;">
    	</form>
    </center>
  </body>
</html>
