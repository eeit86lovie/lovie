package com.kidscodetw.eeit.websocket;

import org.springframework.web.socket.TextMessage;  
import org.springframework.web.socket.WebSocketSession;  
import org.springframework.web.socket.handler.TextWebSocketHandler;  
  
public class SocketHandler extends TextWebSocketHandler {  
  
    @Override  
    protected void handleTextMessage(WebSocketSession session,  
            TextMessage message) throws Exception {  
        super.handleTextMessage(session, message);
//        TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");  
        
        TextMessage returnMessage = new TextMessage(session.getAttributes()+" received at server"); 
        session.sendMessage(returnMessage);  
    }  
}  