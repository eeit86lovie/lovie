package com.kidscodetw.eeit.admin.controller.message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {
	
	@RequestMapping("admin/broadcast")
	public String dispatch(){
		return "/admin/broadcast/message.jsp";
	}

}
