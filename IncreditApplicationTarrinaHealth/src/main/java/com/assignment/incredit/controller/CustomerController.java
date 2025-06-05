package com.assignment.incredit.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.incredit.model.Customer;
import com.assignment.incredit.service.CustomerService;
import com.assignment.incredit.service.StatisticsService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	private final CustomerService customerService;
    private final StatisticsService statisticsService;

    public CustomerController(CustomerService customerService, StatisticsService statisticsService) {
        this.customerService = customerService;
        this.statisticsService = statisticsService;
    }

    @PostMapping("/import")
    public ResponseEntity<String> importCustomerData(@RequestParam("file") MultipartFile file) {
        try {
            customerService.importCustomerData(file);
            return ResponseEntity.ok("Customer data imported successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to import data: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.getCustomerById(id);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/statistics")
    public ResponseEntity<Map<String, Object>> getStatistics(@PathVariable("id") Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) return ResponseEntity.notFound().build();
        Map<String, Object> stats = statisticsService.calculateStatistics(customer);
        return ResponseEntity.ok(stats);
    }

}
