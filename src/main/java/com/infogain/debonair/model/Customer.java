package com.infogain.debonair.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Customer Class which is the parent class of Regular and Corporate Customer
 * 
 * @author Chetna
 * @since 21-Apr-2020
 */
public class Customer implements Serializable {

	private static final long serialVersionUID = 17L;
	private int customerID;
	private String customerName;
	private String customerDob;
	private String customerMobile;
	private String customerType;
	private String customerAddress;

	/**
	 * @param customerID      - Customer's ID
	 * @param customerName    - Customer's Name
	 * @param customerDob     - Customer's Date Of Birth
	 * @param customerMobile  - Customer's Mobile Number
	 * @param customerType    - Customer's Type
	 * @param customerAddress - Customer's Address
	 */
	public Customer(int customerID, String customerName, String customerDob, String customerMobile, String customerType,
			String customerAddress) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerDob = customerDob;
		this.customerMobile = customerMobile;
		this.customerType = customerType;
		this.customerAddress = customerAddress;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(String customerDob) {
		this.customerDob = customerDob;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 * Overridden hashCode() method of Customer class
	 * 
	 * @return - hashCode generated of the object
	 * @since 21-Apr-2020
	 */
	@Override
	public int hashCode() {
		return Objects.hash(customerAddress, customerDob, customerID, customerMobile, customerName, customerType);
	}

	/**
	 * Overridden equals() method of Customer class
	 * 
	 * @param obj - object which needs to be compared with the current object
	 * @return - {@code true} if the arguments are equal to each other and
	 *         {@code false} otherwise
	 * @since 21-Apr-2020
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
		return Objects.equals(customerAddress, other.customerAddress) && Objects.equals(customerDob, other.customerDob)
				&& customerID == other.customerID && Objects.equals(customerMobile, other.customerMobile)
				&& Objects.equals(customerName, other.customerName) && Objects.equals(customerType, other.customerType);
	}

	/**
	 * Overridden toString() method of Customer class
	 * 
	 * @return Stringified form of the object in human readable form
	 * @since 21-Apr-2020
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Customer ID: ").append(customerID).append(", Customer Name: ").append(customerName)
				.append(", Customer Dob: ").append(customerDob).append(", Customer Mobile: ").append(customerMobile)
				.append(", Customer Type: ").append(customerType).append(", Customer Address: ")
				.append(customerAddress);
		return builder.toString();
	}

}
