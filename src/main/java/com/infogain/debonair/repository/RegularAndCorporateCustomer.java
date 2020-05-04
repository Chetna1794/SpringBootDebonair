package com.infogain.debonair.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infogain.debonair.constants.Constants;
import com.infogain.debonair.model.CorporateCustomer;
import com.infogain.debonair.model.Customer;
import com.infogain.debonair.model.RegularCustomer;

/**
 * This repository class is used to handle all the administrative actions of the
 * customer
 * 
 * @author Chetna
 * @since 04-May-2020
 */
@Repository
public class RegularAndCorporateCustomer {
	List<Customer> customers = new ArrayList<>();

	RegularAndCorporateCustomer() {
		/* customer id 0-4 is for regular customers */
		for (int i = 0; i < 5; i++) {
			customers.add(i,
					new RegularCustomer(i, "Chetna", "31-01-1994", "9876543" + i, "REGULAR", "Rajat Vihar", 10));
		}
		/* customer id 5-9 is for corporate customers */
		for (int i = 5; i < 10; i++) {
			customers.add(i, new CorporateCustomer(i, "Prafull", "01-07-1994", "8734231" + i, "CORPORATE",
					"Mansarovar Apartments", i, 5.0f));
		}
	}

	/**
	 * This method is used get customer type depending on the order Id provided in
	 * the parameter
	 * 
	 * @param customerId Customer Id
	 * @return Type of customer i.e., 'CORPORATE' or 'REGULAR'
	 * @since 04-May-2020
	 */
	public String getCustomerType(String customerId) {
		Integer customId = Integer.parseInt(customerId);
		Iterator<Customer> customerIterator = customers.iterator();
		while (customerIterator.hasNext()) {
			Customer customer = customerIterator.next();
			if (customId != null && customId.equals(customer.getCustomerID())) {
				if (Constants.CORPORATE.equalsIgnoreCase(customer.getCustomerType())) {
					return Constants.CORPORATE;
				} else if (Constants.REGULAR.equalsIgnoreCase(customer.getCustomerType())) {
					return Constants.REGULAR;
				}
			}
		}
		return "ERROR";
	}

}
