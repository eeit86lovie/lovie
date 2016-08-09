package com.kidscodetw.eeit.controller.member;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.security.SecurityContextImple;


@Controller
public class AllMembers {
	@Autowired
	private MemberDAO memberDAO; 
	
	@RequestMapping("members")
	public String dispatch(Model model){
		try{
			SecurityContextImple SecurityContext = (SecurityContextImple) SecurityContextHolder.getContext();
			MemberBean bean = SecurityContext.getMemberBean();
			model.addAttribute("member",bean);
		}catch(java.lang.ClassCastException e){}
		return "/member/allMemberList.jsp";
	}
	
	
}
