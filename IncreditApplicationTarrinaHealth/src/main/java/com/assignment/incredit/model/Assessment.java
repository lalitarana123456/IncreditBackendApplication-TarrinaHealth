package com.assignment.incredit.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assessment {

	
	
	@Id
    private String assessmentId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private double requestedCreditAmount;
    private int tenureMonths;
    private String purpose;

    private boolean willPayOnTime;
    private double riskScore;
    private String riskCategory;
    private double confidence;

    private double paymentHistoryWeight;
    private double incomeRatioWeight;
    private double creditUtilizationWeight;

    private String recommendation;
    private double maxRecommendedAmount;
    private int recommendedTenure;

    private LocalDateTime timestamp;

    @PrePersist
    public void autoSetId() {
        this.assessmentId = "ASMT_" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.timestamp = LocalDateTime.now();
    }

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getRequestedCreditAmount() {
		return requestedCreditAmount;
	}

	public void setRequestedCreditAmount(double requestedCreditAmount) {
		this.requestedCreditAmount = requestedCreditAmount;
	}

	public int getTenureMonths() {
		return tenureMonths;
	}

	public void setTenureMonths(int tenureMonths) {
		this.tenureMonths = tenureMonths;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public boolean isWillPayOnTime() {
		return willPayOnTime;
	}

	public void setWillPayOnTime(boolean willPayOnTime) {
		this.willPayOnTime = willPayOnTime;
	}

	public double getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(double riskScore) {
		this.riskScore = riskScore;
	}

	public String getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	public double getPaymentHistoryWeight() {
		return paymentHistoryWeight;
	}

	public void setPaymentHistoryWeight(double paymentHistoryWeight) {
		this.paymentHistoryWeight = paymentHistoryWeight;
	}

	public double getIncomeRatioWeight() {
		return incomeRatioWeight;
	}

	public void setIncomeRatioWeight(double incomeRatioWeight) {
		this.incomeRatioWeight = incomeRatioWeight;
	}

	public double getCreditUtilizationWeight() {
		return creditUtilizationWeight;
	}

	public void setCreditUtilizationWeight(double creditUtilizationWeight) {
		this.creditUtilizationWeight = creditUtilizationWeight;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public double getMaxRecommendedAmount() {
		return maxRecommendedAmount;
	}

	public void setMaxRecommendedAmount(double maxRecommendedAmount) {
		this.maxRecommendedAmount = maxRecommendedAmount;
	}

	public int getRecommendedTenure() {
		return recommendedTenure;
	}

	public void setRecommendedTenure(int recommendedTenure) {
		this.recommendedTenure = recommendedTenure;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
    
    
    
}
