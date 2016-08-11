<%@page pageEncoding="UTF-8" %>

<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="${pageContext.request.contextPath}/admin/index.jsp">Lovie Admin</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">
		
			
		
		
		<!-- /.dropdown -->
		<li class="dropdown"><a class="dropdown-toggle"
			 href="${pageContext.request.contextPath }/index.jsp"> <i class="fa fa-home fa-fw"></i>
				
		</a>
			
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control" placeholder="Search...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div> <!-- /input-group -->
				</li>
				<li><a href="index.jsp"><i class="fa fa-windows fa-fw"></i> 
					控制台 <span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="${pageContext.request.contextPath}/admin/report/chart.jsp">會員資料分析圖</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/report/report.jsp">會員明細表</a></li>
					</ul>
				</li>
				<li><a href="${pageContext.request.contextPath}/admin/appointment/admin_appointment.jsp"><i class="fa fa-heart fa-fw"></i> 約會</a></li>
				<li><a href="#"><i class="fa fa-film fa-fw"></i> 電影<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="${pageContext.request.contextPath}/admin/movie/movie.do">電影管理</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/movie/theater.do">戲院管理</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/movie/showtime.do">電影時刻表管理</a></li>
					</ul> <!-- /.nav-second-level --></li>
				<li><a href="#"><i class="fa fa-user fa-fw"></i> 會員<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="${pageContext.request.contextPath}/admin/member/admin_members.jsp">會員管理</a></li>
					</ul></li>
				<li><a href="pages/forms.html"><i class="fa fa-edit fa-fw"></i>
						討論區<span class="fa arrow"></a>
					<ul class="nav nav-second-level">
						<li><a href="${pageContext.request.contextPath}/admin/forum/admin_forum.jsp">討論區管理</a></li>
					</ul></li>
				<li><a href="${pageContext.request.contextPath}/admin/bill"><i class="fa fa-credit-card fa-fw"></i> 訂單</span></a>
					<!-- /.nav-second-level --></li>
				<li><a href="pages/forms.html"><i class="fa fa-microphone fa-fw"></i>
						廣播<span class="fa arrow"></a>
					<ul class="nav nav-second-level">
						<li><a href="${pageContext.request.contextPath}/admin/broadcast/broadcastAll">使用者群組廣播</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/broadcast/broadcastOne">特定使用者廣播</a></li>
					</ul></li>
					
					<li><a href="pages/forms.html"><i class="fa fa-microphone fa-fw"></i>
						客服<span class="fa arrow"></a>
					<ul class="nav nav-second-level">
						<li><a href="${pageContext.request.contextPath}/admin/custService/admin_custservice.jsp">問題查看</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>