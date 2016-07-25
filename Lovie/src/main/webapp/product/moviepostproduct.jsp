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
.navbar-default{
 margin-top:-0.5cm;

}

.slide-image{
display:block;
margin: auto;
width:1000px;
height:1000px;
max-width:1000px;
max-height:3000px;
}

.thumbnail img{
width:180px;
height:180px;

}

.nav{
text-align:center;

}

.caption{


text-align:center;


}






</style>



<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
</head>
<body>
 
 
  <div class="row">
 
 
 <div id="wrapper">
       <div class="navbar-default sidebar">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                         <li>
                            <a href="/Lovie/product.do"><i class="my home"></i>回商城首頁 </a>
                        </li>
                        <li>
                            <a href="/Lovie/memberproduct.do?category=1"><i class="buy member"></i>購買會員 </a>
                        </li>
                        <li>
                            <a href="#"><i class=""></i> 電影週邊商品<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="/Lovie/doll.do?category=3">人物公仔</a>
                                </li>
                                <li>
                                    <a href="/Lovie/clothesproduct.do?category=4">服飾</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="tables.html"><i class="selectbill"></i>訂單查詢</a>
                        </li>
                        <li>
                            <a href="forms.html"><i class="mylove"></i>我的最愛</a>
                        </li>
                        <li>
                            <a href="#"><i class="customerservice"></i>回報客服</a>
                           
                            <!-- /.nav-second-level -->
                        </li>
                       
                       
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
       </div>
</div>

<div id="page-wrapper">
<div class="col-md-9">

<c:forEach var="moviepostproducts" items="${Allmoviepostproduct}">
<div class="col-md-4">
					<div class="thumbnail">
						<img src="../cart/images000.jpg" alt="">
						<div class="caption">
						    <p id="dollproductname">${moviepostproducts.name}</p>
						    <p id="dollmoney">NT:${moviepostproducts.cost}元</p>
				            <p id="dollproductcontent">${moviepostproducts.content}</p>
							<p>
								<a href="#" class="btn btn-primary">加入購物車</a>
							</p>

						</div>
					</div>

				</div>
</c:forEach>
</div>

</div>

<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
<table border="1">
  <tr>
    <td width='76'>
        
     </td>
     <td width='76'>
          
     </td>
     <td width='76'>
            
                <div id="pnext">
                   <a href="DisplayPageProducts?pageNo=2">下一頁</a>&nbsp;&nbsp;&nbsp;
                </div>
            
     </td>  
     <td width='76'>
            
                <div id="plast">
                    <a href="DisplayPageProducts?pageNo=5">最末頁</a>&nbsp;&nbsp;&nbsp;
                </div>
            
     </td>
     <td width='176' align="center">
           第1頁 / 共5頁
     </td>  
</tr>
</table>


  <script>





  </script>
  
</body>
   <c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>              
</html>