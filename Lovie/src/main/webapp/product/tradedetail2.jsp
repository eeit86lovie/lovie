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


.btn btn-primary btn-lg{
text-align: center;

}
.panel-heading{

text-align: center;
}
alert alert-warning{

text-align: right;
}

.btn btn-primary btn-lg btn-block{
text-align:center;;

}
</style>

<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
</head>
<body>

<c:import charEncoding="UTF-8" url="/product/productMenu.jsp"></c:import>
	
	<div id="page-wrapper">
<div class="col-lg-9">
<form role="form" action="${pageContext.request.contextPath }/billCheckout" >
     <div class="panel panel-default">
                        <div class="panel-heading">
                                                  交易明細
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table id="ShoppingCart"class="table">
                                    <thead>
                                        <tr>
                                          
                                            <th>會員編號</th>
                                            <th>會員帳號</th>
                                            <th>地址</th>
                                            <th>聯絡電話</th>
                                            <th>交易日期</th>
                                            <th>產品名稱</th>
                                             <th>數量</th>
                                             <th>總價</th>
                                 
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${checkoutItems}" var="checkoutItem" >
                                    <tr>
                                           
                                             <td>${checkoutItem.memberid }</td>
                                             <td>${checkoutItem.memberaccount }</td>
                                             <td>${checkoutItem.memberaddress }</td>
                                             <td>${checkoutItem.memberphone }</td>
                                             <td>${checkoutItem.checktradeTime }</td>
                                             <td>${checkoutItem.productname }</td>
                                             <td>${checkoutItem.amount }</td>
                                             <td>${checkoutItem.totalcost }</td>
                                          
                                    		
                                     </tr>
                                    </c:forEach>
                                   
                                     
                                     	
                                     
                                    </tbody>
                                    
                                    
                                </table>
                                <div style="float:right; font-size: 18px;margin-right:8px;">
                          			總金額:${amount }
                                </div>
                            </div>
                                  
                            </div>
                  
  </div>

  </div>
  </div>
                      

	
	
	


		<script>
		
		
		
		
		
		
		
		
		
		
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