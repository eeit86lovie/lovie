<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
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
.form-group {
    margin-bottom: 6px;
}
.clearselspan {
   line-height:30px;
   //color:green;
}
.movie_intro
{
   border: #E0E0E0 1px dashed; 
   height:200px;
   overflow: auto; 
   //margin-left: 5px;
   //margin-right: 5px;   
}
.movie_showtime
{
   //height:180px;
   //margin-left: 5px;
   //margin-right: 5px;   
}
.movie_showtime_inside
{
   border: #BBB 2px dotted; 
   height: 180px; 
   overflow: auto; 
   padding-left: 1px;
   font-size:15px;
}
.movie_showtime_inside a:hover 
{ 
   text-decoration:none;
} 
.nondisplaycomp {
    display:none;
}
.displaycomp {
    display:inline;
}
.memberColumn {
	color: black;
}
.oneappdiv-o{
  display:inline-block ;
  vertical-align: top;
  background:white;
  border:1px solid #acd6ff;
  border-radius:5px;
  padding:5px;
  margin:5px;
  width:298px;
  height:167px;
  box-shadow: 0 5px 8px 0 rgba(0,0,0,0.2);
  transition: .15s linear;
  overflow:hidden;
}
.oneappdiv-i{
  text-decoration:none;
  background:#ebebe0;
  display:block;
  border-radius:5px;
  height:100%;
}
.oneappdiv-ic0{
background:#ffe6ee;
}
.oneappdiv-ic1{
background:#ceebfd;//#e7f5fe;
}
.oneappdiv-o:hover {
  border:1px solid #bcf6ff;
  background:#f3f3f3;
  box-shadow: 5px 6px 7px rgba(33,33,33,.7);
}
.memimg{
  float:left;
  border:0px solid #acd6ff;
  border-radius:6px;
  width:30%;
  margin:3px;
}
div.panel-body {
  padding-right: 0px;
  padding-left: 0px;
}
</style>
<title>申請新約會</title>
</head>
<body>
<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
<sec:authorize access="!hasRole('USER')">
	<div style="color:red;font-size:1.2em;">　請先登入，一般會員以上等級才可執行申請新約會功能.</div>
</sec:authorize>
<sec:authorize access="hasRole('USER')"> 
<!-- beg sec-->	
<div class="container">

<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
		步驟1:輸入查詢條件:
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
      <!-- 1查詢條件 beg -->
	  <form class="form-horizontal" role="form" name="form1" id="form1" action="#">
	  <fieldset>
		<div class="form-group">
		    <label class="control-label col-md-2" for="city" style="margin-right: 0px;">城　　市：</label>
		    <div class="col-md-9"> 
	    		<select name="city" id="city" class="form-control" multiple="multiple">
					<c:forEach var="cityVO" items="${citynames}">
						<option value="${cityVO}">${cityVO}</option>
   					</c:forEach>
				</select>
		    </div>	
		    <span class="glyphicon glyphicon-remove-sign clearselspan" aria-hidden="true" onclick="clearinput(1);"></span>
		</div>
		<div class="form-group">
		    <label class="control-label col-md-2" for="theaterName" style="margin-right: 0px;">戲院名稱：</label>
		    <div class="col-md-9"> 
		    	<select name="theaterName" id="theaterName" class="form-control" >
					<option value=""  class="form-control"></option>
					<c:forEach var="theaterVO" items="${theaternames}">
						<option value="${theaterVO}">${theaterVO}</option>
   					</c:forEach>
				</select>
		    </div>
		    <span class="glyphicon glyphicon-remove-sign clearselspan" aria-hidden="true" onclick="clearinput(2);"></span>
		</div>
		<div class="form-group">
		    <label class="control-label col-md-2" for="genreId" style="margin-right: 0px;">電影類型：</label>
		    <div class="col-md-9"> 
	    		<select name="genreId" id="genreId"  class="form-control" multiple="multiple">
					<c:forEach var="genreVO" items="${genrenames}">
						<option value="${genreVO.id}">${genreVO.name}</option>
   					</c:forEach>
				</select>
		    </div>		 
		    <span class="glyphicon glyphicon-remove-sign clearselspan" aria-hidden="true" onclick="clearinput(3);"></span>
		</div>
		<div class="form-group">
		    <label class="control-label col-md-2" for="movieName" style="margin-right: 0px;">電影名稱：</label>
		    <div class="col-md-9"> 
		    	<select name="movieName" id="movieName" class="form-control" >
					<option value=""  class="form-control"></option>
					<c:forEach var="movieVO" items="${movienames}">
						<option value="${movieVO}">${movieVO}</option>
   					</c:forEach>
				</select>
		    </div>	
		    <span class="glyphicon glyphicon-remove-sign clearselspan" aria-hidden="true" onclick="clearinput(4);"></span>
		</div>
		<div class="form-group">
		    <label class="control-label col-md-2" for="showtimeDatebeg" style="margin-right: 0px;">放映日期：</label>
		    <div class="col-md-4"> 
		    	<input type="text" class="form-control" id="showtimeDatebeg" name="showtimeDatebeg" placeholder="請選擇放映起日" readonly>
		    </div>
		    <div class="col-md-1" style="text-align:center;line-height:29px;"><span >～</span></div>
		    <div class="col-md-4"> 
		    	<input type="text" class="form-control" id="showtimeDateend" name="showtimeDateend" placeholder="請選擇放映迄日" readonly>
		    </div>
		    <span class="glyphicon glyphicon-remove-sign clearselspan" aria-hidden="true" onclick="clearinput(5);"></span>
	    </div>
		<div class="form-group"> 
		  <div class="col-md-offset-2 col-md-9">
			  <div class="btn-group" role="group" aria-label="...">
		      <button type="button" class="btn btn-warning " 
			      	onClick="formsubmit();">查询</button>
		      <button type="reset" class="btn btn-default" onClick="formreset();">重設</button>
			  </div>
		</div></div>
	  </fieldset>
	  </form>
      <!-- 1查詢條件 end -->
      </div>
    </div>
  </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
		步驟2:選擇電影時刻表:
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
      <!-- 2 showtime beg -->
      <img src="${pageContext.request.contextPath}/image/ajax-loader.gif" id="ajax-loader" class="nondisplaycomp" />
	  <div id="movieshowtime">
        	目前沒有符合條件的電影,請重新查詢。
      </div> 
      <!-- 2 showtime end -->
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
		步驟3:選擇約會:
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body">
      <!-- 3 appointmentr beg -->
      <img src="${pageContext.request.contextPath}/image/ajax-loader.gif" id="ajax-loader2" class="nondisplaycomp" />
	  <div id="appointmentr">
        	  目前沒有符合條件的約會,請重新查詢 ,或 新增邀請的約會(直接點選電影時刻)。 
      </div> 
      <!-- 3 appointmentr end -->
      </div>
    </div>
  </div>  
