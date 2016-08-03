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

<div class="col-lg-9">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                                                                                           訂單
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form">
                                        <div class="form-group">
                                            <label>會員帳號</label>
                                          <p id="memberAccount" class="help-block">${loginmember.account}</p>
              
                                             </div>  
                                             <div class="form-group">
                                              <label>姓名</label>
                                            <input class="form-control"  >
                                            <p class="help-block">必填</p>
                                        </div>
                                         <div class="form-group">
                                            <label>地址</label>
                                            <input class="form-control">
                                            <p class="help-block">必填</p>
                                         
                                        </div>
                                        <div class="form-group">
                                            <label>E-MAIL</label>
                                            <input class="form-control" placeholder="Enter text">
                                             <p class="help-block">必填</p>
                                        </div>
                                        <div class="form-group">
                                            <label>連絡電話</label>
                                              <input class="form-control" placeholder="Enter text">
                                              <p class="help-block">必填</p>
                                        </div>
                                        
                                           <div class="form-group">
                                            <label></label>
                                              <input class="form-control" placeholder="Enter text">
                                              <p class="help-block">必填</p>
                                        </div>
                                       
                                        </div>
                                    </form>
                                    <form role="form">
                                         
                                         
                                     </form>
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


	function bill(){
	$.ajax({
		type : "post",
		url : "/product/bill",
		
		success : function(data) {
	
	
	
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