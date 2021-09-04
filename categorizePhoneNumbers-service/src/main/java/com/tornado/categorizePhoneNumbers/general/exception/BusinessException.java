package com.tornado.categorizePhoneNumbers.general.exception;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 1969442617900358857L;
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(String message) {
		super(message);
	}
}
