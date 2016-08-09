<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<title>Lovie 客服中心</title>
</head>
<body>
<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
	
	<div class="container">



	 <input type="button"  onclick="location.href='http://localhost:8080/Lovie/custservice/KF-FAQ.jsp'" value="常見問題FAQ" style="width:300px;height:100px;margin-left:300px;margin-top:50px ;font-size:40px;font-weight:700" /><span>
     <input type="button" onclick="location.href='http://localhost:8080/Lovie/custservice/custServiceForm'" value="問題回報線上表單" style="width:300px;height:100px;margin-left:300px;margin-top:100px;font-size:30px;font-weight:600" />
     <input type="button" onclick="location.href='http://localhost:8080/Lovie/custservice/KF-chat.jsp'" value="線上客服" style="width:300px;height:100px;margin-left:300px;margin-top:100px;font-size:50px;font-weight:700"  /></span>
		
			
	</div>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>