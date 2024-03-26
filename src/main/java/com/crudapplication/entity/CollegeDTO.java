package com.crudapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollegeDTO {
	
	private int id;
	private String name;
	private String place;
	private DirectorDTO director;

}
