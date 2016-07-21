package com.kidscodetw.eeit.controller.member;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.service.member.MemberGetListService;
import com.kidscodetw.eeit.util.DataTransfer;

@Controller
public class MemberListMVC {

	@RequestMapping(value="secure/MemberListServlet/{gender}", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public List<MemberBean> dispatch(@PathVariable("gender") Integer gender, Model model) {
		if (gender.equals(1)) {
			return changeBirthdayToAge(MemberGetListService.getAllGirls());
		}else if(gender.equals(0)){
			return changeBirthdayToAge(MemberGetListService.getAllBoys());
		}
		return null;
	}
	
	private List<MemberBean> changeBirthdayToAge(List<MemberBean> memberBean){
		for (MemberBean mb : memberBean) {
			if(mb.getBirthday().length()<2)
			mb.setBirthday(String.valueOf(DataTransfer.changeBirthdayToAge(mb))); 
		}
		return memberBean;
	}
}


