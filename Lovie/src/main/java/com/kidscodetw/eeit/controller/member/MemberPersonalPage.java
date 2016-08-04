package com.kidscodetw.eeit.controller.member;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.dao.member.FriendDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.FriendBean;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.util.DataTransfer;

@Controller
public class MemberPersonalPage {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private ForumDAO forumDAO;
	@Autowired
	private FriendDAO friendDAO;
	
	@RequestMapping(value="/member/profile/{id}", produces=MediaType.APPLICATION_JSON)
	public String getMemberById(@PathVariable("id")Integer memberId, Model model){
		MemberBean memberBean=memberDAO.select(memberId);
//		List<FriendBean> friendBean=friendDAO.selectPart(memberBean.getId(), 1);
//		model.addAttribute("friends",friendBean.size());
		model.addAttribute("memberPrivilege",DataTransfer.changeNumToPrivilege(memberBean));
		model.addAttribute("gender",DataTransfer.genderTransfer(memberBean));
		model.addAttribute("oneMember",memberBean);
		model.addAttribute("article",forumDAO.select_memberAccount(memberBean.getAccount()).size());
		return "member/memberPersonalPage.jsp";
	}
	
}
