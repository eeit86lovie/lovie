package com.kidscodetw.eeit.admin.controller.broadcast;

import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserMessageController {

	private static List<String> guestlisteningUser;
	private static List<String> userlisteningUser;
	private static List<String> goldlisteningUser;

	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/broadcast")
	public void dispatch(FromBackendMessge message) throws Exception {
		for (Object role : message.getGroup()) {
			if (role != null) {
				if (role.equals("guest")) {
					template.convertAndSend("/topic/guest",
							new SendToRoleMessage(message.getMessage()));
				} else if (role.equals("user")) {
					template.convertAndSend("/topic/user",
							new SendToRoleMessage(message.getMessage()));
				} else if (role.equals("gold")) {
					template.convertAndSend("/topic/gold",
							new SendToRoleMessage(message.getMessage()));
				}
			}
		}
	}

	@SubscribeMapping("topic/guest")
	public void putGuest(ServletContext context, Principal principal) {
		guestlisteningUser.add(principal.getName());
	}
	
	@SubscribeMapping("topic/user")
	public void putUser(ServletContext context, Principal principal) {
		userlisteningUser.add(principal.getName());
	}
	
	@SubscribeMapping("topic/gold")
	public void putGold(ServletContext context, Principal principal) {
		goldlisteningUser.add(principal.getName());
	}

}
