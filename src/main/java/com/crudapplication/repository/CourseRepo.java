package com.crudapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudapplication.entity.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course,Integer>{

}
