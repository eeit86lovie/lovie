package com.kidscodetw.eeit.controller.cart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="removeSessionAttribute")
public class RemoveSessionAttribute {
	
	@RequestMapping(method=RequestMethod.GET)
	public String removeSessionAttrAll(HttpServletRequest request){
		request.getSession().removeAttribute("addcartlist");
		return "";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String removeSessionAttrOne(HttpServletRequest request){
		request.getSession().removeAttribute("addcartlist");
		return "";
	}

}
