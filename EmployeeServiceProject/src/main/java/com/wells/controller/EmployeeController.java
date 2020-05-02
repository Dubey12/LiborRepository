package com.wells.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wells.model.Employee;
import com.wells.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee getEmployee(@RequestParam int id) {
		Employee e=new Employee();
		for(Employee emp:empService.getEmployeeList()) {
			if(emp.getEmpId()==id) {
				e.setEmpId(emp.getEmpId());
				e.setName(emp.getName());
				e.setDesignation(emp.getDesignation());
				e.setSalary(emp.getSalary());
			}
		}
		

		return e;
	}
	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public List<Employee> getEmployees() {

		return empService.getEmployeeList();
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {

		System.out.println("Inside POST Method");
		Employee emp = new Employee();
		emp.setName(employee.getName());
		emp.setDesignation(employee.getDesignation());
		emp.setEmpId(employee.getEmpId());
		emp.setSalary(employee.getSalary());
		
		Employee e=empService.addEmployee(emp);

		return e;
	}

}