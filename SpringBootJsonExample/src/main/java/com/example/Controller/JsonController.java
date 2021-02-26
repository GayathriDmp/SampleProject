package com.example.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Payment;
import com.example.Service.CustomizedException;
import com.example.config.ValidationService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api")
public class JsonController {
	 
	 
	 @Autowired
	 ValidationService validationService;
	
	@Autowired 
	ObjectMapper mapper;

	
	@RequestMapping(value="/postJson",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<JsonNode> postJsonData(@RequestBody String request) throws Exception {
		
		
		JsonNode jsonNode  =mapper.readTree(request);
		//logger.info("Received jsonNode from request");
		
		//LoggerUtil.log(Level.getLevel("IPHDELIMITED"), " ",request,jsonNode.toString());
	
		//logger.info("validating the input josn ");
		
			jsonNode = validationService.iterateJson(jsonNode);	
		
		System.out.println("jsonNode "+jsonNode);
		
		
		
		 
	    //Payment payment = mapper.readValue(jsonNode.toString(),Payment.class);
	    //System.out.println("Payment"+payment);
	      
	   //   String newNode = mapper.writeValueAsString(payment);
	   // System.out.println("pojoToJson"+newNode);
		
		return new ResponseEntity<JsonNode>(jsonNode,HttpStatus.OK);
			
		
	}
	
	@RequestMapping(value="/health", method = RequestMethod.GET)
	 public @ResponseBody String health() {
		System.out.println("In Health");
		return "200 OK";
	}
	

}
