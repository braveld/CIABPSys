<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.ciabp.models.Question"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>superadmin/dowanload.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.11.1.js"> </script> 
		
<%response.setHeader("Content-Disposition", "attachment;filename=filenmane.doc"); %>
  </head>
  
  <body>
    <center>
   	<h2>问卷答案</h2>

		<hr>
		<form>
		<table border="0" width="600" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
    	<%List<Question> list = (List<Question>)request.getAttribute("UQustionList");
    		
    		if(list!=null && !list.isEmpty()){
    			for(Question question : list){
    			%>
    				<tr style="margin-left: 0px" align="center" height="50px"><th align="left">
					*&nbsp;<%=question.getQuestion() %></th></tr>
					<%
					if(question.getType().equals("2")){%>
						<tr style="margin-left: 0px" align="center" height="40px"><br><th style="margin-left: 0px" align="left">&nbsp;&nbsp;<%=question.getAnswer() %></th><br></tr>
					<% }else if(question.getType().equals("0")){ 
						String option = question.getOption();
						String[] options = option.split("/");
						String danswers = question.getAnswer();
						%>
						<tr style="margin-left: 0px" align="center" height="40px"><br><th style="margin-left: 0px" align="left">
							&nbsp;&nbsp;<%=danswers %>	
						</th><br></tr>		
					<%}else if(question.getType().equals("1")){ 
						String option = question.getOption();
						String[] options = option.split("/");
						String[] answers = question.getAnswer().split("\\|");
						%>
						<tr style="margin-left: 0px" align="center" height="40px"><br><th style="margin-left: 0px" align="left">&nbsp;&nbsp;
						<% 
						List ll = Arrays.asList(answers);
						for(int i = 0;i < options.length;i++){
							if(ll.contains(options[i].trim())){	
						%>
							<%=options[i] %>&nbsp;
						<%}
						} %>
						</th><br></tr>
					<%} %>
    			<% }
    		}
    	 %>
						
    </center>
  </body>
</html>
