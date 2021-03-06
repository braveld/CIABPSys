<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>临床诊断</title>
    
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
  <script language="JavaScript" src="js/jquery-1.11.1.js"></script>
	<style type="text/css">
		
		img{border:none;}
		
		
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
     	<c:choose>
     		<c:when test='${requestScope.jieguo == "success"}'><script>alert("添加成功");</script></c:when>
     	</c:choose>
		<h2>临床诊断</h2>
		<hr>
		<form method="post" action="${pageContext.request.contextPath}/user/writelc.action" enctype="multipart/form-data">
		<table border="1" width="1000" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<tr height="40">
				<th style="color:#1F85B6">就诊日期：<input name="date" id="date" type="text" class="inputbox" style="width:100px" onfocus="HS_setDate(this)"></th>
				<th style="color:#1F85B6">就诊医院：<input name="linchuang.hospital" type="text" class="inputbox" id="linchuang.hospital"
											style="width:100px;hight:20px"></th>
				<th style="color:#1F85B6">就诊医生：<input name="linchuang.doctor" type="text" class="inputbox" id="linchuang.doctor"
											style="width:100px;hight:20px"></th>
				<th style="color:#1F85B6"><input type="file" value="上传临床检测单" name="lcimage" id="lcimage"></th>
			</tr>
		</table>
		<input type="submit" value="提交" style="height:28px; width:60px;margin-top: 20px; ">
		</form>
		<hr>
		<table border="1" width="1000" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
		 <thead>
			<tr height="40">
				<th style="color:#1F85B6">就诊日期</th>
				<th style="color:#1F85B6">就诊医院</th>
				<th style="color:#1F85B6">就诊医生</th>
				<th style="color:#1F85B6">上传文件</th>
				<th style="color:#1F85B6">操作</th>
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
					<td><a href="${pageContext.request.contextPath}/user/deleteL.action?id=${linchuang.id}&no=${linchuang.userno}&filename=${linchuang.filename}">删除</a></td>
				</tr>	
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" align="right"><right><form action="${pageContext.request.contextPath }/user/${requestScope.actionName }.action" method="post">当前是第${requestScope.upageVO.page }页
				|共${ requestScope.upageVO.pageCount}页|
					<c:choose>
						<c:when test="${ requestScope.upageVO.page le 1 }">上一页</c:when>
						<c:otherwise>
							<a
								href="${pageContext.request.contextPath }/user/${requestScope.actionName }.action?page=${ requestScope.upageVO.page - 1 }">上一页</a>
						</c:otherwise>
					</c:choose> 
					|跳转到<input name="page" id="page" type="text" style="height:23px; width:30px;"><input type="submit" value="跳转" ">
					&nbsp;|<c:choose>
						<c:when test="${ requestScope.upageVO.page ge requestScope.upageVO.pageCount }">下一页</c:when>
						<c:otherwise>
						<a
								href="${pageContext.request.contextPath }/user/${requestScope.actionName }.action?page=${ requestScope.upageVO.page +1 }">下一页</a>
						</c:otherwise>
					</c:choose>
					</form></right></td>
			</tr>
		</tfoot>
		</table>
	</center>
  </body>
</html>
