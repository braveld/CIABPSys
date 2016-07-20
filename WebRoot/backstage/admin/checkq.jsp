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
    
    <title>admin/checkq.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.11.1.js"> </script> 
		<SCRIPT type=text/javascript>

	function getanswers(){
		var answer = "";
		<%String[] nos = (String[])request.getAttribute("nos");
			String Qno = (String)request.getAttribute("Qno");
			String[] types = (String[])request.getAttribute("types");
			String no = (String)request.getAttribute("no");
			Integer pages = (Integer)request.getAttribute("page");
			String type = "";
			String questionno = "";
			for(int j = 0;j < types.length;j++){
				type = type + "/" + types[j];
				questionno = questionno + "/" + nos[j];
			}
			for(int i = 0;i < nos.length;i++){
				if(types[i].equals("0")){%>
					answer = answer + "/" +  $('input:radio[name="<%=nos[i]%>"]:checked').val();
				<%}else if(types[i].equals("1")){%>
					var checkedObj = $('input:checkbox[name="<%=nos[i]%>"]:checked');
					var question3 = "";
					checkedObj.each(function() { var isCheck = this.value; question3 += "|" + isCheck; });
					answer = answer + "/" + question3;
				<%}else if(types[i].equals("2")){%>
					answer = answer + "/" + $("#<%=nos[i]%>").val();
				<%}
			}
		 %>
		 var t = "<%=type%>";
		 var q = "<%=questionno%>";
		 var n = "<%=Qno%>";
		 var p = "<%=no%>";
		 var pp = "<%=pages%>";
		 if(confirm("是否确认提交？")){
			location.href="/CIABPSys/admin/updateanswer.action?page="+pp+"&no="+p+"&type="+t+"&questionno="+q+"&questionaireno="+n+"&answer="+answer;
		 }
		
		
	}
</SCRIPT>
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
						<tr style="margin-left: 0px" align="center" height="40px"><th style="margin-left: 0px" align="left"><textarea name="<%=question.getNo() %>" type="text" class="inputbox" id="<%=question.getNo() %>"
											style="width:600px;hight:60px"><%=question.getAnswer() %></textarea></th></tr>
					<% }else if(question.getType().equals("0")){ 
						String option = question.getOption();
						String[] options = option.split("/");
						String danswers = question.getAnswer();
						%>
						<tr style="margin-left: 0px" align="center" height="40px"><th style="margin-left: 0px" align="left">
						<% for(int i = 0;i < options.length;i++){
							
						%>
							<input name="<%=question.getNo() %>" id="<%=question.getNo() %>" type="radio" value="<%=options[i] %>" /><%=options[i] %>
						<%} 
						
						%>
						<SCRIPT type=text/javascript>
							$("input[name='<%=question.getNo() %>'][value='<%=danswers%>']").attr("checked","checked");
						</SCRIPT>		
						</th></tr>		
					<%}else if(question.getType().equals("1")){ 
						String option = question.getOption();
						String[] options = option.split("/");
						String[] answers = question.getAnswer().split("\\|");
						%>
						<tr style="margin-left: 0px" align="center" height="40px"><th style="margin-left: 0px" align="left">
						<% 
						List ll = Arrays.asList(answers);
						for(int i = 0;i < options.length;i++){
							if(ll.contains(options[i].trim())){	
						%>
							<input name="<%=question.getNo() %>" id="<%=question.getNo() %>" type="checkbox" value="<%=options[i].trim() %>" checked="checked"/><%=options[i] %>
						<%}else{%>
							<input name="<%=question.getNo() %>" id="<%=question.getNo() %>" type="checkbox" value="<%=options[i].trim() %>"/><%=options[i] %>
						<%}
						
						} %>
						
						</th></tr>
					<%} %>
				
    			<% }
    		}
    	 %>
						
    </table><input type="submit" value="保存" style="height:28px; width:60px; margin-top: 50px" onclick="getanswers();return false;"></form><a href="${pageContext.request.contextPath}/superadmin/downloadQ.action?no=${requestScope.no}&qno=${requestScope.Qno}">下载</a>
    </center>
  </body>
</html>
