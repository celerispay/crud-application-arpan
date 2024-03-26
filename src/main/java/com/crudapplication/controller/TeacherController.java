package com.crudapplication.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapplication.entity.Course;
import com.crudapplication.entity.Teacher;
import com.crudapplication.entity.TeacherDTO;
import com.crudapplication.service.TeacherService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/teacher")
@Log4j2
public class TeacherController {

	@Autowired
	private TeacherService service;
	
	

	@GetMapping("/")
	public ResponseEntity<List<Teacher>> getAllTeachers() {
		log.info("Retrieving list of teachers");
		List<Teacher> teachers = service.getAllTeachers();
		log.info("Total teachers retrieved:{}", teachers.size());
		return new ResponseEntity<>(teachers, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Void> addTeacher(@RequestBody TeacherDTO teacherDTO) {
		log.info("Adding teacher");
		Teacher teacher=convertDTOtoTeacher(teacherDTO);
		service.addTeacher(teacher);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	private Teacher convertDTOtoTeacher(TeacherDTO teacherDTO) {
		Teacher teacher=new Teacher();
		teacher.setTeacherId(teacherDTO.getId());
		teacher.setTeacherName(teacher.getTeacherName());
		
		Set<Course> courses=new HashSet<>();
		for(Course courseDTO:teacherDTO.getCourse()) {
			Course course=new Course();
			course.setId(courseDTO.getId());
			course.setName(courseDTO.getName());
			courses.add(course);
		}
		teacher.setCourse(courses);
		return teacher;
	}
}
