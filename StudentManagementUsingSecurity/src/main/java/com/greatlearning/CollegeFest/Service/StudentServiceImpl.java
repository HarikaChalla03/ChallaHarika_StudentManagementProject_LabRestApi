package com.greatlearning.CollegeFest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.CollegeFest.Entities.Student;
import com.greatlearning.CollegeFest.Repository.StudentRepository;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public List<Student> findAll() {

		List<Student> students = studentRepository.findAll();

		return students;
	}

	@Transactional
	public Student findById(int id) {

		Student student = new Student();

		// find record with Id from the database table
		student = studentRepository.findById(id).get();

		return student;
	}

	@Transactional
	public void save(Student theStudent) {

		studentRepository.save(theStudent);

	}

	@Transactional
	public void deleteById(int id) {

		studentRepository.deleteById(id);

	}

	@Transactional
	public List<Student> searchBy(String firstName, String lastName) {
		@SuppressWarnings("unused")
		List<Student> students = studentRepository.findbyNameContainsAndfirstNameContailsAllIgnoreCase(firstName,
				lastName);
		return null;

	}

}