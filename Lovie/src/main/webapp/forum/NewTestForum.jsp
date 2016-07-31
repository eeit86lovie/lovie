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
	width: 780px;
	overflow: hidden;
	margin: 15px auto;
	border: #ADADAD 1px solid;
	box-shadow: 0px 3px 3px rgba(0, 0, 0, 0.2);
	border-radius: 7px;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	background-color: #FFFFFF;
	overflow: hidden;
}


.BOX01 .article_header_div{
	width: 770px;
	height:250px;
	float: left;
	margin:5px 5px;
	height:50px;
	margin-buttom:2px;
	background-color: #FFFFFF;
}

.BOX01 .article_header_div .photo_div {
	width: 90px;
	height: 120px;
	display: block;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    float:left;
	margin-left:12px;
	margin-top:12px;
	display:inline;
}

.BOX01 .article_header_div .member {
	width: 300px;
	height:30px;
	margin:2px 3px 3px 10px;
	font-size: 26px;
	color:#1E90FF;
	font-weight: bold;
	float:left;
	margin-left:12px;
	margin-top:8px;

}

.BOX01 .article_header_div .genre{
	width: 80px;
	font-size: 24px;
	float:left;
	margin-top: 15px;
	margin-left: 35px;
	font-weight: bold;
}

.BOX01 .article_header_div .title {
	width: 500px;
	font-size: 24px;
	margin-left: 5px;
	float:left;
	font-weight: bold;

}

.BOX01 .content {
	width: 740px;
	clear:both;
	margin:10px 15px;
	background-color:#FFFFFF ;
	margin-top:150px;
	overflow: hidden;
	text-align: justify;
	font-size: 18px;
}



.photo {
	width: 120px;
	height: 80px;
}

.pubTime {
	width: 300px;
	margin: 20px 20px;
	float: right;
	text-align:right;
}

.editTime {
	width: 300px;
	margin: 0 20px 0 670px;
	float: right;
	text-align:right;
}

.replyButton {
	weight: 30px;
	height: 26px;
	border: #ADADAD 1px solid;
	border-radius: 5px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	background-Color: lightgreen;
	margin-top:20px;
}

