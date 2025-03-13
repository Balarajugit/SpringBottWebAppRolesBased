package com.example.service;

import java.util.List;

import com.example.bean.Student;

public interface StudentService {
	
	public String saveStudent(Student s);
	
	public List<Student> getAll();
	
	public String deleteById(int id);

}
