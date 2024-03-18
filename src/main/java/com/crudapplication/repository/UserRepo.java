package com.crudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudapplication.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User,Integer>{

	User findByName(String name);

	

	

	

	

}
