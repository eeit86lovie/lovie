package com.kidscodetw.eeit.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class UserMessageController {

	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/backend")
	public void dispatch(FromBackendMessge message) throws Exception {
		for (Object role : message.getGroup()) {
			if (role != null) {
				if (role.equals("guest")) {
					template.convertAndSend(
							"/topic/guest",
							new SendToRoleMessage(message.getMessage()));
				} else if (role.equals("user")) {
					template.convertAndSend(
							"/topic/user",
							new SendToRoleMessage(message.getMessage()));
				} else if (role.equals("gold")) {
					template.convertAndSend(
							"/topic/gold",
							new SendToRoleMessage(message.getMessage()));
				}
			}
		}
		;
	}

}
