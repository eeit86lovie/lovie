package com.kidscodetw.eeit.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

@Controller
public class UserChatController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@MessageMapping("/chat")
	public void search(@Payload String jsonMessage) {
		Gson gson = new Gson();
		ChatMessage message = gson.fromJson(jsonMessage, ChatMessage.class);
		template.convertAndSendToUser(message.getDestUser(), "/queue/chat", message.getMessage());
	}
	
	private class ChatMessage{
		private String destUser;
		private String message;
		public String getDestUser() {
			return destUser;
		}
		
		public String getMessage() {
			return message;
		}

	}
	
}

