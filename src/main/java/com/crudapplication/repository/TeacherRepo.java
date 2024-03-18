package com.crudapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudapplication.entity.Teacher;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher,Integer>{

}
