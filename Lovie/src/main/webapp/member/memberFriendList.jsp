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
.buttons{
	border-radius: 8px;
	background-color:#F88;
	color:white;
	border:0px;
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
	var addfriendDisplay="inline";
	var removefriendDisplay="inline";
	if(tableName=="friendTable"||tableName=="interestedTable"){
		addfriendDisplay="none";
	}else if(tableName=="interestingTable"){
		removefriendDisplay="none";
	}
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
				var img1=$("<a href></a>")
				img1.attr('href',"${pageContext.request.contextPath}/member/profile/"+member.id)
				img1.append(img)
				var img2  = $("<div class='col-sm-2'></div>").append(img1)
				var nickname  = $("<div class='col-sm-2' style='color:#EE7700'></div>").text(member.nickname)
				var city  = $("<div class='col-sm-2'></div>").text(member.city)
				var age  = $("<div class='col-sm-1'></div>").text(member.age+"歲")
				var intro = $("<span></span>").append(member.intro)
				var intro1  = $("<div class='col-sm-7'></div>").append(intro)
				var movieList =$("<div class='col-sm-8' style='color:#880000'></div>").text("喜歡的電影類型："+member.interestedMovieList)
				var hr =$("<div class='col-sm-12'></div>").append("<hr>")
				var addFriend=$("<div class='col-sm-1'><button class='buttons' style='display:"+addfriendDisplay+"' onclick='addFriend("+member.id+")' '>加為好友</button></div>")
				var removeFriend=$("<div class='col-sm-1'><button class='buttons' style='display:"+removefriendDisplay+"'>取消關注</button></div>")
				var line=$("<div class='col-sm-12'></div><div class='col-sm-8'></div>")
				var row = $("<div class='row'></div>").append([img2,nickname,city,age,intro1,movieList,line,addFriend,removeFriend,hr])
				flag.append(row)
			})
			tb.append(flag)

		}
		})
}

function addFriend(friendId){
	
}

 
 </script>

	
	</div>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>