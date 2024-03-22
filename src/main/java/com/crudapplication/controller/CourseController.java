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

import com.crudapplication.entity.Course;
import com.crudapplication.service.CourseService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/course")
@Log4j2
public class CourseController {

	@Autowired
	private CourseService service;

	@GetMapping("/")
	public ResponseEntity<List<Course>> getAllCourses() {
		log.info("Retrieving list of courses");
		List<Course> courses = service.getAllCourses();
		log.info("Total courses retrieved:{}", courses.size());
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Void> addCourse(@RequestBody Course course) {
		log.info("Adding course");
		service.addCourse(course);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
