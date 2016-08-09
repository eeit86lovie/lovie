<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="../meta.jsp"></c:import>
<style type="text/css">
td{
	min-width: 10px;
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
					<h2 class="">電影管理</h2>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-10">
					<div id="crawloutput"></div>
				</div>
				<div class="col-md-2">
					<button id="update_button" onclick="movieCrawler()">更新電影</button>
					<img id ="update_loading_icon" src="image/loading.gif" style="width: 100px;display: none">
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">
					<div class="panel-heading">電影表單</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="movietable">
								<thead>
									<tr>
										<th></th>
										<th>ID</th>
										<th>名稱</th>
										<th>分級</th>
										<th>上映時間</th>
										<th>片長</th>
										<th>簡介</th>
										<th>圖片</th>
										<th>預告片</th>
									</tr>
								</thead>
								<tbody id="movie_tbody">
									<c:forEach var="movie" items="${movies }" varStatus="vs">
										<tr id="movietr${movie.id }">
											<td id="movie_delete${movie.id }" onclick="movie_delete(this)"><span
												class="glyphicon glyphicon-remove" style="color: red;"></span></td>
											<td id="movie${movie.id }_mID" onclick="movie_edit(this)">${movie.id}</td>
											<td id="movie${movie.id }_mName" onclick="movie_edit(this)">${movie.name}</td>
											<td id="movie${movie.id }_mRank" onclick="movie_edit(this)">${movie.rank}</td>
											<td id="movie${movie.id }_mStartTime" onclick="movie_edit(this)" style="min-width: 100px;">${movie.startTime}</td>
											<td id="movie${movie.id }_mFilmLength" onclick="movie_edit(this)">${movie.filmLength}</td>
											<td id="movie${movie.id }_mIntro" onclick="movie_edit(this)">${movie.intro}</td>
											<td id="movie${movie.id }_mPhoto" onclick="movie_edit(this)">${movie.photo}</td>
											<td id="movie${movie.id }_mTrailer" onclick="movie_edit(this)">${movie.trailer}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>



				</div>
			</div>
			<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
			<script>
			var update_button = document.getElementById("update_button");
			var crawloutput = document.getElementById("crawloutput");
			var update_loading_icon = document.getElementById("update_loading_icon");
			function movie_edit(col){
				var text = col.innerHTML;
				var editableText = $('<input type="text" value="'+text+'" style="width:100%;" name="'+col.id+'" id="'+col.id+'"/>');
				$("#"+col.id).replaceWith(editableText);
				$("#"+col.id).focus();
				$("#"+col.id).blur(function(){
					var after_text = $("#"+col.id).val();
					var col_id = col.id;
					var pattern = /^movie(\d+)_(\w+)/;
					var match_id = pattern.exec(col_id);
					var mID = match_id[1];
					var type = match_id[2];
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange = callback;
					xhr.open("get", "movieEdit.do?mID="+mID+"&type="+type+"&value="+after_text);
					xhr.send();
					function callback() {
						if(xhr.readyState==4 && xhr.status==200){
							$("#"+col_id).replaceWith('<td id="'+col_id+'" onclick="movie_edit(this)">'+after_text+'</td>')
						}
					}
				})
				$("#"+col.id).keydown(function(event){
					if(event.which==13){
					var after_text = $("#"+col.id).val();
					var col_id = col.id;
					var pattern = /^movie(\d+)_(\w+)/;
					var match_id = pattern.exec(col_id);
					var mID = match_id[1];
					var type = match_id[2];
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange = callback;
					xhr.open("get", "movieEdit.do?mID="+mID+"&type="+type+"&value="+after_text);
					xhr.send();
					}
					function callback() {
						if(xhr.readyState==4 && xhr.status==200){
							$("#"+col_id).replaceWith('<td id="'+col_id+'" onclick="movie_edit(this)">'+after_text+'</td>')
						}
					}
				})
			}
			
			function movieCrawler(){
				xhr = new XMLHttpRequest();
				xhr.onreadystatechange = callback;
				update_button.setAttribute("style", "display:none")
				update_loading_icon.setAttribute("style", "width:100px;display:block")
				xhr.open("get", "movieCrawler");
				xhr.send();
				
				function callback(){
					if(xhr.readyState == 4 && xhr.status==200){
						while(crawloutput.firstChild){
							crawloutput.removeChild(crawloutput.firstChild);
						}
						if(xhr.responseText=="no"){
							crawl_div = document.getElementById("crawloutput");
							crawl_div.innerHTML = '<h3>沒有電影需要更新</h3>';
							update_button.setAttribute("style", "display:block")
							update_loading_icon.setAttribute("style", "display:none")
						}else{
						crawl_div = document.createElement("div");
						crawl_div.innerHTML = xhr.responseText+'<br><input type="button" style="margin:10px" value="取消"><input id="update_confirm_button" type="button" onclick="movieCrawlerConfirm()" style="margin:10px" value="確認"><img id ="update_loading_icon2" src="image/loading.gif" style="width: 100px;display: none">';
						crawloutput.appendChild(crawl_div);
						update_button.setAttribute("style", "display:block")
						update_loading_icon.setAttribute("style", "display:none")
						}
					}
				}
			}
			
			function movieCrawlerConfirm(){
				var update_confirm_button = document.getElementById("update_confirm_button");
				var update_loading_icon2 = document.getElementById("update_loading_icon2");
				xhr = new XMLHttpRequest();
				xhr.onreadystatechange = callback;
				xhr.open("get", "movieCrawlerConfirm");
				update_confirm_button.setAttribute("style", "display:none")
				update_loading_icon2.setAttribute("style", "width:100px;display:block")
				xhr.send();
				
				function callback(){
					if(xhr.readyState == 4 && xhr.status==200){
						while(crawloutput.firstChild){
							crawloutput.removeChild(crawloutput.firstChild);
						}
						$(crawloutput).html("<h2>新增完成</h2>").delay(1000);
						location.assign("${pageContext.request.contextPath}/admin/movie/movie.do")
							
					}
						
				}
			}
			
			function movie_delete(movie){
				var check = confirm("確定刪除電影ID "+movie.id.substring(12)+" ?");
				if(check==true){
					$.ajax({
						url: '${pageContext.request.contextPath}/admin/movie/delete/'+movie.id.substring(12),
						type: 'get',
						success: function(response) {
					        if(response=='yes'){
					        	alert('刪除成功!');
					        	$('#movietr'+movie.id.substring(12)).empty().remove();
					        }else{
					        	alert('刪除失敗,請洽管理員!')
					        }
					 
					    }
						
					})
				}
			}
				
			
			</script>
</body>
</html>
