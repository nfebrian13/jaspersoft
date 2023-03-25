package com.nfebrian13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nfebrian13.model.Student;
import com.nfebrian13.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/student/{id}", produces = "application/json")
	public Student findById(@PathVariable long id) {
		return studentService.findById(id);
	}

	@GetMapping(path = "/student", produces = "application/json")
	public List<Student> findAll() {
		return studentService.findAll();
	}
}
