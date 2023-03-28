package com.example.springboot_backend.service.impl;

import com.example.springboot_backend.exception.ResourceNotFoundExeption;
import com.example.springboot_backend.model.Employee;
import com.example.springboot_backend.repository.EmployeeRepository;
import com.example.springboot_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSeriverImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	public EmployeeSeriverImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);

//		if (employee.isPresent()){
//			return employee;
//		} else {
//			throw new ResourceNotFoundExeption("Employee","id",id);
//		}

		return Optional.ofNullable(employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Employee", "id", id)));
	}
}
