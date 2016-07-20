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
    
    <title>admin/userinfo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function HS_DateAdd(interval,number,date){
 number = parseInt(number);
 if (typeof(date)=="string"){var date = new Date(date.split("-")[0],date.split("-")[1],date.split("-")[2])}
 if (typeof(date)=="object"){var date = date}
 switch(interval){
 case "y":return new Date(date.getFullYear()+number,date.getMonth(),date.getDate()); break;
 case "m":return new Date(date.getFullYear(),date.getMonth()+number,checkDate(date.getFullYear(),date.getMonth()+number,date.getDate())); break;
 case "d":return new Date(date.getFullYear(),date.getMonth(),date.getDate()+number); break;
 case "w":return new Date(date.getFullYear(),date.getMonth(),7*number+date.getDate()); break;
 }
}
function checkDate(year,month,date){
 var enddate = ["31","28","31","30","31","30","31","31","30","31","30","31"];
 var returnDate = "";
 if (year%4==0){enddate[1]="29"}
 if (date>enddate[month]){returnDate = enddate[month]}else{returnDate = date}
 return returnDate;
}

function WeekDay(date){
 var theDate;
 if (typeof(date)=="string"){theDate = new Date(date.split("-")[0],date.split("-")[1],date.split("-")[2]);}
 if (typeof(date)=="object"){theDate = date}
 return theDate.getDay();
}
function HS_calender(){
 var lis = "";
 var style = "";
 style +="<style type='text/css'>";
 style +=".calender { width:170px; height:auto; font-size:12px; margin-right:14px; background:url(calenderbg.gif) no-repeat right center #fff; border:1px solid #397EAE; padding:1px}";
 style +=".calender ul {list-style-type:none; margin:0; padding:0;}";
 style +=".calender .day { background-color:#EDF5FF; height:20px;}";
 style +=".calender .day li,.calender .date li{ float:left; width:14%; height:20px; line-height:20px; text-align:center}";
 style +=".calender li a { text-decoration:none; font-family:Tahoma; font-size:11px; color:#333}";
 style +=".calender li a:hover { color:#f30; text-decoration:underline}";
 style +=".calender li a.hasArticle {font-weight:bold; color:#f60 !important}";
 style +=".lastMonthDate, .nextMonthDate {color:#bbb;font-size:11px}";
 style +=".selectThisYear a, .selectThisMonth a{text-decoration:none; margin:0 2px; color:#000; font-weight:bold}";
 style +=".calender .LastMonth, .calender .NextMonth{ text-decoration:none; color:#000; font-size:18px; font-weight:bold; line-height:16px;}";
 style +=".calender .LastMonth { float:left;}";
 style +=".calender .NextMonth { float:right;}";
 style +=".calenderBody {clear:both}";
 style +=".calenderTitle {text-align:center;height:20px; line-height:20px; clear:both}";
 style +=".today { background-color:#ffffaa;border:1px solid #f60; padding:2px}";
 style +=".today a { color:#f30; }";
 style +=".calenderBottom {clear:both; border-top:1px solid #ddd; padding: 3px 0; text-align:left}";
 style +=".calenderBottom a {text-decoration:none; margin:2px !important; font-weight:bold; color:#000}";
 style +=".calenderBottom a.closeCalender{float:right}";
 style +=".closeCalenderBox {float:right; border:1px solid #000; background:#fff; font-size:9px; width:11px; height:11px; line-height:11px; text-align:center;overflow:hidden; font-weight:normal !important}";
 style +="</style>";

 var now;
 if (typeof(arguments[0])=="string"){
  selectDate = arguments[0].split("-");
  var year = selectDate[0];
  var month = parseInt(selectDate[1])-1+"";
  var date = selectDate[2];
  now = new Date(year,month,date);
 }else if (typeof(arguments[0])=="object"){
  now = arguments[0];
 }
 var lastMonthEndDate = HS_DateAdd("d","-1",now.getFullYear()+"-"+now.getMonth()+"-01").getDate();
 var lastMonthDate = WeekDay(now.getFullYear()+"-"+now.getMonth()+"-01");
 var thisMonthLastDate = HS_DateAdd("d","-1",now.getFullYear()+"-"+(parseInt(now.getMonth())+1).toString()+"-01");
 var thisMonthEndDate = thisMonthLastDate.getDate();
 var thisMonthEndDay = thisMonthLastDate.getDay();
 var todayObj = new Date();
 today = todayObj.getFullYear()+"-"+todayObj.getMonth()+"-"+todayObj.getDate();
 
 for (i=0; i<lastMonthDate; i++){  // Last Month's Date
  lis = "<li class='lastMonthDate'>"+lastMonthEndDate+"</li>" + lis;
  lastMonthEndDate--;
 }
 for (i=1; i<=thisMonthEndDate; i++){ // Current Month's Date

  if(today == now.getFullYear()+"-"+now.getMonth()+"-"+i){
   var todayString = now.getFullYear()+"-"+(parseInt(now.getMonth())+1).toString()+"-"+i;
   lis += "<li><a href=javascript:void(0) class='today' onclick='_selectThisDay(this)' title='"+now.getFullYear()+"-"+(parseInt(now.getMonth())+1)+"-"+i+"'>"+i+"</a></li>";
  }else{
   lis += "<li><a href=javascript:void(0) onclick='_selectThisDay(this)' title='"+now.getFullYear()+"-"+(parseInt(now.getMonth())+1)+"-"+i+"'>"+i+"</a></li>";
  }
  
 }
 var j=1;
 for (i=thisMonthEndDay; i<6; i++){  // Next Month's Date
  lis += "<li class='nextMonthDate'>"+j+"</li>";
  j++;
 }
 lis += style;

 var CalenderTitle = "<a href='javascript:void(0)' class='NextMonth' onclick=HS_calender(HS_DateAdd('m',1,'"+now.getFullYear()+"-"+now.getMonth()+"-"+now.getDate()+"'),this) title='Next Month'>&raquo;</a>";
 CalenderTitle += "<a href='javascript:void(0)' class='LastMonth' onclick=HS_calender(HS_DateAdd('m',-1,'"+now.getFullYear()+"-"+now.getMonth()+"-"+now.getDate()+"'),this) title='Previous Month'>&laquo;</a>";
 CalenderTitle += "<span class='selectThisYear'><a href='javascript:void(0)' onclick='CalenderselectYear(this)' title='Click here to select other year' >"+now.getFullYear()+"</a></span>年<span class='selectThisMonth'><a href='javascript:void(0)' onclick='CalenderselectMonth(this)' title='Click here to select other month'>"+(parseInt(now.getMonth())+1).toString()+"</a></span>月";

 if (arguments.length>1){
  arguments[1].parentNode.parentNode.getElementsByTagName("ul")[1].innerHTML = lis;
  arguments[1].parentNode.innerHTML = CalenderTitle;

 }else{
  var CalenderBox = style+"<div class='calender'><div class='calenderTitle'>"+CalenderTitle+"</div><div class='calenderBody'><ul class='day'><li>日</li><li>一</li><li>二</li><li>三</li><li>四</li><li>五</li><li>六</li></ul><ul class='date' id='thisMonthDate'>"+lis+"</ul></div><div class='calenderBottom'><a href='javascript:void(0)' class='closeCalender' onclick='closeCalender(this)'>×</a><span><span><a href=javascript:void(0) onclick='_selectThisDay(this)' title='"+todayString+"'>Today</a></span></span></div></div>";
  return CalenderBox;
 }
}
function _selectThisDay(d){
 var boxObj = d.parentNode.parentNode.parentNode.parentNode.parentNode;
  boxObj.targetObj.value = d.title;
  boxObj.parentNode.removeChild(boxObj);
}
function closeCalender(d){
 var boxObj = d.parentNode.parentNode.parentNode;
  boxObj.parentNode.removeChild(boxObj);
}

