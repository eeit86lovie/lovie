<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入</title>
<script src="http://s.codepen.io/assets/libs/modernizr.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="css/reset.css">
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="css/styleForLogin.css">

<style>

.logintop{

	text-align: center;
	margin-top:100px;
}
.loginfooter{

	float:right;
	margin-top:25%;
	font-size: 14px;
}

.loginfooter a{
	font-style: normal;
	color:blue;
	text-decoration: none;
}


.loginfooter a:visited{
	font-style: normal;
	color:blue;
	text-decoration: none;
}

</style>
</head>
<body>

<div class="logintop">
	<a href="${pageContext.request.contextPath}/index.jsp"><img id="logo" height="60" src="${pageContext.request.contextPath}/image/icon/logo.png"></a>
</div>
<div class="login">
	<form 
		action="<c:url value='j_spring_security_check' />" method="post">
		<fieldset>
			<legend class="legend">登入</legend>
			<div class="input">
				<input type="text" placeholder="Username" required name="username" value="${param.account}">${errors.account}
				<span><i class="fa fa-user"></i></span>
			</div>
			<div class="input">
				<input type="password" placeholder="Password" required name="password" value="${param.password}">${errors.password}
				<span><i class="fa fa-lock"></i></span>
			</div>
			<button type="submit" class="submit" value="登入">
				<i class="fa fa-long-arrow-right"></i>
			</button>
		</fieldset>
	</form>
	<div class="loginfooter">
	<a href="#">忘記密碼</a>
</div>
</div>


	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>

</body>
</html>