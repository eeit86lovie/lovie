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

#slide-image img { 
max-width:1000px;
max-height:200px; 
myimg:expression(onload=function(){ 
this.style.height=(this.offsetWidth > 200px)?"200px":"auto"});
} 



</style>

<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
</head>
<body>

	<c:import charEncoding="UTF-8" url="/product/productMenu.jsp"></c:import>



	<div id="page-wrapper" class="page-wrapperall">
<div class="col-md-12">
                       <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2" class=""></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="${pageContext.request.contextPath}/image/product/A3.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="${pageContext.request.contextPath}/image/product/A4.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="${pageContext.request.contextPath}/image/product/A5.jpg" alt="">
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
	
	
	<div class="col-md-12"><br>
	
	
	<div class="show">
	 <img class="slide-image" src="${pageContext.request.contextPath}/image/product/images.png" >
	</div>
	
	
		</div>
	
	
	
	
	
	
</div>
	<script>
		//首頁	
		function back() {
			$("#page-wrapper").empty();

		}

		//會員商品
// 		function buyMemberproduct() {
// 			$("#page-wrapper").empty();
// 			$.ajax({
// 				type : "get",
// 				url : "memberproducts/1",
// 				success : function(data) {
// 					for (var i = 0; i < data.length; i++) {

// 						//alert(data[i].productid);
// 						// 	 						
// 						$('#showproduct').empty();

// 						var MemberNameP = document.createElement("p");
// 						var MemberNameTextP = document.createTextNode(data[i].name);
// 						MemberNameP.appendChild(MemberNameTextP);

// 						var MemberMoneyP = document.createElement("p");
// 						var MemberMoneyTextP = document.createTextNode(data[i].cost);
// 						MemberMoneyP.appendChild(MemberMoneyTextP);

// 						var MemberContentP = document.createElement("p");
// 						var MemberContentTextP = document.createTextNode(data[i].content);
// 						MemberContentP.appendChild(MemberContentTextP);

// 						var MemberBtnP = document.createElement("button");
// 						MemberBtnP.id = "MemberBtnP"+data[i].productid;
// 						MemberBtnP.setAttribute('onclick', "addToCart(this)");
// 						MemberBtnP.className = "addtocart"
// 						var MemberBtnTextP = document.createTextNode("加入購物車");
// 						MemberBtnP.appendChild(MemberBtnTextP);

// 						var CaptionDiv = document.createElement("div");
// 						CaptionDiv.className = "caption";
// 						CaptionDiv.id = "memberproduct";

// 						var ImgDiv = document.createElement("img");
// 						ImgDiv.setAttribute("src", "null");

// 						var ThumbnailDiv = document.createElement("div");
// 						ThumbnailDiv.className = "thumbnail";
// 						ThumbnailDiv.id = "memberdiscount";

// 						var ColDiv = document.createElement("div")
// 						ColDiv.className = "col-sm-4 col-lg-4 col-md-4";
// 						ColDiv.id = "memberproductshow";

// 						CaptionDiv.appendChild(MemberNameP);
// 						CaptionDiv.appendChild(MemberMoneyP);
// 						CaptionDiv.appendChild(MemberContentP);
// 						CaptionDiv.appendChild(MemberBtnP);
// 						CaptionDiv.appendChild(MemberBtnP);
// 						ThumbnailDiv.appendChild(ImgDiv);
// 						ThumbnailDiv.appendChild(CaptionDiv);
// 						ColDiv.appendChild(ThumbnailDiv);

// 						var wrapperDiv = document.getElementById("page-wrapper");
// 						wrapperDiv.appendChild(ColDiv);
// 					}

// 				}

// 			})
// 		}

// 		$('body').on('click', '.addtocart', function() {
// alert("ssss");
// 			$.ajax({
// 				type : "get",
// 				url : "carts/addtocart",
// 				data : {
// 					productId : $(this).val()
// 				},
// 				success : function(data) {
// 					alert(data);

// 				}
// 			});
			
