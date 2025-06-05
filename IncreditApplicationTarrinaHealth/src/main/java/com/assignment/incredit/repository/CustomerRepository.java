package com.assignment.incredit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.incredit.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
