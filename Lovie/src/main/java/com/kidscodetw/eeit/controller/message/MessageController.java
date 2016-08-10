package com.kidscodetw.eeit.controller.message;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.member.FriendDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.dao.message.MessageDAO;
import com.kidscodetw.eeit.entity.member.FriendBean;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.entity.message.MessageBean;
import com.kidscodetw.eeit.util.MessageTimestampComparator;

@Controller
@RequestMapping("chat")
public class MessageController {

	@Autowired
	private MessageDAO messageDAO;
	
	@Autowired
	private FriendDAO friendDAO;
	
	@Autowired
	private MemberDAO memberDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String dispatch(Principal principal, Model model, @RequestParam(value="sender", required=false) String sender){
		Integer memberId = memberDAO.select(principal.getName()).getId();
		List<FriendBean> friendBeans = friendDAO.selectPart(memberId, 3);
		List<MemberBean> memberBeans = new ArrayList<MemberBean>();
		for(FriendBean bean :friendBeans){
			memberBeans.add(memberDAO.select(bean.getFriendId()));
		}
		if(sender != null){
			model.addAttribute("firstSender", sender);
		}
		model.addAttribute("friends", memberBeans);
		return "/chat/chat.jsp";
	}

	@RequestMapping(value = "info", produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public Set<MessageBean> getInfo(Principal principal) {
		SortedSet<MessageBean> both = null;
		if (principal != null) {
			List<MessageBean> senders = getSenders(principal.getName());
			List<MessageBean> receivers = getReceivers(principal.getName());
			both = new TreeSet<MessageBean>(new MessageTimestampComparator());
			for(MessageBean sender: senders)
				both.add(sender);
			for(MessageBean receiver: receivers)
				both.add(receiver);
		}
		return both;
	}
	
	@RequestMapping(value = "info/{account}", produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public Set<MessageBean> getInfoOne(@PathVariable String account,Principal principal) {
		SortedSet<MessageBean> both = null;
		if (principal != null) {
			List<MessageBean> senders = getSenders(account);
			List<MessageBean> receivers = getReceivers(account);
			both = new TreeSet<MessageBean>(new MessageTimestampComparator());
			for(MessageBean sender: senders)
				both.add(sender);
			for(MessageBean receiver: receivers)
				both.add(receiver);
		}
		return both;
	}
	
	

	public List<MessageBean> getSenders(String sender) {
		return messageDAO.selectSender(sender);
	}

	public List<MessageBean> getReceivers(String receiver) {
		return messageDAO.selectReceiver(receiver);
	}
	
}
