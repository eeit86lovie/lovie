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
  <div class="col-md-12" ><br></div>
  <div class="col-md-3"><img id="blah" style="border:5px solid #acd6ff;border-radius:15px;width:100%" src="${pageContext.request.contextPath}/photo/member/${oneMember.id}"></div>
  <div class="col-md-9" ></div>
  <div class="col-md-9" ><b class="memberColumn">暱稱：</b><span id="nickname" onclick="member_edit(this)">${oneMember.nickname}</span></div>
  <div class="col-md-9" ><b class="memberColumn">年齡：</b>${memberAge}歲</div>
  <div class="col-md-9" ><b class="memberColumn">性別：</b>${gender}</div>
  <div class="col-md-9" ><b class="memberColumn">星座：</b>${oneMember.constellation}</div>
  <div class="col-md-9" ><b class="memberColumn">所在地：</b><span id="city" onclick="city_edit(this)"><span>${oneMember.city}</span>  <span>${oneMember.district}</span></span></div>
  <div class="col-md-9" ><b class="memberColumn">好友數：</b>${oneMember.friendNum}</div>
  <div class="col-md-9" ><b class="memberColumn">會員等級：</b>鑽石會員</div>
  <div class="col-md-9" ><b class="memberColumn">會員發文總數：</b>${article}</div>
  <div class="col-md-9" id="pic" style="display:none"><b class="memberColumn">頭像：</b><input id="imgInp" style="margin-top:5px;display:inline" type="file"></input></div>
  <div class="col-md-9" ><button class="edit" id=uesrPic style="margin-top:5px;display:none">確認上傳圖片</button> </div>
  <div class="col-md-12" > </div>
  <div class="col-md-12" ><b class="memberColumn">自我介紹：</b></div>
  <div class="col-md-1" ></div>
  <div class="col-md-9" ><span id="intro" onclick="member_edit(this)">${oneMember.intro}</span></div>
  <div class="col-md-2" ></div>
   <div class="col-md-12" ><br></div>
  <div class="col-md-10" ><b class="memberColumn">喜歡的電影類型：</b>喜劇|奇幻|驚悚</div>
<!--   <div class="col-md-2" ><button class="edit" id=uesrBasic style="display:none;float:right;" >編輯</button></div> -->
  <div class="col-md-2" ><button class="edit" id=uesrAdvanced style="display:none">進階編輯</button></div>
  <div class="col-md-12" ><br></div>
 <div class="col-md-5" style="font-size:20%;color:black">註冊日期：${oneMember.registeredTime}</div>
 <div class="col-md-3"></div>
 <div class="col-md-4" style="font-size:20%;color:black">上次上站：${oneMember.lastOnTime}</div>
<div class="col-md-12"></div>

 </form>
 </div>

</div>

<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>

<script src="${pageContext.request.contextPath }/js/jQuery-TWzipcode.js"></script>

<script>

if("${loginmember.id}"=="${oneMember.id}"&&"${oneMember.id}"!=""){
	document.getElementById("pic").style.display = "block";
	document.getElementById("uesrPic").style.display = "block";
	document.getElementById("uesrAdvanced").style.display = "block";
	
	function readURL(input) {
		  if (input.files && input.files[0]) {
		    var reader = new FileReader();
		    reader.onload = function (e) {
		      $('#blah').attr('src', e.target.result);
		    }
		    reader.readAsDataURL(input.files[0]);
		    
		  }
		  
		}

		$("#imgInp").change(function(){
		  readURL(this);})

function member_edit(member_col){//呼叫的member欄位物件,onclick時觸發
	
	var loginmemberId=${loginmember.id}
	var text = member_col.innerHTML.replace(/<br>/gi,"\n");
	console.log(text)
	var editableText = $('<input type="text" value="'+text+'" " name="'+member_col.id+'" id="'+member_col.id+'"/>');
	var introText=$('<textarea cols="40" rows="5" style="width:auto;"id="intro">'+text+'</textarea>')
	if(member_col.id=="intro")
		$("#"+member_col.id).replaceWith(introText);
	else 
		$("#"+member_col.id).replaceWith(editableText);//把原本的span換成input
		
	$("#"+member_col.id).focus();//onclick時focus本欄位

	$("#"+member_col.id).blur(
		function(){
		var after_text = $("#"+member_col.id).val();
		if(member_col.id=="intro")
			after_text=after_text.replace(/\n/g,"<br>");
		var member_id = member_col.id;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open("get", "memberEdit.do?id="+loginmemberId+"&type="+member_id+"&value="+after_text);
		xhr.send();
		function callback() {
			if(xhr.readyState==4 && xhr.status==200){		
				$("#"+member_id).replaceWith('<span id="'+member_id+'" onclick="member_edit(this)">'+after_text+'</span>')
			}
		}
	}
			)
// 	$("#"+member_col.id).keydown(function(event){
// 		if(event.which==13&&member_col.id!="intro"){//代表按下enter
// 			var after_text = $("#"+member_col.id).val();
// 			var member_id = member_col.id;
// 			xhr = new XMLHttpRequest();
// 			xhr.onreadystatechange = callback;
// 			xhr.open("get", "memberEdit.do?id="+loginmemberId+"&type="+member_id+"&value="+after_text);
// 			xhr.send();
// 			function callback() {
// 				if(xhr.readyState==4 && xhr.status==200){
// 					$("#"+member_id).replaceWith('<span id="'+member_id+'" onclick="member_edit(this)">'+after_text+'</span>')
// 				}
// 			}
// 		}
		
// 	})
}

function city_edit(member_col){
	var loginmemberId=${loginmember.id}
	var text = member_col.childNodes[0].innerHTML;
	var districttext=member_col.childNodes[2].innerHTML;
	var cityText=$('<span id="twzipcode"></span>')
		$("#"+member_col.id).replaceWith(cityText);
	console.log(districttext)
		$('#twzipcode').twzipcode({
			'countySel':text,
			'districtSel':districttext})
		member_col.id="cityselect";
	$("#districtselect").blur(function(){
		var after_text = $("#cityselect").val();
		var district_after_text = $("#districtselect").val();
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = callback;
			xhr.open("get", "memberEdit.do?id="+loginmemberId+"&type=city&value="+after_text+"&type1=district&value1="+district_after_text);
			xhr.send();
			function callback() {
				if(xhr.readyState==4 && xhr.status==200){
					if(document.getElementById("twzipcode")){
						$("#twzipcode").replaceWith('<span id="city" onclick="city_edit(this)"><span>'+after_text+'</span>  <span>'+district_after_text+'</span></span>')
					}
				}
			}
		
		}
		)
}
var files;
$('body').on('change','#imgInp',function(event){
	files=event.target.files;
})

$('#uesrPic').click(function(){
	loginmemberId="${loginmember.id}"
	var formData = new FormData();
	
	formData.append('file', files[0]);
	formData.append('id', loginmemberId);
		$.ajax({
			url: "${pageContext.request.contextPath}/member/MemberChangePhoto/insertPhoto",
			type: 'post',
			data: formData,
			processData: false,
			contentType: false,
			success: function(data){
			},error: function(){
				
// 				alertify.alert('檔案格式異常').set('title', '警告');
			}
		})	

})

		}
</script>

</body>
</html>