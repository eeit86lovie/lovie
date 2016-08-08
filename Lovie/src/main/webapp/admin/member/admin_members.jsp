<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="../meta.jsp"></c:import>
</head>
<body>
<div id="wrapper">
<c:import charEncoding="UTF-8" url="../nav.jsp"></c:import>
	<div id="page-wrapper">
				<div class="row">
				<div class="col-md-4">
					<h2 class="">討論區管理</h2>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-10">
					<div id="crawloutput"></div>
				</div>
				<div class="col-md-2">
					
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">
					<div class="panel-heading">被檢舉文章</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="movietable">
								<thead>
									<tr>
										<th>權限</th>
										<th>ID</th>
										<th>會員</th>
										<th>綽號</th>
										<th>性別</th>
										<th>email</th>
										<th>城市</th>
										<th>區域</th>
										<th>電話</th>
										<th>區域</th>
										<th>區域</th>
									</tr>
								</thead>
								<tbody id="forum_tbody">				
																	
								</tbody>
							</table>
						</div>
					</div>



				</div>
			</div>


	</div>
</div>
<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
</body>
</html>
