package com.example.dao;

import java.util.List;

import com.example.bean.Student;

public interface StudentRepo {
	
	public String saveStudent(Student s);
	
	public List<Student> getAll();
	
	public Student getById(int id);
	
	public String deleteById(int id);

}
