package com.kiran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String getHomepage() {
		return "homePage";
	}
	
	@GetMapping("/welcome")
	public String welcomePage() {
		return "welcomePage";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		return "login";
	}
	
	@GetMapping("/kiran")
	public String welcomePage2() {
		return "home2";
	}
	
	
	@GetMapping("/admin")
	public String getAdminPage() {
		return "adminPage";
	}
	
	@GetMapping("/emp")
	public String getEmployeePage() {
		return "empPage";
	}
	
	@GetMapping("/mgr")
	public String getManagerPage() {
		return "mgrPage";
	}
	
	@GetMapping("/hr")
	public String getHrPage() {
		return "hrPage";
	}
	
	@GetMapping("/common")
	public String getCommonPage() {
		return "commonPage";
	}
	
	@GetMapping("/accessDenied")
	public String getAccessDeniedPage() {
		return "accessDeniedPage";
	}
}
