package com.company.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.EmployeeManagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
