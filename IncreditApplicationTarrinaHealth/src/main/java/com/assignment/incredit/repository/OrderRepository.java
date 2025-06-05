package com.assignment.incredit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.incredit.model.Order;

public interface OrderRepository extends JpaRepository<Order, String>{
	
	
	List<Order> findByCustomerId(Long customerId);

}
