<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <c:import charEncoding="UTF-8" url="../meta.jsp"></c:import> 
<style type="text/css">
 #container01,#container02,#container03{
        margin: -5px;
        padding: 0px;
        box-shadow:0px 1px 2px 1px #aaaaaa,
                   inset 0px 1px 1px rgba(255,255,255,0.7);
        border-radius: 3px;
}
#container02,#container03{
	//width: 453px;  //chrome 解析度110%
}
#container02{
	//margin-left: 10px; //chrome 解析度110%
}
#container03{
	//margin-left: -12px; //chrome 解析度110%
}
</style>
</head>
<body>
	<div id="wrapper">
		<c:import charEncoding="UTF-8" url="../nav.jsp"></c:import>
		<div id="page-wrapper">
			<!-- <div class="row">
				<div class="col-md-4">
					<h3 class="">會員資料分析圖</h3>
				</div>
			</div>
			<hr> -->
			<div class="row">
				<div class="col-md-12">
					<!-- /.panel-heading -->
					<div class="panel-body">
					<div id="container01" style="min-width: 400px; height: 300px; margin: -1"></div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div id="container02" style="height: 210px;"></div>
				</div>
				<div class="col-md-6">
					<div id="container03" style="height: 210px;"></div>
				</div>
			</div>
			<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
</body>
<script type="text/ecmascript"	src="${pageContext.request.contextPath}/js/highchart/highcharts.js"></script>
<script type="text/ecmascript"	src="${pageContext.request.contextPath}/js/highchart/highcharts-3d.js"></script>
<script type="text/ecmascript"	src="${pageContext.request.contextPath}/js/highchart/modules/exporting.js"></script>
<!-- 
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
 -->
