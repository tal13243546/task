package com.app.task.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class EmployeeList {
	
	private List<Employee> employees = new ArrayList<Employee>();

}
