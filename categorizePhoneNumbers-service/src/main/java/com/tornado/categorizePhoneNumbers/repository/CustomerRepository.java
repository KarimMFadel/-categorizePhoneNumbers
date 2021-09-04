package com.tornado.categorizePhoneNumbers.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tornado.categorizePhoneNumbers.model.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
