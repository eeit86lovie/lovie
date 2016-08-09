<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="../meta.jsp"></c:import>
<style type="text/css">
th{
	text-align: center;
}

td{
	min-width: 60px;
	overflow: hidden;
}

</style>
</head>
<body>
	<div id="wrapper">
		<c:import charEncoding="UTF-8" url="../nav.jsp"></c:import>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-md-4">
					<h2 class="">戲院管理</h2>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">
					<div class="panel-heading">戲院表單</div>
					<div onclick="theater_add" style="float:right;margin-right: 20px;margin-bottom: 20px;"><button>新增戲院</button></div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="theatertable">
								<thead>
									<tr>
										<th>操作</th>
										<th>ID</th>
										<th>名稱</th>
										<th>城市</th>
										<th>區域</th>
										<th>地址</th>
										<th>電話</th>
										<th>網址</th>

									</tr>
								</thead>
								<tbody id="tbody">
									<c:forEach var="theater" items="${theaters }" varStatus="vs">
										<tr id="theater${theater.id }">
											<td
												onclick="theater_delete(${theater.id},'${theater.name}')"><span
												class="glyphicon glyphicon-remove" style="color: red;"></span></td>
											<td id="theater${theater.id }_idd" onclick="theater_edit(this)">${theater.id}</td>
											<td id="theater${theater.id }_name" onclick="theater_edit(this)">${theater.name}</td>
											<td id="theater${theater.id }_city" onclick="theater_edit(this)">${theater.city}</td>
											<td id="theater${theater.id }_district" onclick="theater_edit(this)">${theater.district}</td>
											<td id="theater${theater.id }_address" onclick="theater_edit(this)">${theater.address}</td>
											<td id="theater${theater.id }_phone" onclick="theater_edit(this)">${theater.phone}</td>
											<td id="theater${theater.id }_website" onclick="theater_edit(this)" style="max-width: 150px">${theater.websiteUrl}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>



				</div>
			</div>
			<script>
			
			function theater_delete(theater_id,theater_name){
				var xhr;
				var result = window.confirm("確定刪除 "+theater_name+"?");
				if(result){
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange=callback;
					xhr.open("get", "theaterRemove.do?id="+theater_id);
					xhr.send();
				}
				
				function callback(){
					if (xhr.readyState==4 ){
						var result = xhr.responseText;
					if(result){
						var parent = document.getElementById("tbody");
						var child = document.getElementById("theater"+theater_id);
						parent.removeChild(child);	
					}else{
						alert("刪除失敗")
					}
					}
				}
			}
			
			function theater_edit(col){
				var text = col.innerHTML;
				var editableText = $('<input type="text" value="'+text+'" style="width:100%;" name="'+col.id+'" id="'+col.id+'"/>');
				$("#"+col.id).replaceWith(editableText);
				$("#"+col.id).focus();
				$("#"+col.id).blur(function(){
					var after_text = $("#"+col.id).val();
					var col_id = col.id;
					var pattern = /^theater(\d+)_(\w+)/;
					var match_id = pattern.exec(col_id);
					var id = match_id[1];
					var type = match_id[2];
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange = callback;
					xhr.open("get", "theaterEdit.do?id="+id+"&type="+type+"&value="+after_text);
					xhr.send();
					function callback() {
						if(xhr.readyState==4 && xhr.status==200){
							$("#"+col_id).replaceWith('<td id="'+col_id+'" onclick="theater_edit(this)">'+after_text+'</td>')
						}
					}
				});
				$("#"+col.id).keydown(function(event){
					if(event.which==13){
					var after_text = $("#"+col.id).val();
					var col_id = col.id;
					var pattern = /^theater(\d+)_(\w+)/;
					var match_id = pattern.exec(col_id);
					var id = match_id[1];
					var type = match_id[2];
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange = callback;
					xhr.open("get", "theaterEdit.do?id="+id+"&type="+type+"&value="+after_text);
					xhr.send();
					}
					function callback() {
						if(xhr.readyState==4 && xhr.status==200){
							$("#"+col_id).replaceWith('<td id="'+col_id+'" onclick="theater_edit(this)">'+after_text+'</td>')
						}
					}
				});
			}
			
			
			
			</script>


			<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
</body>
</html>
