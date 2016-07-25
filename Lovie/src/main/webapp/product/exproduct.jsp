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

.background{
line-height:
text-align:center;


}

.everymonth{
font-size:XX-large;
line-height:20px;
border:1px solid black;
text-align: center;
height: 50px;
background:yellow;
}

.slide-image{
display:block;
margin: auto;
width:1000px;
height:1000px;
max-width:000px;
max-height:3000px;
}

.thumbnail img{
width:180px;
height:180px;

}




</style>



<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
</head>
<body>

 
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead"></p>
                <div class="list-group">
                    <a href="product/memberproduct.jsp" class="list-group-item">購買會員</a>
                    <a href="product/movieproduct.jsp" class="list-group-item">電影週邊商品</a>
                    <a href="product/bill.jsp" class="list-group-item">訂單查詢</a>
                    <a href="product/.jsp" class="list-group-item">我的最愛</a>
                    <a href="#" class="list-group-item">回報問題</a>
                </div>
            </div>

            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="/Lovie/cart/images0.jpg" alt="">
										
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="/Lovie/cart/images1.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="/Lovie/cart/images2.jpg" alt="">
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

<div class="everymonth">
<div class="background">
<h1>每月折扣商品</h1>
</div>
</div>
                <div class="row">
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="/Lovie/cart/images000.jpg" alt="">
                            <div class="caption">
                                <h4 class="pull-right">$94</h4>
                                <h4><a >黃金會員</a>
                                </h4>
                                <p></p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">18 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>


                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="/Lovie/cart/images01.jpg" alt="">
                            <div class="caption">
                                <h4 class="pull-right">$64</h4>
                                <h4><a>鋼鐵人公仔</a>
                                </h4>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">12 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="/Lovie/cart/images02.jpg" alt="">
                            <div class="caption">
                                <h4 class="pull-right">$74</h4>
                                <h4><a>美國隊長海報</a>
                                </h4>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">31 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">

							<img src="/Lovie/cart/images001.jpg" alt="">
                            <div class="caption">
                                <h4 class="pull-right">$94</h4>
                                <h4><a>白金會員</a>
                                </h4>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">18 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="/Lovie/cart/images003.jpg" alt="">
                            <div class="caption">
                            <h4 class="pull-right">$14</h4>
                                <h4>蜘蛛人公仔</h4>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">6 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="/Lovie/cart/images04.jpg" alt="">
                            <div class="caption">
                                <h4 class="pull-right">$94</h4>
                                <h4><a>ID4海報</a>
                                </h4>
 
                            </div>
                            <div class="ratings">
                                <p class="pull-right">18 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                 
                </div>

            </div>

        </div>

    </div>
    









</body>
   <c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>              
</html>