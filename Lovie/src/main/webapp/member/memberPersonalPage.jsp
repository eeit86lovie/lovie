<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.row {
	border: #CC0000 1px dotted;
	border-radius: 15px;
	margin: 15px;
	padding: 10px;
	width:90%;
}
.memberColumn{
color:#CC6600
}
</style>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>



<title>會員個人頁面</title>

</head>
<body>
<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
<div class="container">
<div class="row" >

<form>
  <div class="col-md-12" style="font-weight:bold;text-align:center;">${oneMember.nickname}的個人首頁</div>
  <div class="col-md-3"><img style="border:5px solid #acd6ff;border-radius:15px;" src="${oneMember.photoUrl}" style="width:80%"> </div>
  <div class="col-md-9" ></div>
  <div class="col-md-9" ><b class="memberColumn" id="nickName">暱稱：</b>${oneMember.nickname}</div>
  <div class="col-md-9" ><b class="memberColumn">年齡：</b>${oneMember.birthday}</div>
  <div class="col-md-9" ><b class="memberColumn">性別：</b>${oneMember.gender}</div>
  <div class="col-md-9" ><b class="memberColumn">星座：</b>${constellation}</div>
  <div class="col-md-9" ><b class="memberColumn">所在地：</b>${oneMember.city} ${oneMember.district}</div>
  <div class="col-md-9" ><b class="memberColumn">好友數：</b>${oneMember.friendNum}</div>
  <div class="col-md-9" ><b class="memberColumn">會員等級：</b>鑽石會員</div>
  <div class="col-md-9" ><b class="memberColumn">會員發文總數：</b>${article}</div>
  <div class="col-md-12" > </div>
  <div class="col-md-12" ><b class="memberColumn">自我介紹：</b></div>
  <div class="col-md-1" ></div>
  <div class="col-md-9" >${oneMember.intro}</div>
  <div class="col-md-2" ></div>
  <div class="col-md-12" ><b class="memberColumn">喜歡的電影類型：</b>喜劇|奇幻|驚悚</div>
  <div class="col-md-12" ><br></div>
 <div class="col-md-5" style="font-size:20%;color:black">註冊日期：${member.registeredTime}</div>
 <div class="col-md-3"></div>
 <div class="col-md-4" style="font-size:20%;color:black">上次上站：${member.lastOnTime}</div>

 
 </form>
 </div>
</div>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
<script>

window.onload=function() {

	$.ajax({
	"type":"get",
	"url":"${pageContext.request.contextPath}/MemberPersonalPage/{id}",
	"dataType" : "json",
	"success":function(memberBean){
		var flag = $(document.createDocumentFragment());
		$.each(memberBean,function(idx,member){	
			var img=$('<img />')
			img.addClass("img1");
				img.attr('src',"photo/member/"+member.id)
				var cell1=$("<a herf></a>")
				cell1.attr('href','/member/MemberPersonalPage/'+member.id)
			cell1.append(img)
//				var cell1  = $("<div></div>").append(img)
			var cell2  = $("<div></div>").text(member.nickname)
			var cell3  = $("<div></div>").text(member.city)
			var cell4  = $("<div></div>").text(member.birthday+"歲")

			var row = $("<li class='item'></li>").append([cell1,cell2,cell3,cell4])
			flag.append(row);
		})
		tb.append(flag)
		
	}
	})

		}

</script>


</body>
</html>