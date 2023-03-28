package com.example.springboot_backend.service;

import com.example.springboot_backend.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Optional<Employee> getEmployeeById(long id);
}
