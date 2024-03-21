package com.crudapplication.configuration;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.crudapplication.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Component
public class StudentItemProcessor implements ItemProcessor<Student, ProcessedStudent> {

	private int studentCount=0;
    @Override
    public ProcessedStudent process(Student student) throws Exception {
       while(studentCount++<5) {
        return new ProcessedStudent(studentCount,student);
       }
	return null;
    }
}

