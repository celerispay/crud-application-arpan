package com.crudapplication.configuration;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.crudapplication.entity.Student;
import com.crudapplication.repository.StudentRepo;




@Component

public class StudentItemReader implements ItemReader<Student> {

    @Autowired
    private StudentRepo studentRepo;

    private int nextStudentIndex;
    private List<Student> students;

    @Override
    public Student read() throws Exception {
        if (students == null) {
            students = (List<Student>) studentRepo.findAll(); 
            nextStudentIndex = 0;
        }

        Student nextStudent = null;
        if (nextStudentIndex < students.size()) {
            nextStudent = students.get(nextStudentIndex);
          
            nextStudentIndex++;
        }

        return nextStudent;
    }
}
