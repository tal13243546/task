package com.app.task.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.task.bean.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByName(String name);
	
	Employee findByNameAndSalary(String name, double salary);

	Employee findById(Long id);
	
}
