package com.tornado.categorizePhoneNumbers.dto;

public enum State {

	VALID("valid"),
	NOT_VALID("Not Valid");
	
	String name;
	
	State(String name) {
		this.name = name;
	}
}
