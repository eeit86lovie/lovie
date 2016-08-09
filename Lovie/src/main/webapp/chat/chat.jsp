<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Chat</title>
    
    
    <link rel="stylesheet" href="${pageContext.request.contextPath }/chat/css/reset.css">

    
        <link rel="stylesheet" href="${pageContext.request.contextPath }/chat/css/style.css">
    
    <style>


/* The CSS */
select {
	min-width:150px;
    padding:3px;
    margin: 0;
    -webkit-border-radius:4px;
    -moz-border-radius:4px;
    border-radius:4px;
    -webkit-box-shadow: 0 3px 0 #ccc, 0 -1px #fff inset;
    -moz-box-shadow: 0 3px 0 #ccc, 0 -1px #fff inset;
    box-shadow: 0 3px 0 #ccc, 0 -1px #fff inset;
    background: #f8f8f8;
    color:#888;
    border:none;
    outline:none;
    display: inline-block;
    -webkit-appearance:none;
    -moz-appearance:none;
    appearance:none;
    cursor:pointer;
}

/* Targetting Webkit browsers only. FF will show the dropdown arrow with so much padding. */
@media screen and (-webkit-min-device-pixel-ratio:0) {
    select {padding-right:18px}
}

label {position:relative}
label:after {
    content:'<>';
    font:11px "Consolas", monospace;
    color:#aaa;
    -webkit-transform:rotate(90deg);
    -moz-transform:rotate(90deg);
    -ms-transform:rotate(90deg);
    transform:rotate(90deg);
    right:8px; top:2px;
    padding:0 0 2px;
    border-bottom:1px solid #ddd;
    position:absolute;
    pointer-events:none;
}
label:before {
    content:'';
    right:6px; top:0px;
    width:20px; height:20px;
    background:#f8f8f8;
    position:absolute;
    pointer-events:none;
    display:block;
}
    </style>
    
  </head>

  <body onload="connect()">

    <div class="wrapper">
    <div class="container">
        <div class="left">
            <div class="top">
                <label>
				    <select id="appendFriend" onchange="chooseFriend(this.options[this.options.selectedIndex])">
				    <option>選擇好友</option>
				    <c:forEach items="${friends}" var="friend">
				    	<option value="${friend.account }">${friend.nickname }</option>
				    </c:forEach>
				    </select>
				</label>
            </div>
            <ul class="people" id="peopleappend">
                
            </ul>
        </div>
        <div class="right" id="chatappend">
            <div class="top" ><span>To: <span data-id="" id="receiver" class="name"></span></span></div>
            
            <div class="write">
                <a href="javascript:;" class="write-link attach"></a>
                <input type="text" id="inputText" onkeydown="if (event.keyCode == 13) { sendMessage()}"/>
                <a href="javascript:;" class="write-link smiley"></a>
                <a href="#" onclick="sendMessage()" class="write-link send"></a>
            </div>
        </div>
    </div>
</div>

<span class="credits">design: <a href="https://dribbble.com/Miksa" target="_blank">milan</a>, code: <a href="http://codepen.io/Momciloo" target="_blank">momcilo</a></span>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.1/sockjs.min.js"></script>
    	<script src="//cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.14.1/moment.min.js"></script>
		<script src="${pageContext.request.contextPath }/chat/js/chat.js"></script>
    
    <script>
    $.ajax({
        url: 'info',
        type: 'GET',
        success: function(response) {
        	if(response[0]==null){
        	}else{
           	for(var i=0; i<response.length;i++){
           		appendPeople(response[i]);
           		appendRight(response[i]);
           	}
           	firstLoad();
        	}
        }
      });
    
		
// 		<div class="chat" data-chat="person1">
//         <div class="conversation-start">
//             <span>Today, 6:48 AM</span>
//         </div>
//         <div class="bubble you">
//             Hello,
//         </div>
//         <div class="bubble you">
//             it's me.
//         </div>
//         <div class="bubble you">
//             I was wondering...
//         </div>
//     </div>
	function appendRight(person){
		var fixedPerson;
		if(person['sender'] == ${loginmember.account}){
			fixedPerson = person['receiver'];
		}else{
			fixedPerson = person['sender']
		}
		if(document.getElementById(fixedPerson+'_chat')==null){
			person_div = $('<div></div>').attr('class', 'chat').attr('id', fixedPerson+'_chat').attr('data-chat',fixedPerson);
			var date = new Date(person['timestamp'])
			var dateString = date.getMonth()+1 +'/'+date.getDate()+' '+ date.getHours()+':'+date.getMinutes() 
			time_div = $('<div></div>').attr('class', 'conversation-start').html("<span>"+dateString+"</span>");
			if(person['sender']==${loginmember.account}){
				message_div = $('<div></div>').attr('class', 'bubble you').text(person['message'])
			}else{
				message_div = $('<div></div>').attr('class', 'bubble me').text(person['message'])
			}
			person_div.append(time_div).append(message_div);
			person_div.insertBefore($('.write'));
		}else{
			if(fixedPerson==person['sender']){
				appendMessage = $('<div></div').attr('class', 'bubble you').text(person['message']);
				$('#'+fixedPerson+'_chat').append(appendMessage);
			}else if(fixedPerson==person['receiver']){
				appendMessage = $('<div></div').attr('class', 'bubble me').text(person['message']);
				$('#'+fixedPerson+'_chat').append(appendMessage);
			}
			
		}
		
	}
	
