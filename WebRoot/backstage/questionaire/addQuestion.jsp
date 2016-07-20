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
    
    <title>题目入库</title>
    
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
  <%
  String flag = (String)session.getAttribute("addQuestion");
  if(flag.equals("true")){%>
  <script type="text/javascript">alert("添加成功");</script>
  
  <%} %>
  
    <center>
		<h2>题目入库</h2>

		<hr>
		<form action="${pageContext.request.contextPath }/user/addQuestion.action" method="post">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td height="100%" align="center" bgcolor="#e3efff">
					<table width="762" height="435" border="0" cellpadding="0"
						cellspacing="0" >
						<tr>
							<td><table border="0" align="center" cellpadding="0"
									cellspacing="7">
									<tr>
										<td><span style="font-size:12px;">题型：</span></td>
										<td><select id="question.type" name="question.type">
                  								<option value ="0">单选题</option>  
  												<option value ="1">多选题</option>  
  												<option value="2">填空题</option> 
                  							</select></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">题目：</span></td>
										<td><textarea name="question.question" type="text" class="inputbox" id="question.question"
											style="width:400px;hight:60px"></textarea></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">选项：</span></td>
										<td><textarea name="question.option" type="text" class="inputbox" id="question.option"
											 style="width:400px;hight:60px"></textarea></td>
										<td><span style="font-size:12px;">(非选择题为空，格式：XXXX/xxxx)</span></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">正确答案：</span></td>
										<td><input name="question.answer" type="text" class="inputbox" id="question.answer"
											 style="width:200px;hight:20px"></td>
				
									</tr>
									<tr>
										<td height="100" colspan="2" valign="top"><table
												border="0" align="center" cellpadding="0" cellspacing="5">
												<tr>
													<td><input type="submit" value="添加" 
															style="height:28px; width:60px; margin-left:50px;">
													</td>
													<td><input type="reset" value="重置" style="height:28px; width:60px;">
													</td>
												</tr>
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table></form>
	</center>
  </body>
</html>
