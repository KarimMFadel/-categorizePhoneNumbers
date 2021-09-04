package com.tornado.categorizePhoneNumbers.dto;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import lombok.Getter;

public enum Country {

	Cameroon("Cameroon", "237", countryCode->countryCode.contains("237"), Pattern.compile("[2368]\\d{7,8}$") ),
	Ethiopia("Ethiopia", "251", countryCode->countryCode.contains("251"), Pattern.compile("[1-59]\\d{8}$") ),
	Morocco("Morocco", "212", countryCode->countryCode.contains("212"), Pattern.compile("[5-9]\\d{8}$") ),
	Mozambique("Mozambique", "258", countryCode->countryCode.contains("258"), Pattern.compile("[28]\\d{7,8}$") ),
	Uganda("Uganda", "256", countryCode->countryCode.contains("256"), Pattern.compile("\\d{9}$") );
	
    @Getter
	private String name;
    @Getter
    private String code;
    @Getter
	private Predicate<String> condition;
    @Getter
	private Pattern pattern;
	
	Country(String name, String code, Predicate<String> condition, Pattern pattern) {
		this.name = name;
        this.code = code;
		this.condition = condition;
		this.pattern = pattern;
	}
	
}
