<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

 input[type=checkbox] {
     display: none; 
 } 
input[name="hideUDR_checkBox"] + label span{
    display:inline-block;
    width:50px;
    height:50px;
    margin:-1px 4px 0 0;
    vertical-align:middle;   
    background:url('${pageContext.request.contextPath}/image/hideReply.gif');
    background-size: 50% 50%;
    background-repeat:no-repeat;
    cursor:pointer;   
}
input[name="hideUDR_checkBox"]:checked + label span{
    background:url('${pageContext.request.contextPath}/image/unhideReply.gif');
    background-size: 50% 50%;
    background-repeat:no-repeat;
}


input[name="hideReply_checkBox"] + label span{
     display:inline-block;
     width:50px;
     height:50px;
     margin:-1px 4px 0 0;
     vertical-align:middle;   
     background:url('${pageContext.request.contextPath}/image/countReply.gif');
     background-size: 50% 50%;
     background-repeat:no-repeat;
      cursor:pointer;   
  }


input[name="hideReply_checkBox"]:checked + label span{
      background:url('${pageContext.request.contextPath}/image/noReply.gif');
      background-size: 50% 50%;
      background-repeat:no-repeat;
  }



input[name="like_checkBox"] + label span{
    display:inline-block;
    width:50px;
    height:50px;    
    background:url('${pageContext.request.contextPath}/image/Noclick_like.gif');
    background-size: 50% 50%;
    background-repeat:no-repeat;
    cursor:pointer;   
}
input[name="like_checkBox"]:checked + label span{
    background:url('${pageContext.request.contextPath}/image/like.gif');
    background-size: 50% 50%;
    background-repeat:no-repeat;
}
input[name="dislike_checkBox"] + label span{
    display:inline-block;
    width:50px;
    height:50px;    
    background:url('${pageContext.request.contextPath}/image/Noclick_dislike.gif');
    background-size: 50% 50%;
    background-repeat:no-repeat;
    cursor:pointer;      
}
input[name="dislike_checkBox"]:checked + label span{
    background:url('${pageContext.request.contextPath}/image/dislike.gif');
    background-size: 50% 50%;
    background-repeat:no-repeat;
}

</style>

</head>
<body>

<script>

// $(window).scroll(function(){
//     //最後一頁scrollTop=body-window，50是預留空間
//     last=$("body").height()-$(window).height()-50
//     if($(window).scrollTop()>=last){
//     	add();
//     }
// })


// function dd(){
// 	 last=$("body").height()-$(window).height()-50
// 	    if($(window).scrollTop()>=last){
// 	    	add();
// 	    }
// }

//window.onload=scroll;

// function scroll(){
//     var sHeight = document.body.scrollTop;//滚动高度
//     var wHeight = document.documentElement.clientHeight;//window 
//     var dHeight = document.documentElement.offsetHeight;//整个文档高度
//     if(dHeight-(sHeight+wHeight)<100)
//     {
//     	alert("ssssssssss");
//     	add();
//     	//setTimeout(function() { add(); }, 5000);
    	
//     }
    
// };


