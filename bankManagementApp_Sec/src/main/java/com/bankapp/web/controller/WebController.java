package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.bankapp.security.service.SecurityUser;

@Controller
public class WebController {
	
//	@GetMapping(path = "home")
//	public String hello() {
//		return "home";
//	}
	
	@GetMapping(path = "home")
	public String hello(ModelMap map) {
		return "home";
	}
	
	@GetMapping(path = "login")
	public String login() {
		return "loginpage";
	}

	@GetMapping(path = "logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
		if (auth != null){   
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
		
		return "redirect:login?logout=success";
		
	}
	
	@GetMapping(path = "accessdenied")
	public String handleAccessDenied(ModelMap map, @AuthenticationPrincipal SecurityUser secUser) {
		
		map.addAttribute("user", secUser.getUser());
		return "403";
		
	}
	
}
