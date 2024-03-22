package com.crudapplication.configuration;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crudapplication.entity.Student;
import com.crudapplication.repository.StudentRepo;

import lombok.extern.log4j.Log4j2;

import java.util.List;

@Component
@Log4j2
public class StudentItemWriter implements ItemWriter<ProcessedStudent> {

	private final StudentRepo studentRepo;

	@Autowired
	public StudentItemWriter(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public void write(List<? extends ProcessedStudent> processedStudents) throws Exception {
		for (ProcessedStudent processedStudent : processedStudents) {
			Student student = processedStudent.getStudent();
			log.info("Processed student count: " + processedStudent.getCount());
			log.info("Student ID: " + student.getId() + ", Name: " + student.getName() + ", Marks: "
					+ student.getMarks());
			studentRepo.save(student);
		}

	}

}
