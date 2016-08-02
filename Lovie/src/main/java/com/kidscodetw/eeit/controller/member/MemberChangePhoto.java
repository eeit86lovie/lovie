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
import org.springframework.web.multipart.MultipartFile;

import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.jdbc.MemberDAOJdbc;
import com.kidscodetw.eeit.service.member.MemberService;

@Controller
@RequestMapping("/member/MemberChangePhoto")
public class MemberChangePhoto {
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private ServletContext servletContext;
	
    private MemberDAOJdbc memberDAOJdbc;
	@RequestMapping(method = RequestMethod.POST, value="/insertPhoto", produces=MediaType.APPLICATION_JSON)
	public @ResponseBody MemberBean changePhoto(
			HttpSession session,
			@RequestParam MultipartFile file,
			Model model){
		InputStream is=null;
		Long size=null;
		try {
			is=file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		size=file.getSize();
		MemberBean bean=((MemberBean)session.getAttribute("loginmember"));
		memberDAOJdbc=new MemberDAOJdbc();
		memberDAOJdbc.updatePhotos(bean,is,size);
        String imgName="Member"+bean.getId();
		File f = new File(servletContext.getRealPath("/") + "/photo/" + imgName
				+ ".jpg");
		f.delete();
		return bean;
		
	}
}
