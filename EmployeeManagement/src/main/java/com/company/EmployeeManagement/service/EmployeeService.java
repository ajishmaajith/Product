package com.company.EmployeeManagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.EmployeeManagement.Exception.ResourceNotFoundException;
import com.company.EmployeeManagement.model.Employee;
import com.company.EmployeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public List<Employee> getAllEmployeeList() {

		return repo.findAll();

	}

	public Employee addEmployee(Employee emp) {

		Employee obj = repo.save(emp);

		return obj;
	}

	public Employee getEmployeeById(int id) {

		Optional<Employee> o = repo.findById(id);

		if (o.isPresent()) {
			return o.get();
		} else {
			throw new ResourceNotFoundException("No details found for this id :" + id);
		}
	}

	public Employee updateEmployeeById(int id, Employee e) {
		Optional<Employee> o = repo.findById(id);

		if (o.isPresent()) {

			o.get().setFirstName(e.getFirstName());
			o.get().setLastName(e.getLastName());
			o.get().setEmailId(e.getEmailId());
			return repo.save(o.get());

		} else {
			throw new ResourceNotFoundException("No details found for this id :" + id);
		}
	}
	
	public Map<String,Boolean> deleteEmployee(int id){
		
		Optional<Employee> o = repo.findById(id);

		if (o.isPresent()) {
			repo.delete(o.get());
			
			Map<String,Boolean> map=new HashMap<String, Boolean>();
			map.put("Deleted!!", true);
			return map;
			
			
		} else {
			throw new ResourceNotFoundException("No details found for this id :" + id);
		}
		
	}

}