</div>
<!-- end sec-->
</sec:authorize>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
<!-- beg script -->
<script src='${pageContext.request.contextPath}/js/multiselect/select2.js'></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/multiselect/select2.css" type="text/css"/>

<!--  為了用 datapicker..才引用的js -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

<script>

var appointmentrdiv;
var appointmentrlist;
var appointdivstyle=1;

$(function () {
	appointmentrdiv = $("#appointmentr");
	appointmentrlist = [];
})

function clearinput(sel) {
	switch(sel)
	{  case 1:
			$("#city").val('').trigger('change'); break; 
	   case 2:
			$("#theaterName").val('').trigger('change'); break; 
	   case 3:
			$("#genreId").val('').trigger('change'); break; 
	   case 4:
			$("#movieName").val('').trigger('change'); break; 
	   case 5:
			$("#showtimeDatebeg").val(""); 
			$("#showtimeDateend").val(""); 
			break; 
	}
}

function formreset() {
	$("#city").val('').trigger('change');
	$("#theaterName").val('').trigger('change');
	$("#genreId").val('').trigger('change');
	$("#movieName").val('').trigger('change');
	$("#showtimeDatebeg").val(""); 
	$("#showtimeDateend").val(""); 
}

function formsubmit() {
	var showtimeDatebeg = $("#showtimeDatebeg").val();
	var showtimeDateend = $("#showtimeDateend").val();

	if ((showtimeDatebeg != ''  && showtimeDateend != '')
		&& (showtimeDatebeg > showtimeDateend)) 
	{
		alert("放映起日不可大於放映迄日,請重新選擇.");
		return;
	}	
	var data_to_send = $("#form1").serialize();
	
	$.ajax({
		url : "new_appointmoviea_json",
		data:data_to_send,
		type:"post",
		beforeSend : function(){
			var movieshowtime = $("#movieshowtime");
			movieshowtime.empty();
			var appointmentr = appointmentrdiv;
			appointmentr.empty();
			$("#ajax-loader").removeClass("nondisplaycomp").addClass("displaycomp");
			$("#ajax-loader2").removeClass("nondisplaycomp").addClass("displaycomp");
			$("#collapseTwo").addClass('in');
		},
		complete: function(){
			$("#ajax-loader").removeClass("displaycomp").addClass("nondisplaycomp");
		},
		success : function(data) {
		if (data != null) {
				//var result = JSON.parse(data);
				var result =data;
				var movieshowtime = $("#movieshowtime");
				var appointmentr = appointmentrdiv;
				//console.log(movieshowtime);
				if (result.length > 0) {
					//movieshowtime.empty();
				  $("<form class='form-horizontal' role='form' name='form2' id='form2' action='#'>" +
  				  "<fieldset id='fieldset2'><button type='button' class='btn btn-danger '" +
				  "    	onClick='form2submit();' style='margin-bottom: 6px;' >查询約會(依電影時刻表)</button>").appendTo(movieshowtime);
				for (var i = 0; i < result.length; i++) {
					var item = result[i];
				//**one movie template beg
				    var drow = document.createElement('div');
				    //$(drow).addClass("row").appendTo(movieshowtime); //row div
				    $(drow).addClass("row").appendTo($("#fieldset2")); //row div
				    var drow_c1 = document.createElement('div');
				    $(drow_c1).addClass("col-md-2").appendTo(drow); //row div_col-2
				    $("<img src=${pageContext.request.contextPath }/photo/movie/"+item.id+" style='height:200px;'>").appendTo(drow_c1);				
				    var drow_c2 = document.createElement('div');
				    $(drow_c2).addClass("col-md-5").appendTo(drow); //row div_col-5
				    $(drow_c2).addClass("movie_intro");
				    $("<p><img src='${pageContext.request.contextPath }/image/movie/"+item.rank+".png' width='40'	></p>").appendTo(drow_c2);				
				    $("<b style='font-size: 13px;'>片名："+item.name+"</b>").appendTo(drow_c2);				
				    $("<p>上映時間:"+item.startTime+"</p>").appendTo(drow_c2);				
				    $("<p>類型:"+item.genrelist+"</p>").appendTo(drow_c2);				
				    $("<p align='justify'>簡介:<br>"+item.intro+"</p>").appendTo(drow_c2);				
				    var drow_c3 = document.createElement('div');
				    $(drow_c3).addClass("col-md-5").appendTo(drow); //row div_col-5
				    $(drow_c3).addClass("movie_showtime");
				    $("<h3 style='margin:1px;'>電影時刻表</h3>").appendTo(drow_c3);
				    var drow_c3_1 = document.createElement('div');
				    $(drow_c3_1).addClass("movie_showtime_inside").appendTo(drow_c3); 
				    var item_s =  item.showtimeBeans;
					for (var j = 0; j < item_s.length; j++) {
						var item_s_i = item_s[j];
						$("<p><input type='checkbox' name='showtimechk' id='showtimechk"+item_s_i.id+"' value='"+item_s_i.id+"' />　"+
						  "<a href='${pageContext.request.contextPath }/appointmentaadd/"+item_s_i.id+"'>"+
							item_s_i.theaterName+"　"+item_s_i.showtimeDate+"　"+item_s_i.showtimeTime+"</a></p>").appendTo(drow_c3_1);
					}
				//**one movie template end	
				}
			    	$("<button type='button' class='btn btn-danger' onClick='form2submit();'>查询約會(依電影時刻表)</button>" ).appendTo($("#fieldset2")); //row div
					$("#ajax-loader").removeClass("displaycomp").addClass("nondisplaycomp");
					$("#collapseOne").removeClass('in');
				 	//alert("查詢完成.....");
				 	form2submit();
				} else {
					$("#ajax-loader").removeClass("displaycomp").addClass("nondisplaycomp");
					movieshowtime.text("目前沒有符合條件的電影,請重新查詢。");
					appointmentr.text("目前沒有符合條件的約會,請重新查詢 ,或 新增邀請的約會(直接點選電影時刻)。");
				 	alert("沒有符合條件的電影,請重新查詢。");
				}
				//$("#collapseTwo").addClass('in');
		}else{
			movieshowtime.text("請重新查詢。");
			appointmentr.text("請重新查詢。");
			alert("請重新查詢。");
		}
		}
	});
}

