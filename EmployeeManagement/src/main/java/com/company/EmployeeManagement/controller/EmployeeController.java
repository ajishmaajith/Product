package com.company.EmployeeManagement.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.EmployeeManagement.model.Employee;
import com.company.EmployeeManagement.service.EmployeeService;

@RestController
public class EmployeeController {
	
	
	@Autowired
	EmployeeService service;
	
	
	
	@GetMapping("employeelist")
	public List<Employee> getEmployeeList(){
		
		
		return service.getAllEmployeeList();
	}
	
	@GetMapping("employeeList/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		return service.getEmployeeById(id);
	}
	@PostMapping("addemployee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee e){
		return ResponseEntity.ok(service.addEmployee(e));
	}
	
	@PutMapping("updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable("id") int id,@RequestBody Employee e) {
		return service.updateEmployeeById(id, e);
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public Map<String,Boolean> deleteEmployee(@PathVariable("id") int id){
		return service.deleteEmployee(id);
	}

}
