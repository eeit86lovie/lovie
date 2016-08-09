<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="../meta.jsp"></c:import>
<style type="text/css">
td{
	min-width: 30px;
	max-width: 400px;
	overflow: hidden;
	 white-space:nowrap;
	 overflow:hidden;
	 text-overflow: ellipsis;
}
th{
min-width: 50px;
}
.search-box {
  font-size: 13px;
  width: 120px;
  background: #E6E6E6 url('http://www.davidpai.tw/wp-content/uploads/2012/04/search.gif') no-repeat 3px 3px;
  padding: 3px 3px 3px 22px;
}
</style>
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
<!-- 			<hr> -->
			<div class="row">
				<div class="col-md-12">
					<div class="panel-heading">會員資料列表</div>
					<div class="panel-heading" style="float:left;" >ID查詢：<input id="searchId" type="text" class='search-box' name="search-box" />
					<button onclick='searchId()'>查詢</button>
					</div>
					
					<div class="panel-heading" style="float:left;">帳號查詢：<input id="searchAccount" type="text" class='search-box' name="search-box" />
					<button onclick='searchAccount()'>查詢</button>
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<table class="table table-striped table-bordered table-hover"
								id="membertable" "style='table-layout: fixed'";>
								<thead>
									<tr>
										<th >權限</th>
										<th >ID</th>
										<th style="min-width:100px">會員帳號</th>
										<th >綽號</th>
										<th>性別</th>
										<th>信箱</th>
										<th style="min-width:75px">城市</th>
										<th style="min-width:75px">區域</th>
										<th>電話</th>
										<th>生日</th>
										<th style="min-width:100px">自我介紹</th>
										<th style="min-width:100px">註冊日期</th>
										<th style="min-width:130px">上次上站日期</th>
										<th style="min-width:100px">權限到期日</th>
										<th style="min-width:100px">上站次數</th>
									</tr>
								</thead>
								<tbody>				
			
								</tbody>
							</table>
						</div>
					</div>



				</div>
			</div>


	</div>
</div>
<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>


<!-- ****************************************************************************************** -->
<script>
var tb = $("#membertable>tbody")
tb.empty()
$.ajax({
	url : "${pageContext.request.contextPath}/admin/member/getMembers",
	type : "post",
	processData: false,
	contentType: false,
	success : function(memberBeanList) {
		var flag = $(document.createDocumentFragment())

		$.each(memberBeanList,function(idx,member){	
			if(member.gender==0){
				member.gender="女"
			}else{
				member.gender="男"
			}
			var cell1  = $("<td style='width:10px'></td>").text(member.privilege)
			var cell2  = $("<td></td>").text(member.id)
			var cell3  = $("<td></td>").text(member.account)
			var cell4  = $("<td></td>").text(member.nickname)
			var cell5  = $("<td></td>").text(member.gender)
			var cell6  = $("<td></td>").text(member.email)
			var cell7  = $("<td></td>").text(member.city)
			var cell8  = $("<td></td>").text(member.district)
			var cell9  = $("<td></td>").text(member.phone)
			var cell10  = $("<td></td>").text(member.birthday)
			var cell11  = $("<td onclick='allIntro(this)'></td>").text(member.intro)
			var cell12 = $("<td></td>").text(member.registeredTime)
			var cell13 = $("<td></td>").text(member.lastOnTime)
			var cell14 = $("<td></td>").text(member.privilegeExp)
			var cell15  = $("<td></td>").text(member.loginTimes)

			var row = $("<tr></tr>").append([cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15])
			flag.append(row);
		})
		tb.append(flag)
	},error: function(){
		alert("失敗")
	}					
})

function allIntro(object){
	alert(object.innerHTML.replace(/<br>/gi,"\n"))
}

