package com.assignment.incredit.dto;

public class RiskAssessmentDTO {
	
	private boolean willPayOnTime;
    private int riskScore;
    private String riskCategory;
    private double confidence;
    
    
    
	public boolean isWillPayOnTime() {
		return willPayOnTime;
	}
	public void setWillPayOnTime(boolean willPayOnTime) {
		this.willPayOnTime = willPayOnTime;
	}
	public int getRiskScore() {
		return riskScore;
	}
	public void setRiskScore(int riskScore) {
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


}
