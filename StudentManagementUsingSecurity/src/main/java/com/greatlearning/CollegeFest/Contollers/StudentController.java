package com.greatlearning.CollegeFest.Contollers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.CollegeFest.Entities.Student;
import com.greatlearning.CollegeFest.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// add mapping for "/list"
	@RequestMapping("/list")
	public String listStudents(Model theModel) {

		// get Students from database
		List<Student> theStudents = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("ListofStudents", theStudents);
		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		return "student-form";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		// get the Student from the service
		Student theStudent = studentService.findById(theId);

		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		return "student-form";

	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("studentId") int studentId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("department") String department,
			@RequestParam("country") String country) {
		System.out.println(studentId);
		Student theStudents;
		if (studentId != 0) {

			theStudents = studentService.findById(studentId);
			theStudents.setFirstName(firstName);
			theStudents.setLastName(lastName);
			theStudents.setDepartment(department);
			theStudents.setCountry(country);
		} else
			theStudents = new Student();
		// save the Students
		studentService.save(theStudents);

		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studId") int theId) {

		// delete the Student
		studentService.deleteById(theId);

		// redirect to /Students/list
		return "redirect:/students/list";

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}
