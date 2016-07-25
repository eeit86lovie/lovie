package com.kidscodetw.eeit.websocket;

import java.security.Principal;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

@Controller
public class UserChatController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@MessageMapping("/chat")
	public void search(@Payload String jsonMessage, Principal principal) {
		Gson gson = new Gson();
		ChatMessage message = gson.fromJson(jsonMessage, ChatMessage.class);
		message.setOrinUser(principal.getName());
		SimpleDateFormat format = 
	            new SimpleDateFormat("MM-dd HH:mm:ss");
		String now = format.format(new java.util.Date());
		message.setTimestamp(now);
		template.convertAndSendToUser(message.getDestUser(), "/queue/chat", message);
		template.convertAndSendToUser(message.getOrinUser(), "/queue/chat", message);
	}
	
	private class ChatMessage{
		private String orinUser;
		private String destUser;
		private String message;
		private String timestamp;
		
		public String getDestUser() {
			return destUser;
		}
		
		public String getMessage() {
			return message;
		}
		
		public String getOrinUser() {
			return orinUser;
		}
		
		public void setOrinUser(String orinUser){
			this.orinUser = orinUser;
		}

		public String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

	}
	
}

