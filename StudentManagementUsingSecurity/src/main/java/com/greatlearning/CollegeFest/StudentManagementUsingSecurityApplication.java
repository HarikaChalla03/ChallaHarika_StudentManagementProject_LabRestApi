package com.greatlearning.CollegeFest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({ "main.controllers", "main.repositories" })
@EnableJpaRepositories("main.repositories")
@SpringBootApplication
public class StudentManagementUsingSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementUsingSecurityApplication.class, args);
		System.out.println("Hi");
	}

	void contextLoads() {
	}

}
