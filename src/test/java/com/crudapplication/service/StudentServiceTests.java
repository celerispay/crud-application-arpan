package com.crudapplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.crudapplication.entity.College;
import com.crudapplication.entity.Director;
import com.crudapplication.entity.Student;
import com.crudapplication.repository.StudentRepo;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

	@Mock
	private StudentRepo repository;

	@InjectMocks
	private StudentService service;

	@Test
	public void testGetAllStudents() {
		List<Student> students = new ArrayList<>();
		Director director = new Director(1, "Mohan Lal");
		College college = new College(1901, "MVM", "Lucknow", director);
		students.add(new Student(1, "Arpan", "93", college));
		students.add(new Student(2, "Tapan", "94", college));
		when(repository.findAll()).thenReturn(students);

		List<Student> result = service.getAllStudents();

		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	public void testGetStudent() {
		int id = 1;
		Director director = new Director(1, "Mohan Lal");
		College college = new College(1901, "MVM", "Lucknow", director);
		Student student = new Student(id, "Avinash", "96", college);
		when(repository.findById(id)).thenReturn(Optional.of(student));

		Student result = service.getStudent(id);

		assertNotNull(result);
		assertEquals(id, result.getId());
	}

	@Test
	public void testAddStudent() {
		Director director = new Director(1, "Mohan Lal");
		College college = new College(1901, "MVM", "Lucknow", director);
		Student student = new Student(1, "Arpan", "93", college);

		service.addStudent(student);

		verify(repository, times(1)).save(student);
	}

	@Test
	public void testUpdateStudent() {
		int id = 1;
		List<Student> students = new ArrayList<>();
		Director director = new Director(1, "Mohan Lal");
		College college = new College(1901, "MVM", "Lucknow", director);
		students.add(new Student(1, "Vishesh", "93", college));
		service.updateStudent(students, id);

		verify(repository, times(1)).save(students);
	}

	@Test
	public void testDeleteStudentByID() {
		int id = 1;

		service.deleteStudentByID(id);

		verify(repository, times(1)).deleteById(id);
	}
}
