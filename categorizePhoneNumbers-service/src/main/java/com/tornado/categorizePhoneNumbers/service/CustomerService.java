package com.tornado.categorizePhoneNumbers.service;

import com.tornado.categorizePhoneNumbers.dto.ResponcePhoneNumbers;

public interface CustomerService {

	ResponcePhoneNumbers GetAllPhoneNumbers(int page, int size);
}
