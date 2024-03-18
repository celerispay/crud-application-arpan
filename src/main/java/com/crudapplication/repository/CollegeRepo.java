package com.crudapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudapplication.entity.College;

@Repository
public interface CollegeRepo extends CrudRepository<College,Integer> {

}
