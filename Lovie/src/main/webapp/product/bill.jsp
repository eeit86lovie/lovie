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

					<li><a href="/Lovie/product/cart.jsp"><i
							class="glyphicon glyphicon-shopping-cart"></i> 購物車</a></li>
					<li><a href="/Lovie/product/tradedetail.jsp"><i
							class="selectbill"></i>訂單查詢</a></li>
					<li><a href=""><i class="customerservice"></i>回報客服</a> <!-- /.nav-second-level -->
					</li>


				</ul>
			</div>

		</div>
	</div>
	${loginmember.account}


	<div id="page-wrapper">

		<div class="col-lg-9">
			<div class="panel panel-default">
				<div class="panel-heading">訂單</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-4">
							<form role="form">
								<div class="form-group">
									<label>會員帳號:</label>
									<p id="memberAccount" class="help-block">${loginmember.account}</p>

								</div>
								<div class="form-group">
									<label>會員編號:</label>
									<p id="memberid" class="help-block">${loginmember.id}</p>
								</div>
								<div class="form-group">

									<div class="st1">
										<label>姓名</label> <input class="" type="text" id="idName"
											required placeholder="請輸入姓名" /><span id="idsp1"> </span>
									</div>
									<span>必填(不可空白，至少兩個字且必須為中文字)</span>
								</div>
								<div class="form-group">
									<div class="st1">
										<label>地址</label> <input class="" type="text" id="idAddress"
											required placeholder="請輸入地址" /><span id="idsp2"> </span> <br>
										<span>必填(不可空白，至少兩個字且必須為中文字)</span></br>
									</div>
								</div>
								<div class="form-group">
									<label>E-MAIL</label> <input class="" type="text"
										id="idAddress" required placeholder="請輸入E-MAIL" /><span
										id="idsp3"> </span> <br>
									<span>(不可空白，不包含中文，至少6個字且必須包含英文字母、數字、特殊字元[!@#$%^&*]</span></br>

								</div>
								<div class="form-group">
									<label>連絡電話</label> <input class="" type="text" id="idAddress"
										required placeholder="請輸入電話" /><span id="idsp4"> </span> <br>
									<span>(不可空白，不包含中文，至少6個字且必須包含英文字母、數字、特殊字元[!@#$%^&*]<span>
											</br>
								</div>
						</div>
						<div class="col-lg-4">
							<div class="form-group">
								<label>購買產品:</label>
								<c:forEach items="${addcartlist}" var="addtocart" varStatus="loop">
									<tr id="Cart${addtocart.bean.productid}" data-cost="${addtocart.bean.cost*addtocart.amount}" class="success">
										<br><td>產品編號:${addtocart.bean.productid}</td>
										<br><td>產品名稱:${addtocart.bean.name}</td>
										<br><td>產品內容:${addtocart.bean.content}</td>
										<br><td>產品折扣:${addtocart.bean.discount}</td>
										<br><td>單筆金額:NT$${addtocart.bean.cost}元</td>
										<br><td>產品數量${addtocart.amount}</td>
										<br><td>產品金額:${addtocart.bean.cost*addtocart.amount}</td>
										<c:if test="${loop.last}">
											<script>
                                    		var itemAmount = ${loop.count}
                                    		</script>
										</c:if>
									</tr>
								</c:forEach>

								<tr>
									<br><th>總金額</th>
									<th id="allMoney">NT$${param.allcost}元</th>

								</tr>

							</div>
						</div>
						<div class="col-lg-4">
						
						
						
						
							<div class="form-group">
									<label>信用卡號</label>
									<input class="" type="text" id="idAddress" required placeholder="請輸入卡號" /><spanid="idsp3"> </span> <br>
									<span>(不可空白，不包含中文，至少6個字且必須包含英文字母、數字、特殊字元[!@#$%^&*]</span></br>

								</div>
	
						</div>
						</form>
						<form role="form"></form>
					</div>
					<!-- /.col-lg-6 (nested) -->
				</div>
				<!-- /.row (nested) -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>




	<script>
		function bill() {
			$.ajax({
				type : "get",
				url : "cart.do",
				data : {
					productId : ProductId,
					amount:Amount.value
				},
				success : function(addproductbean) {
				}
			});
							

			
			window.onload = function() {
								document.getElementById("idName").onblur = chkName;
								document.getElementById("idPwd").onblur = chkPwd;
								document.getElementById("idDate").onblur = chkDate;
							}
							function chkName() {
								var theName = document.getElementById("idName").value;
								re = /^[\u4E00-\u9FA5]{2,}$/;
								if (re.test(theName))
									document.getElementById("idsp1").innerHTML = "<img src='../EEITLabSrc(Express)/Lab06/Images/check.png' />";
								else
									document.getElementById("idsp1").innerHTML = "<img src='../EEITLabSrc(Express)/Lab06/Images/error.png' />";
							}
							function chkPwd() {
								var theName = document.getElementById("idPwd").value;
								re = /^(?=.*[a-z])(?=.*\d)(?=.*[\*\@\-\_\+\$\%\#\&\^\!])\S{6,}$/;
								if (re.test(theName))
									document.getElementById("idsp2").innerHTML = "<img src='../EEITLabSrc(Express)/Lab06/Images/check.png' />";
								else
									document.getElementById("idsp2").innerHTML = "<img src='../EEITLabSrc(Express)/Lab06/Images/error.png' />";
							}
							function chkDate() {
								var theDate = document.getElementById("idDate").value;
								re = /^((0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01])[- /.](19|20)?[0-9]{2})*$/;
								if (theDate == "") {
									document.getElementById("idsp3").innerHTML = "<img src='../EEITLabSrc(Express)/Lab06/Images/error.png' />";
								} else if (re.test(theDate)) {
									document.getElementById("idsp3").innerHTML = "<img src='../EEITLabSrc(Express)/Lab06/Images/check.png' />";
								} else {
									document.getElementById("idsp3").innerHTML = "<img src='../EEITLabSrc(Express)/Lab06/Images/error.png' />";
								}
							}

						}
					})
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