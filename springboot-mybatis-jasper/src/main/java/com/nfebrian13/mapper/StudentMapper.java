package com.nfebrian13.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nfebrian13.model.Student;

@Mapper
public interface StudentMapper {

	public Student findById(long id);
	
	public List<Student> findAll();

}
