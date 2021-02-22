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
import com.example.config.CustomValidation;
import com.example.utils.JsonValidationUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api")
public class JsonController {
	
	
	 @Autowired 
	 CustomValidation customValidation;
	
	@Autowired ObjectMapper mapper;
	
	@RequestMapping(value="/postJson",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<JsonNode> postJsonData(@RequestBody String request) throws Exception {
		
		JsonNode jsonNode  =mapper.readTree(request);
	
		jsonNode = customValidation.transformData(jsonNode);
		

	      Payment payment = mapper.readValue(jsonNode.toString(),Payment.class);
	      System.out.println("Payment"+payment);
	      
	      String newNode = mapper.writeValueAsString(payment);
	    System.out.println("pojoToJson"+newNode);
		
		return new ResponseEntity<JsonNode>(jsonNode,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/health", method = RequestMethod.GET)
	 public @ResponseBody String health() {
		System.out.println("In Health");
		return "200 OK";
	}
	

}
