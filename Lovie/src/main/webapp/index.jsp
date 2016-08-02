<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/imagehover.css">
<link rel="stylesheet" href="css/bulma.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/scrolling-nav.css">

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="./js/jquery-2.2.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.navbar {
	background-color: #EEEEEE;
	border-color: #FFFFFF;
	}
.navbar-brand {
	
}

.ghost-button {
 
 color: #000;
 background: #fff;
 border: 1px solid #000;
 font-size: 17px;
 padding: 7px 12px;
 font-weight: normal;
 margin: 6px 0;
 margin-right: 12px;
 display: inline-block;
 text-decoration: none;
 font-family: 'Open Sans', sans-serif;
 min-width: 120px;
 margin-top:200px;
}

.ghost-button:hover, .ghost-button:active {
  color:#fff;
  background:#000;
  text-decoration: none;
}

#page-top{
	background-image: url("image/index/entity.jpg");
	height:800px;
	
}

</style>
<title>Lovie 電影交友網</title>
</head>
<body>
	<header>

	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top"></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
					<li><a href=<c:url value="/index.jsp"/>>首頁</a></li>
					<li><a href=<c:url value="/appointments"/>>約會</a></li>
					<li><a href=<c:url value="/movies"/>>電影</a></li>
					<li><a href=<c:url value="/theaters"/>>戲院</a></li>
					<li><a href=<c:url value="/members"/>>會員</a></li>
					<li><a href=<c:url value="/forums"/>>討論</a></li>
					<li><a href=<c:url value="/carts"/>>商城</a></li>
				</ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	
	</header>
	
	<div id="page-top"> <a class="ghost-button" href="#">Ghost button text </a> </div> 
	
	<div class="index_content2"></div>
	
	<c:import charEncoding="UTF-8" url="footer.jsp"></c:import>
<script src="js/jquery.easing.min.js"></script>
<script src="js/scrolling-nav.js"></script>
</body>
</html>