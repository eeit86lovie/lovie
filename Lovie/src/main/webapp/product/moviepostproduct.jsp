<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/admin/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css"
	rel="stylesheet">


<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/admin/bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/shop-homepage.css"
	rel="stylesheet">


<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="${pageContext.request.contextPath}/css/timeline.css"
	rel="stylesheet">





<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<title>商城購物</title>

<style>
.navbar-default {
	margin-top: -0.5cm;
}

.nav {
	text-align: center;
}

.thumbnail {
	text-align: center;
	border: solid;
	width:300px;
    height:400px
}
#postdiscount img { 
max-width:150px; 
myimg:expression(onload=function(){ 
this.style.width=(this.offsetWidth > 150)?"150px":"auto"});
} 


</style>



<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
</head>
<body>

	
	<div class="row">

		<div class="navbar-default sidebar">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="/Lovie/products" class="show">首頁</a></li>

					<li><a href="/Lovie/product/memberproduct.jsp">購買會員</a></li>

					<li><a href="/Lovie/product/moviepostproduct.jsp">電影海報</a></li>
					<li><a href="/Lovie/product/dollproduct.jsp">人物公仔</a></li>
					<li><a href="/Lovie/product/clothesproduct.jsp">服飾</a></li>

					<li><a href="/Lovie/product/cart.jsp"><i class="glyphicon glyphicon-shopping-cart"></i> 購物車</a></li>
					<li><a href="/Lovie/product/tradedetail.jsp"><i class="selectbill"></i>訂單查詢</a></li>
					<li><a href=""><i class="customerservice"></i>回報客服</a> <!-- /.nav-second-level -->
					</li>


				</ul>
			</div>

		</div>
	</div>




	<div id="page-wrapper">

	</div>

	<script>

	//電影海報
	var movieposts = document.createDocumentFragment();
	function moviepost(){

		$.ajax({
			type : "get",
			url : "movieposts/2",
			success : function(data) {
				for (var i = 0; i<data.length; i++) {

					var PostNameP = document.createElement("p");
					var PostNameTextP = document.createTextNode(data[i].name);
					PostNameP.appendChild(PostNameTextP);

					var PostMoneyP = document.createElement("p");
					var PostMoneyTextP = document.createTextNode(data[i].cost);
					PostMoneyP.appendChild(PostMoneyTextP);

					var PostContentP = document.createElement("p");
					var PostContentTextP = document.createTextNode(data[i].content);
					PostContentP.appendChild(PostContentTextP);


					var PostBtnP = document.createElement("button");
					PostBtnP.id = "PostBtnP"+JSON.stringify(data[i]['productid']);
					PostBtnP.setAttribute('onclick', "addToCart(this)");
					PostBtnP.className = "addtocart"
					var PostBtnTextP = document.createTextNode("加入購物車");
					PostBtnP.appendChild(PostBtnTextP);
					
					var PostSelect=document.createElement("select");
					PostSelect.className="form-control input-sm";
					PostSelect.id="PostSelectAmountdata"+JSON.stringify(data[i].productid);
					
					var PostOpt1=document.createElement("option");
					PostOpt1.value=1;
					var PostOPtText1=document.createTextNode(1);
					PostOpt1.appendChild(PostOPtText1);
					
					var PostOpt2=document.createElement("option");
					PostOpt2.value=2;
					var PostOPtText2=document.createTextNode(2);
					PostOpt2.appendChild(PostOPtText2);
					
					var PostOpt3=document.createElement("option");
					PostOpt3.value=3;
					var PostOPtText3=document.createTextNode(3);
					PostOpt3.appendChild(PostOPtText3);
					
					var PostOpt4=document.createElement("option");
					PostOpt4.value=4;
					var PostOPtText4=document.createTextNode(4);
					PostOpt4.appendChild(PostOPtText4);
					
					var PostOpt5=document.createElement("option");
					PostOpt5.value=5;
					var PostOPtText5=document.createTextNode(5);
					PostOpt5.appendChild(PostOPtText5);
	
					var PostCaptionDiv = document.createElement("div");
					PostCaptionDiv.className = "caption";
					PostCaptionDiv.id = "postProduct";

					var PostImgDiv = document.createElement("img");
					PostImgDiv.id=data[i].productid;
					PostImgDiv.setAttribute("src", "${pageContext.request.contextPath}/image/product/post/"+data[i].productid+".jpg");

					var PostThumbnailDiv = document.createElement("div");
					PostThumbnailDiv.className = "thumbnail";
					PostThumbnailDiv.id = "postdiscount";

					var PostColDiv = document.createElement("div")
					PostColDiv.className = "col-sm-4 col-lg-4 col-md-4";
					PostColDiv.id = "postproductshow";

					PostCaptionDiv.appendChild(PostNameP);
					PostCaptionDiv.appendChild(PostMoneyP);
					PostCaptionDiv.appendChild(PostContentP);
					PostSelect.appendChild(PostOpt1);
					PostSelect.appendChild(PostOpt2);
					PostSelect.appendChild(PostOpt3);
					PostSelect.appendChild(PostOpt4);
					PostSelect.appendChild(PostOpt5);
					PostCaptionDiv.appendChild(PostSelect);
					PostCaptionDiv.appendChild(PostBtnP);
					PostThumbnailDiv.appendChild(PostImgDiv);
					PostThumbnailDiv.appendChild(PostCaptionDiv);
					PostColDiv.appendChild(PostThumbnailDiv);
					movieposts.appendChild(PostColDiv);

					var PostwrapperDiv = document.getElementById("page-wrapper");
					PostwrapperDiv.appendChild(movieposts);

				}

			}

		})
	}

		window.onload=moviepost();

		function addToCart(addToCartObject){
			var ProductId = addToCartObject.id.substring(8);
	        var PostAmount=document.getElementById("PostSelectAmountdata"+addToCartObject.id.substring(8));
			$.ajax({
				type : "get",
				url : "cart.do",
				data : {
					productId : ProductId,
					amount:PostAmount.value
				},
				success : function(addproductbean) {
			
	                   alert("確定加入購物車");
				}
			});
		
		}

		
		
	
			
		
		
		
		
		</script>







	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/admin/bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>


	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/admin/bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- Flot Charts JavaScript -->
	<script
		src="${pageContext.request.contextPath}/admin/bower_components/flot/excanvas.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/bower_components/flot/jquery.flot.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/bower_components/flot/jquery.flot.pie.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/bower_components/flot/jquery.flot.resize.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/bower_components/flot/jquery.flot.time.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/bower_components/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
	

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>



</body>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</html>