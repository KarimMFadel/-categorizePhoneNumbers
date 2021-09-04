package com.tornado.categorizePhoneNumbers.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tornado.categorizePhoneNumbers.dto.Country;
import com.tornado.categorizePhoneNumbers.dto.PhoneNumberDto;
import com.tornado.categorizePhoneNumbers.dto.ResponcePhoneNumbers;
import com.tornado.categorizePhoneNumbers.model.Customer;
import com.tornado.categorizePhoneNumbers.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public ResponcePhoneNumbers GetAllPhoneNumbers(int page, int size) {
		LOG.info("Retrieve the all customer information"); 
		Pageable paging = PageRequest.of(page, size, Sort.by("phone"));
		Page<Customer> pageResult = customerRepository.findAll(paging);
		
		return new ResponcePhoneNumbers(pageResult.getTotalPages(), 
					mapCustomersToPhoneNumberDto(pageResult.getContent()));
	}

	private List<PhoneNumberDto> mapCustomersToPhoneNumberDto(List<Customer> customers) {
		List<PhoneNumberDto> phoneNumberDtos = new ArrayList<>();
		List<Country>  Countries = Arrays.asList(Country.values());
		customers.forEach(customer->{
			String phoneNumber = customer.getPhone();
			String[] splited = phoneNumber.split("\\s+");
			String number = splited[1];
			Country country = Countries.stream()
				.filter(coun->coun.getCondition().test(splited[0]))
				.findAny().orElse(null);
			if(country == null)
				return ;
			PhoneNumberDto numberDto = new PhoneNumberDto(country.getCode(), country.getName(), number,
				country.getPattern().matcher(number).matches());
			
			phoneNumberDtos.add(numberDto);
		});
		return phoneNumberDtos;
	}

}
