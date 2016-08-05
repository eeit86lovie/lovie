<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.img1{
width:100px;
height:100px;
}
.row{
margin-bottom: 10px;
margin-top: 10px
}
.col-sm-10{
margin: 0px;
}

</style>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<title>會員朋友列表</title>
  <script>
      $(function () {
          $("#tabs").tabs();
      });
  </script>
  <style type="text/css">

  </style>
</head>
<body>
<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.theme.tabs.min.css" />
	<div class="container">
	<!-- 程式碼位置 利用<div col-md-12> 編排 --> 
		
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">好友列表</a></li>
    <li><a href="#tabs-2">我感興趣的對象</a></li>
    <li><a href="#tabs-3">對我感興趣的人</a></li>
  </ul>
  <div id="tabs-1" >
<div id="friendTable"></div>
			</div>
  
  <div id="tabs-2">
     <div id="interestedTable"></div>
  </div>
  
  <div id="tabs-3">
     <div id="interestingTable"></div>
  </div>
</div>
 
 
 <script type="text/javascript">
 var loginmemberId= "${loginmember.id}";
 window.onload=function() {
    	findData(loginmemberId,1,"friendTable");
    	findData(loginmemberId,2,"interestedTable");
    	findData(loginmemberId,3,"interestingTable");


	}
function findData(loginmemberId,relation,tableName){
	var tb = $("#"+tableName)
	tb.empty()
	var formData = new FormData();
	formData.append('memberId',loginmemberId);
	formData.append('relation', relation);
	$.ajax({
		type: 'post',
		data: formData,
		url:"${pageContext.request.contextPath}/member/FriendList/getFriendData",
		processData: false,
		contentType: false,
		success:function(memberBean){
			var flag = $(document.createDocumentFragment());
			$.each(memberBean,function(idx,member){	
				var img=$('<img />')
				img.addClass("img1");
				img.attr('src',"${pageContext.request.contextPath}/photo/member/"+member.id)
				var imgs=$("<a href></a>")
				imgs.attr('href',"${pageContext.request.contextPath}/member/profile/"+member.id)
				imgs.append(img)
				var allimg  = $("<div class='col-sm-2'></div>").append(imgs)
				var nickname  = $("<div class='col-sm-2' style='color:#EE7700'></div>").text(member.nickname)
				var city  = $("<div class='col-sm-2'></div>").text(member.city)
				var age  = $("<div class='col-sm-2'></div>").text(member.age+"歲")
				var addbutton=$("<div class='col-sm-2'></div>").append("<button>加為好友</button>")
				var intro1 = $("<span></span>").append(member.intro)
				var intro2  = $("<div class='col-sm-7'></div>").append(intro1)
				var MovieList =$("<div class='col-sm-12' style='color:#880000'></div>").text("喜歡的電影類型："+member.interestedMovieList)
				var hr =$("<div class='col-sm-12'></div>").append("<hr>")
				var row = $("<div class='row'></div>").append([allimg,nickname,city,age,addbutton,intro2,MovieList,hr])
				flag.append(row)
			})
			tb.append(flag)

		}
		})
} 

 
 </script>

	
	</div>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>