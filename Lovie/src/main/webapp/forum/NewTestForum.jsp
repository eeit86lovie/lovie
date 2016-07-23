<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/lightbox.css">
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.leanModal.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
body {
	font-family: Arial, Helvetica, "微軟正黑體", sans-serif;
}

.BOX01 {
	width: 930px;
	overflow: hidden;
	margin: 15px 0;
	border: #ADADAD 1px solid;
	box-shadow: 0px 3px 3px rgba(0, 0, 0, 0.2);
	border-radius: 7px;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	background-color: #FFFFFF;
	overflow: hidden;
}

.content {
	margin: 90px 20px;
	text-align: justify;
	line-height: 30px;
	font-size: 18px;
}

.title {
	width: 600px;
	font-size: 24px;
	margin-left: 110px;
	margin-top: 60px;
	font-weight: bold;
}

.member {
	width: 300px;
	margin-left: 2px;
	margin-top: 20px;
	font-size: 20px;
	float: left;
	color: #0072E3;
	font-weight: bold";
}

.photo_div {
	width: 90px;
	height: 120px;
	margin: 20px 20px 5px 20px;
	float: left;
}

.photo {
	width: 120px;
	height: 80px;
}

.pubTime {
	width: 150px;
	margin: 20px 20px;
	float: right;
}

.editTime {
	width: 150px;
	margin: 20px 20px 20px 670px;
	float: right;
}

.replyButton {
	weight: 30px;
	height: 30px;
	background-Color: lightgreen;
}

.replyText {
	width: 750px;
	margin: 20px 20px 20px 100px;
	height: 26px;
}

.col-md-12 {
	background: #F0F0F0";
}

.replyphoto {
	width: 45px;
	margin: 10px 10px;
	height: 60px;
	float: left;
}

.replymember {
	width: 60px;
	margin-left: 2px;
	margin-top: 10px;
	margin-right: 20px;
	font-size: 16px;
	float: left;
	color: #0072E3;
	font-weight: bold;
}

.replycontent {
	width: 600px;
	margin-top: 10px;
	font-size: 14px;
	overflow: hidden;
	position: relative;
	z-index: 1;
}

.replypubTime {
	margin-top: 20px;
	font-size: 12px;
}

.replyAll {
	width: 890px;
	overflow: hidden;
	margin: 10px 20px;
	border: #ADADAD 0.3px solid;
	border-radius: 5px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;	
}



.replyarea {
	
	background-color: #FFFFFF;
	clear: Both;
	display: none
}

.errormessage {
	color: red;
}

#lean_overlay {
	position: fixed;
	z-index: 100;
	top: 0px;
	left: 0px;
	height: 100%;
	width: 100%;
	background: #3C3C3C;
	display: none;
}
</style>



</head>
<body>
	<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>


		
	<div class="container">

		<input type="button" id="addarticle" value="ADD" onclick="add()">
		<a href="#loginmodal" class="flatbtn" id="modaltrigger">lightbox</a>
		<div class="row">

			<div id="box"></div>

		</div>
	</div>


<!-- ------------------------------------------------------------------------------------------------------------------- -->             
  
  
  <div id="loginmodal"style="display:none">
    
    
      <label >Title:</label>
      <input type="text" name="username" id="username" class="txtfield" tabindex="1">
      <div id="error_message_title"></div>
      <label >文章類別:</label>
      <select id="ArticleGenre">
　		<option value="好雷">好雷</option>
　		<option value="負雷">負雷</option>
　		<option value="新聞">新聞</option>
　		<option value="討論">討論</option>
　		<option value="問片">問片</option>
　		<option value="其他">其他</option>
　	  </select>
      
      <label>Content:</label>
      <TextArea id="textArea" Cols="20" Rows="5" Name="意見內容" Wrap="off" class="txtfield" tabindex="2"></TextArea>

	  <div id="error_message_content"></div>

      <div class="center"><input type="button" name="loginbtn" id="loginbtn" onclick="PublicationArticle()" class="flatbtn-blu hidemodal" value="發文" tabindex="3"></div>
   
  </div>
  
  
             
<!-- ------------------------------------------------------------------------------------------------------------------- -->     

<script>

$('#modaltrigger').leanModal({ top: 110, overlay: 0.8, closeButton: ".hidemodal" });



function PublicationArticle() {
	var pubMember = "${loginmember.account}";
	var pubTitle = $("#username").val();
	var pubGenre = $("#ArticleGenre").val();
	var pubContent = $("#textArea").val();
	
	
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
			var selectReplyjson;	 
			//alert(PublicationArticleResult.id);
				  createArticle(PublicationArticleResult,selectReplyjson);
		}					
	})
}


</script>






	<script>
 

 //window.onload = heidReplyDiv();

