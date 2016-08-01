<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.leanModal.min.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lightbox.css" />


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.cont{
    background:#0F0;
    width:400px;
    height:40px;
    line-height:40px;
    display: table;
}
.button{
    background:#F00;
    display: table-cell;
}
​



</style>

</head>
<body>

<div>
	<a id="modal_trigger" href="#modal" class="btn" onclick="checkLogin()">我要發表文章</a>
</div>

<div id="modal" class="popupContainer" style="display:none;">
	<header class="popupHeader">
		<span class="header_title">發表文章</span>
		
	</header>

    <section class="popupBody">
    
      <div class="user_login">
    <form>
        <label>文章標題</label> <input type="text" id="username"><br>
        <p id ="error_title"></p>
        
        <label>文章分類</label>
        <select id="ArticleGenre">
	　		<option value="好雷">好雷</option>
	　		<option value="負雷">負雷</option>
	　		<option value="新聞">新聞</option>
	　		<option value="討論">討論</option>
	　		<option value="問片">問片</option>
	　		<option value="其他">其他</option>
	　	</select><br>

        <label>文章內容</label><TextArea type="text" id="textArea"></TextArea><br>
        <p id="error_content"></p>
        
        <div class="action_btns">
			<div class="one_half last">
            	<div class="center"><input class="btn btn_red" type="button" name="loginbtn" id="loginbtn" onclick="clickLightButton()"  value="發文" ></div>
            </div>
        </div>
    </form>
           
     </div>   
</div>
    </section>
</div>

<script>

function checkLogin(){
	
	if("${loginmember.account}" != ""){
		$("#modal_trigger").leanModal({top : 200, overlay : 0.6, closeButton: ".btn btn_red"});	
	}else{
		alert("請先登入會員");
	}
	
}


function clickLightButton(){
	var pubMember = "${loginmember.account}";
	var pubTitle = $("#username").val();
	var pubGenre = $("#ArticleGenre").val();
	var pubContent = $("#textArea").val();
	
	var error_title = 0;
	var error_content = 0;
	
		
		
		
		if(pubTitle==""){
			$("#error_title").empty();
			$("#error_title").append("請輸入標題");
			var error_title = 1;
		}else{
			$("#error_title").empty();
		}
		
		if(pubContent==""){
			$("#error_content").empty();
			$("#error_content").append("請輸入內容");
			var error_content = 1;
		}else{
			$("#error_content").empty();
		}
		
		
		if(error_title == 0 && error_content == 0){
			$.ajax({
				url : "forumsPublicationArticle",
				type : "post",
				data : { 
						 PublicationMember:pubMember,
						 PublicationTitle:pubTitle,
				 		 PublicationGenre:pubGenre,
				 		 PublicationContent:pubContent,  		
				},
				dataType : "json",
				success : function(PublicationArticleResult) {
					$("#lean_overlay").hide();
					$("#modal").hide();
					
					var selectReplyjson;	 
				    createArticle(PublicationArticleResult,selectReplyjson);
				}					
			})
		
		}	
}

</script>


</body>
</html>