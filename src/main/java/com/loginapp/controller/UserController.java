package com.loginapp.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	
	@GetMapping("/")
	public String home(Principal p,Model m ) {
		
		System.out.println(p.getName());
		m.addAttribute("UserName",p.getName());
		return "user/home";
	}

}