// window.onscroll=function(){
//     var sHeight = document.body.scrollTop;//滚动高度
//     var wHeight = document.documentElement.clientHeight;//window 
//     var dHeight = document.documentElement.offsetHeight;//整个文档高度
//     if(dHeight-(sHeight+wHeight)<1000)
//     {
//     	add();
//     	//setTimeout(function() { add(); }, 5000);
    	
//     }
    
// };


function scroll(){
    var sHeight = document.body.scrollTop;//滚动高度
    var wHeight = document.documentElement.clientHeight;//window 
    var dHeight = document.documentElement.offsetHeight;//整个文档高度
    if(dHeight-(sHeight+wHeight)<100)
    {
    	add();
    	//setTimeout(function() { add(); }, 5000);
    	
    }
    
};
</script>



	<script>

var articleJson;
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
					url : "forums",
					type : "post",
					dataType : "json",
					success : function(articlejson) {			
						$.ajax({
							url : "forumsAllLike",
							type : "post",
							dataType : "json",
							success : function(allLikejson) {
		 						articleJson = articlejson;
		 						createArticle(articleJson,selectReplyjson,allLikejson);
		//alert(allLikejson);
							}					
						})
					}					
				})
			}		
		})	
	}	
})






		
		
			

</script>

	<script>

// function add(){
// 	var count = $(".BOX01").size();
// 	$.ajax({
// 		url : "addarticle.mvc?articleCount="+count,
// 		type : "GET",
// 		dataType : "json",
// 		success : function(addarticlejson) {
// 			//alert(addarticlejson);
// 			alert("ssssssssssssss");
// 		}		
// 	})	
// }


