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
					<h2 class="">討論區管理</h2>
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
					<div class="panel-heading">被檢舉文章</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="movietable">
								<thead>
									<tr>
										<th>操作</th>
										<th>ID</th>
										<th>會員</th>
										<th>分類</th>
										<th>文章標題</th>
										<th>文章內容</th>
										<th>發佈時間</th>
										<th>檢舉會員</th>
										<th>被檢舉原因</th>
										<th>檢舉次數</th>
									</tr>
								</thead>
								<tbody id="forum_tbody">
									<c:forEach var="reports" items="${forums }" varStatus="vs">
										<tr>
											<td ${forums.ForumBean.id}>${forums.ForumBean.id}</td>
<%-- 											<td id="movie${forums.id }_mName" onclick="movie_edit(this)">${movie.name}</td> --%>
<%-- 											<td id="movie${movie.id }_mRank" onclick="movie_edit(this)">${movie.rank}</td> --%>
<%-- 											<td id="movie${movie.id }_mStartTime" onclick="movie_edit(this)" style="min-width: 100px;">${movie.startTime}</td> --%>
<%-- 											<td id="movie${movie.id }_mFilmLength" onclick="movie_edit(this)">${movie.filmLength}</td> --%>
<%-- 											<td id="movie${movie.id }_mIntro" onclick="movie_edit(this)">${movie.intro}</td> --%>
<%-- 											<td id="movie${movie.id }_mPhoto" onclick="movie_edit(this)">${movie.photo}</td> --%>
<%-- 											<td id="movie${movie.id }_mTrailer" onclick="movie_edit(this)">${movie.trailer}</td> --%>
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


</script>		
			
			
</body>
</html>