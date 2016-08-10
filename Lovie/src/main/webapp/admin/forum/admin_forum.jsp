<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="../meta.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

.deleteimg{
    width:30px;
    height:25px;
}

td{
	min-width: 30px;
	max-width: 400px;
	overflow: hidden;
	 white-space:nowrap;
	 overflow:hidden;
	 text-overflow: ellipsis;
}
th{
min-width: 50px;
}

</style>
</head>
<body>

<div id="wrapper">
		<c:import charEncoding="UTF-8" url="../nav.jsp"></c:import>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-md-4">
					<h2 class="">討論區管理</h2>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-10">
					<div id="crawloutput"></div>
				</div>
				<div class="col-md-2">
					
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">
					<div class="panel-heading">被檢舉文章</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="forumtable" "style='table-layout: fixed'">
								<thead>
									<tr>
										<th>操作</th>
									    <th>觀看</th>
										<th>ID</th>
										<th>會員</th>
										<th>分類</th>
										<th style="min-width:75px">文章標題</th>
										<th style="min-width:75px">文章內容</th>
										<th>發佈時間</th>
										<th>檢舉次數</th>
									</tr>
								</thead>
								<tbody id="forum_tbody">				
																	
								</tbody>
							</table>
						</div>
					</div>



				</div>
			</div>
			<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
			
			
			
<script>

$.ajax({
	url : "${pageContext.request.contextPath}/forumsAdmin",
	type : "get",
	dataType : "json",
	success : function(report) {
		
		for(var i =0;i<report.length;i++){
			
			
			var reportcount = 0;
		for(var j =0;j<report.length;j++){
			if(report[i].id == report[j].id){
				reportcount++;
			}
		}
			
		
		
			var deleteimg = document.createElement("img");
			deleteimg.className = "deleteimg";
			deleteimg.id = "deleteimg"+report[i].id;
			deleteimg.setAttribute("onclick", "clickDelete(this)");
			deleteimg.src = "${pageContext.request.contextPath}/image/deleteArticle.gif";
			
			var detailimg = document.createElement("img");
			detailimg.className = "deleteimg";
			detailimg.id = "detailimg"+report[i].id;
			detailimg.setAttribute("onclick", "clickdetail(this)");
			detailimg.src = "${pageContext.request.contextPath}/image/admin_forum.gif";
			
			var td0 = $("<td id='"+'img'+report[i].id+"'></td>").append(deleteimg);
			var td1 = $("<td id='"+'img'+report[i].id+"'></td>").append(detailimg);
			var td2 = $("<td id='"+'id'+report[i].id+"'></td>").append(report[i].id);
			var td3 = $("<td id='"+'member'+report[i].id+"'></td>").append(report[i].memberAccount);
			var td4 = $("<td id='"+'genre'+report[i].id+"'></td>").append(report[i].genre);
			var td5 = $("<td id='"+'title'+report[i].id+"'></td>").append(report[i].title);
			var td6 = $("<td id='"+'content'+report[i].id+"'></td>").append(report[i].content);
			var td7 = $("<td id='"+'pubTime'+report[i].id+"'></td>").append(report[i].pubTime);
			var td8 = $("<td id='"+'reportReason'+report[i].id+"'></td>").append(reportcount);
						
			
			var tr = $("<tr id='"+'tr'+report[i].id+"'></tr>");
			
			
			
			
			tr.append(td0);
			tr.append(td1);
			tr.append(td2);			
			tr.append(td3);
			tr.append(td4);
			tr.append(td5);
			tr.append(td6);
			tr.append(td7);
			tr.append(td8);
			
			
			$("#forum_tbody").append(tr);
			
			
			
		}
		
	
	}					
})







function clickDelete(ButtonObject){
	
	var article_ID = ButtonObject.id.substring(9);
	$.ajax({
		url : "${pageContext.request.contextPath}/forumsDelete",
		type : "POST",
		
		data : {
			Article_ID:article_ID,
		},
		success : function(deleteCount) {
			if(deleteCount==1){
				$("#"+"BOX01"+ article_ID).remove();
				alert("刪除成功");
			}else{
				alert("刪除失敗");
			}
		}		
	})			
	
}

function clickdetail(detailObject){
	
	var article_ID = detailObject.id.substring(9)
	window.location.assign("${pageContext.request.contextPath}/forumsAdminReportArticle/"+ article_ID);
}



</script>		
			
			
</body>
</html>