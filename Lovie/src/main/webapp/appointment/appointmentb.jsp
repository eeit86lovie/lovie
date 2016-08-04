<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<style>
.ui-search-table .columns {
    margin-left: 0px; 
    margin-top: 0px; 
}    
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
	font-size:13px;
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
<div class="row"><div class="col-md-12">
  <ul class="nav nav-tabs nav-justified">
    <li> 
  <!--<img src="${pageContext.request.contextPath}/image/icon/logo.png" style="width:90px;float:right;padding-right:20px;"></img>
      <div style="color:red">會員:${loginmember.account}${loginmember.nickname}</div>  -->
       <span class="myButton" onclick="newappointmentb();"><span class="glyphicon glyphicon-heart" style="padding-right:2px;"></span>+申請新約會</span>
       <span class="myButton" onclick="newappointmenta();"><span class="glyphicon glyphicon-heart-empty" style="padding-right:2px;"></span>+邀請新約會</span>
    </li>
    <li><a href="${pageContext.request.contextPath}/appointments">一週約會通知</a></li>
    <li class="active"><a href="${pageContext.request.contextPath}/appointmentb">申請的約會</a></li>
    <li><a href="${pageContext.request.contextPath}/appointmenta">邀請的約會</a></li>
  </ul>
  <div class="tab-content">
  <div id="menu1" class="tab-pane fade in active">
	<div class="row">
		<div class="col-md-12">
			<!-- jqgrid beg -->
			<div style="margin: 0px" id="jqGriddiv">
				<table id="jqGrid"></table>
				<div id="jqGridPager"></div>
			</div>
			<!-- jqgrid end -->
		</div>
	</div>
  </div>
  </div>
</div></div>
</div>
</sec:authorize>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
<script type="text/ecmascript"	src="${pageContext.request.contextPath}/js/trirand/i18n/grid.locale-tw.js"></script>
<script type="text/ecmascript"	src="${pageContext.request.contextPath}/js/trirand/jquery.jqGrid.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen"	href="${pageContext.request.contextPath}/css/trirand/ui.jqgrid-bootstrap.css" />

<script type="text/javascript">
var colorgender=["red","green"];
$(document).ready(function() {
	$("#jqGrid").jqGrid({
		colModel : [
		{
			label : 'id',
			name : 'id',
			hidden : true
		}, {
			label : '發起時間',
			name : 'pubTime',
			search:true, stype:'text', searchoptions:{dataInit:function (elem){
				$(elem).datepicker({ dateFormat: "yy-mm-dd" });
			},sopt:['cn','nc','eq']},
			formatter : function (cellvalue, options, rowObject){
				return  (cellvalue.length <= 16 ?cellvalue:cellvalue.substring(0,16));
			},
			width : 140,
			fixed : true
		}, {
			label : 'showtimeId',
			name : 'showtimeId',
			hidden : true
		}, {
			label : '約會日期',
			name : 'showtimeDate',
			search:true, stype:'text', searchoptions:{dataInit:function (elem){
				$(elem).datepicker({ dateFormat: "yy-mm-dd" });
			},sopt:['cn','nc','eq']},
			formatter : 'date',
			formatoptions:{newformat:'Y-m-d'},
			width : 120,
			fixed : true
		}, {
			label : '電影時刻表',
			name : 'showtimeData',
			search:true, stype:'text', searchoptions:{sopt:['cn','nc','eq']},
			width : 270,
			fixed : true
		}, {
			label : 'mId',
			name : 'mId',
			hidden : true
		}, {
			label : 'gender',
			name : 'gender',
			hidden : true
		}, {
			label : '邀請對象',
			name : 'nickname',
			search:true, stype:'text', searchoptions:{sopt:['cn','nc','eq']},
			cellattr : memberidAttr,
			formatter : function (cellvalue, options, rowObject){
				return  (cellvalue == 0 ?cellvalue:cellvalue+'　<a href="member/profile/'+rowObject.mId+'" target="_blank" > <img src="photo/member/'+rowObject.mId+
						'" style="width:50px;border:1px green dashed;" /></a>');
			},
			width : 130,
			fixed : true
		}, {
			label : '申請時間',
			name : 'requestAppointmentTime',
			search:true, stype:'text', searchoptions:{dataInit:function (elem){
				$(elem).datepicker({ dateFormat: "yy-mm-dd" });
			},sopt:['cn','nc','eq']},
			formatter : function (cellvalue, options, rowObject){
				return  (cellvalue.length <= 16 ?cellvalue:cellvalue.substring(0,16));
			},
			width : 140,
			fixed : true
		}, {
			label : '狀態',
			name : 'bstatus',
			search:true, stype:'select', 
			searchoptions: { value: "0:0.尚未回應;1:1.是;2:2.否;7:7.取消(申請者);8:8.取消(邀請者)"	,
				             sopt:['eq']},
			width : 120,
			fixed : true,
            formatter : formatterStatus
		}],
        url: 'appointmentbjson',
        datatype: "json",
		sortname: 'showtimeDate',
		sortorder: 'desc',
		loadonce: true,
		rowList: [5,10,20],
		rowNum: 5,
		hidegrid: false,
		viewrecords: true,
		width: $("#jqGriddiv").width(),
		height: 250,
		pager: "#jqGridPager"
	});
	
	function memberidAttr(rowId, cellValue, rowObject, colModel, arrData) {
		if (rowObject.gender == 0) {
			return ' style="color: '+colorgender[0]+'"';
		} else {
			return ' style="color: '+colorgender[1]+'"';
		}	
	}

	function formatterStatus(cellvalue, options, rowObject){
		return  (cellvalue==0?"0.尚未回應":(cellvalue==1?"1.是":(cellvalue==2?"2.否":(cellvalue==7?"7.取消(申請者)":(cellvalue==8?"8.取消(邀請者)":(cellvalue==9?"9.取消(管理員)":""))))));
	}

	$('#jqGrid').navGrid('#jqGridPager',
	{
			//refreshstate:'current',
			edit : true,
			edittext : "修改",
			edittitle : "修改所選列",
			add : false,
			del : false,
			search : true,
			refresh : false,
			view : true,
			viewtext : "查看明細",
			viewtitle : "查看所選列明細資料",
			position : "left",
			cloneToTop : false,
			editfunc:function(){
				var gr = jQuery("#jqGrid").jqGrid('getGridParam','selrow');
			     if( gr != null ) {
						var grv = jQuery("#jqGrid").jqGrid('getRowData',gr);
						window.location.href = "${pageContext.request.contextPath}/appointmentbedit/"+grv.id;
			     }
			     else { alert("尚未選擇修改列!");  }
			}
		},{
			reloadAfterSubmit: true, 
			closeOnEscape: true,
			closeAfterEdit: true,
			closeAfterSubmit: true
		    //afterSubmit: function(response, postdata){//用在更新按確認,但資料還沒回寫到grid }
		},
		// options for the Edit Dialog
		{},
		// options for the Add Dialog
		{},
		// options for the Delete Dailog
		{});
});
</script>
<script>
function newappointmenta() {
	window.location.href = "${pageContext.request.contextPath}/new_appointmenta";
}
function newappointmentb() {
	window.location.href = "${pageContext.request.contextPath}/new_appointmentb";
}

</script>
</body>
</html>