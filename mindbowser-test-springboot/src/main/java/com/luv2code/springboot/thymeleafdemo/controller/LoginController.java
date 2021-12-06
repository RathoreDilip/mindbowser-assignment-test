package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/")
    public String home() {
		return "redirect:/manager/signInforManager";
    }
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "manager/manager-signin-form";
	}
}
