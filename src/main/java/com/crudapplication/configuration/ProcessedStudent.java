package com.crudapplication.configuration;

import com.crudapplication.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessedStudent {
	
	private int count;
	private Student student;

}
