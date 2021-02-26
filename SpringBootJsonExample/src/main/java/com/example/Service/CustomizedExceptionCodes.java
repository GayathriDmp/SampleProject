package com.example.Service;

public enum CustomizedExceptionCodes implements ErrorCode {
	
	//MISSING_ATTRIBUTE(301),
	DATETIME_PARSE_EXCEPTION_CODE("IPH_101" , "Missing attribute");
	
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
