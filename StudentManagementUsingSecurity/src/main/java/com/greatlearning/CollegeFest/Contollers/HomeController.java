package com.greatlearning.CollegeFest.Contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/home")

public class HomeController {

	@GetMapping("/hello")

	public String showHomePage() {

		System.out.println("Working");

		return "home";

	}

}