function add(){
	var count = $(".BOX01").size();
	$.ajax({
		url : "forumsSelectreply",
		type : "post",
		dataType : "json",
		success : function(selectReplyjson) {
			$.ajax({
				url : "forumsAddarticle",
				type : "GET",
				dataType : "json",
				data : {
					addcontent:count
				},
				success : function(addarticlejson) {
					var selectReplyjson;
					createArticle(addarticlejson,selectReplyjson);		
					}		
				})	
			}		
	})	
}




	function createArticle(articleJson,selectReplyjson,allLikejson){
		
		for(i = 0; i<articleJson.length;i++){
	      
			var allarticle = $("<div id='BOX01' class='BOX01'></div>");
			
			var linkMember = document.createElement("a");
			var memberLink = "${pageContext.request.contextPath}/member/profile/"+getmemberPhoto(articleJson[i].memberAccount).id;
			linkMember.setAttribute("href", memberLink);
			var article_memberAccount_Text = document.createTextNode(getmemberPhoto(articleJson[i].memberAccount).nickname);
			linkMember.appendChild(article_memberAccount_Text);
			
			var article_genre_Text = document.createTextNode(articleJson[i].genre);
	  		var article_title_Text = document.createTextNode(articleJson[i].title);
	  		var article_content_Text = document.createTextNode(articleJson[i].content);
	  		var article_pubTime_Text = document.createTextNode("發表時間:"+articleJson[i].pubTime);
	  		var article_editTime_Text = document.createTextNode("最後編輯時間:"+articleJson[i].editTime);
	 
	  		
	  		var replyText = document.createElement("input");
				replyText.setAttribute("type", "text");
				//replyText.className = "replyText";
				replyText.id="text" + articleJson[i].id;
				FocusReplyText
				replyText.setAttribute("onfocus", "FocusReplyText(this)");
				//replyText.setAttribute("onblur", "onBlurReplyText(this)");
				
			var replybutton = document.createElement("button");
			    replybutton.id = "replyButton" + articleJson[i].id;
			    //replybutton.className="replyButton";
				replybutton.setAttribute("onclick", "clickReplyButton(this)");
				var reply_button_Text = document.createTextNode("留言");
				//var reply_addcontent_error_div = document.createElement("div");
				//reply_addcontent_error_div.className="errormessage";
				replybutton.appendChild(reply_button_Text);	
				
			
				var hideReply = document.createElement('input');//隱藏留言
				hideReply.type = "checkbox";
				hideReply.id = "hideReply"+articleJson[i].id;
				hideReply.checked="checked";
				hideReply.setAttribute("onchange", "heidReplyDiv(this)");
				var hideReply_div = $("<div></div>").append(hideReply);
				
				var like_Button = document.createElement('input');//Like
				like_Button.type = "checkbox";
				like_Button.id = "like_Button"+articleJson[i].id;
				like_Button.setAttribute("onchange", "checkLike(this)");
				var like_Button_div = $("<div id='"+'like_Button_div'+articleJson[i].id+"'></div>").append(like_Button);
				
				var disLike_Button = document.createElement('input');//DisLike
				disLike_Button.type = "checkbox";
				disLike_Button.id = "disLike_Button"+articleJson[i].id;
				disLike_Button.setAttribute("onchange", "checkDisLike(this)");
				var disLike_Button_div = $("<div id='"+'disLike_Button_div'+articleJson[i].id+"'></div>").append(disLike_Button);
				
	  		
	  		var img = document.createElement("img");
	  		img.src = getmemberPhoto(articleJson[i].memberAccount).photoUrl;
	  		img.className = "photo_div";
	  		var Article_photo_div = $("<div></div>").append(img);
	  		var Article_member_div = $("<div class='member'></div>").append(linkMember);
	  		
	  		
			var Article_genre_div = $("<div class='title'></div>").append(article_genre_Text);
	  		var Article_title_div = $("<div class='title'></div>").append(article_title_Text);
	  		var Article_content_div = $("<div class='content'></div>").append(article_content_Text);
	  		var Article_pubTime_div = $("<div class='pubTime'></div>").append(article_pubTime_Text);
	  		var Article_editTime_div = $("<div class='editTime'></div>").append(article_editTime_Text);
	  		var Article_replyarea_div = $("<div class='replyarea' id='"+'replyarea'+articleJson[i].id+"'></div>");
	  		var Article_addReply_div = $("<div id='"+'addReply'+articleJson[i].id+"'></div>");
	  		
	  		
	  		
	  		if(allLikejson!=null){//顯示每筆文章的Like && DisLike
	  			var countLike = 0;
	  			var countDisLike = 0;
	  			var myself ="";
	  			for(m =0; m<allLikejson.length;m++){
					if(allLikejson[m].articleID == articleJson[i].id){
						
						if(allLikejson[m].good == 1 && allLikejson[m].memberAccount == "${loginmember.account}"){
							myself = "你和其他";
							like_Button.checked="checked";
						}else if(allLikejson[m].good == 1){
							countLike++;
						}
						
						if(allLikejson[m].bad == 1 && allLikejson[m].memberAccount == "${loginmember.account}"){
							myself = "你和其他"
						}else if(allLikejson[m].bad == 1){
							countDisLike++;
						}
					}
		  		}
	  	    like_Button_div.append(myself + countLike+"人Like");
	  	  	disLike_Button_div.append(countDisLike+"人disLike");
	  		}
	  	
	  		
	  		
	  		
	  		if(selectReplyjson!=null){//顯示每筆文章的留言
		  		for(k = 0; k < Object.keys(selectReplyjson).length;k++){
					if(selectReplyjson[k].articleID == articleJson[i].id){
					returnReplyString = JSON.stringify(selectReplyjson[k]);
					var returnReplyjson = JSON.parse(returnReplyString);
					var replyAll_div = createReply(returnReplyjson);
					Article_replyarea_div.append(replyAll_div);	
							}	
		  			}
	  		}
	  		
	  		Article_addReply_div.append(replyText);//留言文字框
	  		Article_addReply_div.append(replybutton);//流言按鈕
	 		
	  		
	  		var countReply = Article_replyarea_div.children().length+"則留言";
	  		if(Article_replyarea_div.children().length>0){
	  			var countReply_div = $("<div></div>").append(countReply);
	  		}
	  		
	  		allarticle.append(Article_photo_div);
	 		allarticle.append(Article_member_div);
	 		allarticle.append(Article_pubTime_div);
	 		allarticle.append(Article_genre_div);
	 		allarticle.append(Article_title_div);
			allarticle.append(Article_content_div);
			
			allarticle.append(hideReply_div);////隱藏留言
			allarticle.append(like_Button_div);//like
			allarticle.append(disLike_Button_div);//disLike
			
			allarticle.append(Article_editTime_div);
			allarticle.append(countReply_div);
	 		allarticle.append(Article_addReply_div);
	 		allarticle.append(Article_replyarea_div);//留言放這
	 		
	 		
	 		
	 		if(articleJson.length == 1){
	 			$("#box").prepend(allarticle);
	 		}else{
	 			$("#box").append(allarticle);		
	 		}
		}
		
	}//end of createArticle


	function getmemberPhoto(articlemember){
		for(j = 0; j<Object.keys(memberJson).length;j++){
			if(memberJson[j].account == articlemember){
				return memberJson[j];
			}	
		}	
	}//end of getMemberPhoto


	
	
	function clickReplyButton(replyButtonObject){
		$("#errormessage").remove();
		var replyValue = $("#"+"text"+replyButtonObject.id.substring(11)).val();
		var replyArticle_id = replyButtonObject.id.substring(11);
		var replyMember ="${loginmember.account}";
		
		if(replyValue != ""){//需要再判斷有無登入
			
					$.ajax({
						url : "forumsAddreply",
						type : "POST",
						dataType : "json",
						data : {
							ReplyArticle_ID:replyArticle_id,
							ReplyMember:replyMember,
							ReplyContent:replyValue
						},
						success : function(articleReplyResult) {
							var replyAll_div = createReply(articleReplyResult);
							$("#"+"replyarea"+replyButtonObject.id.substring(11)).append(replyAll_div);
							$("#"+"text"+replyButtonObject.id.substring(11)).val("");	
						}		
					})			
			}else{
				var error_message = $("<div class='errormessage' id='errormessage'></div>").append("請輸入留言");
				$("#"+"addReply"+ replyButtonObject.id.substring(11)).append(error_message);
			}
	}
	

	
	function createReply(returnReplyjson){
		
	
		var Reply_img = document.createElement("img");
		Reply_img.src = getmemberPhoto(returnReplyjson.memberAccount).photoUrl;
		Reply_img.className = "replyphoto";
	  	var Reply_photo_div = $("<div></div>").append(Reply_img);
	  		  	
	  	var linkReplyMember = document.createElement("a");
		var ReplymemberLink = "${pageContext.request.contextPath}/member/profile/"+getmemberPhoto(returnReplyjson.memberAccount).id;
		linkReplyMember.setAttribute("href", ReplymemberLink);
	  	var Repty_member_TextNode = document.createTextNode(getmemberPhoto(returnReplyjson.memberAccount).nickname);
	  	linkReplyMember.appendChild(Repty_member_TextNode);
	  	
	  	var Reply_member_div = document.createElement("div");
	  	Reply_member_div.className = "replymember";
	  	Reply_member_div.appendChild(linkReplyMember);
	  	
	  	
	  	var Reply_content_div = $("<div class='replycontent'></div>").append(returnReplyjson.content);
	  	var Reply_pubTime_div = $("<div class='replypubTime'></div>").append("留言時間:"+returnReplyjson.pubTime);	
	    var replyAll_div = $("<div class='replyAll'></div>");//整塊留言DIV		
		
	    
	    replyAll_div.append(Reply_photo_div);
	    replyAll_div.append(Reply_member_div);
	    replyAll_div.append(Reply_content_div);
	    replyAll_div.append(Reply_pubTime_div);

		return replyAll_div;
	}
	
	
	function heidReplyDiv(hideReplyObject){
		if(document.getElementById(hideReplyObject.id).checked){
			$("#"+"replyarea"+hideReplyObject.id.substring(9)).slideUp(1000);			
			
		}else{			
			$("#"+"replyarea"+hideReplyObject.id.substring(9)).slideDown(1000);			
 		}
		
	}
	

	function FocusReplyText(ReplyTextObject){
		  $("#"+"hideReply"+ReplyTextObject.id.substring(4)).prop("checked",false);		
		  
 	  if($("#"+"hideReply"+ReplyTextObject.id.substring(4)).attr("checked",false)){
 			  $("#"+"replyarea"+ReplyTextObject.id.substring(4)).slideDown(1000)
 			
 		  }
	}
	
	
