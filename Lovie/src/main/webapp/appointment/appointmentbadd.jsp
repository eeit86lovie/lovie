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
.divleft {
	border: #CC0000 1px dotted;
	border-radius: 10px;
	margin-top: 5px;
	margin-bottom: 5px;
	margin-left: -5px;
	margin-right: 5px;
	line-height :1.6;
}
.divright {
	margin-left: -1px;
	margin-right: -5px;
	padding-left: 0px;
    padding-right: 0px;
	line-height :1.4;
}
.memberColumn {
	color: #CC6600
}
.subright {
	padding-right:2px;
	margin-bottom: 0px;
}
.subleft {
	padding-left:2px;
}
.contentdiv {
	border:2px groove #E0E0E0;
	padding: 2px;
	height:120px;
	overflow:auto;
	box-shadow: 3px 3px 3px #E0E0E0;
}
.nondisplaycomp {
    display:none;
}
.displaycomp {
    display:inline;
}
.form-group {
    margin-bottom:8px;
}
.myButton {
	-moz-box-shadow: 3px 5px 19px -3px #8a2a21;
	-webkit-box-shadow: 3px 5px 19px -3px #8a2a21;
	box-shadow: 3px 5px 19px -3px #8a2a21;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #c62d1f), color-stop(1, #f24437));
	background:-moz-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background:-webkit-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background:-o-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background:-ms-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background:linear-gradient(to bottom, #c62d1f 5%, #f24437 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#c62d1f', endColorstr='#f24437',GradientType=0);
	background-color:#c62d1f;
	-moz-border-radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	border:2px solid #d02718;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:12px;
	font-weight:bold;
	padding:5px 4px;
	text-decoration:none;
	text-shadow:1px 2px 1px #810e05;
}
.myButton:visited {
	color:#ffffff;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #f24437), color-stop(1, #c62d1f));
	background:-moz-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background:-webkit-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background:-o-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background:-ms-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background:linear-gradient(to bottom, #f24437 5%, #c62d1f 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#f24437', endColorstr='#c62d1f',GradientType=0);
	background-color:#f24437;
	color:#f0f0e0;
}
.myButton:active {
	position:relative;
	top:1px;
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
<!--  <div class="row"> -->
<div class="col-md-12">
  <ul class="nav nav-tabs nav-justified">
  <li><img src="${pageContext.request.contextPath}/image/icon/logo.png" style="width:90px;float:right;padding-right:20px;"></img>
  <!-- <div style="color:red">會員:${loginmember.account}${loginmember.nickname}</div> -->
  </li>
    <li><a href="${pageContext.request.contextPath}/appointments">一週約會通知</a></li>
    <li class="active"><a href="${pageContext.request.contextPath}/appointmentb">申請的約會(新增)</a></li>
    <li><a href="${pageContext.request.contextPath}/appointmenta">邀請的約會</a></li>
  </ul>
  <div class="tab-content">
  <div id="menu1" class="tab-pane fade in active">
<div class="row">
<div class="col-md-7 divleft">
  <div class="col-md-12" ><br></div>
  <div class="col-md-4"><img id="blah" style="border:5px solid #acd6ff;border-radius:15px;width:100%" src="${pageContext.request.contextPath}/photo/member/${oneAppointmentR.mId}"></div>
  <div class="col-md-8" ></div>
  <div class="col-md-8" >
  	<span class='glyphicon glyphicon-heart-empty' style='color:red;'></span>
  	<b class='memberColumn'> 已申請：</b>${oneAppointmentR.requestcnt}<br />
  </div>
  <div class="col-md-8" ><b class="memberColumn">邀請者暱稱：</b>${oneAppointmentR.nickname}</div>
  <div class="col-md-8" ><b class="memberColumn">年齡：</b>${oneAppointmentR.age}歲</div>
  <div class="col-md-8" ><b class="memberColumn">性別：</b>${oneAppointmentR.gendertxt}</div>
  <div class="col-md-8" ><b class="memberColumn">星座：</b>${oneAppointmentR.constellation}</div>
  <div class="col-md-8" ><b class="memberColumn">所在地：</b><span id="city" ><span>${oneAppointmentR.city}</span>  <span>${oneAppointmentR.district}</span></span></div>
  <div class="col-md-12" > </div>
  <div class="col-md-2 subright" ><b class="memberColumn">許　　願:</b></div>
  <div class="col-md-10 subleft" >${oneAppointmentR.showtimeData}</div>
  <div class="col-md-2 subright" ><b class="memberColumn">邀請內容:</b></div>
  <div class="col-md-10 subleft contentdiv" >${oneAppointmentR.acontent}</div>
  <div class="col-md-12" ><br></div>
</div>
<div class="col-md-5 divright" >
  <div class="col-md-12 divright" >
   <form class="form-horizontal" role="from" >
     <div class="col-md-12" ><br /> </div>
     <div class="form-groupa">
       <div class="col-md-3 subright" ><b class="memberColumn">申 請 者:</b></div>
	   <div class="col-md-9 subleft" >${loginmember.nickname}</div>
	 </div>

	 <div class="form-groupa">
	   <div class="col-md-3 subright" ><b class="memberColumn">內　　容:</b></div><br/>
	      <div class="col-md-12" >
	      <textarea id="bcontenttxt" name="bcontenttxt"></textarea>
	      </div>
	 </div>

	 <div class="form-groupa">
	  <div class="col-md-3 subright" ><br /></div>
	  <div class="col-md-9 subleft" >
	    <input type="hidden" id="appointmentid" value="${oneAppointmentR.id}" /> 
	    <input type="hidden" id="bstatus" value="0" />
	  </div>
	 </div>
	 <div class="form-groupa col-md-10">
	 <div class="btn-group" role="group" >
	      <button type="button" id="savebtn" class="btn btn-primary " 
	      	  onClick="addsave();">存檔</button>
	      <button type="button" class="btn btn-default " onClick="addcancel();">返回申請的約會</button>
	 </div>
	 </div>
   </form>
  </div>
   
</div>
</div>
</div></div>
</div></div>
<!--  </div>  -->
</sec:authorize>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
<script type="text/ecmascript"	src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" type="text/css" media="screen"	href="${pageContext.request.contextPath}/js/ckeditor/contents.css" />
<script>
$(document).ready(function() {
	   CKEDITOR.replace('bcontenttxt', {toolbarStartupExpanded : false,height:150} );
});
</script>
<script>
function addcancel(){
		window.location.href = "${pageContext.request.contextPath}/appointmentb";
}
function addsave(){
    //申請狀態為 [0.尚未回應]
	var appointmentid = $("#appointmentid").val();
	var bstatus = 0;
	var bcontent = CKEDITOR.instances.bcontenttxt.getData(); 
	if (bcontent.length > 0 ) {
		var result = window.confirm("確定進行存檔?");
		if (result) {
		$.ajax({
			url:"${pageContext.request.contextPath}/appointmentbadd/appointmentRAdd",
			data:{"appointmentid":appointmentid,"bcontent":bcontent},
			type:"post",
			success:function(data){
				var res = $.parseJSON(data);
				if (res > 0)
				{
					var result2 = window.confirm("新增成功,是否返回查看申請的約會功能 ?");
					if (result2) {
						window.location.href = "${pageContext.request.contextPath}/appointmentb";
					} else {
						window.location.href = "${pageContext.request.contextPath}/appointmentbedit/"+$("#appointmentid").val();
					}
				}else
				{
					alert("存檔失敗,請重新執行");
				}	
			}
		});
		}
	}else{
		alert("申請約會留言內容不可空白,請重新輸入。");
	}
}
</script>
</body>
</html>