package com.crudapplication.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.crudapplication.entity.College;
import com.crudapplication.entity.Director;
import com.crudapplication.entity.Student;


@DataJpaTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepoTests {

	@Autowired
	private StudentRepo repository;

	private Student student;

	@BeforeEach
	public void setupTestData() {
		student = Student.builder().id(1).name("Arpan").marks("97").college(College.builder().id(1901).name("MVM")
				.place("Lucknow").director(Director.builder().id(1).name("Mohan Lal").build()).build()).build();
	}

	@Test
	public void testFindAll() {
		Student studentOne = Student.builder().id(2).name("Sakshi").marks("97").college(College.builder().id(1901)
				.name("MVM").place("Lucknow").director(Director.builder().id(1).name("Mohan Lal").build()).build())
				.build();

		Student studentTwo = Student.builder().id(1).name("Rahul").marks("97").college(College.builder().id(1901)
				.name("MVM").place("Lucknow").director(Director.builder().id(1).name("Mohan Lal").build()).build())
				.build();

		repository.save(studentOne);
		repository.save(studentTwo);

		List<Student> students = (List<Student>) repository.findAll();
		assertEquals(students.isEmpty(), false);
//		assertEquals(students.size(),6);
	}

	@Test
	public void testGetStudent() {
		repository.save(student);
		Student students = repository.findById(student.getId()).get();
		assertNotNull(students);
	}

	@Test
	public void testAddStudent() {
		Student addedStudent = repository.save(student);
		assertNotNull(addedStudent);
		assertEquals(true, addedStudent.getId() > 0);

	}

	@Test
	public void testUpdateStudent() {
		repository.save(student);
		student.setName("Ramu");
		Student updatedStudent = repository.save(student);

		assertNotNull(updatedStudent);
		assertEquals("Ramu", updatedStudent.getName());
	}

	@Test
	public void testDeleteStudent() {
		repository.save(student);

		repository.deleteById(student.getId());

		Optional<Student> deletedStudentOptional = repository.findById(student.getId());
		assertTrue(deletedStudentOptional.isEmpty());
	}

}
