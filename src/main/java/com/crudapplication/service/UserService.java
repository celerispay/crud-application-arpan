package com.crudapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crudapplication.entity.User;
import com.crudapplication.repository.UserRepo;

import lombok.Data;

@Data
@Service
public class UserService {

	@Autowired
	private UserRepo repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	

}
