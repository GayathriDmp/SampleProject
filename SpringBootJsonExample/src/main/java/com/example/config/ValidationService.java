package com.example.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.utils.JsonValidationUtil;
import com.fasterxml.jackson.databind.JsonNode;
@Component
public class ValidationService {
	
	@Autowired
	CustomConfiguration config;
	
	@Autowired
	JsonValidationUtil util;
	
	
	public  JsonNode iterateJson(JsonNode requestObject) throws Exception{
		
		
		
		for(String key:config.getObject()) {
			JsonNode node = requestObject.get(key);
			if(!requestObject.has(key)||node.equals(null)||(node.asText().equals(" "))){
				util.getString(requestObject, config.getObject().get(0), "IPH");
				util.getString(requestObject, config.getObject().get(1), " ");
				String paymentTimestamp =util.getStringValue(requestObject,  config.getObject().get(2));
				if(paymentTimestamp.equals(" ")){
					
					util.updateJsonForString(requestObject, config.getObject().get(2), " ");
									}
				else {
					
					paymentTimestamp = util.patternMatcher(requestObject, config.getObject().get(2));
					util.updateJsonForString(requestObject, config.getObject().get(2), paymentTimestamp);
				}
					
				util.getString(requestObject, config.getObject().get(3), "P");
				util.getString(requestObject, config.getObject().get(4), "S");
				
			}
		}
		return requestObject;
		
			}
}
