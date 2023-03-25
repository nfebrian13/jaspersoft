package com.nfebrian13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfebrian13.model.Student;
import com.nfebrian13.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student findById(long id) {
		return studentRepository.findById(id);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}
}
