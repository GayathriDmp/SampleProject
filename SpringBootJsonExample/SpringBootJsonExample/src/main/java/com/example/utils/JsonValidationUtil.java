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
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonValidationUtil {
	
	
	public static boolean getJsonNode(JsonNode node ,String property) {
		if(node.has(property)) {
			return true;
		}
		return false;
		
	}
	
	
	
	public static int getIntValue(JsonNode node ,String property) { 
		return node.has(property)?node.get(property).asInt():0;
	 }
	
	public static String getStringValue(JsonNode node ,String property) { 
		return node.has(property)?node.get(property).asText():" ";
			 }
	 
	public static int ifEmptyString(String val) {
		if(val.equals(" ")||val.equals("")) {
			
			return 0;
		}
		
		return Integer.parseInt(val);
	}
	/*public static String stringToDate(String dateString) throws Exception {

		String localDate = LocalDate.parse(dateString).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return localDate;
    }*/
	
	public static String convertDate(JsonNode node ,String dateString) throws Exception {

         
		if(getJsonNode(node,dateString)==true) {
			String dateValue =node.get(dateString).asText();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(dateValue, formatter);
			return date.toString();
		}
		return null;
		
    }
	
	public static String convertZonedDateTime(JsonNode node , String dateProperty) throws DateTimeParseException {
		if(node.has(dateProperty)) {
			String date;
			
			ZonedDateTime dateTime = ZonedDateTime.parse(node.get(dateProperty).asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS").withZone(ZoneId.of("Europe/London")));
			System.out.println("dateTime "+dateTime);		
			//String lDt = dateTime.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));
			//System.out.println("lDt"+lDt);
			
			if(isDTSEnabled(dateTime.toLocalDateTime())) {
			date =  dateTime.plusHours(1).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));
			
			}
			else {
				date = dateTime.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));
			}
			return date;
		}
			return "";
		}
		
	
	
	public static boolean isDTSEnabled(LocalDateTime localDateTime) {
		ZonedDateTime dateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/London"));
		if(dateTime.getZone().getRules().isDaylightSavings(localDateTime.toInstant(dateTime.getOffset()))) {
			return true;
		}
	
		return false;
		
	}
	
	public static String getSysTime() {
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Europe/London"));
		return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS"));
		
	}
	
	public static String patternMatcher(JsonNode node , String property) {
		
		if(node.has(property)) {
		String value = node.get(property).asText();
		
		String regex = "\\d{4}-[01]\\d-[0-3]\\dT[0-2]\\d:[0-5]\\d:[0-5]\\d(?:\\.\\d+)Z";
		Pattern pattern = Pattern.compile(regex);
		if(!pattern.matcher(value).matches()) {
			
			return convertZonedDateTime(node,property);
		}
		
		 return convertISODate(node,property);
		
		}
		return "";
	
	}
	
	
	public static String getPaymentSubType(JsonNode node , String property) {
		
		if(node.has(property) && property.equals("PAYMNT_SUB_TYPE")){
			String key = node.get(property).asText();
			
			
			Map<String , String> hashmap = new HashMap<>();
			hashmap.put("10", "Single Immediate Payment");
			hashmap.put("20", "Return Payment");
			hashmap.put("25", "Scheme Return Payment");
			hashmap.put("30", "Standing Order");
			hashmap.put("40", "Forward Dated Single Payment");
			hashmap.put("50", "Corporate Bulk Payment");
		   // hashmap.forEach((k,v)->System.out.println(k+" "+v));
		    
		    return hashmap.get(key);
		    
		
		}
		return "";
		
		
	}
	
	public static String convertISODate(JsonNode node , String property) {
		if(node.has(property)) {
		String [] arr = node.get(property).asText().split("\\+");
		return   arr[0].replace("T", "-").replaceAll(":", ".");
		}
		return "";
}

	
public static String getsplPaymentType(JsonNode node , String property) {
		
		if(node.has(property) && property.equals("SPL_PAYMNT_TYPE")){
			String key = node.get(property).asText();
			
			
			Map<String , String> hashmap = new HashMap<>();
			hashmap.put("HO", "HOCA Payments");
			hashmap.put("AG", "Agency Payments");
			hashmap.put("SW", "Account Switched Paymrents");
			hashmap.put("RR", "Reversal");
			hashmap.put(" ", " ");
			
		  //  hashmap.forEach((k,v)->System.out.println(k+" "+v));
		    
		    return hashmap.get(key);
		    
		
		}
		return "";
		
		
	}
	
	
	public static JsonNode updateJsonForString(JsonNode node,String property,String updatedValue) {
		if(node.has(property)) {
			((ObjectNode) node).put(property,updatedValue);
		}
		return node;
		
	}
	
	public static JsonNode updateJsonForInt(JsonNode node,String property,int updatedValue) {
		if(node.has(property)) {
			((ObjectNode) node).put(property,updatedValue);
		}
		return node;
		
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
	
	
	public static String convertCurrency(JsonNode node,String property) {
		
				String value = getStringValue(node,property);
				switch(value) {
				case "826" :
					return "GBP";
					
				default:
					return "GBP";
				
				}
				
				
	}
	
	
	public static JsonNode getInt(JsonNode node, String property, int defaultValue) throws Exception  {
		      
		       
			  if(!node.has(property)==true||nullCheck(node,property)==true||emptyCheckForInt(node,property)==true) {
				
					return ((ObjectNode) node).put(property,defaultValue);
					
				  }
			  else {
				  return node.get(property);
			  }
				 
		 
			  
		}
	
	
	public  static JsonNode getString(JsonNode node, String property, String defaultValue) throws Exception  {
		
		 if(!node.has(property)==true||nullCheck(node,property)==true||emptyCheckForString(node,property)==true){
			 
				// System.out.println(((ObjectNode) node).put(property,defaultValue));
		
				return (((ObjectNode) node).put(property,defaultValue));
				 
			
			    
			  }
		 
		 else {
		
		 		return node.get(property);
		    
	
	}
	
}
	
	
	
	
	public static ArrayNode getArrayNode(JsonNode node , String property) {
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
	
	public static String ArrayNodeToString(JsonNode node , String property ,String delimiter) {
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
			//(String[]) strList.toArray(new String[strList.size()]);
		}
		return null;
	}
}
