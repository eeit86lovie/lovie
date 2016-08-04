package com.kidscodetw.eeit.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.ws.rs.core.MediaType;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;

@Controller
public class GetMemberByAccount {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(value="member/nickname/{account}", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public MemberBean getNickname(@PathVariable("account")String account){
		
		MemberBean memberBean = memberDAO.select(account);
		if(memberBean!=null){
			return memberBean;
		}else{
			return null;
		}
		
	}

}
