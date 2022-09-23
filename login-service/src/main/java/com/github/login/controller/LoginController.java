package com.github.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.login.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/signin")
	public String login(//
			@RequestParam String username, //
			@RequestParam String password) {
		return loginService.signin(username, password);
	}

}
