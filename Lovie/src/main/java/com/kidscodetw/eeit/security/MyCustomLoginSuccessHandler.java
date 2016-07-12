package com.kidscodetw.eeit.security;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class MyCustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	private String loginMapping = "login.mvc";
	
	@Autowired
	private ServletContext context;
	
	public MyCustomLoginSuccessHandler(){
		
	}
	
    public MyCustomLoginSuccessHandler(String defaultTargetUrl) {
        setDefaultTargetUrl(defaultTargetUrl);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
    	String referrer = request.getHeader("Referer");
        if(referrer!=null){
            request.getSession().setAttribute("url_prior_login", referrer);
        }
        HttpSession session = request.getSession();
        if (session != null) {
            String redirectUrl = (String) session.getAttribute("url_prior_login");
            if (redirectUrl != null) {
                if(redirectUrl.substring(redirectUrl.length()-loginMapping.length()).equals(loginMapping)){
                	System.out.println(context.getContextPath()+"/index.jsp");
                	 getRedirectStrategy().sendRedirect(request, response, context.getContextPath()+"/index.jsp");
                }
                session.removeAttribute("url_prior_login");
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
            } else {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
    

    
    
}