package com.crudapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	
	private int id;
	private String name;
	private String marks;
	private CollegeDTO college;
	
	

}
