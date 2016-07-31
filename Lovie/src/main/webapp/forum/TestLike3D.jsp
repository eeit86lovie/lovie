<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/likedemo.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/likestyle.css">
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.gallery.js"></script>
<script src="${pageContext.request.contextPath}/js/modernizr.custom.53451.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

.rankPeople_img{
	width: 400px;
	height: 300px;
}

</style>

</head>


<body>


<div class = "yyy">
<div class ="xxx">
<section id="dg-container" class="dg-container">
	<div id="selectRankPeople" class="dg-wrapper">
		
	</div>
	<nav>	
		<span class="dg-prev"><</span>
		<span class="dg-next">></span>
	</nav>
</section>
</div>
</div>

  
  <script>
 
  
function selectRankPeople(selectRankPeopleObject){
	 
	
	$.ajax({
		url : "forumsAllLike",
		type : "post",
		dataType : "json",
		success : function(allLikejson) {
			
			var article_ID = selectRankPeopleObject.id.substring(13);
			
			
			for(m =0; m<allLikejson.length;m++){
				if(allLikejson[m].articleID==article_ID){
					
					var a_Rank = document.createElement("a");					
					a_Rank.setAttribute("href","#dg-container");
					
					var rankPeople_div = $("<div ></div>");
					var rankPeopleName_div = $("<div></div>").append(getmemberPhoto(allLikejson[m].memberAccount).nickname);
					var rankPeople_img = document.createElement("img");
					rankPeople_img.className ="rankPeople_img";
					rankPeople_img.src = getmemberPhoto(allLikejson[m].memberAccount).photoUrl;
		
					rankPeople_div.append(rankPeople_img);
					rankPeople_div.append(rankPeopleName_div);
					a_Rank.appendChild(rankPeople_img);	
					$("#selectRankPeople").append(a_Rank);
					
				}
			
			}
			$('#dg-container').gallery();
		}					
	})
	

}
     
     
  </script>


</body>
</html>