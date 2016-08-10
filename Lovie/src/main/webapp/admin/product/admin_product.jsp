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
					<h2 class="">商品管理</h2>
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
					<div class="panel-heading">商品列表</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="movietable">
								<thead>
									<tr>
									    <th>訂單</th>
										<th>會員編號</th>
									    <th>會員帳號</th>
										<th>地址</th>
										<th>聯絡電話</th>
										<th>交易日期</th>
										<th>產品名稱</th>
										<th>數量</th>
										<th>總價</th>
									
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
	url : "${pageContext.request.contextPath}/checkoutbill",
	type : "get",
	dataType : "json",
	success : function() {
		
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
			detailimg.id = "deleteimg"+report[i].id;
			detailimg.setAttribute("onclick", "clickdetail(this)");
			deleteimg.src = "${pageContext.request.contextPath}/image/deleteArticle.gif";
			
			var td0 = $("<td id='"+'img'+report[i].id+"'></td>").append(deleteimg);
			var td1 = $("<td id='"+'img'+report[i].id+"'></td>").append(detailimg);
			var td2 = $("<td id='"+'id'+report[i].id+"'></td>").append(report[i].id);
			var td3 = $("<td id='"+'member'+report[i].id+"'></td>").append(report[i].memberAccount);
			var td4 = $("<td id='"+'genre'+report[i].id+"'></td>").append(report[i].genre);
			var td5 = $("<td id='"+'title'+report[i].id+"'></td>").append(report[i].title);
			var td6 = $("<td id='"+'content'+report[i].id+"'></td>").append(report[i].content);
			var td7 = $("<td id='"+'pubTime'+report[i].id+"'></td>").append(report[i].pubTime);
			var td8 = $("<td id='"+'reportReason'+report[i].id+"'></td>").append(reportcount);
						
			
			var tr = jQuery("<tr id='"+'tr'+report[i].id+"'></tr>", {
				onclick: seeReportArticle
			});
			
			
			
			
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







</script>		
			
			
</body>
</html>