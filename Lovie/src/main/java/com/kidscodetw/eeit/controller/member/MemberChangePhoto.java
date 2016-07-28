package com.kidscodetw.eeit.controller.member;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MemberChangePhoto {


	@RequestMapping(method = RequestMethod.POST, value="member/MemberChangePhoto", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public void changePhoto(@RequestParam MultipartFile file){
		System.out.println("111111111111111111111111111");
		System.out.println(file+"22222222222222222222222222222222");
	}
}
