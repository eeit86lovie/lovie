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

  <body onload="connect()">

    <div class="wrapper">
    <div class="container">
        <div class="left">
            <div class="top">
                <input type="text" />
                <a href="javascript:;" class="search"></a>
            </div>
            <ul class="people" id="peopleappend">
                <li class="person" data-chat="person1">
                    <img src="http://s13.postimg.org/ih41k9tqr/img1.jpg" alt="" />
                    <span class="name">Thomas Bangalter</span>
                    <span class="time">2:09 PM</span>
                    <span class="preview">I was wondering...</span>
                </li>
                <li class="person" data-chat="person2">
                    <img src="http://s3.postimg.org/yf86x7z1r/img2.jpg" alt="" />
                    <span class="name">Dog Woofson</span>
                    <span class="time">1:44 PM</span>
                    <span class="preview">I've forgotten how it felt before</span>
                </li>
                <li class="person" data-chat="person3">
                    <img src="http://s3.postimg.org/h9q4sm433/img3.jpg" alt="" />
                    <span class="name">Louis CK</span>
                    <span class="time">2:09 PM</span>
                    <span class="preview">But weâre probably gonna need a new carpet.</span>
                </li>
                <li class="person" data-chat="person4">
                    <img src="http://s3.postimg.org/quect8isv/img4.jpg" alt="" />
                    <span class="name">Bo Jackson</span>
                    <span class="time">2:09 PM</span>
                    <span class="preview">Itâs not that bad...</span>
                </li>
                <li class="person" data-chat="person5">
                    <img src="http://s16.postimg.org/ete1l89z5/img5.jpg" alt="" />
                    <span class="name">Michael Jordan</span>
                    <span class="time">2:09 PM</span>
                    <span class="preview">Wasup for the third time like is you bling bitch</span>
                </li>
                <li class="person" data-chat="person6">
                    <img src="http://s30.postimg.org/kwi7e42rh/img6.jpg" alt="" />
                    <span class="name">Drake</span>
                    <span class="time">2:09 PM</span>
                    <span class="preview">howdoyoudoaspace</span>
                </li>
            </ul>
        </div>
        <div class="right">
            <div class="top" id="chatappend"><span>To: <span class="name">Dog Woofson</span></span></div>
            <div class="chat" data-chat="person1">
                <div class="conversation-start">
                    <span>Today, 6:48 AM</span>
                </div>
                <div class="bubble you">
                    Hello,
                </div>
                <div class="bubble you">
                    it's me.
                </div>
                <div class="bubble you">
                    I was wondering...
                </div>
            </div>
            <div class="chat" data-chat="person2">
                <div class="conversation-start">
                    <span>Today, 5:38 PM</span>
                </div>
                <div class="bubble you">
                    Hello, can you hear me?
                </div>
                <div class="bubble you">
                    I'm in California dreaming
                </div>
                <div class="bubble me">
                    ... about who we used to be.
                </div>
                <div class="bubble me">
                    Are you serious?
                </div>
                <div class="bubble you">
                    When we were younger and free...
                </div>
                <div class="bubble you">
                    I've forgotten how it felt before
                </div>
            </div>
            <div class="chat" data-chat="person3">
                <div class="conversation-start">
                    <span>Today, 3:38 AM</span>
                </div>
                <div class="bubble you">
                    Hey human!
                </div>
                <div class="bubble you">
                    Umm... Someone took a shit in the hallway.
                </div>
                <div class="bubble me">
                    ... what.
                </div>
                <div class="bubble me">
                    Are you serious?
                </div>
                <div class="bubble you">
                    I mean...
                </div>
                <div class="bubble you">
                    Itâs not that bad...
                </div>
                <div class="bubble you">
                    But weâre probably gonna need a new carpet.
                </div>
            </div>
            <div class="chat" data-chat="person4">
                <div class="conversation-start">
                    <span>Yesterday, 4:20 PM</span>
                </div>
                <div class="bubble me">
                    Hey human!
                </div>
                <div class="bubble me">
                    Umm... Someone took a shit in the hallway.
                </div>
                <div class="bubble you">
                    ... what.
                </div>
                <div class="bubble you">
                    Are you serious?
                </div>
                <div class="bubble me">
                    I mean...
                </div>
                <div class="bubble me">
                    Itâs not that bad...
                </div>
            </div>
            <div class="chat" data-chat="person5">
                <div class="conversation-start">
                    <span>Today, 6:28 AM</span>
                </div>
                <div class="bubble you">
                    Wasup
                </div>
                <div class="bubble you">
                    Wasup
                </div>
                <div class="bubble you">
                    Wasup for the third time like is <br />you bling bitch
                </div>

            </div>
            <div class="chat" data-chat="person6">
                <div class="conversation-start">
                    <span>Monday, 1:27 PM</span>
                </div>
                <div class="bubble you">
                    So, how's your new phone?
                </div>
                <div class="bubble you">
                    You finally have a smartphone :D
                </div>
                <div class="bubble me">
                    Drake?
                </div>
                <div class="bubble me">
                    Why aren't you answering?
                </div>
                <div class="bubble you">
                    howdoyoudoaspace
                </div>
            </div>
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

        <script src="${pageContext.request.contextPath }/chat/js/index.js"></script>
		<script src="${pageContext.request.contextPath }/chat/js/index.js"></script>
    
    <script>
    $.ajax({
        url: 'chat/info',
        type: 'GET',
        success: function(response) {
            
        }
      });
    
//     <li class="person" data-chat="person1">
//     <img src="http://s13.postimg.org/ih41k9tqr/img1.jpg" alt="" />
//     <span class="name">Thomas Bangalter</span>
//     <span class="time">2:09 PM</span>
//     <span class="preview">I was wondering...</span>
// 		</li>
	
	function appendPeople(sender){
		sender_li = $('<li></li>').attr('class', 'person').attr('data-chat',sender);
		sender_img = $('<img></img>').attr('src',sender.getPhoto());
		sender_span_name = $('<span></span>').attr('class', 'name');
		sender_span_time = $('<span></span>').attr('class', 'time');
		sender_span_preview = $('<span></span>').attr('class', 'preview');
		sender_li.append(sender_img).append(sender_span_time).append(sender_span_time).append(sender_span_preview);
		$('#peopleappend').append(sender_li);
	}
    </script>
    
  </body>
</html>
