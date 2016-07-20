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
    
    
    <title>userQ/downloadresult.jsp</title>
    
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
		require.config({
			paths: {
   				echarts: '<%=basePath%>js/build/dist'
			}
		});
	</script>
	<%response.setHeader("Content-Disposition", "attachment;filename=filenmane.doc"); %>
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
								    calculable : true,
								    yAxis : [
								        {
								            type : 'value',
								            boundaryGap : [0, 0.01]
								        }
								    ],
								    xAxis : [
								    	
								        {
									        axisLabel : {
												rotate: 45,
												textStyle:{
													color:"black", //刻度颜色
													fontWeight:'550',
													fontSize:13  //刻度大小
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
	        				}
	        				);
	        				
	     					</script>
	     				</th>
	     			</tr>
				<% }
			 %>
		</table>
  </body>
</html>
