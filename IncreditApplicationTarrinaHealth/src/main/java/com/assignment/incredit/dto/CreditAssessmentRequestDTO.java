package com.assignment.incredit.dto;

public class CreditAssessmentRequestDTO {
	
	private Long customerId;
    private double requestedCreditAmount;
    private int tenureMonths;
    private String purpose;
    
    
    
    //Getter abd Setter 
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
    
    

}
