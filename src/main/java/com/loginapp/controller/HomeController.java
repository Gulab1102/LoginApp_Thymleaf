package com.loginapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loginapp.model.User;
import com.loginapp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/register")
	public String registration() {
		
		
		return "register";
	}
	
	@PostMapping("/createUser")
	public String createUser(@ModelAttribute("user") User user,HttpSession session) throws InterruptedException {
		//System.out.println(user);
		
		if(userService.checkEmail(user.getEmail())) {
			System.out.println("UserName alraedy Exists!!");
			session.setAttribute("msg", "UserName alraedy Exists!!");
			return "redirect:/register";
			
		}
		session.setAttribute("msg", "SuccessFull !!");
		//session.setMaxInactiveInterval(1);
		
		userService.createUser(user);
		return "redirect:/register";
	}

}
