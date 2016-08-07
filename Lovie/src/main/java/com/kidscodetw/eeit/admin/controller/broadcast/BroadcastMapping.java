package com.kidscodetw.eeit.admin.controller.broadcast;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BroadcastMapping {
	
	@RequestMapping("admin/broadcast/broadcastAll")
	public String broadcastAllDispatch(){
		return "/admin/broadcast/broadcastAll.jsp";
	}
	
	@RequestMapping("admin/broadcast/broadcastOne")
	public String broadcastOneDispatch(){
		return "/admin/broadcast/broadcastOne.jsp";
	}
}
