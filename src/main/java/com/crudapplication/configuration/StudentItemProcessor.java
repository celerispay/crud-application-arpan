package com.crudapplication.configuration;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.crudapplication.entity.Student;

@Component
public class StudentItemProcessor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) throws Exception {
        return student; 
    }
}

