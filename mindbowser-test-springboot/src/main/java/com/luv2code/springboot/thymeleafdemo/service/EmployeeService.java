package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.Entity.Employee;

public interface EmployeeService {

		public List<Employee> findAll();
		
		public Employee findById(int theId);
		
		public void save(Employee employee);
		
		public void deleteById(int theId);
	
}
