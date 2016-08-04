<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

/* The container <div> - needed to position the dropdown content */
.dropdown {
    position: relative;
    display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
 
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
    display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}

</style>

</head>
<body>
<div class="dropdown">
  <div class="dropdown-content" id="dropdown-content">
    <a href="#">
    	<button id="searchMyArticleButton" onclick= "searchMyArticle()">我的文章</button>
    </a>
    
    <a href="#">
    	<p>搜尋作者</p><br>
	    <input type="text" id="searchMember">
	    <button id="searchMemberButton" onclick= "searchmember()">搜尋</button>
    </a>
    
    <a href="#">
    	<p>搜尋標題</p><br>
	    <input type="text" id="searchTitle">
	    <button id="searchTitleButton" onclick= "searchTitle()">搜尋</button>
    
    </a> <a href="#">
	    <p>依類別搜尋</p><br>
	    <select id="searchGenre">
	　		<option value="好雷">好雷</option>
	　		<option value="負雷">負雷</option>
	　		<option value="新聞">新聞</option>
	　		<option value="討論">討論</option>
	　		<option value="問片">問片</option>
	　		<option value="其他">其他</option>
	　	</select><br>
	    <button id="searchGenreButton" onclick= "searchGenre()">搜尋</button>
    </a>    
    
    <a href="#">
    	<p>搜尋內容關鍵字</p><br>
	    <input type="text" id="searchContent">
	    <button id="searchContentButton" onclick= "searchContent()">搜尋</button>
    </a>
    
    
    
    <a href="#">
        <button id="searchMyLikeButton" onclick= "searchMyLike()">我所喜歡的文章</button>  
    </a>
    
    
    <a href="#">
        <button id="searchMyDisLikeButton" onclick= "searchMyDisLike()">我所不喜歡的文章</button> 
    </a>
    
    
    
    <a href="#">Link 9</a>
    <a href="#">Link 10</a>
    <a href="#">Link 11</a>
    <a href="#">Link 12</a>
    
  </div>
</div>


<script>
function searchmember(){
	var searchedMember = $('#searchMember').val();
	window.location.assign("http://localhost:8080/Lovie/forumsOneMember/"+ searchedMember);
}


function searchTitle(){
	var searchedTitle = $('#searchTitle').val();
	window.location.assign("http://localhost:8080/Lovie/forumsTitle/"+searchedTitle);
}


function searchMyArticle(){
	var searchMyArticle = "${loginmember.account}";
	window.location.assign("http://localhost:8080/Lovie/forumsOneMember/"+ searchMyArticle);
}


function searchGenre(){
	var searchGenre = $("#searchGenre").val();
	window.location.assign("http://localhost:8080/Lovie/forumsArticleGenre/"+ searchGenre);
}


function searchContent(){
	var searchContent = $("#searchContent").val();
	window.location.assign("http://localhost:8080/Lovie/forumsArticleContent/"+ searchContent);
}


function searchMyLike(){
	var searchMyLike = "${loginmember.account}";
	window.location.assign("http://localhost:8080/Lovie/forumsArticleMyLike/"+ searchMyLike);
}

function searchMyDisLike(){
	var searchMyDisLike = "${loginmember.account}";
	window.location.assign("http://localhost:8080/Lovie/forumsArticleMyDisLike/"+ searchMyDisLike);
}


</script>



</body>
</html>