package com.kidscodetw.eeit.controller.member;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;

@Controller
@RequestMapping("/member/MemberChangePhoto")
public class MemberChangePhoto {
	@Autowired
	private MemberDAO memberDAO;

	@RequestMapping(method = RequestMethod.POST, value="/insertPhoto", produces=MediaType.APPLICATION_JSON)
	public @ResponseBody MemberBean changePhoto(
			HttpSession session,
			@RequestParam MultipartFile file,
			Model model){
		byte[] photo=null;
		try {
			photo= file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MemberBean bean=((MemberBean)session.getAttribute("loginmember"));
		MemberBean memberBean=memberDAO.updatePhotos(photo, bean);
		return memberBean;
		
	}
}
