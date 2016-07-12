<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
   <head>  
     <title>WebSocket Echo Test</title>  
     <meta charset="UTF-8">  
     <meta name="viewport" content="width=device-width, initial-scale=1.0">  
      
   </head>  
   <body>  
     
     <form>
     <input type="text" id="messageText">
     <input type="button" onclick="sendMessage()" value="�e�X">
     </form>
     <textarea rows="10" cols="50" id="output" ></textarea>
     
     <script language="javascript" type="text/javascript">  
       var wsUri = "ws://localhost:8080${pageContext.request.contextPath}/websocket2";  
       var outputArea;  
       function init()  
       {  
         outputArea = document.getElementById("output");  
         runWebSocket();  
       }  
       function runWebSocket() {   
         websocket = new WebSocket(wsUri);  
         websocket.onopen = function (event) {  
           onOpen(event)  
         };  
         websocket.onclose = function (event) {  
           onClose(event)  
         };  
         websocket.onmessage = function (event) {  
           onMessage(event)  
         };  
         websocket.onerror = function (event) {  
           onError(event)  
         };  
       }  
       function onOpen(event) {  
    	   outputArea.value = outputArea.value + "�s�u���\\n";    
       }       
       
       function onClose(event) {  
    	   outputArea.value =outputArea.value + "�s�u���_\n"; 
       }  

       function onMessage(event) {  
    	   outputArea.value =outputArea.value + "�q���A������: "+event.data +"\n";  
          
       }  

       function onError(event) {  
    	   outputArea.value =outputArea.value + event.data+"\n";  
       }  

       function sendMessage() {  
    	 
    	   outputArea.value = outputArea.value +"�o�����A��: "+ messageText.value+"\n";
         websocket.send(messageText.value);  
       }  

       
       window.addEventListener("load", init, false);  
     </script> 
   </body>  
 </html> 