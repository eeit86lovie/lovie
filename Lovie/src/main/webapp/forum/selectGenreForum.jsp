<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lightbox.css">
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.leanModal.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/createForum/createForum.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/selectLike/selectLike.css">
<script src="${pageContext.request.contextPath}/js/jquery.hoverCarousel.js"></script>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>電影討論區</title>

<style type="text/css">

</style>




</head>


<body>
	<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
	
		
	
	
       
	
		
	<div class="row">
   
		
		<div class="col-md-2">
			<c:import charEncoding="UTF-8" url="/forum/NewTestUl.jsp"></c:import>
		</div>
		
		<div class="col-md-8">			
			<div id="box">
				
			</div>
		</div>
	
        <div class="col-md-2"></div>
    
        
	</div>
    


<div>
	<a id="Update_Article_trigger" href="#Update_Article" class="btn" onclick="updateButton()"></a>
</div>

<div id="Update_Article" class="popupContainer" style="display:none;">
	<header class="popupHeader">
		<span class="header_title">修改文章</span>
		
	</header>

    <section class="popupBody">
    
      <div class="user_login">
    <form>
      
        
        
        <select id="updateGenre" class="articleGenre">
	　		<option value="好雷">好雷</option>
	　		<option value="負雷">負雷</option>
	　		<option value="新聞">新聞</option>
	　		<option value="討論">討論</option>
	　		<option value="問片">問片</option>
	　		<option value="其他">其他</option>
	　	</select><br>

      <input type="text" id="updateTitle" class="articleTitle"><br>
        <p id ="error_update_title"></p>

         <TextArea type="text" id="updateTextArea" class="articleTextArea"></TextArea><br>
        <p id="error_update_content"></p>
        
        <div class="action_btns">
			<div class="one_half last">
            	<div class="center"><input class="btn btn_red" type="button" name="loginbtn" id="updatebtn" value="發文" onclick="clickUpdate()" ></div>
            </div>
        </div>
    </form>
           
     </div>   
</div>
    </section>
</div>




<div>
	<a id="Report_Article_trigger" href="#Report_Article" class="btn" onclick="reportButton()"></a>
</div>



<div id="Report_Article" class="popupContainer" style="display:none;">
	<header class="popupHeader">
		<span class="header_title">檢舉文章</span>
		
	</header>

    <section class="popupBody">
    
      <div class="user_login">
    <form>
        <label>文章標題</label> <input type="text" id="reportTitle"><br>
        
        
        
        <label>檢舉內容</label><TextArea type="text" id="reportContent"></TextArea><br>
        <p id="error_report_content"></p>
        
        <div class="action_btns">
			<div class="one_half last">
            	<div class="center"><input class="btn btn_red" type="button" name="reportbtn" id="reportbtn" value="發文" onclick="clickReportButton()" ></div>
            </div>
        </div>
    </form>
           
     </div>   
</div>
    </section>
</div>



<div id="myNav" class="overlay">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
  <div class="carousel right">
  <div class="indicator"></div>
  <div class="wrap">
    <ul id="selectLike_ul">      
    </ul>
  </div>
</div>
</div>
</div>


<c:import charEncoding="UTF-8" url="/forum/createForumFunction.jsp"></c:import>

<script>
var selectGenreArticleJson;
var memberJson;

$.ajax({
	url : "${pageContext.request.contextPath}/forumsMember",
	type : "post",
	dataType : "json",
	success : function(memberjson) {
		memberJson = memberjson;
		$.ajax({
			url : "${pageContext.request.contextPath}/forumsSelectreply",
			type : "post",
			dataType : "json",
			success : function(selectReplyjson) {
				$.ajax({
					url : "${pageContext.request.contextPath}/forumsSelectGenre",
					type : "post",
					data:{Genre:"${genre}"},
					dataType : "json",
					success : function(selectGenreArticlejson) {			
						$.ajax({
							url : "${pageContext.request.contextPath}/forumsAllLike",
							type : "post",
							dataType : "json",
							success : function(allLikejson) {
								selectGenreArticleJson = selectGenreArticlejson;
		 						createArticle(selectGenreArticlejson,selectReplyjson,allLikejson);
							}					
						})
					}					
				})
			}		
		})	
	}	
})
	
	
	
</script>


	<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>