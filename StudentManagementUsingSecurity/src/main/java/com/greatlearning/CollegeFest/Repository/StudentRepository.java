package com.greatlearning.CollegeFest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greatlearning.CollegeFest.Entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findbyNameContainsAndfirstNameContailsAllIgnoreCase(String firstName, String lastName);

	@Query("Select s from Student s where s.firstName like ?2 or name like ?1")

	List<Student> findSearch(String firstName, String lastName);

}