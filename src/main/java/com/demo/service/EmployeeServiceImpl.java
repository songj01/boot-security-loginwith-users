package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		employeeDao.insertEmployees(employees);
	}

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}



	@Override
	public Employee getEmployeeById(String empId) {
		Employee employee = employeeDao.getEmployeeById(empId);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee, String id) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(employee, id);
	}

	@Override
	public boolean deleteEmployeeById(String empid) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployeeById(empid);
	}

}