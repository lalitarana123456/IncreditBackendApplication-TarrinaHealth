package com.assignment.incredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.incredit.model.Customer;
import com.assignment.incredit.model.Order;
import com.assignment.incredit.repository.CustomerRepository;
import com.assignment.incredit.repository.OrderRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           OrderRepository orderRepository,
                           ObjectMapper objectMapper) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.objectMapper = objectMapper; // Spring-configured with JavaTimeModule
    }

    public void importCustomerData(MultipartFile file) throws Exception {
        List<Customer> customers = objectMapper.readValue(
            file.getInputStream(),
            new TypeReference<List<Customer>>() {}
        );

        for (Customer customer : customers) {
            for (Order order : customer.getOrders()) {
                order.setCustomer(customer);
            }
        }

        customerRepository.saveAll(customers);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

}
