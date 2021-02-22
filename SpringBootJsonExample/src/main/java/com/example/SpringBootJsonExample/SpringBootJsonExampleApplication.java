package com.example.SpringBootJsonExample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.config.CustomConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;



@SpringBootApplication(scanBasePackages= {"com.example"})
public class SpringBootJsonExampleApplication implements CommandLineRunner{
	
	@Autowired
	CustomConfiguration config;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJsonExampleApplication.class, args);
		
	}
	
	
		@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		config.getObject().forEach(System.out::println);
		//System.out.println("dateformat"+JsonValidationUtil.convertDateTime("2018-07-01T22:00:00.4567Z"));
		//System.out.println("date-validation"+JsonValidationUtil.convertISODate("2018-07-01T22:00:00.4567Z"));
		System.out.println(config.getObject().get(2));
		
		
		
	}

	

}
