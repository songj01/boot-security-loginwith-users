package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(String empid);
	void updateEmployee(Employee employee, String id);
	boolean deleteEmployeeById(String empid);
}