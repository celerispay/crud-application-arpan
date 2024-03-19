package com.crudapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapplication.entity.College;

import com.crudapplication.repository.CollegeRepo;

import lombok.Data;

@Data
@Service
public class CollegeService {

	@Autowired
	private CollegeRepo repository;

	public List<College> getAllCollege() {
		List<College> college = (List<College>) repository.findAll();
		return college;
	}

	public void addCollege(College college) {
		repository.save(college);
	}

}
