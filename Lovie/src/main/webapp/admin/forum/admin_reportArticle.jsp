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
								id="movietable">
								<thead>
								
  
			                     

	
								</thead>
								<tbody id="forum_tbody">				
																	
								</tbody>
							</table>
						</div>
					</div>



				</div>
			</div>
			<div id="box"></div>
			<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
			
</html>

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
					success : function(reportArticle) {			
						$.ajax({
							url : "${pageContext.request.contextPath}/forumsAllLike",
							type : "post",
							dataType : "json",
							success : function(allLikejson) {
								
								if(reportArticle !=""){
									//ReportArticle = reportArticle;
			 						createArticle(reportArticle,selectReplyjson,allLikejson);
							alert(reportArticle.title);
								}else{
									
									var no_member = $("<p class='notfound'></p>").append("查無此會員")
									$("#box").append(no_member);
									
								}
								}					
						})
					}					
				})
			}		
		})	
	}	
})
	
	
	
</script>
			
</body>
</html>