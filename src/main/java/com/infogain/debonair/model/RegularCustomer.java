package com.infogain.debonair.model;

import com.infogain.debonair.model.Customer;

/**
 * Regular Customer class which is used to create Regular type Customer objects
 * 
 * @author Chetna
 * @since 21-Apr-2020
 */
public class RegularCustomer extends Customer {

	private static final long serialVersionUID = 1L;
	private int customerPoints;

	/**
	 * @param customerID      - Customer's ID
	 * @param customerName    - Customer's Name
	 * @param customerDob     - Customer's Date Of Birth
	 * @param customerMobile  - Customer's Mobile Number
	 * @param customerType    - Customer's Type
	 * @param customerAddress - Customer's Address
	 * @param customerPoints  - Customer's loyalty points
	 */
	public RegularCustomer(int customerID, String customerName, String customerDob, String customerMobile,
			String customerType, String customerAddress, int customerPoints) {
		super(customerID, customerName, customerDob, customerMobile, customerType, customerAddress);
		this.setCustomerPoints(customerPoints);
	}

	public int getCustomerPoints() {
		return customerPoints;
	}

	public void setCustomerPoints(int customerPoints) {
		this.customerPoints = customerPoints;
	}

	/**
	 * Overridden hashCode() method of RegularCustomer class
	 * 
	 * @return generated hashCode of the object
	 * @since 21-Apr-2020
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerPoints;
		return result;
	}

	/**
	 * Overridden equals method of RegularCustomer class
	 * 
	 * @param obj
	 * @return
	 * @since 21-Apr-2020
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegularCustomer other = (RegularCustomer) obj;
		if (customerPoints != other.customerPoints)
			return false;
		return true;
	}

	/**
	 * Overridden toString method in RegularCustomer.java
	 * 
	 * @return Stringified object of RegularCustomer class
	 * @since 21-Apr-2020
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegularCustomer [").append(super.toString()).append(", Customer Points: ")
				.append(customerPoints).append("]");
		return builder.toString();
	}
}
