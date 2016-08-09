<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/imagehover.css">
<link rel="stylesheet" href="css/bulma.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="./js/jquery-2.2.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.navbar {
	background-color: #FFFFFF;
	border-color: #FFFFFF;
}
</style>
<title>Lovie 電影交友網</title>
</head>
<body>
	<header>

	<div id="nav">
		<nav class="navbar navbar-inverse" role="navigation">
		<div class="container">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"></a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">首頁</a></li>
					<li><a href="#">約會</a></li>
					<li><a href="selectAllMovie">電影</a></li>
					<li><a href="#">會員</a></li>
					<li><a href="#">討論</a></li>
					<li><a href="#">感興趣</a></li>
				</ul>
				<div class="member_nav">
					<img class="member_pic_nav" src="image/cloud.jpg"><a href="#">幼咪咪雲姐</a>
				</div>
			</div>

		</div>
		</nav>
	</div>
	</header>

	<img src="image/index/entity2.jpg"> 
	
	
	<div class="index_content2"></div>
	
	<c:import charEncoding="UTF-8" url="footer.jsp"></c:import>

</body>
</html>