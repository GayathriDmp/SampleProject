package com.example.Service;

public enum CustomizedExceptionCodes implements ErrorCode {
	
	//MISSING_ATTRIBUTE(301),
	DATETIME_PARSE_EXCEPTION_CODE("IPH_101" , "exception occurred while parsing DateTime"),
	MISSING_ATTRIBUTE_EXCEPTION_CODE("IPH_102" , "Missing required attribute"),
	VALUE_IS_NOT_VALID("IPH_103", "value is not valid"),
	VALUE_IS_NULL_EXCEPTION_CODE("IPH_104","value should not be null");
	
	private final String id;
	private final String name;
	
	

	private CustomizedExceptionCodes(String id , String name) {
	        this.id = id;
	        this.name = name;
	    }
	
	 public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		

}