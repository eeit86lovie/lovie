package com.kidscodetw.eeit.controller.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.member.FriendDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.FriendBean;
import com.kidscodetw.eeit.entity.member.MemberBean;

@Controller
@RequestMapping("/member/FriendList")
public class FriendList {
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private FriendDAO friendDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(method = RequestMethod.POST, value="/getFriendData", produces=MediaType.APPLICATION_JSON)
	public @ResponseBody List<MemberBean> getFriendData(
			HttpSession session,
			@RequestParam Integer memberId,
			@RequestParam Integer relation,
			Model model){
		MemberBean bean=((MemberBean)session.getAttribute("loginmember"));
		//把好友id調出來
		List<FriendBean> friendBeanList = friendDAO.selectPart(bean.getId(), relation);
		List<MemberBean> friendMemberList = new ArrayList<MemberBean>();
		for(FriendBean beans:friendBeanList){
			friendMemberList.add(memberDAO.select(beans.getFriendId()));
		}
		return friendMemberList;
		
	}
	

}
