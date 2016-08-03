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
    
     <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/css/shop-homepage.css" rel="stylesheet">

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
  <div class="row">
 <div id="wrapper">
       <div class="navbar-default sidebar">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                       <li>
                            <a href="products"><i class="my home"></i>回商城首頁 </a>
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


 		
  <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail" id="memberdiscount01">
                            <img src="" alt="">
                            <div class="caption" id="memberproduct">
                               <p id="membername"></p>
						       <p id="membermoney"></p>
				               <p id="membercontent"></p>
				               <p id="xx"></p>
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
 

                   
                   
                </div>

            </div>


   
 
 <script>



//  $.ajax({
//     type:"post",
//     url:"memberproduct",
//     dataType:"json",
//     success : function(memberproduct) {
// 		var xxx = memberproduct[1].name;
	
// $("#xx").append(xxx);


// 		}

	 
// 	 })

window.onload=function(){
var mp=document.createDocumentFragment();

	 $.ajax({
		 type:"get",
		 url:"memberproducts/1",
		 success:function(data){
	var MemberProduct=document.getElementById("memberdiscount01");		 	
    var MemberNameP=document.createElement("p");
    var MemberNameTextP=document.createTextNode(data[0].name);
    MemberNameP.appendChild(MemberNameTextP);
    MemberProduct.appendChild(MemberNameP);	

		 }
	 
	 })	
 
}
//<p id="memberName"></p>

 </script>
 
 
 

 
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
 
 <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
 
 <script>



//     var memberproducts_name;

// //  <div class="thumbnail" id="memberdiscount">
// 	var productDiv = document.createElement("div");
// 	productDiv.className = "thumbnail";
// 	productDiv.id = "memberdiscount";

// //  <img src="/Lovie/cart/images01.jpg" alt="" />
// 	var img01 = document.createElement("img");
// 	img01.setAttribute("src","/Lovie/cart/images01.jpg");
	
// //  <div class="caption" id="memberproduct01">
// 	var captionDiv = document.createElement("div");
// 	captionDiv.className = "caption";
// 	captionDiv.id = "memberproduct01";

// //  <p id="membername">${memberproducts.name}</p>
// 	var memberNameP = document.createElement("p");
// 	var memberNamePText = document.createTextNode(memberproducts_name);
// 	memberNameP.append(memberNamePText);

// //  <p id="membermoney">元</p>
// 	var memberMoneyP = document.createElement("p");
// 	var memberMoneyPText = document.createTextNode("元");
// 	memberMoneyP.appendChild(memberMoenyPText);

// //  <p id="membercontent"></p>
// 	var memberContentP = document.createElement("p");
// 	var memberContentPText = document.createTextNode("");
// 	memberContextP.appendChild(memberContextPText);

// 	captionDiv.appendChild(memberNameP);
// 	captionDiv.appendChild(memberMoneyP);
// 	captionDiv.appendChild(memberContextP);
// 	thumbnailDiv.appendChild(img01);
// 	thumbnailDiv.appendChild(captionDiv);

// 	var pageWrapper = document.getElementById("page-wrapper");
// 	pageWrapper.appendChild(thumbnailDiv);


	
 </script>

</body>
   <c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>              
</html>