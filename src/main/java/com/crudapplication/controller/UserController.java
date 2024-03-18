package com.crudapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crudapplication.entity.MyUser;

@RestController
public class UserController {

	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Profile("dev")
	@PostMapping(value = "/register-user")
	public String regiter(@RequestBody MyUser myUser) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(myUser.getRoles()));
		String encodededPassword = passwordEncoder.encode(myUser.getPassword());
		User user = new User(myUser.getUserName(), encodededPassword, authorities);
		jdbcUserDetailsManager.createUser(user);
		return "User created :)";
	}

	@GetMapping(value = "/admin")
	public String admin(Model model) {

		model.addAttribute("message", "Welcome Admin :)");
		return "admin";
	}

	@GetMapping(value = "/user")
	public String user(Model model) {

		model.addAttribute("message", "Hello User :)");
		return "user";
	}

	@GetMapping(value = "/")
	public String welcome(Model model) {

		model.addAttribute("message", "Welcome :)");
		return "welcome";
	}
}
