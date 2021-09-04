package com.tornado.categorizePhoneNumbers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberDto {

	String number;
	String countryName;
	State state;
	String countryCode;

	public PhoneNumberDto(String countryCode, String countryName, String number, boolean valid) {
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.number = number;
		this.state = calculateState(valid);
	}
	
	public State calculateState(boolean valid) {
		return valid ? State.VALID : State.NOT_VALID;
	}
}
