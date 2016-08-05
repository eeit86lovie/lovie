<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
.row {
	border: #CC0000 1px dotted;
	border-radius: 15px;
	margin: 15px;
	padding: 10px;
	width: 90%;
}
.edit {
	border-radius: 8px;
	background-color:#F88;
	color:white;
	border:0px;
}

.memberColumn {
	color: #CC6600
}

.ui-datepicker-month{
color:black;
}
.ui-datepicker-year{
color:black;
}


</style>

<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>

<title>會員個人頁面</title>
</head>
<body>
<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.theme.min.css" />
<div class="container">
<div class="row" >
<form>
  <div class="col-md-12" style="font-weight:bold;text-align:center;">${oneMember.nickname}的個人首頁</div>
  <div class="col-md-12" ><br></div>
  <div class="col-md-3"><img id="blah" style="border:5px solid #acd6ff;border-radius:15px;width:100%" src="${pageContext.request.contextPath}/photo/member/${oneMember.id}"></div>
  <div class="col-md-9" ></div>
  <div class="col-md-9" ><b class="memberColumn">暱稱：</b><span id="nickname" onclick="member_edit(this)">${oneMember.nickname}</span></div>
  <div class="col-md-9" ><b class="memberColumn">年齡：</b>${oneMember.age}歲</div>
  <div class="col-md-9" ><b class="memberColumn">性別：</b>${gender}</div>
  <div class="col-md-9" ><b class="memberColumn">星座：</b>${oneMember.constellation}</div>
  <div class="col-md-9" ><b class="memberColumn">所在地：</b><span id="city" onclick="city_edit(this)"><span>${oneMember.city}</span>  <span>${oneMember.district}</span></span></div>
  <div class="col-md-9" ><b class="memberColumn">好友數：</b>${oneMember.friendNum}</div>
  <div class="col-md-9" ><b class="memberColumn">會員等級：</b>${memberPrivilege}</div>
  <div class="col-md-9" ><b class="memberColumn">會員發文總數：</b><a href='${pageContext.request.contextPath}/forumsOneMember/${oneMember.account}'>${article}</a></div>
  <div class="col-md-9" id="pic" style="display:none"><b class="memberColumn">頭像：</b><input id="imgInp" style="margin-top:5px;display:inline" type="file"></input></div>
  <div class="col-md-9" ><button class="edit" id=uesrPic style="margin-top:5px;display:none">確認上傳圖片</button> </div>
  <div class="col-md-12" > </div>
  <div class="col-md-12" ><b class="memberColumn">自我介紹：</b></div>
  <div class="col-md-1" ></div>
  <div class="col-md-9" ><span id="intro" onclick="member_edit(this)">${oneMember.intro}</span></div>
  <div class="col-md-2" ></div>
   <div class="col-md-12" ><br></div>
  <div class="col-md-10" ><b class="memberColumn">喜歡的電影類型：</b>喜劇|奇幻|驚悚</div>
  <div class="col-md-2" ><button  type="button" id=advancedEdit style="display:none">進階編輯</button></div>
  <div class="col-md-12" ><br></div>
 <div class="col-md-5" style="font-size:20%;color:black">註冊日期：${oneMember.registeredTime}</div>
 <div class="col-md-3"></div>
 <div class="col-md-4" style="font-size:20%;color:black">上次上站：${oneMember.lastOnTime}</div>
<div class="col-md-12"></div>

 </form>
 </div>
 
<div id="dialog-form" title="編輯個人檔案"><!--彈跳視窗的內容-->
<form id="advanceForm">
  <div class="col-md-12" style="font-weight:bold;text-align:center;">個人檔案進階編輯</div>
  <div class="col-md-12" ><br></div>
  <div class="col-md-12" ><b class="memberColumn" style="display: block;">修改密碼：</b><input type="password" id="password1" onblur="changePassword()" style="display:inline;"/><span style="color:red;display:none" id="wrongPassword">  密碼需一致</span></div>
  <div class="col-md-12" ><b class="memberColumn">再次確認新密碼：</b><input type="password" id="password2" onblur="changePassword()"/></div>
  <div class="col-md-12" ><b class="memberColumn">信箱：</b><input type="email" id="email" value='${oneMember.email}' onblur="checkEmail()" /></div>
  <div class="col-md-12" ><b class="memberColumn">電話：</b><input id=phone value="${oneMember.phone}"/></div>
  <div class="col-md-12" ><b class="memberColumn">生日：</b><br><input type="text" id="datepicker" disabled="value" value="${oneMember.birthday}"></div>
 </form>
</div>
</div>

<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>

<script src="${pageContext.request.contextPath }/js/jQuery-TWzipcode.js"></script>

<script>

if("${loginmember.id}"=="${oneMember.id}"&&"${oneMember.id}"!=""){
	document.getElementById("pic").style.display = "block";
	document.getElementById("uesrPic").style.display = "block";
	document.getElementById("advancedEdit").style.display = "block";
	
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
}

