package com.demo.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@GetMapping("/users/addNewEmployee")
	public ModelAndView show() {
		return new ModelAndView("addEmployee", "emp", new Employee());
	}

	@PostMapping("/users")
	public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) {

		employeeService.insertEmployee(emp);
		String message = "Added a new employee sucessfully!";
		ModelAndView model = new ModelAndView("addedNewEmployee");
		model.addObject("message", message);
		return model;
	}

	@GetMapping("/users")
	public ModelAndView getEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("viewAllEmployees");
		Collections.sort(employees, (emp1, emp2) -> emp1.getEmpId().compareTo(emp2.getEmpId()));
		model.addObject("employees", employees);
		return model;
	}

	@GetMapping("/users/findById")
	public ModelAndView getEmployeeByIdForm() {
		return new ModelAndView("getEmployeeByIdForm", "getIdForm", new Employee());
	}

	@GetMapping("/users/{empId}")
	public ModelAndView getEmployeeById(@PathVariable String empId) {
		Employee employee = employeeService.getEmployeeById(empId);
		ModelAndView model = new ModelAndView("gotEmployeeById");
		model.addObject("employee", employee);
		return model;
	}

	@GetMapping("/users/edit/{empId}")
	public ModelAndView updateEmployee(@PathVariable String empId) {
		Employee employee = employeeService.getEmployeeById(empId);
	
		ModelAndView model = new ModelAndView("employedit");
		model.addObject("empl", employee);
		return model;

	}

	@GetMapping("/users/deleted/{empId}")
	public String deleteById(@PathVariable String empId, Model model) {
		employeeService.deleteEmployeeById(empId);
		String message = "deleted successfully";
		model.addAttribute("message", message);
		return "deleted";
	}
	
	@PostMapping("/users/edit")
	public ModelAndView updatedEmployee(@RequestParam String empName, @RequestParam String empId) {
		Employee employee= new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employeeService.updateEmployee(employee,empId);
		String message = "Updated sucessfully!";
		ModelAndView model = new ModelAndView("updateEmployee");
		model.addObject("message", empName);
		return model;
	}

}