//  <li class="person" data-chat="person1">
//  <img src="http://s13.postimg.org/ih41k9tqr/img1.jpg" alt="" />
//  <span class="name">Thomas Bangalter</span>
//  <span class="time">2:09 PM</span>
//  <span class="preview">I was wondering...</span>
//
	function appendPeople(person){
		var fixedPerson;
		var nickname;
		if(person['sender']==${loginmember.account}){
			fixedPerson = person['receiver'];
		}else{
			fixedPerson = person['sender'];
		}
		
		if(document.getElementById(fixedPerson)==null){
			 $.ajax({
				    url: '${pageContext.request.contextPath}/member/nickname/'+fixedPerson,
				    type: 'GET',
				    async: false,
				    success: function(response) {
				        nickname = response['nickname'];
				    }
				  });
			sender_li = $('<li></li>').attr('class', 'person').attr('id',fixedPerson).attr('data-chat',fixedPerson).attr('onclick', 'personClick(this)');
			sender_img = $('<img></img>').attr('src','${pageContext.request.contextPath}/photo/member/account/'+fixedPerson);
			sender_span_name = $('<span></span>').attr('class', 'name').text(nickname);
			var date = new Date(person['timestamp']);
			var dateString = date.getHours()+':'+date.getMinutes();
			sender_span_time = $('<span></span>').attr('class', 'time').text(dateString);
			sender_span_preview = $('<span></span>').attr('class', 'preview').text(person['message'])
			sender_li.append(sender_img).append(sender_span_name).append(sender_span_time).append(sender_span_preview);
			$('#peopleappend').append(sender_li);
		}else{
			$('#'+fixedPerson+' .preview').html(person['message']);
			var date = new Date(person['timestamp']);
			var dateString = date.getHours()+':'+date.getMinutes();
			$('#'+fixedPerson+' .time').html(dateString);
		}
	}
	
	function sendMessage(){
		var message = $('#inputText').val();
		$('#inputText').val("");
		var sender = ${loginmember.account};
		var receiver = $('#receiver').attr('data-id');
		stompClient.send("/app/chat", {}, JSON.stringify({ 'receiver': receiver , 'message':message}));
		
	}
	
	function personClick(object){
    	if ($(object).hasClass('person active')) {
            return false;
        } else {
        	
            var findChat = $(object).attr('data-chat');
            var personName = $(object).find('.name').text();
            $('.right .top .name').html(personName);
            $('.chat').removeClass('active-chat');
            $('.left .person').removeClass('active');
            $(object).addClass('active');
            $('.chat[data-chat = '+findChat+']').addClass('active-chat');
            $('#receiver').attr('data-id',findChat);
        }
    	};
	

    </script>
    <script>
    function firstLoad(){
    	var firstPerson = $('.right div:nth-child(2)').attr('data-chat')
    	var nickname;
    	$.ajax({
				    url: '${pageContext.request.contextPath}/member/nickname/'+firstPerson,
				    type: 'GET',
				    async: false,
				    success: function(response) {
				        nickname = response['nickname'];
				    }
				  });
	    $('.chat[data-chat='+firstPerson+']').addClass('active-chat');
	    $('.person[data-chat='+firstPerson+']').addClass('active');
	    $('#receiver').attr('data-id',firstPerson);
	    $('#receiver').text(nickname);
	    
    }
    
    
    
    function chooseFriend(friend){
    	if(friend.text!="選擇好友"){
	    	if(!$('#'+friend.value).hasClass('active')){
				$('#receiver').attr("data-id", friend.value).text(friend.text);
	    	}
	    	var checkPerson = document.getElementById(friend.value);
	    	if(checkPerson==null){
				$('.chat').removeClass('active-chat');
			}else{
				personClick($('#'+friend.value));
			}
    	}
    }
    
    </script>
  </body>
</html>
