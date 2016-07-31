package com.kidscodetw.eeit.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LogoutHandler {
	
	private String referer;
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) throws IOException {
		referer = request.getHeader("referer");
		if(referer.contains("profile")){
			return "/index.jsp";
		}
		return referer;
//	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    if (auth != null){    
//	        new SecurityContextLogoutHandler().logout(request, response, auth);
//	    }
//	    return "redirect:/login";
	}
}
