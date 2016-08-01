<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" %>
<%@ page import ="com.kidscodetw.eeit.security.SecurityContextImple" %>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  <script src="${pageContext.request.contextPath }/css/sweetalert/dist/sweetalert.min.js"></script> 
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sweetalert/dist/sweetalert.css">
<style>
a{
    text-decoration:none;
}
</style>

<header>


	<div id="navtop" class="nav-top" style="width:80%;margin: auto;">

		<a href="${pageContext.request.contextPath}/index.jsp"><img id="logo" height="60" src="${pageContext.request.contextPath}/image/icon/logo.png"></a>

	</div>
	<div id="nav" class="navbar navbar-inverse" role="navigation">
		<nav >
		<div class="container" >

			<div class="navbar-header" >
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"></a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href=<c:url value="/index.jsp"/>>首頁</a></li>
					<li><a href=<c:url value="/appointments"/>>約會</a></li>
					<li><a href=<c:url value="/movies"/>>電影</a></li>
					<li><a href=<c:url value="/theaters"/>>戲院</a></li>
					<li><a href=<c:url value="/members"/>>會員</a></li>
					<li><a href=<c:url value="/forums"/>>討論</a></li>
				</ul>
				
				<sec:authorize access="!hasRole('ROLE_ADMIN') and !hasRole('ROLE_GOLD') and !hasRole('ROLE_USER')">
				<div class="member_nav">
					<div id="regbar">
					    <div id="navthing">
					      <h2><a href="#" id="loginform">登入</a> | <a href="#">註冊</a></h2>
					    	<div class="login">
					      <div class="formholder">
					        <div class="randompad">
							<c:if test="${not empty error}">
								<div class="error">${error}</div>
							</c:if>
							<c:if test="${not empty msg}">
								<div class="msg">${msg}</div>
							</c:if>
							<form name='loginForm'
		 					 action="<c:url value='j_spring_security_check' />" method="post">
					
							   <table>
								<tr>
									<td>帳號:</td>
									<td><input id="login_account" placeholder="username" type='input' name='username' value=''></td>
								</tr>
								<tr>
									<td>密碼:</td>
									<td><input id="login_password" type='password'  placeholder="password" name='password' /></td>
								</tr>
								<tr>
									<td colspan='2'><input id="login_submit" name="submit" type="submit"
										value="登入" /></td>
								</tr>
							  </table>
					
							   <input type="hidden" 
					                     name="${_csrf.parameterName}" value="${_csrf.token}" />
							</form>
					      </div>
					    </div>
					    </div>
  					</div>
				</div></div>
				</sec:authorize>
				
				
				
				
				<sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_GOLD') or hasRole('ROLE_USER')">
				
				
					<div class="member_nav" style="float:right">
						<div>
							 <div id="memberPic" >
							 <img src=${pageContext.request.contextPath}/photo/member/${loginmember.id} height="40" />

								<ul id="menu" style="display:none;position:absolute;z-index:1;">
									<li><div><a href='${pageContext.request.contextPath}/member/profile/${loginmember.id}'>個人首頁</a></div></li>
									<li><div>我的朋友</div></li>
									<li><div>有興趣的對象</div></li>
									<li><div>我的邀請</div></li>
									<li><div>我的請求</div></li>
									<li><div>訊息通知</div></li>
									<li><div><a href="${pageContext.request.contextPath}/chat/" target="_blank">聊天</a></div></li>
									<sec:authorize access="hasRole('ADMIN')">
									<li id="backstage" style="display: none"><div>
									<a href='${pageContext.request.contextPath}/admin/index.jsp'>管理頁面</a>
									</div></li>
									</sec:authorize>

									</ul>
								</div>
								<a href='${pageContext.request.contextPath }/logout'>登出</a>
						</div>
					</div>
					
				</sec:authorize>
				
				
				
				
			</div>
		</div>
		</nav>
		
	</div>
	<script>
		$("#memberPic").hover(function() {
			document.getElementById("menu").style.display = "block";
		}, function() {
			document.getElementById("menu").style.display = "none";
		})
	$(function() {
		$("#menu").menu();
	});
	var privilege="${loginmember.privilege}"
	if(privilege==3){
		document.getElementById("backstage").style.display = "block";
	}
	</script>
	</header>
	