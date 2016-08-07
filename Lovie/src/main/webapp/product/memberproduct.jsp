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
}

.


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

		//會員商品
	
			function memberproduct(){
			$.ajax({
				type : "get",
				url : "memberproducts/1",
				success : function(data) {
					for (var i = 0; i < data.length; i++) {

						var MemberNameP = document.createElement("p");
						var MemberNameTextP = document.createTextNode(data[i].name);
						MemberNameP.appendChild(MemberNameTextP);

						var MemberMoneyP = document.createElement("p");
						var MemberMoneyTextP = document.createTextNode(data[i].cost);
						MemberMoneyP.appendChild(MemberMoneyTextP);

						var MemberContentP = document.createElement("p");
						var MemberContentTextP = document.createTextNode(data[i].content);
						MemberContentP.appendChild(MemberContentTextP);

						var MemberBtnP = document.createElement("button");
						MemberBtnP.id = "MemberBtnP"+JSON.stringify(data[i]['productid']);
						MemberBtnP.setAttribute('onclick', "addToCart(this)");
						MemberBtnP.className = "addtocart"
						var MemberBtnTextP = document.createTextNode("加入購物車");
						MemberBtnP.appendChild(MemberBtnTextP);
						
						var MemberSelect=document.createElement("select");
						MemberSelect.className="form-control input-sm";
						MemberSelect.id="MemberSelectAmountdata"+JSON.stringify(data[i].productid);
						
						var MemberOpt1=document.createElement("option");
						MemberOpt1.value=1;
						var MemberOPtText1=document.createTextNode(1);
						MemberOpt1.appendChild(MemberOPtText1);
						
						var MemberOpt2=document.createElement("option");
						MemberOpt2.value=2;
						var MemberOPtText2=document.createTextNode(2);
						MemberOpt2.appendChild(MemberOPtText2);
						
						var MemberOpt3=document.createElement("option");
						MemberOpt3.value=3;
						var MemberOPtText3=document.createTextNode(3);
						MemberOpt3.appendChild(MemberOPtText3);
						
						var MemberOpt4=document.createElement("option");
						MemberOpt4.value=4;
						var MemberOPtText4=document.createTextNode(4);
						MemberOpt4.appendChild(MemberOPtText4);
						
						var MemberOpt5=document.createElement("option");
						MemberOpt5.value=5;
						var MemberOPtText5=document.createTextNode(5);
						MemberOpt5.appendChild(MemberOPtText5);

						var CaptionDiv = document.createElement("div");
						CaptionDiv.className = "caption";
						CaptionDiv.id = "memberproduct";

						var ImgDiv = document.createElement("img");
						ImgDiv.setAttribute("src", "null");

						var ThumbnailDiv = document.createElement("div");
						ThumbnailDiv.className = "thumbnail";
						ThumbnailDiv.id = "memberdiscount";

						var ColDiv = document.createElement("div")
						ColDiv.className = "col-sm-4 col-lg-4 col-md-4";
						ColDiv.id = "memberproductshow";

						CaptionDiv.appendChild(MemberNameP);
						CaptionDiv.appendChild(MemberMoneyP);
						CaptionDiv.appendChild(MemberContentP);
						MemberSelect.appendChild(MemberOpt1);
						MemberSelect.appendChild(MemberOpt2);
						MemberSelect.appendChild(MemberOpt3);
						MemberSelect.appendChild(MemberOpt4);
						MemberSelect.appendChild(MemberOpt5);
						CaptionDiv.appendChild(MemberSelect);
						CaptionDiv.appendChild(MemberBtnP);
						CaptionDiv.appendChild(MemberBtnP);
						ThumbnailDiv.appendChild(ImgDiv);
						ThumbnailDiv.appendChild(CaptionDiv);
						ColDiv.appendChild(ThumbnailDiv);

						var wrapperDiv = document.getElementById("page-wrapper");
						wrapperDiv.appendChild(ColDiv);
					}

				}

		});
			};
		window.onload=memberproduct();
		function addToCart(addToCartObject){
			var ProductId = addToCartObject.id.substring(10);
	        var Amount=document.getElementById("MemberSelectAmountdata"+addToCartObject.id.substring(10));
	    
			$.ajax({
				type : "get",
				url : "cart.do",
				data : {
					productId : ProductId,
					amount:Amount.value,
				
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