package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bean.Student;
import com.example.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/*
	 * @GetMapping("/reg") public String studentRegPage() { return
	 * "StudentRegister"; }
	 * 
	 * @PostMapping("/saveStudent") public String
	 * saveStudent(@ModelAttribute("student") Student student,Model m) { String
	 * message = studentService.saveStudent(student); m.addAttribute("resp",
	 * message); return "StudentRegister"; }
	 */
	
	
	@GetMapping("/getAll")
	public String getAllStudents(Model m) {
		List<Student> li = studentService.getAll();
		m.addAttribute("list",li);
		return "StudentData";
	}
	
	

}
