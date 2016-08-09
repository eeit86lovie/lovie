<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="../meta.jsp"></c:import>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/createForum/createForum.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/selectLike/selectLike.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

.deleteimg{
    width:30px;
    height:25px;
}

.memberimg{
    width: 80px;
	height: 120px;
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
					
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="forumable" "style='table-layout: fixed'">
								<thead>
								    <tr>
										<th>檢舉會員</th>
										<th>檢舉會員 暱稱</th>
									    <th>檢舉會員帳號</th>
										<th>檢舉原因</th>
									</tr>
									
									<button type="button" onclick="deleteArticle()">刪除</button>
								</thead>
								<tbody id="forum_tbody">				
																	
								</tbody>
							   <div id="box"></div>
							</table>
						</div>
					</div>



				</div>
			</div>
			<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
			
			
<c:import charEncoding="UTF-8" url="/forum/createForumFunction.jsp"></c:import>

<script>
//var ReportArticle;
var memberJson;


$.ajax({
	url : "${pageContext.request.contextPath}/forumsMember",
	type : "post",
	dataType : "json",
	success : function(memberjson) {
		memberJson = memberjson;
		$.ajax({
			url : "${pageContext.request.contextPath}/forumsSelectreply",
			type : "post",
			dataType : "json",
			success : function(selectReplyjson) {
				$.ajax({
					url : "${pageContext.request.contextPath}/forumsSelectReportID",
					type : "post",
					data:{ReportAreicleID:"${reportAreicleID}"},
					dataType : "json",
					success : function(reportArticlejson) {			
						$.ajax({
							url : "${pageContext.request.contextPath}/forumsAllLike",
							type : "post",
							dataType : "json",
							success : function(allLikejson) {
								
							
									//ReportArticle = reportArticle;
			 						createArticle(reportArticlejson,selectReplyjson,allLikejson);
							//alert(reportArticle.title);
								
								}					
						})
					}					
				})
			}		
		})	
	}	
})
	
	
	
	//var ReportID ="${reportAreicleID}";
	//alert(ReportID);
	
$.ajax({
	url : "${pageContext.request.contextPath}/forumsMember",
	type : "post",
	dataType : "json",
	success : function(memberjson) {
		memberJson = memberjson;
$.ajax({
		url : "${pageContext.request.contextPath}/forumsSelectReportReson",
		type : "post",
		data:{ReportID:"${reportAreicleID}"},
		dataType : "json",
		success : function(reportAdmin) {
				for(var i =0;i<reportAdmin.length;i++){
					
					
					var memberimg = document.createElement("img");
					memberimg.className="memberimg"
					memberimg.src = getmemberPhoto(reportAdmin[i].memberAccount).photoUrl;
					
					var td_report1 = $("<td></td>").append(memberimg);
					var td_report2 = $("<td></td>").append(getmemberPhoto(reportAdmin[i].memberAccount).nickname);
					var td_report3 = $("<td></td>").append(reportAdmin[i].memberAccount);
					var td_report4 = $("<td></td>").append(reportAdmin[i].reportReason);
								
					
					var tr_report = $("<tr></tr>");
					
					
					
					
					tr_report.append(td_report1);
					tr_report.append(td_report2);
					tr_report.append(td_report3);			
					tr_report.append(td_report4);			
					
					$("#forum_tbody").append(tr_report);
					
					
				}
			}					
		})
	}					
})
	
function deleteArticle(){
	
	
	$.ajax({
		url : "${pageContext.request.contextPath}/forumsDelete",
		type : "POST",
		
		data : {
			Article_ID:"${reportAreicleID}",
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
</script>
			
</body>
</html>