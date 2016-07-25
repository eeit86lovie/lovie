<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="${pageContext.request.contextPath}/dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">






<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<title>商城購物</title>

<style>
.navbar-default{
 margin-top:-0.5cm;

}




.slide-image{
display:block;
margin: auto;
width:1000px;
height:1000px;
max-width:1000px;
max-height:3000px;
}

.thumbnail img{
width:180px;
height:180px;

}
.everymonthimages{
width:635px;
height:180px;
text-align:center;

}
.nav{
text-align:center;

}


</style>



<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
</head>
<body>
  <div class="row" items"">
 <div id="wrapper">
       <div class="navbar-default sidebar">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                        <li>
                            <a href="/Lovie/memberproduct"><i class="buy member"></i>購買會員 </a>
                        </li>
                        <li>
                            <a href="#"><i class=""></i> 電影週邊商品<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="/Lovie/moviepost.do?category=2">電影海報</a>
                                </li>
                                <li>
                                    <a href="/Lovie/doll.do?category=3">人物公仔</a>
                                </li>
                                <li>
                                    <a href="/Lovie/clothesproduct.do?category=4">服飾</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="tables.html"><i class="selectbill"></i>訂單查詢</a>
                        </li>
                        <li>
                            <a href="forms.html"><i class="mylove"></i>我的最愛</a>
                        </li>
                        <li>
                            <a href="#"><i class="customerservice"></i>回報客服</a>
                           
                            <!-- /.nav-second-level -->
                        </li>
                       
                       
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
       </div>

<div id="page-wrapper">
<div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="" alt="">
										
                                </div>
                                <div class="item">
                                    <img class="slide-image" src=" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>
 <c:forEach var="showproducts" items="">
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail" id="showdiscount">
                            <img src="/Lovie/cart/images01.jpg" alt="">
                            <div class="caption">
                               <p id="showtname"></p>
						       <p id="showmoney"></p>
				               <p id="showcontent"></p>
                                </h4>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">12 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>
  </c:forEach>                   
                </div>

            </div>

</div>


<script>
var productjson;
$.ajax({
	url : "product",
	type : "get",
	dataType : "json",
	success : function(productjson) {
		productJson = productjson;
	}
})



</script>
   
 
 <script>

 <!-- jQuery -->
 <script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>

 <!-- Bootstrap Core JavaScript -->
 <script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

 <!-- Metis Menu Plugin JavaScript -->
 <script src="${pageContext.request.contextPath}/bower_components/metisMenu/dist/metisMenu.min.js"></script>

 <!-- Morris Charts JavaScript -->
 <script src="${pageContext.request.contextPath}/bower_components/raphael/raphael-min.js"></script>
 <script src="${pageContext.request.contextPath}/bower_components/morrisjs/morris.min.js"></script>
 <script src="${pageContext.request.contextPath}/js/morris-data.js"></script>

 <!-- Custom Theme JavaScript -->
 <script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>






 

 </script>
</body>
   <c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>              
</html>