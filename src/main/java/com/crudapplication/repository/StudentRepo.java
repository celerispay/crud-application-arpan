package com.crudapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudapplication.entity.Student;




@Repository
public interface StudentRepo extends CrudRepository<Student,Integer>{

}
