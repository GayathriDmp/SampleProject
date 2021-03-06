package com.example.utils;

import com.fasterxml.jackson.databind.JsonNode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
		if(val.equals(" ")||val.trim().equals("")) {
			
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
	
	
	public String convertDateTime(JsonNode node , String dateProperty) throws DateTimeParseException {
		if(node.has(dateProperty)) {
			String date;
			LocalDateTime dateTime =  null;
			try {
			dateTime = LocalDateTime.parse(node.get(dateProperty).asText() ,DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));
			System.out.println("dateTime"+dateTime);
			}
			catch(DateTimeParseException ex) {
				try {
				dateTime =LocalDateTime.parse(node.get(dateProperty).asText());
				ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of("UTC"));
				System.out.println(zonedDateTime+"zonedDateTime");
				dateTime = zonedDateTime.toLocalDateTime();		
				System.out.println("dateTime"+dateTime);
				}
				catch(DateTimeParseException e) {
					date =convertISODate(node.get(dateProperty).asText());
					dateTime = LocalDateTime.parse(date ,DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));
					
				}
			}
			if(isDSTEnabled(dateTime)) {
				
			date =  dateTime.plusHours(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));;
			System.out.println(date);
			
			}
			else {
				
				date = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));
			}
			//dateTime.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));
			return date;
		}
			return "";
		}
		
		
		
	
	
	public static boolean isDSTEnabled(LocalDateTime localDateTime) {
		ZonedDateTime dateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/London"));
		//System.out.println("dateTimeDts"+dateTime);
		if(dateTime.getZone().getRules().isDaylightSavings(localDateTime.toInstant(dateTime.getOffset()))) {
			return true;
		}
	
		return false;
		
	}
	
	public  String getSysTime() {
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Europe/London"));
		System.out.println("localDateTimelocalDateTimelocalDateTime "+localDateTime);
		return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));

		
	}
	
	
	
	public  static String convertISODate(String property) {
		
		String [] arr = property.split("\\+");
		
		System.out.println("splitted value"+arr[0].replace("T", "-").replaceAll(":", "."));
		return   arr[0].replace("T", "-").replaceAll(":", ".").replace("Z", " ");
		
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
	
	
	public boolean isEmpty(JsonNode node , String property) {
		if(!(StringUtils.containsWhitespace(node.get(property).asText()))) {
			return true;
		}
		return false;
		
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
	
public  boolean getsplPaymentType(String value) {
		
		/*if(node.has(property) && property.equals("SPL_PAYMNT_TYPE")){
			String key = node.get(property).asText();*/
			
			
			Map<String , String> hashmap = new HashMap<>();
			hashmap.put("HO", "HOCA Payments");
			hashmap.put("AG", "Agency Payments");
			hashmap.put("SW", "Account Switched Paymrents");
			hashmap.put("RR", "Reversal");
			
			
		  //  hashmap.forEach((k,v)->System.out.println(k+" "+v));
		    
		    return hashmap.containsKey(value);
		    
		
		}
		
		
		
	

public  boolean getPaymentSubType(String value) {
	
	/*if(node.has(property) && property.equals("PAYMNT_SUB_TYPE")){
		String key = node.get(property).asText();*/
		
		
		Map<String , String> hashmap = new HashMap<>();
		hashmap.put("10", "Single Immediate Payment");
		hashmap.put("20", "Return Payment");
		hashmap.put("25", "Scheme Return Payment");
		hashmap.put("30", "Standing Order");
		hashmap.put("40", "Forward Dated Single Payment");
		hashmap.put("50", "Corporate Bulk Payment");
		
	   // hashmap.forEach((k,v)->System.out.println(k+" "+v));
	    //hashmap.get(key)
	    return hashmap.containsKey(value);
	    
	
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



	public JsonNode getDouble(JsonNode node, String property) {
		
		return node.get(property);
		// TODO Auto-generated method stub
		
	}
}

