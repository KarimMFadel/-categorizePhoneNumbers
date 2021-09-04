package com.tornado.categorizePhoneNumbers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tornado.categorizePhoneNumbers.model.Customer;
import com.tornado.categorizePhoneNumbers.repository.CustomerRepository;
import com.tornado.categorizePhoneNumbers.service.CustomerService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
class CategorizePhoneNumbersServiceApplicationTests {

	@Autowired
	CustomerService customerService;

	@MockBean
	CustomerRepository customerRepository;
	
	static Customer c1 , c2 , c3;
	

	@BeforeAll
	public static void setup() {
		c1 = new Customer(0L,"Walid Hammadi","(212) 6007989253"); 
		c2 = new Customer(1L,"Yosaf Karrouch","(212) 698054317"); 
		c3 = new Customer(2L,"Younes Boutikyad","(212) 6546545369"); 
	}


	@Test
	void returnListOfPhoneNumbers() {
		List<Customer> customers = new ArrayList<>(Arrays.asList(c1,c2,c3));
		Pageable paging = PageRequest.of(0, 2, Sort.by("phone"));
		when(customerRepository.findAll(paging)).thenReturn(new PageImpl<>(customers));
		assertTrue(customerService.GetAllPhoneNumbers(0,2).getPhoneNumbers().size()>0);
	}
	

}
