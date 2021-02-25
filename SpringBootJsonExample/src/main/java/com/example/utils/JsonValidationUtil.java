package com.example.utils;

import com.fasterxml.jackson.databind.JsonNode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
@Component
public class JsonValidationUtil {
	
	
	public  boolean getJsonNode(JsonNode node ,String property) {
		if(node.has(property)) {
			return true;
		}
		return false;
		
	}
	
	
	
	public  int getIntValue(JsonNode node ,String property) { 
		return node.has(property)?node.get(property).asInt():0;
	 }
	
	public  String getStringValue(JsonNode node ,String property) { 
		return node.has(property)?node.get(property).asText():" ";
			 }
	 
	public  int ifEmptyString(String val) {
		if(val.equals(" ")||val.equals("")) {
			
			return 0;
		}
		
		return Integer.parseInt(val);
	}
	
	public  String convertDate(JsonNode node ,String dateString) throws Exception {

		if(getJsonNode(node,dateString)==true) {
			String dateValue =node.get(dateString).asText();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate date = LocalDate.parse(dateValue, formatter);
			return date.toString();
		}
		return null;
		
    }
	
	public String convertZonedDateTime(JsonNode node , String dateProperty) throws DateTimeParseException {
		if(node.has(dateProperty)) {
			String date;
			
			ZonedDateTime dateTime = ZonedDateTime.parse(node.get(dateProperty).asText());
			
			
					
			
			
			if(isDTSEnabled(dateTime.toLocalDateTime())) {
				
			date =  dateTime.plusHours(1).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));
			System.out.println(date);
			
			}
			else {
				
				date = dateTime.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));
			}
			return date;
		}
			return "";
		}
		
	
	
	public boolean isDTSEnabled(LocalDateTime localDateTime) {
		ZonedDateTime dateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/London"));
		if(dateTime.getZone().getRules().isDaylightSavings(localDateTime.toInstant(dateTime.getOffset()))) {
			return true;
		}
	
		return false;
		
	}
	
	public  static String getSysTime() {
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Europe/London"));
		System.out.println("localDateTimelocalDateTimelocalDateTime "+localDateTime);
		return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));

		
	}
	
	public String patternMatcher(JsonNode node , String property) {
		String value;
		if(node.has(property)) {
		value = node.get(property).asText();
		System.out.println("value"+value);
				
			if(value.contains("T")&&value.endsWith("Z")) {
			System.out.println("contains T");
			
			return convertZonedDateTime(node,property);
			
	}
		else if(value.contains("T")){
		
			return convertISODate(node,property);
		
		}
		else {
		
		return value;
	
	}
		}
		return "";
		
	}
	
	
	
	public  static String convertISODate(JsonNode node ,String property) {
		if(node.has(property)) {
			System.out.println("date value here");
		String [] arr = node.get(property).asText().split("\\+");
		
		System.out.println("splitted value"+arr[0].replace("T", "-").replaceAll(":", "."));
		return   arr[0].replace("T", "-").replaceAll(":", ".");
		}
		else {
			return "";
		}
		
		
}

	

	
	public  JsonNode updateJsonForString(JsonNode node,String property,String updatedValue) {
		if(node.has(property)) {
			((ObjectNode) node).put(property,updatedValue);
		}
		return node;
		
	}
	
	public  JsonNode updateJsonForInt(JsonNode node,String property,int updatedValue) {
		if(node.has(property)) {
			((ObjectNode) node).put(property,updatedValue);
		}
		return node;
		
	}
	
	public  boolean nullCheck(JsonNode node,String property) {
		if(node.get(property) != null ||!node.get(property).isNull()) {
			
			
			return false;
		}
		return true;
	}
	
	
	public  boolean emptyCheckForInt(JsonNode node,String property) {
		
		if(!( node.get(property).asInt()==0)){
			
			
			return false;
		}
			
		
		    return true;
	}
	
	
	public  boolean emptyCheckForString(JsonNode node,String property) {
		
		if(!node.get(property).asText().equals(" ")||!node.get(property).isEmpty()){
			
			
			return false;
		}
			
		
		    return true;
	}
	
	
	public  String convertCurrency(JsonNode node,String property) {
		
				String value = getStringValue(node,property);
				switch(value) {
				case "826" :
					return "GBP";
					
				default:
					return "GBP";
				
				}
				
				
	}
	
	
	public  JsonNode getInt(JsonNode node, String property, int defaultValue) throws Exception  {
		      
		       
			  if(!node.has(property)==true||nullCheck(node,property)==true||emptyCheckForInt(node,property)==true) {
				
					return ((ObjectNode) node).put(property,defaultValue);
					
				  }
			  else {
				  return node.get(property);
			  }
				 
		 
			  
		}
	
	
	public JsonNode getString(JsonNode node, String property, String defaultValue) throws Exception  {
		
		 if(!node.has(property)==true||nullCheck(node,property)==true||emptyCheckForString(node,property)==true){
			 
	
		
				return (((ObjectNode) node).put(property,defaultValue));
				 
			
			    
			  }
		 
		 else {
		
		 		return node.get(property);
		    
	
	}
	
}
	
	
	
	
	public  ArrayNode getArrayNode(JsonNode node , String property) {
		 if(node.isArray()) {
			 for(JsonNode objNode : node) {
				 System.out.println(objNode);
				 }
			 return (ArrayNode) node;
		 }
		
		return null;
		
	}
	
	public boolean isEmptyStringArray(String [] array){
		
		 for(int i=0; i<array.length; i++){ 
		  if(array[i]!=null){
		   return false;
		  }
		  }
		  return true;
		}
	
	public  String ArrayNodeToString(JsonNode node , String property ,String delimiter) {
		String values="";
		List<String> strList = new LinkedList<String>();
		if(node.has(property)) {
			ArrayNode array = (ArrayNode)node.get(property);
			
			if(!array.isEmpty()) {
				array.forEach(result -> {strList.add(result.asText());
			});
				values = String.join(delimiter, strList);
		}
			return values;
			
		}
		return null;
	}
}

