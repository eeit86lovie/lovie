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
.form-group {
    margin-bottom:8px;
}
.ragent0{
	color:red;
}
.ragent1{
	color:green;
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
<form class="form-horizontal" role="from" >

<div class="col-md-12">
  <ul class="nav nav-tabs nav-justified">
  <li><img src="${pageContext.request.contextPath}/image/icon/logo.png" style="width:90px;float:right;padding-right:20px;"></img>
  <!-- <div style="color:red">會員:${loginmember.account}${loginmember.nickname}</div> -->
  </li>
    <li><a href="${pageContext.request.contextPath}/appointments">一週約會通知</a></li>
    <li><a href="${pageContext.request.contextPath}/appointmentb">申請的約會</a></li>
    <li class="active"><a href="${pageContext.request.contextPath}/appointmenta">邀請的約會(新增)</a></li>
  </ul>
  <div class="tab-content">
  <div id="menu1" class="tab-pane fade in active">
<div class="row">
<div class="col-md-6 divleft">
  <div class="col-md-12" ><br></div>
  <div class="col-md-4"><img id="blah" style="border:5px solid #acd6ff;border-radius:15px;width:100%" src="${pageContext.request.contextPath}/photo/member/${loginmember.id}"></div>
  <div class="col-md-8" ></div>
  <div class="col-md-8" ><b class="memberColumn">邀請者暱稱：</b>${loginmember.nickname}</div>
  <div class="col-md-8" ><b class="memberColumn">年齡：</b>${loginmember.age}歲</div>
  <div class="col-md-8" ><b class="memberColumn">性別：</b>${gender}</div>
  <div class="col-md-8" ><b class="memberColumn">星座：</b>${loginmember.constellation}</div>
  <div class="col-md-8" ><b class="memberColumn">所在地：</b><span id="city" ><span>${loginmember.city}</span>  <span>${loginmember.district}</span></span></div>
  <div class="col-md-8" ><b class="memberColumn">許願：</b></div>
  <div class="col-md-8" >${showtimeData}</div>
  <div class="col-md-12" ><br /> </div>
</div>
<div class="col-md-6 divright" >
  <div class="col-md-12 divright" >
	<div class="col-md-12" ></div>
	 <div class="form-groupa">
	   <div class="col-md-2 subright" ><b class="memberColumn">邀請內容:</b></div>
	      <div class="col-md-10 subleft " >
	      <textarea id="acontenttxt" name="acontenttxt"></textarea>
	      </div>
	 </div>

	 <div class="form-groupa">
	  <div class="col-md-2 subright" ><b class="memberColumn">邀請狀態:</b></div>
	  <div class="col-md-10 subleft" >
	    <input type="hidden" id="showtimeid" value="${showtimeid}" /> 
	    1.進行
	  </div>
	 </div>
	 <div class="form-groupa col-md-10">
	 <div class="btn-group" role="group" >
	      <button type="button" id="savebtn" class="btn btn-primary" 
	      	  onClick="addsave();">新增</button>
	      <button type="button" class="btn btn-default" onClick="addcancel();">返回</button>
	 </div>
	 </div>
	 </div>
</div>
</div>
</div></div></div>
</form>
<!--  </div>  -->
</div>
</sec:authorize>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
<script type="text/ecmascript"	src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" type="text/css" media="screen"	href="${pageContext.request.contextPath}/js/ckeditor/contents.css" />
<script>
$(document).ready(function() {
    CKEDITOR.replace('acontenttxt', {toolbarStartupExpanded : false,height:130} );
});
</script>
<script>
function addcancel(){
		window.location.href = "${pageContext.request.contextPath}/new_appointmenta";
}
function addsave(){
	var showtimeid = $("#showtimeid").val();
	var acontent = CKEDITOR.instances.acontenttxt.getData(); 
	if (acontent.length > 0 ) {
		var result = window.confirm("確定進行存檔?");
		if (result) {
		$.ajax({
			url:"${pageContext.request.contextPath}/appointmentaadd/appointmentAAdd",
			data:{"showtimeid":showtimeid,"acontent":acontent},
			type:"post",
			success:function(data){
				var res = $.parseJSON(data);
				if (res > 0)
				{
					var result2 = window.confirm("新增成功,是否返回查看邀請的約會功能 ?");
					if (result2) {
						window.location.href = "${pageContext.request.contextPath}/appointmenta";
					} else {
						window.location.href = "${pageContext.request.contextPath}/appointmentaedit/"+res;
					}
				}else
				{
					alert("存檔失敗,請重新執行");
				}	
			}
		});
		}
	}else{
		alert("邀請內容不可空白,請重新輸入。");
	}
}
</script>
</body>
</html>