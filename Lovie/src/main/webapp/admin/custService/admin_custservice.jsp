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
</head>
<body>

<div id="wrapper">
		<c:import charEncoding="UTF-8" url="../nav.jsp"></c:import>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-md-4">
					<h2 class="">客服管理</h2>
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
					<div class="panel-heading">問題回報</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="custtable" "style='table-layout: fixed'">
								<thead>
									<tr>
										<th>id</th>
									    <th>會員帳號</th>
										<th>問題種類</th>
										<th>原因</th>
										<th>回覆</th>
										<th>狀態</th>
									</tr>
								</thead>
								<tbody id="cust_tbody">				
																	
								</tbody>
							</table>
						</div>
					</div>



				</div>
			</div>
			<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
			
	<script>
	
	$.ajax({
		url : "${pageContext.request.contextPath}/admincustService",
		type : "post",
		dataType : "json",
		success : function(Selectresult) {
			var status;
			for(var i =0;i<Selectresult.length;i++){
			
			
				//alert(Selectresult[i].status);
				
				var td0 = $("<td id='"+'id'+Selectresult[i].id+"'></td>").append(Selectresult[i].id);
				var td1 = $("<td id='"+'member'+Selectresult[i].id+"'></td>").append(Selectresult[i].memberId);
				var td2 = $("<td id='"+'catagory'+Selectresult[i].id+"'></td>").append(Selectresult[i].catagory);
				var td3 = $("<td id='"+'message'+Selectresult[i].id+"'></td>").append(Selectresult[i].message);
				
				
				
				
				var text = document.createElement("input");
				text.type="text";
				text.id="text"+Selectresult[i].id;
				var t = document.createTextNode("送出"); 				
				var button = document.createElement("button");
				button.appendChild(t);
				button.id="button"+Selectresult[i].id;
				button.setAttribute("onclick","clickbutton(this)");
				
				
				
				var td4 = $("<td id='"+'report'+Selectresult[i].id+"'></td>").append(text);
				td4.append(button);
				
				if(Selectresult[i].status=="1"){
					status ="代處理";
					
					var td5 = $("<td id='"+'statue'+Selectresult[i].id+"'></td>").append(status);
				}else{
					status ="已處理"
					var td5 = $("<td id='"+'statue'+Selectresult[i].i+"'></td>").append(status);
				}
				
							
				
				var tr = $("<tr id='"+'tr'+Selectresult[i].id+"'></tr>");
				
				
				
				
				tr.append(td0);
				tr.append(td1);
				tr.append(td2);			
				tr.append(td3);
				tr.append(td4);
				tr.append(td5);
				
				
				
				$("#cust_tbody").append(tr);
				
				
				
			}
			
		
		}					
	})
	
	
	
	function clickbutton(buttionObject){
		var id = buttionObject.id.substring(6);
		var reason = $("#"+"text"+id).val();
		
		
		$.ajax({
			url : "${pageContext.request.contextPath}/adminSelectcustService",
			type : "post",
			data:{ID:id,
				  REASON:reason},
			dataType : "json",
			success : function(Selectresult) {
				$("#"+"statue"+id).empty();
				$("#"+"text"+id).empty();
				$("#"+"statue"+id).append("已處理");
				alert("信件已寄送");
			}
		})
	}
	
	
	
	</script>
	
	
			
</body>
</html>