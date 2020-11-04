package com.app.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.task.bean.Employee;
import com.app.task.repo.EmployeeRepo;
import com.app.task.service.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/addEmp")
	public long addEmployee(@RequestBody Employee employee) {
		this.companyService.addEmployee(employee);
		return this.companyService.getEmployeeRepo().findByNameAndSalary(employee.getName(), employee.getSalary()).getId();
	}
	
	@GetMapping("/getOneEmp/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return this.companyService.getEmployeeById(id);
	}
	
	@GetMapping("/getEmp")
	public List<Employee> getEmployees() {
		return this.companyService.getAllEmployees();
	}
	
	@GetMapping("/getEmp/{name}")
	public List<Employee> getEmployees(@PathVariable String name) {
		return this.companyService.getEmployeesByName(name);
	}
}
