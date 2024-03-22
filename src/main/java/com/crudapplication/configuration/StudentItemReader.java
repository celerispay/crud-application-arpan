package com.crudapplication.configuration;

import java.util.Iterator;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crudapplication.entity.Student;
import com.crudapplication.repository.StudentRepo;

import lombok.Data;

@Data
@Component
public class StudentItemReader implements ItemReader<Student> {

	private final StudentRepo studentRepo;

	private Iterator<Student> studentIterator;

	@Autowired
	public StudentItemReader(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public Student read() throws Exception {
		if (studentIterator == null || !studentIterator.hasNext()) {
			studentIterator = studentRepo.findAll().iterator();
		}
		return studentIterator.hasNext() ? studentIterator.next() : null;
	}
}
