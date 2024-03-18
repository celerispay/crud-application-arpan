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

import com.crudapplication.entity.Teacher;
import com.crudapplication.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Teacher>> getAllTeachers(){
		List<Teacher> teachers = service.getAllTeachers();
		return new ResponseEntity<>(teachers, HttpStatus.OK);
	}
	
	@PostMapping("/")    
	public ResponseEntity<Void> addTeacher(@RequestBody Teacher teacher){
		service.addTeacher(teacher);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
