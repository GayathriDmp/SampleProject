package com.example.Service;


import java.util.Arrays;

public class CustomizedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String message;
	private Throwable throwable;
	private  StackTraceElement[] stacktraceElement;
	
	//
	
	public CustomizedException(String errorCode, String message, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.message = message;
		
	}


	public CustomizedException(String errorCode, String message, Throwable cause ,StackTraceElement[] stacktraceElement) {
		super(cause);
		this.errorCode = errorCode;
		this.message = message;
		
		this.stacktraceElement = stacktraceElement;
		
	}
    


	@Override
	public String toString() {
		return "CustomizedException [errorCode=" + errorCode + ", message=" + message + ", input=" + getCause()
				+ ", stacktraceElement=" + Arrays.toString(stacktraceElement) + "]";
				//Arrays.toString(stacktraceElement) 
	}
	
	
	
	
	
	

}
