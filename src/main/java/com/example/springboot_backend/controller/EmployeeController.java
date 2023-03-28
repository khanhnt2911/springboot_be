package com.example.springboot_backend.controller;

import com.example.springboot_backend.model.Employee;
import com.example.springboot_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

//	build create employee REST API
	@PostMapping()
	public ResponseEntity<Employee> saveEmloyee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}

//	build get employee by id REST API

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeByid(@PathVariable("id") long id){
		ResponseEntity<Employee> employeeResponseEntity = new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
		return employeeResponseEntity;
	}
}
