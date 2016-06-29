<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${theater.name}</title>



<style>
.img-responsive {
	width: 195px;
	height: 288px;
	margin-bottom: 10px;
}

.movie_head{
	margin-bottom:5px;
}



.row{
	margin-top:5px;
	margin-bottom:10px;
}

.showtime{
	border:#F5F5F5 solid 10px;
	margin-left:2px;
	float:left;
	height:300px;
	width:180px;
	background:#F5F5F5;
	overflow-y: auto;
	margin-bottom: 25px; 
	
}

#style-1::-webkit-scrollbar-track
{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	border-radius: 10px;
	background-color: #F5F5F5;
}

#style-1::-webkit-scrollbar
{
width:12px;
background-color: #F5F5F5;
}

#style-1::-webkit-scrollbar-thumb
{
border-radius:10px;
-webkit-box-shadow:inset 0 0 6px rgba(0,0,0,0.3);
background-color: #555;
}

</style>
</head>
<body>
	<c:import url="/header.jsp"></c:import>

	<div class="container">

		<div class="row">
			<div class="col-md-4">
				<h1 class="page-header" style="font-size: 24px;">
					<a href="theater.do?tID=${theater.id }">${theater.name}</a>
				</h1>
				${theater.address }<br> ${theater.phone } &nbsp <a
					href="${theater.websiteUrl }">網站</a><br>


			</div>
			<div class="col-md-8"></div>
		</div>


		<c:forEach var="movie" items="${movies }" varStatus="vs">
			<c:if test="${vs.count %2 == 0}">
				<div class="row">
			</c:if>
			<div class="col-md-6">
				<div class="col-md-6">
					<a href="movie.do?mID=${movie.id}"> <img
						class="img-responsive" src="photo.do?type=movie&id=${movie.id}" alt=""></a>
				</div>
				<div class="col-md-6">
					<div class="movie_head">
						<h1 style="width: 100%;">${movie.name}</h1>
					</div>
					<div class="showtime" id="style-1">
						<c:forEach var="showtime" items="${showtimes }">
							<c:if test="${showtime.movieName == movie.name}">
							 ${showtime.showtimeDate } - ${showtime.showtimeTime }<br>
							</c:if>
						</c:forEach>

					</div>
				</div>

			</div>
			<c:if test="${vs.count %2 == 0}">
	</div>
	</c:if>
	</c:forEach>

	</div>





	<!-- container -->
	<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
	<script>
		
	</script>
</body>
</html>