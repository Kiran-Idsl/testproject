package com.kiran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/welcome")
	public String log() {
		System.out.println("hhhhhhhhhhhhhh");
		return "welcome";
	}
	
	@GetMapping("/login")
	public String log33() {
		return "login";
	}
	
	@GetMapping("/one")
	public String log2() {
		return "one";
	}
	
	@GetMapping("/hr")
	public String log22() {
		return "hr";
	}
}
