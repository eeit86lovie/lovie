<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <c:import charEncoding="UTF-8" url="../meta.jsp"></c:import> 
</head>
<body>
	<div id="wrapper">
		<c:import charEncoding="UTF-8" url="../nav.jsp"></c:import>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-md-4">
					<h2 class="">約會管理</h2>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">
					<!-- <div class="panel-heading">約會表單</div> -->
					<!-- jqgrid beg -->
					<div style="margin-left: 20px">
						<table id="jqGrid"></table>
						<div id="jqGridPager"></div>
					</div>
					<!-- jqgrid end -->
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper"></div>
					</div>
				</div>
			</div>
			<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import> 


<script type="text/ecmascript"	src="${pageContext.request.contextPath}/js/trirand/i18n/grid.locale-tw.js"></script>
<script type="text/ecmascript"	src="${pageContext.request.contextPath}/js/trirand/jquery.jqGrid.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen"	href="${pageContext.request.contextPath}/css/trirand/ui.jqgrid-bootstrap.css" />

<!--  為了search 條件可以用 datapicker..才引用的js -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

<script>
	$.jgrid.defaults.width = 920;
	$.jgrid.defaults.responsive = true;
	$.jgrid.defaults.styleUI = 'Bootstrap';
</script>

<style type="text/css">
	#viewmodjqGrid {
	   top: 51px !important;
	}
	#status0,#status1,#status2,#status9{
		margin-left: -40px;
	}
</style>

