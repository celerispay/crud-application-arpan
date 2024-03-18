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

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Course>> getAllCourses(){
		List<Course> courses = service.getAllCourses();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}
	
	@PostMapping("/")    
	public ResponseEntity<Void> addCourse(@RequestBody Course course){
		service.addCourse(course);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
