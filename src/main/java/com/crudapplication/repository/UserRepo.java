package com.crudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudapplication.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	User findByUsername(String username);

}
