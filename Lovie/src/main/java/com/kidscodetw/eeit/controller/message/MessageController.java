package com.kidscodetw.eeit.controller.message;

import java.security.Principal;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.message.MessageDAO;
import com.kidscodetw.eeit.entity.message.MessageBean;

@Controller
@RequestMapping("chat")
public class MessageController {
	
	@Autowired
	private MessageDAO messageDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String dispatch(Model model, Principal principal){
		model.addAttribute("loginmember", principal.getName());
		return "/chat/chat.jsp";
	}
	
	@RequestMapping(value="info", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public List<MessageBean> getInfo(Principal principal){
		List<MessageBean> senders = messageDAO.selectSender(principal.getName());
		List<MessageBean> receivers = messageDAO.selectReceiver(principal.getName());
		
		return null;
	}
	
	
}
