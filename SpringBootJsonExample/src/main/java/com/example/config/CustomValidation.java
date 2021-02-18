package com.example.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.utils.JsonValidationUtil;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class CustomValidation {
	
	@Autowired
	CustomConfiguration configuration;
	
	public JsonNode transformData(JsonNode jsonNode) throws IOException, JsonProcessingException {
		
		     
				
				try {
					
					int payerId = JsonValidationUtil.getInt(jsonNode,configuration.getObject().get(0),123).asInt();
					System.out.println("payerId "+payerId);
					
					
					
					String payerName =JsonValidationUtil.getString(jsonNode,configuration.getObject().get(1),"abc").asText(); 
					System.out.println("payerName"+payerName);
					
					
					String paymentType =JsonValidationUtil.getString(jsonNode,configuration.getObject().get(2),"IPH").asText(); 
					System.out.println("paymentType"+paymentType);
					
					
					
					int payerAccountNumber = JsonValidationUtil.getInt(jsonNode,configuration.getObject().get(3),123456).asInt();
					System.out.println("payerAccountNumber"+payerAccountNumber);
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
					System.out.println("Exception Ocurred while processing");
				}
				
			
			     return jsonNode;
				
	}

}
