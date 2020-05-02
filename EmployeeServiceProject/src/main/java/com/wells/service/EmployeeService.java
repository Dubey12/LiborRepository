package com.wells.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wells.model.Employee;

@Service
public class EmployeeService {
	
	List<Employee>empList=new ArrayList<Employee>();
	
	public List<Employee>getEmployeeList(){
		//ArrayList<Employee>empList=new ArrayList<Employee>();
		empList.add(new Employee(100,"Ajay","SeniorSoftware",50000.0));
		empList.add(new Employee(101,"Jhon","Lead",80000.0));
		empList.add(new Employee(102,"shan","Technical specialist",70000.0));
		empList.add(new Employee(103,"Rocky","SeniorSoftware",50000.0));
		empList.add(new Employee(104,"Alex","consultant",100000.0));
		return empList;
		
		
	}
	
	public Employee addEmployee(Employee e) {
		empList.add(e);
		return e;
		
	}

}
