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
#clothdiscount img { 
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

	var clothes = document.createDocumentFragment();
	//服飾
	function buyClothes(){
		$("#page-wrapper").empty();
		$.ajax({
			type : "get",
			url : "clothes/4",
			success : function(data) {
				for (var i = 0; i <data.length; i++) {

					//alert(data[i].productid);

					$('#showproduct').empty();

					var ClotheNameP = document.createElement("p");
					var ClotheNameTextP = document.createTextNode(data[i].name);
					ClotheNameP.appendChild(ClotheNameTextP);

					var ClotheMoneyP = document.createElement("p");
					var ClotheMoneyTextP = document.createTextNode(data[i].cost);
					ClotheMoneyP.appendChild(ClotheMoneyTextP);

					var ClotheContentP = document.createElement("p");
					var ClotheContentTextP = document.createTextNode(data[i].content);
					ClotheContentP.appendChild(ClotheContentTextP);

					var ClotheBtnP = document.createElement("button");
					ClotheBtnP.id = "ClotheBtnP"+JSON.stringify(data[i]['productid']);
					ClotheBtnP.setAttribute('onclick', "addToCart(this)");
					ClotheBtnP.className = "addtocart"
					var ClotheBtnTextP = document.createTextNode("加入購物車");
					ClotheBtnP.appendChild(ClotheBtnTextP);
					
					var ClotheSelect=document.createElement("select");
					ClotheSelect.className="form-control input-sm";
					ClotheSelect.id="ClotheSelectAmountdata"+JSON.stringify(data[i].productid);
					
					var ClotheOpt1=document.createElement("option");
					ClotheOpt1.value=1;
					var ClotheOPtText1=document.createTextNode(1);
					ClotheOpt1.appendChild(ClotheOPtText1);
					
					var ClotheOpt2=document.createElement("option");
					ClotheOpt2.value=2;
					var ClotheOPtText2=document.createTextNode(2);
					ClotheOpt2.appendChild(ClotheOPtText2);
					
					var ClotheOpt3=document.createElement("option");
					ClotheOpt3.value=3;
					var ClotheOPtText3=document.createTextNode(3);
					ClotheOpt3.appendChild(ClotheOPtText3);
					
					var ClotheOpt4=document.createElement("option");
					ClotheOpt4.value=4;
					var ClotheOPtText4=document.createTextNode(4);
					ClotheOpt4.appendChild(ClotheOPtText4);
					
					var ClotheOpt5=document.createElement("option");
					ClotheOpt5.value=5;
					var ClotheOPtText5=document.createTextNode(5);
					ClotheOpt5.appendChild(ClotheOPtText5);

					var ClotheCaptionDiv = document.createElement("div");
					ClotheCaptionDiv.className = "caption";
					ClotheCaptionDiv.id = "clothProduct";

					var ClotheImgDiv = document.createElement("img");
					ClotheImgDiv.setAttribute("src", "${pageContext.request.contextPath}/image/product/clothes/"+data[i].productid+".jpg");

					var ClotheThumbnailDiv = document.createElement("div");
					ClotheThumbnailDiv.className = "thumbnail";
					ClotheThumbnailDiv.id = "clothdiscount";

					var ClotheColDiv = document.createElement("div")
					ClotheColDiv.className = "col-sm-4 col-lg-4 col-md-4";
					ClotheColDiv.id = "Clotheproductshow";

					ClotheCaptionDiv.appendChild(ClotheNameP);
					ClotheCaptionDiv.appendChild(ClotheMoneyP);
					ClotheCaptionDiv.appendChild(ClotheContentP);
					ClotheSelect.appendChild(ClotheOpt1);
					ClotheSelect.appendChild(ClotheOpt2);
					ClotheSelect.appendChild(ClotheOpt3);
					ClotheSelect.appendChild(ClotheOpt4);
					ClotheSelect.appendChild(ClotheOpt5);
					ClotheCaptionDiv.appendChild(ClotheSelect);
					ClotheCaptionDiv.appendChild(ClotheBtnP);
					ClotheThumbnailDiv.appendChild(ClotheImgDiv);
					ClotheThumbnailDiv.appendChild(ClotheCaptionDiv);
					ClotheColDiv.appendChild(ClotheThumbnailDiv);
					clothes.appendChild(ClotheColDiv);

					var ClothewrapperDiv = document.getElementById("page-wrapper");
					
				}
				ClothewrapperDiv.appendChild(clothes);
			}
		})
	}
		window.onload= buyClothes();
		function addToCart(addToCartObject){
			var ProductId = addToCartObject.id.substring(10);
			alert(ProductId);
	        var ClotheAmount=document.getElementById("ClotheSelectAmountdata"+addToCartObject.id.substring(10));
			$.ajax({
				type : "get",
				url : "cart.do",
				data : {
					productId : ProductId,
					amount:ClotheAmount.value
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