function CalenderselectYear(obj){
  var opt = "";
  var thisYear = obj.innerHTML;
  for (i=1900; i<=2020; i++){
   if (i==thisYear){
    opt += "<option value="+i+" selected>"+i+"</option>";
   }else{
    opt += "<option value="+i+">"+i+"</option>";
   }
  }
  opt = "<select onblur='selectThisYear(this)' onchange='selectThisYear(this)' style='font-size:11px'>"+opt+"</select>";
  obj.parentNode.innerHTML = opt;
}

function selectThisYear(obj){
 HS_calender(obj.value+"-"+obj.parentNode.parentNode.getElementsByTagName("span")[1].getElementsByTagName("a")[0].innerHTML+"-1",obj.parentNode);
}

function CalenderselectMonth(obj){
  var opt = "";
  var thisMonth = obj.innerHTML;
  for (i=1; i<=12; i++){
   if (i==thisMonth){
    opt += "<option value="+i+" selected>"+i+"</option>";
   }else{
    opt += "<option value="+i+">"+i+"</option>";
   }
  }
  opt = "<select onblur='selectThisMonth(this)' onchange='selectThisMonth(this)' style='font-size:11px'>"+opt+"</select>";
  obj.parentNode.innerHTML = opt;
}
function selectThisMonth(obj){
 HS_calender(obj.parentNode.parentNode.getElementsByTagName("span")[0].getElementsByTagName("a")[0].innerHTML+"-"+obj.value+"-1",obj.parentNode);
}
function HS_setDate(inputObj){
 var calenderObj = document.createElement("span");
 calenderObj.innerHTML = HS_calender(new Date());
 calenderObj.style.position = "absolute";
 calenderObj.targetObj = inputObj;
 inputObj.parentNode.insertBefore(calenderObj,inputObj.nextSibling);
}

  </script>
