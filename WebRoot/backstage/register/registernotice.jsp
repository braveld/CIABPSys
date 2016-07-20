<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registernotice.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <SCRIPT type=text/javascript>

	function tiaozhuan(){
		window.location="/CIABPSys/backstage/register.jsp";
	}
</SCRIPT>
  </head>

  <body>
   	<center>
		<h2>注册须知</h2>

		<hr>
		<table border="1" width="1200" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<tr height="40">
				<th width="200" style="color:#1F85B6">标题</th>
				<th width="200" style="color:#1F85B6">内容</th>
			</tr>
		
			<tr>
				<th>注册须知</th>
				<td align="left"><font style="font-family:宋体;font-size:80%;line-height:150%"><br/>
					<ul>
						<li>您注册白塞人临床信息档案馆时，根据网站要求提供您的个人信息；</li>
						<li>我们不会向任何人出售或出借您的个人信息，除非事先得到您的许可。</li>
						<li>为服务用户的目的，我们可能通过使用您的个人信息，向您提供帮助，包括但不限于向您发出活动和服务信息等。</li>
					</ul>
					　　信息披露<br/>
					<ul>
						<li>您的个人信息将在下述情况下部分或全部被披露：</li>
						<li>经您同意，向第三方披露；</li>
						<li>如您是符合资格的知识产权投诉人并已提起投诉，应被投诉人要求，向被投诉人披露，以便双方处理可能的权利纠纷；</li>
						<li>根据法律的有关规定，或者行政或司法机构的要求，向第三方或者行政、司法机构披露；</li>
						<li>如果您出现违反中国有关法律或者网站政策的情况，需要向第三方披露；</li>
						<li>为提供你所要求的产品和服务，而必须和第三方分享您的个人信息；</li>
						<li>其他本网站根据法律或者网站政策认为合适的披露。</li>
					</ul>
					　　 会员须做到<br/>
					<ul>
						<li>用户名和昵称的注册与使用应符合网络道德，遵守中华人民共和国的相关法律法规。</li>
						<li>用户名和昵称中不能含有威胁、淫秽、漫骂、非法、侵害他人权益等有争议性的文字。</li>
						<li>注册成功后，会员必须保护好自己的帐号和密码，因会员本人泄露而造成的任何损失由会员本人负责。</li>
						<li>不得盗用他人帐号，由此行为造成的后果自负。</li>
					</ul>
					　　 政策修改<br/>
					<ul>
						<li>白塞人临床信息档案馆保留对本政策作出不定时修改的权利。</li>
						<li>本隐私声明是您与白塞人临床信息档案馆签署的注册协议的一部分，请您仔细阅读。</li>
					</ul></font></td>
			
			</tr>
			
				
		</table>
		<input type="submit" value="知道了，注册" onclick="tiaozhuan();return false;"
						style="height:28px; width:120px; margin-left:50px;">
			
	</center>
  </body>
</html>
