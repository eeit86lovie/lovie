package com.kidscodetw.eeit.controller.member;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.forum.ForumBean;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.util.ChangeBirthToOther;

@Controller
public class MemberPersonalPage {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private ForumDAO forumDAO;
	
	@RequestMapping(value="MemberPersonalPage/{id}", produces=MediaType.APPLICATION_JSON)
	public String getMemberById(@PathVariable("id")Integer memberId,Model model){
		MemberBean memberBean = memberDAO.select(memberId);
		model.addAttribute("oneMember", memberBean);
		model.addAttribute("constellation",ChangeBirthToOther.changeBirthdayToConstellations(memberBean));
		model.addAttribute("article",forumDAO.select_memberAccount(memberBean.getAccount()).size());
		
		
		return "member/memberPersonalPage.jsp";
	}
	
}
