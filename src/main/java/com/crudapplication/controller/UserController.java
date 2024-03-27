package com.crudapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class UserController {

	@GetMapping("/signin")
	public String signIn() {
		log.info("Displaying Login Form");
		return "login";
	}
	
	@GetMapping("/signout")
	public String signOut() {
		log.info("Logged out!!!");
		return "logout";
	}


}