// 		});

		
	
		function addToCart(addToCartObject){
		
			var ProductId = addToCartObject.id.substring(10);
			
			$.ajax({
				type : "get",
				url : "cart.do",
				data : {
					productId : ProductId,
				},
				success : function(addproductbean) {

// 					var product_div = $("<div></div>").append(addproductbean[0].productid);
// 					var content_div = $("<div></div>").append(addproductbean[0].content);
// 					var name_div = $("<div></div>").append(addproductbean[0].name);
// 					var discount_div = $("<div></div>").append(addproductbean[0].discount);
// 					var cost_div = $("<div></div>").append(addproductbean[0].cost);
					
// 					var ALL = $("<div></div>").append(product_div);
// 					ALL.append(content_div);
// 					ALL.append(name_div);
// 					ALL.append(discount_div);
// 					ALL.append(cost_div);
					
// 					$("#ALLcar").append(ALL);
					
				}
			});
			
		
		}
		var movieposts = document.createDocumentFragment();
		//電影海報
		function buyMoviePost() {
			$("#page-wrapper").empty();
			$.ajax({
				type : "get",
				url : "movieposts/2",
				success : function(data) {
					for (var i = 0; i<data.length; i++) {

						//alert(data[i].productid);

						$('#showproduct').empty();

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
						PostBtnP.setAttribute('value', data[i].productid);
						PostBtnP.className = "addtocart"
						var PostBtnTextP = document.createTextNode("加入購物車");
						PostBtnP.appendChild(PostBtnTextP);
						
						
						var PostCaptionDiv = document.createElement("div");
						PostCaptionDiv.className = "caption";
						PostCaptionDiv.id = "postProduct";

						var PostImgDiv = document.createElement("img");
						PostImgDiv.setAttribute("src", "null");

						var PostThumbnailDiv = document.createElement("div");
						PostThumbnailDiv.className = "thumbnail";
						PostThumbnailDiv.id = "postdiscount";

						var PostColDiv = document.createElement("div")
						PostColDiv.className = "col-sm-4 col-lg-4 col-md-4";
						PostColDiv.id = "postproductshow";

						PostCaptionDiv.appendChild(PostNameP);
						PostCaptionDiv.appendChild(PostMoneyP);
						PostCaptionDiv.appendChild(PostContentP);
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

		var dolls = document.createDocumentFragment();
		//公仔
		function buyDoll() {
			$("#page-wrapper").empty();
			$.ajax({
				type : "get",
				url : "dolls/3",
				success : function(data) {
					for (var i = 0; i<data.length; i++) {

						//alert(data[i].productid);

						$('#showproduct').empty();

						var DollNameP = document.createElement("p");
						var DollNameTextP = document.createTextNode(data[i].name);
						DollNameP.appendChild(DollNameTextP);

						var DollMoneyP = document.createElement("p");
						var DollMoneyTextP = document.createTextNode(data[i].cost);
						DollMoneyP.appendChild(DollMoneyTextP);

						var DollContentP = document.createElement("p");
						var DollContentTextP = document.createTextNode(data[i].content);
						DollContentP.appendChild(DollContentTextP);

						var DollBtnP = document.createElement("button");
						DollBtnP.setAttribute('value', data[i].productid);
						DollBtnP.className = "addtocart"
						var DollContentTextP = document.createTextNode("加入購物車");
						DollBtnP.appendChild(DollContentTextP);

						var DollCaptionDiv = document.createElement("div");
						DollCaptionDiv.className = "caption";
						DollCaptionDiv.id = "dollProduct";

						var DollImgDiv = document.createElement("img");
						DollImgDiv.setAttribute("src", "null");

						var DollThumbnailDiv = document.createElement("div");
						DollThumbnailDiv.className = "thumbnail";
						DollThumbnailDiv.id = "dolldiscount";

						var DollColDiv = document.createElement("div")
						DollColDiv.className = "col-sm-4 col-lg-4 col-md-4";
						DollColDiv.id = "Dollproductshow";

						DollCaptionDiv.appendChild(DollNameP);
						DollCaptionDiv.appendChild(DollMoneyP);
						DollCaptionDiv.appendChild(DollContentP);
						DollCaptionDiv.appendChild(DollBtnP);
						DollThumbnailDiv.appendChild(DollImgDiv);
						DollThumbnailDiv.appendChild(DollCaptionDiv);
						DollColDiv.appendChild(DollThumbnailDiv);
						dolls.appendChild(DollColDiv);

						var DollwrapperDiv = document.getElementById("page-wrapper");
						DollwrapperDiv.appendChild(dolls);

					}
				}
			})
		}

		var clothes = document.createDocumentFragment();
		//服飾
		function buyClothes() {
			$("#page-wrapper").empty();
			$.ajax({
				type : "get",
				url : "clothess/4",
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
						ClotheBtnP.setAttribute('value', data[i].productid);
						ClotheBtnP.className = "addtocart"
						var ClotheContentTextP = document.createTextNode("加入購物車");
						ClotheBtnP.appendChild(ClotheContentTextP);

						var ClotheCaptionDiv = document.createElement("div");
						ClotheCaptionDiv.className = "caption";
						ClotheCaptionDiv.id = "clothProduct";

						var ClotheImgDiv = document.createElement("img");
						ClotheImgDiv.setAttribute("src", "null");

						var ClotheThumbnailDiv = document.createElement("div");
						ClotheThumbnailDiv.className = "thumbnail";
						ClotheThumbnailDiv.id = "clothdiscount";

						var ClotheColDiv = document.createElement("div")
						ClotheColDiv.className = "col-sm-4 col-lg-4 col-md-4";
						ClotheColDiv.id = "Clotheproductshow";

						ClotheCaptionDiv.appendChild(ClotheNameP);
						ClotheCaptionDiv.appendChild(ClotheMoneyP);
						ClotheCaptionDiv.appendChild(ClotheContentP);
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

// // 		function addtocart(){
			
			
// // 			var ProductId = 0;
// // 			$("#page-wrapper").empty();
// // 			$.ajax({
// // 				type : "get",
// // 				url : "carts/addtocart",
// // 				data:{productId:$(this).val()},
// // 				success : function(data) {
// // 			alert(data);
// // 			var productamount = 1;		 
			
// // 			for(var i=0;i<data.length;i++){
						 
// // 				  var BillIdTh=document.createElement("th");
// // 			      var BillIdTextTh=document.createTextNode(i+1);
// // 				  BillIdTh.appendChild(BillIdTextTh);	 
						 
// // 			      var BillProductidTh=document.createElement("th");
// // 			      var BillProductidTextTh=document.createTextNode(產品編號);
// // 			      BillProductidTh.appendChild(BillProductidTextTh);
			      
// // 			      var BillProductNameTh=document.createElement("th");
// // 			      var BillProductNameTextTh=document.createTextNode(商品名稱);
// // 			      BillProductNameTh.appendChild(BillProductNameTextTh);
			      
// // 			      var BillProductImgTh=document.createElement("img");
// // 			      var BillProductImgTextTh=document.createTextNode("null");
// // 			      BillProductImgTh.appendChild(BillProductImgTextTh);
			      
// // 			      var BillProductDiscountTh=document.createElement("th");
// // 			      var BillProductDiscountTextTh=document.createTextNode(折扣);
// // 			      BillProductDiscountTh.appendChild(BillProductDiscountTextTh);
			      
// // 			      var BillProductContentTh=document.createElement("th");
// // 			      var BillProductContentTextTh=document.createTextNode(產品內容);
// // 			      BillProductContentTh.appendChild(BillProductContentTextTh);
			      
// // 			      var BillProductCostTh=document.createElement("th");
// // 			      var BillProductCostTextTh=documentcreateTextNode(價錢);
// // 			      BillProductCostTh.appendChild(BillProductCostTextTh);
			      
// // 			      var BillProductTr=document.createElement("tr");
// // 			      BillProductTr.id="Billtr1";
			      
// // 			      var BillProductThead=document.createElement("thead");
// // 			      BillProductThead.id="Billthead";
			      
// // 			      var BillIdTd=document.createElement("td");
// // 			      var BillIdTextTd=document.createElementTextNode(i+1);
// // 			      BillIdTd.appendChild(BillIdTextTd);
			      
// // 			      var BillProduct
			      

			      
// // 			      if(!BillProductidTextTd.isEmpty){
			      
// // 				  var newproductcount =  checkProductid(data,BillProductidTextTd);
// // 				  var BillProductAmountTd=document.createElement("td");
// // 			      var BillProductAmountTextTd=document.createTextNode(newproductcount);
				
// //  			    }else{
// //  			      var BillProductAmountTd=document.createElement("td");
// // 			      var BillProductAmountTextTd=document.createTextNode(productamount);
// //  			    }



					
//  		}
// 				}
//  			})

// // 		}
		
		
		function checkProductid(data,BillProductidTextTd){
			
			var newProductamount = 1;
			if(data.productid==BillProductidTextTd){
				
			 newProductamount++;
				
			}
			
			
			return newProductamount;
			
		}
		
		
// 			var ALLcar = $("<div id='ALLcar'></div>");
// 		function goToCart(){
// 			$("#page-wrapper").empty();
// 			var ALLcar = $("<div id='ALLcar'></div>");
			
// 		}
		

		
		
		
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