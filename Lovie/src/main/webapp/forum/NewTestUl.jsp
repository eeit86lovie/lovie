<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <p>搜尋作者</p><br>
    <input type="text" id="suchMember">
    <button id="suchMemberButton" onclick= "suchmember()">搜尋</button>
    </a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
    <a href="#">Link 4</a>
    <a href="#">Link 5</a>
    <a href="#">Link 6</a>
    <a href="#">Link 7</a>
    <a href="#">Link 8</a>
    <a href="#">Link 9</a>
    <a href="#">Link 10</a>
    <a href="#">Link 11</a>
    <a href="#">Link 12</a>
    
  </div>
</div>


<script>

function suchmember(){
	$("#box").empty();
	var memberAccount = $("#suchMember").val();
	var selectMemberArticleJson;
	var memberJson;

	$.ajax({
		url : "forumsMember",
		type : "post",
		dataType : "json",
		success : function(memberjson) {
			memberJson = memberjson;
			$.ajax({
				url : "forumsSelectreply",
				type : "post",
				dataType : "json",
				success : function(selectReplyjson) {
					$.ajax({
						url : "forums/"+ memberAccount,
						type : "get",		
						dataType : "json",
						success : function(selectMemberArticlejson) {			
							$.ajax({
								url : "forumsAllLike",
								type : "post",
								dataType : "json",
								success : function(allLikejson) {
									selectMemberArticleJson = selectMemberArticlejson;
			 						createArticle(selectMemberArticlejson,selectReplyjson,allLikejson);
								}					
							})
						}					
					})
				}		
			})	
		}	
	})
}

</script>



</body>
</html>