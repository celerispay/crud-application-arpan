package com.crudapplication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@Column(name = "teacher_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;

	@Column(name = "teacher_name")
	private String teacherName;

	@ManyToMany
	@JoinTable(name = "course_teacher", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> course;
	
	
	 public Teacher(TeacherDTO teacherDTO) {
		 this.teacherId=teacherDTO.getId();
	       this.teacherName = teacherDTO.getName();
	       
	        this.course = mapCourseDTOsToCourses(teacherDTO.getCourse());
	    }

	   
	    private Set<Course> mapCourseDTOsToCourses(Set<CourseDTO> courseDTOs) {
	        Set<Course> courses = new HashSet<>();
	        for (CourseDTO courseDTO : courseDTOs) {
	            Course course = new Course();
	            course.setId(courseDTO.getId());
	            course.setName(courseDTO.getName());
	            courses.add(course);
	        }
	        return courses;
	    }
	}

