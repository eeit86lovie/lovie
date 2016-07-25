package com.kidscodetw.eeit.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginService {
	@RequestMapping("login.mvc")
    public String login() {
        return "login.jsp";
    }
}
