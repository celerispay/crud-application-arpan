package com.crudapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crudapplication.entity.User;
import com.crudapplication.service.UserService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/login")
	public ModelAndView firstPage() {
		return new ModelAndView("login");
	}
	
	
	
	
	


}
