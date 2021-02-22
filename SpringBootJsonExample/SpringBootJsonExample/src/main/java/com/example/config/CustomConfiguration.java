package com.example.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration


@ConfigurationProperties(prefix="app.default")
public class CustomConfiguration {
	
    @Value("${app.default.attributes}")
    private List<String> object ;
   
	public List<String> getObject() {
		return object;
	}
	
	public void setObject(List<String> object) {
		this.object = object;
	}

	
	
}
