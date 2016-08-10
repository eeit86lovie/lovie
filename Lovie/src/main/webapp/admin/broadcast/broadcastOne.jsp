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

        function getCheckedBoxes(chkboxName) {
        	  var checkboxes = document.getElementsByName(chkboxName);
        	  var checkboxesChecked = [];
        	  for (var i=0; i<checkboxes.length; i++) {
        	     if (checkboxes[i].checked) {
        	        checkboxesChecked.push(checkboxes[i]);
        	     }
        	  }
        	  return checkboxesChecked.length > 0 ? checkboxesChecked : null;
        	}

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
        	var group = [];
            var message = document.getElementById('messageInput').value;
            var checkedBoxs = getCheckedBoxes("account");
            if(checkedBoxs == null){
            	alert("請至少勾選一名會員");
           	}else if(document.getElementById("messageInput").value==""){
           		alert("請輸入廣播訊息")
           	}else{
           		for(var i=0;i<checkedBoxs.length;i++){
           			group.push(checkedBoxs[i].id)
           		}
           		stompClient.send("/app/broadcastMember", {}, JSON.stringify({ 'message': message ,'group':group}));
           	}
        }

        
        
        function getCheckedValue(checkbox){
        	if(checkbox.checked){
        		return document.querySelector('#'+checkbox.id+':checked').value;
        	}
        }
        
    </script>
    
   <style>
	td{
		Vertical-Align:middle !important;
	}
   
   </style>
</head>
<body onload="connect()">
<div id="wrapper">
<c:import charEncoding="UTF-8" url="../nav.jsp"></c:import>
	<div id="page-wrapper">
	
	<div class="row">
		<h1>線上會員廣播:</h1>
	</div>
	
	<div class="row">
	<table class="table">
	<thead>
		<th></th>
		<th>照片</th>
		<th>帳號</th>
		<th>暱稱</th>
		<th>年齡</th>
		<th>性別</th>
		<th>居住地</th>
	</thead>
	<tbody>
	<c:forEach items="${onlineUsers }" var="onlineUser">
	
	<tr>
		<td><input type="checkbox" name="account" id="${onlineUser.account }" value="${onlineUser.account }" /></td>
		<td><img height="100" src="${pageContext.request.contextPath }/photo/member/${onlineUser.id}" /></td>
		<td>${onlineUser.account}</td>
		<td>${onlineUser.nickname}</td>
		<td>${onlineUser.age}</td>
		<c:if test="${onlineUser.gender=='1'}"><td>男</td></c:if>
		<c:if test="${onlineUser.gender=='0'}"><td>女</td></c:if>
		<td>${onlineUser.city}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	
	</div>
	
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
