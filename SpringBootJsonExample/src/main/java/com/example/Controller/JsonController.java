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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api")
public class JsonController {
	
	
	 @Autowired 
	 CustomValidation customValidation;
	
	
	
	@RequestMapping(value="/postJson",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<JsonNode> postJsonData(@RequestBody String request) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode  =mapper.readTree(request);
		
		//boolean state=JsonValidationUtil.isMandatoryFieldExists(jsonNode, constants.MANDATORY_PROPS_LIST);
		
		
		System.out.println("jsonNode "+jsonNode.toString());
		
		
		jsonNode = customValidation.transformData(jsonNode);

		System.out.println("jsonNode"+jsonNode);
		Payment payment = mapper.readValue(jsonNode.toString(),Payment.class);
		System.out.println("Payment"+payment);
		return new ResponseEntity<JsonNode>(jsonNode,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/health", method = RequestMethod.GET)
	 public @ResponseBody String health() {
		System.out.println("In Health");
		return "200 OK";
	}
	

}
