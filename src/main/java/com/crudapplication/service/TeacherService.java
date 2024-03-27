package com.crudapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapplication.entity.Teacher;
import com.crudapplication.repository.TeacherRepo;

import lombok.Data;

@Data
@Service
public class TeacherService {

	@Autowired
	private TeacherRepo repository;

	public List<Teacher> getAllTeachers() {
		return (List<Teacher>) repository.findAll();

	}

	public void addTeacher(Teacher teacher) {
		repository.save(teacher);
	}
	
}
