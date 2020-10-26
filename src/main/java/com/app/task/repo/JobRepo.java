package com.app.task.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.task.bean.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {
	
	List<Job> findByEndDate(Date endDate);
	List<Job> findByEndDateBetween(Date startDate, Date endDate);

}
