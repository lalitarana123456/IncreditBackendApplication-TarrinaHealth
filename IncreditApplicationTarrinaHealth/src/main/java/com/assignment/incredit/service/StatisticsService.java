package com.assignment.incredit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.assignment.incredit.model.Customer;
import com.assignment.incredit.model.Order;
import com.assignment.incredit.repository.OrderRepository;


@Service
public class StatisticsService {
	
	
	private final OrderRepository orderRepository;

    public StatisticsService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Map<String, Object> calculateStatistics(Customer customer) {
        List<Order> orders = orderRepository.findByCustomerId(customer.getId());

        int totalOrders = orders.size();
        long onTimePayments = orders.stream().filter(o -> "PAID".equals(o.getPaymentStatus()) && o.getDaysOutstandingOrLate() <= 0).count();
        double onTimePercentage = totalOrders > 0 ? ((double) onTimePayments / totalOrders) * 100 : 0.0;

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalOrders", totalOrders);
        stats.put("onTimePercentage", onTimePercentage);
        return stats;
    }

}
