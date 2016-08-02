package com.kidscodetw.eeit.controller.member;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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

import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;

@Controller
@RequestMapping("/member/MemberUpdateAdvanceData")
public class MemberUpdateAdvanceData {
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(method = RequestMethod.POST, value="/updateData", produces=MediaType.APPLICATION_JSON)
	public @ResponseBody MemberBean updateData(
			HttpSession session,
			@RequestParam String password1,
			@RequestParam String password2,
			@RequestParam String email,
			@RequestParam String phone,
			@RequestParam String datepicker,
			Model model){
		MemberBean bean=((MemberBean)session.getAttribute("loginmember"));
		if(password1.equals(password2)){
			bean.setPassword(password1);
		}

		return bean;
		
	}
	
	
}
