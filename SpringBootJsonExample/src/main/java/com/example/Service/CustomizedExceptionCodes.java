package com.example.Service;

public enum CustomizedExceptionCodes implements ErrorCode {
	
	MISSING_ATTRIBUTE(301),
	DATE_FORMAT_INVALID(302);
	
	private final int number;
	
	 private CustomizedExceptionCodes(int number) {
	        this.number = number;
	    }
	
	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return number;
	}

}
