package com.crudapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudapplication.entity.Director;

@Repository
public interface DirectorRepo extends CrudRepository<Director, Integer> {

}
