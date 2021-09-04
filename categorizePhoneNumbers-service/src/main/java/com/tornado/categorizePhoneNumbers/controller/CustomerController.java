package com.tornado.categorizePhoneNumbers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tornado.categorizePhoneNumbers.dto.ResponcePhoneNumbers;
import com.tornado.categorizePhoneNumbers.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping(path = "/phoneNumbers", produces = "application/json")
	public ResponcePhoneNumbers GetAllPhoneNumbers(
				@RequestParam(defaultValue = "0") Integer page, 
				@RequestParam(defaultValue = "5") Integer size) {
		return customerService.GetAllPhoneNumbers(page,  size);
	}
	
}
