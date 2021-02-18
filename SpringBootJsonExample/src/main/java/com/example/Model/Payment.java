package com.example.Model;



import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment {
	
	@JsonProperty("payer_id")
	
	private Integer payerId;
	
	private String payerName;
	private String payment_type ;
	private Integer payerAccountNumber;
	
	public Integer getPayerId() {
		return payerId;
	}
	
	public void setPayerId(Integer payerId) {
		
		this.payerId = payerId;
		
	}
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public Integer getPayerAccountNumber() {
		return payerAccountNumber;
	}
	public void setPayerAccountNumber(Integer payerAccountNumber) {
		this.payerAccountNumber = payerAccountNumber;
	}
	
	public String toString() {
		return "payerId: "+payerId+" payerName: "+payerName+" paymentType: "+payment_type+" payerAccountNumber: "+payerAccountNumber;
	}
	
	
	
}
