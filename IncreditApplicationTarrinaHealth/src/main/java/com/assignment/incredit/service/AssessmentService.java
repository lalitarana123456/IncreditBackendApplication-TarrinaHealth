package com.assignment.incredit.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.stereotype.Service;

import com.assignment.incredit.dto.CreditAssessmentRequestDTO;
import com.assignment.incredit.dto.CreditAssessmentResponseDTO;
import com.assignment.incredit.dto.RiskAssessmentDTO;
import com.assignment.incredit.model.Customer;
import com.assignment.incredit.model.Order;
import com.assignment.incredit.repository.CustomerRepository;

@Service
public class AssessmentService {
	
	private final CustomerRepository customerRepository;

    public AssessmentService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CreditAssessmentResponseDTO assess(CreditAssessmentRequestDTO request) {
    	
        Customer customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if (customer == null) throw new RuntimeException("Customer not found.");

        List<Order> orders = customer.getOrders();
        if (orders == null || orders.isEmpty()) throw new RuntimeException("No orders found for customer.");

        // Statistical Metrics
        double onTimePercentage = getOnTimePaymentRate(orders);
        double incomeToCreditRatio = customer.getApproxAnnualIncomeInr() / averageCredit(orders);
        double creditUtilization = averageUtilization(orders);

        // Linear Regression
        SimpleRegression regression = new SimpleRegression(true);
        for (Order order : orders) {
            regression.addData(order.getCreditExtendedAmountInr(), order.getAmountPaidInr());
        }

        double confidence = regression.getR(); // Correlation coefficient (0 to 1)

        // Calculate risk score (lower is better)
        double score = 100 - (onTimePercentage * 0.4 + incomeToCreditRatio * 0.3 + (100 - creditUtilization) * 0.3);
        int riskScore = (int) Math.min(100, Math.max(0, score));

        String riskCategory;
        if (riskScore <= 33) riskCategory = "LOW";
        else if (riskScore <= 66) riskCategory = "MEDIUM";
        else riskCategory = "HIGH";

        // Build Response
        CreditAssessmentResponseDTO response = new CreditAssessmentResponseDTO();
        response.setCustomerId(customer.getId());
        response.setAssessmentId("asmt_" + Instant.now().toEpochMilli());

        RiskAssessmentDTO ra = new RiskAssessmentDTO();
        ra.setWillPayOnTime(riskCategory.equals("LOW"));
        ra.setRiskScore(riskScore);
        ra.setRiskCategory(riskCategory);
        ra.setConfidence(confidence);
        response.setRiskAssessment(ra);

        // Statistical Factors
        List<Map<String, Object>> factors = new ArrayList<>();
        factors.add(factor("payment_history_percentage", onTimePercentage, "positive", "On-time payment rate"));
        factors.add(factor("income_to_credit_ratio", incomeToCreditRatio, "positive", "Income vs Credit ratio"));
        factors.add(factor("credit_utilization", creditUtilization, "neutral", "Average credit usage"));

        response.setStatisticalFactors(factors);

        // Regression Coefficients
        Map<String, Double> coefficients = new HashMap<>();
        coefficients.put("intercept", regression.getIntercept());
        coefficients.put("slope", regression.getSlope());
        response.setRegressionCoefficients(coefficients);

        // Recommendation
        response.setRecommendation(riskCategory.equals("HIGH") ? "REJECT" : "APPROVE");
        response.setAlternativeTerms(Map.of(
                "maxRecommendedAmount", 75000,
                "recommendedTenure", request.getTenureMonths()
        ));

        response.setTimestamp(Instant.now().toString());

        return response;
    }

    private double getOnTimePaymentRate(List<Order> orders) {
        long onTime = orders.stream().filter(o -> o.getPaymentStatus().equals("PAID") && o.getDaysOutstandingOrLate() <= 0).count();
        return (onTime * 100.0) / orders.size();
    }

    private double averageCredit(List<Order> orders) {
        return orders.stream().mapToDouble(Order::getCreditExtendedAmountInr).average().orElse(1.0);
    }

    private double averageUtilization(List<Order> orders) {
        return orders.stream()
                .mapToDouble(o -> o.getAmountPaidInr() / o.getCreditExtendedAmountInr() * 100)
                .average().orElse(0.0);
    }

    private Map<String, Object> factor(String factor, double value, String impact, String desc) {
        Map<String, Object> map = new HashMap<>();
        map.put("factor", factor);
        map.put("value", value);
        map.put("impact", impact);
        map.put("description", desc);
        return map;
    }

}
