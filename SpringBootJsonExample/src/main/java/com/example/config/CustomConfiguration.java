package com.example.config;



//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;

@Configuration

//@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix="app")
public class CustomConfiguration {
	private String colour;
	private String lang;
    private String theme;
    private List<String> object ;
    public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public List<String> getObject() {
		return object;
	}
	public void setObject(List<String> object) {
		this.object = object;
	}
	
    
    

	

}
