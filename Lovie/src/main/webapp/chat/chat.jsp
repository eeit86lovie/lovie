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
    
    
    
  </head>

  <body>

    <div class="wrapper">
    <div class="container">
        <div class="left">
            <div class="top">
                <input type="text" />
                <a href="javascript:;" class="search"></a>
            </div>
            <ul class="people" id="peopleappend">
                
            </ul>
        </div>
        <div class="right">
            <div class="top" id="chatappend"><span>To: <span class="name">Dog Woofson</span></span></div>
            
            <div class="write">
                <a href="javascript:;" class="write-link attach"></a>
                <input type="text" />
                <a href="javascript:;" class="write-link smiley"></a>
                <a href="javascript:;" class="write-link send"></a>
            </div>
        </div>
    </div>
</div>

<span class="credits">design: <a href="https://dribbble.com/Miksa" target="_blank">milan</a>, code: <a href="http://codepen.io/Momciloo" target="_blank">momcilo</a></span>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.1/sockjs.min.js"></script>
    	<script src="//cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.14.1/moment.min.js"></script>
        <script src="${pageContext.request.contextPath }/chat/js/index.js"></script>
		<script src="${pageContext.request.contextPath }/chat/js/chat.js"></script>
    
    <script>
    $.ajax({
        url: 'info',
        type: 'GET',
        success: function(response) {
           	for(var i=0; i<response.length;i++){
           		appendPeople(response[i]);
           		appendRight(response[i])
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
		person_div = $('<div></div>').attr('class', 'chat').attr('data-chat',fixedPerson);
		var dateString = moment.unix(person['timestamp']).format("MM/DD/YYYY hh:mm A");
		time_div = $('<div></div>').attr('class', 'conversation-start').html("<span>"+dateString+"</span>");
		if(person['sender']==${loginmember.account}){
			message_div = $('<div></div>').attr('class', 'bubble you').text(person['message'])
		}else{
			message_div = $('<div></div>').attr('class', 'bubble me').text(person['message'])
		}
		person_div.append(time_div).append(message_div);
		$('#chatappend').append(person_div);
		
	}
	
//  <li class="person" data-chat="person1">
//  <img src="http://s13.postimg.org/ih41k9tqr/img1.jpg" alt="" />
//  <span class="name">Thomas Bangalter</span>
//  <span class="time">2:09 PM</span>
//  <span class="preview">I was wondering...</span>
//
	function appendPeople(person){
		var fixedPerson;
		if(person['sender']!=${loginmember.account}){
			fixedPerson = person['receiver'];
		}else{
			fixedPerson = person['sender'];
		}
		checkPersonInList(fixedPerson)
		if($('.person').attr('data-chat')!=person['sender'] && person['sender']!=${loginmember.account}){
			sender_li = $('<li></li>').attr('class', 'person').attr('data-chat',person['sender']);
			sender_img = $('<img></img>').attr('src','http://localhost:8080/Lovie/photo/member/account/'+person['sender']);
			sender_span_name = $('<span></span>').attr('class', 'name').text(person['sender']);
			var dateString = moment.unix(person['timestamp']).format("hh:mm A");
			sender_span_time = $('<span></span>').attr('class', 'time').text(dateString);
			sender_span_preview = $('<span></span>').attr('class', 'preview').text(person['message'])
			sender_li.append(sender_img).append(sender_span_name).append(sender_span_time).append(sender_span_preview);
			$('#peopleappend').append(sender_li);
		}
	}
	
	function checkPersonInList(fixedPerson){
		if($('.people .li').hasAttr('data-chat', fixedPerson)){
			alert('yes')
		}else{
			alert('no')	
		}
	}
    </script>
    
  </body>
</html>
