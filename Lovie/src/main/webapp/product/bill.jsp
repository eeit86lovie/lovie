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
	<div id="page-wrapper">
<div class="col-lg-9">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                                                                    購買商品
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table id="ShoppingCart"class="table">
                                    <thead>
                                        <tr>
                                          
                                            <th>產品編號</th>
                                            <th>產品名稱</th>
                                            <th>產品樣式</th>
                                            <th>產品內容</th>
                                            <th>產品折扣</th>
                                            <th>產品價格</th>
                                             <th>數量</th>
                                             <th>小計</th>
                                 
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${addcartlist}" var="addtocart" varStatus="loop">
                                    		
                                           <tr id="Cart${addtocart.bean.productid}" data-cost="${addtocart.bean.cost*addtocart.amount}" class="success">
                                             <td>${addtocart.bean.productid}</td>
                                             <td>${addtocart.bean.name}</td>
                                             <td>${addtocart.bean.productphoto}</td>
                                             <td>${addtocart.bean.content}</td>
                                             <td>${addtocart.bean.discount}</td>
                                             <td>${addtocart.bean.cost}</td>
                                             <td>${addtocart.amount}</td>
                                             <td>${addtocart.bean.cost*addtocart.amount}</td>
                                            <c:if test="${loop.last}">
                                    		<script>
                                    		var itemAmount = ${loop.count}
                                    		</script>
                                    		</c:if>
                                    		
                                     </tr>
                                    </c:forEach>
                                   
                                         
                                    </tbody>
                                    
                                    
                                </table>
                                <div>
                          
                                </div>
                            </div>
                                  <div class="alert alert-warning">
                                          <tr >
                                             <th>總金額</th>
                                            <th id="allMoney">${param.allcost}</th>
                                         </tr> 
                                  </div>
                            </div>
                            </div>

                        </div>
                      
           <div class="col-lg-9">
			<div class="panel panel-default">
				<div class="panel-heading">　</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form role="form" action="${pageContext.request.contextPath }/billCheckout" method="post">
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
										<label  for="idName">姓名</label>: 
										<input  type="text" id="idName" required placeholder="請輸入姓名" name="username"/><span id="idsp1"></span>
									</div>
									<span>必填(不可空白，至少兩個字且必須為中文字)</span>
								</div>
								<div class="form-group">
									<div class="st1">
										<label for="idAddress">地址</label> 
										<input class="" type="text" id="idAddress" required placeholder="請輸入地址" name="address"/><span id="idsp2"> </span> <br>
										<span>必填(不可空白，至少兩個字且必須為中文字)</span></br>
									</div>
								</div>
								<div class="form-group">
									<label for="idMail">E-MAIL</label> <input class="" type="text"
										id="idMail" required placeholder="請輸入E-MAIL" name="mail"/><span
										id="idsp3"> </span> <br>
									<span>(不可空白，不包含中文，至少6個字且必須包含英文字母、數字、特殊字元[!@#$%^&*]</span></br>

								</div>
								<div class="form-group">
									<label for="idPhone">連絡電話</label> <input class="" type="text" id="idPhone" required placeholder="請輸入電話" name="phone"/><span id="idsp3"> </span> <br>
									<span>(不可空白)<span>
											</br>
								</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
									<label for="idCard">信用卡號</label>
									<img src="${pageContext.request.contextPath}/src/main/webapp/image/product/visa.jpg"></img>
									<input class="" type="text" id="idCard" required placeholder="請輸入卡號"  name="card"/><span id="idsp4"> </span> <br>
									<span>(不可空白)</span></br>

								</div>

						</div>
						 
						 <Input type="submit" class="btn btn-primary btn-lg btn-block" ></Input>
						 
					</form>
					
					</div>
					<div>
                           
                      </div>
				</div>
			</div>
	
			</div>

		</div>
		
	

	<script>
 

				function chkName(){
				var theName=document.getElementById("idName").value;
				re = /^[\u4E00-\u9FA5]{2,}$/;
				if(re.test(theName))
				alert("OK");
				else
				alert("錯誤");
				}
				function chkAddress(){
				var theAddress=document.getElementById("idAddress").value;
				re=/^[\u4E00-\u9FA5]{2,}$/;
				if(re.test(theAddress))	
				alert("OK");
				else
			    alert("錯誤");	
				}
				function chkMail(){
				var theMail=document.getElementById("idMail").value;
				re=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;
				if(re.test(theMail))	
				alert("OK");	
				else
		        alert("錯誤");
				}
				function chkPhone(){
					var thePhone=document.getElementById("idPhone").value;
					re=/^09\d{2}-?\d{3}-?\d{3}$/;
					if(re.test(thePhone))
					alert("OK");
					else
				    alert("錯誤");	
					}	
				function chkCard(){
					var theCard=document.getElementById("idCard").value;
					
				
		
				


							
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