<script type="text/javascript">
$(function () {
	$.ajax({
		url : "chart1select",
		type:"get",
		success : function(data) {
		if (data != null) {
			var chart1age = new Array();
								//['0-14','15-19',
			                    //'20-24','25-29',
			                    //'30-34','35-39',
			                    //'40-44','45以上'];
		    var chart1data0 = new Array();//[null, 3, 61, 53, 24, null, null, null];
		    var chart1data1 = new Array();//[null, null , 49, 160, null, null, null,null];
			var result =data;
			var idx = 0;
			for (var i = 0; i < result.length; i++,idx++) {
				var item = result[i];
			 	chart1age[idx]=item.age;
			 	if (item.gender == 0)
			 		chart1data0[idx]=((item.sumcnt==null)?null:item.sumcnt);
			 	else
			 		chart1data1[idx]=((item.sumcnt==null)?null:item.sumcnt);

			 	i++; 	
				var item = result[i];
			 	if (item.gender == 0)
			 		chart1data0[idx]=((item.sumcnt==null)?null:item.sumcnt);
			 	else
			 		chart1data1[idx]=((item.sumcnt==null)?null:item.sumcnt);
			 	//console.log("=>"+chart1age[idx]+","+chart1data0[idx]+","+chart1data1[idx]);
			}
			
		    $('#container01').highcharts({
			    colors: ["#F060A0" , "#9999CC"],
		        chart: {
		            type: 'column',
		            options3d: {
		                enabled: true,
		                alpha: 5,
		                beta: 15,
		                viewDistance: 25,
		                depth: 40
		            }
		        },
		        title: {
		            text: '會員年齡級距分析',
		            y: 20,
		            style: {
		                fontSize: '14px'
		            }
		        },
		        xAxis: {
		         	title: {
		             		text: '年齡級距(歲)'
		            },
		            categories: chart1age
		        },
		        yAxis: {
		            allowDecimals: false,
		            min: 0,
			       	title: {
		              text: '人數 (位)'
		         	}
		        },
		        tooltip: {
		            headerFormat: '<b>{point.key}歳</b><br>',
		            pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y}位 / Total:{point.stackTotal}'
		        },
		        legend: {
		            align: 'right',
		            x: -60,
		            verticalAlign: 'top',
		            y: 5,
		            floating: true,
		            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
		            borderColor: '#CCC',
		            borderWidth: 1,
		            shadow: false
		        },
		        plotOptions: {
		            column: {
		                stacking: 'normal',
		                depth: 40
		            }
		        },
		        series: [{
		            name: '女',
		            data: chart1data0,
		            stack: 'mem'
		        }, {
		            name: '男',
		            data: chart1data1,
		            stack: 'mem'
		        }]
		    });
		}}
	});
 

	$.ajax({
		url : "chart2select",
		type:"get",
		success : function(data) {
		if (data != null) {
		    var chart2data0 = 0;//141 ;
		    var chart2data1 = 0;//209 ;
			var result =data;
			for (var i = 0; i < result.length; i++) {
				var item = result[i];
			 	if (item.gender == 0)
			 		chart2data0=((item.cnt==null)?null:item.cnt);
			 	else
			 		chart2data1=((item.cnt==null)?null:item.cnt);
			 	
			 	i++; 	
				var item = result[i];
			 	if (item.gender == 0)
			 		chart2data0=((item.cnt==null)?null:item.cnt);
			 	else
			 		chart2data1=((item.cnt==null)?null:item.cnt);
			 	//console.log("=>"+chart2data0+","+chart2data1);
			}
			
		    $('#container02').highcharts({
			    colors: ["#ff0080","#7798BF" ],
		        chart: {
		            type: 'pie',
		            options3d: {
		                enabled: true,
		                alpha: 45,
		                beta: 0
		            }
		        },
		        title: {
		            text: '男/女比例分析',
		                style: {
		                    fontSize: '14px'
		                }
		        },
		        plotOptions: {
		            pie: {
		                allowPointSelect: true,
		                cursor: 'pointer',
		                depth: 35,
		                dataLabels: {
		                    enabled: true,
		                    format: '{point.name}'
		                }
		            }
		        },
		        series: [{
		            name: '人數',
		            data: [
		                ['女'+(((chart2data0)/(chart2data0+chart2data1))*100).toFixed(2)+'%', chart2data0],
		                ['男'+(100-(((chart2data0)/(chart2data0+chart2data1))*100).toFixed(2))+'%', chart2data1]
		            ]
		        }]
		    });
		}}
	});

	$.ajax({
		url : "chart3select",
		type:"get",
		success : function(data) {
		if (data != null) {
		    var chart3data = new Array();
		    /*		    [[19, 3],[20, 2],[21, 3],
		                   [22, 17],[23, 17],[24, 71],
		                   [25, 55],[26, 61],[27, 40],
		                   [28, 27],[29, 30],[30, 8],
		                   [31, 3],[32, 3],[33, 4],
		                   [34, 6]]
		    */
			var result =data;
			for (var i = 0; i < result.length; i++) {
				var item = result[i];
				chart3data[i] = new Array();
				chart3data[i][0] = ((item.age==null)?null:item.age);
				chart3data[i][1] = ((item.cnt==null)?null:item.cnt);
				//console.log(chart3data[i][0]+","+chart3data[i][1]);
			}
			
		    $('#container03').highcharts({
			    colors: ["#7D7DFF"],
		        title: {
		            text: '會員年齡分析',
		            x: -20, //center
		            style: {
		                fontSize: '14px'
		            }
		        },
		        xAxis: {
		       	  title: {
		       		text: '年齡(歲)'
		          },
		          labels: {
		            formatter: function () {
		                return this.value + '歲';
		            }
		          }
		        },
		        yAxis: {
		        	 title: {
		                 text: '人數 (位)'
		             },
		            plotLines: [{
		                value: 0,
		                width: 1,
		                color: '#808080'
		            }]
		        },
		        tooltip: {
		            headerFormat: '<b>{series.name}</b><br/>',
		            pointFormat: '{point.x}歲: {point.y}位'
		        },
		        legend: {
		            enabled: false
		        },
		        plotOptions: {
		            line: {
		                dataLabels: {
		                    enabled: true
		                }
		            },
		            column: {
		                depth: 25
		            }
		        },
		        series: [{
		            name: '會員',
		            data: chart3data
		        }]
		    });
		}}
	});	


});
</script>

</html>
