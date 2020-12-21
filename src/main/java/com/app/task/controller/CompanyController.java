package com.app.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.task.bean.Employee;
import com.app.task.bean.EmployeeList;
import com.app.task.service.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/addEmp")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Long>(this.companyService.addEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/getOneEmp/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable Long id) {
		return new ResponseEntity<Employee>(this.companyService.getEmployeeById(id), HttpStatus.OK) ;
	}
	
	@GetMapping("/getEmp")
	public ResponseEntity<?> getEmployees() {
		List<Employee> employees = this.companyService.getAllEmployees();
		EmployeeList employeeList = new EmployeeList(employees);
		return new ResponseEntity<EmployeeList>(employeeList, HttpStatus.OK) ;
	}
	
	@GetMapping("/getEmp/{name}")
	public ResponseEntity<?> getEmployees(@PathVariable String name) {
		List<Employee> employees = this.companyService.getEmployeesByName(name);
		EmployeeList employeeList = new EmployeeList(employees);
		return new ResponseEntity<EmployeeList>(employeeList, HttpStatus.OK) ;
	}
}
