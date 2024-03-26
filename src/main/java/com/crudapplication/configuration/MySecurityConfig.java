package com.crudapplication.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.crudapplication.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String SIGNIN="/signin";
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/swagger-ui/**", "/v3/api-docs").permitAll()
				.antMatchers("/api/college/").hasRole("NORMAL").antMatchers(SIGNIN).permitAll()
				.antMatchers("/api/student/").hasRole("ADMIN").anyRequest().authenticated().and().formLogin()
				.loginPage(SIGNIN).loginProcessingUrl("/dologin").defaultSuccessUrl("/api/student/")
//		.defaultSuccessUrl("/college/")
				.and().logout().logoutSuccessUrl(SIGNIN).logoutUrl("/signout");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}
