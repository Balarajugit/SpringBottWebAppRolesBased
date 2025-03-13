package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Student;
import com.example.dao.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo srepo;
	
	@Override
	public String saveStudent(Student s) {
		// TODO Auto-generated method stub
		return srepo.saveStudent(s);
	}
	
	@Override
	public List<Student> getAll() {
		// TODO sre-generated method stub
		return srepo.getAll();
	}
	
	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		return srepo.deleteById(id);
	}

}
