package com.infogain.debonair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.debonair.repository.RegularAndCorporateCustomer;

/**
 * This class is service class to handle business logic involving customer
 * details manipulation
 * 
 * @author Chetna
 * @since 04-May-2020
 */
@Service
public class CustomerService {

	@Autowired
	RegularAndCorporateCustomer customerRepository;

	/**
	 * This method to get customer type from the repository and return it to
	 * controller
	 * 
	 * @param customerId Customer Id
	 * @return Type of customer i.e., 'CORPORATE' or 'REGULAR'
	 * @since 04-May-2020
	 */
	public String checkCustomerType(String customerId) {
		return customerRepository.getCustomerType(customerId);
	}

}
