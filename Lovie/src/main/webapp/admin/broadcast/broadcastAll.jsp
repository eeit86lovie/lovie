<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="../meta.jsp"></c:import>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.1/sockjs.min.js"></script>
    <script src="//cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>
    <script type="text/javascript">
        var stompClient = null;



        function connect() {
            var socket = new SockJS('/Lovie/stomp');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                console.log('Connected: ' + frame);
            });
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }

        function sendMessage() {
        	var style;
            var message = document.getElementById('messageInput').value;
            var checkedGuest = document.getElementById("guestCheckbox");
            var checkedUser = document.getElementById("userCheckbox");
            var checkedGold = document.getElementById("goldCheckbox");
           	if(!checkedGuest.checked && !checkedUser.checked && !checkedGold.checked){
            	alert("請至少勾選一項使用者群組");
           	}else{
           		stompClient.send("/app/broadcast", {}, JSON.stringify({ 'message': message ,'group':[getCheckedValue(checkedGuest) ,getCheckedValue(checkedUser),getCheckedValue(checkedGold)]}));
           	}
        }

        
        
        function getCheckedValue(checkbox){
        	if(checkbox.checked){
        		return document.querySelector('#'+checkbox.id+':checked').value;
        	}
        }
        
    </script>
</head>
<body onload="connect()">
<div id="wrapper">
<c:import charEncoding="UTF-8" url="../nav.jsp"></c:import>
	<div id="page-wrapper">
	<form>
	<input type="checkbox" id="guestCheckbox" name="guest" value="guest" checked> 未登入用戶 <br>
  	<input type="checkbox" id="userCheckbox" name="user" value="user" checked> 一般會員 <br>
  	<input type="checkbox" id="goldCheckbox" name="gold" value="gold" checked> 黃金會員 <br>

	</form>
	
	<div id="conversationDiv">
        <label>請輸入廣播內容</label><input type="text" id="messageInput" />
        <button id="sendMessage" onclick="sendMessage();">Send</button>
        <p id="response"></p>
    </div>
	
	


	</div>
</div>


<c:import charEncoding="UTF-8" url="../footer.jsp"></c:import>
</body>
</html>
