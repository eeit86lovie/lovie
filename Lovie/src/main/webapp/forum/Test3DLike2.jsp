<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/selectLike/selectLike.css">
<script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.hoverCarousel.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">




</style>
</head>
<body>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">☰ open</span>

 <li><img src="${pageContext.request.contextPath}/image/2.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>
      <li><img src="${pageContext.request.contextPath}/image/3.jpg"/></li>


<div id="myNav" class="overlay">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
  <div class="carousel right">
  <div class="indicator"></div>
  <div class="wrap">
    <ul>
          
    </ul>
  </div>
</div>
  </div>
</div>







<script>
function openNav() {
    document.getElementById("myNav").style.height = "40%";
}
function closeNav() {
    document.getElementById("myNav").style.height = "0%";
}

	

</script>

</body>
</html>