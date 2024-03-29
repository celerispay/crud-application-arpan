package com.crudapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapplication.entity.Course;
import com.crudapplication.repository.CourseRepo;

import lombok.Data;

@Data
@Service
public class CourseService {

	@Autowired
	private CourseRepo repository;

	public List<Course> getAllCourses() {
		return (List<Course>) repository.findAll();

	}

	public void addCourse(Course course) {
		repository.save(course);
	}
}
