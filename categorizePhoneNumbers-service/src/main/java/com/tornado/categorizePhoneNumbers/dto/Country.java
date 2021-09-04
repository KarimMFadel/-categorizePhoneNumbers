package com.tornado.categorizePhoneNumbers.dto;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public enum Country {

	Cameroon("Cameroon", "237", countryCode->countryCode.contains("237"), Pattern.compile("[2368]\\d{7,8}$") ),
	Ethiopia("Ethiopia", "251", countryCode->countryCode.contains("251"), Pattern.compile("[1-59]\\d{8}$") ),
	Morocco("Morocco", "212", countryCode->countryCode.contains("212"), Pattern.compile("[5-9]\\d{8}$") ),
	Mozambique("Mozambique", "258", countryCode->countryCode.contains("258"), Pattern.compile("[28]\\d{7,8}$") ),
	Uganda("Uganda", "256", countryCode->countryCode.contains("256"), Pattern.compile("\\d{9}$") );
	
	private String name;
    private String code;
	private Predicate<String> condition;
	private Pattern pattern;
	
	Country(String name, String code, Predicate<String> condition, Pattern pattern) {
		this.name = name;
        this.code = code;
		this.condition = condition;
		this.pattern = pattern;
	}
	
    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the condition
     */
    public Predicate<String> getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(Predicate<String> condition) {
        this.condition = condition;
    }

    /**
     * @return Pattern return the pattern
     */
    public Pattern getPattern() {
        return pattern;
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    /**
     * @return String return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

}
