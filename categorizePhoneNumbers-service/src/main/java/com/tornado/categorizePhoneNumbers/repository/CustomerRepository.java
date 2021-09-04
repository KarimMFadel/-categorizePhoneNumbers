package com.tornado.categorizePhoneNumbers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.tornado.categorizePhoneNumbers.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("SELECT c.phone FROM Customer c ")
	List<String> findAllPhoneNumbers();
}
