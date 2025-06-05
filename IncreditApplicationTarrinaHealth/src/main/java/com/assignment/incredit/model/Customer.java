package com.assignment.incredit.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
	
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String city;
	    private String state;
	    private int age;
	    
	    @JsonProperty("employment_status")
	    private String employmentStatus;
	    
	    @JsonProperty("approx_annual_income_inr")
	    private double approxAnnualIncomeInr;
	    
	    @JsonProperty("registration_date")
	    private LocalDate registrationDate;

	    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Order> orders;

	    @JsonProperty("target_will_pay_on_time_next_credit")
	    private Boolean targetWillPayOnTimeNextCredit;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getEmploymentStatus() {
			return employmentStatus;
		}

		public void setEmploymentStatus(String employmentStatus) {
			this.employmentStatus = employmentStatus;
		}

		public double getApproxAnnualIncomeInr() {
			return approxAnnualIncomeInr;
		}

		public void setApproxAnnualIncomeInr(double approxAnnualIncomeInr) {
			this.approxAnnualIncomeInr = approxAnnualIncomeInr;
		}

		public LocalDate getRegistrationDate() {
			return registrationDate;
		}

		public void setRegistrationDate(LocalDate registrationDate) {
			this.registrationDate = registrationDate;
		}

		public List<Order> getOrders() {
			return orders;
		}

		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}

		public Boolean getTargetWillPayOnTimeNextCredit() {
			return targetWillPayOnTimeNextCredit;
		}

		public void setTargetWillPayOnTimeNextCredit(Boolean targetWillPayOnTimeNextCredit) {
			this.targetWillPayOnTimeNextCredit = targetWillPayOnTimeNextCredit;
		}
    
	    
	    
}