function searchId(){
	tb.empty()
	var id = document.getElementById("searchId").value;
	var formData = new FormData();
	formData.append('memberId',id);
	$.ajax({
		url : "${pageContext.request.contextPath}/admin/member/getMemberFormId",
		type : "post",
		data:formData,
		processData: false,
		contentType: false,
		success : function(member) {
			var flag = $(document.createDocumentFragment())
				if(member.gender==0){
					member.gender="女"
				}else{
					member.gender="男"
				}
				var cell1  = $("<td style='width:10px'></td>").text(member.privilege)
				var cell2  = $("<td></td>").text(member.id)
				var cell3  = $("<td></td>").text(member.account)
				var cell4  = $("<td></td>").text(member.nickname)
				var cell5  = $("<td></td>").text(member.gender)
				var cell6  = $("<td></td>").text(member.email)
				var cell7  = $("<td></td>").text(member.city)
				var cell8  = $("<td></td>").text(member.district)
				var cell9  = $("<td></td>").text(member.phone)
				var cell10  = $("<td></td>").text(member.birthday)
				var cell11  = $("<td onclick='allIntro(this)'></td>").text(member.intro)
				var cell12 = $("<td></td>").text(member.registeredTime)
				var cell13 = $("<td></td>").text(member.lastOnTime)
				var cell14 = $("<td></td>").text(member.privilegeExp)
				var cell15  = $("<td></td>").text(member.loginTimes)

				var row = $("<tr></tr>").append([cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15])
				flag.append(row);
			tb.append(flag)
		},error: function(){
			alert("失敗")
		}					
	})
}
function searchAccount(){
	tb.empty()
	var account = document.getElementById("searchAccount").value;
	var formData = new FormData();
	formData.append('memberAccount',account);
	$.ajax({
		url : "${pageContext.request.contextPath}/admin/member/getMemberFormAccount",
		type : "post",
		data:formData,
		processData: false,
		contentType: false,
		success : function(member) {
			var flag = $(document.createDocumentFragment())
				if(member.gender==0){
					member.gender="女"
				}else{
					member.gender="男"
				}
				var cell1  = $("<td style='width:10px'></td>").text(member.privilege)
				var cell2  = $("<td></td>").text(member.id)
				var cell3  = $("<td></td>").text(member.account)
				var cell4  = $("<td></td>").text(member.nickname)
				var cell5  = $("<td></td>").text(member.gender)
				var cell6  = $("<td></td>").text(member.email)
				var cell7  = $("<td></td>").text(member.city)
				var cell8  = $("<td></td>").text(member.district)
				var cell9  = $("<td></td>").text(member.phone)
				var cell10  = $("<td></td>").text(member.birthday)
				var cell11  = $("<td onclick='allIntro(this)'></td>").text(member.intro)
				var cell12 = $("<td></td>").text(member.registeredTime)
				var cell13 = $("<td></td>").text(member.lastOnTime)
				var cell14 = $("<td></td>").text(member.privilegeExp)
				var cell15  = $("<td></td>").text(member.loginTimes)

				var row = $("<tr></tr>").append([cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15])
				flag.append(row);
			tb.append(flag)
		},error: function(){
			$.ajax({
				url : "${pageContext.request.contextPath}/admin/member/getMembers",
				type : "post",
				processData: false,
				contentType: false,
				success : function(memberBeanList) {
					var flag = $(document.createDocumentFragment())

					$.each(memberBeanList,function(idx,member){	
						if(member.gender==0){
							member.gender="女"
						}else{
							member.gender="男"
						}
						var cell1  = $("<td style='width:10px'></td>").text(member.privilege)
						var cell2  = $("<td></td>").text(member.id)
						var cell3  = $("<td></td>").text(member.account)
						var cell4  = $("<td></td>").text(member.nickname)
						var cell5  = $("<td></td>").text(member.gender)
						var cell6  = $("<td></td>").text(member.email)
						var cell7  = $("<td></td>").text(member.city)
						var cell8  = $("<td></td>").text(member.district)
						var cell9  = $("<td></td>").text(member.phone)
						var cell10  = $("<td></td>").text(member.birthday)
						var cell11  = $("<td onclick='allIntro(this)'></td>").text(member.intro)
						var cell12 = $("<td></td>").text(member.registeredTime)
						var cell13 = $("<td></td>").text(member.lastOnTime)
						var cell14 = $("<td></td>").text(member.privilegeExp)
						var cell15  = $("<td></td>").text(member.loginTimes)

						var row = $("<tr></tr>").append([cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15])
						flag.append(row);
					})
					tb.append(flag)
				},error: function(){
					alert("失敗")
				}					
			})
		}					
	})
}
</script>		

</body>
</html>
