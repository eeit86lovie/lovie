package com.kidscodetw.eeit.websocket;

import java.security.Principal;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.kidscodetw.eeit.dao.message.MessageDAO;
import com.kidscodetw.eeit.entity.message.MessageBean;

@Controller
public class UserChatController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private MessageDAO messageDAO;
	
	@MessageMapping("/chat")
	public void search(@Payload String jsonMessage, Principal principal) {
		Gson gson = new Gson();
		MessageBean message = gson.fromJson(jsonMessage, MessageBean.class);
		message.setSender(principal.getName());
		MessageBean result = messageDAO.insert(message);
		System.out.println(result);
		template.convertAndSendToUser(message.getReceiver(), "/queue/chat", result);
		template.convertAndSendToUser(message.getSender(), "/queue/chat", result);
	}
	
	
	
}

