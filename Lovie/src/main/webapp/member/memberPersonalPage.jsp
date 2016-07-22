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
	width: 90%;
}
.edit {
	border-radius: 8px;
	background-color:#ed647d;
	color:white;
	border:0px;
}

.memberColumn {
	color: #CC6600
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
  <div class="col-md-9" ><b class="memberColumn">暱稱：</b><span id="nickname" onclick="member_edit(this)">${oneMember.nickname}</span></div>
<%--   <div class="col-md-9" ><b class="memberColumn" id="nickName">暱稱：</b><input type="text" value="${oneMember.nickname}"/></div> --%>
  <div class="col-md-9" ><b class="memberColumn">年齡：</b>${memberAge}歲</div>
  <div class="col-md-9" ><b class="memberColumn">性別：</b><span id="gender" onclick="member_edit(this)">${gender}</span></div>
  <div class="col-md-9" ><b class="memberColumn">星座：</b>${oneMember.constellation}</div>
  <div class="col-md-9" ><b class="memberColumn">所在地：</b><span id="city" onclick="member_edit(this)">${oneMember.city}</span><span id="district" onclick="member_edit(this)"> ${oneMember.district}</span></div>
  <div class="col-md-9" ><b class="memberColumn">好友數：</b>${oneMember.friendNum}</div>
  <div class="col-md-9" ><b class="memberColumn">會員等級：</b>鑽石會員</div>
  <div class="col-md-9" ><b class="memberColumn">會員發文總數：</b>${article}</div>
  <div class="col-md-12" > </div>
  <div class="col-md-12" ><b class="memberColumn">自我介紹：</b></div>
  <div class="col-md-1" ></div>
  <div class="col-md-9" >${oneMember.intro}</div>
<%--   <div class="col-md-9" ><textarea cols="40" rows="5" style="width:auto;">${oneMember.intro}</textarea></div> --%>
  <div class="col-md-2" ></div>
   <div class="col-md-12" ><br></div>
  <div class="col-md-8" ><b class="memberColumn">喜歡的電影類型：</b>喜劇|奇幻|驚悚</div>
  <div class="col-md-2" ><button class="edit" id=uesrBasic style="display:none;float:right;" >編輯</button></div>
  <div class="col-md-2" ><button class="edit" id=uesrAdvanced style="display:none">進階編輯</button></div>
  <div class="col-md-12" ><br></div>
 <div class="col-md-5" style="font-size:20%;color:black">註冊日期：${oneMember.registeredTime}</div>
 <div class="col-md-3"></div>
 <div class="col-md-4" style="font-size:20%;color:black">上次上站：${oneMember.lastOnTime}</div>

 
 </form>
 </div>
</div>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
<script>


if("${loginmember.id}"=="${oneMember.id}"&&"${oneMember.id}"!=""){
	document.getElementById("uesrBasic").style.display = "block";
	document.getElementById("uesrAdvanced").style.display = "block";

function member_edit(member_col){//呼叫的member欄位物件,onclick時觸發
	var loginmemberId=${loginmember.id}
	
	var text = member_col.innerHTML;
	var editableText = $('<input type="text" value="'+text+'" " name="'+member_col.id+'" id="'+member_col.id+'"/>');
	$("#"+member_col.id).replaceWith(editableText);//把原本的span換成input
	$("#"+member_col.id).focus();//onclick時focus本欄位
	$("#"+member_col.id).blur(function(){
		var after_text = $("#"+member_col.id).val();
		alert(after_text)
		var member_id = member_col.id;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open("get", "memberEdit.do?mID="+loginmemberId+"&type="+member_id+"&value="+after_text);
		xhr.send();
		function callback() {
			if(xhr.readyState==4 && xhr.status==200){
				$("#"+col_id).replaceWith('<td id="'+member_id+'" onclick="movie_edit(this)">'+after_text+'</td>')
			}
		}
	})
	$("#"+member_col.id).keydown(function(event){
		if(event.which==13){//代表按下enter
		var after_text = $("#"+member_col.id).val();//enter之前輸入欄位的值
		var member_id = member_col.id;
// 		var pattern = /^movie(\d+)_(\w+)/;
// 		var match_id = pattern.exec(col_id);

		var mID = match_id[1];
		var type = match_id[2];
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open("get", "movieEdit.do?mID="+mID+"&type="+type+"&value="+after_text);
		xhr.send();
		}
		function callback() {
			if(xhr.readyState==4 && xhr.status==200){
				$("#"+col_id).replaceWith('<span id="'+member_id+'" onclick="member_edit(this)">'+after_text+'</span>')
			}
		}
	})
}





}



















</script>


</body>
</html>