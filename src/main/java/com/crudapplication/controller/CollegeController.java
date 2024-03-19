package com.crudapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapplication.entity.College;
import com.crudapplication.service.CollegeService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/college")
@Log4j2
public class CollegeController {

	@Autowired
	private CollegeService service;

	@GetMapping("/")
	public ResponseEntity<List<College>> getAllCollege() {
		log.info("Retrieving list of colleges");
		List<College> colleges = service.getAllCollege();
		log.info("Total colleges retrieved:{}",colleges.size());
		return new ResponseEntity<>(colleges, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Void> addCollege(@RequestBody College college) {
		log.info("Adding college");
		service.addCollege(college);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
