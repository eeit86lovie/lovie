package com.kidscodetw.eeit.service.member;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;

@Controller
@RequestMapping("/admin/member")
public class AdminMembersService {
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(method = RequestMethod.POST, value="/getMembers", produces=MediaType.APPLICATION_JSON)
	public @ResponseBody List<MemberBean> getMembers(
			Model model){
		return memberDAO.select();
	}
}
