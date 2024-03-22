package com.crudapplication.configuration;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.crudapplication.entity.Student;

@Component
public class StudentItemProcessor implements ItemProcessor<Student, ProcessedStudent> {

	private int studentCount = 0;

	@Override
	public ProcessedStudent process(Student student) throws Exception {
			return studentCount++<5?new ProcessedStudent(studentCount, student):null;
		
	}
}