<style>
  body {font-size:12px}
  td {text-align:center}
  h1 {font-size:26px;}
  h4 {font-size:16px;}
  em {color:#999; margin:0 10px; font-size:11px; display:block}
  </style>
  </head>
  
  <body>
  <center>
   		<form method="post" action="${pageContext.request.contextPath}/admin/uupdateUser.action?&no=${user.no}">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td height="100%" align="center" bgcolor="#e3efff">
					<table width="762" height="435" border="0" cellpadding="0"
						cellspacing="0" background="../images/loginBg.png">
						<tr> <center>
							<td><table border="1" align="center" cellpadding="0"
									cellspacing="7">
									<tr>
										<td><span style="font-size:12px;">*手机（登录名）：</span> </td>
										<td><input name="user.mphone" type="text" id="user.mphone"
											class="inputbox" style="width:160px;hight:20px"  onblur="phoneInfoOnBlur(this);" value="${requestScope.user.mphone}"><span id ="phoneInfo"></span></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">*用户名：</span></td>
										<td><input name="user.nick" type="text" class="inputbox" id="user.nick" onBlur="validate(this.value);" value="${requestScope.user.nick}"
											style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">*姓名：</span></td>
										<td><input name="user.name" type="text" id="user.name" value="${requestScope.user.name}"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">*性别：</span></td>
										<td><input name="user.sex" type="text" id="user.sex" value="${requestScope.user.sex}"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">*民族：</span></td>
										<td><input name="user.type" type="text" id="user.type" value="${requestScope.user.type}"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">*出生日期：</span></td>
										<td><input name="user.birthday" id="user.birthday" type="text" class="inputbox" style="width:160px;hight:20px" onfocus="HS_setDate(this)" value="${requestScope.user.birthday}"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">*教育程度：</span></td>
										<td><select id="user.education" name="user.education" style="width:160px;hight:20px">
										<c:if test="${requestScope.user.education eq 0}">
												<option value ="0">小学</option>  
  												<option value ="1">初中</option>  
  												<option value="2">高中</option>
  												<option value="3">大学及以上学历</option>
  												<option value="4">其他</option>
										</c:if>
                  						<c:if test="${requestScope.user.education eq 1}">
												<option value ="1" selected="selected">初中</option> 
												<option value ="0">小学</option>  
  												 
  												<option value="2">高中</option>
  												<option value="3">大学及以上学历</option>
  												<option value="4">其他</option>
										</c:if>
										<c:if test="${requestScope.user.education eq 2}">
												<option value="2" selected="selected">高中</option>
												<option value ="0">小学</option>  
  												<option value ="1">初中</option>  
  												
  												<option value="3">大学及以上学历</option>
  												<option value="4">其他</option>
										</c:if>
										<c:if test="${requestScope.user.education eq 3}">
												<option value="3" selected="selected">大学及以上学历</option>
												<option value ="0">小学</option>  
  												<option value ="1">初中</option>  
  												<option value="2">高中</option>
  												
  												<option value="4">其他</option>
										</c:if>
										<c:if test="${requestScope.user.education eq 4}">
												<option value="4" selected="selected">其他</option>
												<option value ="0">小学</option>  
  												<option value ="1">初中</option>  
  												<option value="2">高中</option>
  												<option value="3">大学及以上学历</option>
  												
										</c:if>
                  							</select></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">*职业：</span></td>
										<td><input name="user.work" type="text" id="user.work" value="${requestScope.user.work}"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">*电子邮件：</span></td>
										<td><input name="user.email" type="text" id="user.email" value="${requestScope.user.email}"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">*qq：</span></td>
										<td><input name="user.qq" type="text" id="user.qq" value="${requestScope.user.qq}"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">微信号：</span></td>
										<td><input name="user.weixin" type="text" id="user.weixin" value="${requestScope.user.weixin}"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									
									<tr>
										<td><span style="font-size:12px;">*家庭联系电话：</span></td>
										<td><input name="user.phone" type="text" id="user.phone" value="${requestScope.user.phone}"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span style="font-size:12px;">家庭住址：</span></td>
										<td><input name="user.address" type="text" id="user.address" value="${requestScope.user.address}"
											class="inputbox" style="width:160px;hight:20px"></td>
									</tr>
									<tr>
										<td><span >注：带星号为必填选项</span></td>
									</tr>
									<tr>
										<td height="100" colspan="2" valign="top"><table
												border="0" align="center" cellpadding="0" cellspacing="5">
												<tr>
													<td><input type="submit" value="保存" 
															style="height:28px; width:60px; margin-left:50px;">
													</td>
												</tr>
											</table></td>
									</tr>
								</table> </center></td>
						</tr>
					</table></td>
			</tr>
		</table>
		</form>
		</center>
  </body>
</html>
