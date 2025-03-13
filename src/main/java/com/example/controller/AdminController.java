package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bean.Student;
import com.example.service.StudentService;

@Controller
@RequestMapping("/admin/students")
public class AdminController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/reg")
	public String studentRegPage() {
		return "StudentRegister";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student,Model m) {
		String message = studentService.saveStudent(student);
		m.addAttribute("resp", message);
		return "StudentRegister";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id,Model m) {
		String msg = studentService.deleteById(id);
		m.addAttribute("resp", msg);
		return "redirect:/students/getAll";
	}
	
	
	

}
