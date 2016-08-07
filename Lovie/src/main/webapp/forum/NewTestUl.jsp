<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.leanModal.min.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lightbox.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

body{
	background-color:#FFFFFF;
}


/* The container <div> - needed to position the dropdown content */
.dropdown {
	width:220px;
	background-color: #FFFFFF;
	position:fixed; /*固定不動*/
	top:200px;
	left:-100px;
}

/* Dropdown Content (Hidden by Default) */

.row.dropdown-content { 
	margin:5px;
}

.min_but{
    width: 210px;
    height: 35px;
    float:left;
    margin:10px 0;
	border: #ff5959 1px solid;
	border-radius:5px;
	-moz-border-radius:5px;
	color: #ff5959;
	background-color: #FFFFFF;
}

.min_but:hover{
	color: #FFFFFF;
	background-color: #ff5959;
}
/*
.search_but{
	width: 50px;
    height: 25px;
    float:right;
	border: #ff5959 1px solid;
	border-radius:3px;
	-moz-border-radius:3px;
	color: #FFFFFF;
	background-color:#ff5959;
	text-align: center;
	cursor: pointer;
}
*/

button{
width:50px;
height:25px;
	margin-top:5px;
	color: #FFFFFF;
	background-color:#ff5959;
	border:none;
		border-radius:3px;
	-moz-border-radius:3px;
}

.dropdown-content {
	width:200px;
	font-size:16px;
	clor:#ff5959;
	float:left;
	margin:5px 0;
	
}

.search_text{
	width:140px;
	height: 25px;
	float:left;
	border-radius:3px;
	-moz-border-radius:3px;
	margin:5px 0;
	color:#666666;

}

.menu_search_genre{
	width: 140px;
    height: 25px;
    margin-top:8px;
    margin-bottom:15px;
    color:#666666;
}
.minsearch_text{
	width:200px;
	margin-top:2px;
	color: #ff5959;
	font-weight: bold;
}


.remind_text{
	font-size:12px;
	width:200px;
	color:red;
	float:left;
	padding-tottom:5px;
}
</style>


</head>
<body>
<c:import charEncoding="UTF-8" url="/forum/createForumFunction.jsp"></c:import>
<div class="dropdown">
  <div class="dropdown-content" id="dropdown-content">

       		<button id="modal_trigger" href="#modal" onclick="checkLogin()" class="min_but">發表文章</button>
  
    		<button id="searchMyArticleButton" onclick= "searchMyArticle()"class="min_but">我的文章</button>
    		
    		<button id="searchMyLikeButton" onclick= "searchMyLike()"class="min_but">我所喜歡的文章</button>  

        <button id="searchMyDisLikeButton" onclick= "searchMyDisLike()"class="min_but">我所不喜歡的文章</button> 
  
    	<p class="minsearch_text">搜尋作者</p>
	    <input type="text" id="searchMember" class="search_text">
	    <button id="searchMemberButton" onclick= "searchmember()">搜尋</button>
	    <p id="error_message_searchMember" class="remind_text"></p>

    	<p class="minsearch_text">搜尋標題</p>
	    <input type="text" id="searchTitle" class="search_text">
	    <button id="searchTitleButton" onclick= "searchTitle()" >搜尋</button>
    	<p id="error_message_searchTitle" class="remind_text"></p>

	    <p class="minsearch_text">依類別搜尋</p>
	    <select id="searchGenre" class="menu_search_genre">
	　		<option value="好雷">好雷</option>
	　		<option value="負雷">負雷</option>
	　		<option value="新聞">新聞</option>
	　		<option value="討論">討論</option>
	　		<option value="問片">問片</option>
	　		<option value="其他">其他</option>
	　	</select>
	    <button id="searchGenreButton" onclick= "searchGenre()" class="but">搜尋</button>

    	<p class="minsearch_text">搜尋內容關鍵字</p>
	    <input type="text" id="searchContent" class="search_text">
	    <button id="searchContentButton" onclick= "searchContent()">搜尋</button>
 		<p id="error_message_searchContent" class="remind_text"></p>
     
  </div>
</div>





<div id="modal" class="popupContainer" style="display:none;">
	<header class="popupHeader">
		<span class="header_title">發表文章</span>
		
	</header>

    <section class="popupBody">
    
      <div class="user_login">
    <form>
    	<select id="ArticleGenre" class="articleGenre">
	　		<option value="好雷">好雷</option>
	　		<option value="負雷">負雷</option>
	　		<option value="新聞">新聞</option>
	　		<option value="討論">討論</option>
	　		<option value="問片">問片</option>
	　		<option value="其他">其他</option>
	　	</select>
        <input type="text" id="articleTitle" class="articleTitle">
        <p id ="error_title" class="error_title"></p>
       
        <TextArea type="text" id="textArea" class="articleTextArea"></TextArea><br>
        <p id="error_content" class="error_content"></p>
        
        <div class="action_btns">
			<div class="one_half last">
            	<div class="center"><input class="btn btn_red" type="button" name="loginbtn" id="loginbtn" onclick="clickLightButton()"  value="發文" ></div>
            </div>
        </div>
    </form>
           
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
	var pubTitle = $("#articleTitle").val();
	var pubGenre = $("#ArticleGenre").val();
	var pubContent = $("#textArea").val();
	
	var error_title = 0;
	var error_content = 0;
	$("#error_title").empty();
	$("#error_content").empty();	
		
		
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
				    $("#articleTitle").val("");
				    $("#textArea").val("");
				}					
			})
		
		}	
}




function searchmember(){
	var searchedMember = $('#searchMember').val();
	var account = getmemberNickName(searchedMember);
	if(searchedMember==""){
		$("#error_message_searchMember").empty();
		$("#error_message_searchTitle").empty();
		$("#error_message_searchMember").empty();
		$("#error_message_searchMember").append("請輸入會員");
	}else{
		
	window.location.assign("${pageContext.request.contextPath}/forumsOneMember/"+ account);
	}
}


function searchTitle(){
	var searchedTitle = $('#searchTitle').val();
	if(searchedTitle==""){
		$("#error_message_searchMember").empty();
		$("#error_message_searchTitle").empty();
		$("#error_message_searchContent").empty();
		$("#error_message_searchTitle").append("請輸入標題")
	}else{
		
	window.location.assign("${pageContext.request.contextPath}/forumsTitle/"+searchedTitle);
	}
	
}


function searchMyArticle(){
	var searchMyArticle = "${loginmember.account}";
	window.location.assign("${pageContext.request.contextPath}/forumsOneMember/"+ searchMyArticle);
}


function searchGenre(){
	var searchGenre = $("#searchGenre").val();
	window.location.assign("${pageContext.request.contextPath}/forumsArticleGenre/"+ searchGenre);
}


function searchContent(){
	var searchContent = $("#searchContent").val();
	$("#error_message_searchMember").empty();
	$("#error_message_searchTitle").empty();
	$("#error_message_searchContent").empty();
	if(searchContent==""){
		$("#error_message_searchContent").empty();
		$("#error_message_searchContent").append("請輸入內容")
	}else{
		
	window.location.assign("${pageContext.request.contextPath}/forumsArticleContent/"+ searchContent);
	}
}


function searchMyLike(){
	var searchMyLike = "${loginmember.account}";
	window.location.assign("${pageContext.request.contextPath}/forumsArticleMyLike/"+ searchMyLike);
}

function searchMyDisLike(){
	var searchMyDisLike = "${loginmember.account}";
	window.location.assign("${pageContext.request.contextPath}/forumsArticleMyDisLike/"+ searchMyDisLike);
}


</script>



</body>
</html>
