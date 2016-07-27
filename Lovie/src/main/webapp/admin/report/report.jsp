<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<h3 class="">會員明細查詢</h3>
			</div>
		</div>
		<hr>
		<div class="row">
		<div class="col-md-12">
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form class="form-horizontal" role="form" name="form1" 
				       action="reportMemberDetail" method="post" target="_blank">
				  <fieldset>
 				  <div class="form-group"> 
				    <label class="control-label col-sm-2">會員等級:</label>
				    <div class="col-sm-10">
				    	<label class="radio-inline"><input type="radio" name="privilege" value="0" checked>全部</label>
						<label class="radio-inline"><input type="radio" name="privilege" value="1">一般會員</label>
						<label class="radio-inline"><input type="radio" name="privilege" value="2">鑽石會員</label>
						<label class="radio-inline"><input type="radio" name="privilege" value="3">管理員</label>
				    </div>
				  </div>
				  <div class="form-group"> 
				    <label class="control-label col-sm-2" >性別:</label>
				    <div class="col-sm-10">
				    	<label class="radio-inline"><input type="radio" name="gender" value="3" checked>全部</label>
						<label class="radio-inline"><input type="radio" name="gender" value="0">女會員</label>
						<label class="radio-inline"><input type="radio" name="gender" value="1">男會員</label>
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-2" for="lastOnTime">最後登入日 < </label>
				    <div class="col-sm-5"> 
				    	<input type="text" class="form-control" id="lastOnTime" name="lastOnTime" placeholder="會員最後登入日在選擇日期之前" readonly>
				    </div>
				  </div>
				  <div class="form-group"> 
				  <div class="col-sm-offset-2 col-sm-10">
				  <div class="btn-group" role="group" aria-label="...">
				      <button type="button" class="btn btn-primary" 
				      	onClick="form1.submit();">查询</button>
				      <button type="reset" class="btn btn-default">清除</button>
				  </div>
				  </div>
				  </fieldset>
				</form>
			</div>
		</div>
		</div>
	</div>
</div>
<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
<!--  為了用 datapicker..才引用的js -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
		<script type="text/javascript">
            $(function () {
                $('#lastOnTime').datepicker({ dateFormat: "yy-mm-dd" });
            });
        </script>
</body>

</html>