function city_edit(member_col){
	var loginmemberId=${loginmember.id}
	var text = member_col.childNodes[0].innerHTML;
	var districttext=member_col.childNodes[2].innerHTML;
	var cityText=$('<span id="twzipcode"></span>')
		$("#"+member_col.id).replaceWith(cityText);
	console.log(districttext+"????")
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
// 	loginmemberId="${loginmember.id}"
	var formData = new FormData();
	formData.append('file', files[0]);
//不要傳送太大的檔案，會error
		$.ajax({
			url: "${pageContext.request.contextPath}/member/MemberChangePhoto/insertPhoto",
			type: 'post',
			data: formData,
			processData: false,
			contentType: false,
			success: function(data){
				alert("圖片更新成功！")
			},error: function(){
				alert("圖片更新失敗，請再試一次")
			}
		})	

})

}

//**************************************************************************************************************************
//以下是跳出來的選單

    jQuery("#dialog").prev('.ui-dialog-titlebar').css("background", "red");
$(function () {
    var dialog, form,
      // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
      emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
      name = $("#name"),
      email = $("#email"),
      password = $("#password"),
      allFields = $([]).add(name).add(email).add(password),
      tips = $(".validateTips");

    function updateTips(t) {
        tips
          .text(t)
          .addClass("ui-state-highlight");
        setTimeout(function () {
            tips.removeClass("ui-state-highlight", 1500);
        }, 500);
    }

    function checkLength(o, n, min, max) {
        if (o.val().length > max || o.val().length < min) {
            o.addClass("ui-state-error");
            updateTips("Length of " + n + " must be between " +
              min + " and " + max + ".");
            return false;
        } else {
            return true;
        }
    }

    function checkRegexp(o, regexp, n) {
        if (!(regexp.test(o.val()))) {
            o.addClass("ui-state-error");
            updateTips(n);
            return false;
        } else {
            return true;
        }
    }
    dialog = $("#dialog-form").dialog({
        autoOpen: false,
        height: 400,
        width: 350,
        modal: true,
        closeOnEscape: false,//按ESC不能關閉
        open: function(event, ui) {
            $(this).parent().children().children('.ui-dialog-titlebar-close').hide();
        },
        buttons: {
            "確認":{
            	text:"確定",
            	id:"checkButton",
            	click:updateData },
            "取消": function () {
                dialog.dialog("close");
            }
        },
        close: function () {
            form[0].reset();
            allFields.removeClass("ui-state-error");
        }
    });

    form = dialog.find("form").on("submit", function (event) {
        event.preventDefault();
        addUser();
    });

    $("#advancedEdit").button().on("click", function () {
        dialog.dialog("open");
    });
    function updateData(){
//         	var formElement = document.getElementById("advanceForm");
        	var formData1 = new FormData();
        	formData1.append('password1', document.getElementById("password1").value);
        	formData1.append('password2', document.getElementById("password2").value);
        	formData1.append('email', document.getElementById("email").value);
        	formData1.append('phone', document.getElementById("phone").value);
        	formData1.append('datepicker', document.getElementById("datepicker").value);
        		$.ajax({
        			url: "${pageContext.request.contextPath}/member/MemberUpdateAdvanceData/updateData",
        			type: 'post',
        			data: formData1,
        			processData: false,
        			contentType: false,
        			success: function(data){
        				alert("更新成功")
        				dialog.dialog( "close" );
        				window.location.reload();
        			},error: function(){
        				alert("失敗Q_Q")
        			}
        		})	
    }
});

//*************************************************************************************************************
//以下是跳出選單中的生日下拉式選單
var birthday="${loginmember.birthday}"

      $(function () {
    	  console.log(birthday)
          $("#datepicker").datepicker({
        	  dateFormat:"yy-mm-dd",
              defaultDate: birthday,
              changeMonth: true,
              changeYear: true,
              showOn: "button",
              yearRange:"1950:2000",
              buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
              buttonImageOnly: true
          });
//           $("#datepicker").datepicker().datepicker("setDate", birthday);
      });
//****************************************************************************************************************
//進階表單內容驗證
//確定密碼相同
function changePassword(){
if(document.getElementById("password1").value!=document.getElementById("password2").value){
	document.getElementById("wrongPassword").style.display = "inline";
	document.getElementById("checkButton").disabled=true;
}else{
	document.getElementById("wrongPassword").style.display = "none";
	document.getElementById("checkButton").disabled=false;
}
}
//email格式
var emailRule = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;
 
//validate ok or not
function checkEmail(){
	if(document.getElementById("email").value!=""&&document.getElementById("email").value.search(emailRule)!= -1){
		document.getElementById("checkButton").disabled=false;
	}else{
		document.getElementById("checkButton").disabled=true;
		alert("請輸入正確信箱")
	}
}


</script>

</body>
</html>