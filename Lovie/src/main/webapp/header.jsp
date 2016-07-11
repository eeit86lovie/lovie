<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" %>
<header>


	<div class="nav-top" >

		<a href="${pageContext.request.contextPath}/index.jsp"><img id="logo" height="60" src="./image/icon/logo.png"></a>

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
					<li><a href="appointments.do">約會</a></li>
					<li><a href="movies.mvc">電影</a></li>
					<li><a href="theaters.mvc">戲院</a></li>
					<li><a href="member.do">會員</a></li>
					<li><a href="forum.do">討論</a></li>
					<li><a href="interest.do">感興趣</a></li>
				</ul>
				
				<sec:authorize access="!hasRole('ROLE_ADMIN') or !hasRole('ROLE_GOLD') or !hasRole('ROLE_USER')">
				<div class="member_nav">
					<div id="regbar">
					    <div id="navthing">
					      <h2><a href="#" id="loginform">登入</a> | <a href="#">註冊</a></h2>
					    	<div class="login">
					      <div class="formholder">
					        <div class="randompad">
					           <fieldset>
					             <label name="account">帳號</label>
					             <div id="account_error" style="color:red;"></div>
					             <input id="login_account" type="input" placeholder="username" />
					             <label name="password">密碼</label>
					             <div id="password_error" style="color:red;"></div>
					             <input id="login_password" type="password" placeholder="password" />
					             <input id="login_submit" onclick="login()" type="submit" value="登入" />
					             <div id="login_error" style="color:red;"></div>
					 
					           </fieldset>
					        </div>
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
	