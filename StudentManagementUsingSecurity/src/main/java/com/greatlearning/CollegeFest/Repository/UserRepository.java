package com.greatlearning.CollegeFest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.greatlearning.CollegeFest.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByNameContainsAndAuthorContainsAllIgnoreCases(String username);

	@Query("SELECT u FROM User u WHERE u.username = ?1")

	public User getUserByUsername(String username);
}
