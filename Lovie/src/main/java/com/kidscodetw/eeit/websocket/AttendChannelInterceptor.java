package com.kidscodetw.eeit.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.stereotype.Service;

import com.kidscodetw.eeit.admin.controller.broadcast.OnlineUserRepo;
import com.kidscodetw.eeit.dao.member.MemberDAO;

@Service
public class AttendChannelInterceptor extends ChannelInterceptorAdapter {

	@Autowired
	MemberDAO memberDAO;

	@Override
	public void postSend(Message<?> message, MessageChannel channel,
			boolean sent) {

		StompHeaderAccessor sha = StompHeaderAccessor.wrap(message);

		if (sha.getCommand() == null
				|| sha.getCommand().equals(StompCommand.CONNECT)) {
			return;
		}
		if (sha.getUser() == null) {
			return;
		}

		if (sha.getDestination().equals("/app/attend")) {
			OnlineUserRepo.getOnlineUser().put(sha.getUser().getName(),
					memberDAO.select(sha.getUser().getName()));
		}

		if (sha.getCommand().equals(StompCommand.DISCONNECT) || sha.getCommand().equals(StompCommand.ERROR)) {
			OnlineUserRepo.getOnlineUser().remove(sha.getUser().getName());
		}

	}
}