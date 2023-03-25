package com.nfebrian13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfebrian13.mapper.EmployeeMapper;
import com.nfebrian13.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	public Employee findByIdEmployee(long id) {
		return employeeMapper.findByIdEmployee(id);
	}

	public List<Employee> findAllEmployee() {
		return employeeMapper.findAllEmployee();
	}

}
