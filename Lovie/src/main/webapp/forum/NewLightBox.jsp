<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.leanModal.min.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lightbox.css" />


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<a id="modal_trigger" href="#modal" class="btn">Click here to Login or register</a>

<div id="modal" class="popupContainer" style="display:none;">
	<header class="popupHeader">
		<span class="header_title">Login</span>
		
	</header>

    <section class="popupBody">
    
      <div class="user_login">
    <form>
        <label>Email / Username</label> <input type="text"><br>
        <label>Password</label> <input type="password"><br>

        <div class="checkbox">
            <input id="remember" type="checkbox"> <label for=
            "remember">Remember me on this computer</label>
        </div>

        <div class="action_btns">
            <div class="one_half">
                <a class="btn back_btn" href="#">Back</a>
            </div>

            <div class="one_half last">
                
                <div class="center"><input class="btn btn_red" type="button" name="loginbtn" id="loginbtn"   value="發文" ></div>
            </div>
        </div>
    </form>
    
    
</div>
   
</div>
    </section>
</div>

<script>
$("#modal_trigger").leanModal({top : 200, overlay : 0.6, closeButton: ".btn btn_red"});

</script>


</body>
</html>