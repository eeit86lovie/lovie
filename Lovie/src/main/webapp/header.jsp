<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" %>
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
					<li><a href="index.jsp">首頁</a></li>
					<li><a href="appointments">約會</a></li>
					<li><a href="movies">電影</a></li>
					<li><a href="theaters">戲院</a></li>
					<li><a href="members">會員</a></li>
					<li><a href="forums">討論</a></li>
					<li><a href="interests">感興趣</a></li>
				</ul>
				
				<sec:authorize access="!hasRole('ROLE_ADMIN') or !hasRole('ROLE_GOLD') or !hasRole('ROLE_USER')">
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
									<td>User:</td>
									<td><input type='text' name='username' value=''></td>
								</tr>
								<tr>
									<td>Password:</td>
									<td><input type='password' name='password' /></td>
								</tr>
								<tr>
									<td colspan='2'><input name="submit" type="submit"
										value="submit" /></td>
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
							<img width="20" src="${LoginOK.photoUrl }">${LoginOK.account }
						</div>
						
						<div>
							<a href="logout.do">登出</a>
						</div>
					</div>
					
				</sec:authorize>
				
				
				
				
			</div>
		</div>
		</nav>
		
	</div>
	
	</header>
	