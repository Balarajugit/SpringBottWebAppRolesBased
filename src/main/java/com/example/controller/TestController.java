package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bean.UsersData;
import com.example.service.UserDataService;


public class TestController {
	
	@Autowired
	private UserDataService use;
	
	@GetMapping("/reg")
	public String testRegPage() {
		return "RegisterPage";
	}
	
	@GetMapping("/login")
	public String testLoginPage() {
		return "LoginPage";
	}
	
	@PostMapping("/resgister")
	public String regUserData(@ModelAttribute("userdata") UsersData userdata,Model m) {
		String saveUserData = use.saveUserData(userdata);
		m.addAttribute("res", saveUserData);
		return "RegisterPage";
	}

}
