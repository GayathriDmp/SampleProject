package com.example.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Payment {
	
	
	@JsonProperty("payer_id")
	private Integer payerId;
	
	private String payerName;
	private String payment_type ;
	private int payerAccountNumber;
	
	
	public Integer getPayerId() {
		return payerId;
	}
	@JsonSetter("payer_id")  ///if payer_id is null , set to default , Integer data type for the reason of accepting null
	public void setPayerId(Integer payerId) {
		if(payerId==null ) {
			this.payerId = 10;
		}
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
	public int getPayerAccountNumber() {
		return payerAccountNumber;
	}
	public void setPayerAccountNumber(int payerAccountNumber) {
		this.payerAccountNumber = payerAccountNumber;
	}
	

	public String toString() {
		return "payerId: "+payerId+"payerName: "+payerName+"paymentType: "+payment_type+"payerAccountNumber: "+payerAccountNumber;
	}
}
