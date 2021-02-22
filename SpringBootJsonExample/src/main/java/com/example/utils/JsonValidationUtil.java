package com.example.utils;


import org.springframework.beans.factory.annotation.Autowired;


import com.example.config.CustomConfiguration;
//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.node.ObjectNode;



public class JsonValidationUtil {
	
	@Autowired

	CustomConfiguration config;
	
	
	public static JsonNode getStringValue(JsonNode node ,String property) {
		return node.has(property)?node.get(property):null;
		
	}
	
	public static JsonNode getIntValue(JsonNode node ,String property) {
		return node.has(property)?node.get(property):null;
		
		
	}
	
	public static boolean nullCheck(JsonNode node,String property) {
		if(!((node.get(property) == null || node.get(property).isNull()))) {
			
			System.out.println("Values are not null");
			return false;
		}
		return true;
	}
	
	
	public static boolean emptyCheckForInt(JsonNode node,String property) {
		
		if(!( node.get(property).asInt()==0)){
			
			System.out.println("int values are not empty");
			return false;
		}
			
		
		    return true;
	}
	
	
	public static boolean emptyCheckForString(JsonNode node,String property) {
		
		if(!( node.get(property).asText().isEmpty())){
			
			System.out.println("String values are not empty");
			return false;
		}
			
		
		    return true;
	}
	
	
	
	public static JsonNode getInt(JsonNode node, String property, int defaultValue) throws Exception  {
		      
		       
			  if(!node.has(property)==true||nullCheck(node,property)==true||emptyCheckForInt(node,property)==true) {
				
					return ((ObjectNode) node).put(property,defaultValue);
					
				  }
			  else {
				  return getIntValue(node,property);
			  }
				 
		 
			  
		}
	
	public  static JsonNode getString(JsonNode node, String property, String defaultValue) throws Exception  {
		
		 if(!node.has(property)==true||nullCheck(node,property)==true||emptyCheckForString(node,property)==true){
			 
				// System.out.println(((ObjectNode) node).put(property,defaultValue));
		
				return (((ObjectNode) node).put(property,defaultValue));
				 
			
			    
			  }
		 
		 else {
		
		 		return getStringValue(node,property);
		    
	
	}
	
}
}
