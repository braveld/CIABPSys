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
    <base href="<%=basePath%>">
    
    <title>superadmin</title>
    
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
					xu = xuanxiangs.get(i).split(",");
					int begin = 0;
					if(xu[0]==null || xu[0].equals("")){
						begin = 1;
					}
				%>
					<tr style="margin-left: 0px" align="center" height="50px"><th align="left">
					*&nbsp;<%=questions.get(i) %></th></tr>
					<tr style="margin-left: 0px" align="center" height="40px">
						<th style="margin-left: 0px" align="left">
							<div id="div<%=i %>" style="width:700px;height:400px;float:left;display:block; float:left;">		 	 
	     					</div>
	     					<script type="text/javascript">
	     						var myChart = document.getElementById("div<%=i %>");
	     						var y = '\'<%=xu[begin]%>\'';
	     						var x = '<%=qlist.get(0).getResult()%>';
	     						<%
	     						for(int j = begin+1;j < xu.length;j++){%>
	     							y = y + ',' + '\''+<%=xu[j]%>+'\'';
	     						<%}
	     						%>
	     						<%
	     						for(int k = 1;k < qlist.size();k++){%>
	     							x = x + ',' + '\''+<%=qlist.get(k).getResult()%>+'\'';
	     						<%}
	     						%>
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
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
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
				rotate: 60,
			},
			textStyle : {
				fontSize : 12,
			},
            type : 'category',
            data : [y]
        }
    ],
    series : [
        {
            name:'次数',
            type:'bar',
            data:[x]
        }
    ]
};
	
				                // 为echarts对象加载数据 
				                myChart.setOption(option); 
				                //指标详情chart
		        				require.config({
		            				paths: {
		                				echarts: '<%=basePath%>js/build/dist'
		            				}
		        				});
	     					</script>
	     				</th>
	     			</tr>
				<% }
			 %>
		</table>
  </body>
</html>
