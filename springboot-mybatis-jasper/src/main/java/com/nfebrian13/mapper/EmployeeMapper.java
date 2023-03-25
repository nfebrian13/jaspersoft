package com.nfebrian13.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nfebrian13.model.Employee;

@Mapper
public interface EmployeeMapper {

	public Employee findByIdEmployee(long id);
	
	public List<Employee> findAllEmployee();
}
