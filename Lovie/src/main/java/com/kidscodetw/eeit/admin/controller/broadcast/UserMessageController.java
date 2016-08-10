package com.kidscodetw.eeit.admin.controller.broadcast;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import com.kidscodetw.eeit.dao.member.MemberDAO;

@Controller
public class UserMessageController {

	@Autowired
	MemberDAO memberDAO;

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

	@MessageMapping("/broadcastMember")
	public void dispatchMember(FromBackendMessge message) throws Exception {
		for (Object role : message.getGroup()) {
			template.convertAndSendToUser((String) role, "/queue/broadcastOne", message.getMessage());
			
		}
	}
}