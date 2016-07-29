<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<style>
.col-lg-12 label {
	margin: 10px;
}
#div1{
	position: absolute;
	z-index: 1;
}
.col-md-3 a img{
	height: 280px;
}
.col-md-3{
	margin-bottom: 20px;
}
</style>
<title>查詢約會</title>
</head>
<body>
<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
<sec:authorize access="!hasRole('USER')">
	<div style="color:red;font-size:1.2em;">　請先登入，一般會員以上等級才可執行查詢約會功能.</div>
</sec:authorize>
<sec:authorize access="hasRole('USER')"> 
<div class="container">
<div class="row"><div class="col-md-12">
  <ul class="nav nav-tabs nav-justified">
  <li><img src="image/icon/logo.png" style="width:90px;float:right;padding-right:20px;"></img>
  <div style="color:red">會員${loginmember.id}</div>
    <li><a href="appointments">一週約會通知</a></li>
    <li><a href="appointmentb">申請的約會</a></li>
    <li class="active"><a href="appointmenta">邀請的約會</a></li>
  </ul>
  <div class="tab-content">
  <div id="menu1" class="tab-pane fade in active">
	<div class="row">
		<div class="col-md-12">
QQa
		</div>
	</div>
  </div>
  </div>
</div></div>
</div>
</sec:authorize>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>