.replyText {
	width: 650px;
	margin: 20px 15px 20px 15px;
	height: 26px;
	border: #ADADAD 1px solid;
	border-radius: 5px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	background-color: #FFFFFF;
	float: left;
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


input[type=checkbox] {
    display: none;
}



input[name="hideReply_checkBox"] + label span{
    display:inline-block;
    width:50px;
    height:50px;
    margin:-1px 4px 0 0;
    vertical-align:middle;   
    background:url('${pageContext.request.contextPath}/image/unhideReply.gif');
    background-size: 50% 50%;
    background-repeat:no-repeat;
    cursor:pointer;   
}

input[name="hideReply_checkBox"]:checked + label span{
    background:url('${pageContext.request.contextPath}/image/hideReply.gif');
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

.replyCountimg{
    width:25px;
    height:25px;
}

.countReplyimg_div{
	width:30px;
	height:25px;
	float: left;
	margin-left:5px;
	border: #ADADAD 1px solid;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
}


.like_Button_div{
	width:30px;
	height:25px;
	float: left;
	margin-left: 15px;
	border: #ADADAD 1px solid;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
}

.disLike_Button_div{
	width:30px;
	height:25px;
	float: left;
	margin-left:5px;
	border: #ADADAD 1px solid;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
}

.hideReply_div{
	width:30px;
	height:25px;
	float: left;
	margin-left: 5px;
	border: #ADADAD 1px solid;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
}


.BOX01 .ALLbutton_div{
	width:840px;
	background-color:CCCC00;
	float: left;
	margin-right:5px;
}


.BOX01 .addReply{
margin-top:50px;

}

.countLike_div{
	width:60px;
	height:25px;
	float: left;
	margin-left:5px;
}

.countDisLike_div{
	width:60px;
	height:25px;
	float: left;
	margin-left:5px;

}

.countReply_div{
	width:60px;
	height:25px;
	float: left;
	margin-left:5px;


}
</style>



</head>


<body>
	<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>


	<c:import charEncoding="UTF-8" url="/forum/NewLightBox.jsp"></c:import>
		
	
	
       
	
		
	<div class="row">
   
		
		<div class="col-md-2"></div>
		
		
		
		
		<div class="col-md-8">			
			<div id="box">
				<input type="button" id="addarticle" value="ADD" onclick="add()">
			</div>
		</div>
	
        <div class="col-md-2"></div>
    
        
	</div>
    


<div>
	<a id="xxx_trigger" href="#xxx" class="btn" onclick="testButton()">我要發表文章</a>
</div>

<div id="xxx" class="popupContainer" style="display:none;">
	<header class="popupHeader">
		<span class="header_title">發表文章</span>
		
	</header>

    <section class="popupBody">
    
      <div class="user_login">
    <form>
        <label>文章標題</label> <input type="text" id="updateTitle"><br>
        <p id ="error_title"></p>
        
        <label>文章分類</label>
        <select id="updateGenre">
	　		<option value="好雷">好雷</option>
	　		<option value="負雷">負雷</option>
	　		<option value="新聞">新聞</option>
	　		<option value="討論">討論</option>
	　		<option value="問片">問片</option>
	　		<option value="其他">其他</option>
	　	</select><br>

        <label>文章內容</label><TextArea type="text" id="updateTextArea"></TextArea><br>
        <p id="error_content"></p>
        
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
						url : "forumsAddarticle",
						type : "GET",
						dataType : "json",
						data : {
							addcontent:count
						},
						success : function(addarticlejson) {			
							$.ajax({
								url : "forumsAllLike",
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
	  		var article_pubTime_Text = document.createTextNode("發表時間:"+articleJson[i].pubTime);
	  		var article_editTime_Text = document.createTextNode("最後編輯時間:"+articleJson[i].editTime);
	 
	  		
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
				var hideReply_div = $("<div class='hideReply_div'></div>").append(hideReply);
				var hidelabel = document.createElement('label');
				hidelabel.setAttribute("for", hideReply.id);				
				var hidespan = document.createElement('span');
				hidespan.className ="hidespan";
				hidelabel.appendChild(hidespan);
				hideReply_div.append(hidelabel);
					
				
							
				var like_Button = document.createElement('input');//Like
				
				
				var countLike_div = $("<div onclick='selectRankPeople(this)' class='countLike_div' id='"+'countLike_div'+articleJson[i].id+"'></div>");
				
				
				
				//--------------------------------------------------------------------------------------------------------------------

				var testButton = document.createElement("button");
				var testButton_Text = document.createTextNode("測式按鈕");
				testButton.id = "testButton"+articleJson[i].id;
				testButton.setAttribute("onclick", "testButton(this)");
				testButton.setAttribute("href", "#xxx");
				testButton.appendChild(testButton_Text);
				
				
				//--------------------------------------------------------------------------------------------------------------------
				
				
				
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
				var countDisLike_div = $("<div class='countDisLike_div' id='"+'countDisLike_div'+articleJson[i].id+"'></div>");
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
	  		img.src = getmemberPhoto(articleJson[i].memberAccount).photoUrl;
	  		img.className = "photo_div";
	  		var Article_photo_div = $("<div></div>").append(img);
	  		var Article_member_div = $("<div class='member'></div>").append(linkMember);
	  		
	  		
			var Article_genre_div = $("<div class='genre'></div>").append(article_genre_Text);
	  		var Article_title_div = $("<div class='title'></div>").append(article_title_Text);
	  		var Article_content_div = $("<div class='content'></div>").append(article_content_Text);
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
	  		
	  
	 		
	  		var replyCountimg = document.createElement("img");
	  		replyCountimg.className = "replyCountimg";
	  		replyCountimg.src = "${pageContext.request.contextPath}/image/countReply.gif";
	  		var countReplyimg_div = $("<div class='countReplyimg_div'></div>").append(replyCountimg);
	  		countReplyimg_div.className = "countReplyimg_div"
	  		var countReply = Article_replyarea_div.children().length+"則留言";
	  		if(Article_replyarea_div.children().length>0){
	  			var countReply_div = $("<div class='countReply_div' id='"+'countReply_div'+articleJson[i].id+"'></div>").append(countReply);
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
							justIDisLike++
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
	  		article_header_div.append(Article_genre_div);
	  		article_header_div.append(Article_title_div);
	  		
	  		
	  		var ALLbutton_div = $("<div class='ALLbutton_div'></div>").append(like_Button_div);
	  		ALLbutton_div.append(countLike_div);
	  		ALLbutton_div.append(disLike_Button_div);
	  		ALLbutton_div.append(countDisLike_div);
	  		ALLbutton_div.append(countReplyimg_div);
	  		ALLbutton_div.append(countReply_div);
	  		ALLbutton_div.append(hideReply_div);
	  	
	  			  		
	  		Article_addReply_div.append(replyText);
	  		Article_addReply_div.append(replybutton);
	  		
	  		allarticle.append(article_header_div);//photo member pubTime title genre	 		
			allarticle.append(Article_content_div);//文章			
			allarticle.append(testButton);//---------------------------------------------------測式按鈕			
			allarticle.append(Article_editTime_div);
			allarticle.append(ALLbutton_div);//縮放文章 Like DisLike 留言人數 按鈕
			allarticle.append(Article_addReply_div);//留言按鈕加文字框
	 		allarticle.append(Article_replyarea_div);//新增留言放這
	 		
	 		
	 		
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
							$("#"+"replyarea"+replyButtonObject.id.substring(11)).prepend(replyAll_div);
							$("#"+"text"+replyButtonObject.id.substring(11)).val("");
							
						}		
					})			
						    var countReply_div_Id = $("#"+"countReply_div"+replyButtonObject.id.substring(11));
						    var newCountReply = parseInt(countReply_div_Id.text().slice(0,-3)) + 1;		
						    countReply_div_Id.text("");
						    countReply_div_Id.append(newCountReply+"則留言");	
		
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
				url : "forumsLike",
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
				url : "forumsDisLike",
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
	
	
	
	function testButton(testButtonObject){
		var article_ID = testButtonObject.id.substring(10);
		//deleteAreicle(article_ID);
		$("#"+testButtonObject.id).leanModal({top : 200, overlay : 0.6, closeButton: ".btn btn_red"});//修改文章用
		
		var id = updateArticle(article_ID);
		
	
	}
	
	
	
	
	
	function deleteAreicle(article_ID){
		
		$.ajax({
			url : "forumsDelete",
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
			url : "forumsSelectUpdate",
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
	   
   
   
   
   function clickUpdate(){
	    
	    var upArticleID = $("#updatebtn").prop("name");
 	    var updateMember = "${loginmember.account}";   
 	    var updateTitle = $("#updateTitle").val();
 		var updateGenre = $("#updateGenre").val();
 		var updateContent = $("#updateTextArea").text();

	   
		   $.ajax({
				url : "forumsUpdateArticle",
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
					alert("ssssssssss");
				}		
			})	
	  
	   
	  
	}
	

   
   
	
</script>

	<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>