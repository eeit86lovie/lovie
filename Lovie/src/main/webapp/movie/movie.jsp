<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<style>
.movie_showtime{
	height:260px;
	margin-left: 80px;
	margin-right: 20px;
}

.row{
	margin-bottom: 20px;
}
</style>
<title>${movie.name}</title>
</head>
<body>
	<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>



	<!-- Page Content -->
	<div class="container">
	
	

		<!-- Portfolio Item Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header" style="font-size: 28px;">${movie.name}</h1>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<img src=${pageContext.request.contextPath }/photo/movie/${movie.id}>
			</div>
			<div class="col-md-3">
				<p><img src="${pageContext.request.contextPath }/image/movie/${movie.rank}.png" width="40"	></p>
				<p>上映時間:${movie.startTime}</p>
				<p>
					類型:
					<c:forEach var="genre" items="${genre_list}">${genre}&nbsp;</c:forEach>
				</p>
				<p align="justify">簡介:<br>${movie.intro}</p>
				
			</div>
			
			
			<div class="col-md-6">
				
				<div class="movie_showtime" >
				<h3 style="margin:10px;">電影時刻表</h3>
				
				<div style="border: #BBB 2px dotted; height: 260px; overflow: auto; padding: 10px;">
				
				<c:forEach var="showtime" items="${showtime_list }">
				${showtime.theaterName } ${showtime.showtimeDate } ${showtime.showtimeTime }<br>
				</c:forEach>
				   
					
					</div>
				</div>
			</div>



		</div>
		<!-- /.row -->

		<!-- Portfolio Item Row -->
		<div class="row">

			<div class="col-md-12">
				<div class="video_view" style="">
					
						<iframe frameborder="0" id="ff" height="400" width="920" src="${movie.trailer}"></iframe>
						
				</div>
			</div>


		</div>
		<!-- /.row -->

		<!-- Related Projects Row -->
		<div class="row">

			<div class="col-lg-12">
				<h3 class="page-header" style="font-size: 28px;">近期約會</h3>
			</div>

			<div class="col-sm-3 col-xs-6">
				<a href="#"> <img class="img-responsive portfolio-item"
					src="http://placehold.it/500x300" alt="">
				</a>
			</div>

			<div class="col-sm-3 col-xs-6">
				<a href="#"> <img class="img-responsive portfolio-item"
					src="http://placehold.it/500x300" alt="">
				</a>
			</div>

			<div class="col-sm-3 col-xs-6">
				<a href="#"> <img class="img-responsive portfolio-item"
					src="http://placehold.it/500x300" alt="">
				</a>
			</div>

			<div class="col-sm-3 col-xs-6">
				<a href="#"> <img class="img-responsive portfolio-item"
					src="http://placehold.it/500x300" alt="">
				</a>
			</div>

		</div>
		<!-- /.row -->


	</div>
	<!-- /.container -->









	<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
	<script>
		$(function() {
			$("#ff").load(function() {
				$(this).height($(this).contents().find("body").height() + 400);
			});
		});
	</script>

</body>
</html>