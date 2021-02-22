package com.example.config;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.utils.JsonValidationUtil;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class CustomValidation1 {
	
	@Autowired
	CustomConfiguration configuration;
	
	public JsonNode transformData(JsonNode jsonNode) throws IOException, JsonProcessingException {
		
		try {
					
		JsonValidationUtil.getString(jsonNode,configuration.getObject().get(0),"IFP").asText();
		
		JsonValidationUtil.getString(jsonNode,"PAYMNT_AMOUNT","0.00").asDouble();
		
					
		/*String splPaymentType = JsonValidationUtil.getsplPaymentType(jsonNode, "SPL_PAYMNT_TYPE");
		if(splPaymentType.isEmpty()) {
			JsonValidationUtil.getString(jsonNode,"SPL_PAYMENT_TYPE"," ");
		}
		else {
			JsonValidationUtil.updateJsonForString(jsonNode, "SPL_PAYMENT_TYPE", splPaymentType);
		}*/
		
		JsonValidationUtil.getString(jsonNode, "SPL_PAYMENT_TYPE", " ").asText() ;
		
					
		String processCodeValue = JsonValidationUtil.getStringValue(jsonNode,"PROCESS_CODE");
		int processCode =JsonValidationUtil.ifEmptyString(processCodeValue);
		JsonValidationUtil.updateJsonForInt(jsonNode, "PROCESS_CODE", processCode);
		
		
			
		//String paymentCurrency =JsonValidationUtil.convertCurrency(jsonNode, "PAYMNT_CURRENCY");
		//JsonValidationUtil.updateJsonForString(jsonNode, "PAYMNT_CURRENCY", paymentCurrency);
		
		JsonValidationUtil.getString(jsonNode, "PAYMNT_CURRENCY","826");
		
		
		
					
		
		/*String paymentSubType=JsonValidationUtil.getPaymentSubType(jsonNode, "PAYMNT_SUB_TYPE");
		if(JsonValidationUtil.getStringValue(jsonNode , "PAYMNT_SUB_TYPE").equals(" ")) {
			
			JsonValidationUtil.getString(jsonNode, "PAYMNT_SUB_TYPE"," ");
			
			
		}
		else {
			JsonValidationUtil.updateJsonForString(jsonNode, "PAYMNT_SUB_TYPE",paymentSubType);
		}*/
					
		JsonValidationUtil.getString(jsonNode, "PAYMNT_SUB_TYPE"," ");
					
		String paymentSentDate = JsonValidationUtil.convertDate(jsonNode, "PAYMNT_SENT_DATE");
		if(paymentSentDate.isEmpty()) {
			JsonValidationUtil.getString(jsonNode, "PAYMNT_SENT_DATE",LocalDate.now().toString());
		}
		else {
			JsonValidationUtil.updateJsonForString(jsonNode, "SETTLMNT_DATE", paymentSentDate);
		}
			
		
					
		String settlementDate = JsonValidationUtil.convertDate(jsonNode, "SETTLMNT_DATE");
		if(settlementDate.isEmpty()) {
		JsonValidationUtil.getString(jsonNode, "SETTLMNT_DATE", LocalDate.now().toString());
		}
		else {
			JsonValidationUtil.updateJsonForString(jsonNode, "SETTLMNT_DATE", settlementDate);
		}
		
					
		String settlementCycleValue = JsonValidationUtil.getStringValue(jsonNode,"SETTLMNT_CYCLE_ID");
		int settlementCycleId =JsonValidationUtil.ifEmptyString(settlementCycleValue);
		
		JsonValidationUtil.updateJsonForInt(jsonNode, "SETTLMNT_CYCLE_ID", settlementCycleId);
		
		JsonValidationUtil.getString(jsonNode,"BRAND","RBS").asText();
		
		//String  paymentTimestamp = JsonValidationUtil.patternMatcher(jsonNode, "PAYMNT_TIMESTMP");
		//if(paymentTimestamp.isEmpty()) {
			//JsonValidationUtil.getString(jsonNode, "PAYMNT_TIMESTMP", JsonValidationUtil.getSysTime());
		//}
		//else {
		//JsonValidationUtil.updateJsonForString(jsonNode, "PAYMNT_TIMESTMP", paymentTimestamp);
		//}
		
		//System.out.println("paymentTimestamp"+paymentTimestamp);				
		
		String payerAcctAddress = JsonValidationUtil.getString(jsonNode, "PAYER_ACCT_ADDRESS", " ").asText();
		JsonValidationUtil.updateJsonForString(jsonNode, "PAYER_ACCT_ADDRESS", payerAcctAddress);
					
		String pmtRetnCode = JsonValidationUtil.getString(jsonNode, "PMT_RETN_CODE", " ").asText();
		JsonValidationUtil.updateJsonForString(jsonNode, "PMT_RETN_CODE", pmtRetnCode);
					
		String tenantId = JsonValidationUtil.getString(jsonNode,configuration.getObject().get(3),"P").asText();
		System.out.println("tenantId"+tenantId);
					
		String aricMode = JsonValidationUtil.getString(jsonNode,configuration.getObject().get(4),"S").asText();
		System.out.println("aricMode"+aricMode);
					
		} 
		catch (Exception e) {
										
					e.printStackTrace();
					System.out.println("Exception Ocurred while processing");
				}
				
			
			     return jsonNode;
				
	}

}
