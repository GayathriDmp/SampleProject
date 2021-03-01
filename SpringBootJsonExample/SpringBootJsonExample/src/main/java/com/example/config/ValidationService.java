package com.example.config;


import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Service.CustomizedException;
import com.example.Service.CustomizedExceptionCodes;
import com.example.utils.JsonValidationUtil;
import com.fasterxml.jackson.databind.JsonNode;
@Component
public class ValidationService {
	
	@Autowired
	CustomConfiguration config;
	
	@Autowired
	JsonValidationUtil util;
	
	
	public  JsonNode iterateJson(JsonNode requestObject) throws Exception ,CustomizedException{
		
			checkMandatoryFields(requestObject);
			
			Iterator<String> fields = requestObject.fieldNames();
			while(fields.hasNext()) {
			String field = fields.next();
			
			if(field.equals(config.getObject().get(2))) {
				String requestValue = requestObject.get(field).asText();
				if(!requestValue.equals(" ")) {
					//String dateTime =util.patternMatcher(requestObject, field);
					String dateTime = util.convertDateTime(requestObject, field);
					util.updateJsonForString(requestObject, field, dateTime);
				}
				else {
					throw new CustomizedException(CustomizedExceptionCodes.DATETIME_PARSE_EXCEPTION_CODE.getId(),CustomizedExceptionCodes.DATETIME_PARSE_EXCEPTION_CODE.getName()+"for "+field,null,Thread.currentThread().getStackTrace());
				}
			}
			
			
			if(field.equals("PAYMNT_SUB_TYPE")) {
				System.out.println(field+"is there");
				String value =requestObject.get(field).asText();
				 if(value.isEmpty()) {
					 
					 util.getString(requestObject, field, "!");
				 }
				else if(util.getPaymentSubType(value)==true){
							System.out.println(requestObject.get(field).asText()+"value ");
					 util.getString(requestObject, field, value);
						}
					
							
					
				
						else {
							throw new CustomizedException(CustomizedExceptionCodes.VALUE_IS_NOT_VALID.getId() , CustomizedExceptionCodes.VALUE_IS_NOT_VALID.getName()+"for "+field , null);
						}
			}
			
			if(field.equals("SPL_PAYMNT_TYPE")) {
				String value =requestObject.get(field).asText().trim();
				System.out.println(value+"valuevaluevalue");
				System.out.println(util.getsplPaymentType(value));
				if(value.isEmpty()){
					util.getString(requestObject, field, "!");
				}
				
				else if(util.getsplPaymentType(value)==true){
							
					         util.getString(requestObject, field, value);
							System.out.println("splpaymenttype "+util.getString(requestObject, field, value).asText());
					
				}
						
						else {
							throw new CustomizedException(CustomizedExceptionCodes.VALUE_IS_NOT_VALID.getId() , CustomizedExceptionCodes.VALUE_IS_NOT_VALID.getName()+"for "+field , null);
						}
			
			}
			
			if(field.equals("PAYMNT_AMOUNT")||field.equals("ORIG_AMOUNT")) {
				JsonNode value = requestObject.get(field);
				if(value==null||value.asText().equals(" ")) {
					throw new CustomizedException(CustomizedExceptionCodes.VALUE_IS_NULL_EXCEPTION_CODE.getId(),CustomizedExceptionCodes.VALUE_IS_NULL_EXCEPTION_CODE.getName(),null,Thread.currentThread().getStackTrace());
				}
				else {
				util.getDouble(requestObject, field);
			}
			
		 
			}
			
			if(field.equals("PAYMNT_CURRENCY"))
							 {
				String value =util.convertCurrency(requestObject, field);
				System.out.println("currencycurrency"+value);
				util.updateJsonForString(requestObject, field, value);
			}
			
		
		
		}
			return requestObject;
	
	}
	
	public JsonNode checkMandatoryFields(JsonNode jsonNode) throws CustomizedException {
		for(String key:config.getObject())
			if(!jsonNode.has(key)||StringUtils.isBlank(jsonNode.get(key).asText())) {
		throw new CustomizedException(CustomizedExceptionCodes.MISSING_ATTRIBUTE_EXCEPTION_CODE.getId(),CustomizedExceptionCodes.MISSING_ATTRIBUTE_EXCEPTION_CODE.getName()+"for "+key,null, Thread.currentThread().getStackTrace());
			}
		return jsonNode;
		
		
	}
}
