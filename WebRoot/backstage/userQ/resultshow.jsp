<%@page import="com.ciabp.models.Qresult"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>userQ/resultshow.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=basePath%>js/echarts.js"></script>
	<script type="text/javascript">
		var data=new Array(); 
		function xiazai(){
			location.href="/CIABPSys/user/submitAnswer.action?type="+t+"&questionno="+q+"&questionaireno="+n+"&answer="+answer;
		}
	</script>
	<script type="text/javascript">
		require.config({
			paths: {
   				echarts: '<%=basePath%>js/build/dist'
			}
		});
	</script>
  </head>
  
  <body>
     <center>
   	<h2>问卷</h2>

		<hr>
		<form>
		<table border="0" width="600" cellpadding="0" cellspacing="0" bordercolor="#1F85B6">
			<%
				List<List<Qresult>> list = (List<List<Qresult>>)request.getAttribute("qresultlist");
				List<String> questions = (List<String>)request.getAttribute("questions");
				List<String> xuanxiangs = (List<String>)request.getAttribute("xuanxiangs");
				List<Qresult> qlist = null;
				String[] xu = null;
				
				for(int i = 0;i < questions.size();i++){
					qlist = list.get(i);
					String x = "";
					String y = "";
					
					for(int p = 0;p < qlist.size();p++){
						if(p == 0){
							x = "'"+qlist.get(0).getXuanxiang()+"'";
						}else{
							x = x+",'"+qlist.get(p).getXuanxiang()+"'";
						}
						
					}
					for(int k = 0;k < qlist.size();k++){
						if(k==0){
							y = "'"+qlist.get(0).getResult()+"'";
						}else{
							y = y + ",'" + qlist.get(k).getResult() + "'";
						}
						
					}
					if(qlist.size() >= 10){
				%>
					
					<tr style="margin-left: 0px" align="center" height="40px">
						<th style="margin-left: 0px" align="left">
							<div id="div<%=i %>" style="width:700px;height:400px;float:left;display:block; float:left;">		 	 
	     					</div>
	     					<script type="text/javascript">
	     					 require(
				            [
				                'echarts',
				                'echarts/chart/bar'
				                
				            ],
				            function (ec) {
	     						var myChart<%=i %> = ec.init(document.getElementById("div<%=i %>"));
	     						option = {
								    title : {
								        text: '<%=questions.get(i)%>',
								    },
								    tooltip : {
								        trigger: 'axis'
								    },
								    legend: {
								        data:['次数']
								    },
								    
								    yAxis : [
								        {
								            type : 'value',
								            boundaryGap : [0, 0.01]
								        }
								    ],
								    dataZoom:{
										orient:"horizontal", //水平显示
										handleSize:3,
										show:true, //显示滚动条
										start:20, //起始值为20%
										end:60  //结束值为60%
									},
									
							        calculable : false,
							            animation : false,
								    xAxis : [
								    	
								        {
									        axisLabel : {
												rotate: 25,
												textStyle:{
													color:"black", //刻度颜色
													fontWeight:'600',
													fontSize:16  //刻度大小
												}
											},
								            type : 'category',
								            data : [<%=x%>]
								        }
								    ],
								    grid: { // 控制图的大小，调整下面这些值就可以，
							             x: 60,
							             x2: 80,
							             y2: 150,// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
							         },
								    series : [
								        {
								            name:'次数',
								            type:'bar',
								            data:[<%=y%>]
								        }
								    ]
								};
	
				                // 为echarts对象加载数据 
				                myChart<%=i %>.setOption(option); 
				                //data[i]=myChart<%=i %>.getDataURL("png");
							    
	        				}
	        				);
	        				
	     					</script>
	     				</th>
	     			</tr>
				<% }else{%>
					<tr style="margin-left: 0px" align="center" height="40px">
						<th style="margin-left: 0px" align="left">
							<div id="div<%=i %>" style="width:700px;height:400px;float:left;display:block; float:left;">		 	 
	     					</div>
	     					<script type="text/javascript">
	     					 require(
				            [
				                'echarts',
				                'echarts/chart/bar'
				                
				            ],
				            function (ec) {
	     						var myChart<%=i %> = ec.init(document.getElementById("div<%=i %>"));
	     						option = {
								    title : {
								        text: '<%=questions.get(i)%>',
								    },
								    tooltip : {
								        trigger: 'axis'
								    },
								    legend: {
								        data:['次数']
								    },
								    
								    yAxis : [
								        {
								            type : 'value',
								            boundaryGap : [0, 0.01]
								        }
								    ],
								  
							        calculable : false,
							            animation : false,
								    xAxis : [
								    	
								        {
									        axisLabel : {
												textStyle:{
													color:"black", //刻度颜色
													fontWeight:'600',
													fontSize:14  //刻度大小
												}
											},
								            type : 'category',
								            data : [<%=x%>]
								        }
								    ],
								    grid: { // 控制图的大小，调整下面这些值就可以，
							             x: 60,
							             x2: 80,
							             y2: 150,// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
							         },
								    series : [
								        {
								            name:'次数',
								            type:'bar',
								            data:[<%=y%>]
								        }
								    ]
								};
	
				                // 为echarts对象加载数据 
				                myChart<%=i %>.setOption(option); 
				                //data[i]=myChart<%=i %>.getDataURL("png");
				                 
	        				}
	        				);
	        				
	     					</script>
	     				</th>
	     			</tr>
				<% }
				}
			 %>
		</table>
		<script type="text/javascript">
		function xiazai(){
			location.href="/CIABPSys/superadmin/sresultshow.action?qno=${requestScope.no}&data="+data;
		}
	</script>
		

  </body>
</html>
