package com.crudapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Name is required")
	@Column(name = "student_name")
	private String name;

	@NotBlank(message = "Marks is required")
	@Pattern(regexp = "\\d{1,3}", message = "Marks must be a number between 0 and 999")
	@Column(name = "student_marks")
	private String marks;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "college_id")
	private College college;
}