function form2submit() {
	var showtimechk = [];
	$('input[name="showtimechk"]:checked').each(function() {
		showtimechk.push(this.value);
	});
	if (showtimechk=="")
	{
		$('input[name="showtimechk"]').each(function() {
			showtimechk.push(this.value);
		});
	}	
	if (showtimechk=="")
	{
		alert("請先查詢電影時刻表後,再執行查詢約會功能");
	}else {
		$.ajax({
			url : "new_appointment_json",
			data:{showtimechk:showtimechk.toString()},
			type:"post",
			beforeSend : function(){
				var appointmentr = appointmentrdiv;
				appointmentr.empty();
				$("#ajax-loader2").removeClass("nondisplaycomp").addClass("displaycomp");
				$("#collapseThree").addClass('in');
			},
			complete: function(){
				$("#ajax-loader2").removeClass("displaycomp").addClass("nondisplaycomp");
			},
			success : function(data) {
			if (data != null) {
				//var appointmentrlist = JSON.parse(data);
				var appointmentr = appointmentrdiv;
				appointmentrlist = data;
				console.log(appointmentrlist.length);
  				if (appointmentrlist.length > 0) {
					appointdiv();
  				} else {
					appointmentr.text("目前沒有符合條件的約會,請重新查詢 ,或 新增邀請的約會(直接點選電影時刻)。");
				 	alert("沒有符合條件的約會,請重新查詢 ,或 新增邀請的約會(直接點選電影時刻)。");  					
  				}
			}else{
				appointmentr.text("請重新查詢。");
				alert("請重新查詢。");
			}
			} //end success
		});  //end $.ajax({
	} //end if (showtimechk=="")
} //end form2submit()

