package com.webClient.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/")
	public String start() {
		return "home";
	}
	
	@GetMapping("/decode")
	public void decode() {
		
	}
}
