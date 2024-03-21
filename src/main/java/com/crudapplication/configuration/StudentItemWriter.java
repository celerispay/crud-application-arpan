package com.crudapplication.configuration;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crudapplication.entity.Student;
import com.crudapplication.repository.StudentRepo;

import java.util.List;

@Component
public class StudentItemWriter implements ItemWriter<Student> {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void write(List<? extends Student> students) throws Exception {
        studentRepo.save(students); 
    }
}
