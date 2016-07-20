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
  <div class="col-md-12" style="font-weight:bold;text-align:center;">花花的個人首頁</div>
  <div class="col-md-3"><img style="border:5px solid #acd6ff;border-radius:15px;" src="http://img.ltn.com.tw/Upload/liveNews/BigPic/600_phpldz4Sk.png" style="width:80%"> </div>
  <div class="col-md-9" ></div>
  <div class="col-md-9" ><b class="memberColumn" id="nickName">暱稱：</b></div>
  <div class="col-md-9" ><b class="memberColumn">年齡：</b>2歲</div>
  <div class="col-md-9" ><b class="memberColumn">性別：</b>男</div>
  <div class="col-md-9" ><b class="memberColumn">星座：</b>雙子座</div>
  <div class="col-md-9" ><b class="memberColumn">所在地：</b>台中市 西屯區</div>
  <div class="col-md-9" ><b class="memberColumn">好友數：</b>13</div>
  <div class="col-md-9" ><b class="memberColumn">會員等級：</b>鑽石會員</div>
  <div class="col-md-9" ><b class="memberColumn">會員發文總數：</b>123篇</div>
  <div class="col-md-12" > </div>
  <div class="col-md-12" ><b class="memberColumn">自我介紹：</b></div>
  <div class="col-md-1" ></div>
  <div class="col-md-9" >我目前住在高雄市苓雅區，職業是其他，興趣是喜劇片, 科幻片, 恐怖片,國語流行, 台語歌曲, 懷念老歌,旅遊休閒, 愛情小說, 電影音樂, 其他，想在公寓找到談心好友。如果有興趣跟我交朋友就來留言給我吧！歡迎與我聯絡喔！</div>
  <div class="col-md-2" ></div>
  <div class="col-md-12" ><b class="memberColumn">喜歡的電影類型：</b>喜劇|奇幻|驚悚</div>
  <div class="col-md-12" ></div>
 <div class="col-md-2" style="font-size:20%;color:black">註冊日期：</div>
 <div class="col-md-7"></div>
 <div class="col-md-3" style="font-size:20%;color:black">上次上站：</div>

 
 </form>
 </div>
</div>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
<script>
var LoginMember="${LoginOK.account}"
var nickname="${LoginOK.nickname}"
	window.onload=function() {
	
}
</script>


</body>
</html>