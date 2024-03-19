package com.crudapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crudapplication.entity.CustomUserDetail;
import com.crudapplication.entity.User;
import com.crudapplication.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.repository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("NO USER");
		}
		return new CustomUserDetail(user);
	}

}
