package com.crudapplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapplication.entity.Student;
import com.crudapplication.service.StudentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudents() {
		log.info("Retrieving all students");
		List<Student> students = service.getAllStudents();
		log.info("Total students retrieved: {}", students.size());
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) {
		log.info("Retrieving students with id:{}", id);
		Student student = service.getStudent(id);
		if (student == null) {
			log.info("Student with id {} not found", id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<List<Student>> addStudent(@Valid @RequestBody List<Student> students, BindingResult result) {

		for (Student student : students) {
			log.info("Adding student");
			service.addStudent(student);
			log.info("Added student with id:{}", student.getId());
		}

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateStudent(@Valid @RequestBody List<Student> students, @PathVariable int id,
			BindingResult result) {

		log.info("Updating student with id:{}", id);
		service.updateStudent(students, id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudentByID(@PathVariable int id) {
		log.info("Deleting students with id:{}", id);
		service.deleteStudentByID(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
