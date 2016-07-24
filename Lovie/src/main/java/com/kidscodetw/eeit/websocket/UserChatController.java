package com.kidscodetw.eeit.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class UserChatController {
	
	@MessageMapping("/chat")
	@SendToUser(broadcast=false)
	public String search(@Payload String xxx) {
		System.out.println(xxx);
	    return "TEST1234";
	}
}
