<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.moviename_panel{
	width: 800px;
}
.moviename{
	float:left;
	margin-left:10px;
	margin-right:20px;
	width: 180px;
}
.theatername_panel{
	width: 800px;
}
.theatername{
	float:left;
	margin-left:10px;
	margin-right:20px;
	width: 180px;
}

.dropdown-menu{
	position:absolute;
	cursor:pointer;
}

</style>
<c:import charEncoding="UTF-8" url="../meta.jsp"></c:import>
</head>
<body>
	<div id="wrapper">
		<c:import charEncoding="UTF-8" url="../nav.jsp"></c:import>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-md-4">
					<h2 class="">電影時刻表管理</h2>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-10">
					<div class="output"></div>
				</div>
				<div class="col-md-2">
					<button>
						<a href="showtimecrawler.do">更新電影時刻表</a>
					</button>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">
				
					<div class="panel-heading">電影時刻表</div>
					
					<div class="col-md-1">
						<div class="btn-group" style="float: left">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="buttonMovie" data-toggle="dropdown">
							&nbsp;&nbsp;電影名稱&nbsp;&nbsp; <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="menuMovie">
							<li id="movieSub"></li>
						</ul>
						</div>
					</div>
					<div class="col-md-2">
						 <div class="form-group" style="margin-left: 20px;">
	    				<input type="text" class="form-control" style="width: 150px;" id="searchMovie" placeholder="搜索電影">
	  					</div>
					</div>
					<div class="row">
						<div class="col-md-1">
							<div class="btn-group" style="float: left">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="buttonTheater" data-toggle="dropdown">
								&nbsp;&nbsp;戲院名稱&nbsp;&nbsp; <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" id="menuTheater" aria-labelledby="menuTheater">
								<li id="theaterSub"></li>
							</ul>
							</div>
						</div>
						<div class="col-md-2">
							 <div class="form-group" style="margin-left: 20px;">
		    				<input type="text" class="form-control" style="width: 150px;" id="searchTheater" placeholder="搜索戲院">
		  					</div>
		  				</div>
		  			</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
					
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="movietable">
								<thead>
									<tr>
										<th>ID</th>
										<th>電影名稱</th>
										<th>戲院名稱</th>
										<th>日期</th>
										<th>時間</th>
									</tr>
								</thead>
								
								<tbody id="showtime_list">
									<tr>
									</tr>
								</tbody>
								
							</table>
						</div>
					</div>



				</div>
			</div>
		
			
	<script>
			var movienames = [<c:forEach var="moviename" items="${movienames}">"${moviename}",</c:forEach>];
			var theaternames = [<c:forEach var="theatername" items="${theaternames}">"${moviename}",</c:forEach>];
			var moviename_panel = document.createElement("div");
			moviename_panel.setAttribute("class", "moviename_panel");
			for(i=0; i<movienames.length;i++){
				var moviename_div = document.createElement("div");
				moviename_div.setAttribute("class", "moviename");
				moviename_div.setAttribute("id", "moviename"+i);
				moviename_div.setAttribute("onclick", "getbymovie(this)");
				var moviename_text = document.createTextNode(movienames[i])
				moviename_div.appendChild(moviename_text);
				moviename_panel.appendChild(moviename_div);
			}
			var moviesub = document.getElementById("movieSub");
			moviesub.appendChild(moviename_panel);
			
			var theaternames = [<c:forEach var="theatername" items="${theaternames}">"${theatername}",</c:forEach>];
			var theatername_panel = document.createElement("div");
			theatername_panel.setAttribute("class", "theatername_panel");
			for(i=0; i<theaternames.length;i++){
				var theatername_div = document.createElement("div");
				theatername_div.setAttribute("class", "theatername");
				theatername_div.setAttribute("id", "theatername"+i);
				theatername_div.setAttribute("onclick", "getbytheater(this)");
				var theatername_text = document.createTextNode(theaternames[i])
				theatername_div.appendChild(theatername_text);
				theatername_panel.appendChild(theatername_div);
			}
			var theatersub = document.getElementById("theaterSub");
			theatersub.appendChild(theatername_panel);
			
			function getbymovie(ele){
				var moviename = ele.innerText;
				xhr = new XMLHttpRequest();
				xhr.onreadystatechange = callback;
				xhr.open("get","${pageContext.request.contextPath}/showtimeJsonByMovie.do?MovieName="+moviename);
				xhr.send();
				
				function callback(){
					if(xhr.readyState==4 && xhr.status==200){
						var response = xhr.responseText;
						var showtimes = JSON.parse(response);
						var showtime_list = document.getElementById("showtime_list")
						while(showtime_list.firstChild){
							showtime_list.removeChild(showtime_list.firstChild);
						}
						
						
						for(i=0; i<showtimes.length; i++){
							var tr = document.createElement("tr");
							var showtime_td = document.createElement("td");
							var showtime_td_text_id = document.createTextNode(showtimes[i].id);
							showtime_td.appendChild(showtime_td_text_id);
							tr.appendChild(showtime_td);
							var showtime_td = document.createElement("td");
							var showtime_td_text_id = document.createTextNode(showtimes[i].movieName);
							showtime_td.appendChild(showtime_td_text_id);
							tr.appendChild(showtime_td);
							var showtime_td = document.createElement("td");
							var showtime_td_text_id = document.createTextNode(showtimes[i].theaterName);
							showtime_td.appendChild(showtime_td_text_id);
							tr.appendChild(showtime_td);
							var showtime_td = document.createElement("td");
							var showtime_td_text_id = document.createTextNode(showtimes[i].showtimeDate);
							showtime_td.appendChild(showtime_td_text_id);
							tr.appendChild(showtime_td);
							var showtime_td = document.createElement("td");
							var showtime_td_text_id = document.createTextNode(showtimes[i].showtimeTime);
							showtime_td.appendChild(showtime_td_text_id);
							tr.appendChild(showtime_td);
							showtime_list.appendChild(tr);
						}
					}
				}
			}
			
			function getbytheater(ele){
				var theatername = ele.innerText;
				xhr = new XMLHttpRequest();
				xhr.onreadystatechange = callback;
				xhr.open("get","${pageContext.request.contextPath}/showtimeJsonByTheater.do?tName="+theatername);
				xhr.send();
				
				function callback(){
					if(xhr.readyState==4 && xhr.status==200){
						var response = xhr.responseText;
						var showtimes = JSON.parse(response);
						var showtime_list = document.getElementById("showtime_list")
						while(showtime_list.firstChild){
							showtime_list.removeChild(showtime_list.firstChild);
						}
						
						
						for(i=0; i<showtimes.length; i++){
							var tr = document.createElement("tr");
							var showtime_td = document.createElement("td");
							var showtime_td_text_id = document.createTextNode(showtimes[i].id);
							showtime_td.appendChild(showtime_td_text_id);
							tr.appendChild(showtime_td);
							var showtime_td = document.createElement("td");
							var showtime_td_text_id = document.createTextNode(showtimes[i].movieName);
							showtime_td.appendChild(showtime_td_text_id);
							tr.appendChild(showtime_td);
							var showtime_td = document.createElement("td");
							var showtime_td_text_id = document.createTextNode(showtimes[i].theaterName);
							showtime_td.appendChild(showtime_td_text_id);
							tr.appendChild(showtime_td);
							var showtime_td = document.createElement("td");
							var showtime_td_text_id = document.createTextNode(showtimes[i].showtimeDate);
							showtime_td.appendChild(showtime_td_text_id);
							tr.appendChild(showtime_td);
							var showtime_td = document.createElement("td");
							var showtime_td_text_id = document.createTextNode(showtimes[i].showtimeTime);
							showtime_td.appendChild(showtime_td_text_id);
							tr.appendChild(showtime_td);
							showtime_list.appendChild(tr);
						}
					}
				}
			}
			
			
	</script>
<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
</body>
</html>