// 	function onBlurReplyText(onBlurReplyObject){
// 		$("#"+"hideReply"+onBlurReplyObject.id.substring(4)).prop("checked",true);
		
// 		if($("#"+"hideReply"+onBlurReplyObject.id.substring(4)).attr("checked",true)){
// 			  $("#"+"replyarea"+onBlurReplyObject.id.substring(4)).slideUp(1000);
// 		  }
		
// 	}
	
	function checkLike(likeObiect){
		var like;
		if(document.getElementById(likeObiect.id).checked){				
			like = 1;
		}else{			
			like = 0;			
 		}		
		if("${loginmember.account}"!=""){
			
			var likeArticleId = likeObiect.id.substring(11);
			var likeMember = "${loginmember.account}"
			//var like = //function判斷??
			
			$.ajax({
				url : "forumsLike",
				type : "POST",
				dataType : "json",
				data : {
					LikeArticleId:likeArticleId,
					LikeMember:likeMember,
					Like:like
				},
				success : function(articleLikeResult) {
					//alert(articleLikeResult);
					var countLike = articleLikeResult.length;
						for(n =0;n<articleLikeResult.length;n++){
							//alert(articleLikeResult[n].memberAccount);
						}
				//$("#"+"disLike_Button_div"+likeObiect.id).append(countLike+"人Like");
				}		
			})			
		
		}else{
			alert("請先登入會員")
		}
	}
	
	
	function checkDisLike(disLikeObiect){
        if("${loginmember.account}"!=""){
			
		}else{
			alert("請先登入會員")
		}
	}
	
	
	function articleAllLike(allLikejson,ArticleID){
		
		
	}
	
</script>

	<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>