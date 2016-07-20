<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<title>商城購物</title>

<style>
.caption {
	text-align: center;
}
</style>



<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
</head>
<body>

	<div class="shop">
		<div class="cart">
			<div class="shop-menu pull-right">
				<ul class="nav navbar-nav">

					<li><a href="checkout.html" class="active"><i
							class="fa fa-crosshairs"></i>結帳</a></li>
					<li><a href="cart.html"><i class="fa fa-shopping-cart"></i>
							購物車</a></li>

				</ul>
			</div>
		</div>


		<div class="container">



			<div class="col-md-3">
				<p class="lead"></p>
				<div class="list-group">

					<a href="/Lovie/product.do" class="list-group-item">回商城首頁</a> <a
						href="#" class="list-group-item">電影週邊商品</a> <a href="#"
						class="list-group-item">訂單查詢</a> <a href="#"
						class="list-group-item">我的最愛</a> <a href="#"
						class="list-group-item">回報問題</a>

				</div>
			</div>

			<div class="col-md-9">

				<div class="col-md-6">
					<div class="thumbnail">
						<img src="../photo/images0.jpg" alt="">
						<div class="caption">
							<p>黃金會員</p>
							<p>
								<a href="#" class="btn btn-primary">加入購物車</a>
							</p>

						</div>
					</div>

				</div>
				
				
				<div class="col-md-6">
					<div class="thumbnail">
						<img src="../photo/images0.jpg" alt="">
						<div class="caption">
							<p>黃金會員</p>
							<p>
								<a href="#" class="btn btn-primary">加入購物車</a>
							</p>

						</div>
					</div>

				</div>
				
				<div class="col-md-6">
					<div class="thumbnail">
						<img src="../photo/images0.jpg" alt="">
						<div class="caption">
							<p>黃金會員</p>
							<p>
								<a href="#" class="btn btn-primary">加入購物車!</a>
							</p>

						</div>
					</div>

				</div>
				
				<div class="col-md-6">
					<div class="thumbnail">
						<img src="../photo/images0.jpg" alt="">
						<div class="caption">
							<p>黃金會員</p>
							<p>
								<a href="#" class="btn btn-primary">加入購物車</a>
							</p>

						</div>
					</div>

				</div>
				
				
				
				
			</div>

		</div>
		
		
		
		
</body>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</html>