function appointdiv() {
  if (appointmentrlist != "") {
	if (appointdivstyle == 1){ 
		var frag = $(document.createDocumentFragment());
		$.each(appointmentrlist,function(idx,oneAppoint){
			//**one appoint template beg
		    var oneapp_div = document.createElement('div');
		    $(oneapp_div).addClass("col-md-4 oneappdiv-o").appendTo(frag); 
		    var oneapp_div_i = document.createElement('div');
		    $(oneapp_div_i).addClass("col-md-12 oneappdiv-i").appendTo(oneapp_div);
		    if (oneAppoint.gender == 0) {
		    	$(oneapp_div_i).addClass("oneappdiv-ic0");
		    }else if (oneAppoint.gender == 1) {
		    	$(oneapp_div_i).addClass("oneappdiv-ic1");
		    }
		    $("<a href='${pageContext.request.contextPath }/appointmentbadd/"+oneAppoint.id+"'>"+
			  "<img class='memimg' src='${pageContext.request.contextPath}/photo/member/"+oneAppoint.memberId+"' /></a>").appendTo(oneapp_div_i);
		    $("<span class='glyphicon glyphicon-heart-empty' style='color:red;'></span>").appendTo(oneapp_div_i);
		    $("<b class='memberColumn'> 已申請：</b>"+oneAppoint.requestcnt+"<br />").appendTo(oneapp_div_i);
		    $("<b class='memberColumn'>邀請者：</b>"+oneAppoint.nickname+"<br />").appendTo(oneapp_div_i);
		    $("<b class='memberColumn'>年齡：</b>"+oneAppoint.age+"歲　　<b class='memberColumn'>性別：</b>"+oneAppoint.gendertxt+"<br />").appendTo(oneapp_div_i);
		    $("<b class='memberColumn'>許願：</b>"+oneAppoint.showtimeData+"<br />").appendTo(oneapp_div_i);
		    $("<b class='memberColumn'>內容：</b>"+oneAppoint.acontent+"<br />").appendTo(oneapp_div_i);
		    //**one appoint template end
			/*
		      <!-- one div beg -->
			  <div class="col-md-4 oneappdiv-o"  >
			  <div class="col-md-12 oneappdiv-i" id="app1" >
			  <a href='${pageContext.request.contextPath }/appointmentbadd/28'>
			  <img id="blah" style="float:left;border:0px solid #acd6ff;border-radius:6px;width:30%;margin:3px;" src="${pageContext.request.contextPath}/photo/member/28" xx="${oneAppointmentedit.memberId}">
			  </a>
			  <b class="memberColumn">已申請：</b>${oneAppointmentedit.requestcnt}　<br />
			  <b class="memberColumn">邀請者暱稱：</b>${oneAppointmentedit.nickname}　　<br />
			  <b class="memberColumn">年齡：</b>${oneAppointmentedit.age}歲　　<b class="memberColumn">性別：</b>${oneAppointmentedit.gendertxt}<br />
			  <b class="memberColumn">許願：</b>
			  ${oneAppointmentedit.showtimeData}<br />
			  <b class="memberColumn">內容：</b>
			  ${oneAppointmentedit.acontent}<br />
			  </div></div>
			  <!-- one div end --> 
			*/			
		});
		$(frag).appendTo(appointmentrdiv);
	}else if (appointdivstyle == 2) {
		
	}else if (appointdivstyle == 3) {
		
	}
  } else {
  	appointmentrdiv.text("目前沒有符合條件的約會,請重新查詢 ,或 新增邀請的約會(直接點選電影時刻)。");
  } // end (appointmentrlist == "")
}
</script>

<script type="text/javascript">
     $(function () {
		 $('#city').select2({
			 placeholder: '請選擇城市'
		 });
		 $('#theaterName').select2({
			 placeholder: '請選擇戲院名稱',
			 allowClear: true
		 });
		 $('#genreId').select2({
			 placeholder: '請選擇劇情類型'
		 });
		 $('#movieName').select2({
			 placeholder: '請選擇電影名稱',
			 allowClear: true
		 });
         $('#showtimeDatebeg').datepicker({ dateFormat: "yy-mm-dd" });
         $('#showtimeDateend').datepicker({ dateFormat: "yy-mm-dd" });
     });
</script>
<!-- end script -->
</body>
</html>