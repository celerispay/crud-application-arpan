package com.crudapplication.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapplication.entity.Student;
import com.crudapplication.repository.StudentRepo;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Service
@Log4j2
public class StudentService {

	@Autowired
	private StudentRepo repository;

	public List<Student> getAllStudents() {
		log.info("Getting all students");
		List<Student> student = (List<Student>) repository.findAll();
		return student;
	}

	public Student getStudent(int id) {
		log.info("Getting student with id:{}", id);
		return repository.findById(id).orElse(null);
	}

	public Student addStudent(@Valid Student student) {
		log.info("Adding students");
		return repository.save(student);

	}

	@Transactional
	public void updateStudent(@Valid List<Student> student, int id) {
		log.info("updating students with given id:{}", id);
//		for (Student s : student) {
//			if (id == s.getId()) {
				repository.save(student);
//			}
//		}
	}

	public void deleteStudentByID(int id) {
		repository.deleteById(id);
	}

}
