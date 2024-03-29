package com.crudapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "college")
public class College {

	@Id
	@Column(name = "college_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "college_name")
	private String name;

	@Column(name = "college_place")
	private String place;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "director_id")
	private Director director;

	public College(CollegeDTO collegeDTO, DirectorDTO directorDTO) {
		this.id = collegeDTO.getId();
		this.name = collegeDTO.getName();
		this.place = collegeDTO.getPlace();
		this.director = new Director(collegeDTO.getDirector().getId(), collegeDTO.getDirector().getName());
	}
}