// $(window).scroll(function() {
//    if($(window).scrollTop() + $(window).height() > $(document).height() - 100) {
// 	   add();
//    }
// });

		
		
			



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
						url : "${pageContext.request.contextPath}/forumsAddarticle",
						type : "GET",
						dataType : "json",
						data : {
							addcontent:count
						},
						success : function(addarticlejson) {			
							$.ajax({
								url : "${pageContext.request.contextPath}/forumsAllLike",
								type : "post",
								dataType : "json",
								success : function(allLikejson) {
			 						createArticle(addarticlejson,selectReplyjson,allLikejson);
			 			
								}					
							})
						}					
					})
				}		
			})	
		}	
	})
   }











	function createArticle(articleJson,selectReplyjson,allLikejson){
		
		for(i = 0; i<articleJson.length;i++){
	      
			var allarticle = $("<div class='BOX01' id='"+'BOX01'+articleJson[i].id+"'></div>");
			var linkMember = document.createElement("a");
			var memberLink = "${pageContext.request.contextPath}/member/profile/"+getmemberPhoto(articleJson[i].memberAccount).id;
			linkMember.setAttribute("href", memberLink);
			var article_memberAccount_Text = document.createTextNode(getmemberPhoto(articleJson[i].memberAccount).nickname);
			linkMember.appendChild(article_memberAccount_Text);
			
			var article_genre_Text = document.createTextNode(articleJson[i].genre);
	  		var article_title_Text = document.createTextNode(articleJson[i].title);
	  		var article_content_Text = document.createTextNode(articleJson[i].content);
	  		var time_pubTime = new Date(articleJson[i].pubTime);
	  		var article_pubTime_Text = document.createTextNode("發表時間:"+time_pubTime.customFormat( "#YYYY#-#MM#-#DD# #hh#:#mm#:#ss#" ));
	  		time_editTime = new Date(articleJson[i].editTime);
	  		var article_editTime_Text = document.createTextNode("最後編輯時間:"+ time_editTime.customFormat( "#YYYY#-#MM#-#DD# #hh#:#mm#:#ss#" ));
	
	  		var replyText = document.createElement("input");
				replyText.setAttribute("type", "text");
				replyText.className = "replyText";
				replyText.id="text" + articleJson[i].id;
				FocusReplyText
				replyText.setAttribute("onfocus", "FocusReplyText(this)");
				//replyText.setAttribute("onblur", "onBlurReplyText(this)");
				
			var replybutton = document.createElement("button");
			    replybutton.id = "replyButton" + articleJson[i].id;
			    replybutton.className="replyButton";
				replybutton.setAttribute("onclick", "clickReplyButton(this)");
				var reply_button_Text = document.createTextNode("留言");
				//var reply_addcontent_error_div = document.createElement("div");
				//reply_addcontent_error_div.className="errormessage";
				replybutton.appendChild(reply_button_Text);	
				
				
			
				var hideReply = document.createElement('input');//隱藏留言
				hideReply.type = "checkbox";
				hideReply.id = "hideReply"+articleJson[i].id;
				hideReply.checked="checked";
				hideReply.className ="hideReply_checkBox";
				hideReply.name ="hideReply_checkBox";
				hideReply.setAttribute("onchange", "heidReplyDiv(this)");
				//var hideReply_div = $("<div class='hideReply_div'></div>").append(hideReply);
				var hidelabel = document.createElement('label');
				hidelabel.setAttribute("for", hideReply.id);				
				var hidespan = document.createElement('span');
				hidespan.className ="hidespan";
				hidelabel.appendChild(hidespan);
				//hideReply_div.append(hidelabel);
					
				
				
							
				
				
				
				
				//--------------------------------------------------------------------------------------------------------------------

// 				var testButton = document.createElement("button");
// 				var testButton_Text = document.createTextNode("測式按鈕");
// 				testButton.id = "testButton"+articleJson[i].id;
// 				testButton.setAttribute("onclick", "testButton(this)");
// 				//testButton.setAttribute("href", "#xxx");
// 				testButton.appendChild(testButton_Text);
// 				var testButton_div = $("<div id='"+'testButton_div'+articleJson[i].id+"'></div>");
				
				
				var articleUDR = document.createElement('input');//Update Delete Report
				articleUDR.type = "checkbox";
				articleUDR.id = "articleUDR"+articleJson[i].id;
				
				articleUDR.className ="hideUDR_checkBox";
				articleUDR.name ="hideUDR_checkBox";
				var articleUDRlabel = document.createElement('label');
				articleUDRlabel.setAttribute("for", articleUDR.id );				
				var articleUDRspan = document.createElement('span');
				articleUDRspan.className ="hidespan";
				articleUDRlabel.appendChild(articleUDRspan);
				
				
				articleUDR.setAttribute("onchange", "articleUDR(this)");
				var articleUDR_div =$("<div class='articleUDR_div' id='"+'articleUDR_div'+articleJson[i].id+"'></div>").append(articleUDR);
				var articleUDR_ul = $("<ul class='articleUDR_ul' id='"+'articleUDR_ul'+articleJson[i].id+"'></ul>");
				var articleUDR_ul_div = $("<div class='articleUDR_ul_div' id='"+'articleUDR_ul_div'+articleJson[i].id+"'></div>");
				articleUDR_div.append(articleUDRlabel);
				
				
				if(articleJson[i].memberAccount == "${loginmember.account}"){
		        	articleUpdate = $("<li></li>");
		        	var updateButton = document.createElement("button");
	 				var updateButton_Text = document.createTextNode("修改文章");
	 				updateButton.appendChild(updateButton_Text);
	 				updateButton.id = "updateButton"+articleJson[i].id;
	 				updateButton.setAttribute("onclick", "updateButton(this)");
	 				updateButton.setAttribute("href", "#Update_Article");
		        	articleUpdate.append(updateButton);
		        	articleUDR_ul.append(articleUpdate);
		        	
		        	articleDelete = $("<li></li>");
		        	var deleteButton = document.createElement("button");
	 				var deleteButton_Text = document.createTextNode("刪除文章");
	 				deleteButton.appendChild(deleteButton_Text);
	 				deleteButton.id = "deleteButton"+articleJson[i].id;
	 				deleteButton.setAttribute("onclick", "deleteButton(this)");
		        	articleDelete.append(deleteButton);
		        	articleUDR_ul.append(articleDelete);
		        }else{
		        	
		        	
		        		articleReport = $("<li></li>");
			        	var reportButton = document.createElement("button");
		 				var reportButton_Text = document.createTextNode("檢舉文章");
		 				reportButton.appendChild(reportButton_Text);
		 				reportButton.id = "reportButton"+articleJson[i].id;
		 				reportButton.setAttribute("onclick", "reportButton(this)");
		 				reportButton.setAttribute("href", "#Report_Article");
			        	articleReport.append(reportButton);
			        	articleUDR_ul.append(articleReport);
		        	
		        	
		        }						
				
				articleUDR_ul_div.append(articleUDR_ul)
				articleUDR_div.append(articleUDR_ul_div);
				
				
				//--------------------------------------------------------------------------------------------------------------------
				
				
				var like_Button = document.createElement('input');//Like
				var countLike_div = $("<div onclick='selectLikePeople(this)' class='countLike_div' id='"+'countLike_div'+articleJson[i].id+"'></div>");
				like_Button.type = "checkbox";
				like_Button.id = "like_Button"+articleJson[i].id;
				like_Button.name = "like_checkBox";
				like_Button.setAttribute("onchange", "checkLike(this)");
				var like_Button_div = $("<div class='like_Button_div' id='"+'like_Button_div'+articleJson[i].id+"'></div>").append(like_Button);
				var likelabel = document.createElement('label');
				likelabel.setAttribute("for", like_Button.id);				
				var likespan = document.createElement('span');
				likelabel.appendChild(likespan);
				like_Button_div.append(likelabel);
				
				
				var disLike_Button = document.createElement('input');//DisLike
				var countDisLike_div = $("<div onclick='selectDisLikePeople(this)' class='countDisLike_div' id='"+'countDisLike_div'+articleJson[i].id+"'></div>");
				disLike_Button.type = "checkbox";
				disLike_Button.id = "disLike_Button"+articleJson[i].id;
				disLike_Button.name = "dislike_checkBox";
				disLike_Button.setAttribute("onchange", "checkDisLike(this)");
				var disLike_Button_div = $("<div class='disLike_Button_div' id='"+'disLike_Button_div'+articleJson[i].id+"'></div>").append(disLike_Button);				
				var dislikelabel = document.createElement('label');
				dislikelabel.setAttribute("for", disLike_Button.id);				
				var dislikespan = document.createElement('span');
				dislikelabel.appendChild(dislikespan);
				disLike_Button_div.append(dislikelabel);
				
	  		
	  		var img = document.createElement("img");
	  		img.src = "${pageContext.request.contextPath}/photo/member/"+getmemberPhoto(articleJson[i].memberAccount).id;
	  		img.className = "photo_div";
	  		var Article_photo_div = $("<div></div>").append(img);
	  		var Article_member_div = $("<div class='member'></div>").append(linkMember);	  		
	  		var Article_genre_p = $("<p class='genre_p'></p>").append(article_genre_Text);
	  		var Article_genre_div = $("<div class='genre'></div>").append(Article_genre_p);	  		
			var Article_title_div = $("<div class='title'></div>").append(article_title_Text);
	  		//var Article_content_div = $("<div class='content'></div>").append(article_content_Text);
	  		var tempTextarea=$("<span></span>").append(articleJson[i].content);
	  		var Article_content_div = $("<div class='content'></div>").append(tempTextarea);
	  		var Article_pubTime_div = $("<div class='pubTime'></div>").append(article_pubTime_Text);
	  		var Article_editTime_div = $("<div class='editTime'></div>").append(article_editTime_Text);
	  		var Article_replyarea_div = $("<div class='replyarea' id='"+'replyarea'+articleJson[i].id+"'></div>");
	  		var Article_addReply_div = $("<div class='addReply' id='"+'addReply'+articleJson[i].id+"'></div>");
	  		
	  		
	  	
	  		
	  	
  		

	  		
	  		if(selectReplyjson!=null){
		  		for(k = 0; k < Object.keys(selectReplyjson).length;k++){
					if(selectReplyjson[k].articleID == articleJson[i].id){
					returnReplyString = JSON.stringify(selectReplyjson[k]);
					var returnReplyjson = JSON.parse(returnReplyString);
					var replyAll_div = createReply(returnReplyjson);
					Article_replyarea_div.prepend(replyAll_div);	
							}	
		  			}
	  		}
	  		
	  
	 		
	  		//var replyCountimg = document.createElement("img");
	  		//replyCountimg.className = "replyCountimg";
	  		//replyCountimg.src = "${pageContext.request.contextPath}/image/countReply.gif";
	  		var countReplyimg_div = $("<div class='countReplyimg_div'></div>").append(hideReply);
	  		countReplyimg_div.append(hidelabel);
	  		countReplyimg_div.className = "countReplyimg_div"
	  		var countReply = Article_replyarea_div.children().length+"則留言";
	  		var countReply_div = $("<div class='countReply_div' id='"+'countReply_div'+articleJson[i].id+"'></div>");
	  		if(Article_replyarea_div.children().length>0){
	  			countReply_div.append(countReply);
	  		}
	  		
	  		
	  		
	  		if(allLikejson!=null){//顯示每筆文章的Like && DisLike
	  			var countLike = 0;
	  			var countDisLike = 0;
	  			var myself ="";
	  			var justILike = 0;
	  			var justIDisLike = 0;
	  			for(m =0; m<allLikejson.length;m++){
					if(allLikejson[m].articleID == articleJson[i].id){
					
						if(allLikejson[m].good == 1 && allLikejson[m].memberAccount == "${loginmember.account}"){
							myself = "你和其他";
							like_Button.checked="checked";
							justILike++;
						
						}else if(allLikejson[m].good == 1){
							countLike++;							
						}
						
						if(allLikejson[m].bad == 1 && allLikejson[m].memberAccount == "${loginmember.account}"){
							myself = "你和其他"
							disLike_Button.checked="checked";
							justIDisLike++;
							
						}else if(allLikejson[m].bad == 1){
							countDisLike++;
						}
					}
		  		}
			  	    
		  			if(justILike==1){
			  	    	countLike_div.append("你覺得Like");
		  			}
	  				if(countLike==0){
			  	    	countLike_div.append("");
			  	    }else{
			  	    	countLike_div.empty();
			  	    	countLike_div.append(myself + countLike+"人Like");
			  	    }
	  			
	  				
	  				if(justIDisLike==1){
	  					countDisLike_div.append("你覺得disLike");
		  			}
			  	    if(countDisLike==0){
			  	    	countDisLike_div.append("");
			  	    }else{
			  	    	countDisLike_div.empty();
			  	    	countDisLike_div.append(myself + countDisLike+"人disLike");
			  	    }
	  		
	  		}
	  		
	  	 
	  		
	  		
	  		
	  		var article_header_div = $("<div class='article_header_div'></div>").append(Article_photo_div);
	  		article_header_div.append(Article_member_div);
	  		article_header_div.append(Article_pubTime_div);
	  		article_header_div.append(articleUDR_div);//檢舉 新增 刪除div	
	  		article_header_div.append(Article_genre_div);
	  		article_header_div.append(Article_title_div);
	  		
	  		
	  		var ALLbutton_div = $("<div class='ALLbutton_div'></div>").append(like_Button_div);
	  		ALLbutton_div.append(countLike_div);
	  		ALLbutton_div.append(disLike_Button_div);
	  		ALLbutton_div.append(countDisLike_div);
	  		ALLbutton_div.append(countReplyimg_div);
	  		ALLbutton_div.append(countReply_div);
	  		//ALLbutton_div.append(hideReply_div);
	  	
	  			  		
	  		Article_addReply_div.append(replyText);
	  		Article_addReply_div.append(replybutton);
	  		
	  		allarticle.append(article_header_div);//photo member pubTime title genre	 		
			allarticle.append(Article_content_div);//文章									
				
			
			allarticle.append(ALLbutton_div);//縮放文章 Like DisLike 留言人數 按鈕
			allarticle.append(Article_addReply_div);//留言按鈕加文字框
			allarticle.append(Article_editTime_div);
	 		allarticle.append(Article_replyarea_div);//新增留言放這	 		
	 		havereport(articleJson[i].id);//放入已檢舉
	 		
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


	
	function getmemberNickName(nickName){
		var Member = "";
		for(var j = 0; j<Object.keys(memberJson).length;j++){
			if(memberJson[j].nickname == nickName){
				Member = memberJson[j];
				return Member;
			}
		}
		return Member;
	}//end of getMemberPhoto

	
	
	
	function clickReplyButton(replyButtonObject){
		$("#errormessage").remove();
		var replyValue = $("#"+"text"+replyButtonObject.id.substring(11)).val();
		var replyArticle_id = replyButtonObject.id.substring(11);
		var replyMember ="${loginmember.account}";
		
		if(replyValue != ""){//需要再判斷有無登入
			
					$.ajax({
						url : "${pageContext.request.contextPath}/forumsAddreply",
						type : "POST",
						dataType : "json",
						data : {
							ReplyArticle_ID:replyArticle_id,
							ReplyMember:replyMember,
							ReplyContent:replyValue
						},
						success : function(articleReplyResult) {
							var replyAll_div = createReply(articleReplyResult);
							$("#"+"replyarea"+replyButtonObject.id.substring(11)).prepend(replyAll_div);
							$("#"+"text"+replyButtonObject.id.substring(11)).val("");
							
						}		
					})			
						    var countReply_div_Id = $("#"+"countReply_div"+replyButtonObject.id.substring(11));
						    var newCountReply = parseInt(countReply_div_Id.text().slice(0,-3)) + 1;		
						    countReply_div_Id.text("");
						    if(isNaN(newCountReply)){
						    	 countReply_div_Id.append("1則留言");	
						    }else{	
						    	 countReply_div_Id.append(newCountReply+"則留言");	
						    	 }	
		
		}else{
				var error_message = $("<div class='errormessage' id='errormessage'></div>").append("請輸入留言");
				$("#"+"addReply"+ replyButtonObject.id.substring(11)).append(error_message);
			}
	}
	

	
	function createReply(returnReplyjson){
		
	
		var Reply_img = document.createElement("img");
		Reply_img.src = "${pageContext.request.contextPath}/photo/member/"+getmemberPhoto(returnReplyjson.memberAccount).id;
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
	  	
	  	var time_replyTime = new Date(returnReplyjson.pubTime);
	  	var Reply_pubTime_div = $("<div class='replypubTime'></div>").append("留言時間:"+time_replyTime.customFormat( "#YYYY#-#MM#-#DD# #hh#:#mm#:#ss#" ));	
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
	
	
	function articleUDR(articleUDRObject){
		var articleUDR_id = articleUDRObject.id.substring(10);
		
		if(document.getElementById("articleUDR"+articleUDR_id).checked){
			$("#"+"articleUDR_ul_div"+articleUDR_id).show();
		}else{
			$("#"+"articleUDR_ul_div"+articleUDR_id).hide();
		}
	}
	
	
// 	function onBlurReplyText(onBlurReplyObject){
// 		$("#"+"hideReply"+onBlurReplyObject.id.substring(4)).prop("checked",true);
		
// 		if($("#"+"hideReply"+onBlurReplyObject.id.substring(4)).attr("checked",true)){
// 			  $("#"+"replyarea"+onBlurReplyObject.id.substring(4)).slideUp(1000);
// 		  }
		
// 	}
	
	function selectRank(allLikejson,article_Id){
		for(m =0; m<allLikejson.length;m++){
			if(allLikejson[m].articleID == article_Id){
				return allLikejson[m];
			}
		}
	}
	
	
	
	
	
	function checkLike(likeObiect){
		var like = 0;
		if(document.getElementById(likeObiect.id).checked){				
			like = 1;			
		}
		if("${loginmember.account}"!=""){
			
			var likeArticleId = likeObiect.id.substring(11);
			var likeMember = "${loginmember.account}"
			$.ajax({
				url : "${pageContext.request.contextPath}/forumsLike",
				type : "POST",
				dataType : "json",
				data : {
					LikeArticleId:likeArticleId,
					LikeMember:likeMember,
					Like:like
				},
				success : function(articleLikeResult) {
					
					var countLike_div_Id = $("#"+"countLike_div"+likeObiect.id.substring(11));
					if(document.getElementById(likeObiect.id).checked){				
			            var otherLike = articleLikeResult.length-1;
			            if(otherLike == 0){
			            	countLike_div_Id.text("");
				            countLike_div_Id.append("你覺得Like");
			            }else{
			            	countLike_div_Id.text("");
				            countLike_div_Id.append("你和其他"+ otherLike +"人Like");
			            }			            
					}else{			
						if(articleLikeResult.length==0){
							countLike_div_Id.text("");
						}else{
							countLike_div_Id.text("");
							countLike_div_Id.append(articleLikeResult.length+"人Like");
						}
			 		}		
				}		
			})			
		
		}else{
			alert("請先登入會員")
		}
	}
	
	
	function checkDisLike(disLikeObiect){
		var disLike = 0;
		if(document.getElementById(disLikeObiect.id).checked){				
			 //$("#"+"Like_Button"+disLikeObiect.id.substring(11)).prop("checked",true);
			disLike = 1;
		}
		if("${loginmember.account}"!=""){
	
			var disLikeArticleId = disLikeObiect.id.substring(14);
			var disLikeMember = "${loginmember.account}"
			$.ajax({
				url : "${pageContext.request.contextPath}/forumsDisLike",
				type : "POST",
				dataType : "json",
				data : {
					DisLikeArticleId:disLikeArticleId,
					DisLikeMember:disLikeMember,
					DisLike:disLike
				},
				success : function(articleDisLikeResult) {
					var countDisLike_div_Id = $("#"+"countDisLike_div"+disLikeObiect.id.substring(14));
					
					if(document.getElementById(disLikeObiect.id).checked){				
			            var otherdisLike = articleDisLikeResult.length-1;
			            if(otherdisLike == 0){
			            	 countDisLike_div_Id.text("");
					         countDisLike_div_Id.append("你覺得DisLike");
			            }else{
				            countDisLike_div_Id.text("");
				            countDisLike_div_Id.append("你和其他"+ otherdisLike +"人DisLike");
			            }
					}else{			
						if(articleDisLikeResult.length==0){
							countDisLike_div_Id.text("");
						}else{
							countDisLike_div_Id.text("");
							countDisLike_div_Id.append(articleDisLikeResult.length+"人DisLike");
						}
			 		}		
				}		
			})			
		
		}else{
			alert("請先登入會員")
		}
	}
	
	
	
	function updateButton(updateButtonObject){
		var article_ID = updateButtonObject.id.substring(12);
		$("#"+updateButtonObject.id).leanModal({top : 200, overlay : 0.6, closeButton: ".btn btn_red"});//修改文章用
		updateArticle(article_ID);
	
	}
	
	
	function reportButton(reportButtonObject){
		var article_ID = reportButtonObject.id.substring(12);
		$("#"+reportButtonObject.id).leanModal({top : 200, overlay : 0.6, closeButton: ".btn btn_red"});//檢舉文章用
		$.ajax({
			url : "${pageContext.request.contextPath}/forumsSelectUpdate",
			type : "POST",
			dataType : "json",
			data : {
				Article_ID:article_ID,
			},
			success : function(selectUpdateArticlejson) {
				var reportTitle = $("#reportTitle").val(selectUpdateArticlejson.title);
				$("#reportbtn").attr("name",selectUpdateArticlejson.id);
			}		
		})				
		
		
		
	}
	
	
	
	
	
	function deleteButton(deleteButtonObject){
		
		var article_ID = deleteButtonObject.id.substring(12);
		$.ajax({
			url : "${pageContext.request.contextPath}/forumsDelete",
			type : "POST",
			
			data : {
				Article_ID:article_ID,
			},
			success : function(deleteCount) {
				if(deleteCount==1){
					$("#"+"BOX01"+ article_ID).remove();
					alert("刪除成功");
				}else{
					alert("刪除失敗");
				}
			}		
		})			
	}
	
	
   function updateArticle(article_ID){
		
	   $.ajax({
			url : "${pageContext.request.contextPath}/forumsSelectUpdate",
			type : "POST",
			dataType : "json",
			data : {
				Article_ID:article_ID,
			},
			success : function(selectUpdateArticlejson) {
				var updateTitle = $("#updateTitle").val(selectUpdateArticlejson.title);
				var updateGenre = $("#updateGenre").val(selectUpdateArticlejson.genre);
				var updateContent = $("#updateTextArea").text(selectUpdateArticlejson.content);
				$("#updatebtn").attr("name",selectUpdateArticlejson.id); 
			}		
		})				
	   
     
   }	   
	   
   

	function clickReportButton(){
		
		var report_Member = "${loginmember.account}"; 
		var report_Article_ID = $("#reportbtn").prop("name");
		var report_content = $("#reportContent").val();				
		
		
		var error_report_content = 0;			
			
			
			if(report_content==""){
				$("#error_report_content").empty();
				$("#error_report_content").append("請輸入檢舉內容");
				var error_report_content = 1;
			}else{
				$("#error_report_content").empty();
			}
			
			
			if(error_report_content == 0){
				$.ajax({
					url : "${pageContext.request.contextPath}/forumsReport",
					type : "POST",
					
					data : {
						Report_Member:report_Member,
						Report_Article_ID:report_Article_ID,
						Report_content:report_content,
					},
					success : function(haveReport) {
						if(haveReport==1){
							$("#reportContent").val("");
							$("#lean_overlay").hide();
							$("#Report_Article").hide();
							alert("檢舉成功");					
						}else{
							$("#reportContent").val("")
							$("#lean_overlay").hide();
							$("#Report_Article").hide();
							alert("檢舉失敗");
						}
						havereport(report_Article_ID);
					}		
				})			
			
			}	
		
		
		
		
		
	}
	
   
   function clickUpdate(){
	    
	    var upArticleID = $("#updatebtn").prop("name");
 	    var updateMember = "${loginmember.account}";   
 	    var updateTitle = $("#updateTitle").val();
 		var updateGenre = $("#updateGenre").val();
 		var updateContent = $("#updateTextArea").val();
		
		var error_update_title = 0;
		var error_update_content = 0;
	
				if(updateTitle==""){
					$("#error_update_title").empty();
					$("#error_update_title").append("請輸入標題");
					var error_update_title = 1;
				}else{
					$("#error_update_title").empty();
				}
				
				if(updateContent==""){
					$("#error_update_content").empty();
					$("#error_update_content").append("請輸入內容");
					var error_update_content = 1;
				}else{
					$("#error_update_content").empty();
				}
				
				
				if(error_update_title == 0 && error_update_content == 0){
					$.ajax({
						url : "${pageContext.request.contextPath}/forumsUpdateArticle",
						type : "POST",
						dataType : "json",
						data : {
							
							UpdateArticleId:upArticleID,
							UpdateMember:updateMember,
							UpdateTitle:updateTitle,
							UpdateGenre:updateGenre,
							UpdateContent:updateContent,
						},
						success : function(UpdateArticle) {
							
							var updateGenre = $("#"+"BOX01"+UpdateArticle.id).find(".genre_p")
							var updateTitle = $("#"+"BOX01"+UpdateArticle.id).find(".title")
							var updateContent = $("#"+"BOX01"+UpdateArticle.id).find(".content")
							
							
							updateGenre.empty();
							updateGenre.append(UpdateArticle.genre);
							
							updateTitle.empty();
							updateTitle.append(UpdateArticle.title);
							
							updateContent.empty();
							updateContent.append(UpdateArticle.content);
							
							$("#lean_overlay").hide();
							$("#Update_Article").hide();
							
						}		
					})	
				
				}	
			
	  
	}
	

   
   function havereport(article_ID){
	   
	   
	   $.ajax({
			url : "${pageContext.request.contextPath}/forumsHaveReport",
			type : "POST",
			dataType : "json",
			success : function(haveReportResult) {
				
				for(o =0;o<haveReportResult.length;o++){
					if(haveReportResult[o].memberAccount == "${loginmember.account}" && haveReportResult[o].articleID == article_ID){
						$("#"+"articleUDR_ul"+haveReportResult[o].articleID).empty();						
						$("#"+"articleUDR_div"+haveReportResult[o].articleID).append($("<div class ='haveReport'></div>").append("已檢舉"));
						
					}
				}
				
			}		
		})	
		
   }
   
   
   
   function closeNav() {
	    document.getElementById("myNav").style.height = "0%";
   }
   
   function selectLikePeople(selectLikePeopleObject){
	   $("#selectLike_ul").empty();
	   document.getElementById("myNav").style.height = "40%";
		
		$.ajax({
			url : "${pageContext.request.contextPath}/forumsAllLike",
			type : "post",
			dataType : "json",
			success : function(allLikejson) {
				
				var article_ID = selectLikePeopleObject.id.substring(13);
				
				
				for(m =0; m<allLikejson.length;m++){
					if(allLikejson[m].articleID==article_ID){
						if(allLikejson[m].good == 1){
							var li_Rank = $("<li></li>");											
							//var rankPeople_div = $("<div ></div>");
							//var rankPeopleName_div = $("<div></div>").append(getmemberPhoto(allLikejson[m].memberAccount).nickname);
							
							var linklikeMember = document.createElement("a");
							var likememberLink = "${pageContext.request.contextPath}/member/profile/"+getmemberPhoto(allLikejson[m].memberAccount).id;
							linklikeMember.setAttribute("href", likememberLink);
							
							
							var rankPeople_img = document.createElement("img");
							rankPeople_img.className ="rankPeople_img";
							rankPeople_img.src = "${pageContext.request.contextPath}/photo/member/"+getmemberPhoto(allLikejson[m].memberAccount).id;
				
							
							linklikeMember.appendChild(rankPeople_img);
							//rankPeople_div.append(rankPeople_img);
							//rankPeople_div.append(rankPeopleName_div);	
							
							li_Rank.append(linklikeMember);
							
														
							$("#selectLike_ul").append(li_Rank);
						}
						
						
					}
				
				}
				
			}					
		})
		

	}
   
   
   function selectDisLikePeople(selectDisLikePeopleObject){
	   $("#selectLike_ul").empty();
	   document.getElementById("myNav").style.height = "40%";
		
		$.ajax({
			url : "${pageContext.request.contextPath}/forumsAllLike",
			type : "post",
			dataType : "json",
			success : function(allLikejson) {
				
				var article_ID = selectDisLikePeopleObject.id.substring(16);
				
				
				for(m =0; m<allLikejson.length;m++){
					if(allLikejson[m].articleID==article_ID){
						if(allLikejson[m].bad == 1){
							var li_Rank = $("<li></li>");											
							//var rankPeople_div = $("<div ></div>");
							//var rankPeopleName_div = $("<div></div>").append(getmemberPhoto(allLikejson[m].memberAccount).nickname);
							var linkDislikeMember = document.createElement("a");
							var DislikememberLink = "${pageContext.request.contextPath}/member/profile/"+getmemberPhoto(allLikejson[m].memberAccount).id;
							linkDislikeMember.setAttribute("href", DislikememberLink);
							
							
							var rankPeople_img = document.createElement("img");
							rankPeople_img.className ="rankPeople_img";
							rankPeople_img.src = "${pageContext.request.contextPath}/photo/member/"+getmemberPhoto(allLikejson[m].memberAccount).id;
				
							linkDislikeMember.appendChild(rankPeople_img);
							li_Rank.append(linkDislikeMember);
							//rankPeople_div.append(rankPeopleName_div);
							//a_Rank.appendChild(rankPeople_img);	
							$("#selectLike_ul").append(li_Rank);
						}
						
						
					}
				
				}
				
			}					
		})
		

	}

   
   Date.prototype.customFormat = function(formatString){
	   var YYYY,YY,MMMM,MMM,MM,M,DDDD,DDD,DD,D,hhhh,hhh,hh,h,mm,m,ss,s,ampm,AMPM,dMod,th;
	   YY = ((YYYY=this.getFullYear())+"").slice(-2);
	   MM = (M=this.getMonth()+1)<10?('0'+M):M;
	   MMM = (MMMM=["January","February","March","April","May","June","July","August","September","October","November","December"][M-1]).substring(0,3);
	   DD = (D=this.getDate())<10?('0'+D):D;
	   DDD = (DDDD=["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"][this.getDay()]).substring(0,3);
	   th=(D>=10&&D<=20)?'th':((dMod=D%10)==1)?'st':(dMod==2)?'nd':(dMod==3)?'rd':'th';
	   formatString = formatString.replace("#YYYY#",YYYY).replace("#YY#",YY).replace("#MMMM#",MMMM).replace("#MMM#",MMM).replace("#MM#",MM).replace("#M#",M).replace("#DDDD#",DDDD).replace("#DDD#",DDD).replace("#DD#",DD).replace("#D#",D).replace("#th#",th);
	   h=(hhh=this.getHours());
	   if (h==0) h=24;
	   if (h>12) h-=12;
	   hh = h<10?('0'+h):h;
	   hhhh = hhh<10?('0'+hhh):hhh;
	   AMPM=(ampm=hhh<12?'am':'pm').toUpperCase();
	   mm=(m=this.getMinutes())<10?('0'+m):m;
	   ss=(s=this.getSeconds())<10?('0'+s):s;
	   return formatString.replace("#hhhh#",hhhh).replace("#hhh#",hhh).replace("#hh#",hh).replace("#h#",h).replace("#mm#",mm).replace("#m#",m).replace("#ss#",ss).replace("#s#",s).replace("#ampm#",ampm).replace("#AMPM#",AMPM);
	 };
   
</script>


</body>
</html>