<script type="text/javascript">
var colorgender=["red","green"];
$(document).ready(function() {
	$("#jqGrid").jqGrid({
		colModel : [
		{
			label : 'ID',
			name : 'id',
			width : 60,
			search:true, stype:'text', searchoptions:{sopt:['eq','cn','nc']},
			fixed : true
		}, {
			label : 'memberid',
			name : 'memberid',
			hidden : true
		}, {
			label : 'membergender',
			name : 'membergender',
			hidden : true
		}, {
			label : '邀請人',
			name : 'membernm',
			search:true, stype:'text', searchoptions:{sopt:['eq','cn','nc']},
			cellattr : memberidAttr,
			width : 90,
			fixed : true
		}, {
			label : '電影時刻表',
			name : 'showtimeBean',
			search:true, stype:'text', searchoptions:{dataInit:function (elem){
				$(elem).datepicker({ dateFormat: "yy-mm-dd" });
			},sopt:['cn','nc','eq']},
			width : 170,
			fixed : true
		}, {
			label : '發佈時間',
			name : 'pubTime',
			search:true, stype:'text', searchoptions:{sopt:['cn','eq','nc']},
			formatter : 'date',
			formatoptions:{newformat:'Y-m-d H:i'},
			width : 145,
			fixed : true
		}, {
			label : '留言',
			name : 'content',
			search:true, stype:'text', searchoptions:{sopt:['eq','cn','nc']},
			width : 150,
			fixed : true
		}, {
			label : 'acceptedmemberid',
			name : 'acceptedmemberid',
			hidden : true
		}, {
			label : 'acceptedmembergender',
			name : 'acceptedmembergender',
			hidden : true
		}, {
			label : '申請人',
			name : 'acceptedmembernm',
			search:true, stype:'text', searchoptions:{sopt:['eq','cn','nc']},
			cellattr : acceptedmemberidAttr,
			width : 90,
			fixed : true
		}, {
			label : '申請時間',
			name : 'acceptedTime',
			search:false, 
			formatter : 'date',
			formatoptions:{newformat:'Y-m-d H:i'},
			width : 145,
			fixed : true
		}, {
			label : '狀態',
			name : 'status',
			search:true, stype:'select', 
			searchoptions: { value: "0:0.取消;1:1.進行;2:2.成功;9:9.封存"	,
				             sopt:['eq']},
			width : 65,
			fixed : true,
			editable: true,
            edittype: "custom",
            formatter : formatterStatus,
            editoptions: {
                custom_value: getStatusElementValue,
                custom_element: createStatusEditElement
            }
		} ],
		editurl : 'clientArray',
		datatype: 'local',
		caption : "約會表單",
		sortname : 'id',
		sortorder : 'asc',
		loadonce: true,
		rowList:[3,5,10,20],
		rowNum : 3,
		hidegrid : false,
		viewrecords : true,
		width : 920,
		height : 300,
		pager : "#jqGridPager"
	});
	
	function memberidAttr(rowId, cellValue, rowObject, colModel, arrData) {
		if (rowObject.membergender == 0) {
			return ' style="color: '+colorgender[0]+'"';
		} else {
			return ' style="color: '+colorgender[1]+'"';
		}	
	}
	function acceptedmemberidAttr(rowId, cellValue, rowObject, colModel, arrData) {
		if (rowObject.acceptedmembergender == 0) {
			return ' style="color: '+colorgender[0]+'"';
		} else {
			return ' style="color: '+colorgender[1]+'"';
		}	
	}
	
	fetchGridData();
	function fetchGridData() {
		var gridArrayData = [];
		$("#jqGrid")[0].grid.beginReq();
		$.ajax({
			url : "appointmentjson",
			type:"get",
			success : function(data) {
			if (data != null) {
					//var result = JSON.parse(data);
					var result =data;
					for (var i = 0; i < result.length; i++) {
						var item = result[i];
						gridArrayData.push({
							//opt : "	<span class=\"glyphicon glyphicon-trash\" style=\"color: red;\"  onclick=\"appointment_delete("+item.id+",'"+item.memberBean.id+"')\"></span>",
							id : item.id,
							//type : item.type,
							name : item.name,
							memberid : item.memberBean==null?"":item.memberBean.id,
							membergender : item.memberBean==null?"":item.memberBean.gender,
							membernm : item.memberBean==null?"":
								item.memberBean.account+"<br/>"+item.memberBean.nickname,
							showtimeBean : item.showtimeBean==null?"":item.showtimeBean.id+"<br/>"+item.showtimeBean.theaterName+"<br/>"+new Date(item.showtimeBean.showtimeDate).toISOString().split('T')[0]+"<br/>"+item.showtimeBean.showtimeTime,
							pubTime : new Date(item.pubTime), 
							content : item.content,
							acceptedmemberid : item.acceptedmemberBean==null?"":item.acceptedmemberBean.id,
							acceptedmembergender : item.acceptedmemberBean==null?"":item.acceptedmemberBean.gender,
							acceptedmembernm : item.acceptedmemberBean==null?"":
								item.acceptedmemberBean.account+"<br/>"+item.acceptedmemberBean.nickname,
							acceptedTime : new Date(item.acceptedTime),
							status : item.status
						});
					}
				$("#jqGrid").jqGrid('setGridParam', { data: gridArrayData});
				$("#jqGrid")[0].grid.endReq();
				$("#jqGrid").trigger('reloadGrid');
			}}
		});
	}
	
	function formatterStatus(cellvalue, options, rowObject){
		return  (cellvalue==0?"0.取消":(cellvalue==1?"1.進行":(cellvalue==2?"2.成功":(cellvalue==9?"9.封存":""))));
	}
    function createStatusEditElement(valuet, editOptions) {
    	var value = valuet.substring(0,1);
    	var div =$("<div style='margin-bottom:5px;margin-top:-10px;margin-left=2px;'></div>");
        var label = $("<label class='radio-inline'></label>");
        var radio = $("<input>", { type: "radio", value: "0", name: "status", id: "status0", checked: value == 0 });
		label.append(radio).append("0.取消");
        var label1 = $("<label class='radio-inline'></label>");
        var radio1 = $("<input>", { type: "radio", value: "1", name: "status", id: "status1", checked: value == 1 });
		label1.append(radio1).append("1.進行");
        var label2 = $("<label class='radio-inline'></label>");
        var radio2 = $("<input>", { type: "radio", value: "2", name: "status", id: "status2", checked: value == 2 });
		label2.append(radio2).append("2.成功");
        var label3 = $("<label class='radio-inline'></label>");
        var radio3 = $("<input>", { type: "radio", value: "9", name: "status", id: "status9", checked: value == 9 });
		label3.append(radio3).append("9.封存");
        div.append(label).append(label1).append(label2).append(label3);
        return div;
    }
    function getStatusElementValue(elem, oper, value) {
        if (oper === "set") {
            var radioButton = $(elem).find("input:radio[value='" + value.substr(0,1) + "']");
            if (radioButton.length > 0) {
                radioButton.prop("checked", true);
            }
        }
        if (oper === "get") {
        	var newstatus = $(elem).find("input:radio:checked").val(); 
			var gr = jQuery("#jqGrid").jqGrid('getGridParam','selrow');
		     if( gr != null ) {
					var grv = jQuery("#jqGrid").jqGrid('getRowData',gr);
			    	appointment_updateStatus(grv.id,newstatus);
		     }
		     else { alert("尚未選擇修改列!");  }
            return newstatus;
        }
    }

	$('#jqGrid').navGrid('#jqGridPager',
	{
			//refreshstate:'current',
			edit : true,
			edittext : "修改狀態",
			edittitle : "修改所選列狀態",
			add : false,
			del : true,
			deltext : "刪除列",
			deltitle : "刪除所選列資料",
			search : true,
			refresh : false,
			view : true,
			viewtext : "查看明細",
			viewtitle : "查看所選列明細資料",
			position : "left",
			cloneToTop : false,
			delfunc:function(){ 
				var gr = jQuery("#jqGrid").jqGrid('getGridParam','selrow');
			     if( gr != null ) {
						var grv = jQuery("#jqGrid").jqGrid('getRowData',gr);
				        appointment_delete(grv.id,grv.memberid);
				        //alert("del......");
					    var row = $("#jqGrid").jqGrid('delRowData',grv.id);
				        $("#jqGrid").trigger('reloadGrid');
			     }
			     else { alert("尚未選擇刪除列!");  }
			}
		},{
			reloadAfterSubmit: true, 
			closeOnEscape: true,
			closeAfterEdit: true,
			closeAfterSubmit: true
		    //afterSubmit: function(response, postdata){//用在更新按確認,但資料還沒回寫到grid }
		},
		// options for the Edit Dialog
		{
			editCaption : "編輯狀態",
			errorTextFormat : function(data) {
				return 'Error: '+ data.responseText
			}
		},
		// options for the Add Dialog
		{},
		// options for the Delete Dailog
		{});

	function appointment_delete(appointment_id,
			appointment_memberId) {
		var xhr;
		var result = window.confirm("確定刪除ID為 "
				+ appointment_id + "的約會資料?");
		if (result) {
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = callback;
			xhr.open("get", "appointmentRemove?id="+ appointment_id);
			xhr.send();
		}

		function callback() {
			if (xhr.readyState == 4) {
				var result = xhr.responseText;
				if (result) {
				    /*var row = $("#jqGrid").jqGrid('delRowData',appointment_id);
				    if (row)
				      {}//alert("刪除成功->"+"appointment"+appointment_id);
				    else
				      alert("刪除失敗");*/
				} else {
					alert("刪除失敗");
				}
			}
		}
	}

	function appointment_updateStatus(appointment_id,appointment_status) {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open("get", "appointmentUpdateStatus?id="+ 
				 appointment_id+"&status="+appointment_status);
		xhr.send();

		function callback() {
			if (xhr.readyState == 4) {
				var result = xhr.responseText;
				if (!result) {
					alert("狀態更新失敗");
				}
			}
		}
	}

});

</script>
</body>
</html>
