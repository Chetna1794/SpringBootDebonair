package com.infogain.debonair.model;

import java.util.Objects;

import com.infogain.debonair.model.Customer;

/**
 * Corporate Customer class which is used to create Corporate type Customer
 * objects
 * 
 * @author Chetna
 * @since 21-Apr-2020
 */
public class CorporateCustomer extends Customer {

	private static final long serialVersionUID = 2L;
	private int registrationNumber;
	private float discountPercent;

	/**
	 * @param customerID         - Customer's ID
	 * @param customerName       - Customer's Name
	 * @param customerDob        - Customer's Date Of Birth
	 * @param customerMobile     - Customer's Mobile Number
	 * @param customerType       - Customer's Type
	 * @param customerAddress    - Customer's Address
	 * @param registrationNumber Customer's Registration Number
	 * @param discountPercent    - Discount Percent offered to the customer
	 */
	public CorporateCustomer(int customerID, String customerName, String customerDob, String customerMobile,
			String customerType, String customerAddress, int registrationNumber, float discountPercent) {
		super(customerID, customerName, customerDob, customerMobile, customerType, customerAddress);
		this.registrationNumber = registrationNumber;
		this.discountPercent = discountPercent;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * Overridden hashCode method in CorporateCustomer.java
	 * 
	 * @return generated hashcode of the object
	 * @since 21-Apr-2020
	 */
	@Override
	public int hashCode() {
		return Objects.hash(discountPercent, registrationNumber);
	}

	/**
	 * Overridden equals method in CorporateCustomer.java
	 * 
	 * @param obj - Object which will be compared with the current object
	 * @return
	 * @since 21-Apr-2020
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CorporateCustomer)) {
			return false;
		}
		CorporateCustomer other = (CorporateCustomer) obj;
		return Float.floatToIntBits(discountPercent) == Float.floatToIntBits(other.discountPercent)
				&& registrationNumber == other.registrationNumber;
	}

	/**
	 * Overridden toString method in CorporateCustomer.java
	 * 
	 * @return Stringified object of CorporateCustomer class
	 * @since 21-Apr-2020
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CorporateCustomer [").append(super.toString()).append(", Registration Number: ")
				.append(registrationNumber).append(", Discount Percent: ").append(discountPercent).append("]");
		return builder.toString();
	}

}
