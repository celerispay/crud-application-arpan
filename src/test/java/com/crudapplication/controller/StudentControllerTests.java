package com.crudapplication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.crudapplication.entity.College;
import com.crudapplication.entity.Director;
import com.crudapplication.entity.Student;
import com.crudapplication.service.StudentService;

@ExtendWith(MockitoExtension.class)
class StudentControllerTests {

	@Mock
	private StudentService service;

	@InjectMocks
	private StudentController controller;

	@Test
	void testGetAllStudents() {
		List<Student> students = new ArrayList<>();
		Director director = new Director(1, "Mohan Lal");
		College college = new College(1901, "MVM", "Lucknow", director);
		students.add(new Student(1, "Arpan", "93", college));
		students.add(new Student(2, "Tapan", "94", college));
		when(service.getAllStudents()).thenReturn(students);

		ResponseEntity<List<Student>> responseEntity = controller.getAllStudents();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(2, responseEntity.getBody().size());
	}

	@Test
	void testGetStudent() {
		int id = 1;
		Director director = new Director(1, "Mohan Lal");
		College college = new College(1901, "MVM", "Lucknow", director);
		Student student = new Student(id, "Avinash", "96", college);
		when(service.getStudent(id)).thenReturn(student);

		ResponseEntity<Student> responseEntity = controller.getStudent(id);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
		assertEquals(id, responseEntity.getBody().getId());
	}

	@Test
	void testAddStudent() {
		List<Student> students = new ArrayList<>();
		Director director = new Director(1, "Mohan Lal");
		College college = new College(1901, "MVM", "Lucknow", director);
		students.add(new Student(1, "Arpan", "93", college));
		ResponseEntity<List<Student>> responseEntity = controller.addStudent(students, null);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		verify(service, times(1)).addStudent(students.get(0));
	}

	@Test
	void testUpdateStudent() {
		int id = 1;
		List<Student> students = new ArrayList<>();
		Director director = new Director(1, "Mohan Lal");
		College college = new College(1901, "MVM", "Lucknow", director);
		students.add(new Student(1, "Tapan", "93", college));

		ResponseEntity<Void> responseEntity = controller.updateStudent(students, id, null);

		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
		verify(service, times(1)).updateStudent(students, id);
	}

	@Test
	void testDeleteStudentByID() {
		int id = 1;

		ResponseEntity<Void> responseEntity = controller.deleteStudentByID(id);

		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
		verify(service, times(1)).deleteStudentByID(id);
	}

}
