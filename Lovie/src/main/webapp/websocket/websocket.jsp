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
     <input type="button" onclick="sendMessage()" value="送出">
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
    	   outputArea.value = outputArea.value + "連線成功\n";    
       }       
       
       function onClose(event) {  
    	   outputArea.value =outputArea.value + "連線中斷\n"; 
       }  

       function onMessage(event) {  
    	   outputArea.value =outputArea.value + "從伺服器接收: "+event.data +"\n";  
          
       }  

       function onError(event) {  
    	   outputArea.value =outputArea.value + event.data+"\n";  
       }  

       function sendMessage() {  
    	 
    	   outputArea.value = outputArea.value +"發給伺服器: "+ messageText.value+"\n";
         websocket.send(messageText.value);  
       }  

       
       window.addEventListener("load", init, false);  
     </script> 
   </body>  
 </html> 