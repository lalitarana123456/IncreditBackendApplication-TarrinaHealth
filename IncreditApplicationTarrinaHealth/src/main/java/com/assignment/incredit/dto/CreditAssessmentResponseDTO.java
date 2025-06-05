package com.assignment.incredit.dto;

import java.util.List;
import java.util.Map;

public class CreditAssessmentResponseDTO {
	
	private Long customerId;
    private String assessmentId;
    private RiskAssessmentDTO riskAssessment;
    private List<Map<String, Object>> statisticalFactors;
    private Map<String, Double> regressionCoefficients;
    private String recommendation;
    private Map<String, Object> alternativeTerms;
    private String timestamp;
    
    
    
    //getter and setter
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}
	public RiskAssessmentDTO getRiskAssessment() {
		return riskAssessment;
	}
	public void setRiskAssessment(RiskAssessmentDTO riskAssessment) {
		this.riskAssessment = riskAssessment;
	}
	public List<Map<String, Object>> getStatisticalFactors() {
		return statisticalFactors;
	}
	public void setStatisticalFactors(List<Map<String, Object>> statisticalFactors) {
		this.statisticalFactors = statisticalFactors;
	}
	public Map<String, Double> getRegressionCoefficients() {
		return regressionCoefficients;
	}
	public void setRegressionCoefficients(Map<String, Double> regressionCoefficients) {
		this.regressionCoefficients = regressionCoefficients;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public Map<String, Object> getAlternativeTerms() {
		return alternativeTerms;
	}
	public void setAlternativeTerms(Map<String, Object> alternativeTerms) {
		this.alternativeTerms = alternativeTerms;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

    
    
    
 
}
