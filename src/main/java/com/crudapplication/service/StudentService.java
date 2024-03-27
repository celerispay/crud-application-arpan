package com.crudapplication.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
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
		return (List<Student>) repository.findAll();
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
	public void updateStudent(@Valid List<Student> students, int id) {
		log.info("updating students with given id:{}", id);
		Optional<Student> optionalStudent = repository.findById(id);
		
		if(optionalStudent.isPresent()) {
			Student existingStudent=optionalStudent.get();
			Student updatedStudentData=students.get(0);
			
			 existingStudent.setName(updatedStudentData.getName());
	            existingStudent.setMarks(updatedStudentData.getMarks());
	            repository.save(existingStudent);
		}
		else {
			throw new EntityNotFoundException("Student with ID " + id + " not found");
		}
		

	}

	public Student deleteStudentByID(int id) {
		Optional<Student> optionalStudent=repository.findById(id);
		
		if(optionalStudent.isPresent()) {
			log.info("Deleting students");
			Student student=optionalStudent.get();
			repository.deleteById(id);
			return student;
		}
		else {
			return null;
		}
		
	}

}
