package com.example.Service;

import java.util.Map;
import java.util.TreeMap;

public class MissingAttributeException extends Exception{

	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;
	private final Map<String, Object> properties = new TreeMap<String, Object>();
	
	
	public static MissingAttributeException wrap(Throwable exception, ErrorCode errorCode) {
        if (exception instanceof MissingAttributeException) {
        	MissingAttributeException ex = (MissingAttributeException) exception;
            if (errorCode != null && errorCode != ex.getErrorCode()) {
                return new MissingAttributeException(exception.getMessage(), exception, errorCode);
            }
            return ex;
        } else {
            return new MissingAttributeException(exception.getMessage(), exception, errorCode);
        }
    }
	
	
	 public static MissingAttributeException wrap(Throwable exception) {
	        return wrap(exception, null);
	    }
	
	 public MissingAttributeException(ErrorCode errorCode) {
	        this.errorCode = errorCode;
	    }

	    public MissingAttributeException(String message, ErrorCode errorCode) {
	        super(message);
	        this.errorCode = errorCode;
	    }
	
	
	
	    public MissingAttributeException(Throwable cause, ErrorCode errorCode) {
	        super(cause);
	        this.errorCode = errorCode;
	    }

	 
	public MissingAttributeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public MissingAttributeException(String string, Throwable exception, ErrorCode errorCode) {
		errorCode = CustomizedExceptionCodes.MISSING_ATTRIBUTE;
	}
	
	 public ErrorCode getErrorCode() {
	        return errorCode;
	    }

	    public MissingAttributeException setErrorCode(ErrorCode errorCode) {
	        this.errorCode = errorCode;
	        return this;
	    }
	    
	    @SuppressWarnings("unchecked")
	    public <T> T get(String name) {
	        return (T) properties.get(name);
	    }

	    public MissingAttributeException set(String name, Object value) {
	        properties.put(name, value);
	        return this;
	    }


	



	
}
