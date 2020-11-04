package com.app.task.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.app.task.bean.Employee;
import com.app.task.bean.Job;
import com.app.task.repo.EmployeeRepo;
import com.app.task.repo.JobRepo;

import lombok.Data;

@Service
@Lazy
@Data
public class CompanyService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private JobRepo jobRepo;

	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	public Employee getEmployeeById(int id) {
		return employeeRepo.getOne(id);
	}

	public List<Employee> getEmployeesByName(String name) {
		return employeeRepo.findByName(name);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	
	public List<Job> getAllJobs() {
		return jobRepo.findAll();
	}
	
	public List<Job> getJobsByEndDate(Date endDate) {
		return jobRepo.findByEndDate(endDate);
	}
	
	public List<Job> getJobsBetweenEndDates(Date start, Date end) {
		return jobRepo.findByEndDateBetween(start, end);
	}

}
