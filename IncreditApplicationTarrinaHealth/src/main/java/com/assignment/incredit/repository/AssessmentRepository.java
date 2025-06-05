package com.assignment.incredit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.incredit.model.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, String>{

	
	List<Assessment> findByCustomerId(Long customerId);
}
