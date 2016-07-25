package com.kidscodetw.eeit.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginHandler {
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginPage () {
	    return "/login.jsp";
	}

}