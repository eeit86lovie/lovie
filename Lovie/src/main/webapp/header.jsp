<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" %>
<%@ page import ="com.kidscodetw.eeit.security.SecurityContextImple" %>
				
<header>


	<div class="nav-top" >

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
					<li><a href=<c:url value="/interests"/>>感興趣</a></li>
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
				</div>
				</sec:authorize>
				
				
				
				
				<sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_GOLD') or hasRole('ROLE_USER')">
				
				
					<div class="member_nav" style="float:right">
						<div>
							<a href='/member/${loginmember.id}'> <img src=photo/member/${loginmember.id} height="40" /></a>
							<a href="<c:url value='logout' />" >登出</a>
						</div>
					</div>
					
				</sec:authorize>
				
				
				
				
			</div>
		</div>
		</nav>
		
	</div>
	
	</header>
	