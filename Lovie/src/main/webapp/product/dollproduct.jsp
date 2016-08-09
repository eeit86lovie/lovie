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
</style>



<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
</head>
<body>

	<c:import charEncoding="UTF-8" url="/product/productMenu.jsp"></c:import>



	<div id="page-wrapper">

	
	</div>

	<script>

	var dolls = document.createDocumentFragment();
	//公仔
	function buyDoll(){
		$("#page-wrapper").empty();
		$.ajax({
			type : "get",
			url : "dolls/3",
			success : function(data) {
				for (var i = 0; i<data.length; i++) {

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
					DollBtnP.id = "DollBtnP"+JSON.stringify(data[i]['productid']);
					DollBtnP.setAttribute('onclick', "addToCart(this)");
					DollBtnP.className = "addtocart"
					var DollBtnTextP = document.createTextNode("加入購物車");
					DollBtnP.appendChild(DollBtnTextP);
					
					var DollSelect=document.createElement("select");
					DollSelect.className="form-control input-sm";
					DollSelect.id="DollSelectAmountdata"+JSON.stringify(data[i].productid);
					
					var DollOpt1=document.createElement("option");
					DollOpt1.value=1;
					var DollOPtText1=document.createTextNode(1);
					DollOpt1.appendChild(DollOPtText1);
					
					var DollOpt2=document.createElement("option");
					DollOpt2.value=2;
					var DollOPtText2=document.createTextNode(2);
					DollOpt2.appendChild(DollOPtText2);
					
					var DollOpt3=document.createElement("option");
					DollOpt3.value=3;
					var DollOPtText3=document.createTextNode(3);
					DollOpt3.appendChild(DollOPtText3);
					
					var DollOpt4=document.createElement("option");
					DollOpt4.value=4;
					var DollOPtText4=document.createTextNode(4);
					DollOpt4.appendChild(DollOPtText4);
					
					var DollOpt5=document.createElement("option");
					DollOpt5.value=5;
					var DollOPtText5=document.createTextNode(5);
					DollOpt5.appendChild(DollOPtText5);
	

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
					DollSelect.appendChild(DollOpt1);
					DollSelect.appendChild(DollOpt2);
					DollSelect.appendChild(DollOpt3);
					DollSelect.appendChild(DollOpt4);
					DollSelect.appendChild(DollOpt5);
					DollCaptionDiv.appendChild(DollSelect);
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

	window.onload=buyDoll();
	function addToCart(addToCartObject){
		var ProductId = addToCartObject.id.substring(8);
        var DollAmount=document.getElementById("DollSelectAmountdata"+addToCartObject.id.substring(8));
		$.ajax({
			type : "get",
			url : "cart.do",
			data : {
				productId : ProductId,
				amount:DollAmount.value
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