package com.example.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Payment;

import com.example.utils.ValidationUtils;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;

@RestController
@RequestMapping("/api")
public class JsonController {
	
	
	@RequestMapping(value="/postJson",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<JsonNode> postJsonData(@RequestBody String request) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode  =mapper.readTree(request);
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("jsonSchema.json").getFile());
		JsonSchema schemaNode = ValidationUtils.getSchemaNode(file);
		ProcessingReport report = schemaNode.validate(jsonNode);
		
		
		if(!report.isSuccess()){
			Iterator<ProcessingMessage> sequence = report.iterator();
			String error=null;
	        while (sequence.hasNext()) {
	        	ProcessingMessage msg = sequence.next();
	        	error=msg.getMessage();		        	
	        }
	        throw new Exception("Schema Validation Failed. Invalid payment data due to "+error);
		}
		
		
		System.out.println("jsonNode "+jsonNode.toString());

		Payment payment = mapper.readValue(request, Payment.class);
		
		System.out.println("payment Object "+payment.toString());
		
		
	
		
		
		
		
		
		
		return new ResponseEntity<JsonNode>(jsonNode,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/health", method = RequestMethod.GET)
	 public @ResponseBody String health() {
		System.out.println("In Health");
		return "200 OK";
	}
	

}
