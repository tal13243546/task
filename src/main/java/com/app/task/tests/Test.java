package com.app.task.tests;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.task.bean.Employee;
import com.app.task.bean.EmployeeList;
import com.app.task.bean.Job;
import com.app.task.service.CompanyService;
import com.app.task.utils.ArtUtils;

@Component
public class Test implements CommandLineRunner{
	@Autowired
	private CompanyService company; 
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		ArtUtils.myTest();
		String URL = "http://localhost:8080/company/";
		Employee e1 = new Employee("Tal Levin", 19000.0);
		Job j1 = new Job("Get 100 in the Task", Date.valueOf("2020-10-26"));
		Job j2 = new Job("Finish JB Course", Date.valueOf("2020-12-26"));
		e1.getJobs().add(j1);
		e1.getJobs().add(j2);
		
		Employee e2 = new Employee("Tomer Levin", 14000.0);
		Job j3 = new Job("Learn Python", Date.valueOf("2020-12-26"));
		Job j4 = new Job("Finish semaster One", Date.valueOf("2021-03-26"));
		e2.getJobs().add(j3);
		e2.getJobs().add(j4);
		System.out.println("-------------------------Add Employee---------------------------");
		System.out.println("Employee:" + restTemplate.postForEntity(URL + "addEmp", e1, Long.class).getBody());
		System.out.println("Employee:" + restTemplate.postForEntity(URL + "addEmp", e2, Long.class).getBody());
//		company.addEmployee(e1);
//		company.addEmployee(e2);
		System.out.println();
		System.out.println(restTemplate.getForObject(URL + "getEmp", EmployeeList.class).getEmployees());
//		System.out.println(company.getAllEmployees() + "\n");
		System.out.println("-------------------------Get Employee By ID(1)---------------------------");
		System.out.println();
		System.out.println(restTemplate.getForObject(URL + "getOneEmp/1", Employee.class));
//		System.out.println(company.getEmployeeById(1) + "\n");
		System.out.println("-------------------------Get Employees By Name(Tal Levin)---------------------------");
		System.out.println();
		System.out.println(restTemplate.getForObject(URL + "getEmp/Tal Levin", EmployeeList.class).getEmployees());
//		System.out.println(company.getEmployeesByName("Tal Levin") + "\n");
		System.out.println("-------------------------Get All Employees---------------------------");
		System.out.println();
		System.out.println(restTemplate.getForObject(URL + "getEmp", EmployeeList.class).getEmployees());
//		System.out.println(company.getAllEmployees() + "\n");
//		System.out.println("-------------------------Get All Jobs---------------------------");
//		System.out.println();
//		System.out.println(company.getAllJobs() + "\n");
//		System.out.println("-------------------------Get Jobs By End Date(2020-12-26)---------------------------");
//		System.out.println();
//		System.out.println(company.getJobsByEndDate(Date.valueOf("2020-12-26")) + "\n");
//		System.out.println("-------------------------Get Jobs Between Dates(2020-12-28 : 2021-03-28)---------------------------");
//		System.out.println();
//		System.out.println(company.getJobsBetweenEndDates(Date.valueOf("2020-12-28"), Date.valueOf("2021-03-28")));
	}

}
