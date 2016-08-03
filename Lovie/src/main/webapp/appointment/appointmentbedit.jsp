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
  <div style="color:red">會員:${loginmember.account}${loginmember.nickname}</div>
    <li><a href="${pageContext.request.contextPath}/appointments">一週約會通知</a></li>
    <li class="active"><a href="${pageContext.request.contextPath}/appointmentb">申請的約會(修改)</a></li>
    <li><a href="${pageContext.request.contextPath}/appointmenta">邀請的約會</a></li>
  </ul>
  <div class="tab-content">
  <div id="menu1" class="tab-pane fade in active">
<div class="row">
<div class="col-md-7 divleft">
  <div class="col-md-12" ><br></div>
  <div class="col-md-4"><img id="blah" style="border:5px solid #acd6ff;border-radius:15px;width:100%" src="${pageContext.request.contextPath}/photo/member/${oneAppointmentR.mId}"></div>
  <div class="col-md-8" ></div>
  <div class="col-md-8" ><b class="memberColumn">邀請者暱稱：</b>${oneAppointmentR.nickname}</div>
  <div class="col-md-8" ><b class="memberColumn">年齡：</b>${memberAge}歲</div>
  <div class="col-md-8" ><b class="memberColumn">性別：</b>${gender}</div>
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
	   <c:if test ="${oneAppointmentR.bstatus == 0}">
	      <div class="col-md-12" >
	      <textarea id="bcontenttxt" name="bcontenttxt">${oneAppointmentR.bcontent}</textarea>
	      </div>
	   </c:if>
	   <c:if test ="${oneAppointmentR.bstatus != 0}">
	      <div class="col-md-9 subleft contentdiv" >${oneAppointmentR.bcontent}
	      </div>
	   </c:if>
	 </div>

	 <div class="form-groupa">
	  <div class="col-md-3 subright" ><b class="memberColumn">申請狀態:</b></div>
	  <div class="col-md-9 subleft" >
	    <input type="hidden" id="appointmentid" value="${oneAppointmentR.id}" /> 
	    <input type="hidden" id="bstatus" value="${oneAppointmentR.bstatus}" /> 
	    <c:if test ="${oneAppointmentR.bstatus == 0}">0.尚未回應</c:if>
	    <c:if test ="${oneAppointmentR.bstatus == 1}">1.是</c:if>
	    <c:if test ="${oneAppointmentR.bstatus == 2}">2.否</c:if>
	    <c:if test ="${oneAppointmentR.bstatus == 7}">7.取消(申請者)</c:if>
	    <c:if test ="${oneAppointmentR.bstatus == 8}">8.取消(邀請者)</c:if>
	    <c:if test ="${oneAppointmentR.bstatus == 9}">9.取消(管理員)</c:if>
	  </div>
	 </div>
     <c:if test ="${oneAppointmentR.bstatus == 0 || oneAppointmentR.bstatus == 1}">
     <div class="form-groupa">
       <div class="col-md-3 subright" ><b class="memberColumn">取　　消:</b></div>
	   <div class="col-md-9 subleft" ><input type="checkbox" name="bcancel" id="bcancel"></div>
	 </div>
	 </c:if>
	 <div class="form-groupa col-md-offset-2 col-md-10">
	 <div class="btn-group" role="group" >
	      <button type="button" id="savebtn" class="btn btn-primary btn-sm" 
	      	  onClick="editsave();">存檔</button>
	      <button type="button" class="btn btn-default btn-sm" onClick="editcancel();">返回</button>
	 </div>
	 </div>
	 <div class="form-groupa col-md-12">
	   說明:
	   <ol style="margin-left:2px;font-size:12px;">
	     <li style="margin-right:-40px;">只有申請狀態為 [0.尚未回應] 才可修改內容</li>
	     <li style="margin-right:-40px;">只有申請狀態為 [0.尚未回應]或[1.是] 才可進行取消,在對方尚未拒絶或約會尚未結束勾選取消,可能會影響他人對您的評價!</li>
	   </ol>
	 </div>
   </form>
  </div>
   
</div>
</div>
  </div>
  </div>
</div></div>
<!--  </div>  -->
</sec:authorize>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
<script type="text/ecmascript"	src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" type="text/css" media="screen"	href="${pageContext.request.contextPath}/js/ckeditor/contents.css" />
<script>
$(document).ready(function() {
	var bstatus = $("#bstatus").val();
	if (bstatus == 0 || bstatus == 1)
	{   $("#savebtn").removeClass("nondisplaycomp").addClass("displaycomp");
	}else {
		$("#savebtn").removeClass("displaycomp").addClass("nondisplaycomp");
	}
		
	if (bstatus == 0)
	   CKEDITOR.replace('bcontenttxt', {toolbarStartupExpanded : false} );
});
</script>
<script>
function editcancel(){
		window.location.href = "${pageContext.request.contextPath}/appointmentb";
}
function editsave(){
    //申請狀態為 [0.尚未回應]
	//  upate appR.內容
    //勾取消
    // (1)申請狀態為 [0.尚未回應]
    //   appR 狀態改為 [7取消(申請者)]
    // (2)申請狀態為[1.是]
	//   appR 狀態改為 [7取消(申請者)]
    //   所有同一個appid 狀態改為 全改為[9取消(管理員)]
    //   app 狀態改為 [0.取消]
	var appointmentid = $("#appointmentid").val();
	var bstatus = $("#bstatus").val();
	var bcontent = null;
	var bcancel = null;
	if (bstatus == 0) {
 	   bcontent = CKEDITOR.instances.bcontenttxt.getData(); 
	   bcancel = $("#bcancel").prop("checked");
	}
	if (bstatus == 1) {
	   bcancel = $("#bcancel").prop("checked");
	}
	if (bstatus == 0 || (bstatus == 1 && bcancel == true)) {
		var result = window.confirm("確定進行存檔?");
		if (result) {
		$.ajax({
			url:"${pageContext.request.contextPath}/appointmentbedit/appointmentRUpdate",
			data:{"appointmentid":appointmentid,"bcontent":bcontent,"bcancel":bcancel,"bstatus":bstatus},
			type:"post",
			success:function(data){
				var res = $.parseJSON(data);
				if (res==true)
				{
					var result2 = window.confirm("存檔成功,是否返回查看申請的約會功能 ?");
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
		alert("不符合異動存檔條件,如要返回查看申請的約會功能,請按取消鈕");
	}
}
</script>
</body>
</html>