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
.hiddisplaycomp {
    visibility:hidden;
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
  <div style="color:red">會員:${loginmember.account}${loginmember.nickname}</div>
    <li><a href="${pageContext.request.contextPath}/appointments">一週約會通知</a></li>
    <li><a href="${pageContext.request.contextPath}/appointmentb">申請的約會</a></li>
    <li class="active"><a href="${pageContext.request.contextPath}/appointmenta">邀請的約會(修改)</a></li>
  </ul>
  <div class="tab-content">
  <div id="menu1" class="tab-pane fade in active">
<div class="row">
<div class="col-md-6 divleft">
  <div class="col-md-12" ><br></div>
  <div class="col-md-4"><img id="blah" style="border:5px solid #acd6ff;border-radius:15px;width:100%" src="${pageContext.request.contextPath}/photo/member/${oneAppointmentedit.mId}"></div>
  <div class="col-md-8" ></div>
  <div class="col-md-8" ><b class="memberColumn">邀請者暱稱：</b>${oneAppointmentedit.nickname}</div>
  <div class="col-md-8" ><b class="memberColumn">年齡：</b>${oneAppointmentedit.age}歲</div>
  <div class="col-md-8" ><b class="memberColumn">性別：</b>${oneAppointmentedit.gendertxt}</div>
  <div class="col-md-8" ><b class="memberColumn">星座：</b>${oneAppointmentedit.constellation}</div>
  <div class="col-md-8" ><b class="memberColumn">所在地：</b><span id="city" ><span>${oneAppointmentedit.city}</span>  <span>${oneAppointmentedit.district}</span></span></div>
  <div class="col-md-8" ><b class="memberColumn">許願：</b></div>
  <div class="col-md-8" >${oneAppointmentedit.showtimeData}</div>
  <div class="col-md-12" ><br /> </div>
</div>
<div class="col-md-6 divright" >
  <div class="col-md-12 divright" >
   	 <c:if test ="${oneAppointmentedit.astatus == 1}">
		<div class="col-md-12" ></div>
	 </c:if>
   	 <c:if test ="${oneAppointmentedit.astatus != 1}">
		<div class="col-md-12" ><br /></div>
	 </c:if>
	 <div class="form-groupa">
	   <div class="col-md-2 subright" ><b class="memberColumn">邀請內容:</b></div>
	   <c:if test ="${oneAppointmentedit.astatus == 1}">
	      <div class="col-md-10 subleft " >
	      <textarea id="acontenttxt" name="acontenttxt">${oneAppointmentedit.acontent}</textarea>
	      </div>
	   </c:if>
	   <c:if test ="${oneAppointmentedit.astatus != 1}">
	      <div class="col-md-10 subleft contentdiv" >${oneAppointmentedit.acontent}
	      </div>
	   </c:if>
	 </div>

	 <div class="form-groupa">
	  <div class="col-md-2 subright" ><b class="memberColumn">邀請狀態:</b></div>
	  <div class="col-md-10 subleft" >
	    <input type="hidden" id="appointmentid" value="${oneAppointmentedit.id}" /> 
	    <input type="hidden" id="astatus" value="${oneAppointmentedit.astatus}" /> 
	    <c:if test ="${oneAppointmentedit.astatus == 0}">0.取消</c:if>
	    <c:if test ="${oneAppointmentedit.astatus == 1}">1.進行</c:if>
	    <c:if test ="${oneAppointmentedit.astatus == 2}">2.成功</c:if>
	    <c:if test ="${oneAppointmentedit.astatus == 9}">9.封存</c:if>
	  </div>
	 </div>
     <c:if test ="${oneAppointmentedit.astatus == 1 || oneAppointmentedit.astatus == 2}">
     <div class="form-groupa">
       <div class="col-md-2 subright" ><b class="memberColumn">取　　消:</b></div>
	   <div class="col-md-10 subleft" ><input type="checkbox" name="acancel" id="acancel" onClick="cancelclk();"></div>
	 </div>
	 </c:if>
	 <div class="form-groupa col-md-12">
	         說明：1.只有申請狀態為 [1.進行] 才可修改內容<br />
	         　　　2.只有申請狀態為 [1.進行] 或 [2.成功] 才可進行取消
	 </div>
	 <div class="form-groupa col-md-10">
	 <div class="btn-group" role="group" >
	      <button type="button" id="savebtn" class="btn btn-primary btn-sm" 
	      	  onClick="editsave();">存檔</button>
	      <button type="button" class="btn btn-default btn-sm" onClick="editcancel();">返回</button>
	 </div>
	 </div>
	 </div>
</div>
</div>
<div class="row">
	<!-- beg table-->
	<div class="dataTable_wrapper table-responsive">
	<table class="table table-striped table-bordered table-hover"
			id="appointmentrtable">
	<c:set var="rcnt" value="0"/>
	<thead>
		<tr>
			<th></th>
			<th>申請狀態</th>
			<th>申請者</th>
			<th>年齡</th>
			<th>性別</th>
			<th>星座</th>
			<th>所在地</th>
			<th>留言</th>
		</tr>
	</thead>
	<tbody id="tbody">
	<c:forEach var="appointmentr" items="${oneAppointmentedit.appointmentareditBeans}"
			varStatus="vs">
		<c:set var="rcnt" value="${vs.count}"/>
		<tr id="rsel${appointmentr.requestMemberId}">
		<td>
		    <c:if test ="${(appointmentr.bstatus == 0 || appointmentr.bstatus == 1 || appointmentr.bstatus == 2) && oneAppointmentedit.astatus == 1}">
		    <input type="radio" name="radiomid" value="${appointmentr.requestMemberId}">
		    </c:if>
		</td>					
		<td>
		    <c:if test ="${appointmentr.bstatus == 0}">0.尚未回應</c:if>
		    <c:if test ="${appointmentr.bstatus == 1}">1.是</c:if>
		    <c:if test ="${appointmentr.bstatus == 2}">2.否</c:if>
		    <c:if test ="${appointmentr.bstatus == 7}">7.取消(申請者)</c:if>
		    <c:if test ="${appointmentr.bstatus == 8}">8.取消(邀請者)</c:if>
		    <c:if test ="${appointmentr.bstatus == 9}">9.取消(管理員)</c:if>
		</td>
		<c:if test ="${appointmentr.gender == 0}">
			<td class="ragent0" >${appointmentr.nickname}　
			<a href="${pageContext.request.contextPath}/member/profile/${appointmentr.requestMemberId}" target="_blank" >
			  <img src="${pageContext.request.contextPath}/photo/member/${appointmentr.requestMemberId}" style="height:50px;border:1px green dashed;" />
			</a>
			</td>
		</c:if>
		<c:if test ="${appointmentr.gender == 1}">
			<td class="ragent1" >${appointmentr.nickname}　
			<a href="${pageContext.request.contextPath}/member/profile/${appointmentr.requestMemberId}" target="_blank" >
			  <img src="${pageContext.request.contextPath}/photo/member/${appointmentr.requestMemberId}" style="height:50px;border:1px green dashed;" />
			</a>
			</td>
		</c:if>		
		<c:if test ="${appointmentr.gender != 0 && appointmentr.gender != 1}">
			<td >${appointmentr.nickname}　
			<a href="${pageContext.request.contextPath}/member/profile/${appointmentr.requestMemberId}" target="_blank" >
			  <img src="${pageContext.request.contextPath}/photo/member/${appointmentr.requestMemberId}" style="height:50px;border:1px green dashed;" />
			</a>
			</td>
		</c:if>			
		<td>${appointmentr.age}</td>
		<td>${appointmentr.gendertxt}</td>
		<td>${appointmentr.constellation}</td>
		<td>${appointmentr.city} ${appointmentr.district}</td>
		<td>${appointmentr.bcontent}</td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
	<tr>
	<td colspan="8">申請人數: ${rcnt} 人</td>
	</tr>
	</tfoot>
	</table>
	</div>
	<!-- end table -->	
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
	var astatus = $("#astatus").val();
	if (astatus == 1 || astatus == 2)
	{   $("#savebtn").removeClass("nondisplaycomp").addClass("displaycomp");
	}else {
		$("#savebtn").removeClass("displaycomp").addClass("nondisplaycomp");
	}
		
	if (astatus == 1)
	   CKEDITOR.replace('acontenttxt', {toolbarStartupExpanded : false} );
});
</script>
<script>
function cancelclk(){
	$("input[name='radiomid']").toggleClass("hiddisplaycomp");
}
function editcancel(){
		window.location.href = "${pageContext.request.contextPath}/appointmenta";
}
function editsave(){
	//說明：1.只有申請狀態為 [1.進行] 才可修改內容<br />
	//    2.只有申請狀態為 [1.進行] 或 [2.成功] 才可進行取消
    //1.申請狀態為 [1:進行] && 沒有勾取消
	//  (a)都沒有人申請,則只異動內容(-1),
	//  (b)有人申請,
	//    update app  內容,接受對像acceptedMemberId,時間acceptedTime,status=2.成功
    //    update appr status=2否  where appointmentID= ? and status in (0,1)
    //    update appr status=1是  where appointmentID= ? and requestMemberId= ? and status = 0
    //2.(申請狀態為 [1:進行]或[2.成功]) && 勾取消
    //  update app 狀態改為 [0.取消]
    //  update appr status=8取消(邀請者)  where appointmentID= ? and status in (0,1,2)

	var appointmentid = $("#appointmentid").val();
	var astatus = $("#astatus").val();
	var acontent = null;
	var acancel = null;
	var radiomid = null;
	
	if (astatus == 1) {
 	   acontent = CKEDITOR.instances.acontenttxt.getData(); 
	}
	if (astatus == 1 || astatus == 2) {
	   acancel = $("#acancel").prop("checked");
	}
	if (astatus == 1 && acancel == false) {
		radiomid = $('input[name="radiomid"]:checked').val();
	   if (radiomid == null)
	   {   radiomid = -1
	   }
	}
	if (astatus == 1 || (astatus == 2 && acancel == true)) {
		var result = window.confirm("確定進行存檔?");
		if (result) {
			
		$.ajax({
			url:"${pageContext.request.contextPath}/appointmentaedit/appointmentAUpdate",
			data:{"appointmentid":appointmentid,"acontent":acontent,"acancel":acancel,"astatus":astatus,"radiomid":radiomid},
			type:"post",
			success:function(data){
				var res = $.parseJSON(data);
				if (res==true)
				{
					var result2 = window.confirm("存檔成功,是否返回查看申請的約會功能 ?");
					if (result2) {
						window.location.href = "${pageContext.request.contextPath}/appointmenta";
					} else {
						window.location.href = "${pageContext.request.contextPath}/appointmentaedit/"+$("#appointmentid").val();
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