package com.suraj.jpaintegration.login;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController {
	
	@RequestMapping("/")
	public String login() {
		return "Welcome to the Login page";
	}

}
