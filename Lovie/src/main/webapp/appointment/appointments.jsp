<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<style>
.col-lg-12 label {
	margin: 10px;
}
#div1{
	position: absolute;
	z-index: 1;
}
.col-md-3 a img{
	height: 280px;
}
.col-md-3{
	margin-bottom: 20px;
}
</style>
<title>查詢約會</title>
</head>
<body>
<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
<sec:authorize access="!hasRole('USER')">
	<div style="color:red;font-size:1.2em;">　請先登入，一般會員以上等級才可執行查詢約會功能.</div>
</sec:authorize>
<sec:authorize access="hasRole('USER')"> 
<div class="container">
<div class="row"><div class="col-md-12">
  <ul class="nav nav-tabs nav-justified">
  <li><img src="image/icon/logo.png" style="width:90px;float:right;padding-right:20px;"></img>
  <div style="color:red">會員:${loginmember.account}${loginmember.nickname}</div>
  </li>
    <li class="active"><a href="appointments">一週約會通知</a></li>
    <li><a href="appointmentb">申請的約會</a></li>
    <li><a href="appointmenta">邀請的約會</a></li>
  </ul>
  <div class="tab-content">
  <div id="menu1" class="tab-pane fade in active">
	<div class="row">
		<div class="col-md-12">
			<div id='calendarappoint' ></div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		約會事件的代表顏色：
		<span style='color:#686868;'>取消</span>、
		<span style='color:green;'>邀請進行中</span>、
		<span style='color:red;'>邀請約會成功</span>、
		<span style='color:#600030;'>申請約會成功</span>、
		<span style='color:#00CACA;'>申請中</span>
		</div>
	</div>
	
  </div>
  </div>
</div></div>
</div>
</sec:authorize>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
<!-- beg -->
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/fullcalendar/fullcalendar.min.css' />
<style>
.tooltip > .tooltip-inner {
    background-color: #73AD21; 
    color: #FFFFFF; 
    border: 1px solid green;
    padding: 10px;
    font-size: 11px;
}
.tooltip.top > .tooltip-arrow {
    border-top: 5px solid green;
}     
.tooltip.bottom > .tooltip-arrow {
    border-bottom: 5px solid blue;
}
.tooltip.left > .tooltip-arrow {
    border-left: 5px solid red;
}

.tooltip.right > .tooltip-arrow {
    border-right: 5px solid black;
}                 
</style>
<script src="${pageContext.request.contextPath}/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src='${pageContext.request.contextPath}/js/fullcalendar/moment.min.js'></script>
<script src='${pageContext.request.contextPath}/js/fullcalendar/fullcalendar.min.js'></script>
<script src='${pageContext.request.contextPath}/js/fullcalendar/lang/zh-tw.js'></script>
<script>
$(document).ready(function() {
	var date = new Date();   
	var d = date.getDate();   
	var m = date.getMonth();   
	var y = date.getFullYear(); 

    $('#calendarappoint').fullCalendar({
	   header: {   
		   left: 'prev,next today',   
		   center: 'title',   
		   right: 'month,agendaWeek'  //,agendaDay 
	   },
	   lang: 'zh-tw',
	    views: {
	        agendaWeek: {
	        	titleFormat: 'YYYY/MM/DD '
	        },
	        month: {
	        }
	    },
   		height: 'auto',
	    defaultView:'agendaWeek',
		firstDay: new Date().getDay(), 
		fixedWeekCount: false,
	    editable: false,   
	    weekMode: 'liquid',
	    allDaySlot:false,
	    slotDuration:'02:00:00',
	    slotLabelInterval :"04:00:00",
	    slotLabelFormat:'ahh(:mm)',
	    nowIndicator: true,
	    timeFormat:'H:mm',
	    eventLimit: 2,
	    events:'appointmentcaljson', // /1150',
		     eventClick: function(event) {
		         if (event.url) {
		             window.open(event.url);
		             return false;
		         }
		     },   
            eventMouseover: function(event, element) {
                $(this).tooltip({title:event.tooltip, html: true, container: "body", tooltipClass: "tooltip"});
                $(this).tooltip( "show");
            },
            eventMouseout: function(event, jsEvent, view) {
                 $(this).tooltip( "hide" );            	 
            },
            eventRender: function(calEvent, element, view) {
                $('.fc-month-button').click(function() {
                	$('#calendarappoint').fullCalendar('option',  {
                		firstDay: 1,
                		height: 'auto'
                	});
                });
                $('.fc-agendaWeek-button').click(function() {
                	$('#calendarappoint').fullCalendar('option',{
                		firstDay: new Date().getDay(),
                		height: 'auto'
                	});
                });           	 
            }
    });
    

});
</script>
<!-- end -->
</body>
</html>